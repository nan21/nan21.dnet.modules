/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

import net.nan21.dnet.module.md.bp.domain.entity.Contact;

public interface IContactService extends IEntityService<Contact> {

    public List<Contact> findByBpartner(BusinessPartner bpartner);

    public List<Contact> findByBpartnerId(Long bpartnerId);

}
