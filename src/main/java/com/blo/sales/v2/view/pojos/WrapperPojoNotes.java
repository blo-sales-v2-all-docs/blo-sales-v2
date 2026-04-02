package com.blo.sales.v2.view.pojos;

import java.util.List;

public class WrapperPojoNotes {
    
    private List<PojoNote> notes;

    public List<PojoNote> getNotes() {
        return notes;
    }

    public void setNotes(List<PojoNote> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WrapperPojoNotes{");
        sb.append("notes=").append(notes);
        sb.append('}');
        return sb.toString();
    }
    
}
