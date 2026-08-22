package com.blo.sales.v2.model.mapper;

import com.blo.sales.v2.controller.pojos.PojoIntDebtorInfoDetail;
import com.blo.sales.v2.controller.pojos.PojoIntProduct;
import com.blo.sales.v2.model.entities.DebtorInfoDetailEntity;
import com.blo.sales.v2.utils.IToOuter;
import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DebtorInfoDetailEntityMapper implements IToOuter<List<DebtorInfoDetailEntity>, PojoIntDebtorInfoDetail> {

    @Override
    public PojoIntDebtorInfoDetail toOuter(List<DebtorInfoDetailEntity> inner) {
        if (inner != null && !inner.isEmpty()) {
            final PojoIntDebtorInfoDetail outer = new PojoIntDebtorInfoDetail();
            outer.setName(inner.get(0).getName());
            outer.setPayments(inner.get(0).getPayments());
            outer.setDebt(inner.get(0).getDebt());
            outer.setIdDebtor(inner.get(0).getId_debtor());
            final List<PojoIntProduct> lstProducts = new ArrayList<>();
            inner.forEach(d -> {
                final PojoIntProduct item = new PojoIntProduct();
                item.setTimestamp(d.getTimestamp());
                item.setProduct(d.getProduct());
                item.setPrice(d.getPrice());
                item.setQuantity(d.getQuantity_sale());
                item.setCostOfSale(d.getProduct_total_on_sale());
                lstProducts.add(item);
            });
            outer.setProducts(lstProducts);
            return outer;
        }
        return null;
    }

}
