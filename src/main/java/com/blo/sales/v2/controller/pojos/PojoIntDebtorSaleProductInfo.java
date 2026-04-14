package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.PaymentTypeIntEnum;
import java.util.List;
import lombok.Data;

public @Data class PojoIntDebtorSaleProductInfo {
    
    private long idDebtor;
    
    private String name;
    
    private String timestamp;
    
    private List<PaymentTypeIntEnum> paymentType;
    
    private String authorization;
    
    private List<Long> idSales;
    
    private String products;
    
    private String payments;
}
