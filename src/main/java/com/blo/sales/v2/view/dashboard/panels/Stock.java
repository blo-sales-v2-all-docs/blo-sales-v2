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
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.dialogs.HistoryDialog;
import com.blo.sales.v2.view.dialogs.PricesEvolutionDialog;
import com.blo.sales.v2.view.mappers.ProductMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoCategoriesMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoMovementsDetailMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoProductsMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoStockPriceHistoryMapper;
import com.blo.sales.v2.view.pojos.PojoProduct;
import com.blo.sales.v2.view.pojos.WrapperPojoProducts;
import com.blo.sales.v2.view.pojos.WrapperPojoStockPriceHistory;
import com.blo.sales.v2.view.commons.GUILogger;
import jakarta.inject.Inject;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.SwingWorker;

public final class Stock extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(Stock.class.getName());
    
    private static final String[] TITLES = {"ID", "Codigo de barras", "Producto", "Cantidad en existencia", "Precio", "Costo de venta", "¿Por kg?", "Categoria"};
    
    @Inject
    private IProductsController productsController;
    
    @Inject
    private ICategoriesController categoriesController;
    
    @Inject
    private IStockPricesHistoryController stockPricesHistoryController;
    
    @Inject
    private IHistoryController historyController;
    
    @Inject
    private WrapperPojoStockPriceHistoryMapper pricesEvolutionPriceMapper;
    
    @Inject
    private WrapperPojoProductsMapper productsMapper;
    
    @Inject
    private ProductMapper productMapper;
    
    @Inject
    private WrapperPojoCategoriesMapper categoriesMapper;
    
    @Inject
    private WrapperPojoMovementsDetailMapper movementsMapper;

    public Stock(String key) {
        super(key);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearcher = new javax.swing.JTextField();
        lblF1Instructions = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        pnlOperations = new javax.swing.JPanel();
        btnCostEvolution = new javax.swing.JButton();
        btnMovementsOfProduct = new javax.swing.JButton();
        btnCancelOperations = new javax.swing.JButton();
        btnDownloadStock = new javax.swing.JButton();
        pgrBrLoader = new javax.swing.JProgressBar();

        txtSearcher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearcherKeyReleased(evt);
            }
        });

        lblF1Instructions.setText("pulsa_la_tecla_f1_para_recuperar_informacion_detallada_del_historial_y_movimientos_del_producto");

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblStock);

        btnCostEvolution.setText("evolucion_de_costos");

        btnMovementsOfProduct.setText("movimientos");

        btnCancelOperations.setText("cancelar");
        btnCancelOperations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOperationsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOperationsLayout = new javax.swing.GroupLayout(pnlOperations);
        pnlOperations.setLayout(pnlOperationsLayout);
        pnlOperationsLayout.setHorizontalGroup(
            pnlOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOperationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCostEvolution)
                .addGap(18, 18, 18)
                .addComponent(btnMovementsOfProduct)
                .addGap(18, 18, 18)
                .addComponent(btnCancelOperations)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOperationsLayout.setVerticalGroup(
            pnlOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOperationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCostEvolution, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(btnMovementsOfProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelOperations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnDownloadStock.setText("descargar_inventario_completo");
        btnDownloadStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlOperations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pgrBrLoader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtSearcher, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblF1Instructions)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDownloadStock)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pgrBrLoader, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDownloadStock)
                    .addComponent(txtSearcher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblF1Instructions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlOperations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelOperationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelOperationsActionPerformed
        reset();
    }//GEN-LAST:event_btnCancelOperationsActionPerformed

    private void btnDownloadStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadStockActionPerformed
        // recuperar todos los registro de la tabla
        final BloSalesV2CSVCols bloSalesRow = new BloSalesV2CSVCols();
        final List<Object[]> r = new ArrayList<>();
        for (int i = 0; i < tblStock.getRowCount(); i++) {
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

    private void txtSearcherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearcherKeyReleased
        GUICommons.addFilter(tblStock, "(?i)", GUICommons.getTextFromField(txtSearcher));
    }//GEN-LAST:event_txtSearcherKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelOperations;
    private javax.swing.JButton btnCostEvolution;
    private javax.swing.JButton btnDownloadStock;
    private javax.swing.JButton btnMovementsOfProduct;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblF1Instructions;
    private javax.swing.JProgressBar pgrBrLoader;
    private javax.swing.JPanel pnlOperations;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtSearcher;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToButton(btnDownloadStock, getTranslateBy(KeysEnum.STOCK_BTN_DOWNLOAD_STOCK.getKey()));
        GUICommons.setTextToButton(btnCostEvolution, getTranslateBy(KeysEnum.STOCK_BTN_COSTS_EVOLUTION.getKey()));
        GUICommons.setTextToButton(btnCancelOperations, getTranslateBy(KeysEnum.COMMON_BTN_CANCEL.getKey()));
        GUICommons.setTextToButton(btnMovementsOfProduct, getTranslateBy(KeysEnum.STOCK_BTN_MOVEMENTS.getKey()));
        GUICommons.setTextToField(lblF1Instructions, getTranslateBy(KeysEnum.STOCK_LBL_F1_SEARCH.getKey()));
    }

    @Override
    public void init() {
        initComponents();
        GUICommons.hiddenPanel(pnlOperations);
        setMainTable(tblStock);
        loadTargets();
        GUICommons.loadTitleOnTable(tblStock, TITLES, true);
        loadStock();
        addEditStockAction();
        viewDetails();
        /** cuando se cambia la fila seleccionada reinicia el panel para ver detalles */
        GUICommons.changeRowSelectedFromTable(tblStock, (Integer nextRow) -> reset());
    }
    
    @Override
    public void reset() {
        for (MouseListener ml : btnCostEvolution.getMouseListeners()) {
            btnCostEvolution.removeMouseListener(ml);
        }
        for (MouseListener ml : btnMovementsOfProduct.getMouseListeners()) {
            btnMovementsOfProduct.removeMouseListener(ml);
        }
        GUICommons.hiddenPanel(pnlOperations);
        GUICommons.enabledComponent(txtSearcher);
    }
    
    /** abre panel para poder ver las operacioens */
    private void viewDetails() {
        GUICommons.addEventKeyColumnsProtecteds(null, GUICommons.F1_INFO_KEY, tblStock, (String[] data) -> {
            final String product = data[0];
            if (product.isBlank()) {
                return;
            }
            final long idProduct = Long.parseLong(product);
            btnCostEvolution.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        final WrapperPojoStockPriceHistory evolution = pricesEvolutionPriceMapper.toOuter(stockPricesHistoryController.getPriceFromProduct(idProduct));
                        if (evolution.getHistory() != null && !evolution.getHistory().isEmpty()) {
                            final var dialog = new PricesEvolutionDialog(Stock.this, true, evolution);
                            dialog.setVisible(true);
                        } else {
                            CommonAlerts.openWarning(BloSalesV2Utils.NOT_PRICES_HISTORY, getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
                        }
                    } catch (BloSalesV2Exception ex) {
                        Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            });
            btnMovementsOfProduct.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        final var history = historyController.getHistoryFromProduct(idProduct);
                        if (history != null && history.getHistory() != null && !history.getHistory().isEmpty()) {
                            final var historyDialog = new HistoryDialog(Stock.this, String.format(getTranslateBy(KeysEnum.STOCK_DLG_HSITORY_MOVEMENTS.getKey()), idProduct), movementsMapper.toOuter(history));
                            historyDialog.setVisible(true);
                            return;
                        }
                        CommonAlerts.openError(String.format(getTranslateBy(KeysEnum.STOCK_DLG_NOT_MOVEMENTS.getKey()), idProduct), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
                    } catch (BloSalesV2Exception ex) {
                        Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            GUICommons.showPanel(pnlOperations);
        });
    }
    
    /** metodo que permite editar el stock */
    private void addEditStockAction() {
        GUICommons.addEventKeyColumnsProtecteds(new int[] {0, 1, 6, 7}, GUICommons.ENTER_KEY, tblStock, (String[] data) -> {
            new SwingWorker<Void, Integer>() {
                    
                    /** ejecuta tareas en un segundo plano */
                    @Override
                    protected Void doInBackground() throws Exception {
                        final DoUpdateProductRunneable update = new DoUpdateProductRunneable(data);
                        update.run();
                        return null;
                    }

                    /** actualiza la interfaz de usuario */
                    @Override
                    protected void process(List<Integer> chunks) {
                        int ultimoValor = chunks.get(chunks.size() - 1);
                        pgrBrLoader.setValue(ultimoValor);
                    }
                    
                    /** reincia la barra en 0 */
                    @Override
                    protected void done() {
                        pgrBrLoader.setValue(0);
                        CommonAlerts.openMessage(getTranslateBy(KeysEnum.COMMON_LBL_UPDATED_COMPLETE.getKey()), getTranslateBy(KeysEnum.COMMON_TTL_COMPLETE.getKey()));
                        reset();
                        GUICommons.setFocusToComponent(txtSearcher);
                    }
                }.execute();
        });
    }
    
    /** carga el inventario completo */
    private void loadStock() {
        try {
            final WrapperPojoProducts allProducts = productsMapper.toOuter(productsController.getAllProducts());
            getDefaultTableModel().setRowCount(0);
            if (allProducts.getProducts() != null && !allProducts.getProducts().isEmpty()) {
                final var categories = categoriesMapper.toOuter(categoriesController.getAllCategories());
                allProducts.getProducts().forEach(p -> {
                    /** filtro para buscar nombre de categorias */
                    final var category = categories.getCategories().stream().filter(c -> c.getIdCategory() == p.getFkCategory()).findFirst().get();
                    final Object[] row = {
                        p.getIdProduct(),
                        p.getBarCode(),
                        p.getProduct(),
                        p.getQuantity(),
                        p.getPrice(),
                        p.getCostOfSale(),
                        p.isKg(),
                        category
                    };
                    getDefaultTableModel().addRow(row);
                });
            }
        } catch (BloSalesV2Exception e) {
            logger.error(e.getMessage());
            CommonAlerts.openError(e.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
     class DoUpdateProductRunneable implements Runnable {
        
        private final String[] data;
        
        public DoUpdateProductRunneable(String data[]) {
            this.data = data;
        }

        @Override
        public void run() {
            try {
                GUICommons.disabledComponent(txtSearcher);
                final List<String> dataAsList = Arrays.asList(data).stream().
                        map(String::trim).
                        collect(Collectors.toList());

                final String quantity = dataAsList.get(3);
                final String price = dataAsList.get(4);
                final String costOfSale = dataAsList.get(5);
                if (
                        !BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.QUANTITY_REGEX, quantity) ||
                        !BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.CURRENCY_REGEX, price) || 
                        !BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.CURRENCY_REGEX, costOfSale) ||
                        dataAsList.get(2).isBlank()
                ) {
                    throw new BloSalesV2Exception(BloSalesV2Utils.ERROR_IN_FIELDS_WRITTED, BloSalesV2Utils.CODE_IN_FIELDS_WRITTED);
                }
                
                final PojoProduct productFound = productMapper.toOuter(productsController.getProductById(Long.parseLong(dataAsList.get(0))));
                
                final int quantityCompared = new BigDecimal(quantity).compareTo(productFound.getQuantity());
                ReasonsIntEnum reason = ReasonsIntEnum.PRODUCT_NOT_MODIFIED;
                TypesIntEnum type = TypesIntEnum.UPDATE_PRODUCT;
                    
                if (quantityCompared != 0) {
                    type = TypesIntEnum.ADJUST;
                    if (quantityCompared < 0) {
                        reason = ReasonsIntEnum.LOST;
                    } else {
                        reason = ReasonsIntEnum.REPLENISHMENT;
                    }
                    productFound.setQuantity(new BigDecimal(quantity));
                }
                
                productFound.setProduct(dataAsList.get(2));
                productFound.setPrice(new BigDecimal(price));
                productFound.setCostOfSale(new BigDecimal(costOfSale));
                
                productsController.updateProductInfoSavingPriceOnHistory(
                    productMapper.toInner(productFound),
                    reason,
                    getUserData().getIdUser(),
                    type
                );
                reset();
                } catch (BloSalesV2Exception e) {
                    logger.error(e.getMessage());
                    CommonAlerts.openError(e.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
                }
        }
        
    }
}
