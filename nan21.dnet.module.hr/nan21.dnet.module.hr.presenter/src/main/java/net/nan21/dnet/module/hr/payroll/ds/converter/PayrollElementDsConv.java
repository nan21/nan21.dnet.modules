/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.elem.business.service.IElementTypeService;
import net.nan21.dnet.module.bd.elem.business.service.IEngineService;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementType;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollElementService;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;
import net.nan21.dnet.module.md.acc.business.service.IAccItemService;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;

public class PayrollElementDsConv extends
        AbstractDsConverter<PayrollElementDs, PayrollElement> implements
        IDsConverter<PayrollElementDs, PayrollElement> {

    @Override
    protected void modelToEntityReferences(PayrollElementDs ds,
            PayrollElement e, boolean isInsert) throws Exception {

        if (ds.getEngineId() == null) {
            Engine x = ((IEngineService) findEntityService(Engine.class))
                    .findByName(ds.getEngine());

            ds.setEngineId(x.getId());
        }

        if (ds.getEngineId() != null) {
            if (e.getEngine() == null
                    || !e.getEngine().getId().equals(ds.getEngineId())) {
                e.setEngine((Engine) this.em.find(Engine.class,
                        ds.getEngineId()));
            }
        } else {
            this.lookup_engine_Engine(ds, e);
        }

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((ElementType) this.em.find(ElementType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_ElementType(ds, e);
        }

        if (ds.getSourceElementId() != null) {
            if (e.getSourceElement() == null
                    || !e.getSourceElement().getId()
                            .equals(ds.getSourceElementId())) {
                e.setSourceElement((PayrollElement) this.em.find(
                        PayrollElement.class, ds.getSourceElementId()));
            }
        } else {
            this.lookup_sourceElement_PayrollElement(ds, e);
        }

        if (ds.getAccItemId() != null) {
            if (e.getAccItem() == null
                    || !e.getAccItem().getId().equals(ds.getAccItemId())) {
                e.setAccItem((AccItem) this.em.find(AccItem.class,
                        ds.getAccItemId()));
            }
        } else {
            this.lookup_accItem_AccItem(ds, e);
        }

    }

    protected void lookup_engine_Engine(PayrollElementDs ds, PayrollElement e)
            throws Exception {
        if (ds.getEngine() != null && !ds.getEngine().equals("")) {
            Engine x = null;
            try {
                x = ((IEngineService) findEntityService(Engine.class))
                        .findByName(ds.getEngine());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Engine` reference:  `engine` = "
                                + ds.getEngine() + "  ");
            }
            e.setEngine(x);

        } else {
            e.setEngine(null);
        }
    }

    protected void lookup_type_ElementType(PayrollElementDs ds, PayrollElement e)
            throws Exception {
        if (ds.getEngineId() != null && !ds.getEngineId().equals("")
                && ds.getType() != null && !ds.getType().equals("")) {
            ElementType x = null;
            try {
                x = ((IElementTypeService) findEntityService(ElementType.class))
                        .findByEngine_name(ds.getEngineId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ElementType` reference:  `engineId` = "
                                + ds.getEngineId() + " , `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

    protected void lookup_sourceElement_PayrollElement(PayrollElementDs ds,
            PayrollElement e) throws Exception {
        if (ds.getEngineId() != null && !ds.getEngineId().equals("")
                && ds.getSourceElement() != null
                && !ds.getSourceElement().equals("")) {
            PayrollElement x = null;
            try {
                x = ((IPayrollElementService) findEntityService(PayrollElement.class))
                        .findByEngine_code(ds.getEngineId(),
                                ds.getSourceElement());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `PayrollElement` reference:  `engineId` = "
                                + ds.getEngineId() + " , `sourceElement` = "
                                + ds.getSourceElement() + "  ");
            }
            e.setSourceElement(x);

        } else {
            e.setSourceElement(null);
        }
    }

    protected void lookup_accItem_AccItem(PayrollElementDs ds, PayrollElement e)
            throws Exception {
        if (ds.getAccItem() != null && !ds.getAccItem().equals("")) {
            AccItem x = null;
            try {
                x = ((IAccItemService) findEntityService(AccItem.class))
                        .findByName(ds.getAccItem());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AccItem` reference:  `accItem` = "
                                + ds.getAccItem() + "  ");
            }
            e.setAccItem(x);

        } else {
            e.setAccItem(null);
        }
    }

}
