package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.ISaleDeletedDetailController;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.mappers.WrapperPojoSalesDeletedDetailsMapper;
import jakarta.inject.Inject;
import javax.swing.table.DefaultTableModel;

public final class SalesCanceled extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(SalesCanceled.class.getName());
    
    private static final String[] titles = {"ID", "Producto", "Motivo", "Fecha", "Cancelado por"};
    
    @Inject
    private ISaleDeletedDetailController saleDeleted;
    
    @Inject
    private WrapperPojoSalesDeletedDetailsMapper wrapperSalesDeletedMapper;

    public SalesCanceled(String key) {
        super(key);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalesCanceled = new javax.swing.JTable();

        tblSalesCanceled.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblSalesCanceled);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSalesCanceled;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void init() {
        try {
            initComponents();
            GUICommons.loadTitleOnTable(tblSalesCanceled, titles, false);
            loadDataOnTbl();
        } catch (BloSalesV2Exception e) {
            logger.error(e.getMessage());
            CommonAlerts.openError(e.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
    private void loadDataOnTbl() throws BloSalesV2Exception {
        final var salesCanceled  = wrapperSalesDeletedMapper.toOuter(saleDeleted.getSalesDeleted());
            final var model = (DefaultTableModel) tblSalesCanceled.getModel();
            model.setRowCount(0);
            for (final var item: salesCanceled.getSalesDeleted()) {
                Object[] row = {
                    item.getIdSaleDeleted(),
                    item.getProduct(),
                    item.getReason(),
                    parserTimestamp(item.getTimestamp()),
                    item.getUsername()
                };
                model.addRow(row);
            }
            tblSalesCanceled.setModel(model);
    }
}
