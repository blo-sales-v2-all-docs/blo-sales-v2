package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IVendorsController;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.components.CheckboxDays;
import com.blo.sales.v2.view.mappers.PojoVendorMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoVendorsMapper;
import com.blo.sales.v2.view.pojos.PojoVendor;
import com.google.gson.Gson;
import jakarta.inject.Inject;

public final class Vendors extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(Vendors.class.getName());
    
    private static final String[] titles = {"Id proveedor", "Nombre", "Contacto", "Marca que maneja", "Dias de visita", "¿Es preventa?", "Ultima actualizacion"};
    
    @Inject
    private IVendorsController vendorsController;
    
    @Inject
    private WrapperPojoVendorsMapper vendorsMapper;
    
    @Inject
    private PojoVendorMapper vendorMapper;
    
    @Inject
    private CheckboxDays weekComponent;
    
    private PojoVendor vendorSelected;

    public Vendors(String keys) {
        super(keys);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendors = new javax.swing.JTable();
        pnlContactEdit = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblContact = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        pnlDays = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cmbxIsPreSale = new javax.swing.JCheckBox();

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

        lblName.setText("nombre");

        lblContact.setText("contacto");

        javax.swing.GroupLayout pnlDaysLayout = new javax.swing.GroupLayout(pnlDays);
        pnlDays.setLayout(pnlDaysLayout);
        pnlDaysLayout.setHorizontalGroup(
            pnlDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );
        pnlDaysLayout.setVerticalGroup(
            pnlDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        btnSave.setText("guardar");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnCancel.setText("cancelar");
        btnCancel.addActionListener(this::btnCancelActionPerformed);

        cmbxIsPreSale.setText("preventa");

        javax.swing.GroupLayout pnlContactEditLayout = new javax.swing.GroupLayout(pnlContactEdit);
        pnlContactEdit.setLayout(pnlContactEditLayout);
        pnlContactEditLayout.setHorizontalGroup(
            pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContactEditLayout.createSequentialGroup()
                .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContactEditLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblName)))
                .addGap(18, 18, 18)
                .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContact))
                .addGap(18, 18, 18)
                .addComponent(pnlDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContactEditLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)
                        .addContainerGap())
                    .addGroup(pnlContactEditLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmbxIsPreSale)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlContactEditLayout.setVerticalGroup(
            pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContactEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblContact))
                .addGap(18, 18, 18)
                .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlContactEditLayout.createSequentialGroup()
                .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContactEditLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmbxIsPreSale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
                    .addComponent(pnlContactEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContactEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (vendorSelected == null) {
                return;
            }
            vendorSelected.setName(GUICommons.getTextFromField(txtName, true));
            vendorSelected.setContact(GUICommons.getTextFromField(txtContact, true));
            final var data = weekComponent.getInfoSelected();
            vendorSelected.setVisitDays(data.getDaysSelected());
            vendorSelected.setPerWeek(data.isPerWeek());
            vendorSelected.setPreSale(GUICommons.isCheckedCkeckBox(cmbxIsPreSale));
            
            final var vendorUpdated = vendorMapper.toInner(vendorSelected);
            vendorsController.updateVendor(vendorUpdated, vendorUpdated.getIdVendor());
            
            resetFields();
            loadVendorsData();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        resetFields();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox cmbxIsPreSale;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblName;
    private javax.swing.JPanel pnlContactEdit;
    private javax.swing.JPanel pnlDays;
    private javax.swing.JTable tblVendors;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void init() {
        initComponents();
        setMainTable(tblVendors);
        loadTargets();
        loadVendorsData();
        pnlContactEdit.setVisible(false);
        GUICommons.addDoubleClickOnTable(tblVendors, (Long id) -> editVendor(id));
        weekComponent.setContainer(pnlDays);
    }
    
    @Override
    public void loadTargets() {
        
    }
    
    private void editVendor(long idVendor) {
        try {
            final var gson = new Gson();
            vendorSelected = vendorMapper.toOuter(vendorsController.getVendorById(idVendor));
            pnlContactEdit.setVisible(true);
            
            GUICommons.setTextToField(txtName, vendorSelected.getName());
            GUICommons.setTextToField(txtContact, vendorSelected.getContact());
            GUICommons.selectElementByBooleanCondition(cmbxIsPreSale, vendorSelected.isPreSale());
            
            final var daysSelected = gson.fromJson(vendorSelected.getVisitDays(), String[].class);
            weekComponent.createWeekCheckboxSelected(daysSelected);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
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
    
    private void resetFields() {
        vendorSelected = null;
        pnlContactEdit.setVisible(false);
        GUICommons.setTextToField(txtName, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(txtContact, BloSalesV2Utils.EMPTY_STRING);
    }
}
