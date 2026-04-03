package com.blo.sales.v2.model.entities;

import com.blo.sales.v2.model.entities.enums.TypeNoteEntityEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public @ToString class NoteEntity {
    
    private long id_note;
    
    private long fk_user;
    
    private String note;
    
    private String timestamp;
    
    private TypeNoteEntityEnum type_note;
}
