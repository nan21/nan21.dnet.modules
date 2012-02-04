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
                x = ((IIssueCategoryService) findEntityService(IssueCategory.class))
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

}
