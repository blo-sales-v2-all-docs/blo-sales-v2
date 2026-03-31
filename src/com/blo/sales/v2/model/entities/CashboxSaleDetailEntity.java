package com.blo.sales.v2.model.entities;

public class CashboxSaleDetailEntity {
    
    private CashboxEntity cashbox;
    
    private SaleEntity sale;
    
    private ProductEntity product;
    
    private UserEntity user;
    
    private SaleProductEntity sale_product;

    public CashboxEntity getCashbox() {
        return cashbox;
    }

    public void setCashbox(CashboxEntity cashbox) {
        this.cashbox = cashbox;
    }

    public SaleEntity getSale() {
        return sale;
    }

    public void setSale(SaleEntity sale) {
        this.sale = sale;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public SaleProductEntity getSale_product() {
        return sale_product;
    }

    public void setSale_product(SaleProductEntity sale_product) {
        this.sale_product = sale_product;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashboxSaleDetailEntity{");
        sb.append(", cashbox=").append(cashbox);
        sb.append(", sale=").append(sale);
        sb.append(", product=").append(product);
        sb.append(", user=").append(user);
        sb.append(", sale_product=").append(sale_product);
        sb.append('}');
        return sb.toString();
    }
    
}
