package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.ReasonsIntEnum;
import com.blo.sales.v2.controller.pojos.enums.TypesIntEnum;
import java.math.BigDecimal;

public class PojoIntMovementDetail {
    
    private long idMovement;
    
    private TypesIntEnum type;
    
    private ReasonsIntEnum reason;
    
    private long idProduct;
    
    private String product;
    
    private String timestamp;
    
    private String username;
    
    private BigDecimal quantity;

    public long getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(long idMovement) {
        this.idMovement = idMovement;
    }

    public TypesIntEnum getType() {
        return type;
    }

    public void setType(TypesIntEnum type) {
        this.type = type;
    }

    public ReasonsIntEnum getReason() {
        return reason;
    }

    public void setReason(ReasonsIntEnum reason) {
        this.reason = reason;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoIntMovementDetail{");
        sb.append("idMovement=").append(idMovement);
        sb.append(", type=").append(type);
        sb.append(", reason=").append(reason);
        sb.append(", idProduct=").append(idProduct);
        sb.append(", product=").append(product);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", username=").append(username);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
