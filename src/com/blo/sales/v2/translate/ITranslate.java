package com.blo.sales.v2.translate;

public interface ITranslate {
    
    static TranslateImpl translate = new TranslateImpl("es", "MX");
    
    void loadTargets();
    
}
