/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityBaseEventHandler;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

public class SalesOrderItemEventHandler extends DomainEntityBaseEventHandler {

    @Override
    public void preInsert(DescriptorEvent event) {
        SalesOrderItem e = (SalesOrderItem) event.getSource();
    }

    @Override
    public void preUpdate(DescriptorEvent event) {
        SalesOrderItem e = (SalesOrderItem) event.getSource();
    }
}
