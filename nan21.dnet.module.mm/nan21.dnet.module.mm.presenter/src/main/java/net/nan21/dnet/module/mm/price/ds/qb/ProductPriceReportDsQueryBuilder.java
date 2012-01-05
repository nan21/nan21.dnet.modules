/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.price.ds.qb;

import net.nan21.dnet.core.presenter.action.QueryBuilderWithJpql;
import net.nan21.dnet.module.mm.price.ds.filter.ProductPriceReportDsFilter;
import net.nan21.dnet.module.mm.price.ds.param.ProductPriceReportDsParam;

import net.nan21.dnet.module.mm.price.ds.model.ProductPriceReportDs;
import net.nan21.dnet.core.api.session.Session;

public class ProductPriceReportDsQueryBuilder
        extends
        QueryBuilderWithJpql<ProductPriceReportDs, ProductPriceReportDsFilter, ProductPriceReportDsParam> {

    @Override
    public void setFilter(ProductPriceReportDsFilter filter) {
        this.filter = filter;
    }

    @Override
    public void beforeBuildWhere() {
        if (this.params != null && this.params.getValidAt() != null) {
            addFilterCondition("  e.priceListVersion.validFrom <= :validAt and not exists (select pp.id from ProductPrice pp where pp.product.id = e.product.id and pp.priceListVersion.priceList.id = e.priceListVersion.priceList.id and pp.priceListVersion.validFrom > e.priceListVersion.validFrom and pp.priceListVersion.validFrom <= :validAt  )");
            addCustomFilterItem("validAt", this.params.getValidAt());
        }

        if (this.params != null && this.params.getProductCategoryId() != null) {
            addFilterCondition("  e.product.id in ( select p.id from  Product p, IN (p.categories) c where c.id = :productCategoryId )  ");
            addCustomFilterItem("productCategoryId",
                    this.params.getProductCategoryId());
        }

    }

}
