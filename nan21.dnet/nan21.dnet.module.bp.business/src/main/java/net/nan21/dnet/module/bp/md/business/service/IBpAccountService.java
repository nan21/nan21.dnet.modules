/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bp.base.domain.entity.CustomerGroup;
import net.nan21.dnet.module.bp.base.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentTerm;
import net.nan21.dnet.module.bp.base.domain.entity.VendorGroup;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

import net.nan21.dnet.module.bp.md.domain.entity.BpAccount;

public interface IBpAccountService extends IEntityService<BpAccount> {

    public List<BpAccount> findByBp(BusinessPartner bp);

    public List<BpAccount> findByBpId(Long bpId);

    public List<BpAccount> findByOrganization(Organization organization);

    public List<BpAccount> findByOrganizationId(Long organizationId);

    public List<BpAccount> findByCustGroup(CustomerGroup custGroup);

    public List<BpAccount> findByCustGroupId(Long custGroupId);

    public List<BpAccount> findByCustPaymentMethod(
            PaymentMethod custPaymentMethod);

    public List<BpAccount> findByCustPaymentMethodId(Long custPaymentMethodId);

    public List<BpAccount> findByCustPaymentTerm(PaymentTerm custPaymentTerm);

    public List<BpAccount> findByCustPaymentTermId(Long custPaymentTermId);

    public List<BpAccount> findByCustDeliveryMethod(
            DeliveryMethod custDeliveryMethod);

    public List<BpAccount> findByCustDeliveryMethodId(Long custDeliveryMethodId);

    public List<BpAccount> findByVendGroup(VendorGroup vendGroup);

    public List<BpAccount> findByVendGroupId(Long vendGroupId);

    public List<BpAccount> findByVendPaymentMethod(
            PaymentMethod vendPaymentMethod);

    public List<BpAccount> findByVendPaymentMethodId(Long vendPaymentMethodId);

    public List<BpAccount> findByVendPaymentTerm(PaymentTerm vendPaymentTerm);

    public List<BpAccount> findByVendPaymentTermId(Long vendPaymentTermId);

}
