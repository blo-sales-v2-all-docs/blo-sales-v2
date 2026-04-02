package com.blo.sales.v2.controller;

import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntTopUp;
import com.blo.sales.v2.controller.pojos.enums.TopUpSearchStatusIntEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;

public interface ITopUpsController {
    
    PojoIntTopUp addTopUp(PojoIntTopUp data, long idCompany) throws BloSalesV2Exception;
    
    WrapperPojoIntTopUp closeTopUps(WrapperPojoIntTopUp topUps) throws BloSalesV2Exception;
    
    WrapperPojoIntTopUp getTopUpsByStatus(TopUpSearchStatusIntEnum status) throws BloSalesV2Exception;
    
}
