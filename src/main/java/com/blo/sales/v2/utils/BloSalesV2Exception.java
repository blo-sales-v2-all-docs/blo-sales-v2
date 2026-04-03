package com.blo.sales.v2.utils;

public class BloSalesV2Exception extends Exception {
    
    private final String message;
    
    private final String code;
    
    public BloSalesV2Exception(String code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }
    
    @Override
    public String getMessage() {
        return "[" + code + "] " + message;
    }
    
}
