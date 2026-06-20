package com.blo.sales.v2.view.dialogs;

import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.view.commons.AbstractDialogBase;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.pojos.WrapperPojoVendors;
import java.awt.Component;
import java.util.function.Consumer;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public final class VendorsVisitDialog<T> extends AbstractDialogBase {
    
    private final WrapperPojoVendors vendors;

    public VendorsVisitDialog(Component parent, String title, Consumer<T> callback, WrapperPojoVendors vendors) {
        super(SwingUtilities.getWindowAncestor(parent), title, ModalityType.APPLICATION_MODAL, false);
        this.vendors = vendors;
        initComponents();
        setSize(500, 300);
        loadTargets();
        dialogSizeHandler();
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstVendorsVisit = new javax.swing.JList<>();
        btnClose = new javax.swing.JButton();

        jScrollPane1.setViewportView(lstVendorsVisit);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    @Override
    public void loadTargets() {
        GUICommons.setTextToButton(btnClose, getTranslateBy(KeysEnum.COMMON_BTN_CLOSE.getKey()));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstVendorsVisit;
    // End of variables declaration//GEN-END:variables

    private void loadData() {
        if (vendors.getVendors() != null && !vendors.getVendors().isEmpty()) {
            final var model = new DefaultListModel<String>();
            vendors.getVendors().forEach(v -> {
                final var common = "[%s] %s (%s)";
                model.addElement(String.format(common, v.getIdVendor(), v.getName(), v.getBrand()));
            });
            lstVendorsVisit.setModel(model);
        }
    }

}
