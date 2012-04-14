/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bp.md.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;

import net.nan21.dnet.module.bp.md.domain.entity.Contact;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Contact.class)
public class BpContactLovDs extends AbstractAuditableLov<Contact> {

    public static final String fNAME = "name";
    public static final String fBPARTNERID = "bpartnerId";

    @DsField(fetch = false, jpqlFilter = " e.lastName like :name ")
    private String name;

    @DsField(join = "left", path = "bpartner.id")
    private Long bpartnerId;

    public BpContactLovDs() {
        super();
    }

    public BpContactLovDs(Contact e) {
        super(e);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBpartnerId() {
        return this.bpartnerId;
    }

    public void setBpartnerId(Long bpartnerId) {
        this.bpartnerId = bpartnerId;
    }

}
