package com.blo.sales.v2.view.pojos;

import java.util.List;

public class WrapperPojoSalesAndStock {
    
    private List<PojoSaleAndProduct> salesDetail;

    public List<PojoSaleAndProduct> getSalesDetail() {
        return salesDetail;
    }

    public void setSalesDetail(List<PojoSaleAndProduct> salesDetail) {
        this.salesDetail = salesDetail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoSalesAndStock{");
        sb.append("salesDetail=").append(salesDetail);
        sb.append('}');
        return sb.toString();
    }
}
