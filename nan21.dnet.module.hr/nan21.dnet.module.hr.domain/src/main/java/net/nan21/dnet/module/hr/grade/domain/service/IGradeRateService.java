/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;

import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;

public interface IGradeRateService extends IEntityService<GradeRate> {

    public GradeRate findByName(Long clientId, String name);

    public List<GradeRate> findByCurrency(Currency currency);

    public List<GradeRate> findByCurrencyId(Long currencyId);

}
