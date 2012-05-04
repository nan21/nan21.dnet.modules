/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;

import net.nan21.dnet.module.md.org.domain.entity.PayAccountMethod;

public interface IPayAccountMethodService extends
        IEntityService<PayAccountMethod> {

    public PayAccountMethod findByAccount_mtd(PayAccount payAccount,
            PaymentMethod payMethod);

    public PayAccountMethod findByAccount_mtd(Long payAccountId,
            Long payMethodId);

    public List<PayAccountMethod> findByPayAccount(PayAccount payAccount);

    public List<PayAccountMethod> findByPayAccountId(Long payAccountId);

    public List<PayAccountMethod> findByPayMethod(PaymentMethod payMethod);

    public List<PayAccountMethod> findByPayMethodId(Long payMethodId);

}
