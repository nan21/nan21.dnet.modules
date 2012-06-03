/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;

import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;

public interface IPayrollElementService extends IEntityService<PayrollElement> {

    public PayrollElement findByEngine_code(Engine engine, String code);

    public PayrollElement findByEngine_code(Long engineId, String code);

    public List<PayrollElement> findByAccItem(AccItem accItem);

    public List<PayrollElement> findByAccItemId(Long accItemId);

    public List<PayrollElement> findBySourceElement(PayrollElement sourceElement);

    public List<PayrollElement> findBySourceElementId(Long sourceElementId);

}
