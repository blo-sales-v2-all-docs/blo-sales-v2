package com.blo.sales.v2.controller.pojos;

import java.math.BigDecimal;


public class PojoIntSaleProductData {
    
    private long idProduct;
    
    private BigDecimal quantityOnSale;
    
    private BigDecimal price;
    
    private BigDecimal productBuyTotal;

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public BigDecimal getQuantityOnSale() {
        return quantityOnSale;
    }

    public void setQuantityOnSale(BigDecimal quantityOnSale) {
        this.quantityOnSale = quantityOnSale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProductBuyTotal() {
        return productBuyTotal;
    }

    public void setProductBuyTotal(BigDecimal productBuyTotal) {
        this.productBuyTotal = productBuyTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoIntSaleProductData{");
        sb.append("idProduct=").append(idProduct);
        sb.append(", quantityOnSale=").append(quantityOnSale);
        sb.append(", price=").append(price);
        sb.append(", productBuyTotal=").append(productBuyTotal);
        sb.append('}');
        return sb.toString();
    }

    
}
