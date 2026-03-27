package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.CashboxStatusEnum;
import java.math.BigDecimal;

public class PojoCashbox {
    
    private long idCashbox;
    
    private long fkUser;
    
    private String timestamp;
    
    private BigDecimal amount;
    
    private CashboxStatusEnum status;
    
    private String userFrom;

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public long getIdCashbox() {
        return idCashbox;
    }

    public void setIdCashbox(long idCashbox) {
        this.idCashbox = idCashbox;
    }

    public long getFkUser() {
        return fkUser;
    }

    public void setFkUser(long fkUser) {
        this.fkUser = fkUser;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal initialAmount) {
        this.amount = initialAmount;
    }

    public CashboxStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CashboxStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoCashbox{");
        sb.append("idCashbox=").append(idCashbox);
        sb.append(", fkUser=").append(fkUser);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", amount=").append(amount);
        sb.append(", status=").append(status);
        sb.append(", userFrom=").append(userFrom);
        sb.append('}');
        return sb.toString();
    }

}
