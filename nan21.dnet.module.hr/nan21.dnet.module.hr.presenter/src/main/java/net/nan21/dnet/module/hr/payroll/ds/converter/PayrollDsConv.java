/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.elem.business.service.IEngineService;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.PayrollDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

public class PayrollDsConv extends AbstractDsConverter<PayrollDs, Payroll>
        implements IDsConverter<PayrollDs, Payroll> {

    @Override
    protected void modelToEntityReferences(PayrollDs ds, Payroll e,
            boolean isInsert) throws Exception {

        if (ds.getEngineId() != null) {
            if (e.getEngine() == null
                    || !e.getEngine().getId().equals(ds.getEngineId())) {
                e.setEngine((Engine) this.em.find(Engine.class,
                        ds.getEngineId()));
            }
        } else {
            this.lookup_engine_Engine(ds, e);
        }

    }

    protected void lookup_engine_Engine(PayrollDs ds, Payroll e)
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

}
