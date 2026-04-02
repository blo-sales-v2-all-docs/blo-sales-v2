package com.blo.sales.v2.model.entities;

import java.util.List;

public class WrapperActivesCostsEntity {
    
    private List<ActiveCostEntity> activesCosts;

    public List<ActiveCostEntity> getActivesCosts() {
        return activesCosts;
    }

    public void setActivesCosts(List<ActiveCostEntity> activesCosts) {
        this.activesCosts = activesCosts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperActivesCostsEntity{");
        sb.append("activesCosts=").append(activesCosts);
        sb.append('}');
        return sb.toString();
    }
    
}
