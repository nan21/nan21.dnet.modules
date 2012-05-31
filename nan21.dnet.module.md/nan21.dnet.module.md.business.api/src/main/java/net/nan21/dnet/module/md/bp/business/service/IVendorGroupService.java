/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;

import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;

public interface IVendorGroupService extends IEntityService<VendorGroup> {

    public VendorGroup findByCode(String code);

    public VendorGroup findByName(String name);

    public List<VendorGroup> findByPaymentMethod(PaymentMethod paymentMethod);

    public List<VendorGroup> findByPaymentMethodId(Long paymentMethodId);

    public List<VendorGroup> findByPaymentTerm(PaymentTerm paymentTerm);

    public List<VendorGroup> findByPaymentTermId(Long paymentTermId);

}
