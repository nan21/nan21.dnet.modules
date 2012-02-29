package net.nan21.dnet.module.ad._domainext;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.ad.system.domain.entity.AuditEntry;
import net.nan21.dnet.module.ad.system.domain.entity.AuditField;

import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.eclipse.persistence.queries.InsertObjectQuery;
import org.eclipse.persistence.queries.WriteObjectQuery;
import org.eclipse.persistence.sessions.changesets.ChangeRecord;
import org.eclipse.persistence.sessions.changesets.DirectToFieldChangeRecord;

public class AuditableEventHandler extends DefaultEventHandler implements
		DescriptorCustomizer {

	@Override
	public void customize(ClassDescriptor descriptor) {
		super.customize(descriptor);
		descriptor.getEventManager().addListener(this);
	}

	@Override
	public void postInsert(DescriptorEvent event) {
		this.processWriteEvent(event);
	}

	@Override
	public void postUpdate(DescriptorEvent event) {
		this.processWriteEvent(event);
	}

	protected void processWriteEvent(DescriptorEvent event) {
		AuditEntry entry = new AuditEntry();
		entry.setOperation(event.getEventCode() == 7 ? "update" : "insert");
		Object source = event.getSource();
		entry.setSourceFQN(source.getClass().getCanonicalName());

		if (source instanceof IModelWithId
				&& ((IModelWithId) source).getId() != null) {
			entry.setSourceId(((IModelWithId) source).getId().toString());
		}

		Collection<AuditField> fields = new LinkedList<AuditField>();
		WriteObjectQuery query = (WriteObjectQuery) event.getQuery();
		List<ChangeRecord> changes = query.getObjectChangeSet().getChanges();
		for (int i = 0; i < changes.size(); i++) {
			if (changes.get(i) instanceof DirectToFieldChangeRecord) {
				DirectToFieldChangeRecord fieldChange = (DirectToFieldChangeRecord) changes
						.get(i);
				if (!fieldChange.getAttribute().equals("version")) {
					AuditField field = new AuditField();
					field.setAuditEntry(entry);
					field.setFieldName(fieldChange.getAttribute());
					if(fieldChange.getNewValue()!=null) {
						field.setNewValue(fieldChange.getNewValue().toString());
					}
					if(fieldChange.getOldValue()!=null) {
						field.setOldValue(fieldChange.getOldValue().toString());
					}
					
					fields.add(field);
				}
			}
		}
		entry.setAuditFields(fields);

		InsertObjectQuery insertQuery = new InsertObjectQuery(entry);
		event.getSession().executeQuery(insertQuery);

		for (AuditField field : fields) {
			insertQuery = new InsertObjectQuery(field);
			event.getSession().executeQuery(insertQuery);
		}
	}

}
