package com.blo.sales.v2.translate;

public enum KeysEnum {
    
    // login
    LOGIN_BTN_LOGN("login.btn.login"), LOGIN_LBL_USERNAME("login.lbl.user-name"), LOGIN_LBL_PASSWROD("login.lbl.password"),
    // sales to day
    SALES_TD_DLG_CANCEL_SALE("sales-today.dialog.cancel-sale"), SALES_TD_DLG_REASON_CANCEL("sales-today.dialog.reason-cancel"),
    // sales
    SALES_LBL_QUANTITY("sales.lbl.quantity"), SALES_LBL_BAR_CODE("sales.lbl.bar-code"), SALES_BTN_COMPLETE("sales.btn.complete"), SALES_BTN_NO_COMPLETE("sales.btn.no-complete"), SALES_DLG_MANUAL_SEARCH("sales.dlg.manual-search"), SALES_DLG_DEBTORS("sales.dlg.debtors"),
    // register product
    REGISTER_PRODUCT_LBL_BAR_CODE("register-product.lbl.bar-code"), REGISTER_PRODUCT_LBL_NAME("register-product.lbl.name"), REGISTER_PRODUCT_BY_KG("register-product.lbl.by-kg"), REGISTER_PRODUCT_LBL_QUANTITY("register-product.lbl.quantity"), REGISTER_PRODUCT_LBL_PRICE("register-product.lbl.price"), REGISTER_PRODUCT_LBL_COST_OF_SALE("register-product.lbl.cost-of-sale"),
    // categories
    CATEGORIES_LBL_CATEGORY("categories.lbl.category"), CATEGORIES_LBL_DESCRIPTION("categories.lbl.description"), CATEGORIES_LBL_EDIT_CATEGORY("categories.lbl.edit-category"),
    // dialogos
    DLG_DEBTORS_BTN_REGISTER("dlg-debtors.btn-register"), DLG_DEBTORS_LBL_GIVE("dlg-debtors.lbl.give"), DLG_DEBTORS_LBL_GIVE_CASH("dlg-debtors.lbl.give-cash"),
    // commons
    COMMON_BTN_SAVE("common.btn.save"), COMMON_BTN_SAVE_CHANGES("common.btn.save-changes"), COMMON_BTN_CANCEL("common.btn.cancel"), COMMON_TOTAL("common.lbl.total"), COMMON_CURRENCY_SYMBOL_BEFORE("common.lbl.currency-symbol-before");
    
    private final String key;

    private KeysEnum(String key) {
        this.key = key;
    }
    
    public String getKey() {
        return this.key;
    }
    
}
