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
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportFieldService;
import net.nan21.dnet.module.ad.impex.business.service.ICsvExportService;
import net.nan21.dnet.module.ad.impex.business.service.IExportMapItemService;
import net.nan21.dnet.module.ad.impex.business.service.IExportMapService;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExport;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportField;
import net.nan21.dnet.module.ad.impex.domain.entity.CsvExportSort;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMapItem;
import net.nan21.dnet.module.ad.impex.ds.model.ExportJobDs;
import net.nan21.dnet.module.ad.impex.ds.model.ExportJobItemDs;
import net.nan21.dnet.module.ad.impex.ds.model.ExportMapDs;
import net.nan21.dnet.module.ad.impex.ds.model.ExportMapItemDs;

public class ExportDelegate extends BaseDsDelegate {
 
	
	public void exportFromJob(ExportJobDs ds) throws Exception {
		IExportMapService srv = 
			(IExportMapService)this.findEntityService(ExportMap.class);
		List<Long> list = (List<Long>)srv.getEntityManager()
		.createQuery( "  select i.map.id from ExportJobItem i where i.active=true and i.job.id = :pJobId   ",Long.class)
            .setParameter("pJobId", ds.getId()).getResultList();		 
		for(Long id: list) {
			this.exportByMapId( id ); 	
		}
	}
	
	public void exportFromJobItem(ExportJobItemDs ds) throws Exception {
		this.exportByMapId( ds.getMapId()); 		 
	}
	
	
	public void exportFromMap(ExportMapDs ds) throws Exception {		
		this.exportByMapId(ds.getId());
	}
	
	public void exportFromMapItem(ExportMapItemDs ds) throws Exception {
		CsvExport csvExport = ((ICsvExportService)this.findEntityService(CsvExport.class)).findById(ds.getCsvExportId());
		this.doWork(csvExport);		
	}
	
	private void exportByMapId(Long mapId) throws Exception {
		ICsvExportService srv = 
			(ICsvExportService)this.findEntityService(CsvExport.class);
		
		List<CsvExport> list = (List<CsvExport>)srv.getEntityManager()
			.createQuery( "select e from CsvExport e " +
					"where e.active = true " +
					"  and e.id in ( select i.csvExport.id from ExportMapItem i where i.active=true and i.exportMap.id = :pMapId )  ",CsvExport.class)
                .setParameter("pMapId", mapId).getResultList();		 
		for(CsvExport item: list) {
			this.doWork(item );
		}
	}
	
	private void doWork(CsvExport csvExport) throws Exception {
 
		ICsvExportFieldService csvExportFieldService = (ICsvExportFieldService) this.findEntityService(CsvExportField.class);
  
		IDsService dsService = findDsService(csvExport.getDataSource() + "Ds");
		IQueryBuilder builder = dsService.createQueryBuilder();
		IDsExport writer =  new DsCsvExport(dsService.getModelClass());
		 
		List<String> fieldNames = new ArrayList<String>();
		//List<CsvExportField> fields = csvExportFieldService.findByCsvExport(csvExport);
		
		List<CsvExportField> fields = csvExportFieldService.getEntityManager()
		.createQuery( "select e from CsvExportField e " +
				"where e.active = true " +
				"  and e.csvExport.id = :csvExportId " +
				" order by e.sequenceNo  ",CsvExportField.class)
            .setParameter("csvExportId", csvExport.getId()).getResultList();
		 
		for (CsvExportField f: fields ) {
			fieldNames.add(f.getDsField());			 
		}		
		List<CsvExportSort> sorts = csvExportFieldService.getEntityManager()
		.createQuery( "select e from CsvExportSort e " +
				"where e.csvExport.id = :csvExportId " +
				" order by e.sequenceNo  ",CsvExportSort.class)
            .setParameter("csvExportId", csvExport.getId()).getResultList();
		List<SortToken> sortTokens = new ArrayList<SortToken>();
		for (CsvExportSort s: sorts ) {
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
		String theFile = Session.params.get().getDefaultExportPath() + "/" +csvExport.getDataSource()+".csv";
		writer.setOutFile(new File(theFile));
 
		dsService.doExport(null, null, builder, writer);
	}
	
}
