package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperMobilesCompaniesEntity {
    
    private List<MobileCompanyEntity> companies;

    public List<MobileCompanyEntity> getCompanies() {
        return companies;
    }

    public void setCompanies(List<MobileCompanyEntity> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperMobilesCompaniesEntity{");
        sb.append("companies=").append(companies);
        sb.append('}');
        return sb.toString();
    }
    
}
