package net.nan21.dnet.module.ad._presenterdelegates.system;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.descriptor.IDsDefinition;
import net.nan21.dnet.core.api.descriptor.IDsDefinitions;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.system.business.service.ISysDataSourceService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;
import net.nan21.dnet.module.ad.system.ds.model.SysDataSourceDs;
 
public class SysDataSourceDelegate extends BaseDsDelegate<SysDataSourceDs, EmptyParam> {
 
	public void synchronizeCatalog(SysDataSourceDs ds) throws Exception {
		List<IDsDefinitions> list = (List<IDsDefinitions>)appContext.getBean("osgiDsDefinitions");
		ISysDataSourceService srv = (ISysDataSourceService)this.findEntityService(SysDataSource.class);
		
		List<SysDataSource> result = new ArrayList<SysDataSource>();
		for(IDsDefinitions dsdefs:list) {
			for (IDsDefinition def : dsdefs.getDsDefinitions()) {				
				SysDataSource e = new SysDataSource();
				e.setName(def.getName());
				e.setModel(def.getModelClass().getCanonicalName());
				e.setController(def.getModelClass().getCanonicalName());
				
				Field[] fields = def.getModelClass().getDeclaredFields();
				for(Field field:fields) {
	                if ( ! Modifier.isStatic(field.getModifiers()) && !field.getName().equals("_refPaths_") && !field.getName().equals("_joins_")) {
	                    SysDsField f = new SysDsField();
	                    f.setName(field.getName());
	                    f.setActive(true);
	                    f.setDataType(field.getType().getCanonicalName());
	                    e.addToFields(f);
	                }	                
	            }
				result.add(e);
			}
		}
		srv.deleteAll();
		srv.insert(result);		
	}
}