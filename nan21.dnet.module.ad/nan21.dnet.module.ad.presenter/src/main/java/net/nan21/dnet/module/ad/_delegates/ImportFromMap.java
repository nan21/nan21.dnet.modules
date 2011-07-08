package net.nan21.dnet.module.ad._delegates;

import java.util.List;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.impex.business.service.IImportMapItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapDs;

public class ImportFromMap extends AbstractDsDelegate<ImportMapDs>{

	@Override
	public void execute(ImportMapDs ds) throws Exception {
		// TODO Auto-generated method stub
		IImportMapItemService srv = 
			(IImportMapItemService)this.findEntityService(ImportMapItem.class);
		List<ImportMapItem> items = srv.getEntityManager()
			.createQuery( "select e from ImportMapItem e where e.active = true and e.importMap.id = :pImportMapId order by e.sequenceNo ")
                .setParameter("pImportMapId", ds.getId()).getResultList();
		 
		for(ImportMapItem item: items) {
			String fileName = item.getFileName();
	        String dsName = item.getDataSourceName()+"Ds";
	        String path = "D:/work/dnet/product/dnet.src/nan21-dnet/dnet-data/src/main/resources";
	        this.findDsService(dsName).doImport(fileName, path);
		}
		
	}

}
