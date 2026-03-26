package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.ActivesCostsEnum;
import java.math.BigDecimal;

public class PojoActiveCost {
    
    private long idActiveCosts;
    
    private String concept;
    
    private BigDecimal amount;
    
    private ActivesCostsEnum type;
    
    private boolean complete;

    public long getIdActiveCosts() {
        return idActiveCosts;
    }

    public void setIdActiveCosts(long idActiveCosts) {
        this.idActiveCosts = idActiveCosts;
    }


    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ActivesCostsEnum getType() {
        return type;
    }

    public void setType(ActivesCostsEnum type) {
        this.type = type;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(idActiveCosts);
        sb.append(", concept=").append(concept);
        sb.append(", amount=").append(amount);
        sb.append(", type=").append(type);
        sb.append(", complete=").append(complete);
        return sb.toString();
    }
    
}
