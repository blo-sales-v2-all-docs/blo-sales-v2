package com.blo.sales.v2.model.entities;

public class DebtorSaleEntity {
    
    private long id_debtor_sale;
    
    private long fk_sale;
    
    private long fk_debtor;
    
    private String timestamp;

    public long getId_debtor_sale() {
        return id_debtor_sale;
    }

    public void setId_debtor_sale(long id_debtor_sale) {
        this.id_debtor_sale = id_debtor_sale;
    }

    public long getFk_sale() {
        return fk_sale;
    }

    public void setFk_sale(long fk_sale) {
        this.fk_sale = fk_sale;
    }

    public long getFk_debtor() {
        return fk_debtor;
    }

    public void setFk_debtor(long fk_debtor) {
        this.fk_debtor = fk_debtor;
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
        sb.append("DebtorSaleEntity{");
        sb.append("id_debtor_sale=").append(id_debtor_sale);
        sb.append(", fk_sale=").append(fk_sale);
        sb.append(", fk_debtor=").append(fk_debtor);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
    
}
