package com.blo.sales.v2.view.pojos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WrapperPojoCashboxes {
    
    private List<PojoCashbox> cashboxes;

    public List<PojoCashbox> getCashboxes() {
        return cashboxes;
    }

    public void setCashboxes(List<PojoCashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoCashboxes{");
        sb.append("cashboxes=").append(cashboxes);
        sb.append('}');
        return sb.toString();
    }
}
