package net.nan21.dnet.module.md._presenterdelegates.tx.fin;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.md.tx.fin.business.service.IAccDocService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.fin.ds.model.AccDocDs;

public class AccDocPD extends AbstractDsDelegate {

	public void post(AccDocDs ds) throws Exception {
		IAccDocService srv = ((IAccDocService) this
				.findEntityService(AccDoc.class));
		AccDoc e = srv.findById(ds.getId());
		srv.doPost(e);
	}

	public void unPost(AccDocDs ds) throws Exception {
		IAccDocService srv = ((IAccDocService) this
				.findEntityService(AccDoc.class));
		AccDoc e = srv.findById(ds.getId());
		srv.doUnPost(e);
	}

}
