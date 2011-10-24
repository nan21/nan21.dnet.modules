/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.data.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.data.business.service.INoteService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.data.domain.entity.Note;

public class NoteService extends AbstractEntityService<Note> implements
        INoteService {

    public NoteService() {
        super();
    }

    public NoteService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Note> getEntityClass() {
        return Note.class;
    }

}
