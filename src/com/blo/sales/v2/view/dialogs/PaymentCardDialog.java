package com.blo.sales.v2.view.dialogs;

import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.AbstractDialogBase;
import com.blo.sales.v2.view.commons.GUICommons;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public final class PaymentCardDialog<T> extends AbstractDialogBase {
    
    /** llaves de mapa */
    public static final String CARD_PAY = "CARD_PAY";
    public static final String REFERENCE = "REFERENCE";
    public static final String CASH = "CASH";
    public static final String TYPE = "TYPE";

    private final Consumer<T> callback;
    
    private final BigDecimal pay;
    
    public PaymentCardDialog(Component parent, String title, BigDecimal pay, Consumer<T> callback) {
        super(SwingUtilities.getWindowAncestor(parent), title, ModalityType.APPLICATION_MODAL);
        initComponents();
        this.callback = callback;
        this.pay = pay;
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTotalToPay = new javax.swing.JLabel();
        lblPaymentByCard = new javax.swing.JLabel();
        nmbPaymentCard = new javax.swing.JTextField();
        chcbkxComplete = new javax.swing.JCheckBox();
        lblCash = new javax.swing.JLabel();
        nmbCash = new javax.swing.JTextField();
        lblReference = new javax.swing.JLabel();
        txtReference = new javax.swing.JTextField();
        btnDoPay = new javax.swing.JButton();
        lblRest = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTotalToPay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTotalToPay.setText("total_");

        lblPaymentByCard.setText("pago_por_tarjeta");

        chcbkxComplete.setText("completo");
        chcbkxComplete.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chcbkxCompleteStateChanged(evt);
            }
        });

        lblCash.setText("pago_efectivo");

        lblReference.setText("referencia");

        btnDoPay.setText("pagar");
        btnDoPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoPayActionPerformed(evt);
            }
        });

        lblRest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nmbPaymentCard, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPaymentByCard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(chcbkxComplete))
                        .addComponent(lblReference)
                        .addComponent(txtReference))
                    .addComponent(lblTotalToPay, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDoPay)
                    .addComponent(lblCash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nmbCash)
                    .addComponent(lblRest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTotalToPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaymentByCard)
                    .addComponent(lblCash))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nmbCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nmbPaymentCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chcbkxComplete)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblReference)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDoPay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoPayActionPerformed
        final var checkboxStatus = chcbkxComplete.isSelected();
        try {
            final var cardPay = GUICommons.getNumberFromJText(nmbPaymentCard, 2);
            final var reference = GUICommons.getTextFromField(txtReference, true);
            /** todo el pago con tarjeta + comision*/
            final Map<String, Object> paymentData = new HashMap<>();
            paymentData.put(CARD_PAY, cardPay);
            paymentData.put(REFERENCE, reference);
            //var paymentData = String.format("cardPay=%s&reference=%s", cardPay, reference);
            var cash = BigDecimal.ZERO;
            var type = 1;
            if (!checkboxStatus) {
                cash = GUICommons.getNumberFromJText(nmbCash, 2);
                type = 2;
            }
               // final var cashPay = String.format("&cash=%s&type=BOTH", cash);
                //paymentData = paymentData.concat(cashPay);
            paymentData.put(CASH, cash);
            paymentData.put(TYPE, type);
            callback.accept((T) paymentData);
        } catch (BloSalesV2Exception ex) {
            Logger.getLogger(PaymentCardDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDoPayActionPerformed

    private void chcbkxCompleteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chcbkxCompleteStateChanged
        nmbCash.setEnabled(true);
    }//GEN-LAST:event_chcbkxCompleteStateChanged

    @Override
    public void loadTargets() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void init() {
        GUICommons.setTextToField(lblTotalToPay, pay);
        chcbkxComplete.setSelected(true);
        nmbCash.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoPay;
    private javax.swing.JCheckBox chcbkxComplete;
    private javax.swing.JLabel lblCash;
    private javax.swing.JLabel lblPaymentByCard;
    private javax.swing.JLabel lblReference;
    private javax.swing.JLabel lblRest;
    private javax.swing.JLabel lblTotalToPay;
    private javax.swing.JTextField nmbCash;
    private javax.swing.JTextField nmbPaymentCard;
    private javax.swing.JTextField txtReference;
    // End of variables declaration//GEN-END:variables
}
