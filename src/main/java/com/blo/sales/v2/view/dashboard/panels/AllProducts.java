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
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.dialogs.HistoryDialog;
import com.blo.sales.v2.view.dialogs.PricesEvolutionDialog;
import com.blo.sales.v2.view.mappers.ProductMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoCategoriesMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoMovementsDetailMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoProductsMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoStockPriceHistoryMapper;
import com.blo.sales.v2.view.pojos.PojoProduct;
import com.blo.sales.v2.view.pojos.enums.ReasonsEnum;
import com.blo.sales.v2.view.pojos.enums.RolesEnum;
import com.blo.sales.v2.view.pojos.enums.TypesEnum;
import jakarta.inject.Inject;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;

public final class AllProducts extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(AllProducts.class.getName());

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
    
    private BigDecimal currentQuantity;
    
    public AllProducts(String key) {
        super(key);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        txtSearcher = new javax.swing.JTextField();
        pnlManageProduct = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        nmbCostOfSale = new javax.swing.JTextField();
        nmbPrice = new javax.swing.JTextField();
        txtBarCode = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lstReason = new javax.swing.JComboBox<>();
        lblIdProduct = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblCostOfSale = new javax.swing.JLabel();
        lblBarCode = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        btnGetEvolution = new javax.swing.JButton();
        btnMovements = new javax.swing.JButton();
        pnlEditExistenceQuantity = new javax.swing.JPanel();
        btnDownloadStock = new javax.swing.JButton();

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

        btnSave.setText("guardar_cambios");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblProducto.setText("producto");

        lblQuantity.setText("cantidad_en_existencia");

        lblCostOfSale.setText("costo_de_venta");

        lblBarCode.setText("codigo_de_barras");

        lblPrice.setText("precio_al_publico");

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

        javax.swing.GroupLayout pnlEditExistenceQuantityLayout = new javax.swing.GroupLayout(pnlEditExistenceQuantity);
        pnlEditExistenceQuantity.setLayout(pnlEditExistenceQuantityLayout);
        pnlEditExistenceQuantityLayout.setHorizontalGroup(
            pnlEditExistenceQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        pnlEditExistenceQuantityLayout.setVerticalGroup(
            pnlEditExistenceQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlManageProductLayout = new javax.swing.GroupLayout(pnlManageProduct);
        pnlManageProduct.setLayout(pnlManageProductLayout);
        pnlManageProductLayout.setHorizontalGroup(
            pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlManageProductLayout.createSequentialGroup()
                        .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlManageProductLayout.createSequentialGroup()
                                .addComponent(pnlEditExistenceQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lstReason, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlManageProductLayout.createSequentialGroup()
                                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlManageProductLayout.createSequentialGroup()
                                        .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblIdProduct)
                                            .addComponent(lblProducto))
                                        .addGap(117, 117, 117))
                                    .addGroup(pnlManageProductLayout.createSequentialGroup()
                                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)))
                                .addComponent(btnGetEvolution)))
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addGroup(pnlManageProductLayout.createSequentialGroup()
                        .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuantity)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlManageProductLayout.createSequentialGroup()
                        .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nmbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlManageProductLayout.createSequentialGroup()
                                .addComponent(lblCostOfSale)
                                .addGap(100, 100, 100))
                            .addGroup(pnlManageProductLayout.createSequentialGroup()
                                .addComponent(nmbCostOfSale, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 99, Short.MAX_VALUE))))
                    .addGroup(pnlManageProductLayout.createSequentialGroup()
                        .addComponent(lblBarCode)
                        .addContainerGap())
                    .addGroup(pnlManageProductLayout.createSequentialGroup()
                        .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlManageProductLayout.createSequentialGroup()
                                .addComponent(btnMovements)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancel))
                            .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlManageProductLayout.setVerticalGroup(
            pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManageProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCostOfSale))
                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlManageProductLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lblIdProduct))
                    .addGroup(pnlManageProductLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nmbCostOfSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nmbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQuantity)
                            .addComponent(lblBarCode))
                        .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlManageProductLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lstReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnMovements)
                                    .addComponent(btnCancel)))
                            .addGroup(pnlManageProductLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(pnlEditExistenceQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlManageProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSave)
                                    .addComponent(btnGetEvolution))))))
                .addContainerGap())
        );

        btnDownloadStock.setText("descargar_inventario_complet");
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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearcher, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 887, Short.MAX_VALUE)
                        .addComponent(btnDownloadStock))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlManageProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearcher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDownloadStock))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlManageProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            final var newData = new PojoProduct();
            newData.setIdProduct(Long.parseLong(GUICommons.getTextFromField(lblIdProduct, true)));
            newData.setProduct(GUICommons.getTextFromField(txtName, true));
            newData.setBarCode(GUICommons.getTextFromField(txtBarCode, true));
            newData.setCostOfSale(GUICommons.getNumberFromJText(nmbCostOfSale, GUICommons.DIGITS_OF_CURRENCY));
            newData.setPrice(GUICommons.getNumberFromJText(nmbPrice, GUICommons.DIGITS_OF_CURRENCY));
            var reasonEnum = ReasonsEnum.PRODUCT_NOT_MODIFIED;
            var type = TypesEnum.UPDATE_PRODUCT;
            /** recuperar la cantidad de componente dinamico */
            var numberFromPanel = pnlEditExistenceQuantity.getComponent(0);
            if (numberFromPanel instanceof JTextField) {
                newData.setQuantity(GUICommons.getNumberFromJText((JTextField) numberFromPanel, GUICommons.DIGITS_OF_QUANTITY));
            }
            if (numberFromPanel instanceof JSpinner) {
                newData.setQuantity(GUICommons.getNumberFromComponent((JSpinner) numberFromPanel));
            }
            
            if (lstReason.isVisible()) {
                type = TypesEnum.ADJUST;
                final var reason = GUICommons.getValueFromComboBox(lstReason);
                reasonEnum = ReasonsEnum.findReasonByReason(reason);
            }
            productsController.updateProductInfoSavingPriceOnHistory(
                productMapper.toInner(newData),
                ReasonsIntEnum.valueOf(reasonEnum.name()),
                getUserData().getIdUser(),
                TypesIntEnum.valueOf(type.name()));
            GUICommons.addFilter(tblProducts, "", "");
            GUICommons.setTextToField(txtSearcher, BloSalesV2Utils.EMPTY_STRING);
            loadTitlesAndData();
            initPanelManagement();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnGetEvolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetEvolutionActionPerformed
        try {
            final var idProduct = Long.parseLong(GUICommons.getTextFromField(lblIdProduct, true));
            final var evolution = pricesEvolutionPriceMapper.toOuter(stockPricesHistoryController.getPriceFromProduct(idProduct));
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
            final var idProduct = Long.parseLong(GUICommons.getTextFromField(lblIdProduct, true));
            final var history = historyController.getHistoryFromProduct(idProduct);
            if (history != null && history.getHistory() != null && !history.getHistory().isEmpty()) {
                final var historyDialog = new HistoryDialog(this, String.format(getTranslateBy(KeysEnum.STOCK_DLG_HSITORY_MOVEMENTS.getKey()), idProduct), movementsMapper.toOuter(history));
                historyDialog.setVisible(true);
                return;
            }
            CommonAlerts.openError(String.format(getTranslateBy(KeysEnum.STOCK_DLG_NOT_MOVEMENTS.getKey()), idProduct), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
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
            final var productsData = productsMapper.toOuter(productsController.getAllProducts());
            final var categories = categoriesMapper.toOuter(categoriesController.getAllCategories());
            if (getUserData().getRole().equals(RolesEnum.ROOT)) {
                GUICommons.loadTitleOnTable(tblProducts, titles, true);
                getDefaultTableModel().setRowCount(0);
                productsData.getProducts().forEach(p -> {
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
            /** se actualiza cuando hay un cambio en algun producto */
            GUICommons.addDoubleClickOnTable(tblProducts, (Long id) -> {
                pnlManageProduct.setVisible(true);
                final var productSelected = 
                        productsData.getProducts().stream().filter(p -> p.getIdProduct() == id).findFirst().orElse(null);
                if (productSelected != null) {
                    createFieldToQuantity(pnlEditExistenceQuantity, productSelected.isKg(), productSelected.getQuantity());
                    currentQuantity = productSelected.getQuantity();
                    GUICommons.setTextToField(txtName, productSelected.getProduct());
                    GUICommons.setTextToField(txtBarCode, productSelected.getBarCode());
                    GUICommons.setTextToField(nmbCostOfSale, productSelected.getCostOfSale());
                    GUICommons.setTextToField(nmbPrice, productSelected.getPrice());
                    GUICommons.setTextToField(lblIdProduct, productSelected.getIdProduct());
                }
            });
            /** Actualiza la fila por un <code>ENTER</code> */
            GUICommons.addEventKeyColumnsProtecteds(new int[] {0, 1, 6, 7}, GUICommons.ENTER_KEY, tblProducts, (String[] data) -> {
                try {
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
                    
                    
                    /*
                    newData.setIdProduct(Long.parseLong(itemsLst.get(0)));
                    newData.setProduct(itemsLst.get(1));
                    newData.setBarCode(itemsLst.get(2));
                    newData.setQuantity(new BigDecimal(quantity));
                    newData.setPrice(new BigDecimal(price));
                    newData.setCostOfSale(new BigDecimal(costOfSale));
                    
                    final var quantityCompared = newData.getQuantity().compareTo(productFound.getQuantity());
                    
                    if (quantityCompared > 0) {
                        reason = ReasonsIntEnum.REPLENISHMENT;
                    }
                    if (quantityCompared < 0) {
                        reason = ReasonsIntEnum.LOST;
                    }
                    
                    /*if (quantityCompared == 0) {
                        productsController.updateProductInfoSavingPriceOnHistory(
                                productMapper.toInner(newData),
                                reason, 
                                getUserData().getIdUser(),
                                type
                        );
                        return;
                    }
                    type = TypesIntEnum.ADJUST;
                    if (quantityCompared > 0) {
                        reason = ReasonsIntEnum.LOST;
                    }
                    if (quantityCompared < 0) {
                        reason = ReasonsIntEnum.REPLENISHMENT;
                    }*/
                    //productsController.updateProductInfo(productMapper.toInner(newData), ReasonsIntEnum., getUserData().getIdUser(), TypesIntEnum);
                } catch (BloSalesV2Exception e) {
                    logger.error(e.getMessage());
                    CommonAlerts.openError(e.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
                }
            });
        } catch (final BloSalesV2Exception e) {
            logger.error(e.getMessage());
            CommonAlerts.openError(e.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
    /** reinicia los campos */
    private void initPanelManagement() {
        pnlManageProduct.setVisible(false);
        currentQuantity = BigDecimal.ZERO;
        /** este check estara oculto hasta que se de cambie la propiedad de cantidad */
        lstReason.setVisible(false);
        GUICommons.setTextToField(lblIdProduct, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(txtName, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(txtBarCode, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(nmbCostOfSale, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(nmbPrice, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(lblIdProduct, BloSalesV2Utils.EMPTY_STRING);
    }
    
    private void initComboBox() {
        final var categoryModel = new DefaultComboBoxModel<String>();
        ReasonsEnum.getVisiblesReasons().forEach(r -> categoryModel.addElement(r.getReasonTarget()));
        lstReason.setModel(categoryModel);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDownloadStock;
    private javax.swing.JButton btnGetEvolution;
    private javax.swing.JButton btnMovements;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBarCode;
    private javax.swing.JLabel lblCostOfSale;
    private javax.swing.JLabel lblIdProduct;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JComboBox<String> lstReason;
    private javax.swing.JTextField nmbCostOfSale;
    private javax.swing.JTextField nmbPrice;
    private javax.swing.JPanel pnlEditExistenceQuantity;
    private javax.swing.JPanel pnlManageProduct;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtBarCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearcher;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToButton(btnDownloadStock, getTranslateBy(KeysEnum.STOCK_BTN_DOWNLOAD_STOCK.getKey()));
        GUICommons.setTextToField(lblProducto, getTranslateBy(KeysEnum.STOCK_LBL_PRODUCT.getKey()));
        GUICommons.setTextToField(lblCostOfSale, getTranslateBy(KeysEnum.STOCK_LBL_COST_OF_SALE.getKey()));
        GUICommons.setTextToField(lblPrice, getTranslateBy(KeysEnum.STOCK_LBL_PRICE.getKey()));
        GUICommons.setTextToField(lblQuantity, getTranslateBy(KeysEnum.STOCK_LBL_QUANTITY.getKey()));
        GUICommons.setTextToField(lblBarCode, getTranslateBy(KeysEnum.STOCK_LBL_BAR_CODE.getKey()));
        GUICommons.setTextToButton(btnGetEvolution, getTranslateBy(KeysEnum.STOCK_BTN_COSTS_EVOLUTION.getKey()));
        GUICommons.setTextToButton(btnCancel, getTranslateBy(KeysEnum.COMMON_BTN_CANCEL.getKey()));
        GUICommons.setTextToButton(btnMovements, getTranslateBy(KeysEnum.STOCK_BTN_MOVEMENTS.getKey()));
        GUICommons.setTextToButton(btnSave, getTranslateBy(KeysEnum.COMMON_BTN_SAVE_CHANGES.getKey()));
    }

    @Override
    public void init() {
        initComponents();
        setMainTable(tblProducts);
        initComboBox();
        loadTargets();
        lblIdProduct.setVisible(false);
        loadTitlesAndData();
        initPanelManagement();
    }
    
    private void createFieldToQuantity(JPanel pnl, boolean byKg, BigDecimal quantity) {
        pnl.setLayout(new FlowLayout());
        pnl.removeAll();
        if (byKg) {
            final var field = new JTextField(15);
            GUICommons.setTextToField(field, quantity);
            field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    try {
                        reasonHandler(GUICommons.getTextFromField(field, false));
                    } catch (BloSalesV2Exception ex) { }
                }
            });
            pnl.add(field);
        } else {
            final var spinnerModel = new SpinnerNumberModel(quantity.intValue(), 0, 500, 1);
            final var spinner = new JSpinner(spinnerModel);
            spinner.addChangeListener((ChangeEvent e) -> {
                reasonHandler(String.valueOf(spinner.getValue()));
            });
            final var editor = (JSpinner.DefaultEditor) spinner.getEditor();
            editor.getTextField().addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    reasonHandler(editor.getTextField().getText());
                }
            });
            pnl.add(spinner);
        }
        pnl.revalidate();
        pnl.repaint();
    }
    
    /**
     * Metodo que controla la seleccion de la razon de cambio
     * @param tmpQuantity 
     */
    private void reasonHandler(String tmpQuantity) {
        lstReason.setVisible(true);
        if (
                tmpQuantity.isBlank() ||
                !BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.QUANTITY_REGEX, tmpQuantity)
            ) {
            lstReason.setVisible(false);
            return;
        }
            
        final var quantity = new BigDecimal(tmpQuantity.trim());
        final var quantityCompared = currentQuantity.compareTo(quantity);
        logger.info("CurrentQuantity %s tmpQuantity %s result %s", currentQuantity, tmpQuantity, quantityCompared);
        /** desactiva el combo si se modifico pero la cantidad es la misma */
        if (quantityCompared == 0) {
            lstReason.setVisible(false);
        }
        /** si la nueva cantidad es menor puede ser perdido o vendido */
        if (quantityCompared == 1) {
            logger.info("cantidad menor [%s]", String.valueOf(ReasonsEnum.LOST));
            lstReason.setSelectedIndex(ReasonsEnum.LOST.getIndex());
        }
        /** si la nueva cantidad es mayor puede ser reabastecimiento */
        if (quantityCompared == -1) {
            logger.info("cantidad mayor [%s]", String.valueOf(ReasonsEnum.REPLENISHMENT));
            lstReason.setSelectedIndex(ReasonsEnum.REPLENISHMENT.getIndex());
        }
    }
}
