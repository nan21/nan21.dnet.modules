/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.price.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceListVersion;

@Ds(entity = PriceListVersion.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = PriceListVersionLovDs.fNAME) })
public class PriceListVersionLovDs extends AbstractTypeLov<PriceListVersion> {

    public static final String fPRICELISTID = "priceListId";
    public static final String fVALIDFROM = "validFrom";

    @DsField(join = "left", path = "priceList.id")
    private Long priceListId;

    @DsField()
    private Date validFrom;

    public PriceListVersionLovDs() {
        super();
    }

    public PriceListVersionLovDs(PriceListVersion e) {
        super(e);
    }

    public Long getPriceListId() {
        return this.priceListId;
    }

    public void setPriceListId(Long priceListId) {
        this.priceListId = priceListId;
    }

    public Date getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

}
