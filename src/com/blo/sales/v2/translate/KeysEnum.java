package com.blo.sales.v2.translate;

public enum KeysEnum {
    
    LOGIN_BTN_LOGN("login.btn.login"), LOGIN_LBL_USERNAME("login.lbl.user-name"), LOGIN_LBL_PASSWROD("login.lbl.password"),
    SALES_TD_DLG_CANCEL_SALE("sales-today.dialog.cancel-sale"), SALES_TD_DLG_REASON_CANCEL("sales-today.dialog.reason-cancel"),
    SALES_LBL_QUANTITY("sales.lbl.quantity"), SALES_LBL_BAR_CODE("sales.lbl.bar-code"), SALES_BTN_COMPLETE("sales.btn.complete"), SALES_BTN_NO_COMPLETE("sales.btn.no-complete"), SALES_DLG_MANUAL_SEARCH("sales.dlg.manual-search"), SALES_DLG_DEBTORS("sales.dlg.debtors"),
    DLG_DEBTORS_BTN_REGISTER("dlg-debtors.btn-register"), DLG_DEBTORS_LBL_GIVE("dlg-debtors.lbl.give"), DLG_DEBTORS_LBL_GIVE_CASH("dlg-debtors.lbl.give-cash"),
    COMMON_BTN_SAVE("common.btn.save"), COMMON_BTN_CANCEL("common.btn.cancel"), COMMON_TOTAL("common.lbl.total"), COMMON_CURRENCY_SYMBOL_BEFORE("common.lbl.currency-symbol-before");
    
    private final String key;

    private KeysEnum(String key) {
        this.key = key;
    }
    
    public String getKey() {
        return this.key;
    }
    
}
