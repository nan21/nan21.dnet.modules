/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;

import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

public interface IPayScalePointService extends IEntityService<PayScalePoint> {

    public PayScalePoint findByScale_code(PayScale payScale, String code);

    public PayScalePoint findByScale_code(Long payScaleId, String code);

    public List<PayScalePoint> findByPayScale(PayScale payScale);

    public List<PayScalePoint> findByPayScaleId(Long payScaleId);

}
