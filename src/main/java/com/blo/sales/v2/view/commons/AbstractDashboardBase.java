package com.blo.sales.v2.view.commons;

import com.blo.sales.v2.translate.Translate;
import com.blo.sales.v2.utils.BloSalesV2Utils;
import com.blo.sales.v2.view.pojos.PojoLoggedInUser;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase base para paneles de dashboard
 * @version 1.0.0
 * @author BLO
 */
public abstract class AbstractDashboardBase extends javax.swing.JPanel {
    
    private static final Translate translate = new Translate("es", "MX");
    
    private static final String DATE_FORMAT = "EEEE d 'de' MMMM 'del' uuuu 'a las' HH:mm";
    
    @Getter
    private final String title;
    
    /** propiedad que se ocupa para recuperar y realizar operaciones con ModelTable */
    @Setter
    private JTable mainTable;
    
    @Setter
    @Getter
    private PojoLoggedInUser userData;
    
    @Getter
    private final Gson gson;
    
    protected abstract void loadTargets();
    
    public abstract void init();
    
    protected abstract void reset();
    
    public AbstractDashboardBase(String title) {
        this.title = title;
        this.gson = new Gson();
    }
    
    public static String[] getHeadersFrom(String dashboard) {
        return translate.get(dashboard).split(",");
    }
    
    public static String getTranslateBy(String key) {
        return translate.get(key);
    }
    
    public DefaultTableModel getDefaultTableModel() {
        if (mainTable == null) {
            return null;
        }
        return (DefaultTableModel) mainTable.getModel();
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
    
    /**
     * Metodo que se utiliza para separar los pagos mediante guiones
     * @param payments
     * @return 
     */
    public String formatPayments(String payments) {
        final var paymentsSplit = Arrays.asList(payments.split(BloSalesV2Utils.SEPARATOR_PAYMENTS));
        if (!payments.isEmpty()) {
            final var sb = new StringBuilder();
            final var baseStr = "$%s - %s\n";
            paymentsSplit.forEach(pay -> {
                final var paymentSeparated = pay.split(BloSalesV2Utils.TIMESTAMP);
                if (paymentSeparated.length == 2) {
                    final var payed = paymentSeparated[0];
                    final var timestamp = parserTimestamp(paymentSeparated[1]);
                    sb.append(String.format(baseStr, payed, timestamp));
                }
            });
            return sb.toString();
        }
        return BloSalesV2Utils.EMPTY_STRING;
    }
    
    /**
     * Metodo que recupera el filtro, si se presiona una tecla en especifico se limpia el filtro
     * @param searchField
     * @param keyCode
     * @param clearKey
     * @return 
     */
    public String getFilterAndClearSearcher(JTextField searchField, int keyCode, int clearKey) {
        String filter = GUICommons.getTextFromField(searchField);
        if (keyCode == clearKey) {
            filter = BloSalesV2Utils.EMPTY_STRING;
            GUICommons.setTextToField(searchField, BloSalesV2Utils.EMPTY_STRING);
        }
        return filter;
    }
    
}
