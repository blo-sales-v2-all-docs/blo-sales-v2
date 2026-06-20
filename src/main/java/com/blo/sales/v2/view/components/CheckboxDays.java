package com.blo.sales.v2.view.components;

import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.google.gson.Gson;
import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
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
        final var rbMensual = new JRadioButton("Mensual");

        final var group = new ButtonGroup();
        group.add(rbSemanal);
        group.add(rbMensual);

        filaRadio.add(rbSemanal);
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

        rbSemanal.addActionListener(e -> {
            for (final var chk : checkBoxes) {
                chk.setEnabled(true);
            }
        });

        // 6. Agregar las filas al contenedor principal
        container.add(filaRadio);
        container.add(filaChecks);

        // 7. Refrescar
        container.revalidate();
        container.repaint();
    }
    
    public void createWeekCheckboxSelected(String[] daysSelected) {
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
            final var radioWeek = (JRadioButton) rowRadio.getComponent(0);
            radioWeek.setSelected(true);
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
        final var radio = (JRadioButton) perMonthRow.getComponents()[0];
        final var perWeek = radio.isSelected();
        // se agrega negacion porque lo seleccionado es por semana y espera por mes
        info.setPerWeek(perWeek);
        info.setDaysSelected(BloSalesV2Utils.JSON_EMPTY_ARRAY);
        if (perWeek) {
            final var gson = new Gson();
            final var lstDays = new ArrayList<String>();
            final var panelWeek = (JPanel) container.getComponent(1);
            for (final var day: panelWeek.getComponents()) {
                if (day instanceof JCheckBox &&  ((JCheckBox) day).isSelected()) {
                    lstDays.add(day.getName());
                }
            }
            info.setDaysSelected(gson.toJson(lstDays));
        }
        return info;
    }
    
}
