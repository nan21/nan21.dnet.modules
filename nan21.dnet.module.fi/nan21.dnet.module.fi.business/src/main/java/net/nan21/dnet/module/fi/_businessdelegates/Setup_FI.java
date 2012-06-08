package net.nan21.dnet.module.fi._businessdelegates;

import java.util.ArrayList;

import net.nan21.dnet.core.api.setup.ISetupParticipant;
import net.nan21.dnet.core.api.setup.ISetupTask;
import net.nan21.dnet.core.business.service.AbstractBusinessSetupParticipant;

public class Setup_FI extends AbstractBusinessSetupParticipant implements
		ISetupParticipant {

	@Override
	protected void init() {
		this.tasks = new ArrayList<ISetupTask>();
	}

	@Override
	protected void onExecute() throws Exception {

	}

}
