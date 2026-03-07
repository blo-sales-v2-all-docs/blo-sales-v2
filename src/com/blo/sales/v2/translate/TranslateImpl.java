package com.blo.sales.v2.translate;

import java.util.Locale;
import java.util.ResourceBundle;

public class TranslateImpl {

    private final ResourceBundle bundle;

    public TranslateImpl(String lang, String country) {
        Locale locale = new Locale(lang, country);
        // "messages" es el nombre base de tu archivo .properties
        bundle = ResourceBundle.getBundle("com.blo.sales.v2.translate.es", locale);
    }

    public String get(String key) {
        return bundle.getString(key);
    }
}
