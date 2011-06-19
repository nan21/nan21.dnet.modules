/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bp.md.ds.model.ContactLovDs;
import net.nan21.dnet.module.bp.md.domain.entity.Contact;

public class ContactLovDsConv extends
        AbstractDsConverter<ContactLovDs, Contact> implements
        IDsConverter<ContactLovDs, Contact> {

    protected void modelToEntityAttributes(ContactLovDs ds, Contact e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
    }

    protected void modelToEntityReferences(ContactLovDs ds, Contact e)
            throws Exception {
    }

    @Override
    public void entityToModel(Contact e, ContactLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
    }

}
