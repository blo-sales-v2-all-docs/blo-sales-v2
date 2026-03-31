package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.ICategoriesController;
import com.blo.sales.v2.controller.IProductsController;
import com.blo.sales.v2.controller.impl.CategoriesControllerImpl;
import com.blo.sales.v2.controller.impl.ProductsControllerImpl;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.mappers.ProductMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoCategoriesMapper;
import com.blo.sales.v2.view.pojos.PojoProduct;
import com.blo.sales.v2.view.utils.GUIStore;
import com.blo.sales.v2.view.utils.handler.ManagementProductStoreHandler;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public final class RegisterProduct extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(RegisterProduct.class.getName());
    
    private static final ICategoriesController categories = null;
    
    private static final ProductMapper productMapper = ProductMapper.getInstance();
    
    private static final IProductsController productsController = ProductsControllerImpl.getInstance();
    
    private static final WrapperPojoCategoriesMapper categoriesMapper = WrapperPojoCategoriesMapper.getInstance();

    public RegisterProduct(String key) {
        super(key);
        try {
            initComponents();
            loadDataForm();
            loadTargets();
            loadCategories();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBarCode = new javax.swing.JTextField();
        lblBarCode = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        nmbQuantity = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        nmbPrice = new javax.swing.JTextField();
        lblSaleCost = new javax.swing.JLabel();
        nmbSaleCost = new javax.swing.JTextField();
        chkbxItsKg = new javax.swing.JCheckBox();
        btnSave = new javax.swing.JButton();
        lstMarks = new javax.swing.JComboBox<>();

        txtBarCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBarCodeKeyReleased(evt);
            }
        });

        lblBarCode.setText("codigo_de_barras");

        lblProductName.setText("nombre");

        txtProductName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductNameKeyReleased(evt);
            }
        });

        lblQuantity.setText("cantidad_en_existencia");

        nmbQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nmbQuantityKeyReleased(evt);
            }
        });

        lblPrice.setText("precio");

        nmbPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nmbPriceKeyReleased(evt);
            }
        });

        lblSaleCost.setText("costo_de_venta");

        nmbSaleCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nmbSaleCostKeyReleased(evt);
            }
        });

        chkbxItsKg.setText("por kg");

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBarCode)
                                .addGap(49, 49, 49)
                                .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQuantity)
                                .addGap(18, 18, 18)
                                .addComponent(nmbQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPrice)
                                .addGap(18, 18, 18)
                                .addComponent(nmbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSaleCost)
                            .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nmbSaleCost, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                                .addComponent(lstMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtProductName)
                                .addGap(18, 18, 18)
                                .addComponent(chkbxItsKg)))))
                .addGap(330, 330, 330))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBarCode)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblProductName)
                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkbxItsKg)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity)
                    .addComponent(nmbQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice)
                    .addComponent(nmbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaleCost)
                    .addComponent(nmbSaleCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lstMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(464, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            final var productName = GUICommons.getTextFromField(txtProductName, true);
            final var barCode = GUICommons.getTextFromField(txtBarCode, true);
            final var quantity = GUICommons.getNumberFromJText(nmbQuantity, GUICommons.DIGITS_OF_QUANTITY);
            final var price = GUICommons.getNumberFromJText(nmbPrice, GUICommons.DIGITS_OF_CURRENCY);
            final var costOfSale = GUICommons.getNumberFromJText(nmbSaleCost, GUICommons.DIGITS_OF_CURRENCY);
            final var data = new PojoProduct();
            data.setBarCode(barCode);
            data.setCostOfSale(costOfSale);
            data.setPrice(price);
            data.setProduct(productName);
            data.setQuantity(quantity);
            /** selecciona una categoria */
            final var itemSelected = GUICommons.getValueFromComboBox(lstMarks).split("[ ]+");
            BloSalesV2Utils.validateRule(
                    itemSelected.length == 0 || itemSelected[0].trim().isBlank(),
                    BloSalesV2Utils.CODE_CATEGORY_NOT_SELECTED,
                    BloSalesV2Utils.CATEGORY_NO_SELECTED
            );
            final var idMark = itemSelected[0].trim();
            data.setFkCategory(Long.parseLong(idMark));
            data.setKg(GUICommons.isCheckedCkeckBox(chkbxItsKg));
            GUIStore.resetProductData();
            productsController.registerProduct(productMapper.toInner(data));
            GUICommons.setTextToField(txtProductName, BloSalesV2Utils.EMPTY_STRING);
            GUICommons.setTextToField(txtBarCode, BloSalesV2Utils.EMPTY_STRING);
            GUICommons.setTextToField(nmbQuantity, BloSalesV2Utils.EMPTY_STRING);
            GUICommons.setTextToField(nmbPrice, BloSalesV2Utils.EMPTY_STRING);
            GUICommons.setTextToField(nmbSaleCost, BloSalesV2Utils.EMPTY_STRING);
        } catch (BloSalesV2Exception | NumberFormatException ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtBarCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarCodeKeyReleased
        addPojoData(txtBarCode, ManagementProductStoreHandler.BAR_CODE);
    }//GEN-LAST:event_txtBarCodeKeyReleased

    private void txtProductNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductNameKeyReleased
        addPojoData(txtProductName, ManagementProductStoreHandler.PRODUCT);
    }//GEN-LAST:event_txtProductNameKeyReleased

    private void nmbQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nmbQuantityKeyReleased
        addPojoData(nmbQuantity, ManagementProductStoreHandler.QUANTITY);
    }//GEN-LAST:event_nmbQuantityKeyReleased

    private void nmbPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nmbPriceKeyReleased
        addPojoData(nmbPrice, ManagementProductStoreHandler.PRICE);
    }//GEN-LAST:event_nmbPriceKeyReleased

    private void nmbSaleCostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nmbSaleCostKeyReleased
        addPojoData(nmbSaleCost, ManagementProductStoreHandler.COST_OF_SALE);
    }//GEN-LAST:event_nmbSaleCostKeyReleased

    private void loadCategories() throws BloSalesV2Exception {
        final var categoryModel = new DefaultComboBoxModel<String>();
        
        categoriesMapper.toOuter(this.categories.getAllCategories())
                .getCategories().forEach(c -> categoryModel.addElement(c.toString()));
        
        lstMarks.setModel(categoryModel);
    }
    
    private void loadDataForm() {
        final var productStore = GUIStore.getProductData();
        setIfNotNull(productStore.getBarCode(), txtBarCode);
        setIfNotNull(productStore.getProduct(), txtProductName);
        setIfNotNull(productStore.getQuantity(), nmbQuantity);
        setIfNotNull(productStore.getPrice(), nmbPrice);
        setIfNotNull(productStore.getCostOfSale(), nmbSaleCost);
    }
    
    private void setIfNotNull(Object value, JTextField component) {
        if (value != null) {
            GUICommons.setTextToField(component, value.toString());
        }
    }
    
    private void addPojoData(JTextField field, ManagementProductStoreHandler prop) {
        try {
            final var value = GUICommons.getTextFromField(field, false);
            GUIStore.addPropOnPojoProduct(prop, value);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkbxItsKg;
    private javax.swing.JLabel lblBarCode;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSaleCost;
    private javax.swing.JComboBox<String> lstMarks;
    private javax.swing.JTextField nmbPrice;
    private javax.swing.JTextField nmbQuantity;
    private javax.swing.JTextField nmbSaleCost;
    private javax.swing.JTextField txtBarCode;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToField(lblBarCode, getTranslateBy(KeysEnum.REGISTER_PRODUCT_LBL_BAR_CODE.getKey()));
        GUICommons.setTextToField(lblProductName, getTranslateBy(KeysEnum.REGISTER_PRODUCT_LBL_NAME.getKey()));
        GUICommons.setTextToField(lblQuantity, getTranslateBy(KeysEnum.REGISTER_PRODUCT_LBL_QUANTITY.getKey()));
        GUICommons.setTextToField(lblPrice, getTranslateBy(KeysEnum.REGISTER_PRODUCT_LBL_PRICE.getKey()));
        GUICommons.setTextToField(lblSaleCost, getTranslateBy(KeysEnum.REGISTER_PRODUCT_LBL_COST_OF_SALE.getKey()));
        GUICommons.setTextToButton(btnSave, getTranslateBy(KeysEnum.COMMON_BTN_SAVE.getKey()));
        GUICommons.setTextToCheckbox(chkbxItsKg, getTranslateBy(KeysEnum.REGISTER_PRODUCT_BY_KG.getKey()));
    }
}
