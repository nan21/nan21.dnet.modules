/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.system.business.service.ISysJobCtxService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.system.ds.model.SysTimerDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysTimer;

public class SysTimerDsConv extends AbstractDsConverter<SysTimerDs, SysTimer>
        implements IDsConverter<SysTimerDs, SysTimer> {

    @Override
    protected void modelToEntityReferences(SysTimerDs ds, SysTimer e,
            boolean isInsert) throws Exception {

        if (ds.getJobCtxId() != null) {
            if (e.getJobCtx() == null
                    || !e.getJobCtx().getId().equals(ds.getJobCtxId())) {
                e.setJobCtx((SysJobCtx) this.em.find(SysJobCtx.class,
                        ds.getJobCtxId()));
            }
        } else {
            this.lookup_jobCtx_SysJobCtx(ds, e);
        }

    }

    protected void lookup_jobCtx_SysJobCtx(SysTimerDs ds, SysTimer e)
            throws Exception {
        if (ds.getJobCtx() != null && !ds.getJobCtx().equals("")) {
            SysJobCtx x = null;
            try {
                x = ((ISysJobCtxService) findEntityService(SysJobCtx.class))
                        .findByName(ds.getJobCtx());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SysJobCtx` reference:  `jobCtx` = "
                                + ds.getJobCtx() + "  ");
            }
            e.setJobCtx(x);

        } else {
            e.setJobCtx(null);
        }
    }

}
