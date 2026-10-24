package com.blo.sales.v2.view.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Builder
public class PojoUser {
    
    private String username;
    
    private String password;
    
    @Override
    public String toString() {
    	return username;
    }
    
}
