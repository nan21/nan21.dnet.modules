/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;

import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Contact.class)
public class ContactLovDs extends AbstractAuditableLov<Contact> {

    public static final String fNAME = "name";

    @DsField(fetch = false, jpqlFilter = " e.lastName like :name ")
    private String name;

    public ContactLovDs() {
        super();
    }

    public ContactLovDs(Contact e) {
        super(e);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
