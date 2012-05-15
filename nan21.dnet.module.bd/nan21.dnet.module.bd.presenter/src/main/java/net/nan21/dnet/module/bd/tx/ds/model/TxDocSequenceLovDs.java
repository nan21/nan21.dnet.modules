/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.tx.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.bd.tx.domain.entity.TxDocSequence;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = TxDocSequence.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = TxDocSequenceLovDs.fNAME) })
public class TxDocSequenceLovDs extends AbstractTypeLov<TxDocSequence> {

    public TxDocSequenceLovDs() {
        super();
    }

    public TxDocSequenceLovDs(TxDocSequence e) {
        super(e);
    }

}
