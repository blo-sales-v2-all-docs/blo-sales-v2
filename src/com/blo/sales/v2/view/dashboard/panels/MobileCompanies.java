package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IMobileCompanyController;
import com.blo.sales.v2.controller.impl.MobileCompanyControllerImpl;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.mappers.PojoMobileCompanyMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoMobilesCompaniesMapper;
import com.blo.sales.v2.view.pojos.PojoMobileCompany;
import com.blo.sales.v2.view.pojos.WrapperPojoMobilesCompanies;
import javax.swing.table.DefaultTableModel;

public final class MobileCompanies extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(MobileCompanies.class.getName());
    
    private static final IMobileCompanyController mobileController = MobileCompanyControllerImpl.getInstance();
    
    private static final WrapperPojoMobilesCompaniesMapper wrapperCompaniesMapper = WrapperPojoMobilesCompaniesMapper.getInstance();
    
    private static final PojoMobileCompanyMapper companyMapper = PojoMobileCompanyMapper.getInstance();

    private static final String[] titles = {"ID de compañía", "Compañía"};
    
    private WrapperPojoMobilesCompanies companies;
    
    public MobileCompanies(String key) {
        super(key);
        initComponents();
        loadTargets();
        handlerLockButtons(true);
        loadDataOnTable();
        GUICommons.addDoubleClickOnTable(tblCompanies, id -> setDataToForm((long) id));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompanies = new javax.swing.JTable();
        pnlCompanyCntrl = new javax.swing.JPanel();
        txtCompanyName = new javax.swing.JTextField();
        lblCompanyNam = new javax.swing.JLabel();
        lblIdCompany = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        tblCompanies.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCompanies);

        txtCompanyName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCompanyNameKeyReleased(evt);
            }
        });

        lblCompanyNam.setText("company_name");

        btnSave.setText("guardar");
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

        javax.swing.GroupLayout pnlCompanyCntrlLayout = new javax.swing.GroupLayout(pnlCompanyCntrl);
        pnlCompanyCntrl.setLayout(pnlCompanyCntrlLayout);
        pnlCompanyCntrlLayout.setHorizontalGroup(
            pnlCompanyCntrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompanyCntrlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCompanyCntrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCompanyName)
                    .addGroup(pnlCompanyCntrlLayout.createSequentialGroup()
                        .addComponent(lblCompanyNam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(lblIdCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCompanyCntrlLayout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        pnlCompanyCntrlLayout.setVerticalGroup(
            pnlCompanyCntrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompanyCntrlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCompanyCntrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCompanyNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlCompanyCntrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlCompanyCntrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlCompanyCntrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(319, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            final var companyName = GUICommons.getTextFromField(txtCompanyName, true);
            final var company = new PojoMobileCompany();
            final var companyId = GUICommons.getTextFromField(lblIdCompany, false);
            company.setMobileCompany(companyName);
            if (companyId.isBlank()) {
                mobileController.createMobileCompany(companyMapper.toInner(company));
            } else {
                mobileController.updateCompanyMobile(companyMapper.toInner(company), Long.parseLong(companyId));
            }
            refreshTable();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtCompanyNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanyNameKeyReleased
        try {
            final var txt = GUICommons.getTextFromField(txtCompanyName, false);
            if (GUICommons.isEmptyFieldByKeyEvt(evt, txt.isBlank())) {
                handlerLockButtons(true);
                return;
            }
            handlerLockButtons(false);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_txtCompanyNameKeyReleased

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        GUICommons.setTextToField(txtCompanyName, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(lblIdCompany, BloSalesV2Utils.EMPTY_STRING);
        handlerLockButtons(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void setDataToForm(long id) {
        if (companies.getCompanies() != null && !companies.getCompanies().isEmpty()) {
            final var companySelect = 
                    companies.getCompanies().stream().
                            filter(c -> c.getIdMobileCompany() == id).
                            findFirst().
                            orElse(null);
            if (companySelect != null) {
                GUICommons.setTextToField(lblIdCompany, companySelect.getIdMobileCompany());
                GUICommons.setTextToField(txtCompanyName, companySelect.getMobileCompany());
                handlerLockButtons(false);
            }
        }
    }
    
    private void refreshTable() {
        GUICommons.setTextToField(txtCompanyName, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(lblIdCompany, BloSalesV2Utils.EMPTY_STRING);
        loadDataOnTable();
        handlerLockButtons(true);
    }
    
    private void loadDataOnTable() {
        loadCompanies();
        GUICommons.loadTitleOnTable(tblCompanies, titles, false);
        if (companies.getCompanies() != null && !companies.getCompanies().isEmpty()) {
            final var model = (DefaultTableModel) tblCompanies.getModel();
            companies.getCompanies().forEach(c -> {
                final Object[] row = {
                    c.getIdMobileCompany(),
                    c.getMobileCompany()
                };
                model.addRow(row);
            });
            tblCompanies.setModel(model);
        }
    }
    
    private void loadCompanies() {
        try {
            companies = wrapperCompaniesMapper.toOuter(mobileController.getMobilesCompanies());
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
    private void handlerLockButtons(boolean isDisabled) {
        if (isDisabled) {
            GUICommons.disabledButton(btnSave);
            GUICommons.disabledButton(btnCancel);
            return;
        }
        GUICommons.enabledButton(btnSave);
        GUICommons.enabledButton(btnCancel);
    }
    
    @Override
    public void loadTargets() {
        GUICommons.setTextToField(lblCompanyNam, getTranslateBy(KeysEnum.MOBILE_COMPANIES_LBL_COMPANY_NAME.getKey()));
        GUICommons.setTextToButton(btnSave, getTranslateBy(KeysEnum.COMMON_BTN_SAVE.getKey()));
        GUICommons.setTextToButton(btnCancel, getTranslateBy(KeysEnum.COMMON_BTN_CANCEL.getKey()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCompanyNam;
    private javax.swing.JLabel lblIdCompany;
    private javax.swing.JPanel pnlCompanyCntrl;
    private javax.swing.JTable tblCompanies;
    private javax.swing.JTextField txtCompanyName;
    // End of variables declaration//GEN-END:variables

}
