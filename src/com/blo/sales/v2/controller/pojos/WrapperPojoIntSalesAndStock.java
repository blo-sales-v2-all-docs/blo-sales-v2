package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntSalesAndStock {
    
    private List<PojoIntSaleAndProduct> salesDetail;

    public List<PojoIntSaleAndProduct> getSalesDetail() {
        return salesDetail;
    }

    public void setSalesDetail(List<PojoIntSaleAndProduct> salesDetail) {
        this.salesDetail = salesDetail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntSalesAndStock{");
        sb.append("salesDetail=").append(salesDetail);
        sb.append('}');
        return sb.toString();
    }
}
