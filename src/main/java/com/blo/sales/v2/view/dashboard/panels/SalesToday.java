package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.ISalesController;
import com.blo.sales.v2.controller.pojos.enums.SalesStatusIntEnum;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.mappers.WrapperPojoSalesAndStockMapper;
import com.blo.sales.v2.view.pojos.PojoSaleAndProduct;
import com.blo.sales.v2.view.pojos.WrapperPojoSalesAndStock;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.stream.Collectors;

public final class SalesToday extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(SalesToday.class.getName());
    
    @Inject
    private ISalesController salesController;
    
    @Inject
    private WrapperPojoSalesAndStockMapper mapper;

    private static final String[] titles = {"ID de venta", "ID producto", "Producto", "Precio o comprado", "Cantidad en venta", "Total de venta", "Tipo de pago", "Timestamp"};
    
    public SalesToday(String key) {
        super(key);
    }
    
    private void loadData() {
        try {
            final var salesToday = mapper.toOuter(salesController.retrieveSalesByStatus(SalesStatusIntEnum.CLOSE));
            final var total = getTotal(salesToday);
            GUICommons.setTextToField(lblTotal, String.format(getTranslateBy(KeysEnum.COMMON_TOTAL.getKey()), total));
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
     private BigDecimal getTotal(WrapperPojoSalesAndStock wrapper) {
        GUICommons.loadTitleOnTable(tblSummary, titles, false);
        if (wrapper.getSalesDetail() == null || wrapper.getSalesDetail().isEmpty()) {
            return BigDecimal.ZERO;
        }
        getDefaultTableModel().setRowCount(0);
        wrapper.getSalesDetail().sort(Comparator.comparing(PojoSaleAndProduct::getIdSale).reversed());
        wrapper.getSalesDetail().forEach(d -> {
                final Object[] row = {
                    d.getIdSale(),
                    d.getIdProduct(),
                    d.getProduct(),
                    d.getProductTotalOnSale(),
                    d.getQuantityOnSale(),
                    d.getTotalOnSale(),
                    d.getPaymentType().getPaymentTypeTarget(),
                    parserTimestamp(d.getTimestamp())
                };
                getDefaultTableModel().addRow(row);
            });
        getDefaultTableModel().fireTableDataChanged(); 
        tblSummary.repaint();
        tblSummary.revalidate();
        return doSumFrom(wrapper);
    }
     
      /**
     * Metodo que regresa el total de una lista, filtra repetidos (idSale / totalOnSale)
     * @return 
     */
    private BigDecimal doSumFrom(WrapperPojoSalesAndStock wrapper) {
        return wrapper.getSalesDetail().stream().collect(Collectors.toMap(
                        PojoSaleAndProduct::getIdSale,
                        obj -> obj,
                        (existente, reemplazo) -> existente // Si hay duplicado, se queda con el primero
                    )).
                        values().
                        stream().
                        map(PojoSaleAndProduct::getTotalOnSale).
                        reduce(BigDecimal.ZERO, (acc, curr) -> acc.add(curr));
    }

    /**
     * Elimina una venta y solicita el motivo de baja
     * @param idSale 
     */
    private void removeSale(long idSale) {
        final var deletedAccept = CommonAlerts.showConfirmDialog(getTranslateBy(KeysEnum.SALES_TD_DLG_CANCEL_SALE.getKey()), getTranslateBy(KeysEnum.COMMON_ALERT_WARNING.getKey()));
        if (deletedAccept) {
            final var rowSelected = tblSummary.getSelectedRow();
            if (rowSelected != -1) {
                try {
                    final var model = tblSummary.getModel();
                    final var idProduct = Long.parseLong(model.getValueAt(rowSelected, 1).toString());
                    final var message = CommonAlerts.showMessageDialog(getTranslateBy(KeysEnum.SALES_TD_DLG_REASON_CANCEL.getKey()));
                    salesController.deleteSaleProduct(getUserData().getIdUser(), idSale, idProduct, message);
                    loadData();
                } catch (BloSalesV2Exception ex) {
                    logger.error(ex.getMessage());
                    CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSummary = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();

        tblSummary.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblSummary);

        lblTotal.setFont(new java.awt.Font("Adwaita Sans", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblSummary;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void init() {
        initComponents();
        setMainTable(tblSummary);
        loadData();
        GUICommons.addDoubleClickOnTable(tblSummary, id -> removeSale(Long.parseLong(String.valueOf(id))));
    }
}
