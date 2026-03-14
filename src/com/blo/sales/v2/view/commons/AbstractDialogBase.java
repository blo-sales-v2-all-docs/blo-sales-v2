package com.blo.sales.v2.view.commons;

import com.blo.sales.v2.translate.Translate;
import java.awt.Window;

public abstract class AbstractDialogBase extends javax.swing.JDialog {
    
    private static final Translate translate = new Translate("es", "MX");
    
    public AbstractDialogBase(Window window, String title, ModalityType modalityType) {
        super(window, title, modalityType);
    }
    
    public String getTranslateBy(String key) {
        return translate.get(key);
    }
    
    public abstract void loadTargets();
}
