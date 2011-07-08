package net.nan21.dnet.module.ad._delegates;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs;

public class ImportFromMapItem extends AbstractDsDelegate<ImportMapItemDs>{

	@Override
	public void execute(ImportMapItemDs ds) throws Exception {		
		String fileName = ds.getFileName();
        String dsName = ds.getDataSource()+"Ds";
        String path = "D:/work/dnet/product/dnet.src/nan21-dnet/dnet-data/src/main/resources";
        this.findDsService(dsName).doImport(fileName, path);
	}

}
