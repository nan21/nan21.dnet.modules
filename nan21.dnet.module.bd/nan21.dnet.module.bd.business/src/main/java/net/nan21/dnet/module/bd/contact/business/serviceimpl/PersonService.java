/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.contact.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.contact.business.service.IPersonService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.contact.domain.entity.Person;

public class PersonService extends AbstractEntityService<Person> implements
        IPersonService {

    public PersonService() {
        super();
    }

    public PersonService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }

}
