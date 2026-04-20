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
import com.blo.sales.v2.view.pojos.PojoVendor;
import jakarta.inject.Inject;

public class AddVendor extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(AddVendor.class.getName());
    
    @Inject
    private CheckboxDays week;
    
    @Inject
    private PojoVendorMapper vendorMapper;
    
    @Inject
    private IVendorsController vendorController;
    
    public AddVendor(String key) {
        super(key);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVendorName = new javax.swing.JLabel();
        txtVendorName = new javax.swing.JTextField();
        lblContact = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        lblVisitDats = new javax.swing.JLabel();
        lblBrand = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        chbxPreSale = new javax.swing.JCheckBox();
        btnSave = new javax.swing.JButton();
        pnlAreaVisitDays = new javax.swing.JPanel();

        lblVendorName.setText("nombre_de_proveedor");

        lblContact.setText("contacto");

        lblVisitDats.setText("dias_de_visita");

        lblBrand.setText("marca");

        chbxPreSale.setText("prventa");

        btnSave.setText("guardar");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        javax.swing.GroupLayout pnlAreaVisitDaysLayout = new javax.swing.GroupLayout(pnlAreaVisitDays);
        pnlAreaVisitDays.setLayout(pnlAreaVisitDaysLayout);
        pnlAreaVisitDaysLayout.setHorizontalGroup(
            pnlAreaVisitDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );
        pnlAreaVisitDaysLayout.setVerticalGroup(
            pnlAreaVisitDaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVendorName)
                    .addComponent(lblContact)
                    .addComponent(lblBrand))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtVendorName)
                    .addComponent(txtContact)
                    .addComponent(txtBrand, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVisitDats)
                    .addComponent(chbxPreSale)
                    .addComponent(pnlAreaVisitDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(533, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVendorName)
                    .addComponent(txtVendorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVisitDats))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAreaVisitDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContact)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrand)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbxPreSale))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(383, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            final var vendorName = GUICommons.getTextFromField(txtVendorName, true);
            final var contact = GUICommons.getTextFromField(txtContact, true);
            final var brand = GUICommons.getTextFromField(txtBrand, true);
            final var isPreSale = GUICommons.isCheckedCkeckBox(chbxPreSale);
            final var vendor = new PojoVendor();
            vendor.setBrand(brand);
            vendor.setContact(contact);
            vendor.setFkUser(getUserData().getIdUser());
            vendor.setPreSale(isPreSale);
            vendor.setVisitDays(week.getJsonWithDaysSelected());
            vendor.setName(vendorName);
            vendorController.addVendor(vendorMapper.toInner(vendor));
            resetFields();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    @Override
    public void loadTargets() {
        GUICommons.setTextToField(lblVendorName, getTranslateBy(KeysEnum.ADD_VENDOR_LBL_VENDOR_NAME.getKey()));
        GUICommons.setTextToField(lblContact, getTranslateBy(KeysEnum.ADD_VENDOR_LBL_CONTACT.getKey()));
        GUICommons.setTextToField(lblBrand, getTranslateBy(KeysEnum.ADD_VENDOR_LBL_BRAND.getKey()));
        GUICommons.setTextToCheckbox(chbxPreSale, getTranslateBy(KeysEnum.ADD_VENDOR_LBL_PRE_SALE.getKey()));
        GUICommons.setTextToField(lblVisitDats, getTranslateBy(KeysEnum.ADD_VENDOR_LBL_VISIT_DAYS.getKey()));
    }

    @Override
    public void init() {
        initComponents();
        week.setContainer(pnlAreaVisitDays);
        loadTargets();
        week.createCheckboxDaysList();
    }
    
    private void resetFields() {
        GUICommons.setTextToField(lblVendorName, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(lblContact, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(lblBrand, BloSalesV2Utils.EMPTY_STRING);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chbxPreSale;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblVendorName;
    private javax.swing.JLabel lblVisitDats;
    private javax.swing.JPanel pnlAreaVisitDays;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtVendorName;
    // End of variables declaration//GEN-END:variables
}
