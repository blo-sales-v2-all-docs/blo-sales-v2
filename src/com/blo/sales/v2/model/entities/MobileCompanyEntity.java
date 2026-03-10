package com.blo.sales.v2.model.entities;

public class MobileCompanyEntity {
    
    private long id_mobile_company;
    
    private String mobile_company;

    public long getId_mobile_company() {
        return id_mobile_company;
    }

    public void setId_mobile_company(long id_mobile_company) {
        this.id_mobile_company = id_mobile_company;
    }

    public String getMobile_company() {
        return mobile_company;
    }

    public void setMobile_company(String mobile_company) {
        this.mobile_company = mobile_company;
    }

    @Override
    public String toString() {
        return "MobileCompanyEntity{" + "id_mobile_company=" + id_mobile_company + ", mobile_company=" + mobile_company + '}';
    }
}
