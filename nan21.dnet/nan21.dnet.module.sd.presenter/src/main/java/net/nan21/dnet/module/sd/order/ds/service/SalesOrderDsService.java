/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.service;

import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.AbstractDsService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.ds.filter.SalesOrderDsFilter;

import net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs;
import net.nan21.dnet.core.api.session.Session;

public class SalesOrderDsService
        extends
        AbstractDsService<SalesOrderDs, SalesOrderDsFilter, EmptyParam, SalesOrder>
        implements IDsService<SalesOrderDs, SalesOrderDsFilter, EmptyParam> {

    @Override
    public void preInsert(SalesOrderDs ds, EmptyParam params) {
        ds.setDocDate(Session.user.get().getClientCode());
    }
}
