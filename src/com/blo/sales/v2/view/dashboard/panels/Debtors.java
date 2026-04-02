package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IDebtorsController;
import com.blo.sales.v2.controller.ISalesController;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.dialogs.PaymentCardDialog;
import com.blo.sales.v2.view.mappers.DebtorMapper;
import com.blo.sales.v2.view.mappers.PojoPaymentTypeInfoMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoDebtorsDetailsMapper;
import com.blo.sales.v2.view.pojos.PojoDebtorDetail;
import com.blo.sales.v2.view.pojos.PojoPaymentTypeInfo;
import com.blo.sales.v2.view.pojos.WrapperPojoDebtorsDetails;
import com.blo.sales.v2.view.pojos.enums.PaymentTypeEnum;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public final class Debtors extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(Debtors.class.getName());
    
    @Inject
    private IDebtorsController debtors;
    
    @Inject
    private WrapperPojoDebtorsDetailsMapper debtorsDetailsMapper;
    
    @Inject
    private ISalesController salesController;
    
    @Inject
    private PojoPaymentTypeInfoMapper paymentTypeInfoMapper;
    
    /** deudor seleccionado para hacer operaciones */
    private PojoDebtorDetail debtorSelected;
    
    /** variable para poder guardar siempre el total como respaldo */
    private BigDecimal storeTotalSale;
    
    public Debtors(String key) {
        super(key);
    }
    
    private WrapperPojoDebtorsDetails retrieveDebtorsDetails() throws BloSalesV2Exception {
        return debtorsDetailsMapper.toOuter(debtors.getDebtorsDetails());
    }
    
    private void loadDataAndTitles() throws BloSalesV2Exception {
        final String[] titles = {"ID", "Nombre", "Debe", "Timestamp"};
        GUICommons.loadTitleOnTable(tblDebtors, titles, false);
        final var allDebtors = retrieveDebtorsDetails();
        final var model = (DefaultTableModel) tblDebtors.getModel();
        if (allDebtors.getDebtors() != null && !allDebtors.getDebtors().isEmpty()) {
            final var debtorsFilter = allDebtors.getDebtors().stream().collect(Collectors.toMap(
                    PojoDebtorDetail::getName, // Clave para identificar duplicados
                    obj -> obj,// El objeto en sí
                    (existente, reemplazo) -> existente // Si hay duplicado, se queda con el primero
            ))
                    .values()
                    .stream()
                    .collect(Collectors.toList());
            for(final var d: debtorsFilter) {
                final Object[] row = {
                    d.getIdDebtor(),
                    d.getName(),
                    d.getDebt(),
                    parserTimestamp(d.getTimestamp())
                };
                model.addRow(row);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDebtors = new javax.swing.JTable();
        txtSearchDebtor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        nmbPay = new javax.swing.JTextField();
        btnPayall = new javax.swing.JButton();
        lblAddPartialPay = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        lblDebt = new javax.swing.JLabel();
        cmbxPaymentType = new javax.swing.JComboBox<>();
        lblPaymentType = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaPayments = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList<>();

        tblDebtors.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDebtors);

        txtSearchDebtor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDebtorKeyReleased(evt);
            }
        });

        nmbPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nmbPayKeyReleased(evt);
            }
        });

        btnPayall.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPayall.setText("pagar todo");
        btnPayall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayallActionPerformed(evt);
            }
        });

        lblAddPartialPay.setText("abonar");

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblPaymentType.setText("tipo_de_pago");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(192, 192, 192)
                        .addComponent(btnPayall))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDebt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nmbPay, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddPartialPay))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPaymentType)
                            .addComponent(cmbxPaymentType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDebt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddPartialPay)
                    .addComponent(lblPaymentType))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nmbPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxPaymentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPayall, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        areaPayments.setEditable(false);
        areaPayments.setColumns(20);
        areaPayments.setRows(5);
        jScrollPane2.setViewportView(areaPayments);

        jScrollPane3.setViewportView(lstProducts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearchDebtor, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchDebtor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchDebtorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDebtorKeyReleased
        final var filter = txtSearchDebtor.getText();
        GUICommons.addFilter(tblDebtors, "(?i)", filter);
    }//GEN-LAST:event_txtSearchDebtorKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            final var payment = GUICommons.getNumberFromJText(nmbPay, GUICommons.DIGITS_OF_CURRENCY);
            debtors.addPayment(payment, getUserData().getIdUser(), debtorSelected.getIdDebtor());
            loadDataAndTitles();
            disabledButtons();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void nmbPayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nmbPayKeyReleased
        try {
            final var partialPay = GUICommons.getTextFromField(nmbPay, false);
            if (GUICommons.isEmptyFieldByKeyEvt(evt, partialPay.isBlank())) {
                GUICommons.setTextToField(lblDebt, String.format(getTranslateBy(KeysEnum.DEBTORS_LBL_DEBTOR_DEBT.getKey()), debtorSelected.getDebt()));
            }
            if (
                    !partialPay.isBlank() &&
                    BloSalesV2Utils.validateTextWithPattern(BloSalesV2Utils.CURRENCY_REGEX, partialPay)
                ) {
                GUICommons.setTextToField(lblDebt, String.format(getTranslateBy(KeysEnum.DEBTORS_LBL_DEBTOR_DEBT.getKey()), (debtorSelected.getDebt().subtract(new BigDecimal(partialPay)))));
            }
        } catch(BloSalesV2Exception e) { }
    }//GEN-LAST:event_nmbPayKeyReleased

    private void btnPayallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayallActionPerformed
        try {
            if (CommonAlerts.showConfirmDialog(getTranslateBy(KeysEnum.DEBTORS_DLG_PAY_ALL.getKey()), getTranslateBy(KeysEnum.COMMON_ALERT_WARNING.getKey()))) {
                debtors.addPayment(debtorSelected.getDebt(), getUserData().getIdUser(), debtorSelected.getIdDebtor());
                loadDataAndTitles();
                disabledButtons();
            }
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnPayallActionPerformed

    private void disabledButtons() {
        debtorSelected = null;
        storeTotalSale = BigDecimal.ZERO;
        GUICommons.disabledButton(btnSave);
        GUICommons.disabledButton(btnPayall);
        GUICommons.setTextToField(txtName, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(nmbPay, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(areaPayments, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(lstProducts);
        GUICommons.setTextToField(lblDebt, BloSalesV2Utils.EMPTY_STRING);
    }
    
    private void enabledButtons() {
        GUICommons.enabledButton(btnSave);
        GUICommons.enabledButton(btnPayall);
    }
    
    private void selectADebtor(long idDebtor) {
        try {
            final var debtorDetail = retrieveDebtorsDetails().getDebtors().stream().
                    filter(d -> d.getIdDebtor() == idDebtor)
                    .collect(Collectors.toList());
        
            GUICommons.setTextToField(nmbPay, BloSalesV2Utils.EMPTY_STRING);
            if (debtorDetail != null && !debtorDetail.isEmpty()) {
                debtorSelected = debtorDetail.get(0);
                areaPayments.setText(BloSalesV2Utils.EMPTY_STRING);
                GUICommons.setTextToField(txtName, debtorSelected.getName());
                GUICommons.setTextToField(lblDebt, String.format(getTranslateBy(KeysEnum.DEBTORS_LBL_DEBTOR_DEBT.getKey()), debtorSelected.getDebt()));
                Arrays.stream(debtorSelected.getPayments().split(BloSalesV2Utils.SEPARATOR_PAYMENTS)).forEach(p -> {
                    final var arrayTimes = p.split(BloSalesV2Utils.TIMESTAMP);
                    if (arrayTimes.length == 2) {
                        final var pay = arrayTimes[0];
                        final var timestamp = parserTimestamp(arrayTimes[1]);
                        areaPayments.append(String.format("%s - %s \n", pay, timestamp));
                    }
                });
                final var model = new DefaultListModel<String>();
                debtorDetail.forEach(d -> model.addElement(String.format("%s - %s [%s]", d.getProduct(), d.getQuantitySale(), parserTimestamp(d.getTimestamp()))));
                lstProducts.setModel(model);
                enabledButtons();
                storeTotalSale = debtorSelected.getDebt();
            }
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
     private void loadPaymentsType() {
        final var paymentsTypeModel = new DefaultComboBoxModel<String>();
        PaymentTypeEnum.getVisiblesTypes().forEach(c -> paymentsTypeModel.addElement(c.getPaymentTypeTarget()));
        cmbxPaymentType.setModel(paymentsTypeModel);
    }
     
     /** abre la ventana para pagos por tarjeta */
    private void openPaymentCard(int item) {
        if (item == 1) {
            GUICommons.disabledButton(btnSave);
            GUICommons.disabledButton(btnPayall);
            final var totalDebt = debtorSelected.getDebt().
                    multiply(new BigDecimal("1.05")).
                    setScale(2, RoundingMode.HALF_UP);
            GUICommons.setTextToField(lblDebt, String.format(getTranslateBy(KeysEnum.DEBTORS_LBL_DEBTOR_DEBT.getKey()), totalDebt));
            
            final PaymentCardDialog<Map<String, Object>>[] paymentWrapper = new PaymentCardDialog[1];
            
            paymentWrapper[0] = new PaymentCardDialog<>(
                this,
                getTranslateBy(KeysEnum.COMMON_TTL_PAYMENT_BY_CARD.getKey()),
                totalDebt,
                (Map<String, Object> infoPay) -> {
                    try {
                        infoPay.values().removeIf(Objects::isNull);
                        if (infoPay.isEmpty() || infoPay.size() != 4) {
                            throw new BloSalesV2Exception(BloSalesV2Utils.COMMON_RULE_CODE, BloSalesV2Utils.COMMON_RULE);
                        }
                        var cardPay = new BigDecimal(String.valueOf(infoPay.get(PaymentCardDialog.CARD_PAY)));
                        var cash = new BigDecimal(String.valueOf(infoPay.get(PaymentCardDialog.CASH)));
                        final var reference = String.valueOf(infoPay.get(PaymentCardDialog.REFERENCE));
                        final var type = PaymentTypeEnum.getByIndex(
                            Integer.parseInt(String.valueOf(infoPay.get(PaymentCardDialog.TYPE)))
                        );
                        var paysAdded = cardPay.add(cash);
                        /** actualiza la deuda por el pago con tarjeta */
                        final var debtorFound = debtors.getDebtorById(debtorSelected.getIdDebtor());
                        debtorFound.setDebt(totalDebt);
                        debtors.updateDebtor(debtorFound, debtorSelected.getIdDebtor());
                        /** si el tipo es 'ambos' entonces el cash será la resta de la deuda menos el pago con tarjeta */
                        if (type.compareTo(PaymentTypeEnum.BOTH) == 0) {
                            cash = totalDebt.subtract(cardPay);
                        }
                        
                        final var registeredSale = debtors.addPayment(paysAdded, getUserData().getIdUser(), debtorSelected.getIdDebtor());
                        final var paymentTypeAux = new PojoPaymentTypeInfo();
                        paymentTypeAux.setCardPay(cardPay);
                        paymentTypeAux.setCash(cash);
                        paymentTypeAux.setReference(reference);
                        paymentTypeAux.setPaymentType(type);
                        paymentTypeAux.setTotalToPay(paysAdded);
                        paymentTypeAux.setIdSale(registeredSale.getIdSale());
                        salesController.registerPaymentTypeData(paymentTypeInfoMapper.toInner(paymentTypeAux));
                        
                        loadDataAndTitles();
                        disabledButtons();
                        
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
            GUICommons.enabledButton(btnSave);
            GUICommons.enabledButton(btnPayall);
            return;
        }
        /** se restaura la venta */
        debtorSelected.setDebt(storeTotalSale);
        GUICommons.setTextToField(lblDebt, String.format(getTranslateBy(KeysEnum.DEBTORS_LBL_DEBTOR_DEBT.getKey()), debtorSelected.getDebt()));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaPayments;
    private javax.swing.JButton btnPayall;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbxPaymentType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAddPartialPay;
    private javax.swing.JLabel lblDebt;
    private javax.swing.JLabel lblPaymentType;
    private javax.swing.JList<String> lstProducts;
    private javax.swing.JTextField nmbPay;
    private javax.swing.JTable tblDebtors;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearchDebtor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToField(lblAddPartialPay, getTranslateBy(KeysEnum.DEBTORS_LBL_ADD_PAY.getKey()));
        GUICommons.setTextToButton(btnSave, getTranslateBy(KeysEnum.COMMON_BTN_SAVE.getKey()));
        GUICommons.setTextToButton(btnPayall, getTranslateBy(KeysEnum.DEBTORS_BTN_PAY_ALL.getKey()));
        GUICommons.setTextToField(lblPaymentType, getTranslateBy(KeysEnum.COMMON_LBL_PAYMENT_TYPE.getKey()));
    }

    @Override
    public void init() {
        try {
            initComponents();
            loadTargets();
            disabledButtons();
            loadDataAndTitles();
            GUICommons.addDoubleClickOnTable(tblDebtors, item -> selectADebtor((long) item));
            loadPaymentsType();
            GUICommons.addChangeEventOnComboBox(cmbxPaymentType, (Integer index) -> openPaymentCard(index));
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
}
