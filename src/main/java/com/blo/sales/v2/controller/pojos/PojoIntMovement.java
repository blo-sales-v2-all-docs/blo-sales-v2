package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.model.entities.enums.ReasonsEntityEnum;
import com.blo.sales.v2.model.entities.enums.TypesEntityEnum;
import java.math.BigDecimal;

public class PojoIntMovement {
    
    private long idMovement;
    
    private long fkProduct;
    
    private long fkUser;
    
    private TypesEntityEnum type;
    
    private BigDecimal quantity;
    
    private ReasonsEntityEnum reason;
    
    private String timestamp;

    public long getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(long idMovement) {
        this.idMovement = idMovement;
    }

    public long getFkProduct() {
        return fkProduct;
    }

    public void setFkProduct(long fkProduct) {
        this.fkProduct = fkProduct;
    }

    public long getFkUser() {
        return fkUser;
    }

    public void setFkUser(long fkUser) {
        this.fkUser = fkUser;
    }

    public TypesEntityEnum getType() {
        return type;
    }

    public void setType(TypesEntityEnum type) {
        this.type = type;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public ReasonsEntityEnum getReason() {
        return reason;
    }

    public void setReason(ReasonsEntityEnum reason) {
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
        sb.append("PojoIntMovement{");
        sb.append("idMovement=").append(idMovement);
        sb.append(", fkProduct=").append(fkProduct);
        sb.append(", fkUser=").append(fkUser);
        sb.append(", type=").append(type);
        sb.append(", quantity=").append(quantity);
        sb.append(", reason=").append(reason);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
    
}
