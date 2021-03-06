/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

public interface IPayrollService extends IEntityService<Payroll> {

    public Payroll findByName(String name);

    public List<Payroll> findByEngine(Engine engine);

    public List<Payroll> findByEngineId(Long engineId);

}
