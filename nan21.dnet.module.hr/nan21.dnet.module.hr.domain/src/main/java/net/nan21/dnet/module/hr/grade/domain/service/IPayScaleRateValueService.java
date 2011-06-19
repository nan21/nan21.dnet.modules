/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;

import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRateValue;

public interface IPayScaleRateValueService extends
        IEntityService<PayScaleRateValue> {

    public List<PayScaleRateValue> findByScaleRate(PayScaleRate scaleRate);

    public List<PayScaleRateValue> findByScaleRateId(Long scaleRateId);

    public List<PayScaleRateValue> findByScalePoint(PayScalePoint scalePoint);

    public List<PayScaleRateValue> findByScalePointId(Long scalePointId);

}
