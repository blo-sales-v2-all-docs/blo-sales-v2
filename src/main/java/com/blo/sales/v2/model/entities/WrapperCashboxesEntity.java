package com.blo.sales.v2.model.entities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WrapperCashboxesEntity {
    
    private List<CashboxEntity> cashboxes;

}
