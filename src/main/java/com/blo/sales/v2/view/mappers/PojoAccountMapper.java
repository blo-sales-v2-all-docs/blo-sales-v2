package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.PojoIntAccount;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoAccount;
import jakarta.inject.Singleton;

@Singleton
public class PojoAccountMapper implements IToInner<PojoIntAccount, PojoAccount>, IToOuter<PojoIntAccount, PojoAccount> {

    @Override
    public PojoIntAccount toInner(PojoAccount outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new PojoIntAccount();
        inner.setAccount(outer.getAccount());
        inner.setControlAmount(outer.getControlAmount());
        inner.setIdAccount(outer.getIdAccount());
        inner.setTimestamp(outer.getTimestamp());
        return inner;
    }

    @Override
    public PojoAccount toOuter(PojoIntAccount inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoAccount();
        outer.setAccount(inner.getAccount());
        outer.setControlAmount(inner.getControlAmount());
        outer.setIdAccount(inner.getIdAccount());
        outer.setTimestamp(inner.getTimestamp());
        return outer;
    }
    
}
