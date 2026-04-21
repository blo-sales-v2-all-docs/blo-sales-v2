package com.blo.sales.v2.translate;

public enum KeysEnum {
    
    // login
    LOGIN_BTN_LOGN("login.btn.login"), LOGIN_LBL_USERNAME("login.lbl.user-name"), LOGIN_LBL_PASSWROD("login.lbl.password"),
    // sales to day
    SALES_TD_DLG_CANCEL_SALE("sales-today.dialog.cancel-sale"), SALES_TD_DLG_REASON_CANCEL("sales-today.dialog.reason-cancel"),
    // sales
    SALES_LBL_QUANTITY("sales.lbl.quantity"), SALES_LBL_BAR_CODE("sales.lbl.bar-code"), SALES_BTN_COMPLETE("sales.btn.complete"), SALES_BTN_NO_COMPLETE("sales.btn.no-complete"), SALES_DLG_MANUAL_SEARCH("sales.dlg.manual-search"), SALES_DLG_DEBTORS("sales.dlg.debtors"), SALES_LBL_FAST_REST("sales.lbl.fast-rest"),
    // producto
    STOCK_BTN_DOWNLOAD_STOCK("stock.btn.download-stock"), STOCK_LBL_PRODUCT("stock.lbl.product"), STOCK_LBL_COST_OF_SALE("stock.lbl.cost-of-sale"), STOCK_LBL_PRICE("stock.lbl.price"), STOCK_LBL_QUANTITY("stock.lbl.quantity"), STOCK_LBL_BAR_CODE("stock.lbl.bar-code"), STOCK_BTN_COSTS_EVOLUTION("stock.btn.cost-evolutions"), STOCK_BTN_MOVEMENTS("stock.btn.movements"), STOCK_DLG_NOT_MOVEMENTS("stock.dlg.not-movements"), STOCK_DLG_HSITORY_MOVEMENTS("stock.dlg.movements-history"), STOCK_DLG_BTN_DOWNLOAD_HISTORY("stock.dlg.btn.download-history"), STOCK_FILE_NAME("stock.fle.name"),
    // register product
    REGISTER_PRODUCT_LBL_BAR_CODE("register-product.lbl.bar-code"), REGISTER_PRODUCT_LBL_NAME("register-product.lbl.name"), REGISTER_PRODUCT_BY_KG("register-product.lbl.by-kg"), REGISTER_PRODUCT_LBL_QUANTITY("register-product.lbl.quantity"), REGISTER_PRODUCT_LBL_PRICE("register-product.lbl.price"), REGISTER_PRODUCT_LBL_COST_OF_SALE("register-product.lbl.cost-of-sale"),
    // categories
    CATEGORIES_LBL_CATEGORY("categories.lbl.category"), CATEGORIES_LBL_DESCRIPTION("categories.lbl.description"), CATEGORIES_LBL_EDIT_CATEGORY("categories.lbl.edit-category"),
    // dialogos
    DLG_DEBTORS_BTN_REGISTER("dlg-debtors.btn-register"), DLG_DEBTORS_LBL_GIVE("dlg-debtors.lbl.give"), DLG_DEBTORS_LBL_GIVE_CASH("dlg-debtors.lbl.give-cash"),
    DLG_SELECTOR("dlg-filter.lbl.filter"), DLG_CASHBOX_TRG_SALES_TODAY("dlg-cashbox.trg.sales-today"),
    // cashbox
    CASHBOX_BTN_CLOSE_NOW("cashbox.btn.close-now"), CASHBOX_DLG_IMPORT_FROM_NOTES("cashbox.dlg.import-from-notes"), CASHBOX_DLG_CLOSING_CASHBOX("cashbox.dlg.closing-cashbox"), CASHBOXES_BTN_VIEW_DETAILS("cashboxes.btn.view-details"), CASHBOXES_BTN_GRAPHICS("cashboxes.btn.grapics"),
    CASHBOXES_LBL_ACTIVES("cashboxes.lbl.actives"), CASHBOXES_LBL_COSTS("cashboxes.lbl.costs"), CASHBOXES_LBL_CASHBOX_OF("cashboxes.lbl.cashbox-of"), CASHBOX_DLG_CONTINUE("cashbox.dlg.continue"),
    // notes
    NOTES_LBL_INSTRUCTIONS("notes.lbl.instructions"), NOTES_BTN_SAVE_NOTE("notes.btn.save-note"), DLG_NOTE_BTN_DELETE("dlg-note.btn.delete"), NOTES_DLG_EDITING_NOTE("notes.dlg.editing-note"),
    // debtors
    DEBTORS_LBL_ADD_PAY("debtors.lbl.add-pay"), DEBTORS_BTN_PAY_ALL("debtors.btn.pay-all"), DEBTORS_LBL_DEBTOR_DEBT("debtors.lbl.debtor-debt"), DEBTORS_DLG_PAY_ALL("debtors.dlg.pay-all"),
    // consolas
    CONSOLE_BTN_DOWNLOAD_LOGS("console.btn.download-logs"),
    // cashbox dialog
    DLG_CASHBOX_LBL_TOTAL_AMOUNT("dlg-cashbox.lbl.total-amount"), DLG_CASHBOX_LBL_DESCRIPTION("dlg-cashbox.lbl.description"), DLG_CASHBOX_LBL_AMOUNT("dlg-cashbox.lbl.amount"), DLG_CASHBOX_LBL_TOTAL_ACTIVES("dlg-cashbox.lbl.total-actives"), DLG_CASHBOX_LBL_TOTAL_COSTS("dlg-cashbox.lbl.total-costs"), DLG_CASHBOX_LBL_NETO_TOTAL("dlg-cashbox.lbl.neto-total"), DLG_CASHBOX_BTN_DOWNLOAD_REPORT("dlg-cashbox.btn.download-report"),
    //sales report
    SALES_REPORT_LBL_INIT_DATE("sales-report.lbl.init-date"), SALES_REPORT_LBL_END_DATE("sales-report.lbl.end-date"), SALES_REPORT_BTN_FILTER_NOW("sales-report.btn.filter-now"), SALES_REPORT_BTN_DOWNLOAD_REPORT("sales-report.btn.download-report"),
    // companies
    MOBILE_COMPANIES_LBL_COMPANY_NAME("mobile-companies.lbl.company-name"),
    // commons
    COMMON_BTN_SAVE("common.btn.save"), COMMON_BTN_SAVE_CHANGES("common.btn.save-changes"), COMMON_BTN_CANCEL("common.btn.cancel"), COMMON_TOTAL("common.lbl.total"), COMMON_CURRENCY_SYMBOL_BEFORE("common.lbl.currency-symbol-before"), COMMON_BTN_SAVE_NOW("common.btn.save-now"), COMMON_BTN_CONTINUE("common.btn.continue"), COMMON_BTN_CLOSE("common.btn.close"), COMMON_ALERT_ERROR("common.alert.error"), COMMON_ALERT_WARNING("common.alert.warning"), COMMON_LBL_PAYMENT_TYPE("common.lbl.payment-type"),
    // Recargas telefonicas
    TOP_UP_LBL_COMPANY_PHONE("top-ups.lbl.company-phone"), TOP_UP_LBL_PHONE_NUMBER("top-ups.lbl.phone-number"), TOP_UPS_LBL_AMOUNT("top-ups.lbl.amount"), TOP_UPS_BTN_APPLY_FILTER("top-ups.btn.apply-filter"), TOP_UPS_BTN_CLOSE_NOW("top-ups.btn.close-now"), TOP_UPS_DLG_SURE_CLOSE_ALL("top-ups.dlg.sure-close-all"),
    // dashboard
    DASHBOARD_TITLES_REGISTER_SALE("dashboard.titles.register-sale"), DASHBOARD_TITLES_LOGIN("dashboard.titles.login"), DASHBOARD_TITLES_VIEW_SALES_TODAY("dashboard.titles.view-sales-today"), DASHBOARD_TITLES_REGISTER_PRODUCT("dashboard.titles.register-product"), DASHBOARD_TITLES_CATEGORIES("dashboard.titles.categories"), DASHBOARD_TITLES_CONSOLE("dashboard.titles.console"), DASHBOARD_TITLES_DEBTORS("dashboard.titles.debtors"), DASHBOARD_TITLES_VIEW_ALL_PRODUCTS("dashboard.titles.view-all-products"), DASHBOARD_TITLES_FAST_NOTES("dashboard.titles.fast-notes"), DASHBOARD_TITLES_ALL_SALES("dashboard.titles.all-sales"), DASHBOARD_TITLES_ALL_CASHBOXES("dashboard.titles.all-cashboxes"), DASHBOARD_TITLES_OPEN_CASHBOX("dashboard.titles.open-cashbox"), DASHBOARD_TITLES_TOP_UPS("dashboard.titles.top-ups"), DASHBOARD_TITLES_MOBILE_COMPANIES("dashboard.titles.mobile-companies"), DASHBOARD_TITLES_CANCELED_SALES("dashboard.titles.canceled-sales"),
    // dialogo de pago por tarjeta
    DLG_PAYMENTS_LBL_TOTAL("dlg-payemtns-card.lbl.total"), DLG_PAYMENTS_CARD_LBL_PAYMENT_BY_CARD("dlg-payemtns-card.lbl.payment-by-card"), DLG_PAYMENTS_CARD_LBL_PAYMENT_CASH("dlg-payemtns-card.lbl.payment-cash"), DLG_PAYMENTS_CARD_BTN_PAY("dlg-payemtns-card.btn.pay"), DLG_PAYMENTS_CARD_CMBX_COMPLETE("dlg-payemtns-card.cmbx.complete"), COMMON_TTL_PAYMENT_BY_CARD("common.ttl.payment-by-card"), TOP_UPS_LBL_REFERENCE("top-ups.lbl.reference-number"),
    //
    DASHBOARD_TITLES_DEBTOR_SETTLEMENTS("dashboard.titles.debtor-settlements"),
    // cuenta digital
    DASHBOARD_TITLES_VIEW_DIGITAL_WALLET("dashboard.titles.view-digital-wallet"), DIGITAL_WALLET_LBL_CURRENT_ACCOUNT("digital-wallet.lbl.current-account"), DIGITAL_ACCOUNT_LBL_ADD_CASH_ON_WALLET_DIGITAL("digital-wallet.lbl.add-cash-on-digital-wallet"), DIGITAL_WALLET_LBL_REFERENCE_NUMBER("digital-wallet.lbl.reference-number"), DIGITAL_WALLET_LBL_TOTAL_ACCOUNT("digital-wallet.lbl.total-account");
    
    
    private final String key;

    private KeysEnum(String key) {
        this.key = key;
    }
    
    public String getKey() {
        return this.key;
    }
    
}
