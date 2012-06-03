/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.system.business.service.ISysJobCtxService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.system.ds.model.SysJobCtxParamDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtxParam;

public class SysJobCtxParamDsConv extends
        AbstractDsConverter<SysJobCtxParamDs, SysJobCtxParam> implements
        IDsConverter<SysJobCtxParamDs, SysJobCtxParam> {

    @Override
    protected void modelToEntityReferences(SysJobCtxParamDs ds,
            SysJobCtxParam e, boolean isInsert) throws Exception {

        if (ds.getJobCtxId() != null) {
            if (e.getJobCtx() == null
                    || !e.getJobCtx().getId().equals(ds.getJobCtxId())) {
                e.setJobCtx((SysJobCtx) this.em.find(SysJobCtx.class,
                        ds.getJobCtxId()));
            }
        } else {
            this.lookup_jobCtx_SysJobCtx(ds, e);
        }

        if (ds.getJobParamId() != null) {
            if (e.getJobParam() == null
                    || !e.getJobParam().getId().equals(ds.getJobParamId())) {
                e.setJobParam((SysJobParam) this.em.find(SysJobParam.class,
                        ds.getJobParamId()));
            }
        }

    }

    protected void lookup_jobCtx_SysJobCtx(SysJobCtxParamDs ds, SysJobCtxParam e)
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
