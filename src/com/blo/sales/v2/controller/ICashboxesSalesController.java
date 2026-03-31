package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntCashboxSale;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntCashboxesSalesDetails;
import com.blo.sales.v2.utils.BloSalesV2Exception;

public interface ICashboxesSalesController {
    
    PojoIntCashboxSale addCashboxSale(long idCashbox, long idSale) throws BloSalesV2Exception;
    
    WrapperPojoIntCashboxesSalesDetails getCashboxSalesDetailById(long idCashbox) throws BloSalesV2Exception;
    
}
