package com.blo.sales.v2.view.commons;

import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import static com.blo.sales.v2.utils.BloSalesV2Utils.validateRule;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.function.Consumer;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public final class GUICommons {
    
    public static final int DIGITS_OF_CURRENCY = 2;
    
    public static final int DIGITS_OF_QUANTITY = 3;
    
    /** tecla eliminar */
    public static final int REMVOE_KEY_CODE = 8;
    
    /** tecla suprimir */
    public static final int SUPR_KEY = 127;
    
    /** tecla enter */
    public static final int ENTER_KEY = 10;
    
    public static final int F3_SEARCH_KEY = 114;
    
    public static final int ESCAPE_KEY = 27;
    
    private static final int WIDTH = 700;
    
    private static final int HEIGHT = 500;
    
    private static final Color PROFESSIONAL_BLUE = new Color(52, 152, 219);
    
    private static final Color CONTRAST_ORANGE = new Color(230, 126, 34);
    
    private static final Font FONT_SEGOE_UI_BOLD_14 = new Font("Segoe UI", Font.BOLD, 14);

    private GUICommons() {
    }
    
    public static void showPanel(AbstractFrameBase parent, JPanel container, AbstractDashboardBase content) {
        parent.setTitle(parent.getTranslateBy(content.getTitle()));
        openPanel(container, content);
    }
    
    /**
     * abre un nuevo panel, limpia el contenedor para librerar memoria
     *
     * @param content - contenedor donde se dibujara el siguiente panel
     * @param p - contenido
     */
    private static void openPanel(JPanel content, JPanel p) {
        p.setSize(1300, 600); // Ajusta al tamaño de tu contenedor
        p.setLocation(0, 0);
        content.removeAll(); // Limpia el panel principal
        content.add(p, BorderLayout.CENTER); // Agrega el nuevo formulario
        content.revalidate(); // Refresca el diseño
        content.repaint();    // Redibuja la interfaz
    }

    /**
     * Agrega un evento de doble clic a cualquier JList
     *
     * @param <T> El tipo de dato del JList
     * @param list El componente JList
     * @param action Lo que quieres hacer con el item seleccionado (callback)
     */
    public static <T> void addDoubleClickOnListEvt(JList<T> lst, Consumer<T> action) {
        lst.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int index = lst.locationToIndex(evt.getPoint());
                    if (index >= 0) {
                        T item = lst.getModel().getElementAt(index);
                        action.accept(item); // Ejecuta la lógica personalizada
                    }
                }
            }
        });
    }

    /**
     * Agrega un evento doble click a cada fila de una tabla
     * @param <T>
     * @param table
     * @param action 
     */
    public static <T> void addDoubleClickOnTable(JTable table, Consumer<T> action) {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    actionHandler(table, action);
                }
            }
        });

    }
    
    public static <T> void addKeyEventOnTable(JTable table, int keyCode, Consumer<T> action) {
        table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
         .put(KeyStroke.getKeyStroke(keyCode, 0), action);
        
        table.getActionMap().put(action, new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Aquí la fila seleccionada SIGUE siendo la correcta
            actionHandler(table, action);
        }
    });
    }
    
    public static void addChangeEventOnComboBox(JComboBox cmbx, Consumer<Integer> action) {
        cmbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.accept(cmbx.getSelectedIndex());
            }
        });
    }
    
    /**
     * Metodo para recuperar el texto de un campo
     * @param field
     * @param validate
     * @return
     * @throws BloSalesV2Exception 
     */
    public static String getTextFromField(JTextField field, boolean validate) throws BloSalesV2Exception {
        final var text = field.getText().trim();
        validateRule(validate && text.isBlank(), BloSalesV2Utils.COMMON_RULE_CODE, BloSalesV2Utils.INVALID_TEXT);
        return text;
    }
    
    public static String getTextFromField(JLabel field, boolean validate) throws BloSalesV2Exception {
        final var text = field.getText().trim();
        validateRule(validate && text.isBlank(), BloSalesV2Utils.COMMON_RULE_CODE, BloSalesV2Utils.INVALID_TEXT);
        return text;
    }
    
    /**
     * Metodo para recuperar el texto de un text area
     * @param field
     * @param validate
     * @return
     * @throws BloSalesV2Exception 
     */
    public static String getTextFromField(JTextArea field, boolean validate) throws BloSalesV2Exception {
        final var text = field.getText().trim();
        validateRule(validate && text.isBlank(), BloSalesV2Utils.COMMON_RULE_CODE, BloSalesV2Utils.INVALID_TEXT);
        return text;
    }

    /**
     * Recupera el numero de un textfield
     * @param field
     * @param decimals
     * @return
     * @throws BloSalesV2Exception 
     */
    public static BigDecimal getNumberFromJText(JTextField field, int decimals) throws BloSalesV2Exception {
        final var txt = field.getText().trim();
        validateRule(txt.isBlank(), BloSalesV2Utils.COMMON_RULE_CODE, BloSalesV2Utils.INVALID_TEXT);
        validateRule(decimals > 3, BloSalesV2Utils.COMMON_RULE_CODE, BloSalesV2Utils.ERROR_IN_DIGITS);
        
        var regex = BloSalesV2Utils.CURRENCY_REGEX;
        
        if (decimals == 3) {
            regex = regex.replace("2", "3");
        }

        validateRule(
                !BloSalesV2Utils.validateTextWithPattern(regex, txt),
                BloSalesV2Utils.COMMON_RULE_CODE,
                BloSalesV2Utils.ERROR_PATTERN);
        
        return new BigDecimal(txt);
    }
    
    /**
     * Envia texto a un label
     * @param field
     * @param txt 
     */
    public static void setTextToField(JLabel field, Object txt) {
        field.setText(String.valueOf(txt));
    }
    
    /**
     * Envia texto a un textField
     * @param field
     * @param txt 
     */
    public static void setTextToField(JTextField field, Object txt) {
        field.setText(String.valueOf(txt));
    }
    
    public static void setTextToField(JTextArea field, Object txt) {
        field.setText(String.valueOf(txt));
    }
    
    public static void setTextToField(JList field) {
        field.setListData(new String[0]);
    }
    
    public static void setTextToCheckbox(JCheckBox field, String txt) {
        field.setText(String.valueOf(txt));
    }

    /**
     * Recupera el valor de una password
     *
     * @param field
     * @return
     * @throws BloSalesV2Exception
     */
    public static String getPasswordFromJText(JPasswordField field) throws BloSalesV2Exception {
        final var passGet = field.getPassword();
        final var pass = new String(passGet);
        validateRule(pass.isBlank(), BloSalesV2Utils.COMMON_RULE_CODE, BloSalesV2Utils.INVALID_TEXT);
        return pass;
    }
    
    /**
     * recupera el valor seleccionado de un combobox
     *
     * @param comboBox
     * @return
     */
    public static String getValueFromComboBox(JComboBox comboBox) {
        return comboBox.getSelectedItem().toString();
    }

    /**
     * recupera el status de un checkbox
     *
     * @param checkbox
     * @return
     */
    public static boolean isCheckedCkeckBox(JCheckBox checkbox) {
        return checkbox.isSelected();
    }

    /**
     * carga los titulos a las columnas de una tabla
     *
     * @param table
     * @param titles
     */
    public static void loadTitleOnTable(JTable table, String[] titles, boolean isEditable) {
        var titleModel = new DefaultTableModel(titles, 0);
        if (!isEditable) {
            titleModel = new DefaultTableModel(titles, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        }
        table.setModel(titleModel);
    }

    /**
     * Inicializa el filtro de una tabla
     *
     * @param table
     * @param sorter
     */
    public static void filterTable(JTable table, TableRowSorter<DefaultTableModel> sorter) {
        final var model = (DefaultTableModel) table.getModel();
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
    }
    
    /**
     * Deshabilita un botón
     * @param btn 
     */
    public static void disabledButton(JButton btn) {
        btn.setEnabled(false);
    }
    
    public static void disabledComponent(JComboBox box) {
        box.setEnabled(false);
    }
    
    public static void enabledComponent(JComboBox box) {
        box.setEnabled(true);
    }
    
    /**
     * Habilita un boton
     * @param btn 
     */
    public static void enabledButton(JButton btn) {
        btn.setEnabled(true);
    }
    
    public static void setTextToButton(JButton btn, Object text) {
        btn.setText(String.valueOf(text));
    }
    
    /**
     * Envía dimensiones a un contenedor
     * @param content 
     */
    public static void setDimensions(JFrame content) {
        content.setSize(WIDTH, HEIGHT);
    }
    
    /**
     * Hace que un contenero se muestre en toda la pantalla
     * @param content 
     */
    public static void allWindow(JFrame content) {
        content.setExtendedState(JFrame.MAXIMIZED_BOTH);
        content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Método que se usa para validar que tecla fue presionada, 
     * si fue presionada delete o remove y se cumple una condicion regresa true
     * @param evt
     * @param conditionObligatory
     * @return 
     */
    public static boolean isEmptyFieldByKeyEvt(KeyEvent evt, boolean conditionObligatory) {
        return evt.getKeyCode() == GUICommons.REMVOE_KEY_CODE ||
                evt.getKeyCode() == GUICommons.SUPR_KEY &&
                conditionObligatory;
    }
    
    /**
     * Recupera una fecha en formato yyyy-MM-dd
     * @param chooser
     * @return 
     */
    public static String getDateFromDateChooser(JDateChooser chooser) {
        final var date = chooser.getDate();
        if (date == null) {
            return BloSalesV2Utils.EMPTY_STRING;
        }
        final var sdf = new SimpleDateFormat(BloSalesV2Utils.FORMAT_DATE);
        return sdf.format(date);
    }
    
    /**
     * Agrega un filtro en una columna
     * @param tbl
     * @param filter
     * @param regex
     * @param columnFilter 
     */
    public static void addFilter(JTable tbl, String filter, String regex, int columnFilter) {
        if (!filter.isBlank()) {
            final var model = (DefaultTableModel) tbl.getModel();
            final var sorter = new TableRowSorter<>(model);
            tbl.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter(regex + filter, columnFilter));
        } else {
            tbl.setRowSorter(null);
        }
    }
    
    /**
     * Agrega un filtro a toda la fila
     * @param tbl
     * @param regex
     * @param filter 
     */
    public static void addFilter(JTable tbl, String regex, String filter) {
        if (!filter.isBlank()) {
            final var model = (DefaultTableModel) tbl.getModel();
            final var sorter = new TableRowSorter<>(model);
            tbl.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.regexFilter(regex + filter));
        } else {
            tbl.setRowSorter(null);
        }
    }
    
    public static void hiddenPanel(JPanel pnl) {
        pnl.setVisible(false);
    }
    
    public static void showPanel(JPanel pnl) {
        pnl.setVisible(true);
    }
    
    public static void hiddenElement(JButton btn) {
        btn.setVisible(false);
    }
    
    public static void showElement(JButton btn) {
        btn.setVisible(true);
    }
    
    public static void disabledElement(JComboBox<String> cmbx) {
        cmbx.setEnabled(false);
    }
    
    public static void enabledElement(JComboBox<String> cmbx) {
        cmbx.setEnabled(true);
    }
    
    public static void convertMainButton(JButton button) {
        button.setBackground(PROFESSIONAL_BLUE); // Azul profesional
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(FONT_SEGOE_UI_BOLD_14);
    }
    
    public static void convertSecondaryButton(JButton button) {
        button.setBackground(CONTRAST_ORANGE); // Azul profesional
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(FONT_SEGOE_UI_BOLD_14);
    }
    
    /**
     * Gestor de eventos cuando se realiza la accion que se disparar por doble clic / key
     * @param <T>
     * @param table
     * @param action 
     */
    private static <T> void actionHandler(JTable table, Consumer<T> action) {
        final var fila = table.getSelectedRow();
        if (fila != -1) {
            // Convertir el índice por si la tabla está filtrada
            final var filaModelo = table.convertRowIndexToModel(fila);
            // Recuperar el ID (suponiendo que está en la columna 0)
            T id = (T) table.getModel().getValueAt(filaModelo, 0);
            action.accept(id);
        }
    }
}
