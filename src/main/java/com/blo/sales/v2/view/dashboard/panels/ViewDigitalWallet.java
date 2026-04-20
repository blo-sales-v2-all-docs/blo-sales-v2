package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IFinancialHistoryController;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.mappers.WrapperPojoFinancialHistoryMapper;
import com.blo.sales.v2.view.pojos.enums.AccountsEnum;
import jakarta.inject.Inject;

public class ViewDigitalWallet extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(ViewDigitalWallet.class.getName());
    
    private static final String[] tblTitles = {"ID movimiento", "Monto", "Razón", "Tipo de movimiento", "Autorizacion" , "Timestamp"};
    
    @Inject
    private IFinancialHistoryController historyController;
    
    @Inject
    private WrapperPojoFinancialHistoryMapper wrapperMapper;

    public ViewDigitalWallet(String key) {
        super(key);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblCurrentAccount = new javax.swing.JLabel();
        lblAddQuantity = new javax.swing.JLabel();
        nmbQuantity = new javax.swing.JTextField();
        lblPrevisualization = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFinancialHistory = new javax.swing.JTable();

        lblCurrentAccount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCurrentAccount.setText("cuenta_actual: $%s");

        lblAddQuantity.setText("sumar_cantidad_a_cuenta_digital");

        lblPrevisualization.setText("cuenta_actual");

        btnSave.setText("guardar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCurrentAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nmbQuantity)
                            .addComponent(lblAddQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lblPrevisualization, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(932, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurrentAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAddQuantity)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nmbQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrevisualization, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(388, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Detalles", jPanel1);

        tblFinancialHistory.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblFinancialHistory);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Historial", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void loadTargets() {
        
    }

    @Override
    public void init() {
        initComponents();
        setMainTable(tblFinancialHistory);
        loadTargets();
        getHistorial();
    }
    
    private void getHistorial() {
        try {
            final var innerHistory = historyController.retrieveFinancialHistoryByAccountId(AccountsEnum.DIGITAL_WALLET.getId());
            final var wrapperHistory = wrapperMapper.toOuter(innerHistory);
            getDefaultTableModel().setRowCount(0);
            if (wrapperHistory.getHistorial() != null && !wrapperHistory.getHistorial().isEmpty()) {
                GUICommons.loadTitleOnTable(tblFinancialHistory, tblTitles, false);
                wrapperHistory.getHistorial().forEach(mov -> {
                    final Object[] row = {
                        mov.getIdFinancialMovement(),
                        mov.getAmount(),
                        mov.getReason().getReasonTarget(),
                        mov.getType(),
                        mov.getAuthorization(),
                        parserTimestamp(mov.getTimestamp())
                    };
                    getDefaultTableModel().addRow(row);
                });
                tblFinancialHistory.setModel(getDefaultTableModel());
            }
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAddQuantity;
    private javax.swing.JLabel lblCurrentAccount;
    private javax.swing.JLabel lblPrevisualization;
    private javax.swing.JTextField nmbQuantity;
    private javax.swing.JTable tblFinancialHistory;
    // End of variables declaration//GEN-END:variables
}
