package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IOrdersVendorsController;
import com.blo.sales.v2.controller.IVendorsController;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.dialogs.SelectorDialog;
import com.blo.sales.v2.view.mappers.PojoVendorOrderMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoVendorsMapper;
import com.blo.sales.v2.view.pojos.PojoOrderVendor;
import com.blo.sales.v2.view.pojos.enums.StatusOrderProviderEnum;
import jakarta.inject.Inject;

public final class OpenOrder extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(OpenOrder.class.getName());
    
    @Inject
    private IVendorsController vendorsController;
    
    @Inject
    private IOrdersVendorsController ordersVendorsController;
    
    @Inject
    private PojoVendorOrderMapper pojoVendorMapper;
    
    @Inject
    private WrapperPojoVendorsMapper vendorsMapper;
    
    private long idVendorSelected;

    public OpenOrder(String titleKey) {
        super(titleKey);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOrderAmount = new javax.swing.JLabel();
        nmbAmountOrder = new javax.swing.JTextField();
        dtChooserDelv = new com.toedter.calendar.JDateChooser();
        lblDeadLine = new javax.swing.JLabel();
        btnSaveOrder = new javax.swing.JButton();
        btnSelectorVendor = new javax.swing.JButton();
        lblProviderSelected = new javax.swing.JLabel();

        lblOrderAmount.setText("monto_de_orden");

        lblDeadLine.setText("fecha_de_entrega");

        btnSaveOrder.setText("guardar");
        btnSaveOrder.addActionListener(this::btnSaveOrderActionPerformed);

        btnSelectorVendor.setText("seleccionar_proveedor");
        btnSelectorVendor.addActionListener(this::btnSelectorVendorActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelectorVendor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSaveOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblOrderAmount)
                                .addComponent(lblDeadLine))
                            .addGap(54, 54, 54)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dtChooserDelv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nmbAmountOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblProviderSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(923, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSelectorVendor)
                .addGap(18, 18, 18)
                .addComponent(lblProviderSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrderAmount)
                    .addComponent(nmbAmountOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDeadLine)
                    .addComponent(dtChooserDelv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSaveOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveOrderActionPerformed
        try {
            
            if (idVendorSelected != 0) {
                final var order = new PojoOrderVendor();
                order.setFkVendor(idVendorSelected);
                order.setStatusOrder(StatusOrderProviderEnum.PENDIG);
                order.setAmount(GUICommons.getNumberFromJText(nmbAmountOrder, 2));
                order.setDeadline(GUICommons.getDateFromDateChooser(dtChooserDelv));
                order.setProductsInfo(BloSalesV2Utils.EMPTY_STRING);
                ordersVendorsController.highOrder(pojoVendorMapper.toInner(order));
            }
            resetFields();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSaveOrderActionPerformed

    private void btnSelectorVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectorVendorActionPerformed
        try {
            final var vendors = vendorsMapper.toOuter(vendorsController.getAllVendors());
            new SelectorDialog<>(
                    this,
                    getTranslateBy(KeysEnum.OPEN_ORDER_BTN_SELECT_VENDOR.getKey()),
                    vendors.getVendors().stream().map(s -> s.getBasicData()).toList(),
                    (String data) -> {
                        GUICommons.setTextToField(lblProviderSelected, data);
                        idVendorSelected = BloSalesV2Utils.getIdVendorFromBasicData(data);
                    }
            ).setVisible(true);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSelectorVendorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveOrder;
    private javax.swing.JButton btnSelectorVendor;
    private com.toedter.calendar.JDateChooser dtChooserDelv;
    private javax.swing.JLabel lblDeadLine;
    private javax.swing.JLabel lblOrderAmount;
    private javax.swing.JLabel lblProviderSelected;
    private javax.swing.JTextField nmbAmountOrder;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToButton(btnSelectorVendor, getTranslateBy(KeysEnum.OPEN_ORDER_BTN_SELECT_VENDOR.getKey()));
        GUICommons.setTextToField(lblOrderAmount, getTranslateBy(KeysEnum.OPEN_ORDER_LBL_AMOUNT.getKey()));
        GUICommons.setTextToField(lblDeadLine, getTranslateBy(KeysEnum.OPEN_ORDER_LBL_DEAD_LINE.getKey()));
        GUICommons.setTextToButton(btnSaveOrder, getTranslateBy(KeysEnum.COMMON_BTN_SAVE.getKey()));
    }

    @Override
    public void init() {
        initComponents();
        loadTargets();
        resetFields();
    }
    
    
    private void resetFields() {
        GUICommons.setTextToField(nmbAmountOrder, BloSalesV2Utils.EMPTY_STRING);
        idVendorSelected = 0;
        GUICommons.setTextToField(lblProviderSelected, BloSalesV2Utils.EMPTY_STRING);
    }
}
