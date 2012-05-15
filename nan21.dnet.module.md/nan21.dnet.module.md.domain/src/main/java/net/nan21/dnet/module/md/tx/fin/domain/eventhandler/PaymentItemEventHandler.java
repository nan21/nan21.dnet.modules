/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.fin.domain.eventhandler;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

public class PaymentItemEventHandler extends DefaultEventHandler {

    @Override
    public void preInsert(DescriptorEvent event) {
        PaymentItem e = (PaymentItem) event.getSource();
    }

    @Override
    public void preUpdate(DescriptorEvent event) {
        PaymentItem e = (PaymentItem) event.getSource();
    }
}
