/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.domain.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

public interface IPayrollService extends IEntityService<Payroll> {

    public Payroll findByName(Long clientId, String name);

}
