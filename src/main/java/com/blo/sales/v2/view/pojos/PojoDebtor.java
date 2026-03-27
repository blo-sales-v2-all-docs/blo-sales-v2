package com.blo.sales.v2.view.pojos;

import java.math.BigDecimal;

public class PojoDebtor {
    
    private long idDebtor;
    
    private String name;
    
    private BigDecimal debt;
    
    private String payments;

    public long getIdDebtor() {
        return idDebtor;
    }

    public void setIdDebtor(long idDebtor) {
        this.idDebtor = idDebtor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoDebtor{");
        sb.append("idDebtor=").append(idDebtor);
        sb.append(", name=").append(name);
        sb.append(", debt=").append(debt);
        sb.append(", payments=").append(payments);
        sb.append('}');
        return sb.toString();
    }
}
