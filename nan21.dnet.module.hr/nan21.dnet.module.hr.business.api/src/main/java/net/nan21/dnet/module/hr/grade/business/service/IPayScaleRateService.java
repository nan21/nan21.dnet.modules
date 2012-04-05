/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;

import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;

public interface IPayScaleRateService extends IEntityService<PayScaleRate> {

    public PayScaleRate findByName(String name);

    public List<PayScaleRate> findByPayScale(PayScale payScale);

    public List<PayScaleRate> findByPayScaleId(Long payScaleId);

    public List<PayScaleRate> findByCurrency(Currency currency);

    public List<PayScaleRate> findByCurrencyId(Long currencyId);

}
