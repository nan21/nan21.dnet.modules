/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.acc.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.bd.acc.domain.entity.AccJournal;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AccJournal.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = AccJournalLovDs.fNAME) })
public class AccJournalLovDs extends AbstractTypeLov<AccJournal> {

    public AccJournalLovDs() {
        super();
    }

    public AccJournalLovDs(AccJournal e) {
        super(e);
    }

}
