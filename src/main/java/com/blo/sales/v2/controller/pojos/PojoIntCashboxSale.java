package com.blo.sales.v2.controller.pojos;

public class PojoIntCashboxSale {
    
    private long idCashboxSale;
    
    private PojoIntCashbox fkCashbox;
    
    private PojoIntSale fkSale;

    public long getIdCashboxSale() {
        return idCashboxSale;
    }

    public void setIdCashboxSale(long idCashboxSale) {
        this.idCashboxSale = idCashboxSale;
    }

    public PojoIntCashbox getFkCashbox() {
        return fkCashbox;
    }

    public void setFkCashbox(PojoIntCashbox fkCashbox) {
        this.fkCashbox = fkCashbox;
    }

    public PojoIntSale getFkSale() {
        return fkSale;
    }

    public void setFkSale(PojoIntSale fkSale) {
        this.fkSale = fkSale;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PojoIntCashboxSale{");
        sb.append("idCashboxSale=").append(idCashboxSale);
        sb.append(", fkCashbox=").append(fkCashbox);
        sb.append(", fkSale=").append(fkSale);
        sb.append('}');
        return sb.toString();
    }
}
