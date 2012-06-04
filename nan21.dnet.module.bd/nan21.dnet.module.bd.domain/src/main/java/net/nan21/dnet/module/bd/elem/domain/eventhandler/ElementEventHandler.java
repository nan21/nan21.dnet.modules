/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.elem.domain.eventhandler;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.descriptors.ClassExtractor;
import org.eclipse.persistence.sessions.Record;
import org.eclipse.persistence.sessions.Session;

import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;

public class ElementEventHandler extends DefaultEventHandler {

	public void customize(ClassDescriptor descriptor) {
		super.customize(descriptor);
		descriptor.getInheritancePolicy().setShouldOuterJoinSubclasses(true);
		descriptor.getInheritancePolicy().setClassExtractor(
				new ClassExtractor() {
					@Override
					public Class<?> extractClassFromRow(Record row,
							Session session) {
						return Element.class;
					}
				});
		descriptor.getInheritancePolicy().setClassIndicatorField(null);
	}

}
