package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntTopUp {
    
    private List<PojoIntTopUp> topUps;

    public List<PojoIntTopUp> getTopUps() {
        return topUps;
    }

    public void setTopUps(List<PojoIntTopUp> topUps) {
        this.topUps = topUps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntTopUp{");
        sb.append("topUps=").append(topUps);
        sb.append('}');
        return sb.toString();
    }

}
