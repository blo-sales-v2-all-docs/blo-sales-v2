package com.blo.sales.v2.controller.pojos;

public class PojoIntSaleDeletedDetail {
    
    private long idSaleDeleted;
    
    private long fkSaleProduct;
    
    private long fkUser;
    
    private String reason;
    
    private String timestamp;

    public long getIdSaleDeleted() {
        return idSaleDeleted;
    }

    public void setIdSaleDeleted(long idSaleDeleted) {
        this.idSaleDeleted = idSaleDeleted;
    }

    public long getFkSaleProduct() {
        return fkSaleProduct;
    }

    public void setFkSaleProduct(long fkSaleProduct) {
        this.fkSaleProduct = fkSaleProduct;
    }

    public long getFkUser() {
        return fkUser;
    }

    public void setFkUser(long fkUser) {
        this.fkUser = fkUser;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoIntSaleDeletedDetail{");
        sb.append("idSaleDeleted=").append(idSaleDeleted);
        sb.append(", fkSaleProduct=").append(fkSaleProduct);
        sb.append(", fkUser=").append(fkUser);
        sb.append(", reason=").append(reason);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }

}
