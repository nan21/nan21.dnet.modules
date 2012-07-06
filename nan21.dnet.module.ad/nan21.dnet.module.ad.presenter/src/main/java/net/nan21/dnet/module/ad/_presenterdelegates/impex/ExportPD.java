package net.nan21.dnet.module.ad._presenterdelegates.impex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.action.IDsExport;
import net.nan21.dnet.core.api.action.IQueryBuilder;
import net.nan21.dnet.core.api.action.SortToken;
import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.action.DsCsvExport;
import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportFieldService;
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportService;
import net.nan21.dnet.module.ad.impex.business.service.IExportMapItemService;
import net.nan21.dnet.module.ad.impex.business.service.IExportMapService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportSort;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJobItem;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;
import net.nan21.dnet.module.ad.impex.ds.model.ExportJobDs;
import net.nan21.dnet.module.ad.impex.ds.model.ExportJobItemDs;
import net.nan21.dnet.module.ad.impex.ds.model.ExportMapDs;
import net.nan21.dnet.module.ad.impex.ds.model.ExportMapItemDs;

public class ExportPD extends AbstractDsDelegate {

	/**
	 * Execute an export job export
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void exportFromJob(ExportJobDs ds) throws Exception {
		IExportMapService srv = (IExportMapService) this
				.findEntityService(ExportMap.class);
		List<Long> list = (List<Long>) srv.getEntityManager().createQuery(
				"  select i.map.id from " + ExportJobItem.class.getSimpleName()
						+ " i where i.active=true and i.job.id = :pJobId   ",
				Long.class).setParameter("pJobId", ds.getId()).getResultList();
		for (Long id : list) {
			this.exportByMapId(id);
		}
	}

	/**
	 * Execute an export job-item export
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void exportFromJobItem(ExportJobItemDs ds) throws Exception {
		this.exportByMapId(ds.getMapId());
	}

	/**
	 * Execute an export map export
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void exportFromMap(ExportMapDs ds) throws Exception {
		this.exportByMapId(ds.getId());
	}

	/**
	 * Execute an export map-item export
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void exportFromMapItem(ExportMapItemDs ds) throws Exception {
		ExportMapItem mapItem = ((IExportMapItemService) this
				.findEntityService(ExportMapItem.class)).findById(ds.getId());
		this.doWork(mapItem);
	}

	/**
	 * Worker to export a map-item
	 * 
	 * @param mapId
	 * @throws Exception
	 */
	private void exportByMapId(Long mapId) throws Exception {
		ICsvExportService srv = (ICsvExportService) this
				.findEntityService(CsvExport.class);

		String mapItemEql = "select e from "
				+ ExportMapItem.class.getSimpleName()
				+ " e where e.active=true and e.exportMap.id = :pMapId"
				+ " and e.csvExport.active = true ";

		List<ExportMapItem> list = srv.getEntityManager().createQuery(
				mapItemEql, ExportMapItem.class).setParameter("pMapId", mapId)
				.getResultList();

		for (ExportMapItem mapItem : list) {
			this.doWork(mapItem);
		}
	}

	@SuppressWarnings("unchecked")
	private void doWork(ExportMapItem mapItem) throws Exception {

		ExportMap map = mapItem.getExportMap();
		CsvExport csvExport = mapItem.getCsvExport();
		File file = null;

		String _itemPath = mapItem.getPath();
		String _path = _itemPath;
		String _mapPath = map.getPath();
		String _clientExportPath = Session.params.get().getDefaultExportPath();

		String _fileName = mapItem.getFileName();

		if (_fileName == null || _fileName.equals("")) {
			_fileName = csvExport.getDataSource() + ".csv";
		}

		if (!(new File(_path)).isAbsolute()) {
			if (_mapPath != null && !_mapPath.equals("")) {
				_path = _mapPath + File.separator + _path;
			}

			if (!(new File(_path)).isAbsolute()) {
				if (_clientExportPath != null && !_clientExportPath.equals("")) {
					_path = _clientExportPath + File.separator + _path;
				} else {
					throw new Exception(
							"Cannot export file. All paths are relative but client level export path is not set.");
				}
			}
		}

		_fileName = _path + File.separator + _fileName;

		try {
			File dir = new File(_path);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			file = new File(_fileName);
		} catch (Exception e) {
			throw new Exception("Cannot create file `" + _fileName
					+ "`. Reason: " + e.getMessage());
		}

		try {

			ICsvExportFieldService csvExportFieldService = (ICsvExportFieldService) this
					.findEntityService(CsvExportField.class);

			IDsService dsService = findDsService(csvExport.getDataSource()
					+ "Ds");
			IQueryBuilder builder = dsService.createQueryBuilder();
			IDsExport writer = new DsCsvExport(dsService.getModelClass());

			List<String> fieldNames = new ArrayList<String>();

			List<CsvExportField> fields = csvExportFieldService
					.getEntityManager().createQuery(
							"select e from "
									+ CsvExportField.class.getSimpleName()
									+ " e " + "where e.active = true "
									+ "  and e.csvExport.id = :csvExportId "
									+ " order by e.sequenceNo  ",
							CsvExportField.class).setParameter("csvExportId",
							csvExport.getId()).getResultList();

			for (CsvExportField f : fields) {
				fieldNames.add(f.getDsField());
			}
			List<CsvExportSort> sorts = csvExportFieldService
					.getEntityManager().createQuery(
							"select e from "
									+ CsvExportSort.class.getSimpleName()
									+ " e "
									+ "where e.csvExport.id = :csvExportId "
									+ " order by e.sequenceNo  ",
							CsvExportSort.class).setParameter("csvExportId",
							csvExport.getId()).getResultList();
			List<SortToken> sortTokens = new ArrayList<SortToken>();
			for (CsvExportSort s : sorts) {
				SortToken t = new SortToken();
				t.setProperty(s.getDsField());
				if (s.getDescend()) {
					t.setDirection("desc");
				} else {
					t.setDirection("asc");
				}
				sortTokens.add(t);
			}

			builder.addSortInfo(sortTokens);
			writer.setFieldNames(fieldNames);
			writer.setOutFile(file);
			dsService.doExport(null, null, builder, writer);

		} catch (Exception e) {
			throw new Exception("Cannot export csvExport `"
					+ mapItem.getCsvExport().getName() + "`. Reason: "
					+ e.getMessage());
		}

	}

}
