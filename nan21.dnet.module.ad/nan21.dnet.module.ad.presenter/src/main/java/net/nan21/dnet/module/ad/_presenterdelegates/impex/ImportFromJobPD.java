package net.nan21.dnet.module.ad._presenterdelegates.impex;

import java.util.List;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.impex.business.service.IImportJobItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;
import net.nan21.dnet.module.ad.impex.ds.model.ImportJobDs;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapDs;

public class ImportFromJobPD extends AbstractDsDelegate {

	public void execute(ImportJobDs ds) throws Exception {
		IImportJobItemService srv = (IImportJobItemService) this
				.findEntityService(ImportJobItem.class);

		List<ImportJobItem> items = srv
				.getEntityManager()
				.createQuery(
						"select e from ImportJobItem e where e.job.id = :pJobId and e.active = true order by e.sequenceNo",
						ImportJobItem.class).setParameter("pJobId", ds.getId())
				.getResultList();

		ImportFromMapPD d = new ImportFromMapPD();
		this.prepareDelegate(d);		 
		for (ImportJobItem item : items) {
			ImportMapDs mapDs = new ImportMapDs();
			mapDs.setId(item.getMap().getId());
			d.execute(mapDs);
		}

	}

}
