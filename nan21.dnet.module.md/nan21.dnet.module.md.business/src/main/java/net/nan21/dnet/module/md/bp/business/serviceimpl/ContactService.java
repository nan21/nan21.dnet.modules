/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.bp.business.service.IContactService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;

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
                        "select e from Contact e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
                        Contact.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pBpartnerId", bpartnerId).getResultList();
    }

}
