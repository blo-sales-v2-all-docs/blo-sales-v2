package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;

public class PojoSaleProductData {
    
    private long idProduct;
    
    private BigDecimal quantityOnSale;
    
    private BigDecimal price;
    
    private BigDecimal productBuyTotal;
    
    private String timestamp;

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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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
        sb.append("PojoSaleProductData{");
        sb.append("idProduct=").append(idProduct);
        sb.append(", quantityOnSale=").append(quantityOnSale);
        sb.append(", price=").append(price);
        sb.append(", productBuyTotal=").append(productBuyTotal);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
    
}
