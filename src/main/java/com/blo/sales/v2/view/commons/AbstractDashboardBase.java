package com.blo.sales.v2.view.commons;

import com.blo.sales.v2.translate.Translate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public abstract class AbstractDashboardBase extends javax.swing.JPanel {
    
    private static final Translate translate = new Translate("es", "MX");
    
    private static final String DATE_FORMAT = "EEEE d 'de' MMMM 'del' uuuu 'a las' HH:mm";
    
    private final String title;
    
    public abstract void loadTargets();
    
    public AbstractDashboardBase(String title) {
        this.title = title;
    }
    
    public String getTranslateBy(String key) {
        return translate.get(key);
    }
    
    /**
     * Convierte un timestamp parsed a timestamp
     * @param timestamp
     * @return 
     */
    public String revertTimestap(String timestamp) {
        final var inputFormat = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern(DATE_FORMAT)
            .toFormatter(new Locale("es", "ES"));
        final var parsedDate = LocalDateTime.parse(timestamp, inputFormat);
        return parsedDate.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
    
    /**
     * Metodo que se encarga de mostrar de forma legible la fecha
     * @param timestamp
     * @return 
     */
    public String parserTimestamp(String timestamp) {
        final var time = LocalDateTime.parse(timestamp, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        final var formateador = DateTimeFormatter.ofPattern(DATE_FORMAT, new Locale("es", "ES"));
        final var onText = time.format(formateador);
        if (onText == null || onText.trim().isBlank()) {
            return onText;
        }
        return String.format("%s%s", onText.substring(0, 1).toUpperCase(), onText.substring(1).toLowerCase());
    }

    public String getTitle() {
        return title;
    }
    
    
}
