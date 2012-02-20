/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.base.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentTerm;

import net.nan21.dnet.module.bp.base.domain.entity.CustomerGroup;

public interface ICustomerGroupService extends IEntityService<CustomerGroup> {

    public CustomerGroup findByCode(String code);

    public CustomerGroup findByName(String name);

    public List<CustomerGroup> findByPaymentMethod(PaymentMethod paymentMethod);

    public List<CustomerGroup> findByPaymentMethodId(Long paymentMethodId);

    public List<CustomerGroup> findByPaymentTerm(PaymentTerm paymentTerm);

    public List<CustomerGroup> findByPaymentTermId(Long paymentTermId);

}
