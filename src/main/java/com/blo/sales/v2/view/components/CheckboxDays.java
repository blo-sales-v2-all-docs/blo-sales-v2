package com.blo.sales.v2.view.components;

import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.google.gson.Gson;
import jakarta.inject.Singleton;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import lombok.Setter;

/**
 *
 * @author orlndo
 */
@Singleton
public class CheckboxDays {
    
    private static final String MONTHLY = "MONTHLY";
    
    private static final String WEEKLY = "WEEKLY";
    
    private static final String EVERY_TWO_WEEKS = "EVERY_TWO_WEEKS";
    
    private static final String EVERY_THREE_WEEKS = "EVERY_THREE_WEEKS";
    
    private static final String[] week = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
    
    @Setter
    private JPanel container;
    
    /**
     * Crea un componente selector para los dias de la semana
     */
    public void createCheckboxDaysList() {
        // 1. Configuración del Layout: 2 filas, 1 columna
        container.setLayout(new java.awt.GridLayout(2, 1, 5, 5)); 
        container.removeAll();

        // 2. Sub-paneles para organizar las filas
        final var filaRadio = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        final var filaChecks = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        // Hacer los sub-paneles transparentes para que hereden el color del padre (el cuadro negro)
        filaRadio.setOpaque(false);
        filaChecks.setOpaque(false);

        // 3. Crear los Radio Buttons
        final var rbSemanal = new JRadioButton("Semanal", true);
        final var rb2Semanas = new JRadioButton("Quincenal");
        final var rb3Semanas = new JRadioButton("Cada 3 semanas");
        final var rbMensual = new JRadioButton("Mensual");

        final var group = new ButtonGroup();
        group.add(rbSemanal);
        group.add(rb2Semanas);
        group.add(rb3Semanas);
        group.add(rbMensual);

        filaRadio.add(rbSemanal);
        filaRadio.add(rb2Semanas);
        filaRadio.add(rb3Semanas);
        filaRadio.add(rbMensual);

        // 4. Crear los Checkboxes
        final var checkBoxes = new ArrayList<JCheckBox>();
        for(final var day : week) {
            final var chk = new JCheckBox(day);
            chk.setOpaque(false);
            chk.setName(day);
            checkBoxes.add(chk);
            filaChecks.add(chk);
        }

        // 5. Lógica de activación/desactivación
        rbMensual.addActionListener(e -> {
            for (final var chk : checkBoxes) {
                chk.setSelected(false);
                chk.setEnabled(false);
            }            
        });

        rbSemanal.addActionListener(e -> enabledCheckbox(checkBoxes));
        rb2Semanas.addActionListener(e -> enabledCheckbox(checkBoxes));
        rb3Semanas.addActionListener(e -> enabledCheckbox(checkBoxes));

        // 6. Agregar las filas al contenedor principal
        container.add(filaRadio);
        container.add(filaChecks);

        // 7. Refrescar
        container.revalidate();
        container.repaint();
    }
    
    public void createWeekCheckboxSelected(String[] daysSelected, String visits) {
        final var daysAsList = Arrays.asList(daysSelected);
        createCheckboxDaysList();
        if (container.getComponents().length == 0) {
            return;
        }
        final var rowRadio = (JPanel) container.getComponent(0);
        final var filaChecks = (JPanel) container.getComponent(1);
        // visita por mes
        if (daysSelected.length == 0) {
            final var radioMensual = (JRadioButton)rowRadio.getComponent(1);
            radioMensual.setSelected(true);
            for (final var item: filaChecks.getComponents()) {
                final var check = (JCheckBox) item;
                check.setEnabled(false);
            }
            
        } else {
            var visitSelected = 0;
            switch (visits) {
                case WEEKLY:
                    visitSelected = 0;
                    break;
                case EVERY_TWO_WEEKS:
                    visitSelected = 1;
                    break;
                case EVERY_THREE_WEEKS:
                    visitSelected = 2;
                    break;
                default:
                    visitSelected = 0;
                    break;
            }
            final var radio = (JRadioButton) rowRadio.getComponent(visitSelected);
            radio.setSelected(true);
            
            for (final var item: filaChecks.getComponents()) {
                final var check = (JCheckBox) item;
                check.setEnabled(true);
                final var dayCheckbox = check.getName();
                final var dayFound = daysAsList.stream().filter(d -> d.equals(dayCheckbox)).findFirst().orElse(BloSalesV2Utils.EMPTY_STRING);
                check.setSelected(!dayFound.isBlank());
            }
        }
    }
    
    /**
     * Recupea la informacion seleccionada
     * @return wrapper con informacion seleccionada
     */
    public WeekInfoSelected getInfoSelected() {
        // recupera informacion de radio button
        final var info = new WeekInfoSelected();
        final var perMonthRow = (JPanel) container.getComponent(0);
        final var radioByWeek = (JRadioButton) perMonthRow.getComponents()[0]; //semanal
        final var perWeek = radioByWeek.isSelected();
        // recuperar los días que visitara
        final var weeklyBy2 = (JRadioButton) perMonthRow.getComponents()[1]; //quincenal
        final var weeklyBy3 = (JRadioButton) perMonthRow.getComponents()[2]; //trisemanal
        // se agrega negacion porque lo seleccionado es por semana y espera por mes
        info.setPerWeek(perWeek);
        info.setDaysSelected(BloSalesV2Utils.JSON_EMPTY_ARRAY);
        var visits = MONTHLY;
        final var gson = new Gson();
        if (perWeek || weeklyBy2.isSelected() || weeklyBy3.isSelected()) {
            final var lstDays = new ArrayList<String>();
            final var panelWeek = (JPanel) container.getComponent(1);
            for (final var day: panelWeek.getComponents()) {
                if (day instanceof JCheckBox &&  ((JCheckBox) day).isSelected()) {
                    lstDays.add(day.getName());
                }
            }
            info.setDaysSelected(gson.toJson(lstDays));
            if (perWeek) {
                visits = WEEKLY;
            }
            if (weeklyBy2.isSelected()) {
                visits = EVERY_TWO_WEEKS;
            }
            if (weeklyBy3.isSelected()) {
                visits = EVERY_THREE_WEEKS;
            }
        } else {
            try {
                final String dayMonth = CommonAlerts.showMessageDialog("Por favor indica qué día del mes te visitarán");
                BloSalesV2Utils.validateRule(
                    !BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.ONLY_NUMBERS, dayMonth) || Integer.parseInt(dayMonth) > 31,
                    BloSalesV2Utils.COMMON_RULE_CODE,
                    BloSalesV2Utils.INVALID_TEXT);
                info.setDaysSelected(gson.toJson(new String[]{dayMonth}));
            } catch (BloSalesV2Exception ex) {
                CommonAlerts.openError(ex.getMessage(), BloSalesV2Utils.COMMON_RULE);
                return null;
            }
            
        }
        info.setVisits(visits);
        return info;
    }
    
    /**
     * Permite recuperar los dias seleccionados restando un día .cuando está activada la bandera de recordatorio.<br>
 Cuando es un domingo el día de recordatorio derá sábado
    <br>
 Regresa los días en formato JSON
     * @param reminder
     * @param infoSelected
     * @return 
     */
    public String getSelectedDaysToReminder(boolean reminder, WeekInfoSelected infoSelected) {
        final var gson = new Gson();
        if (!reminder) {
            return gson.toJson(BloSalesV2Utils.JSON_EMPTY_ARRAY);
        }
        // si es un día del calendario entonces regresa el día seleccionado
        if (BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.ONLY_NUMBERS, infoSelected.getDaysSelected())) {
            return infoSelected.getDaysSelected();
        }
        final List<String> lstDays = new ArrayList<>();
        final var panelWeek = (JPanel) container.getComponent(1);
        for (int i = 0; i < panelWeek.getComponents().length; i++) {
            final Component day = panelWeek.getComponent(i);
            if (day instanceof JCheckBox &&  ((JCheckBox) day).isSelected()) {
                int previusDayIndex = 0;
                if (i == 0) {
                    previusDayIndex = week.length - 1;
                }
                if (i > 0) {
                    previusDayIndex = i - 1;
                }
                lstDays.add(panelWeek.getComponent(previusDayIndex).getName());
            }
        }
        return gson.toJson(lstDays);
    }
    
    public static String[] getDaysArray() {
        return week;
    }
    
    /**
     * permite activar los checkboxes
     * @param checks 
     */
    private void enabledCheckbox(ArrayList<JCheckBox> checks) {
        for (final var chk: checks) {
            chk.setEnabled(true);
        }
    }
}
