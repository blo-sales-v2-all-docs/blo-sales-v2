package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.ICashboxController;
import com.blo.sales.v2.controller.ICashboxesOrdersVendorsController;
import com.blo.sales.v2.controller.ICashboxesSalesController;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.dialogs.CashboxDetailDialog;
import com.blo.sales.v2.view.dialogs.CashboxesGraphicsDialog;
import com.blo.sales.v2.view.dialogs.ListViewerDialog;
import com.blo.sales.v2.view.mappers.WrapperPojoCashboxesDetailsMapper;
import com.blo.sales.v2.view.pojos.PojoCashboxDetail;
import com.blo.sales.v2.view.pojos.WrapperPojoCashboxesDetails;
import com.blo.sales.v2.view.mappers.WrapperPojoCashboxesSalesDetailMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoVendorsOrdersMapper;
import com.blo.sales.v2.view.pojos.WrapperPojoOrdersVendors;
import com.blo.sales.v2.view.pojos.enums.ActivesCostsEnum;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;

public final class AllCashboxes extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(AllCashboxes.class.getName());
    
    @Inject
    private WrapperPojoCashboxesDetailsMapper mapper;
    
    @Inject
    private WrapperPojoCashboxesSalesDetailMapper salesDetailsMapper;
    
    @Inject
    private ICashboxController controller;
    
    @Inject
    private ICashboxesSalesController cashboxesSales;
    
    @Inject
    private ICashboxesOrdersVendorsController cashboxesOrdersVendorsController;
    
    @Inject
    private WrapperPojoVendorsOrdersMapper vendorsOrdersMapper;
    
    private long idCashbox;
    
    private WrapperPojoCashboxesDetails cashboxesDetails;
    
    private WrapperPojoOrdersVendors ordersVendorsDetails;
    
    private static final Gson GSON = new Gson();

    public AllCashboxes(String key) {
        super(key);
    }
    
    @Override
    public void init() {
        initComponents();
        setMainTable(tblCashboxes);
        loadCashboxData();
        loadTargets();
        GUICommons.addDoubleClickOnListEvt(lstOrders, (String data) -> {
            final var id = BloSalesV2Utils.getMatcherByIndexGroup("ID: (\\d+)", data, 1);
            final var ordenEncontrada = ordersVendorsDetails.getOrders().stream().
                    filter(o -> o.getIdOrderVendor() == Long.parseLong(id)).
                    findFirst().
                    orElse(null);
            new ListViewerDialog(this, id, ordenEncontrada.getProductsInfo()).setVisible(true);
        });
    }
    
    private void loadCashboxData() {
        try {
            cashboxesDetails = mapper.toOuter(controller.getCashboxesDetail());
            if (cashboxesDetails.getCashboxesInfo() != null && !cashboxesDetails.getCashboxesInfo().isEmpty()) {
                cashboxesOnTable(cashboxesDetails);
                GUICommons.addDoubleClickOnTable(tblCashboxes, (Long id) -> {
                    final var cashboxFound = cashboxesDetails.getCashboxesInfo().stream().
                        filter(c -> c.getIdCashbox() == id).collect(Collectors.toList());
                    if (cashboxFound != null) {
                        idCashbox = id;
                        ordersVendorsDetails = null;
                        try {
                            final var modelOrders = new DefaultListModel<String>();
                            ordersVendorsDetails = vendorsOrdersMapper.toOuter(cashboxesOrdersVendorsController.getOrdersVendorByIdCashbox(idCashbox));
                            lstOrders.setModel(addOrdersOnList(ordersVendorsDetails, modelOrders));
                            GUICommons.enabledButton(btnViewDetails);
                            
                            //listas
                            final var modelActives = new DefaultListModel<String>();
                            final var modelCosts = new DefaultListModel<String>();
                            lstActives.setModel(costsAndActivesHandler(cashboxFound, ActivesCostsEnum.ACTIVO, modelActives));
                            lstCosts.setModel(costsAndActivesHandler(cashboxFound, ActivesCostsEnum.PASIVO, modelCosts));
                            indicatorHandler();
                        } catch (BloSalesV2Exception ex) {
                            logger.error(ex.getMessage());
                            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
                        }
                    }
                });
            }
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
    private void indicatorHandler() {
        try {
            final var actives = new BigDecimal(GUICommons.getTextFromField(lblActives, false).split(" ")[1]);
            final var costs = new BigDecimal(GUICommons.getTextFromField(lblCosts, false).split(" ")[1]);
            var color = Color.RED;
            if (actives.compareTo(costs) > 0) {
                color = Color.GREEN;
            }
            GUICommons.setColorToLabel(lblHealth, color, color);
        } catch (BloSalesV2Exception ex) { }
    }
    
    /**
     * Metodo que hace la suma de activos y costos para mostrarlos en pantalla, ademas de llenar el modelo para ser enviado a una lista en la vista
     * @param lst
     * @param type
     * @param model
     * @return 
     */
    private DefaultListModel costsAndActivesHandler(List<PojoCashboxDetail> lst, ActivesCostsEnum type, DefaultListModel model) {
        final var baseStr = "%s=$%s";
        final var total = lst.stream().
                filter(e -> e.getType().getIndex() == type.getIndex()).
                map(e -> {
                    model.addElement(String.format(baseStr, e.getConcept(), e.getConceptAmount()));
                    return e.getConceptAmount();
                }).
                reduce(BigDecimal.ZERO, BigDecimal::add);
        if (type.getIndex() == 0) {
            GUICommons.setTextToField(lblActives, String.format(getTranslateBy(KeysEnum.CASHBOXES_LBL_ACTIVES.getKey()), total));
        }
        if (type.getIndex() == 1) {
            GUICommons.setTextToField(lblCosts, String.format(getTranslateBy(KeysEnum.CASHBOXES_LBL_COSTS.getKey()), total));
        }
        return model;
    }
    
    private void cashboxesOnTable(WrapperPojoCashboxesDetails cashboxes) {
        final String[] titles = {"ID", "Monto", "Status", "Timestamp"};
        GUICommons.loadTitleOnTable(tblCashboxes, titles, false);
            final var cashboxesFilter = cashboxes.getCashboxesInfo().stream().collect(Collectors.toMap(
                    PojoCashboxDetail::getIdCashbox,
                    obj -> obj,
                    (existente, reemplazo) -> existente
            )).values()
            .stream()
            .collect(Collectors.toList());
            getDefaultTableModel().setRowCount(0);
            cashboxesFilter.sort(Comparator.comparing(PojoCashboxDetail::getIdCashbox).reversed());
            cashboxesFilter.forEach(c -> {
                final Object[] row = {
                    c.getIdCashbox(),
                    c.getAmount(),
                    c.getStatus().name(),
                    parserTimestamp(c.getTimestamp())
                };
                getDefaultTableModel().addRow(row);
            });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCashboxes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstActives = new javax.swing.JList<>();
        lblActives = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstCosts = new javax.swing.JList<>();
        lblCosts = new javax.swing.JLabel();
        btnViewDetails = new javax.swing.JButton();
        btnViewGraphic = new javax.swing.JButton();
        lblHealth = new javax.swing.JLabel();
        lblORders = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstOrders = new javax.swing.JList<>();

        tblCashboxes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCashboxes);

        jScrollPane2.setViewportView(lstActives);

        lblActives.setText("activos");

        jScrollPane3.setViewportView(lstCosts);

        lblCosts.setText("gastos");

        btnViewDetails.setText("ver_detalles");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        btnViewGraphic.setText("graphic");
        btnViewGraphic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewGraphicActionPerformed(evt);
            }
        });

        lblORders.setText("ordenes");

        jScrollPane4.setViewportView(lstOrders);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblActives)
                                .addGap(387, 387, 387)
                                .addComponent(lblORders)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCosts)
                                .addGap(275, 275, 275)
                                .addComponent(btnViewDetails))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnViewGraphic)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnViewGraphic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCosts)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblActives)
                        .addComponent(lblORders))
                    .addComponent(btnViewDetails, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        try {
            logger.info("buscando id %s", idCashbox);
            final var cashboxes = salesDetailsMapper.toOuter(cashboxesSales.getCashboxSalesDetailById(idCashbox));
            if (cashboxes.getCashboxes() != null && !cashboxes.getCashboxes().isEmpty()) {
                final var title = String.format(
                        getTranslateBy(
                                KeysEnum.CASHBOXES_LBL_CASHBOX_OF.getKey()),
                                idCashbox, parserTimestamp(cashboxes.getCashboxes().get(0).getCashbox().getTimestamp()
                            )
                        );
                final var detailsDialog = new CashboxDetailDialog(this, title, cashboxes);
                detailsDialog.setVisible(true);
                return;
            }
            CommonAlerts.openWarning("Esta caja aún no tiene disponible esta funcionalidad", "Espera");
        } catch (BloSalesV2Exception ex) {
            System.getLogger(AllCashboxes.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnViewGraphicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewGraphicActionPerformed
        if (cashboxesDetails.getCashboxesInfo() != null && !cashboxesDetails.getCashboxesInfo().isEmpty()) {
            final var cashboxesEvolution = new CashboxesGraphicsDialog(this, "Caja de dinero", cashboxesDetails);
            cashboxesEvolution.setVisible(true);
            return;
        }
        CommonAlerts.openWarning("Esta caja aún no tiene disponible esta funcionalidad", "Espera");
    }//GEN-LAST:event_btnViewGraphicActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JButton btnViewGraphic;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblActives;
    private javax.swing.JLabel lblCosts;
    private javax.swing.JLabel lblHealth;
    private javax.swing.JLabel lblORders;
    private javax.swing.JList<String> lstActives;
    private javax.swing.JList<String> lstCosts;
    private javax.swing.JList<String> lstOrders;
    private javax.swing.JTable tblCashboxes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToField(lblActives, String.format(getTranslateBy(KeysEnum.CASHBOXES_LBL_ACTIVES.getKey()), "0"));
        GUICommons.setTextToField(lblCosts, String.format(getTranslateBy(KeysEnum.CASHBOXES_LBL_COSTS.getKey()), "0"));
        GUICommons.setTextToButton(btnViewDetails, getTranslateBy(KeysEnum.CASHBOXES_BTN_VIEW_DETAILS.getKey()));
        GUICommons.disabledButton(btnViewDetails);
        GUICommons.setTextToButton(btnViewGraphic, getTranslateBy(KeysEnum.CASHBOXES_BTN_GRAPHICS.getKey()));
        GUICommons.setTextToField(lblORders, getTranslateBy(KeysEnum.CASHBOXES_LBL_ORDERS.getKey()));
    }
    
    private DefaultListModel addOrdersOnList(WrapperPojoOrdersVendors orders, DefaultListModel model) {
        if (orders.getOrders() != null && !orders.getOrders().isEmpty()) {
            orders.getOrders().forEach(o -> model.addElement(String.format("ID: %s; %s; %s; $%s [%s]", o.getIdOrderVendor(), o.getBrand(), o.getVendorInfo().getName(), o.getAmount(), o.getStatusOrder().name())));
        }
        return model;
    }
    
}
