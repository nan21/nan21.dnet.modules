/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.fin.domain.eventhandler;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.descriptors.ClassExtractor;
import org.eclipse.persistence.sessions.Record;
import org.eclipse.persistence.sessions.Session;

import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;

public class PaymentEventHandler extends DefaultEventHandler {

	public void customize(ClassDescriptor descriptor) {
		super.customize(descriptor);
		descriptor.getInheritancePolicy().setShouldOuterJoinSubclasses(true);
		descriptor.getInheritancePolicy().setClassExtractor(
				new ClassExtractor() {
					@Override
					public Class<?> extractClassFromRow(Record row,
							Session session) {
						return Payment.class;
					}
				});
		descriptor.getInheritancePolicy().setClassIndicatorField(null);
	}

}
