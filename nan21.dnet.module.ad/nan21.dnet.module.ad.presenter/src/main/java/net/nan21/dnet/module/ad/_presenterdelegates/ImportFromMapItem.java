package net.nan21.dnet.module.ad._presenterdelegates;
 
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs;

public class ImportFromMapItem extends BaseDsDelegate<ImportMapItemDs,EmptyParam> {

	@Override
	public void execute(ImportMapItemDs ds) throws Exception {		
		String fileName = ds.getFileName();
        String dsName = ds.getDataSource()+"Ds";
        String path = "D:/work/dnet/product/dnet.src/nan21-dnet/dnet-data/src/main/resources";
        this.findDsService(dsName).doImport(fileName, path);
	}

}
