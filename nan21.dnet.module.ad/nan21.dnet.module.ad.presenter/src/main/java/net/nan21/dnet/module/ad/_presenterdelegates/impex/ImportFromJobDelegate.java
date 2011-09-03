package net.nan21.dnet.module.ad._presenterdelegates.impex;

import java.util.List;

import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.impex.business.service.IImportJobItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;
import net.nan21.dnet.module.ad.impex.ds.model.ImportJobDs;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapDs;

public class ImportFromJobDelegate extends BaseDsDelegate<ImportJobDs, EmptyParam>{

	@Override
	public void execute(ImportJobDs ds) throws Exception {
		IImportJobItemService srv = (IImportJobItemService)this.findEntityService(ImportJobItem.class);
		List<ImportJobItem> items = srv.findByJobId(ds.getId());
		ImportFromMapDelegate d = new ImportFromMapDelegate();
		d.setAppContext(appContext);
		d.setEntityServiceFactories(this.entityServiceFactories);
		for (ImportJobItem item: items) {
			ImportMapDs mapDs = new ImportMapDs();
			mapDs.setId(item.getMap().getId());			
			d.execute(mapDs);
		}

	}

}
