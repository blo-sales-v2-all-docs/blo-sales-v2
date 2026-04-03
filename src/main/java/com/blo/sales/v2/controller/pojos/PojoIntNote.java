package com.blo.sales.v2.controller.pojos;

import com.blo.sales.v2.controller.pojos.enums.TypeNoteIntEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class PojoIntNote {
    
    private long idNote;
    
    private long fkUser;
    
    private String note;
    
    private String timesamp;
    
    private TypeNoteIntEnum typeNote;
}
