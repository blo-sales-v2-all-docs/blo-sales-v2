package com.blo.sales.v2.model.entities;

public class CashboxSaleEntity {
    
    private long id_cashbox_sale;
    
    private CashboxEntity fk_cashbox;
    
    private SaleEntity fk_sale;

    public long getId_cashbox_sale() {
        return id_cashbox_sale;
    }

    public void setId_cashbox_sale(long id_cashbox_sale) {
        this.id_cashbox_sale = id_cashbox_sale;
    }

    public CashboxEntity getFk_cashbox() {
        return fk_cashbox;
    }

    public void setFk_cashbox(CashboxEntity fk_cashbox) {
        this.fk_cashbox = fk_cashbox;
    }

    public SaleEntity getFk_sale() {
        return fk_sale;
    }

    public void setFk_sale(SaleEntity fk_sale) {
        this.fk_sale = fk_sale;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashboxSaleEntity{");
        sb.append("id_cashbox_sale=").append(id_cashbox_sale);
        sb.append(", fk_cashbox=").append(fk_cashbox);
        sb.append(", fk_sale=").append(fk_sale);
        sb.append('}');
        return sb.toString();
    }
    
}
