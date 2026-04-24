package com.blo.sales.v2.view.dialogs;

import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDialogBase;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.pojos.PojoDebtSettlement;
import com.google.gson.Gson;
import java.awt.Component;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SwingUtilities;

public class DebtorSettlementDetailDialog extends AbstractDialogBase {
    
    private final PojoDebtSettlement settlementData;

    public DebtorSettlementDetailDialog(
        Component parent,
        String title,
        PojoDebtSettlement settlementData
    ) {
        super(SwingUtilities.getWindowAncestor(parent), title, ModalityType.APPLICATION_MODAL, false);
        this.settlementData = settlementData;
        initComponents();
        dialogSizeHandler();
        loadDataOnLists();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPayments = new javax.swing.JLabel();
        lblProducts = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPayments = new javax.swing.JList<>();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblPayments.setText("pagos");

        lblProducts.setText("productos");

        jScrollPane1.setViewportView(lstProducts);

        jScrollPane2.setViewportView(lstPayments);

        btnClose.setText("cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProducts)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblPayments))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducts)
                    .addComponent(lblPayments))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    @Override
    public void loadTargets() {
        GUICommons.setTextToButton(btnClose, getTranslateBy(KeysEnum.COMMON_BTN_CLOSE.getKey()));
        GUICommons.setTextToField(lblProducts, getTranslateBy(KeysEnum.SETTLEMENTS_DLG_PRODUCTS.getKey()));
        GUICommons.setTextToField(lblPayments, getTranslateBy(KeysEnum.SETTLEMENTS_DLG_PAYMENTS.getKey()));
    }
    
    private void loadDataOnLists() {
        final var gson = new Gson();
        final var paymentsDetails = settlementData.getPayments().split(BloSalesV2Utils.SEPARATOR_PAYMENTS);
        loadData(lstPayments, paymentsDetails);
        final var productsDetails = gson.fromJson(settlementData.getProductsDetails(), String[].class);
        loadData(lstProducts, productsDetails);
    }
    
    private void loadData(JList<String> lst, String[] items) {
        final var model = new DefaultListModel<String>();
        for (final var item: items) {
            if (item.contains(BloSalesV2Utils.TIMESTAMP)) {
                model.addElement(item.replace(BloSalesV2Utils.TIMESTAMP, " - "));
                continue;
            }
            model.addElement(item);
        }
        lst.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPayments;
    private javax.swing.JLabel lblProducts;
    private javax.swing.JList<String> lstPayments;
    private javax.swing.JList<String> lstProducts;
    // End of variables declaration//GEN-END:variables
}
