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

import net.nan21.dnet.module.bp.base.domain.entity.VendorGroup;

public interface IVendorGroupService extends IEntityService<VendorGroup> {

    public VendorGroup findByCode(Long clientId, String code);

    public VendorGroup findByName(Long clientId, String name);

    public List<VendorGroup> findByPaymentMethod(PaymentMethod paymentMethod);

    public List<VendorGroup> findByPaymentMethodId(Long paymentMethodId);

    public List<VendorGroup> findByPaymentTerm(PaymentTerm paymentTerm);

    public List<VendorGroup> findByPaymentTermId(Long paymentTermId);

}
