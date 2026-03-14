package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperTopUpsEntity {
    
    private List<TopUpEntity> topUps;

    public List<TopUpEntity> getTopUps() {
        return topUps;
    }

    public void setTopUps(List<TopUpEntity> topUps) {
        this.topUps = topUps;
    }

    @Override
    public String toString() {
        return "WrapperTopUpEntity{" + "topUps=" + topUps + '}';
    }
    
}
