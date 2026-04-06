package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IDebtorsController;
import com.blo.sales.v2.controller.IProductsController;
import com.blo.sales.v2.controller.ISalesController;
import com.blo.sales.v2.controller.pojos.PojoIntSaleProductData;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.utils.BloSalesV2UtilsEnum;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.dialogs.DebtorsDialog;
import com.blo.sales.v2.view.dialogs.PaymentCardDialog;
import com.blo.sales.v2.view.dialogs.SelectorDialog;
import com.blo.sales.v2.view.mappers.DebtorMapper;
import com.blo.sales.v2.view.mappers.PojoPaymentTypeInfoMapper;
import com.blo.sales.v2.view.mappers.PojoSaleProductDataMapper;
import com.blo.sales.v2.view.mappers.WrapperDebtorsMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoProductsMapper;
import com.blo.sales.v2.view.pojos.PojoPaymentTypeInfo;
import com.blo.sales.v2.view.pojos.PojoProduct;
import com.blo.sales.v2.view.pojos.PojoSaleProductData;
import com.blo.sales.v2.view.pojos.enums.PaymentTypeEnum;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public final class Sales extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(Sales.class.getName());
    
    @Inject
    private IProductsController productsController;
    
    @Inject
    private ISalesController salesController;
    
    @Inject
    private IDebtorsController debtorsController;
    
    @Inject
    private WrapperPojoProductsMapper mapperProducts;
    
    @Inject
    private PojoSaleProductDataMapper saleProductMapper;
    
    @Inject
    private WrapperDebtorsMapper wrapperDebtorsMapper;

    @Inject
    private DebtorMapper debtorMapper;
    
    @Inject
    private PojoPaymentTypeInfoMapper paymentTypeInfoMapper;
    
    private List<PojoProduct> products;

    private BigDecimal totalSale;
    
    /** variable para poder guardar siempre el total como respaldo */
    private BigDecimal storeTotalSale;
    
    private PojoProduct productFound;
    
    public Sales(String title) {
        super(title);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTotal = new javax.swing.JLabel();
        pnlPay = new javax.swing.JPanel();
        btnComplete = new javax.swing.JButton();
        btnDebtors = new javax.swing.JButton();
        pnlCalculator = new javax.swing.JPanel();
        lblResult = new javax.swing.JLabel();
        nmbCalcPay = new javax.swing.JTextField();
        lblFastRest = new javax.swing.JLabel();
        lblPaymentType = new javax.swing.JLabel();
        cmnbxPaymentType = new javax.swing.JComboBox<>();
        pnlSearch = new javax.swing.JPanel();
        lblQuantity = new javax.swing.JLabel();
        nmbQuantity = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        lblBarCode = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductsSales = new javax.swing.JTable();

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        btnComplete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnComplete.setText("completo");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });

        btnDebtors.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDebtors.setText("incompleto");
        btnDebtors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebtorsActionPerformed(evt);
            }
        });

        lblResult.setText("jLabel1");

        nmbCalcPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nmbCalcPayKeyReleased(evt);
            }
        });

        lblFastRest.setText("resta_rapida");

        javax.swing.GroupLayout pnlCalculatorLayout = new javax.swing.GroupLayout(pnlCalculator);
        pnlCalculator.setLayout(pnlCalculatorLayout);
        pnlCalculatorLayout.setHorizontalGroup(
            pnlCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalculatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFastRest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlCalculatorLayout.createSequentialGroup()
                        .addComponent(nmbCalcPay, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(lblResult)))
                .addContainerGap())
        );
        pnlCalculatorLayout.setVerticalGroup(
            pnlCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCalculatorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblFastRest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResult)
                    .addComponent(nmbCalcPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        lblPaymentType.setText("tipo_de_pago");

        javax.swing.GroupLayout pnlPayLayout = new javax.swing.GroupLayout(pnlPay);
        pnlPay.setLayout(pnlPayLayout);
        pnlPayLayout.setHorizontalGroup(
            pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPayLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(pnlCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 509, Short.MAX_VALUE)
                .addGroup(pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPaymentType)
                    .addComponent(cmnbxPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDebtors)
                .addGap(18, 18, 18)
                .addComponent(btnComplete)
                .addContainerGap())
        );
        pnlPayLayout.setVerticalGroup(
            pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPayLayout.createSequentialGroup()
                        .addComponent(lblPaymentType)
                        .addGap(18, 18, 18)
                        .addComponent(cmnbxPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnComplete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPayLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDebtors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblQuantity.setText("cantidad");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblBarCode.setText("codigo de barras");

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nmbQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addComponent(lblBarCode)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtSearch))
                .addGap(6, 6, 6))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBarCode)
                    .addComponent(lblQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nmbQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblProductsSales.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProductsSales.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tblProductsSales);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (evt.getKeyCode() == GUICommons.ENTER_KEY) {
            try {
                final var termToSearch = GUICommons.getTextFromField(txtSearch, true);
                /** busqueda por codigo de barras */
                if (BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.ONLY_NUMBERS, termToSearch)) {
                    filterProduct(termToSearch, true);
                    addItemToList();
                }
            } catch (BloSalesV2Exception ex) {
                logger.error(ex.getMessage());
                CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
            }
            
        }
        if (evt.getKeyCode() == GUICommons.F3_SEARCH_KEY) {
            final var productsString = products.stream()
                .map(item -> item.toString())
                .collect(Collectors.toList());
               /** abre un cuadro de dialogo */
               final var dialog = new SelectorDialog<>(
                    this,
                    getTranslateBy(KeysEnum.SALES_DLG_MANUAL_SEARCH.getKey()),
                    productsString,
                    item -> {
                        filterProduct(item, false);
                        GUICommons.setTextToField(txtSearch, productFound.getProduct());
                        addItemToList();
                    });
               dialog.setVisible(true);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    /** ajustar para reiniciar lista */
    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        try {
            salesController.registerSale(totalSale, getProductData(), getUserData().getIdUser());
            disableButtons();
            GUICommons.setTextToField(lblTotal, String.format(getTranslateBy(KeysEnum.COMMON_TOTAL.getKey()), "0"));
            totalSale = BigDecimal.ZERO;
            resetFields();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void btnDebtorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebtorsActionPerformed
        try {
            final var debtors = wrapperDebtorsMapper.toOuter(debtorsController.getAllDebtors());
            final var debtorsCoopy = wrapperDebtorsMapper.toOuter(debtorsController.getAllDebtors());
            final var debtorsDialog = new DebtorsDialog<>(
                this,
                getTranslateBy(KeysEnum.SALES_DLG_DEBTORS.getKey()),
                debtors.getDebtors(),
                totalSale,
                item -> {
                    try {
                        // formato de pagos amountTIMESTAMPtimestamp, 
                        logger.info("deudor %s", String.valueOf(item));
                        var pay = BloSalesV2Utils.getFirstLastPayment(item.getPayments(), BloSalesV2UtilsEnum.LAST);
                        // es nuevo deudor  
                        if (item.getIdDebtor() == 0) {
                            salesController.registerSaleWithNewDebtor(
                                pay,
                                getProductData(),
                                getUserData().getIdUser(),
                                debtorMapper.toInner(item)
                            );
                        } else {
                            // valida que no se haya hecho un pago
                            final var debtorFound = debtorsCoopy.getDebtors().stream().
                                    filter(d -> d.getIdDebtor() == item.getIdDebtor()).
                                    findFirst().
                                    orElse(null);
                            if (debtorFound.getPayments().equals(item.getPayments())) {
                                pay = BigDecimal.ZERO;
                            }
                            salesController.registerSaleWithDebtor(
                                item.getDebt(),
                                getProductData(),
                                pay,
                                item.getPayments(),
                                getUserData().getIdUser(),
                                item.getIdDebtor());
                        }
                        resetFields();
                        totalSale = BigDecimal.ZERO;
                    } catch (BloSalesV2Exception ex) {
                        logger.error(ex.getMessage());
                        CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
                    }
                });
            debtorsDialog.setVisible(true);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnDebtorsActionPerformed

    private void nmbCalcPayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nmbCalcPayKeyReleased
        try {
            final var partialPay = GUICommons.getTextFromField(nmbCalcPay, false);
            if (GUICommons.isEmptyFieldByKeyEvt(evt, partialPay.isBlank())) {
                GUICommons.setTextToField(lblResult, String.valueOf(totalSale));
            }
            if (
                    !partialPay.isBlank() &&
                    BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.CURRENCY_REGEX, partialPay)
                ) {
                final var substract = new BigDecimal(partialPay).subtract(totalSale);
                GUICommons.setTextToField(lblResult, String.valueOf(substract));
            }
        } catch(BloSalesV2Exception e) {
        }
    }//GEN-LAST:event_nmbCalcPayKeyReleased
    
    /** abre la ventana para pagos por tarjeta */
    private void openPaymentCard(int item) {
        if (item == PaymentTypeEnum.TRANSFER.getIndex()) {
            totalSale = totalSale.
                    multiply(new BigDecimal("1.05")).
                    setScale(2, RoundingMode.HALF_UP);
            GUICommons.setTextToField(lblTotal, String.format(getTranslateBy(KeysEnum.COMMON_TOTAL.getKey()), totalSale));
            
            final PaymentCardDialog<Map<String, Object>>[] paymentWrapper = new PaymentCardDialog[1];
            
            paymentWrapper[0] = new PaymentCardDialog<>(
                this,
                getTranslateBy(KeysEnum.COMMON_TTL_PAYMENT_BY_CARD.getKey()),
                totalSale,
                (Map<String, Object> infoPay) -> {
                    try {
                        infoPay.values().removeIf(Objects::isNull);
                        if (infoPay.isEmpty() || infoPay.size() != 4) {
                            throw new BloSalesV2Exception(BloSalesV2Utils.COMMON_RULE_CODE, BloSalesV2Utils.COMMON_RULE);
                        }
                        final var cardPay = new BigDecimal(String.valueOf(infoPay.get(PaymentCardDialog.CARD_PAY)));
                        var cash = new BigDecimal(String.valueOf(infoPay.get(PaymentCardDialog.CASH)));
                        final var reference = String.valueOf(infoPay.get(PaymentCardDialog.REFERENCE));
                        final var type = PaymentTypeEnum.getByIndex(
                            Integer.parseInt(String.valueOf(infoPay.get(PaymentCardDialog.TYPE)))
                        );
                        final var paysAdded = cardPay.add(cash);
                        /** validar que los pagos no sean menor que lo que se debe pagar */
                        if (paysAdded.compareTo(totalSale) < 0) {
                            throw new BloSalesV2Exception(BloSalesV2Utils.CODE_PAYMENT_CARD_NOT_COMPLETE, BloSalesV2Utils.ERROR_PAYMENT_CARD_NOT_COMPLETE);
                        }
                        /** si el tipo es 'ambos' entonces el cash será la resta de la deuda menos el pago con tarjeta */
                        if (type.compareTo(PaymentTypeEnum.BOTH) == 0) {
                            cash = totalSale.subtract(cardPay);
                        }
                        final var paymentTypeAux = new PojoPaymentTypeInfo();
                        paymentTypeAux.setCardPay(cardPay);
                        paymentTypeAux.setCash(cash);
                        paymentTypeAux.setReference(reference);
                        paymentTypeAux.setPaymentType(type);
                        paymentTypeAux.setTotalToPay(totalSale);
                        salesController.registerPaymentTypeData(paymentTypeInfoMapper.toInner(paymentTypeAux), totalSale, getProductData(), getUserData().getIdUser());
                        /*final var registeredSale = salesController.registerSaleCommitNotEnabled(totalSale, getProductData(), getUserData().getIdUser());
                        /** se arma pago *
                        final var paymentTypeAux = new PojoPaymentTypeInfo();
                        paymentTypeAux.setCardPay(cardPay);
                        paymentTypeAux.setCash(cash);
                        paymentTypeAux.setReference(reference);
                        paymentTypeAux.setPaymentType(type);
                        paymentTypeAux.setTotalToPay(totalSale);
                        paymentTypeAux.setIdSale(registeredSale.getIdSale());
                        salesController.registerPaymentTypeData(paymentTypeInfoMapper.toInner(paymentTypeAux));*/
                        
                        disableButtons();
                        GUICommons.setTextToField(lblTotal, String.format(getTranslateBy(KeysEnum.COMMON_TOTAL.getKey()), "0"));
                        totalSale = BigDecimal.ZERO;
                        resetFields();
            
                        // 2. Usamos la referencia del arreglo para cerrar
                        if (paymentWrapper[0] != null) {
                            paymentWrapper[0].dispose();
                        }
                    } catch (BloSalesV2Exception ex) {
                        logger.error(ex.getMessage());
                        CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
                    }
                }
            );
            
            paymentWrapper[0].setVisible(true);
            return;
        }
        /** se restaura la venta */
        totalSale = storeTotalSale;
        GUICommons.setTextToField(lblTotal, String.format(getTranslateBy(KeysEnum.COMMON_TOTAL.getKey()), totalSale));
    }
    
    private void addItemToList() {
        try {
            BloSalesV2Utils.validateRule(productFound == null, BloSalesV2Utils.CODE_PRODUCT_NOT_SELECTED, BloSalesV2Utils.PRODUCT_NOT_SELECTED);
            
            final var quantity = GUICommons.getTextFromField(nmbQuantity, true);
            // valida si se puede con pesos solamente si el producto se vende por kg
            var onSaleQuantity = new BigDecimal(BigInteger.ZERO);
            var onSalePrice = new BigDecimal(BigInteger.ZERO);
            final var isSartByKg = quantity.toLowerCase().startsWith("p");
            /** valida que el producto y lo que se compra funcione si es por kg */
            BloSalesV2Utils.validateRule(isSartByKg && !productFound.isKg(), BloSalesV2Utils.CODE_PRODUCT_IS_NOT_BY_KG, BloSalesV2Utils.ERROR_PRODUCT_IS_NOT_BY_KG);
            if (isSartByKg && productFound.isKg()) {
                // Extraemos el valor numérico después de la 'P'
                final var cash = new BigDecimal(quantity.substring(1));
                final var price = productFound.getPrice();
                // 1. Calculamos la fracción de kilo (10 / 154)
                // 2. Multiplicamos por 1000 para pasar a gramos
                // 3. Redondeamos al final a 2 decimales
                onSaleQuantity = cash.divide(price, 6, RoundingMode.HALF_UP)
                    //.multiply(new BigDecimal("1000"))
                    .setScale(3, RoundingMode.HALF_UP);
                totalSale = totalSale.add(cash);
                onSalePrice = cash;
            } else {
                // Si no empieza con P, se asume que la cantidad ya es numérica (gramos o piezas)
                onSaleQuantity = new BigDecimal(quantity);
                onSalePrice = productFound.getPrice().multiply(onSaleQuantity);
                
                if (productFound.isKg()) {
                    onSalePrice = onSalePrice.setScale(2, RoundingMode.HALF_UP);
                }
                totalSale = totalSale.add(onSalePrice);
            }
            final var model = (DefaultTableModel) tblProductsSales.getModel();
            final Object[] productInfoData = {
                productFound.getIdProduct(),
                productFound.getProduct(),
                onSaleQuantity,
                productFound.getPrice(),
                onSalePrice
            };
            model.addRow(productInfoData);
            /** se almacena siempre el valor total */
            storeTotalSale = totalSale;
            GUICommons.setTextToField(txtSearch, BloSalesV2Utils.EMPTY_STRING);
            GUICommons.setTextToField(lblTotal, String.format(getTranslateBy(KeysEnum.COMMON_TOTAL.getKey()), totalSale));
            GUICommons.setTextToField(nmbQuantity, BigDecimal.ONE);
            productFound = null;
            GUICommons.enabledButton(btnComplete);
            GUICommons.enabledButton(btnDebtors);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    /**
     * filtra los productos por codigo de barras o nombre
     * @param term
     * @param isBarCode 
     */
    private void filterProduct(String term, boolean isBarCode) {
        productFound = products.stream().filter(v -> {
            if (isBarCode) {
                return v.getBarCode().equals(term);
            }
            return v.toString().contains(term);
        }).findAny().orElse(null);
    }
    
    /** AJUSTAR PARA USAR TABLA */
    private List<PojoIntSaleProductData> getProductData() {
        final var products = new ArrayList<PojoSaleProductData>();
        PojoSaleProductData productInfo;
        /** parsea los datos de una fila y crea un nuevo pojo para guardar */
        for (var i = 0; i < tblProductsSales.getRowCount(); i++) {
            // 1. Obtenemos el valor y lo limpiamos de espacios
            final var rawValue = tblProductsSales.getValueAt(i, 3).toString().trim();

            // 2. Reemplazamos la coma por punto (por si acaso el sistema usa formato latino)
            // y quitamos cualquier caracter que no sea número o punto
            final var cleanValue = rawValue.replace(",", ".");
            final var price = new BigDecimal(cleanValue);
            
            final var quantityBuy = tblProductsSales.getValueAt(i, 4).toString().trim();
            productInfo = new PojoSaleProductData();
            productInfo.setIdProduct((long) tblProductsSales.getValueAt(i, 0));
            productInfo.setQuantityOnSale(new BigDecimal(tblProductsSales.getValueAt(i, 2).toString()));
            productInfo.setPrice(price);
            productInfo.setProductBuyTotal(new BigDecimal(quantityBuy));
            products.add(productInfo);
        }
        final var productsInner = new ArrayList<PojoIntSaleProductData>();
        products.forEach(p -> productsInner.add(saleProductMapper.toInner(p)));
        return productsInner;
    }
    
    /**
     * recupera los datos de los productos de una base de datos
     * @throws BloSalesV2Exception 
     */
    private void retrieveProducts() throws BloSalesV2Exception {
        products = mapperProducts.toOuter(productsController.getAllProducts()).getProducts();
    }
    
    private void resetFields() {
        try {
            GUICommons.setTextToField(nmbQuantity, "1");
            final var model = (DefaultTableModel) tblProductsSales.getModel();
            model.setRowCount(0);
            tblProductsSales.repaint();
            GUICommons.setTextToField(lblTotal, String.format(getTranslateBy(KeysEnum.COMMON_TOTAL.getKey()), "0"));
            GUICommons.setTextToField(lblResult, totalSale);
            GUICommons.setTextToField(nmbCalcPay, BloSalesV2Utils.EMPTY_STRING);
            retrieveProducts();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
    private void addElementByKeyEnter() {
        final var model = (DefaultTableModel) tblProductsSales.getModel();
        final var indexSelected = tblProductsSales.getSelectedRow();
        if (indexSelected != -1) {
            final var filaModelo = tblProductsSales.convertRowIndexToModel(indexSelected);
            final var idProduct = Long.parseLong(model.getValueAt(filaModelo, 0).toString());
            final var productFound = products.stream().filter(p -> p.getIdProduct() == idProduct).findFirst().orElse(null);
            try {
                BloSalesV2Utils.validateRule(
                        productFound == null,
                        BloSalesV2Utils.CODE_PRODUCT_NOT_FOUND,
                        BloSalesV2Utils.PRODUCT_NOT_FOUND
                );
                // se valida que no sea por kg
                if (productFound.isKg()) {
                    CommonAlerts.openWarning(BloSalesV2Utils.PRODUCT_IS_BY_KG, getTranslateBy(KeysEnum.COMMON_ALERT_WARNING.getKey()));
                    return;
                }
                // validar que existan productos suficientes
                var quantitySale = new BigDecimal(model.getValueAt(filaModelo, 2).toString());
                // se suma uno a la actual cantidad de producto
                quantitySale = quantitySale.add(BigDecimal.ONE);
                BloSalesV2Utils.validateRule(
                        quantitySale.compareTo(productFound.getQuantity()) > 0,
                        BloSalesV2Utils.CODE_PRODUCT_INSUFFICIENT,
                        BloSalesV2Utils.PRODUCT_INSUFFICIENT
                );
                totalSale = totalSale.add(productFound.getPrice());
                GUICommons.setTextToField(lblTotal, String.format(getTranslateBy(KeysEnum.COMMON_TOTAL.getKey()), totalSale));
                // cantidad comprada col
                model.setValueAt(quantitySale, filaModelo, 2);
                //total
                final var totalProduct = productFound.getPrice().multiply(quantitySale);
                model.setValueAt(totalProduct, filaModelo, 4);
            } catch (BloSalesV2Exception ex) {
                logger.error(ex.getMessage());
                CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
            }
        }
    }
    
    /** 
     * Elimina un item de una tabla
     */
    private void removeItemFromSale(long id) {
        final var model = (DefaultTableModel) tblProductsSales.getModel();
        // elimina un item de la lista
        final var indexSelected = tblProductsSales.getSelectedRow();
        if (indexSelected != -1) {
            final var filaModelo = tblProductsSales.convertRowIndexToModel(indexSelected);
            var quantityOnSale = new BigDecimal(model.getValueAt(filaModelo, 2).toString());
            // resta una unidad al total
            final var productFound = products.stream().filter(p -> p.getIdProduct() == id).findFirst().orElse(null);
            if (!productFound.isKg()) {
                final var price = new BigDecimal(model.getValueAt(filaModelo, 3).toString());
                totalSale = totalSale.subtract(price);
                quantityOnSale = quantityOnSale.subtract(BigDecimal.ONE);
                // si la cantidad es 0 se elimina la fila
                if (quantityOnSale.compareTo(BigDecimal.ZERO) == 0) {
                    model.removeRow(indexSelected);
                } else {
                    final var totalOnSale = quantityOnSale.multiply(price);
                    model.setValueAt(quantityOnSale, filaModelo, 2);
                    model.setValueAt(totalOnSale, filaModelo, 4);
                }
            } else {
                // recuperar cantidad comprada
                final var kgSold = new BigDecimal(model.getValueAt(filaModelo, 4).toString());
                totalSale = totalSale.subtract(kgSold);
                model.removeRow(indexSelected);
            }
            GUICommons.setTextToField(lblTotal, String.format(getTranslateBy(KeysEnum.COMMON_TOTAL.getKey()), totalSale));
            if (totalSale.compareTo(BigDecimal.ZERO) == 0) {
                disableButtons();
            }
        }
    }
    
    private void loadPaymentsType() {
        final var paymentsTypeModel = new DefaultComboBoxModel<String>();
        PaymentTypeEnum.getVisiblesTypes().forEach(c -> paymentsTypeModel.addElement(c.getPaymentTypeTarget()));
        cmnbxPaymentType.setModel(paymentsTypeModel);
    }
    
    private void disableButtons() {
        GUICommons.disabledButton(btnComplete);
        GUICommons.disabledButton(btnDebtors);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnDebtors;
    private javax.swing.JComboBox<String> cmnbxPaymentType;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBarCode;
    private javax.swing.JLabel lblFastRest;
    private javax.swing.JLabel lblPaymentType;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField nmbCalcPay;
    private javax.swing.JTextField nmbQuantity;
    private javax.swing.JPanel pnlCalculator;
    private javax.swing.JPanel pnlPay;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JTable tblProductsSales;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToField(lblQuantity, getTranslateBy(KeysEnum.SALES_LBL_QUANTITY.getKey()));
        GUICommons.setTextToField(lblBarCode, getTranslateBy(KeysEnum.SALES_LBL_BAR_CODE.getKey()));
        GUICommons.setTextToButton(btnComplete, getTranslateBy(KeysEnum.SALES_BTN_COMPLETE.getKey()));
        GUICommons.setTextToButton(btnDebtors, getTranslateBy(KeysEnum.SALES_BTN_NO_COMPLETE.getKey()));
        GUICommons.setTextToField(lblTotal, String.format(getTranslateBy(KeysEnum.COMMON_TOTAL.getKey()), BigDecimal.ZERO));
        GUICommons.setTextToField(lblResult, BigDecimal.ZERO);
        GUICommons.setTextToField(lblFastRest, getTranslateBy(KeysEnum.SALES_LBL_FAST_REST.getKey()));
        GUICommons.setTextToField(lblPaymentType, getTranslateBy(KeysEnum.COMMON_LBL_PAYMENT_TYPE.getKey()));
    }

    @Override
    public void init() {
        try {
            initComponents();
            loadTargets();
            loadPaymentsType();
            totalSale = BigDecimal.ZERO;
            resetFields();
            disableButtons();
            retrieveProducts();
            final String[] titles = {"ID", "Producto", "Cantidad comprada", "Precio", "Total"};
            GUICommons.loadTitleOnTable(tblProductsSales, titles, false);
            GUICommons.addDoubleClickOnTable(tblProductsSales, id -> removeItemFromSale(Long.parseLong(String.format("%s", id))));
            GUICommons.addKeyEventOnTable(tblProductsSales, GUICommons.ENTER_KEY, id -> addElementByKeyEnter());
            GUICommons.addChangeEventOnComboBox(cmnbxPaymentType, (Integer index) -> openPaymentCard(index));
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
        txtSearch.requestFocusInWindow();
    }
}
