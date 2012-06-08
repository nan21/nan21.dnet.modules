package net.nan21.dnet.module.bd._businessdelegates;

import java.util.ArrayList;

import net.nan21.dnet.core.api.setup.ISetupParticipant;
import net.nan21.dnet.core.api.setup.ISetupTask;
import net.nan21.dnet.core.business.service.AbstractBusinessSetupParticipant;

public class Setup_BD extends AbstractBusinessSetupParticipant implements
		ISetupParticipant {

	@Override
	protected void onExecute() throws Exception {
	}

	@Override
	protected void init() {
		this.targetName = "DNet-BD";
		this.createTasks();
	}

	private void createTasks() {
		this.tasks = new ArrayList<ISetupTask>();
		// there is nothing to setup here , this one is run to enforce that the
		// database objects are created in the right order
		// in case the object creation is managed by eclipselink
		@SuppressWarnings("unused")
		Long i = (Long) this.em.createQuery("select count(e) from Country e")
				.getResultList().get(0);

	}

}
