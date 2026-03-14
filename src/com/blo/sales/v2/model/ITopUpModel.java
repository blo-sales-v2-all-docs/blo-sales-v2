package com.blo.sales.v2.model;

import com.blo.sales.v2.controller.pojos.PojoIntTopUp;
import com.blo.sales.v2.controller.pojos.WrapperPojoIntTopUp;
import com.blo.sales.v2.controller.pojos.enums.TopUpSearchStatusIntEnum;
import com.blo.sales.v2.utils.BloSalesV2Exception;

public interface ITopUpModel {
    
    PojoIntTopUp addTopUp(PojoIntTopUp data) throws BloSalesV2Exception;
    
    PojoIntTopUp updateTopUp(PojoIntTopUp data, long idTopUp) throws BloSalesV2Exception;
    
    WrapperPojoIntTopUp getTopUpsByStatus(TopUpSearchStatusIntEnum status) throws BloSalesV2Exception;
}
