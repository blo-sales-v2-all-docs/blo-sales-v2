package com.blo.sales.v2.controller.pojos;


public class PojoIntCashboxesActivesCosts {
    
    private long idCashboxesActivesCosts;
    
    private long fkCashbox;
    
    private long fkActivesCosts;
    
    private String timestamp;

    public long getIdCashboxesActivesCosts() {
        return idCashboxesActivesCosts;
    }

    public void setIdCashboxesActivesCosts(long idCashboxesActivesCosts) {
        this.idCashboxesActivesCosts = idCashboxesActivesCosts;
    }

    public long getFkCashbox() {
        return fkCashbox;
    }

    public void setFkCashbox(long fkCashbox) {
        this.fkCashbox = fkCashbox;
    }

    public long getFkActivesCosts() {
        return fkActivesCosts;
    }

    public void setFkActivesCosts(long fkActivesCosts) {
        this.fkActivesCosts = fkActivesCosts;
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
        sb.append("PojoIntCashboxesActivesCosts{");
        sb.append("idCashboxesActivesCosts=").append(idCashboxesActivesCosts);
        sb.append(", fkCashbox=").append(fkCashbox);
        sb.append(", fkActivesCosts=").append(fkActivesCosts);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }

}
