package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.ICashboxController;
import com.blo.sales.v2.controller.ICashboxesSalesController;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.dialogs.CashboxDetailDialog;
import com.blo.sales.v2.view.dialogs.CashboxesGraphicsDialog;
import com.blo.sales.v2.view.mappers.WrapperPojoCashboxesDetailsMapper;
import com.blo.sales.v2.view.pojos.PojoCashboxDetail;
import com.blo.sales.v2.view.pojos.WrapperPojoCashboxesDetails;
import com.blo.sales.v2.view.mappers.WrapperPojoCashboxesSalesDetailMapper;
import com.blo.sales.v2.view.pojos.enums.ActivesCostsEnum;
import jakarta.inject.Inject;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

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
    
    private long idCashbox;
    
    private WrapperPojoCashboxesDetails cashboxesDetails;

    public AllCashboxes(String key) {
        super(key);
    }
    
    @Override
    public void init() {
        initComponents();
        setMainTable(tblCashboxes);
        loadCashboxData();
        loadTargets();
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
                        GUICommons.enabledButton(btnViewDetails);
                        final var modelActives = new DefaultListModel<String>();
                        final var modelCosts = new DefaultListModel<String>();
                        lstActives.setModel(costsAndActivesHandler(cashboxFound, ActivesCostsEnum.ACTIVO, modelActives));
                        lstCosts.setModel(costsAndActivesHandler(cashboxFound, ActivesCostsEnum.PASIVO, modelCosts));
                        indicatorHandler();
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCosts)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnViewDetails))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblActives)
                        .addComponent(lblCosts))
                    .addComponent(btnViewDetails, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
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
    private javax.swing.JLabel lblActives;
    private javax.swing.JLabel lblCosts;
    private javax.swing.JLabel lblHealth;
    private javax.swing.JList<String> lstActives;
    private javax.swing.JList<String> lstCosts;
    private javax.swing.JTable tblCashboxes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToField(lblActives, String.format(getTranslateBy(KeysEnum.CASHBOXES_LBL_ACTIVES.getKey()), "0"));
        GUICommons.setTextToField(lblCosts, String.format(getTranslateBy(KeysEnum.CASHBOXES_LBL_COSTS.getKey()), "0"));
        GUICommons.setTextToButton(btnViewDetails, getTranslateBy(KeysEnum.CASHBOXES_BTN_VIEW_DETAILS.getKey()));
        GUICommons.disabledButton(btnViewDetails);
        GUICommons.setTextToButton(btnViewGraphic, getTranslateBy(KeysEnum.CASHBOXES_BTN_GRAPHICS.getKey()));
    }
}
