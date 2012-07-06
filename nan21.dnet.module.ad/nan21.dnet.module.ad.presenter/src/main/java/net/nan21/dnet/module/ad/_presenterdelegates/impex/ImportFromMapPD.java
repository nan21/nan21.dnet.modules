package net.nan21.dnet.module.ad._presenterdelegates.impex;

import java.io.File;
import java.util.List;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.impex.business.service.IImportMapItemService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapDs;

public class ImportFromMapPD extends AbstractDsDelegate {

	public void execute(ImportMapDs ds) throws Exception {

		IImportMapItemService srv = (IImportMapItemService) this
				.findEntityService(ImportMapItem.class);
		List<ImportMapItem> items = srv
				.getEntityManager()
				.createQuery(
						"select e from "
								+ ImportMapItem.class.getSimpleName()
								+ " e where e.active = true and e.importMap.id = :pImportMapId order by e.sequenceNo ",
						ImportMapItem.class).setParameter("pImportMapId",
						ds.getId()).getResultList();

		for (ImportMapItem item : items) {
			String fileName = item.getFileName();
			String dsName = item.getDataSourceName() + "Ds";
			if (fileName == null || fileName.equals("")) {
				fileName = item.getDataSourceName() + ".csv";
			}
			if (!(new File(fileName)).isAbsolute()) {
				String _path = item.getPath();
				if (_path != null && !_path.equals("")) {
					fileName = _path + File.separator + fileName;
				}
				if (!(new File(fileName)).isAbsolute()) {
					_path = item.getImportMap().getPath();
					if (_path != null && !_path.equals("")) {
						fileName = _path + File.separator + fileName;
					}
					if (!(new File(fileName)).isAbsolute()) {
						fileName = Session.params.get().getDefaultImportPath()
								+ File.separator + fileName;
					}
				}
			}

			if (item.getUkFieldName() != null
					&& !item.getUkFieldName().equals("")) {
				this.findDsService(dsName).doImport(fileName,
						item.getUkFieldName(), 0);
			} else {
				this.findDsService(dsName).doImport(fileName);
			}
		}

	}

}
