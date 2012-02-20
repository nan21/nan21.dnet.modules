package net.nan21.dnet.module.ad._presenterdelegates.impex;

import java.util.List;
 
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.impex.business.service.IImportMapItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapDs;

public class ImportFromMapDelegate extends AbstractDsDelegate {

	public void execute(ImportMapDs ds) throws Exception {
		 
		IImportMapItemService srv = 
			(IImportMapItemService)this.findEntityService(ImportMapItem.class);
		List<ImportMapItem> items = srv.getEntityManager()
			.createQuery( "select e from ImportMapItem e where e.active = true and e.importMap.id = :pImportMapId order by e.sequenceNo ")
                .setParameter("pImportMapId", ds.getId()).getResultList();
		 
		for(ImportMapItem item: items) {
			String fileName = item.getFileName();
	        String dsName = item.getDataSourceName()+"Ds";
	        String path = Session.params.get().getDefaultImportPath();	        	
	        if (item.getUkFieldName() != null && !item.getUkFieldName().equals("")) {
				this.findDsService(dsName).doImport(fileName, path, item.getUkFieldName(), 0);
			} else {
				this.findDsService(dsName).doImport(fileName, path);
			}
		}
		
	}

}
