package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.dialogs.ListViewerDialog;
import com.blo.sales.v2.view.pojos.PojoCreditDebit;
import com.blo.sales.v2.view.pojos.WrapperPojoCredits;
import com.blo.sales.v2.view.pojos.enums.FilterCreditEnum;
import jakarta.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import javax.swing.DefaultComboBoxModel;
import com.blo.sales.v2.controller.ICreditsDebtsController;
import com.blo.sales.v2.controller.pojos.enums.TypeCreditDebtIntEnum;
import com.blo.sales.v2.view.pojos.enums.TypeCreditDebitEnum;
import com.blo.sales.v2.view.mappers.PojoCreditDebitMapper;
import com.google.gson.Gson;
import java.math.BigDecimal;

public final class Credits extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(Credits.class.getName());
    
    private static final String[] titles = { "ID crédito", "Monto inicial", "Se debe", "Te lo prestó", "Estatus", "Fecha de apertura", "Última actualización" };
    
    private static final PojoCreditDebitMapper CREDITS_MAPPER = PojoCreditDebitMapper.INSTANCE;
    
    private WrapperPojoCredits credits;
    
    private long idCreditSelected;
    
    private final Gson gson;
    
    @Inject
    private ICreditsDebtsController creditsController;
    
    public Credits(String key) {
        super(key);
        this.gson = new Gson();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbdCredits = new javax.swing.JTabbedPane();
        pnlViewCredits = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCredits = new javax.swing.JTable();
        cmbxFilters = new javax.swing.JComboBox<>();
        btnApplyFilter = new javax.swing.JButton();
        pnlAddPayment = new javax.swing.JPanel();
        lblAddPayment = new javax.swing.JLabel();
        nmbPayment = new javax.swing.JTextField();
        btnSavePayment = new javax.swing.JButton();
        btnCancelCredits = new javax.swing.JButton();
        pnlOpenCredit = new javax.swing.JPanel();
        txtLender = new javax.swing.JTextField();
        nmbTotal = new javax.swing.JTextField();
        lblLender = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        tblCredits.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCredits);

        btnApplyFilter.setText("aplicar_filtro");
        btnApplyFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyFilterActionPerformed(evt);
            }
        });

        lblAddPayment.setText("abonar_a_%s");

        btnSavePayment.setText("guardar");
        btnSavePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePaymentActionPerformed(evt);
            }
        });

        btnCancelCredits.setText("cancelar_credito");
        btnCancelCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelCreditsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAddPaymentLayout = new javax.swing.GroupLayout(pnlAddPayment);
        pnlAddPayment.setLayout(pnlAddPaymentLayout);
        pnlAddPaymentLayout.setHorizontalGroup(
            pnlAddPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddPaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAddPayment)
                    .addComponent(nmbPayment)
                    .addComponent(btnCancelCredits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnSavePayment)
                .addContainerGap())
        );
        pnlAddPaymentLayout.setVerticalGroup(
            pnlAddPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddPaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddPaymentLayout.createSequentialGroup()
                        .addComponent(lblAddPayment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nmbPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(btnCancelCredits))
                    .addComponent(btnSavePayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlViewCreditsLayout = new javax.swing.GroupLayout(pnlViewCredits);
        pnlViewCredits.setLayout(pnlViewCreditsLayout);
        pnlViewCreditsLayout.setHorizontalGroup(
            pnlViewCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewCreditsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlViewCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
                    .addGroup(pnlViewCreditsLayout.createSequentialGroup()
                        .addComponent(cmbxFilters, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnApplyFilter)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlViewCreditsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlAddPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlViewCreditsLayout.setVerticalGroup(
            pnlViewCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlViewCreditsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlViewCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbxFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApplyFilter))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(pnlAddPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbdCredits.addTab("Ver créditos", pnlViewCredits);

        lblLender.setText("a_nombre_de_quien");

        lblTotal.setText("total");

        btnSave.setText("guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpenCreditLayout = new javax.swing.GroupLayout(pnlOpenCredit);
        pnlOpenCredit.setLayout(pnlOpenCreditLayout);
        pnlOpenCreditLayout.setHorizontalGroup(
            pnlOpenCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenCreditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpenCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOpenCreditLayout.createSequentialGroup()
                        .addComponent(lblLender)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpenCreditLayout.createSequentialGroup()
                        .addComponent(txtLender, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addGroup(pnlOpenCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nmbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal))
                .addGap(55, 55, 55)
                .addComponent(btnSave)
                .addGap(0, 902, Short.MAX_VALUE))
        );
        pnlOpenCreditLayout.setVerticalGroup(
            pnlOpenCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpenCreditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpenCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlOpenCreditLayout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlOpenCreditLayout.createSequentialGroup()
                        .addGroup(pnlOpenCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLender)
                            .addComponent(lblTotal))
                        .addGap(18, 18, 18)
                        .addGroup(pnlOpenCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nmbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(491, 491, 491))
        );

        tbdCredits.addTab("Abrir crédito", pnlOpenCredit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbdCredits, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbdCredits)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            final var credit = new PojoCreditDebit();
            credit.setAmount(GUICommons.getNumberFromJText(nmbTotal, 2));
            credit.setOriginalAmount(GUICommons.getNumberFromJText(nmbTotal, 2));
            credit.setLenderDebtorName(GUICommons.getTextFromField(txtLender, true));
            credit.setFkUser(getUserData().getIdUser());
            credit.setType(TypeCreditDebitEnum.CREDIT);
            creditsController.saveCreditDebit(CREDITS_MAPPER.toInner(credit));
            CommonAlerts.openMessage(getTranslateBy(KeysEnum.COMMON_TTL_COMPLETE.getKey()), getTranslateBy(KeysEnum.COMMON_TTL_COMPLETE.getKey()));
            reset();
            loadCreditsInfo();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnApplyFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyFilterActionPerformed
        filterCredits(FilterCreditEnum.getByIndex(cmbxFilters.getSelectedIndex()));
    }//GEN-LAST:event_btnApplyFilterActionPerformed

    private void btnSavePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePaymentActionPerformed
        try {
            GUICommons.setTextToField(lblAddPayment, String.format(getTranslateBy(KeysEnum.CREDITS_LBL_ADD_PAYMENT.getKey()), idCreditSelected));
            creditsController.addPayment(GUICommons.getNumberFromJText(nmbPayment, 2), idCreditSelected);
            reset();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSavePaymentActionPerformed

    private void btnCancelCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelCreditsActionPerformed
        if (CommonAlerts.showConfirmDialog(getTranslateBy(KeysEnum.CREDITS_DLG_CANCEL_CREDIT.getKey()), getTranslateBy(KeysEnum.COMMON_ALERT_WARNING.getKey()))) {
            try {
                creditsController.deleteCreditDebit(idCreditSelected);
                reset();
            } catch (BloSalesV2Exception ex) {
                logger.error(ex.getMessage());
                CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
            }
        }
    }//GEN-LAST:event_btnCancelCreditsActionPerformed

    @Override
    protected void loadTargets() {
        GUICommons.setTextToField(lblLender, getTranslateBy(KeysEnum.CREDITS_LBL_LANDER_NAME.getKey()));
        GUICommons.setTextToField(lblTotal, getTranslateBy(KeysEnum.CREDITS_LBL_TOTAL_CREDIT.getKey()));
        GUICommons.setTextToButton(btnSave, getTranslateBy(KeysEnum.COMMON_BTN_SAVE.getKey()));
        GUICommons.setTextToButton(btnApplyFilter, getTranslateBy(KeysEnum.COMMON_BTN_APPLY_FILTER.getKey()));
        GUICommons.setTextToButton(btnSavePayment, getTranslateBy(KeysEnum.COMMON_BTN_SAVE.getKey()));
        GUICommons.setTextToButton(btnCancelCredits, getTranslateBy(KeysEnum.CREDITS_BTN_CANCEL_CREDIT.getKey()));
        GUICommons.setTextToField(lblAddPayment, BloSalesV2Utils.EMPTY_STRING);
    }

    @Override
    public void init() {
        initComponents();
        loadTargets();
        setMainTable(tblCredits);
        loadFilters();
        GUICommons.loadTitleOnTable(tblCredits, titles, false);
        reset();
        GUICommons.addDoubleClickOnTable(tblCredits, idCredit -> selectedClick((Long) idCredit));
        filterCredits(FilterCreditEnum.PENDINGS);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApplyFilter;
    private javax.swing.JButton btnCancelCredits;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSavePayment;
    private javax.swing.JComboBox<String> cmbxFilters;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddPayment;
    private javax.swing.JLabel lblLender;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField nmbPayment;
    private javax.swing.JTextField nmbTotal;
    private javax.swing.JPanel pnlAddPayment;
    private javax.swing.JPanel pnlOpenCredit;
    private javax.swing.JPanel pnlViewCredits;
    private javax.swing.JTabbedPane tbdCredits;
    private javax.swing.JTable tblCredits;
    private javax.swing.JTextField txtLender;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void reset() {
        GUICommons.setTextToField(txtLender, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(nmbTotal, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(nmbPayment, BloSalesV2Utils.EMPTY_STRING);
        idCreditSelected = 0;
        GUICommons.hiddenPanel(pnlAddPayment);
        loadCreditsInfo();
    }
    
    private void loadFilters() {
        final var filters = new DefaultComboBoxModel<String>();
        Arrays.asList(FilterCreditEnum.values()).forEach(f -> filters.addElement(f.getTarget()));
        cmbxFilters.setModel(filters);
    }
    
    /** recupera toda la información de los créditos */
    private void loadCreditsInfo() {
        try {
            credits = CREDITS_MAPPER.wrapperCreditsToOuter(creditsController.getAllCreditsByType(TypeCreditDebtIntEnum.CREDIT));
            setItemsToTable(credits.getCredits());
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
    /** aplica el filtro a los creditos sin afectar la lista original */
    private void filterCredits(FilterCreditEnum creditFilter) {
        getDefaultTableModel().setRowCount(0);
        if (credits.getCredits() != null && !credits.getCredits().isEmpty()) {
            Predicate<PojoCreditDebit> filter = c -> c.isAvailable() && !c.isPayed();
            switch (creditFilter) {
                case PAYED:
                    filter = c -> !c.isAvailable() && c.isPayed();
                    break;
                case CANCELLED:
                    filter = c -> !c.isAvailable() && !c.isPayed();
                    break;
                case PENDINGS:
                default:
                    filter = c -> c.isAvailable() && !c.isPayed();
            }
            setItemsToTable(
                    credits.getCredits().stream().
                            filter(filter).
                            toList()
            );
        }
    }
    
    private void selectedClick(long idCredit) {
        final var creditSelected = 
                credits.getCredits().stream().
                        filter(c -> c.getIdCreditDebit()== idCredit).
                        findFirst().
                        orElse(null);
        if (creditSelected != null) {
            idCreditSelected = idCredit;
            if (!creditSelected.getPayments().equals(BloSalesV2Utils.JSON_EMPTY_ARRAY)) {
                final var items = gson.fromJson(creditSelected.getPayments(), String[].class);
                final var totalAbonos = Arrays.asList(items).stream().
                        map(item -> 
                                BloSalesV2Utils.getMatcherByIndexGroup(BloSalesV2Utils.RECUPERAR_PAGO_DE_HISTORIAL_PAGOS, item, 1)).
                        map(BigDecimal::new).
                        reduce(BigDecimal.ZERO, BigDecimal::add);
                logger.info("total abonos -> %s", totalAbonos);
                
                String[] p = gson.fromJson(creditSelected.getPayments(), String[].class);
                if (p == null) {
                    p = new String[0];
                }
                // Copiar arreglo aumentando en 1 el tamaño
                String[] pagosMasAbono = Arrays.copyOf(p, p.length + 1);
                // La última posición correcta es (longitud - 1)
                pagosMasAbono[pagosMasAbono.length - 1] = "Abono total: " + totalAbonos;
                
                final var titulo = String.format(getTranslateBy(KeysEnum.CREDITS_DLG_PAYMENTS.getKey()), creditSelected.getLenderDebtorName());
                
                new ListViewerDialog(this, titulo, gson.toJson(pagosMasAbono)).setVisible(true);
            }
            GUICommons.setTextToField(lblAddPayment, String.format(getTranslateBy(KeysEnum.CREDITS_LBL_ADD_PAYMENT.getKey()), idCreditSelected));
            // pendiente
            if (creditSelected.isAvailable() && !creditSelected.isPayed()) {
                // activar panel
                GUICommons.showPanel(pnlAddPayment);
            }
        }
    }
    
    private void setItemsToTable(List<PojoCreditDebit> items) {
        getDefaultTableModel().setRowCount(0);
        if (items != null && !items.isEmpty()) {
            items.forEach(i -> {
                var status = FilterCreditEnum.PENDINGS;
                if (!i.isAvailable() && !i.isPayed()) {
                    status = FilterCreditEnum.CANCELLED;
                }
                if (!i.isAvailable() && i.isPayed()) {
                    status = FilterCreditEnum.PAYED;
                }
                final Object[] row = {
                    i.getIdCreditDebit(),
                    i.getOriginalAmount(),
                    i.getAmount(),
                    i.getLenderDebtorName(),
                    status.getTarget(),
                    parserTimestamp(i.getTimestamp()),
                    i.getUpdateDate().isBlank() ? BloSalesV2Utils.EMPTY_STRING : parserTimestamp(i.getUpdateDate())
                };
                getDefaultTableModel().addRow(row);
            });
        }
    }
    
    
}
