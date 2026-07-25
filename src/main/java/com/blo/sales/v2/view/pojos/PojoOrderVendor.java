package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.StatusOrderProviderEnum;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PojoOrderVendor {
    
    private long idOrderVendor;
    
    private long fkVendor;
    
    private BigDecimal amount;
    
    private StatusOrderProviderEnum statusOrder;
    
    private String deadline;
    
    private String invoice;
    
    private String timestamp;
    
    private String vendorName;
    
    private String brand;
    
    private String productsInfo;
    
    private PojoVendor vendorInfo;
    
}
