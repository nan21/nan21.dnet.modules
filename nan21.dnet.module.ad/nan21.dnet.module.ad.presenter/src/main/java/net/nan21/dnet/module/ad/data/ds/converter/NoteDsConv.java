/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.data.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.data.ds.model.NoteDs;
import net.nan21.dnet.module.ad.data.domain.entity.Note;

public class NoteDsConv extends AbstractDsConverter<NoteDs, Note> implements
        IDsConverter<NoteDs, Note> {

    protected void modelToEntityAttributes(NoteDs ds, Note e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setNote(ds.getNote());
        e.setTargetId(ds.getTargetId());
        e.setTargetType(ds.getTargetType());
    }

    protected void modelToEntityReferences(NoteDs ds, Note e) throws Exception {
    }

    @Override
    public void entityToModel(Note e, NoteDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setNote(e.getNote());
        ds.setTargetId(e.getTargetId());
        ds.setTargetType(e.getTargetType());
    }

}
