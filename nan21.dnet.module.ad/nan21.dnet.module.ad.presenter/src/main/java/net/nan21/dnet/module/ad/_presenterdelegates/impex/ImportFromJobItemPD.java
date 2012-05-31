package net.nan21.dnet.module.ad._presenterdelegates.impex;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.impex.ds.model.ImportJobItemDs;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapDs;

public class ImportFromJobItemPD extends AbstractDsDelegate {

	public void execute(ImportJobItemDs ds) throws Exception {
		ImportMapDs mapDs = new ImportMapDs();
		mapDs.setId(ds.getMapId());
		
		ImportFromMapPD mapDelegate = new ImportFromMapPD();
		mapDelegate.setAppContext(this.getAppContext());
		mapDelegate.equals(mapDs);
	}

}
