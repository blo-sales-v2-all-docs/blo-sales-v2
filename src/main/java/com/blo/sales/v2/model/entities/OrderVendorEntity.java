package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.StatusOrderVendorEntityEnum;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderVendorEntity {
    
    private long id_order_vendor;
    
    private long fk_vendor;
    
    private BigDecimal amount;
    
    private StatusOrderVendorEntityEnum status_order;
    
    private String deadline;
    
    private String invoice;
    
    private String timestamp;
    
    private String name;
    
    private String brand;
    
    private String payment_type;
    
    private String products_info;
    
}
