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
        return "WrapperPojoIntTopUp{" + "topUps=" + topUps + '}';
    }
    
}
