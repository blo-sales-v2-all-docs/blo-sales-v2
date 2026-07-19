package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.ICategoriesController;
import com.blo.sales.v2.controller.IHistoryController;
import com.blo.sales.v2.controller.IProductsController;
import com.blo.sales.v2.controller.IStockPricesHistoryController;
import com.blo.sales.v2.controller.pojos.enums.ReasonsIntEnum;
import com.blo.sales.v2.controller.pojos.enums.TypesIntEnum;
import com.blo.sales.v2.plugins.csv.BloSalesV2CSVCols;
import com.blo.sales.v2.plugins.csv.BloSalesV2CSVPlugin;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.utils.PropsKeysEnum;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.dialogs.HistoryDialog;
import com.blo.sales.v2.view.dialogs.PricesEvolutionDialog;
import com.blo.sales.v2.view.mappers.ProductMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoCategoriesMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoMovementsDetailMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoProductsMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoStockPriceHistoryMapper;
import com.blo.sales.v2.view.pojos.enums.RolesEnum;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.SwingWorker;

public final class AllProducts extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(AllProducts.class.getName());
    
    private static final String[] categoriesProtected = BloSalesV2Utils.getProp(PropsKeysEnum.APP_CATEGORIES_PROTECTED.getKey()).split(",");

    @Inject
    private IProductsController productsController;
    
    @Inject
    private IStockPricesHistoryController stockPricesHistoryController;
    
    @Inject
    private IHistoryController historyController;
    
    @Inject
    private ICategoriesController categoriesController;
    
    @Inject
    private WrapperPojoProductsMapper productsMapper;
    
    @Inject
    private ProductMapper productMapper;
    
    @Inject
    private WrapperPojoCategoriesMapper categoriesMapper;
    
    @Inject
    private WrapperPojoStockPriceHistoryMapper pricesEvolutionPriceMapper;
    
    @Inject
    private WrapperPojoMovementsDetailMapper movementsMapper;
    
    private static final String[] titles = {"ID", "Codigo de barras", "Producto", "Cantidad en existencia", "Precio", "Costo de venta", "¿Por kg?", "Categoria"};
    
    private long idProductSelected = 0L;
    
    public AllProducts(String key) {
        super(key);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        txtSearcher = new javax.swing.JTextField();
        btnDownloadStock = new javax.swing.JButton();
        pnlProductDetail = new javax.swing.JPanel();
        btnGetEvolution = new javax.swing.JButton();
        btnMovements = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblF1Instructions = new javax.swing.JLabel();
        prgsBarLoad = new javax.swing.JProgressBar();

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProducts);

        txtSearcher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearcherKeyReleased(evt);
            }
        });

        btnDownloadStock.setText("descargar_inventario_complet");
        btnDownloadStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadStockActionPerformed(evt);
            }
        });

        btnGetEvolution.setText("evolucion_de_costos");
        btnGetEvolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetEvolutionActionPerformed(evt);
            }
        });

        btnMovements.setText("movimientos");
        btnMovements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovementsActionPerformed(evt);
            }
        });

        btnCancel.setText("cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProductDetailLayout = new javax.swing.GroupLayout(pnlProductDetail);
        pnlProductDetail.setLayout(pnlProductDetailLayout);
        pnlProductDetailLayout.setHorizontalGroup(
            pnlProductDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGetEvolution)
                .addGap(18, 18, 18)
                .addComponent(btnMovements)
                .addGap(26, 26, 26)
                .addComponent(btnCancel)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        pnlProductDetailLayout.setVerticalGroup(
            pnlProductDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGetEvolution, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMovements, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblF1Instructions.setText("pulsa_la_tecla_f1_para_recuperar_informacion_detallada_del_historial_y_movimientos_del_producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1476, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearcher, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblF1Instructions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDownloadStock))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlProductDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(prgsBarLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearcher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDownloadStock)
                    .addComponent(lblF1Instructions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prgsBarLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlProductDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearcherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearcherKeyReleased
        try {
            final var filter = GUICommons.getTextFromField(txtSearcher, false);
            GUICommons.addFilter(tblProducts, "(?i)", filter);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
        
    }//GEN-LAST:event_txtSearcherKeyReleased

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        initPanelManagement();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnGetEvolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetEvolutionActionPerformed
        try {
            final var evolution = pricesEvolutionPriceMapper.toOuter(stockPricesHistoryController.getPriceFromProduct(idProductSelected));
            if (evolution.getHistory() != null && !evolution.getHistory().isEmpty()) {
                final var dialog = new PricesEvolutionDialog(this, true, evolution);
                dialog.setVisible(true);
            } else {
                CommonAlerts.openWarning(BloSalesV2Utils.NOT_PRICES_HISTORY, getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
            }
        } catch (BloSalesV2Exception e) {
            logger.error(e.getMessage());
            CommonAlerts.openError(e.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnGetEvolutionActionPerformed

    private void btnMovementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovementsActionPerformed
        try {
            final var history = historyController.getHistoryFromProduct(idProductSelected);
            if (history != null && history.getHistory() != null && !history.getHistory().isEmpty()) {
                final var historyDialog = new HistoryDialog(this, String.format(getTranslateBy(KeysEnum.STOCK_DLG_HSITORY_MOVEMENTS.getKey()), idProductSelected), movementsMapper.toOuter(history));
                historyDialog.setVisible(true);
                return;
            }
            CommonAlerts.openError(String.format(getTranslateBy(KeysEnum.STOCK_DLG_NOT_MOVEMENTS.getKey()), idProductSelected), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        } catch (BloSalesV2Exception e) {
            logger.error(e.getMessage());
            CommonAlerts.openError(e.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnMovementsActionPerformed

    private void btnDownloadStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadStockActionPerformed
        // recuperar todos los registro de la tabla
        final var bloSalesRow = new BloSalesV2CSVCols();
        final var r = new ArrayList<Object[]>();
        for (var i = 0; i < tblProducts.getRowCount(); i++) {
            final Object[] row = {
                String.valueOf(getDefaultTableModel().getValueAt(i, 0)),
                String.valueOf(getDefaultTableModel().getValueAt(i, 1)),
                String.valueOf(getDefaultTableModel().getValueAt(i, 2)),
                String.valueOf(getDefaultTableModel().getValueAt(i, 4)),
                String.valueOf(getDefaultTableModel().getValueAt(i, 5)),
                String.valueOf(getDefaultTableModel().getValueAt(i, 6)),
                String.valueOf(getDefaultTableModel().getValueAt(i, 7)),
                String.valueOf(getDefaultTableModel().getValueAt(i, 3)),
                BloSalesV2Utils.EMPTY_STRING,
                BloSalesV2Utils.EMPTY_STRING,
                BloSalesV2Utils.EMPTY_STRING
            };
            r.add(row);
        }
        bloSalesRow.setCols(r);
        final String[] headers = 
                {"ID", "Codigo de barras", "Producto", "Precio", "Costo de venta", "¿Por kg?", "Categoria",  "Cantidad en existencia", "¿Completo?", "Observaciones"};
        BloSalesV2CSVPlugin.exportFile(headers, bloSalesRow, getTranslateBy(KeysEnum.STOCK_FILE_NAME.getKey()), false);
    }//GEN-LAST:event_btnDownloadStockActionPerformed

    /** ajustar filtro de categorias */
    private void loadTitlesAndData() {
        try {
            var productsData = productsMapper.toOuter(productsController.getAllProducts()).getProducts();
            for (final var categoryProtected: categoriesProtected) {
                productsData = productsData.stream().
                        filter(p -> p.getFkCategory()!= Long.parseLong(categoryProtected)).
                        toList();
            }
            final var categories = categoriesMapper.toOuter(categoriesController.getAllCategories());
            if (getUserData().getRole().equals(RolesEnum.ROOT)) {
                GUICommons.loadTitleOnTable(tblProducts, titles, true);
                getDefaultTableModel().setRowCount(0);
                productsData.forEach(p -> {
                    /** filtro para buscar nombre de categorias */
                    final var category = categories.getCategories().stream().filter(c -> c.getIdCategory() == p.getFkCategory()).findFirst().get();
                    final Object[] row = {
                        p.getIdProduct(),
                        p.getBarCode(),
                        p.getProduct(),
                        p.getQuantity(),
                        p.getPrice(),
                        p.getCostOfSale(),
                        p.isKg() ? "SI": "NO",
                        category.getCategory()
                    };
                    getDefaultTableModel().addRow(row);
                });
            }
            
            /** cuando se cambia la fila seleccionada reinicia el panel para ver detalles */
            GUICommons.changeRowSelectedFromTable(tblProducts, (Integer nextRow) -> initPanelManagement());
            
            /** abre panel para recuperar información del producto */
            GUICommons.addEventKeyColumnsProtecteds(null, GUICommons.F1_INFO_KEY, tblProducts, (String[] data) -> {
                idProductSelected = Long.parseLong(data[0]);
                GUICommons.showPanel(pnlProductDetail);
            });
            
            /** Actualiza la fila por un <code>ENTER</code> */
            GUICommons.addEventKeyColumnsProtecteds(new int[] {0, 1, 6, 7}, GUICommons.ENTER_KEY, tblProducts, (String[] data) -> {
                new SwingWorker<Void, Integer>() {
                    
                    /** ejecuta tareas en un segundo plano */
                    @Override
                    protected Void doInBackground() throws Exception {
                        final DoUpdateProductRunneable update = new DoUpdateProductRunneable(data);
                        update.run();
                        
                        for (var i = 0; i < 100; i++) {
                            publish(i);
                            Thread.sleep(5);
                        }
                        return null;
                    }

                    /** actualiza la interfaz de usuario */
                    @Override
                    protected void process(List<Integer> chunks) {
                        int ultimoValor = chunks.get(chunks.size() - 1);
                        prgsBarLoad.setValue(ultimoValor);
                    }
                    
                    /** reincia la barra en 0 */
                    @Override
                    protected void done() {
                        prgsBarLoad.setValue(0);
                        CommonAlerts.openMessage(getTranslateBy(KeysEnum.COMMON_LBL_UPDATED_COMPLETE.getKey()), getTranslateBy(KeysEnum.COMMON_TTL_COMPLETE.getKey()));
                    }
                    
                    
                }.execute();
            });
        } catch (final BloSalesV2Exception e) {
            logger.error(e.getMessage());
            CommonAlerts.openError(e.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDownloadStock;
    private javax.swing.JButton btnGetEvolution;
    private javax.swing.JButton btnMovements;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblF1Instructions;
    private javax.swing.JPanel pnlProductDetail;
    private javax.swing.JProgressBar prgsBarLoad;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtSearcher;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToButton(btnDownloadStock, getTranslateBy(KeysEnum.STOCK_BTN_DOWNLOAD_STOCK.getKey()));
        GUICommons.setTextToButton(btnGetEvolution, getTranslateBy(KeysEnum.STOCK_BTN_COSTS_EVOLUTION.getKey()));
        GUICommons.setTextToButton(btnCancel, getTranslateBy(KeysEnum.COMMON_BTN_CANCEL.getKey()));
        GUICommons.setTextToButton(btnMovements, getTranslateBy(KeysEnum.STOCK_BTN_MOVEMENTS.getKey()));
        GUICommons.setTextToField(lblF1Instructions, getTranslateBy(KeysEnum.STOCK_LBL_F1_SEARCH.getKey()));
    }

    @Override
    public void init() {
        initComponents();
        setMainTable(tblProducts);
        loadTargets();
        loadTitlesAndData();
        initPanelManagement();
    }

    private void initPanelManagement() {
        GUICommons.hiddenPanel(pnlProductDetail);
        idProductSelected = 0L;
    }
    
    /** clase que permite ejecutar la actualización de un producto en un hilo diferente */
    class DoUpdateProductRunneable implements Runnable {
        
        private final String[] data;
        
        public DoUpdateProductRunneable(String data[]) {
            this.data = data;
        }

        @Override
        public void run() {
            try {
                logger.info("Inicia actualizacion de producto");
                    /** 
                     * 0 - ID
                     * 1 - Codigo de barras
                     * 2 - Producto
                     * 3 - Cantidad en existencia
                     * 4 - Precio
                     * 5 - Costo de venta
                     * 6 - ¿Por kg?
                     * 7 - Categoria;
                     */
                    final var streamItems = Arrays.stream(data).
                            map(d -> (String) d).
                            map(String::trim);
                    final var itemsLst = streamItems.collect(Collectors.toList());

                    final var quantity = itemsLst.get(3);
                    final var price = itemsLst.get(4);
                    final var costOfSale = itemsLst.get(5);
                    if (
                            !BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.QUANTITY_REGEX, quantity) ||
                            !BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.CURRENCY_REGEX, price) || 
                            !BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.CURRENCY_REGEX, costOfSale)
                    ) {
                        throw new BloSalesV2Exception(TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY);
                    }
                    
                    final var productFound = productMapper.toOuter(
                            productsController.getProductById(Long.parseLong(itemsLst.get(0)))
                    );
                    
                    var reason = ReasonsIntEnum.PRODUCT_NOT_MODIFIED;
                    var type = TypesIntEnum.UPDATE_PRODUCT;
                    
                    final var quantityCompared = new BigDecimal(quantity).compareTo(productFound.getQuantity());
                    
                    if (quantityCompared != 0) {
                        type = TypesIntEnum.ADJUST;
                        if (quantityCompared < 0) {
                            reason = ReasonsIntEnum.LOST;
                        } else {
                            reason = ReasonsIntEnum.REPLENISHMENT;
                        }
                        productFound.setQuantity(new BigDecimal(quantity));
                    }
                    productFound.setPrice(new BigDecimal(price));
                    productFound.setCostOfSale(new BigDecimal(costOfSale));
                    productsController.updateProductInfoSavingPriceOnHistory(
                        productMapper.toInner(productFound),
                        reason,
                        getUserData().getIdUser(),
                        type
                    );
                    initPanelManagement();
                    logger.info("producto reiniciado [%s]", idProductSelected);
                } catch (BloSalesV2Exception e) {
                    logger.error(e.getMessage());
                    CommonAlerts.openError(e.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
                }
        }
        
    }
}
