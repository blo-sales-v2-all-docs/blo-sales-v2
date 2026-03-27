package com.blo.sales.v2.view.pojos;
import java.util.List;

public class WrapperPojoActivesCosts {
    
    private List<PojoActiveCost> activesCosts;

    public List<PojoActiveCost> getActivesCosts() {
        return activesCosts;
    }

    public void setActivesCosts(List<PojoActiveCost> activesCosts) {
        this.activesCosts = activesCosts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoActivesCosts{");
        sb.append("activesCosts=").append(activesCosts);
        sb.append('}');
        return sb.toString();
    }
    
}
