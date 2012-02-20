package net.nan21.dnet.module.ad._presenterdelegates.impex;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.impex.ds.filter.ImportMapItemDsFilter;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs;
import net.nan21.dnet.module.ad.impex.ds.param.ImportMapItemDsParam;

public class ImportFromMapItemDelegate extends AbstractDsDelegate {

	public void execute(ImportMapItemDs ds) throws Exception {
		String fileName = ds.getFileName();
		String dsName = ds.getDataSource() + "Ds";
		String path = Session.params.get().getDefaultImportPath();
		if (ds.getUkFieldName() != null && !ds.getUkFieldName().equals("")) {
			this.findDsService(dsName).doImport(fileName, path,
					ds.getUkFieldName(), 0);
		} else {
			this.findDsService(dsName).doImport(fileName, path);
		}
	}

	public void importFile(ImportMapItemDsFilter ds, ImportMapItemDsParam params)
			throws Exception {
		String fileName = params.getImportFileLocation();
		String dsName = params.getImportDataSource() + "Ds";
		  
		if (params.getImportUkFieldName() != null
				&& !params.getImportUkFieldName().equals("")) {
			this.findDsService(dsName).doImport(fileName,
					params.getImportUkFieldName(), 0);
		} else {
			this.findDsService(dsName).doImport(fileName);
		}

	}
}
