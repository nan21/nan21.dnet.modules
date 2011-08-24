/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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

    protected void modelToEntityAttributes(UomConversionDs ds, UomConversion e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setMultiplyWith(ds.getMultiplyWith());
        e.setDivideTo(ds.getDivideTo());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(UomConversionDs ds, UomConversion e)
            throws Exception {

        if (ds.getSourceId() != null) {
            if (e.getSource() == null
                    || !e.getSource().getId().equals(ds.getSourceId())) {
                e.setSource((Uom) this.em.getReference(Uom.class,
                        ds.getSourceId()));
            }
        } else {
            this.lookup_source_Uom(ds, e);
        }
        if (ds.getTargetId() != null) {
            if (e.getTarget() == null
                    || !e.getTarget().getId().equals(ds.getTargetId())) {
                e.setTarget((Uom) this.em.getReference(Uom.class,
                        ds.getTargetId()));
            }
        } else {
            this.lookup_target_Uom(ds, e);
        }
    }

    protected void lookup_source_Uom(UomConversionDs ds, UomConversion e)
            throws Exception {
        if (ds.getSourceCode() != null) {
            Uom x = null;
            try {
                x = ((IUomService) getService(IUomService.class)).findByCode(
                        ds.getClientId(), ds.getSourceCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `sourceCode` = "
                                + ds.getSourceCode() + "  ");
            }
            e.setSource(x);
        }
    }

    protected void lookup_target_Uom(UomConversionDs ds, UomConversion e)
            throws Exception {
        if (ds.getTargetCode() != null) {
            Uom x = null;
            try {
                x = ((IUomService) getService(IUomService.class)).findByCode(
                        ds.getClientId(), ds.getTargetCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `targetCode` = "
                                + ds.getTargetCode() + "  ");
            }
            e.setTarget(x);
        }
    }

    @Override
    public void entityToModel(UomConversion e, UomConversionDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setMultiplyWith(e.getMultiplyWith());
        ds.setDivideTo(e.getDivideTo());
        ds.setActive(e.getActive());
        ds.setSourceId(((e.getSource() != null)) ? e.getSource().getId() : null);
        ds.setSourceCode(((e.getSource() != null)) ? e.getSource().getCode()
                : null);
        ds.setTargetId(((e.getTarget() != null)) ? e.getTarget().getId() : null);
        ds.setTargetCode(((e.getTarget() != null)) ? e.getTarget().getCode()
                : null);
    }

}
