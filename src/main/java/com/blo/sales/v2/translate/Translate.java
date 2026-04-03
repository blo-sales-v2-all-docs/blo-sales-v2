package com.blo.sales.v2.translate;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translate {

    private final ResourceBundle bundle;

    public Translate(String lang, String country) {
        Locale locale = new Locale(lang, country);
        // "messages" es el nombre base de tu archivo .properties
        bundle = ResourceBundle.getBundle("es", locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
