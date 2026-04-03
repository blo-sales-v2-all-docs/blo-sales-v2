package com.blo.sales.v2.view.dashboard.panels;

import com.blo.sales.v2.controller.IUserController;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntNotes;
import com.blo.sales.v2.translate.KeysEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.commons.AbstractDashboardBase;
import com.blo.sales.v2.view.commons.CommonAlerts;
import com.blo.sales.v2.view.commons.GUICommons;
import com.blo.sales.v2.view.commons.GUILogger;
import com.blo.sales.v2.view.dialogs.NoteDialog;
import com.blo.sales.v2.view.mappers.PojoNoteMapper;
import com.blo.sales.v2.view.mappers.WrapperPojoNotesMapper;
import com.blo.sales.v2.view.pojos.PojoNote;
import com.blo.sales.v2.view.pojos.enums.TypeNoteEnum;
import jakarta.inject.Inject;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public final class Notes extends AbstractDashboardBase {
    
    private static final GUILogger logger = GUILogger.getLogger(Notes.class.getName());
    
    @Inject
    private IUserController controller;
    
    @Inject
    private PojoNoteMapper noteMapper;
    
    @Inject
    private WrapperPojoNotesMapper notesMapper;
    
    private static final String[] titles = {"ID", "Nota", "Tipo", "Timestamp"};
    
    private static final String[] types_note = {"ACTIVO", "PASIVO", "OTRO"};
    
    private WrapperPojoIntNotes notes;

    public Notes(String key) {
        super(key);
    }
    
    private void openNoteDialog(long idNote) {
        final var noteSelected = notes.getNotes().stream().filter(n -> n.getIdNote() == idNote).findFirst().orElse(null);
        if (noteSelected == null) {
            return;
        }
        final var dialog = new NoteDialog<>(
            this,
            getTranslateBy(KeysEnum.NOTES_DLG_EDITING_NOTE.getKey()),
            noteMapper.toOuter(noteSelected),
            (PojoNote data) -> {
                try {
                    if (data == null) {
                        controller.deleteNote(idNote);
                    } else {
                        controller.updateNote(noteMapper.toInner(data));
                    }
                    retrieveNotes();
                } catch(BloSalesV2Exception e) {
                    logger.error(e.getMessage());
                    CommonAlerts.openError(e.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
                }
            }
        );
        dialog.setVisible(true);
    }
    
    private void loadTypesNotes() {
        final var typesModel = new DefaultComboBoxModel<String>();
        for (final var types_note1 : types_note) {
            typesModel.addElement(types_note1);
        }
        cmbxTypeNote.setModel(typesModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaNote = new javax.swing.JTextArea();
        btnSaveNow = new javax.swing.JButton();
        cmbxTypeNote = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNotes = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaInstrc = new javax.swing.JTextArea();

        areaNote.setColumns(20);
        areaNote.setRows(5);
        areaNote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areaNoteKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(areaNote);

        btnSaveNow.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSaveNow.setText("guardar nota");
        btnSaveNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSaveNow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbxTypeNote, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbxTypeNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveNow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblNotes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblNotes);

        areaInstrc.setEditable(false);
        areaInstrc.setColumns(20);
        areaInstrc.setRows(5);
        jScrollPane3.setViewportView(areaInstrc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void areaNoteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaNoteKeyReleased
        try {
            final var txt = GUICommons.getTextFromField(areaNote, false);
            if (GUICommons.isEmptyFieldByKeyEvt(evt, txt.isBlank())) {
                GUICommons.disabledButton(btnSaveNow);
                return;
            }
            GUICommons.enabledButton(btnSaveNow);
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_areaNoteKeyReleased

    private void btnSaveNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNowActionPerformed
        try {
            final var txt = GUICommons.getTextFromField(areaNote, true);
            final var itemSelected = GUICommons.getValueFromComboBox(cmbxTypeNote).trim();
            BloSalesV2Utils.validateRule(
                    itemSelected.isBlank(),
                    BloSalesV2Utils.CODE_NOTE_TYPE_NO_SELECTED,
                    BloSalesV2Utils.NOTE_TYPE_NO_SELECTED
            );
            final var noteType = TypeNoteEnum.valueOf(itemSelected);
            final var data = new PojoNote();
            data.setFkUser(getUserData().getIdUser());
            data.setNote(txt);
            data.setTimesamp(BloSalesV2Utils.getTimestamp());
            data.setTypeNote(noteType);
            controller.addNote(noteMapper.toInner(data));
            GUICommons.setTextToField(areaNote, BloSalesV2Utils.EMPTY_STRING);
            GUICommons.disabledButton(btnSaveNow);
            retrieveNotes();
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }//GEN-LAST:event_btnSaveNowActionPerformed

    private void retrieveNotes() {
        try {
            notes = controller.getNotesByUserId(getUserData().getIdUser());
            final var wrapper = notesMapper.toOuter(notes);
            if (wrapper.getNotes() != null && !wrapper.getNotes().isEmpty()) {
                final var model = (DefaultTableModel) tblNotes.getModel();
                model.setRowCount(0);
                wrapper.getNotes().forEach(n -> {
                    final Object[] row = {
                        n.getIdNote(),
                        n.getNote(),
                        n.getTypeNote().name(),
                        parserTimestamp(n.getTimesamp())
                    };
                    model.addRow(row);
                });
                tblNotes.setModel(model);
            }
        } catch (BloSalesV2Exception ex) {
            logger.error(ex.getMessage());
            CommonAlerts.openError(ex.getMessage(), getTranslateBy(KeysEnum.COMMON_ALERT_ERROR.getKey()));
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaInstrc;
    private javax.swing.JTextArea areaNote;
    private javax.swing.JButton btnSaveNow;
    private javax.swing.JComboBox<String> cmbxTypeNote;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblNotes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadTargets() {
        GUICommons.setTextToField(areaInstrc, getTranslateBy(KeysEnum.NOTES_LBL_INSTRUCTIONS.getKey()));
        GUICommons.setTextToButton(btnSaveNow, getTranslateBy(KeysEnum.NOTES_BTN_SAVE_NOTE.getKey()));
    }

    @Override
    public void init() {
        initComponents();
        loadTargets();
        GUICommons.disabledButton(btnSaveNow);
        GUICommons.loadTitleOnTable(tblNotes, titles, false);
        loadTypesNotes();
        retrieveNotes();
        GUICommons.addDoubleClickOnTable(tblNotes, item -> openNoteDialog((long) item));
    }
}
