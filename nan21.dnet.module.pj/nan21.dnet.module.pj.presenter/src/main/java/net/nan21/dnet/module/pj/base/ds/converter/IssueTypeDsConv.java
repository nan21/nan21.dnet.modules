/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.base.business.service.IIssueCategoryService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueCategory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.IssueTypeDs;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;

public class IssueTypeDsConv extends
        AbstractDsConverter<IssueTypeDs, IssueType> implements
        IDsConverter<IssueTypeDs, IssueType> {

    protected void modelToEntityAttributes(IssueTypeDs ds, IssueType e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(IssueTypeDs ds, IssueType e)
            throws Exception {

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((IssueCategory) this.em.find(IssueCategory.class,
                        ds.getCategoryId()));
            }
        } else {
            this.lookup_category_IssueCategory(ds, e);
        }
    }

    protected void lookup_category_IssueCategory(IssueTypeDs ds, IssueType e)
            throws Exception {
        if (ds.getCategory() != null && !ds.getCategory().equals("")) {
            IssueCategory x = null;
            try {
                x = ((IIssueCategoryService) getService(IIssueCategoryService.class))
                        .findByName(ds.getClientId(), ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `IssueCategory` reference:  `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);
        } else {
            e.setCategory(null);
        }
    }

    @Override
    public void entityToModel(IssueType e, IssueTypeDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setCategoryId(((e.getCategory() != null)) ? e.getCategory().getId()
                : null);
        ds.setCategory(((e.getCategory() != null)) ? e.getCategory().getName()
                : null);
    }

}
