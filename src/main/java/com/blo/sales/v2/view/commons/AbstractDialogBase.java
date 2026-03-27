package com.blo.sales.v2.view.commons;

import com.blo.sales.v2.translate.Translate;
import java.awt.Window;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class AbstractDialogBase extends javax.swing.JDialog {
    
    private static final Translate translate = new Translate("es", "MX");
    
    private static final String DATE_FORMAT = "EEEE d 'de' MMMM 'a las' HH:mm";
    
    public AbstractDialogBase(Window window, String title, ModalityType modalityType) {
        super(window, title, modalityType);
    }
    
    public String getTranslateBy(String key) {
        return translate.get(key);
    }
    
    public String parserTimestamp(String timestamp) {
        final var time = LocalDateTime.parse(timestamp, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        final var formateador = DateTimeFormatter.ofPattern(DATE_FORMAT, new Locale("es", "ES"));
        final var onText = time.format(formateador);
        if (onText == null || onText.trim().isBlank()) {
            return onText;
        }
        return String.format("%s%s", onText.substring(0, 1).toUpperCase(), onText.substring(1).toLowerCase());
    }
    
    public abstract void loadTargets();
}
