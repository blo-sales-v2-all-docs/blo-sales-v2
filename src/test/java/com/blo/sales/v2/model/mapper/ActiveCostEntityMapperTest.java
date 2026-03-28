package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntActiveCost;
import com.blo.sales.v2.factory.MocksFactory;
import com.blo.sales.v2.model.entities.ActiveCostEntity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ActiveCostEntityMapperTest {
    
    private static final ActiveCostEntityMapper mapper = ActiveCostEntityMapper.getInstance();
    
    private static final ActiveCostEntity entity = MocksFactory.createActiveEntity();
    
    private static final PojoIntActiveCost pojo = MocksFactory.createPojoIntActive();
    
    @Test
    void toInnerTest() {
        final var out = mapper.toInner(pojo);
        assertEquals(entity.getAmount(), out.getAmount());
        assertEquals(entity.getConcept(), out.getConcept());
        assertEquals(entity.getId_actives_costs(), out.getId_actives_costs());
        assertEquals(entity.getType().name(), out.getType().name());
        assertEquals(entity.isComplete(), out.isComplete());
    }
    
    @Test
    void toInnerNullTest() {
        final var out = mapper.toInner(null);
        assertNull(out);
    }
    
    @Test
    void toOuterTest() {
        final var outer = mapper.toOuter(entity);
        assertEquals(pojo.getAmount(), outer.getAmount());
        assertEquals(pojo.getConcept(), outer.getConcept());
        assertEquals(pojo.getIdActiveCosts(), outer.getIdActiveCosts());
        assertEquals(pojo.getType().name(), outer.getType().name());
        assertEquals(pojo.isComplete(), outer.isComplete());
    }
    
    @Test
    void toOuterNullTest() {
        final var outer = mapper.toOuter(null);
        assertNull(outer);
    }
    
}
