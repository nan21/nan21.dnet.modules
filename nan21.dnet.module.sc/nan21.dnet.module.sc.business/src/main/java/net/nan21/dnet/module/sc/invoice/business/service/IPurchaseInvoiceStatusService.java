/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceStatus;

public interface IPurchaseInvoiceStatusService extends
        IEntityService<PurchaseInvoiceStatus> {

    public PurchaseInvoiceStatus findByName(String name);

}
