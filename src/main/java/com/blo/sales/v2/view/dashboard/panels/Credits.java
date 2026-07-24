package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.ICreditsController;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.dialogs.ListViewerDialog;
import com.blo.sales.v2.view.mappers.PojoCreditMapper;
import com.blo.sales.v2.view.pojos.PojoCredit;
import com.blo.sales.v2.view.pojos.WrapperPojoCredits;
import com.blo.sales.v2.view.pojos.enums.FilterCreditEnum;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class Credits extends AbstractDashboardBase {
    
    private static final String[] titles = { "ID crédito", "Monto", "Te lo prestó", "Fecha de apertura", "Última actualización" };
    
    private static final PojoCreditMapper CREDITS_MAPPER = PojoCreditMapper.INSTANCE;
    
    private WrapperPojoCredits credits;
    
    private long idCreditSelected;
    
    @Inject
    private ICreditsController creditsController;
    
    public Credits(String key) {
        super(key);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbdCredits = new javax.swing.JTabbedPane();
        pnlOpenCredit = new javax.swing.JPanel();
        txtLender = new javax.swing.JTextField();
        nmbTotal = new javax.swing.JTextField();
        lblLender = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        pnlViewCredits = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCredits = new javax.swing.JTable();
        cmbxFilters = new javax.swing.JComboBox<>();
        btnApplyFilter = new javax.swing.JButton();
        pnlAddPayment = new javax.swing.JPanel();
        lblAddPayment = new javax.swing.JLabel();
        nmbPayment = new javax.swing.JTextField();
        btnSavePayment = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

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
                .addGroup(pnlOpenCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLender, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLender))
                .addGap(18, 18, 18)
                .addGroup(pnlOpenCreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal)
                    .addComponent(nmbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(0, 952, Short.MAX_VALUE))
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

        jButton1.setText("cancelar");

        javax.swing.GroupLayout pnlAddPaymentLayout = new javax.swing.GroupLayout(pnlAddPayment);
        pnlAddPayment.setLayout(pnlAddPaymentLayout);
        pnlAddPaymentLayout.setHorizontalGroup(
            pnlAddPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddPaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAddPayment)
                    .addComponent(nmbPayment)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
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
                        .addComponent(jButton1))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
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
                .addContainerGap(10, Short.MAX_VALUE))
        );

        tbdCredits.addTab("Ver créditos", pnlViewCredits);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbdCredits)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbdCredits)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            final var credit = new PojoCredit();
            credit.setAmount(GUICommons.getNumberFromJText(nmbTotal, 2));
            credit.setLenderName(GUICommons.getTextFromField(txtLender, true));
            credit.setFkUser(getUserData().getIdUser());
            creditsController.saveCredit(CREDITS_MAPPER.toInner(credit));
            CommonAlerts.openMessage("", getTranslateBy(KeysEnum.COMMON_TTL_COMPLETE.getKey()));
            reset();
            loadCreditsInfo();
        } catch (BloSalesV2Exception ex) {
            Logger.getLogger(Credits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnApplyFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyFilterActionPerformed
        filterCredits(FilterCreditEnum.getByIndex(cmbxFilters.getSelectedIndex()));
    }//GEN-LAST:event_btnApplyFilterActionPerformed

    private void btnSavePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePaymentActionPerformed
        try {
            creditsController.addPayment(GUICommons.getNumberFromJText(nmbPayment, 2), idCreditSelected);
            reset();
        } catch (BloSalesV2Exception ex) {
            Logger.getLogger(Credits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSavePaymentActionPerformed

    @Override
    public void loadTargets() {
        
    }

    @Override
    public void init() {
        initComponents();
        loadTargets();
        setMainTable(tblCredits);
        reset();
        loadFilters();
        GUICommons.loadTitleOnTable(tblCredits, titles, false);
        loadCreditsInfo();
        GUICommons.addDoubleClickOnTable(tblCredits, idCredit -> selectedClick((Long) idCredit));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApplyFilter;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSavePayment;
    private javax.swing.JComboBox<String> cmbxFilters;
    private javax.swing.JButton jButton1;
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

    private void reset() {
        GUICommons.setTextToField(txtLender, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(nmbTotal, BloSalesV2Utils.EMPTY_STRING);
        GUICommons.setTextToField(nmbPayment, BloSalesV2Utils.EMPTY_STRING);
        idCreditSelected = 0;
        GUICommons.hiddenPanel(pnlAddPayment);
    }
    
    private void loadFilters() {
        final var filters = new DefaultComboBoxModel<String>();
        Arrays.asList(FilterCreditEnum.values()).forEach(f -> filters.addElement(f.getTarget()));
        cmbxFilters.setModel(filters);
    }
    
    /** recupera toda la información de los créditos */
    private void loadCreditsInfo() {
        try {
            credits = CREDITS_MAPPER.wrapperCreditsToOuter(creditsController.getAllCredits());
            setItemsToTable(credits.getCredits());
        } catch (BloSalesV2Exception ex) {
            Logger.getLogger(Credits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /** aplica el filtro a los creditos sin afectar la lista original */
    private void filterCredits(FilterCreditEnum creditFilter) {
        getDefaultTableModel().setRowCount(0);
        if (credits.getCredits() != null && !credits.getCredits().isEmpty()) {
            Predicate<PojoCredit> filter = c -> c.isAvailable() && !c.isPayed();
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
                        filter(c -> c.getIdCredit() == idCredit).
                        findFirst().
                        orElse(null);
        if (creditSelected != null) {
            idCreditSelected = idCredit;
            // pagado
            if (!creditSelected.isAvailable() && creditSelected.isPayed()) {
                new ListViewerDialog(this, "", creditSelected.getPayments()).setVisible(true);
            }
            // cancelado
            if (!creditSelected.isAvailable() && !creditSelected.isPayed()) {}
            // pendiente
            if (creditSelected.isAvailable() && !creditSelected.isPayed()) {
                // activar panel
                GUICommons.showPanel(pnlAddPayment);
                new ListViewerDialog(this, "", creditSelected.getPayments()).setVisible(true);
            }
        }
    }
    
    private void setItemsToTable(List<PojoCredit> items) {
        getDefaultTableModel().setRowCount(0);
        if (items != null && !items.isEmpty()) {
            items.forEach(i -> {
                final Object[] row = {
                    i.getIdCredit(),
                    i.getAmount(),
                    i.getLenderName(),
                    parserTimestamp(i.getTimestamp()),
                    i.getUpdateDate().isBlank() ? BloSalesV2Utils.EMPTY_STRING : parserTimestamp(i.getUpdateDate())
                };
                getDefaultTableModel().addRow(row);
            });
        }
    }
    
}
