/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityBaseEventHandler;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

public class SalesOrderEventHandler extends DomainEntityBaseEventHandler {

    @Override
    public void preInsert(DescriptorEvent event) {
        SalesOrder e = (SalesOrder) event.getSource();
    }

    @Override
    public void preUpdate(DescriptorEvent event) {
        SalesOrder e = (SalesOrder) event.getSource();
    }
}
