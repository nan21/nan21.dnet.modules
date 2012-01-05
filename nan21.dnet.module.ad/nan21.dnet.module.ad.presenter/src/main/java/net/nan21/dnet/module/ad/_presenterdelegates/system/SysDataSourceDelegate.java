package net.nan21.dnet.module.ad._presenterdelegates.system;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.nan21.dnet.core.api.descriptor.IDsDefinition;
import net.nan21.dnet.core.api.descriptor.IDsDefinitions;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.system.business.service.ISysDataSourceService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;
import net.nan21.dnet.module.ad.system.ds.filter.SysDataSourceDsFilter;
 
public class SysDataSourceDelegate extends AbstractDsDelegate {
 
	public void synchronizeCatalog(SysDataSourceDsFilter ds) throws Exception {
		List<IDsDefinitions> list = (List<IDsDefinitions>)appContext.getBean("osgiDsDefinitions");
		ISysDataSourceService srv = (ISysDataSourceService)this.findEntityService(SysDataSource.class);
		
		List<SysDataSource> result = new ArrayList<SysDataSource>();
		for(IDsDefinitions dsdefs:list) {
			for (IDsDefinition def : dsdefs.getDsDefinitions()) {				
				SysDataSource e = new SysDataSource();
				e.setName(def.getName());
				e.setModel(def.getModelClass().getCanonicalName());
				e.setActive(true);
				
				Field[] fields = def.getModelClass().getDeclaredFields();
				for(Field field:fields) {
	                if ( ! Modifier.isStatic(field.getModifiers())  ) {
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
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", Session.user.get().getClientId());
 
		srv.update("delete from "+SysDsField.class.getSimpleName()+"  where clientId = :clientId", params );		 
		srv.update("delete from "+SysDataSource.class.getSimpleName()+"  where clientId = :clientId", params);
		srv.insert(result);		
	}
}