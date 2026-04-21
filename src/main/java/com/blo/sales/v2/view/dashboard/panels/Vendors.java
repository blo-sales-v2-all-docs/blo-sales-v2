package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IVendorsController;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.mappers.WrapperPojoVendorsMapper;
import jakarta.inject.Inject;

public class Vendors extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(Vendors.class.getName());
    
    private static final String[] titles = {"Id proveedor", "Nombre", "Contacto", "Marca que maneja", "Dias de visita", "¿Es preventa?", "Ultima actualizacion"};
    
    @Inject
    private IVendorsController vendorsController;
    
    @Inject
    private WrapperPojoVendorsMapper vendorsMapper;

    public Vendors(String keys) {
        super(keys);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendors = new javax.swing.JTable();

        tblVendors.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblVendors);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVendors;
    // End of variables declaration//GEN-END:variables

    @Override
    public void init() {
        initComponents();
        setMainTable(tblVendors);
        loadTargets();
        loadVendorsData();
    }
    
    @Override
    public void loadTargets() {
        
    }
    
    private void loadVendorsData() {
         try {
             GUICommons.loadTitleOnTable(tblVendors, titles, false);
            final var allVendors = vendorsMapper.toOuter(vendorsController.getAllVendors());
            getDefaultTableModel().setRowCount(0);
            if (allVendors.getVendors() != null && !allVendors.getVendors().isEmpty()) {
                allVendors.getVendors().forEach(v -> {
                    final Object[] row = {
                        v.getIdVendor(),
                        v.getName(),
                        v.getContact(),
                        v.getBrand(),
                        v.getVisitDays(),
                        v.isPreSale(),
                        parserTimestamp(v.getTimestamp())
                    };
                    getDefaultTableModel().addRow(row);
                });
            }
            tblVendors.setModel(getDefaultTableModel());
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
}
