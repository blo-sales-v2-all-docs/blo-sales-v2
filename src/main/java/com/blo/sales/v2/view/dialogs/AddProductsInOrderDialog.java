package com.blo.sales.v2.view.dialogs;

import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDialogBase;
import com.blo.sales.v2.view.commons.GUICommons;
import com.google.gson.Gson;
import java.awt.Component;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public final class AddProductsInOrderDialog<T> extends AbstractDialogBase {
    
    private final String title;
    
    private final Consumer<T> callback;
    
    private final DefaultListModel<String> modeloLista;
    
    private final Gson gson;
    
    private int itemCounter;
    
    public AddProductsInOrderDialog(
        Component parent,
        String title,
        Consumer<T> callback
    ) {
        super(SwingUtilities.getWindowAncestor(parent), title, ModalityType.APPLICATION_MODAL, true);
        this.title = title;
        this.callback = callback;
        this.gson = new Gson();
        this.modeloLista = new DefaultListModel<>();
        this.itemCounter = 0;
        initComponents();
        dialogSizeHandler();
        loadTargets();
        addEvent();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtProductInfo = new javax.swing.JTextField();
        lblInstructions = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProductsInfo = new javax.swing.JList<>();
        btnSave = new javax.swing.JButton();
        lblFormat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtProductInfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductInfoKeyReleased(evt);
            }
        });

        lblInstructions.setText("porfavor_escribe_la_cantidad_de_producto_comprada_utilizando_el_formato");

        jScrollPane1.setViewportView(lstProductsInfo);

        btnSave.setText("continuar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblFormat.setText("num_de_producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductInfo)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addComponent(lblInstructions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFormat)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFormat)
                .addGap(18, 18, 18)
                .addComponent(txtProductInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        var productsInfo = BloSalesV2Utils.JSON_EMPTY_ARRAY;
        if (lstProductsInfo.getModel().getSize() > 0) {
            final var descriptions = new ArrayList<String>();
            for (var i = 0; i < lstProductsInfo.getModel().getSize(); i++) {
                descriptions.add(
                    BloSalesV2Utils.getMatcherByIndexGroup(
                            BloSalesV2Utils.ID_FROM_INDEX_LST,
                            lstProductsInfo.getModel().getElementAt(i),
                            1
                    )
                );
            }
            productsInfo = gson.toJson(descriptions);
        }
        callback.accept((T) productsInfo);
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtProductInfoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductInfoKeyReleased
        try {
            if (evt.getKeyCode() == GUICommons.ENTER_KEY) {
                final var productInfo = GUICommons.getTextFromField(txtProductInfo, true);
                modeloLista.addElement(String.format("%s. %s", itemCounter, productInfo));
                lstProductsInfo.setModel(modeloLista);
                GUICommons.setTextToField(txtProductInfo, BloSalesV2Utils.EMPTY_STRING);
                itemCounter++;
            }
        } catch (BloSalesV2Exception ex) {
            Logger.getLogger(AddProductsInOrderDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtProductInfoKeyReleased

    @Override
    public void loadTargets() {
        
    }

    private void addEvent() {
        GUICommons.addDoubleClickOnListEvt(lstProductsInfo, item -> {
            modeloLista.remove(modeloLista.indexOf(item));
            lstProductsInfo.setModel(modeloLista);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFormat;
    private javax.swing.JLabel lblInstructions;
    private javax.swing.JList<String> lstProductsInfo;
    private javax.swing.JTextField txtProductInfo;
    // End of variables declaration//GEN-END:variables
}
