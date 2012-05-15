/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.uom.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.uom.ds.model.UomConversionDs;
import net.nan21.dnet.module.bd.uom.domain.entity.UomConversion;

public class UomConversionDsConv extends
        AbstractDsConverter<UomConversionDs, UomConversion> implements
        IDsConverter<UomConversionDs, UomConversion> {

    @Override
    protected void modelToEntityReferences(UomConversionDs ds, UomConversion e,
            boolean isInsert) throws Exception {

        if (ds.getSourceId() != null) {
            if (e.getSource() == null
                    || !e.getSource().getId().equals(ds.getSourceId())) {
                e.setSource((Uom) this.em.find(Uom.class, ds.getSourceId()));
            }
        } else {
            this.lookup_source_Uom(ds, e);
        }

        if (ds.getTargetId() != null) {
            if (e.getTarget() == null
                    || !e.getTarget().getId().equals(ds.getTargetId())) {
                e.setTarget((Uom) this.em.find(Uom.class, ds.getTargetId()));
            }
        } else {
            this.lookup_target_Uom(ds, e);
        }

    }

    protected void lookup_source_Uom(UomConversionDs ds, UomConversion e)
            throws Exception {
        if (ds.getSourceCode() != null && !ds.getSourceCode().equals("")) {
            Uom x = null;
            try {
                x = ((IUomService) findEntityService(Uom.class)).findByCode(ds
                        .getSourceCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `sourceCode` = "
                                + ds.getSourceCode() + "  ");
            }
            e.setSource(x);

        } else {
            e.setSource(null);
        }
    }

    protected void lookup_target_Uom(UomConversionDs ds, UomConversion e)
            throws Exception {
        if (ds.getTargetCode() != null && !ds.getTargetCode().equals("")) {
            Uom x = null;
            try {
                x = ((IUomService) findEntityService(Uom.class)).findByCode(ds
                        .getTargetCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `targetCode` = "
                                + ds.getTargetCode() + "  ");
            }
            e.setTarget(x);

        } else {
            e.setTarget(null);
        }
    }

}
