package com.blo.sales.v2.view.dialogs;

import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDialogBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.pojos.PojoAccount;
import com.blo.sales.v2.view.pojos.PojoActiveCost;
import com.blo.sales.v2.view.pojos.PojoCashbox;
import com.blo.sales.v2.view.pojos.PojoDialogCashboxData;
import com.blo.sales.v2.view.pojos.WrapperPojoNotes;
import com.blo.sales.v2.view.pojos.enums.ActivesCostsEnum;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public final class CashboxDialog<T> extends AbstractDialogBase {
    
    private List<PojoActiveCost> lstCosts;
        
    private DefaultListModel modelActives;
    
    private BigDecimal totalActives;
    
    private DefaultListModel modelPasives;
    
    private BigDecimal totalPasives;
    
    private BigDecimal totalActivesCosts;
    
    private Consumer<T> callback;
    
    private PojoDialogCashboxData dataNewCashbox;
    
    private WrapperPojoNotes actives;
    
    private WrapperPojoNotes pasives;
    
    private PojoCashbox cashboxData;
    
    private final PojoAccount account;

    public CashboxDialog(
        Component parent,
        String title,
        PojoCashbox cashboxData,
        WrapperPojoNotes actives,
        WrapperPojoNotes pasives,
        PojoAccount account,
        Consumer<T> callback
    ) {
        super(SwingUtilities.getWindowAncestor(parent), title, ModalityType.APPLICATION_MODAL, false);
        initComponents();
        dialogSizeHandler();
        loadTargets();
        this.callback = callback;
        this.actives = actives;
        this.pasives = pasives;
        this.cashboxData = cashboxData;
        this.account = account;
        lstCosts = new ArrayList<>();
        loadActivesCosts();
        modelActives = new DefaultListModel();
        modelPasives = new DefaultListModel();
        dataNewCashbox = new PojoDialogCashboxData();
        totalActives = BigDecimal.ZERO;
        totalPasives = BigDecimal.ZERO;
        totalActivesCosts = BigDecimal.ZERO;
        GUICommons.setTextToField(lblTotalToCashbox, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_NETO_TOTAL.getKey()), cashboxData.getAmount()));
        setInfoFromNotes();
        // lista de activos
        GUICommons.addDoubleClickOnListEvt(lstActives, item -> removeActive(item));
        // lista de pasivos
        GUICommons.addDoubleClickOnListEvt(lstPasives, item -> removePasive(item));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCategoryName = new javax.swing.JTextField();
        cmbxType = new javax.swing.JComboBox<>();
        lblamountOnCashbox = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        btnContinue = new javax.swing.JButton();
        nmbAmount = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstActives = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPasives = new javax.swing.JList<>();
        lblActivesTotal = new javax.swing.JLabel();
        lblPasivesTotal = new javax.swing.JLabel();
        lblTotalToCashbox = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblamountOnCashbox.setText("monto total de ventas");

        lblAmount.setText("monto");

        lblDescription.setText("descripcion");

        btnContinue.setText("continuar");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstActives);

        jScrollPane2.setViewportView(lstPasives);

        lblActivesTotal.setText("total activos");

        lblPasivesTotal.setText("total pasivos");

        lblTotalToCashbox.setText("total neto");

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblActivesTotal)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPasivesTotal)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTotalToCashbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblActivesTotal)
                    .addComponent(lblPasivesTotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalToCashbox)
                    .addComponent(btnSave)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblamountOnCashbox, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCategoryName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAmount)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nmbAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbxType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnContinue))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescription)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblamountOnCashbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription)
                    .addComponent(lblAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nmbAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(btnContinue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        dataNewCashbox.setItems(lstCosts);
        this.callback.accept((T) dataNewCashbox);
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        try {
            final var concept = GUICommons.getTextFromField(txtCategoryName, true);
            final var amount = GUICommons.getNumberFromJText(nmbAmount, GUICommons.DIGITS_OF_CURRENCY);
            final var indexSelected = cmbxType.getSelectedIndex();
            final var typeConcept = ActivesCostsEnum.getByIndex(indexSelected);
            final var data = createItem(amount, concept, typeConcept);
            lstCosts.add(data);
            if (indexSelected == ActivesCostsEnum.ACTIVO.getIndex()) {
                addActive(data, amount);
            }
            if (indexSelected == ActivesCostsEnum.PASIVO.getIndex()) {
                addCost(data, amount);
            }
            dataNewCashbox.setTotalActives(totalActives);
            dataNewCashbox.setTotalPasives(totalPasives);
            dataNewCashbox.setTotalAmountInCashbox(totalActivesCosts);
            
            //GUICommons.setTextToField(lblTotalToCashbox, "Total neto: " + totalActivesCosts);
            GUICommons.setTextToField(lblTotalToCashbox, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_NETO_TOTAL.getKey()), totalActivesCosts));
            GUICommons.setTextToField(txtCategoryName, BloSalesV2Utils.EMPTY_STRING);
            GUICommons.setTextToField(nmbAmount, BloSalesV2Utils.EMPTY_STRING);
        } catch (BloSalesV2Exception ex) {
        }
    }//GEN-LAST:event_btnContinueActionPerformed

    // carga los datos de una nota en los campos de texto
    private void setInfoFromNotes() {
        final var salesToDay = createItem(cashboxData.getAmount(), getTranslateBy(KeysEnum.DLG_CASHBOX_TRG_SALES_TODAY.getKey()), ActivesCostsEnum.ACTIVO);
        lstCosts.add(salesToDay);
        addActive(salesToDay, salesToDay.getAmount());
        // agregr como activo la cuenta digital
        if (account != null) {
            final var digitalWallet = createItem(account.getControlAmount(), account.getAccount(), ActivesCostsEnum.ACTIVO);
            addActive(digitalWallet, account.getControlAmount());
        }
        if (actives != null) {
            // hay activos
            for (final var note: actives.getNotes()) {
                final var item = createItem(getAmount(note.getNote()), note.getNote(), ActivesCostsEnum.ACTIVO);
                lstCosts.add(item);
                addActive(item, getAmount(note.getNote()));
            }
        }
        if (pasives != null) {
            // hay pasivos
            for (final var note: pasives.getNotes()) {
                final var item = createItem(getAmount(note.getNote()), note.getNote(), ActivesCostsEnum.PASIVO);
                lstCosts.add(item);
                addCost(item, getAmount(note.getNote()));
            }
        }
        dataNewCashbox.setTotalActives(totalActives);
        dataNewCashbox.setTotalPasives(totalPasives);
        dataNewCashbox.setTotalAmountInCashbox(totalActivesCosts);
        //GUICommons.setTextToField(lblTotalToCashbox, "Total neto: " + totalActivesCosts);
        GUICommons.setTextToField(lblTotalToCashbox, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_NETO_TOTAL.getKey()), totalActivesCosts));
    }
    
    /**
     * agrega un item a activos
     * @param data
     * @param amount 
     */
    private void addActive(PojoActiveCost data, BigDecimal amount) {
        modelActives.addElement(data.toString());
        lstActives.setModel(modelActives);
        totalActives = totalActives.add(amount);
        GUICommons.setTextToField(lblActivesTotal, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_TOTAL_ACTIVES.getKey()), totalActives));
        totalActivesCosts = totalActivesCosts.add(amount);
    }
    
    /**
     * Agrega un item a costos
     * @param data
     * @param amount 
     */
    private void addCost(PojoActiveCost data, BigDecimal amount) {
        modelPasives.addElement(data.toString());
        lstPasives.setModel(modelPasives);
        totalPasives = totalPasives.add(amount);
        GUICommons.setTextToField(lblPasivesTotal, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_TOTAL_COSTS.getKey()), totalPasives));
        totalActivesCosts = totalActivesCosts.subtract(amount);
    }
    
    /**
     * Recupera la cantidad de una nota siempre y cuando esté entre $
     * @param data
     * @return 
     */
    private BigDecimal getAmount(String data) {
        final var currency = data.substring(data.lastIndexOf("$") + 1);
        if (currency.length() == 0) {
            return BigDecimal.ZERO;
        }
        final var lastIndex = currency.lastIndexOf(" ") == -1 ? currency.length() : currency.lastIndexOf(" ");
        return new BigDecimal(currency.substring(0, lastIndex));
    }
    
    /**
     * Genera un item para la lista
     * @param amount
     * @param concept
     * @param type
     * @return 
     */
    private PojoActiveCost createItem(BigDecimal amount, String concept, ActivesCostsEnum type) {
        final var out = new PojoActiveCost();
        // elimina el monto del concepto
        if (concept.contains("$")) {
            final var lastIndexOf = concept.lastIndexOf("$");
            concept = concept.substring(0, lastIndexOf).trim();
        }
        out.setAmount(amount);
        out.setComplete(false);
        out.setConcept(concept);
        out.setType(type);
        return out;
    }
    
    private void removeActive(String item) {
        final var indexSelected = lstActives.getSelectedIndex();
        if (indexSelected != -1) {
            try {
                final var amount = getAmountFromItemList(item);
                // resta en la cuenta de activos
                totalActives = totalActives.subtract(amount);
                GUICommons.setTextToField(lblActivesTotal, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_TOTAL_ACTIVES.getKey()), totalActives));
                // se elimina del arreglo y de la lista
                lstCosts.removeIf(i -> i.toString().equals(item));
                modelActives.remove(indexSelected);
                // se resta al total de activos a neto
                totalActivesCosts = totalActivesCosts.subtract(amount);
                GUICommons.setTextToField(lblTotalToCashbox, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_NETO_TOTAL.getKey()), totalActivesCosts));
            } catch(BloSalesV2Exception ex) {
                CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
            }
        }
    }
    
    private void removePasive(String item) {
        final var indexSelected = lstPasives.getSelectedIndex();
        if (indexSelected != -1) {
            try {
                final var amount = getAmountFromItemList(item);
                // resta en la cuenta de activos
                totalPasives = totalPasives.subtract(amount);
                GUICommons.setTextToField(lblPasivesTotal, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_TOTAL_COSTS.getKey()), totalPasives));
                // se elimina del arreglo y de la lista
                lstCosts.removeIf(i -> i.toString().equals(item));
                modelPasives.remove(indexSelected);
                // se resta al total de activos a neto
                totalActivesCosts = totalActivesCosts.add(amount);
                GUICommons.setTextToField(lblTotalToCashbox, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_NETO_TOTAL.getKey()), totalActivesCosts));
            } catch (BloSalesV2Exception ex) {
                CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
            }
        }
    }
    
    private BigDecimal getAmountFromItemList(String item) throws BloSalesV2Exception {
        var props = item.split(",");
        if (props.length < PojoActiveCost.INDEX_AMOUNT) {
            throw new BloSalesV2Exception(BloSalesV2Utils.CODE_FORMAT_ACTIVE_COST, BloSalesV2Utils.ERROR_FORMAT_ACTIVE_COST);
        }
        final var amount = props[PojoActiveCost.INDEX_AMOUNT].split(PojoActiveCost.SEPARATOR)[1].trim();
        return new BigDecimal(amount);
    }
    
    private void loadActivesCosts() {
        final var typesModel = new DefaultComboBoxModel<String>();
        for (final var item : ActivesCostsEnum.getVisiblesTypes()) {
            typesModel.addElement(item.getTarget());
        }
        cmbxType.setModel(typesModel);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbxType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblActivesTotal;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblPasivesTotal;
    private javax.swing.JLabel lblTotalToCashbox;
    private javax.swing.JLabel lblamountOnCashbox;
    private javax.swing.JList<String> lstActives;
    private javax.swing.JList<String> lstPasives;
    private javax.swing.JTextField nmbAmount;
    private javax.swing.JTextField txtCategoryName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToField(lblamountOnCashbox, getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_TOTAL_AMOUNT.getKey()));
        GUICommons.setTextToField(lblDescription, getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_DESCRIPTION.getKey()));
        GUICommons.setTextToField(lblAmount, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_AMOUNT.getKey()), BigDecimal.ZERO));
        GUICommons.setTextToButton(btnContinue, getTranslateBy(KeysEnum.COMMON_BTN_CONTINUE.getKey()));
        GUICommons.setTextToField(lblActivesTotal, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_TOTAL_ACTIVES.getKey()), BigDecimal.ZERO));
        GUICommons.setTextToField(lblPasivesTotal, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_TOTAL_COSTS.getKey()), BigDecimal.ZERO));
        GUICommons.setTextToField(lblTotalToCashbox, String.format(getTranslateBy(KeysEnum.DLG_CASHBOX_LBL_NETO_TOTAL.getKey()), BigDecimal.ZERO));
        GUICommons.setTextToButton(btnSave, getTranslateBy(KeysEnum.COMMON_BTN_SAVE.getKey()));
    }
}
