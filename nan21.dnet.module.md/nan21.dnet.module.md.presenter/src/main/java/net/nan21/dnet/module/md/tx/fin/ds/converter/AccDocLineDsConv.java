/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.fin.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.tx.fin.ds.model.AccDocLineDs;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDocLine;

public class AccDocLineDsConv extends
        AbstractDsConverter<AccDocLineDs, AccDocLine> implements
        IDsConverter<AccDocLineDs, AccDocLine> {

    @Override
    protected void modelToEntityReferences(AccDocLineDs ds, AccDocLine e,
            boolean isInsert) throws Exception {

        if (ds.getAccDocId() != null) {
            if (e.getAccDoc() == null
                    || !e.getAccDoc().getId().equals(ds.getAccDocId())) {
                e.setAccDoc((AccDoc) this.em.find(AccDoc.class,
                        ds.getAccDocId()));
            }
        }

    }

}
