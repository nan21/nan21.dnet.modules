/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.md.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;
import net.nan21.dnet.module.bp.md.domain.service.IContactService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bp.md.domain.entity.Contact;

public class ContactService extends AbstractEntityService<Contact> implements
        IContactService {

    public ContactService() {
        super();
    }

    public ContactService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Contact> getEntityClass() {
        return Contact.class;
    }

    public List<Contact> findByBpartner(BusinessPartner bpartner) {
        return this.findByBpartnerId(bpartner.getId());
    }

    public List<Contact> findByBpartnerId(Long bpartnerId) {
        return (List<Contact>) this.em
                .createQuery(
                        "select e from Contact where e.bpartner.id = :pBpartnerId",
                        Contact.class).setParameter("pBpartnerId", bpartnerId)
                .getResultList();
    }

}
