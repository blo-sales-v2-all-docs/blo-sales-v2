package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSale;
import com.blo.sales.v2.utils.BloSalesV2Exception;

public interface ICashboxesSalesModel {
    
    PojoIntCashboxSale addCashboxSale(long idCashbox, long idSale) throws BloSalesV2Exception;
    
}
