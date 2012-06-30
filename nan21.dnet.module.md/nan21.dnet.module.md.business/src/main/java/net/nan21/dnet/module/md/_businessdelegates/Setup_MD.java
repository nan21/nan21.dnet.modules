package net.nan21.dnet.module.md._businessdelegates;

import java.util.ArrayList;

import net.nan21.dnet.core.api.setup.ISetupParticipant;
import net.nan21.dnet.core.api.setup.ISetupTask;
import net.nan21.dnet.core.business.service.AbstractBusinessSetupParticipant;
import net.nan21.dnet.module.md.bp.domain.entity.Bank;

public class Setup_MD extends AbstractBusinessSetupParticipant implements
		ISetupParticipant {

	@Override
	protected void onExecute() throws Exception {
	}

	@Override
	protected void init() {
		this.targetName = "DNet-MD";
		this.createTasks();
	}

	private void createTasks() {
		this.tasks = new ArrayList<ISetupTask>();
		// there is nothing to setup here, this one is run to enforce that the
		// database objects are created in the right order
		// in case the object creation is managed by eclipselink
		Long i = (Long) this.getEntityManager().createQuery(
				"select count(e) from " + Bank.class.getSimpleName() + " e")
				.getResultList().get(0);

	}

}
