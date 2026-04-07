package com.blo.sales.v2.view.dialogs;

import com.blo.sales.v2.plugins.csv.BloSalesV2CSVCols;
import com.blo.sales.v2.plugins.csv.BloSalesV2CSVPlugin;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.view.commons.AbstractDialogBase;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.pojos.WrapperPojoCashboxesSalesDetails;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public final class CashboxDetailDialog extends AbstractDialogBase {
    
    private static final String[] titles = {"Id venta", "Fecha de venta", "Producto", "Cantidad vendida", "Comprado", "Total de venta", "Tipo de pago", "Referencia", "Efectivo total", "Pago con tarjeta", "Gestionada por"};
            
    private final WrapperPojoCashboxesSalesDetails cashboxDetails;
    
    private final String title;
    
    public CashboxDetailDialog(
        Component parent,
        String title,
        WrapperPojoCashboxesSalesDetails cashboxDetails
    ) {
        super(SwingUtilities.getWindowAncestor(parent), title, ModalityType.APPLICATION_MODAL, true);
        this.cashboxDetails = cashboxDetails;
        this.title = title;
        initComponents();
        dialogSizeHandler();
        loadTargets();
        loadDataOnTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetailsCashbox = new javax.swing.JTable();
        btnDownloadReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDetailsCashbox.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDetailsCashbox);

        btnDownloadReport.setText("descargar_reporte");
        btnDownloadReport.addActionListener(this::btnDownloadReportActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDownloadReport)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnDownloadReport)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDownloadReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadReportActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblDetailsCashbox.getModel();
        final var bloSalesRow = new BloSalesV2CSVCols();
        final var r = new ArrayList<Object[]>();
        r.add(new Object[]{title});
        for(var i = 0; i < tblDetailsCashbox.getRowCount(); i++) {
            final Object[] row = {
                String.valueOf(model.getValueAt(i, 0)),
                String.valueOf(model.getValueAt(i, 1)),
                String.valueOf(model.getValueAt(i, 2)),
                String.valueOf(model.getValueAt(i, 3)),
                String.valueOf(model.getValueAt(i, 4)),
                String.valueOf(model.getValueAt(i, 5)),
                String.valueOf(model.getValueAt(i, 6)),
                String.valueOf(model.getValueAt(i, 7)),
                String.valueOf(model.getValueAt(i, 8)),
                String.valueOf(model.getValueAt(i, 9)),
                String.valueOf(model.getValueAt(i, 10))
            };
            r.add(row);
        }
        bloSalesRow.setCols(r);
        BloSalesV2CSVPlugin.exportFile(titles, bloSalesRow, title, true);
    }//GEN-LAST:event_btnDownloadReportActionPerformed

    @Override
    public void loadTargets() {
        GUICommons.setTextToButton(btnDownloadReport, getTranslateBy(KeysEnum.DLG_CASHBOX_BTN_DOWNLOAD_REPORT.getKey()));
    }
    
    private void loadDataOnTable() {
        GUICommons.loadTitleOnTable(tblDetailsCashbox, titles, false);
        DefaultTableModel model = (DefaultTableModel) tblDetailsCashbox.getModel();
        for(final var item: cashboxDetails.getCashboxes()) {
            final Object[] row = {
                item.getSale().getIdSale(),
                parserTimestamp(item.getSale().getTimestamp()),
                item.getProduct().getProduct(),
                item.getSaleProduct().getQuantityOnSale(),
                item.getSaleProduct().getProductTotalOnSale(),
                item.getSale().getTotal(),
                item.getPaymentTypeInfo().getPaymentType().getPaymentTypeTarget(),
                item.getPaymentTypeInfo().getReference(),
                item.getPaymentTypeInfo().getCash(),
                item.getPaymentTypeInfo().getCardPay(),
                item.getUser().getUsername()
            };
            model.addRow(row);
        }
        tblDetailsCashbox.setModel(model);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDownloadReport;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetailsCashbox;
    // End of variables declaration//GEN-END:variables
}
