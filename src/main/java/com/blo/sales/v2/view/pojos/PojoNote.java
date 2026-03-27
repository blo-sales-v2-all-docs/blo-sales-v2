package com.blo.sales.v2.view.pojos;

import com.blo.sales.v2.view.pojos.enums.TypeNoteEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PojoNote {
    
    private long idNote;
    
    private long fkUser;
    
    private String note;
    
    private String timesamp;
    
    private TypeNoteEnum typeNote;
    
}
