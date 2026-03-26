package com.blo.sales.v2.controller.pojos;

import java.util.List;

public class WrapperPojoIntNotes {
    
    private List<PojoIntNote> notes;

    public List<PojoIntNote> getNotes() {
        return notes;
    }

    public void setNotes(List<PojoIntNote> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoIntNotes{");
        sb.append("notes=").append(notes);
        sb.append('}');
        return sb.toString();
    }
    
}
