package com.blo.sales.v2.view.pojos;

import java.util.List;

public class WrapperPojoTopUp {
    
    private List<PojoTopUp> topUps;

    public List<PojoTopUp> getTopUps() {
        return topUps;
    }

    public void setTopUps(List<PojoTopUp> topUps) {
        this.topUps = topUps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoTopUp{");
        sb.append("topUps=").append(topUps);
        sb.append('}');
        return sb.toString();
    }

}
