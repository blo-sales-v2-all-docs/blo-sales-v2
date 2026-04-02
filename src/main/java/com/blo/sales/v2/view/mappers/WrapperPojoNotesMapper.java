package com.blo.sales.v2.view.mappers;

import com.blo.sales.v2.controller.pojos.WrapperPojoIntNotes;
import com.blo.sales.v2.utils.IToOuter;
import com.blo.sales.v2.view.pojos.PojoNote;
import com.blo.sales.v2.view.pojos.WrapperPojoNotes;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class WrapperPojoNotesMapper implements IToOuter<WrapperPojoIntNotes, WrapperPojoNotes> {
    
    @Inject
    private PojoNoteMapper mapper;

    @Override
    public WrapperPojoNotes toOuter(WrapperPojoIntNotes inner) {
        if (inner == null) {
            return null;
        }
        final var outer = new WrapperPojoNotes();
        final var lst = new ArrayList<PojoNote>();
        if (inner.getNotes() != null && !inner.getNotes().isEmpty()) {
            inner.getNotes().forEach(n -> lst.add(mapper.toOuter(n)));
        }
        outer.setNotes(lst);
        return outer;
    }
    
}
