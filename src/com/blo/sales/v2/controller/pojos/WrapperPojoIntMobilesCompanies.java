package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntMobilesCompanies {
    
    private List<PojoIntMobileCompany> companies;

    public List<PojoIntMobileCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(List<PojoIntMobileCompany> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntMobilesCompanies{");
        sb.append("companies=").append(companies);
        sb.append('}');
        return sb.toString();
    }
    
}
