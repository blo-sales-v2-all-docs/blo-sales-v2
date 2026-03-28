package com.blo.sales.v2.factory;

import com.blo.sales.v2.controller.pojos.PojoIntActiveCost;
import com.blo.sales.v2.controller.pojos.enums.ActiveCostIntEnum;
import com.blo.sales.v2.model.entities.ActiveCostEntity;
import com.blo.sales.v2.model.entities.enums.ActivesCostsEntityEnum;
import java.math.BigDecimal;

public class MocksFactory {

    private static final String ANY_STRING = "any_string";
    
    private static final long  ANY_ID = 1;
    
    private static final long  ANOTHER_ID = 2;
    
    private MocksFactory() { }
    
    public static ActiveCostEntity createActiveEntity() {
        final var out = new ActiveCostEntity();
        out.setAmount(BigDecimal.ONE);
        out.setComplete(false);
        out.setConcept(ANY_STRING);
        out.setId_actives_costs(ANY_ID);
        out.setType(ActivesCostsEntityEnum.ACTIVO);
        return out;
    }
    
    public static ActiveCostEntity createCostEntity() {
        final var out = createActiveEntity();
        out.setId_actives_costs(ANOTHER_ID);
        out.setType(ActivesCostsEntityEnum.PASIVO);
        return out;
    }
    
    public static PojoIntActiveCost createPojoIntActive() {
        final var out = new PojoIntActiveCost();
        out.setAmount(BigDecimal.ONE);
        out.setComplete(false);
        out.setConcept(ANY_STRING);
        out.setIdActiveCosts(ANY_ID);
        out.setType(ActiveCostIntEnum.ACTIVO);
        return out;
    }
    
    public static PojoIntActiveCost createPojoIntCost() {
        final var out = createPojoIntActive();
        out.setIdActiveCosts(ANOTHER_ID);
        out.setType(ActiveCostIntEnum.PASIVO);
        return out;
    }
}
