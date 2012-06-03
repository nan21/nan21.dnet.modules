/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.elem.business.service.IEngineService;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.elem.ds.model.ElementSetDs;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSet;

public class ElementSetDsConv extends
        AbstractDsConverter<ElementSetDs, ElementSet> implements
        IDsConverter<ElementSetDs, ElementSet> {

    @Override
    protected void modelToEntityReferences(ElementSetDs ds, ElementSet e,
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

    protected void lookup_engine_Engine(ElementSetDs ds, ElementSet e)
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
