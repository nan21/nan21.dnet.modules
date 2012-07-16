/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.data.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.data.domain.entity.Note;

@Ds(entity = Note.class)
public class NoteDs extends AbstractAuditableDs<Note> {

    public static final String fNOTE = "note";
    public static final String fTARGETUUID = "targetUuid";
    public static final String fTARGETTYPE = "targetType";

    @DsField()
    private String note;

    @DsField()
    private String targetUuid;

    @DsField()
    private String targetType;

    public NoteDs() {
        super();
    }

    public NoteDs(Note e) {
        super(e);
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTargetUuid() {
        return this.targetUuid;
    }

    public void setTargetUuid(String targetUuid) {
        this.targetUuid = targetUuid;
    }

    public String getTargetType() {
        return this.targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

}
