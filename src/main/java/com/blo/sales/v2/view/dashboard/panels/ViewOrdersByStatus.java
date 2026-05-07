package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IOrdersVendorsController;
import com.blo.sales.v2.controller.pojos.enums.StatusMovementProviderIntEnum;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.mappers.WrapperPojoVendorsOrdersMapper;
import com.blo.sales.v2.view.pojos.PojoOrderVendor;
import com.blo.sales.v2.view.pojos.WrapperPojoOrdersVendors;
import com.blo.sales.v2.view.pojos.enums.StatusOrderProviderEnum;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;

public final class ViewOrdersByStatus extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(ViewOrdersByStatus.class.getName());
    
    private static final String[] titles = {"ID orden", "ID vendedor", "Nombre de proveedor", "Marca", "Monto", "Factura/referencia", "Fecha de entrega estimada", "Estado de orden", "Fecha de creación de orden"};

    @Inject
    private IOrdersVendorsController ordersVendorController;
    
    @Inject
    private WrapperPojoVendorsOrdersMapper vendorsOrdersMapper;
    
    private WrapperPojoOrdersVendors wrapperOrders;
    
    /** variable globala para opreaciones de orden seleccionada */
    private PojoOrderVendor orderVendor;
    
    public ViewOrdersByStatus(String title) {
        super(title);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbxSelectOrderStatus = new javax.swing.JComboBox<>();
        btnApplyFilter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblFilterOrderStatus = new javax.swing.JLabel();
        pnlCtrlCloseOrder = new javax.swing.JPanel();
        cmbxCloseOrderReasons = new javax.swing.JComboBox<>();
        txtInvoice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCloseOrder = new javax.swing.JButton();

        btnApplyFilter.setText("aplicar_filtro");
        btnApplyFilter.addActionListener(this::btnApplyFilterActionPerformed);

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblOrders);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblFilterOrderStatus.setText("filtrar_por_estado_de_orden");

        jLabel1.setText("no_de_factura");

        btnCloseOrder.setText("cerrar_orden");
        btnCloseOrder.addActionListener(this::btnCloseOrderActionPerformed);

        javax.swing.GroupLayout pnlCtrlCloseOrderLayout = new javax.swing.GroupLayout(pnlCtrlCloseOrder);
        pnlCtrlCloseOrder.setLayout(pnlCtrlCloseOrderLayout);
        pnlCtrlCloseOrderLayout.setHorizontalGroup(
            pnlCtrlCloseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCtrlCloseOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCtrlCloseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCtrlCloseOrderLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                    .addComponent(cmbxCloseOrderReasons, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnCloseOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCtrlCloseOrderLayout.setVerticalGroup(
            pnlCtrlCloseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCtrlCloseOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCtrlCloseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCtrlCloseOrderLayout.createSequentialGroup()
                        .addComponent(cmbxCloseOrderReasons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlCtrlCloseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addComponent(btnCloseOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(683, 964, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFilterOrderStatus)
                        .addGap(18, 18, 18)
                        .addComponent(cmbxSelectOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnApplyFilter)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCtrlCloseOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilterOrderStatus)
                    .addComponent(cmbxSelectOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApplyFilter))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCtrlCloseOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApplyFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyFilterActionPerformed
        getDefaultTableModel().setRowCount(0);
        final var itemSelected = StatusOrderProviderEnum.getByIndex(cmbxSelectOrderStatus.getSelectedIndex());
        applyFilterOnTable(wrapperOrders.getOrders(), itemSelected);
    }//GEN-LAST:event_btnApplyFilterActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            final var filter = GUICommons.getTextFromField(txtSearch, false);
            GUICommons.addFilter(tblOrders, "(?i)", filter);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnCloseOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseOrderActionPerformed
        try {
            final var invoice = GUICommons.getTextFromField(txtInvoice, true);
            final var reason = StatusOrderProviderEnum.getByIndex(cmbxCloseOrderReasons.getSelectedIndex() + 1);
            ordersVendorController.closeOrder(
                    StatusMovementProviderIntEnum.valueOf(reason.name()),
                    orderVendor.getAmount(),
                    orderVendor.getBrand(),
                    invoice,
                    getUserData().getIdUser(),
                    orderVendor.getIdOrderVendor()
            );
            resetInfo();
        } catch (BloSalesV2Exception ex) {
            System.getLogger(ViewOrdersByStatus.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_btnCloseOrderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApplyFilter;
    private javax.swing.JButton btnCloseOrder;
    private javax.swing.JComboBox<String> cmbxCloseOrderReasons;
    private javax.swing.JComboBox<String> cmbxSelectOrderStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFilterOrderStatus;
    private javax.swing.JPanel pnlCtrlCloseOrder;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTextField txtInvoice;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
    
    /** metodo que aplica un filtro a la lista de ordenes que son recuperadas desde la db */
    private void applyFilterOnTable(List<PojoOrderVendor> orders, StatusOrderProviderEnum itemSelected) {
        if (itemSelected != null) {
            orders = orders.stream().filter(o -> o.getStatusOrder().equals(itemSelected)).collect(Collectors.toList());
        }
        for (final var order: orders) {
            final Object[] row = {
                order.getIdOrderVendor(),
                order.getFkVendor(),
                order.getVendorName(),
                order.getBrand(),
                order.getAmount(),
                order.getInvoice(),
                order.getDeadline(),
                order.getStatusOrder().getTarget(),
                parserTimestamp(order.getTimestamp())
            };
            getDefaultTableModel().addRow(row);
        }
        tblOrders.setModel(getDefaultTableModel());
    }
    
    /** muestra un panel si la orden seleccionada esta pendiente */
    private void closeOrder(Long idOrder) {
        final var orderFound = wrapperOrders.getOrders().stream().filter(o -> o.getIdOrderVendor() == idOrder).findFirst().orElse(null);
        if (orderFound != null && orderFound.getStatusOrder().compareTo(StatusOrderProviderEnum.PENDIG) == 0) {
            GUICommons.showPanel(pnlCtrlCloseOrder);
            orderVendor = orderFound;
        }
    }
    
    private void loadBySatusFilter() {
        final var statusModel = new DefaultComboBoxModel<String>();
        StatusOrderProviderEnum.getVisiblesTypes(0).forEach(p -> statusModel.addElement(p.getTarget()));
        cmbxSelectOrderStatus.setModel(statusModel);
    }
    
    private void loadReasonCloseOrder() {
        final var statusModel = new DefaultComboBoxModel<String>();
        StatusOrderProviderEnum.getVisiblesTypes(1).forEach(p -> statusModel.addElement(p.getTarget()));
        cmbxCloseOrderReasons.setModel(statusModel);
    }
    
    private void resetInfo() throws BloSalesV2Exception {
        getDefaultTableModel().setRowCount(0);
        wrapperOrders = vendorsOrdersMapper.toOuter(ordersVendorController.getOrders());
        applyFilterOnTable(wrapperOrders.getOrders(), null);
        GUICommons.addDoubleClickOnTable(tblOrders, (Long idOrder) -> closeOrder(idOrder));
        GUICommons.hiddenPanel(pnlCtrlCloseOrder);
        orderVendor = null;
    }
    
    @Override
    public void loadTargets() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void init() {
        try {
            initComponents();
            setMainTable(tblOrders);
            loadBySatusFilter();
            loadReasonCloseOrder();
            GUICommons.loadTitleOnTable(tblOrders, titles, false);
            resetInfo();
        } catch (BloSalesV2Exception e) {
            logger.error(e.getMessage());
            CommonAlerts.openError(e.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
}
