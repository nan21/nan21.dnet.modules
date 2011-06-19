/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.domain.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;

public interface IPayScaleService extends IEntityService<PayScale> {

    public PayScale findByCode(Long clientId, String code);

    public PayScale findByName(Long clientId, String name);

}