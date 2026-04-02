package com.blo.sales.v2.view.pojos;

import java.util.List;

public class WrapperPojoMobilesCompanies {
    
    private List<PojoMobileCompany> companies;

    public List<PojoMobileCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(List<PojoMobileCompany> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoMobilesCompanies{");
        sb.append("companies=").append(companies);
        sb.append('}');
        return sb.toString();
    }
    
}
