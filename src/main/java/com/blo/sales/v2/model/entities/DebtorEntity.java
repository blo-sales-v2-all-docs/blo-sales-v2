package com.blo.sales.v2.model.entities;

import java.math.BigDecimal;

public class DebtorEntity {
    
    private long id_debtor;
    
    private String name;
    
    private BigDecimal debt;
    
    private String payments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId_debtor() {
        return id_debtor;
    }

    public void setId_debtor(long id_debtor) {
        this.id_debtor = id_debtor;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DebtorEntity{");
        sb.append("id_debtor=").append(id_debtor);
        sb.append(", name=").append(name);
        sb.append(", debt=").append(debt);
        sb.append(", payments=").append(payments);
        sb.append('}');
        return sb.toString();
    }

}
