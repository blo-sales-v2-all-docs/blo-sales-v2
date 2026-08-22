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
import com.blo.sales.v2.view.pojos.enums.VisitEnum;
import jakarta.inject.Inject;

public final class Vendors extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(Vendors.class.getName());
    
    private static final String[] titles = {"Id proveedor", "Nombre", "Contacto", "Marca que maneja", "Dias de visita", "¿Es preventa?", "¿Recordatorio?", "Visita", "Ultima actualizacion"};
    
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
        btnDeleteVendor = new javax.swing.JButton();
        chkbxReminder = new javax.swing.JCheckBox();

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

        btnDeleteVendor.setText("eliminar");
        btnDeleteVendor.addActionListener(this::btnDeleteVendorActionPerformed);

        chkbxReminder.setText("recordatorio");

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
                .addGap(18, 18, 18)
                .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContactEditLayout.createSequentialGroup()
                        .addComponent(chkbxReminder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteVendor)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel))
                    .addGroup(pnlContactEditLayout.createSequentialGroup()
                        .addComponent(cmbxIsPreSale)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlContactEditLayout.setVerticalGroup(
            pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContactEditLayout.createSequentialGroup()
                .addComponent(pnlDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(pnlContactEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContactEditLayout.createSequentialGroup()
                        .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(lblContact))
                        .addGap(18, 18, 18)
                        .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContactEditLayout.createSequentialGroup()
                        .addComponent(cmbxIsPreSale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlContactEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkbxReminder))
                        .addContainerGap())))
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
            
            BloSalesV2Utils.validateRule(data == null, BloSalesV2Utils.COMMON_RULE_CODE, BloSalesV2Utils.INVALID_TEXT);
            
            vendorSelected.setVisitDays(data.getDaysSelected());
            vendorSelected.setPerWeek(data.isPerWeek());
            vendorSelected.setPreSale(GUICommons.isCheckedCkeckBox(cmbxIsPreSale));
            vendorSelected.setVisits(VisitEnum.valueOf(data.getVisits()));
            vendorSelected.setReminder(weekComponent.getSelectedDaysToReminder(GUICommons.isCheckedCkeckBox(chkbxReminder), data));
            
            final var vendorUpdated = vendorMapper.toInner(vendorSelected);
            vendorsController.updateVendor(vendorUpdated, vendorUpdated.getIdVendor());
            
            reset();
            loadVendorsData();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        reset();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteVendorActionPerformed
        try {        
            if (CommonAlerts.showConfirmDialog(String.format(getTranslateBy(KeysEnum.VENDORS_DLG_DELETE_VENDOR.getKey()), vendorSelected.getName()), getTranslateBy(KeysEnum.COMMON_ALERT_WARNING.getKey())) && vendorSelected != null) {
                vendorsController.deleteVendor(vendorSelected.getIdVendor());
                reset();
                loadVendorsData();
            }
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnDeleteVendorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteVendor;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkbxReminder;
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

    private void editVendor(long idVendor) {
        try {
            vendorSelected = vendorMapper.toOuter(vendorsController.getVendorById(idVendor));
            pnlContactEdit.setVisible(true);
            
            GUICommons.setTextToField(txtName, vendorSelected.getName());
            GUICommons.setTextToField(txtContact, vendorSelected.getContact());
            GUICommons.selectElementByBooleanCondition(cmbxIsPreSale, vendorSelected.isPreSale());
            GUICommons.selectElementByBooleanCondition(chkbxReminder, !isEmptyReminder(vendorSelected.getReminder()));
            
            final var daysSelected = getGson().fromJson(vendorSelected.getVisitDays(), String[].class);
            var visits = VisitEnum.WEEKLY.name();
            if (vendorSelected.getVisits() != null) {
                visits = vendorSelected.getVisits().name();
            }
            weekComponent.createWeekCheckboxSelected(daysSelected, visits);
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
                        !isEmptyReminder(v.getReminder()),
                        v.getVisits() != null ? v.getVisits().getTarget() : BloSalesV2Utils.EMPTY_STRING,
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
    
    @Override
    public void init() {
        initComponents();
        setMainTable(tblVendors);
        loadTargets();
        loadVendorsData();
        pnlContactEdit.setVisible(false);
        GUICommons.addDoubleClickOnTable(tblVendors, (Long id) -> editVendor(id));
        GUICommons.changeRowSelectedFromTable(tblVendors, (Integer id) -> reset());
        weekComponent.setContainer(pnlDays);
    }
    
    @Override
    protected void loadTargets() {
        GUICommons.setTextToButton(btnSave, getTranslateBy(KeysEnum.COMMON_BTN_SAVE_CHANGES.getKey()));
        GUICommons.setTextToButton(btnCancel, getTranslateBy(KeysEnum.COMMON_BTN_CANCEL.getKey()));
        GUICommons.setTextToButton(btnDeleteVendor, getTranslateBy(KeysEnum.COMMON_BTN_DELETE.getKey()));
    }
    
    @Override
    protected void reset() {
        vendorSelected = null;
        pnlContactEdit.setVisible(false);
        GUICommons.setTextToField(txtName, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(txtContact, BloSalesV2Utils.EMPTY_STRING);
    }
    
    private boolean isEmptyReminder(String reminder) {
        logger.info("reminder %s", reminder);
        return getGson().fromJson(reminder.replace("\"", ""), String[].class).length == 0;
    }
}
