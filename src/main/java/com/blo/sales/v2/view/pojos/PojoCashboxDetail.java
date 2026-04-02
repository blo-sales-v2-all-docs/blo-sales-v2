package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.ActivesCostsEnum;
import com.blo.sales.v2.view.pojos.enums.CashboxStatusEnum;
import java.math.BigDecimal;

public class PojoCashboxDetail {
    
    private long idCashbox;
    
    private CashboxStatusEnum status;
    
    private BigDecimal amount;
    
    private String concept;
    
    private ActivesCostsEnum type;
    
    private String timestamp;
    
    private BigDecimal conceptAmount;

    public BigDecimal getConceptAmount() {
        return conceptAmount;
    }

    public void setConceptAmount(BigDecimal conceptAmount) {
        this.conceptAmount = conceptAmount;
    }

    public long getIdCashbox() {
        return idCashbox;
    }

    public void setIdCashbox(long idCashbox) {
        this.idCashbox = idCashbox;
    }

    public CashboxStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CashboxStatusEnum status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public ActivesCostsEnum getType() {
        return type;
    }

    public void setType(ActivesCostsEnum type) {
        this.type = type;
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
        sb.append("PojoCashboxDetail{");
        sb.append("idCashbox=").append(idCashbox);
        sb.append(", status=").append(status);
        sb.append(", amount=").append(amount);
        sb.append(", concept=").append(concept);
        sb.append(", type=").append(type);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", conceptAmount=").append(conceptAmount);
        sb.append('}');
        return sb.toString();
    }
}
