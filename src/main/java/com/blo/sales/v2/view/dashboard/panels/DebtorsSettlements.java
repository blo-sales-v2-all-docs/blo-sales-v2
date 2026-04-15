package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IDebtorSettlementsController;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.mappers.WrapperPojoDebtorSettlementsMapper;
import com.blo.sales.v2.view.pojos.WrapperPojoDebtSettlement;
import jakarta.inject.Inject;

public final class DebtorsSettlements extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(DebtorsSettlements.class.getName());
    
    private static final String[] titles = {"Id historial de pago", "Deudor", "Productos", "Pagos", "Timestamp"};
    
    @Inject
    private IDebtorSettlementsController settlementsController;
    
    @Inject
    private WrapperPojoDebtorSettlementsMapper wrapperDebtorSettlements;

    public DebtorsSettlements(String key) {
        super(key);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDebtHistory = new javax.swing.JTable();

        tblDebtHistory.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDebtHistory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void loadTargets() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void init() {
        try {
            initComponents();
            setMainTable(tblDebtHistory);
            final var history = wrapperDebtorSettlements.toOuter(settlementsController.getDebtorsPaymentsHistory());
            GUICommons.loadTitleOnTable(tblDebtHistory, titles, true);
            loadDataOnTable(history);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
    private void loadDataOnTable(WrapperPojoDebtSettlement data) {
        if (data.getDebtSettlements() != null && !data.getDebtSettlements().isEmpty()) {
            for (final var item: data.getDebtSettlements()) {
                final Object[] row = {
                    item.getIdDebtSettlement(),
                    item.getDebtor(),
                    item.getProductsDetails(),
                    formatPayments(item.getPayments()),
                    parserTimestamp(item.getTimestamp())
                };
                getDefaultTableModel().addRow(row);
            }
            tblDebtHistory.setModel(getDefaultTableModel());
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDebtHistory;
    // End of variables declaration//GEN-END:variables
}
