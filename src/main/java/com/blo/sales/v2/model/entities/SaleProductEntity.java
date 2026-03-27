package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;

public class SaleProductEntity {
    
    private long id_sale_product;
    
    private long fk_sale;
    
    private long fk_product;

    private BigDecimal qunatity_sale;
    
    private BigDecimal total_on_sale;
    
    private BigDecimal product_total_on_sale;
    
    private String timestamp;
    
    private boolean is_live;

    public BigDecimal getTotal_on_sale() {
        return total_on_sale;
    }

    public void setTotal_on_sale(BigDecimal total_on_sale) {
        this.total_on_sale = total_on_sale;
    }
    
    public long getId_sale_product() {
        return id_sale_product;
    }

    public void setId_sale_product(long id_sale_product) {
        this.id_sale_product = id_sale_product;
    }

    public long getFk_sale() {
        return fk_sale;
    }

    public void setFk_sale(long fk_sale) {
        this.fk_sale = fk_sale;
    }

    public long getFk_product() {
        return fk_product;
    }

    public void setFk_product(long fk_product) {
        this.fk_product = fk_product;
    }

    public BigDecimal getQunatity_sale() {
        return qunatity_sale;
    }

    public void setQunatity_sale(BigDecimal qunatity_sale) {
        this.qunatity_sale = qunatity_sale;
    }

    public BigDecimal getProduct_total_on_sale() {
        return product_total_on_sale;
    }

    public void setProduct_total_on_sale(BigDecimal product_total_on_sale) {
        this.product_total_on_sale = product_total_on_sale;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean is_live() {
        return is_live;
    }

    public void setIs_live(boolean is_live) {
        this.is_live = is_live;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SaleProductEntity{");
        sb.append("id_sale_product=").append(id_sale_product);
        sb.append(", fk_sale=").append(fk_sale);
        sb.append(", fk_product=").append(fk_product);
        sb.append(", qunatity_sale=").append(qunatity_sale);
        sb.append(", total_on_sale=").append(total_on_sale);
        sb.append(", product_total_on_sale=").append(product_total_on_sale);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", is_live=").append(is_live);
        sb.append('}');
        return sb.toString();
    }

}
