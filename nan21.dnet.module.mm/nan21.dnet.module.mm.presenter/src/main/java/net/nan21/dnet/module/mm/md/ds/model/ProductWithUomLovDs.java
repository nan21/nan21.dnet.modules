/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Product.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = ProductWithUomLovDs.fCODE) })
public class ProductWithUomLovDs extends AbstractTypeWithCodeLov<Product> {

    public static final String fUOMID = "uomId";
    public static final String fUOM = "uom";

    @DsField(join = "left", path = "defaultUom.id")
    private Long uomId;

    @DsField(join = "left", path = "defaultUom.code")
    private String uom;

    public ProductWithUomLovDs() {
        super();
    }

    public ProductWithUomLovDs(Product e) {
        super(e);
    }

    public Long getUomId() {
        return this.uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public String getUom() {
        return this.uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

}
