package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.StatusMovementProviderIntEnum;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PojoIntOrderVendor {
    
    private long idOrderVendor;
    
    private long fkVendor;
    
    private BigDecimal amount;
    
    private StatusMovementProviderIntEnum statusOrder;
    
    private String deadline;
    
    private String invoice;
    
    private String timestamp;
    
    private String vendorName;
    
    private String brand;
    
}
