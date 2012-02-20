/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceType;

public interface ISalesInvoiceTypeService extends
        IEntityService<SalesInvoiceType> {

    public SalesInvoiceType findByName(String name);

}
