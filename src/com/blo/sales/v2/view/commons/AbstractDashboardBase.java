package com.blo.sales.v2.view.commons;

import com.blo.sales.v2.translate.Translate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class AbstractDashboardBase extends javax.swing.JPanel {
    
    private static final Translate translate = new Translate("es", "MX");
    
    private static final String DATE_FORMAT = "EEEE d 'de' MMMM 'a las' HH:mm";
    
    private final String title;
    
    public abstract void loadTargets();
    
    public AbstractDashboardBase(String title) {
        this.title = title;
    }
    
    public String getTranslateBy(String key) {
        return translate.get(key);
    }
    
    public String parserTimestamp(String timestamp) {
        final var time = LocalDateTime.parse(timestamp, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        final var formateador = DateTimeFormatter.ofPattern(DATE_FORMAT, new Locale("es", "ES"));
        return time.format(formateador);
    }

    public String getTitle() {
        return title;
    }
    
    
}
