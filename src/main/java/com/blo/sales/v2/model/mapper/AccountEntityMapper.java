package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntAccount;
import com.blo.sales.v2.model.entities.AccountEntity;
import com.blo.sales.v2.utils.IToInner;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Singleton;

@Singleton
public class AccountEntityMapper implements IToInner<AccountEntity, PojoIntAccount>, IToOuter<AccountEntity, PojoIntAccount> {

    @Override
    public AccountEntity toInner(PojoIntAccount outer) {
        if (outer == null) {
            return null;
        }
        final var inner = new AccountEntity();
        inner.setAccount(outer.getAccount());
        inner.setControl_amount(outer.getControlAmount());
        inner.setId_account(outer.getIdAccount());
        inner.setTimestamp(outer.getTimestamp());
        return inner;
    }

    @Override
    public PojoIntAccount toOuter(AccountEntity inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new PojoIntAccount();
        outer.setAccount(inner.getAccount());
        outer.setControlAmount(inner.getControl_amount());
        outer.setIdAccount(inner.getId_account());
        outer.setTimestamp(inner.getTimestamp());
        return outer;
    }
    
}
