package com.blo.sales.v2.view.pojos;

public class PojoCashboxSaleDetail {

    private PojoCashbox cashbox;
    
    private PojoSale sale;
    
    private PojoProduct product;
    
    private PojoLoggedInUser user;
    
    private PojoSaleProduct saleProduct;
    
    private PojoPaymentTypeInfo paymentTypeInfo;
    
    public PojoCashbox getCashbox() {
        return cashbox;
    }

    public void setCashbox(PojoCashbox cashbox) {
        this.cashbox = cashbox;
    }

    public PojoSale getSale() {
        return sale;
    }

    public void setSale(PojoSale sale) {
        this.sale = sale;
    }

    public PojoProduct getProduct() {
        return product;
    }

    public void setProduct(PojoProduct product) {
        this.product = product;
    }

    public PojoLoggedInUser getUser() {
        return user;
    }

    public void setUser(PojoLoggedInUser user) {
        this.user = user;
    }

    public PojoSaleProduct getSaleProduct() {
        return saleProduct;
    }

    public void setSaleProduct(PojoSaleProduct saleProduct) {
        this.saleProduct = saleProduct;
    }

    public PojoPaymentTypeInfo getPaymentTypeInfo() {
        return paymentTypeInfo;
    }

    public void setPaymentTypeInfo(PojoPaymentTypeInfo paymentTypeInfo) {
        this.paymentTypeInfo = paymentTypeInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoCashboxSaleDetail{");
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
