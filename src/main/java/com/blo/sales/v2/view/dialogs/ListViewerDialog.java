package com.blo.sales.v2.view.dialogs;

import com.blo.sales.v2.view.commons.AbstractDialogBase;
import com.google.gson.Gson;
import java.awt.Component;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public final class ListViewerDialog extends AbstractDialogBase {
    
    private final String productsInfo;
    
    private final Gson gson;
    
    private final DefaultListModel<String> modeloLista;

    public ListViewerDialog(Component parent, String title, String productsInfo) {
        super(SwingUtilities.getWindowAncestor(parent), title, ModalityType.APPLICATION_MODAL, false);
        this.productsInfo = productsInfo;
        gson = new Gson();
        modeloLista = new DefaultListModel<>();
        initComponents();
        dialogSizeHandler();
        loadTargets();
        loadProductsInfo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstProductsInfo = new javax.swing.JList<>();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(lstProductsInfo);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    @Override
    public void loadTargets() {
    }
    
    private void loadProductsInfo() {
        if (productsInfo != null && !productsInfo.isBlank()) {
            for (final var info: gson.fromJson(productsInfo.trim(), String[].class)) {
                modeloLista.addElement(info);
            }
            lstProductsInfo.setModel(modeloLista);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstProductsInfo;
    // End of variables declaration//GEN-END:variables
}
