/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tax.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.base.tax.business.service.ITaxCategoryService;
import net.nan21.dnet.module.md.base.tax.business.service.ITaxService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.base.tax.domain.entity.TaxCategory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.base.tax.ds.model.TaxDs;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;

public class TaxDsConv extends AbstractDsConverter<TaxDs, Tax> implements
        IDsConverter<TaxDs, Tax> {

    @Override
    protected void modelToEntityReferences(TaxDs ds, Tax e, boolean isInsert)
            throws Exception {

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((TaxCategory) this.em.find(TaxCategory.class,
                        ds.getCategoryId()));
            }
        } else {
            this.lookup_category_TaxCategory(ds, e);
        }

        if (ds.getParentTaxId() != null) {
            if (e.getParentTax() == null
                    || !e.getParentTax().getId().equals(ds.getParentTaxId())) {
                e.setParentTax((Tax) this.em.find(Tax.class,
                        ds.getParentTaxId()));
            }
        } else {
            this.lookup_parentTax_Tax(ds, e);
        }

    }

    protected void lookup_category_TaxCategory(TaxDs ds, Tax e)
            throws Exception {
        if (ds.getCategory() != null && !ds.getCategory().equals("")) {
            TaxCategory x = null;
            try {
                x = ((ITaxCategoryService) findEntityService(TaxCategory.class))
                        .findByName(ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `TaxCategory` reference:  `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);

        } else {
            e.setCategory(null);
        }
    }

    protected void lookup_parentTax_Tax(TaxDs ds, Tax e) throws Exception {
        if (ds.getParentTax() != null && !ds.getParentTax().equals("")) {
            Tax x = null;
            try {
                x = ((ITaxService) findEntityService(Tax.class)).findByName(ds
                        .getParentTax());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Tax` reference:  `parentTax` = "
                                + ds.getParentTax() + "  ");
            }
            e.setParentTax(x);

        } else {
            e.setParentTax(null);
        }
    }

}
