package com.blo.sales.v2.controller.pojos;

public class PojoIntMobileCompany {
    
    private long idMobileCompany;
    
    private String mobileCompany;

    public long getIdMobileCompany() {
        return idMobileCompany;
    }

    public void setIdMobileCompany(long idMobileCompany) {
        this.idMobileCompany = idMobileCompany;
    }

    public String getMobileCompany() {
        return mobileCompany;
    }

    public void setMobileCompany(String mobileCompany) {
        this.mobileCompany = mobileCompany;
    }

    @Override
    public String toString() {
        return "PojoIntMobileCompany{" + "idMobileCompany=" + idMobileCompany + ", mobileCompany=" + mobileCompany + '}';
    }
    
}
