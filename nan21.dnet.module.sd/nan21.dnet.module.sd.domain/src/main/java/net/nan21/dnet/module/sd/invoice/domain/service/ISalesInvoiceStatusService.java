/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.domain.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceStatus;

public interface ISalesInvoiceStatusService extends
        IEntityService<SalesInvoiceStatus> {

    public SalesInvoiceStatus findByName(Long clientId, String name);

}