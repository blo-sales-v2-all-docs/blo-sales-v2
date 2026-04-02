package com.blo.sales.v2.controller.pojos;

public class PojoIntCashboxSaleDetail {

    private PojoIntCashbox cashbox;
    
    private PojoIntSale sale;
    
    private PojoIntProduct product;
    
    private PojoIntLoggedInUser user;
    
    private PojoIntSaleProduct saleProduct;
    
    private PojoIntPaymentTypeInfo paymentTypeInfo;

    public PojoIntSaleProduct getSaleProduct() {
        return saleProduct;
    }

    public void setSaleProduct(PojoIntSaleProduct saleProduct) {
        this.saleProduct = saleProduct;
    }

    public PojoIntCashbox getCashbox() {
        return cashbox;
    }

    public void setCashbox(PojoIntCashbox cashbox) {
        this.cashbox = cashbox;
    }

    public PojoIntSale getSale() {
        return sale;
    }

    public void setSale(PojoIntSale sale) {
        this.sale = sale;
    }

    public PojoIntProduct getProduct() {
        return product;
    }

    public void setProduct(PojoIntProduct product) {
        this.product = product;
    }

    public PojoIntLoggedInUser getUser() {
        return user;
    }

    public void setUser(PojoIntLoggedInUser user) {
        this.user = user;
    }

    public PojoIntPaymentTypeInfo getPaymentTypeInfo() {
        return paymentTypeInfo;
    }

    public void setPaymentTypeInfo(PojoIntPaymentTypeInfo paymentTypeInfo) {
        this.paymentTypeInfo = paymentTypeInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoIntCashboxSaleDetail{");
        sb.append("cashbox=").append(cashbox);
        sb.append(", sale=").append(sale);
        sb.append(", product=").append(product);
        sb.append(", user=").append(user);
        sb.append(", saleProduct=").append(saleProduct);
        sb.append(", paymentTypeInfo=").append(paymentTypeInfo);
        sb.append('}');
        return sb.toString();
    }

}
