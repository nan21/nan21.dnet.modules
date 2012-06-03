/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.elem.business.service.IElementCategoryService;
import net.nan21.dnet.module.bd.elem.business.service.IEngineService;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementCategory;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.elem.ds.model.ElementTypeDs;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementType;

public class ElementTypeDsConv extends
        AbstractDsConverter<ElementTypeDs, ElementType> implements
        IDsConverter<ElementTypeDs, ElementType> {

    @Override
    protected void modelToEntityReferences(ElementTypeDs ds, ElementType e,
            boolean isInsert) throws Exception {

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

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((ElementCategory) this.em.find(
                        ElementCategory.class, ds.getCategoryId()));
            }
        } else {
            this.lookup_category_ElementCategory(ds, e);
        }

    }

    protected void lookup_engine_Engine(ElementTypeDs ds, ElementType e)
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

    protected void lookup_category_ElementCategory(ElementTypeDs ds,
            ElementType e) throws Exception {
        if (ds.getEngineId() != null && !ds.getEngineId().equals("")
                && ds.getCategory() != null && !ds.getCategory().equals("")) {
            ElementCategory x = null;
            try {
                x = ((IElementCategoryService) findEntityService(ElementCategory.class))
                        .findByEngine_name(ds.getEngineId(), ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ElementCategory` reference:  `engineId` = "
                                + ds.getEngineId() + " , `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);

        } else {
            e.setCategory(null);
        }
    }

}
