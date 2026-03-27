package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IMobileCompanyController;
import com.blo.sales.v2.controller.ITopUpsController;
import com.blo.sales.v2.controller.impl.MobileCompanyControllerImpl;
import com.blo.sales.v2.controller.impl.TopUpsControllerImpl;
import com.blo.sales.v2.controller.pojos.enums.TopUpSearchStatusIntEnum;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.mappers.PojoTopUpMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoMobilesCompaniesMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoTopUpsMapper;
import com.blo.sales.v2.view.pojos.PojoLoggedInUser;
import com.blo.sales.v2.view.pojos.PojoTopUp;
import com.blo.sales.v2.view.pojos.enums.TopUpSearchStatusEnum;
import java.math.BigDecimal;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public final class TopUps extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(TopUps.class.getName());
    
    private static final String[] titles = {"ID", "Número telefónico", "Compañía", "Monto", "Usuario", "Timestamp"};
    
    private static final IMobileCompanyController mobileController = MobileCompanyControllerImpl.getInstance();
    
    private static final ITopUpsController topUpsController = TopUpsControllerImpl.getInstance();
    
    private static final PojoTopUpMapper topUpMapper = PojoTopUpMapper.getInstance();
    
    private static final WrapperPojoTopUpsMapper wrapperPojoTopUp = WrapperPojoTopUpsMapper.getInstance();
    
    private static final WrapperPojoMobilesCompaniesMapper wrapperCompaniesMapper = WrapperPojoMobilesCompaniesMapper.getInstance();
    
    private BigDecimal topUpsTotal;
            
    private PojoLoggedInUser userData;

    public TopUps(PojoLoggedInUser userData, String key) {
        super(key);
        this.userData = userData;
        topUpsTotal = BigDecimal.ZERO;
        initComponents();
        GUICommons.loadTitleOnTable(tblResults, titles, false);
        loadTargets();
        retrieveCompanies();
        setTextToFilter();
        GUICommons.hiddenElement(btnCloseTopUps);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabTopUps = new javax.swing.JTabbedPane();
        pnlDoToUp = new javax.swing.JPanel();
        cmbxCompanyPhone = new javax.swing.JComboBox<>();
        lblCompanyPhone = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        nmbAmount = new javax.swing.JTextField();
        lblAmount = new javax.swing.JLabel();
        pnlShowToUp = new javax.swing.JPanel();
        cmbxFilter = new javax.swing.JComboBox<>();
        btnFilterApply = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResults = new javax.swing.JTable();
        btnCloseTopUps = new javax.swing.JButton();
        lblTotalAmount = new javax.swing.JLabel();

        lblCompanyPhone.setText("company_phone");

        lblPhoneNumber.setText("numero_telefonico");

        txtPhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneNumberKeyReleased(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        nmbAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nmbAmountKeyPressed(evt);
            }
        });

        lblAmount.setText("monto_recarga");

        javax.swing.GroupLayout pnlDoToUpLayout = new javax.swing.GroupLayout(pnlDoToUp);
        pnlDoToUp.setLayout(pnlDoToUpLayout);
        pnlDoToUpLayout.setHorizontalGroup(
            pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoToUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCompanyPhone)
                    .addComponent(cmbxCompanyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneNumber))
                .addGap(18, 18, 18)
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nmbAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAmount))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(796, Short.MAX_VALUE))
        );
        pnlDoToUpLayout.setVerticalGroup(
            pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoToUpLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDoToUpLayout.createSequentialGroup()
                        .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCompanyPhone)
                            .addComponent(lblPhoneNumber)
                            .addComponent(lblAmount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDoToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbxCompanyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nmbAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(655, Short.MAX_VALUE))
        );

        tabTopUps.addTab("Hacer recarga", pnlDoToUp);

        btnFilterApply.setText("aplicar_filtro");
        btnFilterApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterApplyActionPerformed(evt);
            }
        });

        tblResults.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblResults);

        btnCloseTopUps.setText("cerrar_todo");
        btnCloseTopUps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTopUpsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlShowToUpLayout = new javax.swing.GroupLayout(pnlShowToUp);
        pnlShowToUp.setLayout(pnlShowToUpLayout);
        pnlShowToUpLayout.setHorizontalGroup(
            pnlShowToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShowToUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFilterApply)
                .addGap(18, 18, 18)
                .addComponent(lblTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCloseTopUps)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
        );
        pnlShowToUpLayout.setVerticalGroup(
            pnlShowToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShowToUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlShowToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlShowToUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFilterApply)
                        .addComponent(btnCloseTopUps)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabTopUps.addTab("Ver recargas hechas", pnlShowToUp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabTopUps)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabTopUps)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            final var amount = GUICommons.getNumberFromJText(nmbAmount, 0);
            final var phoneNmb = GUICommons.getTextFromField(txtPhoneNumber, true);
            BloSalesV2Utils.validateRule(
                phoneNmb.length() != 10,
                BloSalesV2Utils.CODE_INVALID_PHONE_NUMBER,
                BloSalesV2Utils.ERROR_INVALID_PHONE_NUMBER
            );
            final var companySelected = GUICommons.getValueFromComboBox(cmbxCompanyPhone);
            final var idCompany = companySelected.split("\\s+")[0];
            final var topUpData = new PojoTopUp();
            topUpData.setAmount(amount);
            topUpData.setChecked(false);
            topUpData.setFkMobileCompany(null);
            topUpData.setFkUser(userData);
            topUpData.setPhoneNumber(phoneNmb);
            topUpData.setTimestamp(BloSalesV2Utils.getTimestamp());
            topUpsController.addTopUp(topUpMapper.toInner(topUpData), Long.parseLong(idCompany));
            GUICommons.setTextToField(nmbAmount, BloSalesV2Utils.EMPTY_STRING);
            GUICommons.setTextToField(txtPhoneNumber, BloSalesV2Utils.EMPTY_STRING);
            GUICommons.disabledButton(btnSave);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPhoneNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumberKeyReleased
        try {
            final var txt = GUICommons.getTextFromField(txtPhoneNumber, false);
            if (GUICommons.isEmptyFieldByKeyEvt(evt, txt.isBlank())) {
                GUICommons.disabledButton(btnSave);
                return;
            }
            GUICommons.enabledButton(btnSave);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_txtPhoneNumberKeyReleased

    private void nmbAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nmbAmountKeyPressed
        try {
            final var txt = GUICommons.getTextFromField(nmbAmount, false);
            if (GUICommons.isEmptyFieldByKeyEvt(evt, txt.isBlank())) {
                GUICommons.disabledButton(btnSave);
                return;
            }
            GUICommons.enabledButton(btnSave);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_nmbAmountKeyPressed

    private void btnFilterApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterApplyActionPerformed
        try {
            topUpsTotal = BigDecimal.ZERO;
            final var filterSelected = cmbxFilter.getSelectedItem();
            final var filterEnum = Arrays.asList(TopUpSearchStatusEnum.values()).stream().
                    filter(c -> c.getTarget().equals(filterSelected)).
                    findFirst().
                    orElse(TopUpSearchStatusEnum.ALL);
            final var topUpsFound = topUpsController.getTopUpsByStatus(TopUpSearchStatusIntEnum.valueOf(filterEnum.name()));
            final var model = getModel();
            GUICommons.hiddenElement(btnCloseTopUps);
            GUICommons.setTextToField(lblTotalAmount, BloSalesV2Utils.EMPTY_STRING);
            model.setRowCount(0);
            if (topUpsFound.getTopUps() != null && !topUpsFound.getTopUps().isEmpty()) {
                final var parsedTopUps = wrapperPojoTopUp.toOuter(topUpsFound);
                for (final var top: parsedTopUps.getTopUps()) {
                    topUpsTotal = topUpsTotal.add(top.getAmount());
                    final Object[] row = {
                        top.getIdTopUp(),
                        top.getPhoneNumber(),
                        top.getFkMobileCompany().getMobileCompany(),
                        top.getAmount(),
                        top.getFkUser().getUsername(),
                        parserTimestamp(top.getTimestamp())
                    };
                    model.addRow(row);
                }
                tblResults.setModel(model);
                if (filterEnum.compareTo(TopUpSearchStatusEnum.NO_CHECKED) == 0) {
                    GUICommons.showElement(btnCloseTopUps);
                    GUICommons.setTextToField(lblTotalAmount, topUpsTotal);
                }
            }
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnFilterApplyActionPerformed

    private void btnCloseTopUpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTopUpsActionPerformed
        try {
            if (!CommonAlerts.showConfirmDialog(getTranslateBy(KeysEnum.TOP_UPS_DLG_SURE_CLOSE_ALL.getKey()), getTranslateBy(KeysEnum.COMMON_ALERT_WARNING.getKey()))) {
                return;
            }
            final var topUpsFound = topUpsController.getTopUpsByStatus(TopUpSearchStatusIntEnum.NO_CHECKED);
            if (topUpsFound.getTopUps() != null && !topUpsFound.getTopUps().isEmpty()) {
                topUpsController.closeTopUps(topUpsFound);
                getModel().setRowCount(0);
                GUICommons.hiddenElement(btnCloseTopUps);
            }
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnCloseTopUpsActionPerformed

    private void retrieveCompanies() {
        try {
            GUICommons.disabledButton(btnSave);
            final var companies = wrapperCompaniesMapper.toOuter(mobileController.getMobilesCompanies());
            if (companies.getCompanies() != null && !companies.getCompanies().isEmpty()) {
                final var categoryModel = new DefaultComboBoxModel<String>();
                companies.getCompanies().forEach(c -> categoryModel.addElement(String.format("%s %s", c.getIdMobileCompany(), c.getMobileCompany())));
                cmbxCompanyPhone.setModel(categoryModel);
                return;
            }
            GUICommons.disabledElement(cmbxCompanyPhone);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
    private void setTextToFilter() {
        final var statusFilter = new DefaultComboBoxModel<String>();
        for (final var filter: TopUpSearchStatusEnum.values()) {
            statusFilter.addElement(filter.getTarget());
        }
        cmbxFilter.setModel(statusFilter);
    }
    
    private DefaultTableModel getModel() {
        return (DefaultTableModel) tblResults.getModel();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseTopUps;
    private javax.swing.JButton btnFilterApply;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbxCompanyPhone;
    private javax.swing.JComboBox<String> cmbxFilter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblCompanyPhone;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JTextField nmbAmount;
    private javax.swing.JPanel pnlDoToUp;
    private javax.swing.JPanel pnlShowToUp;
    private javax.swing.JTabbedPane tabTopUps;
    private javax.swing.JTable tblResults;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToField(lblCompanyPhone, getTranslateBy(KeysEnum.TOP_UP_LBL_COMPANY_PHONE.getKey()));
        GUICommons.setTextToField(lblPhoneNumber, getTranslateBy(KeysEnum.TOP_UP_LBL_PHONE_NUMBER.getKey()));
        GUICommons.setTextToField(lblAmount, getTranslateBy(KeysEnum.TOP_UPS_LBL_AMOUNT.getKey()));
        GUICommons.setTextToButton(btnSave, getTranslateBy(KeysEnum.COMMON_BTN_SAVE.getKey()));
        GUICommons.setTextToButton(btnFilterApply, getTranslateBy(KeysEnum.TOP_UPS_BTN_APPLY_FILTER.getKey()));
        GUICommons.setTextToButton(btnCloseTopUps, getTranslateBy(KeysEnum.TOP_UPS_BTN_CLOSE_NOW.getKey()));
        GUICommons.setTextToField(lblTotalAmount, BloSalesV2Utils.EMPTY_STRING);
    }
}
