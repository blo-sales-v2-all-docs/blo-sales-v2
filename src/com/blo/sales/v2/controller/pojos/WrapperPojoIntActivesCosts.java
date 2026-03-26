package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntActivesCosts {
    
    private List<PojoIntActiveCost> activesCosts;

    public List<PojoIntActiveCost> getActivesCosts() {
        return activesCosts;
    }

    public void setActivesCosts(List<PojoIntActiveCost> activesCosts) {
        this.activesCosts = activesCosts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntActivesCosts{");
        sb.append("activesCosts=").append(activesCosts);
        sb.append('}');
        return sb.toString();
    }
    
}
