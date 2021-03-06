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
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;
import net.nan21.dnet.module.ad.system.ds.filter.SysDataSourceDsFilter;

public class SysDataSourcePD extends AbstractDsDelegate {

	@SuppressWarnings("unchecked")
	public void synchronizeCatalog(SysDataSourceDsFilter ds) throws Exception {
		List<IDsDefinitions> list = (List<IDsDefinitions>) this.getAppContext()
				.getBean("osgiDsDefinitions");
		ISysDataSourceService srv = (ISysDataSourceService) this
				.findEntityService(SysDataSource.class);

		List<SysDataSource> result = new ArrayList<SysDataSource>();
		for (IDsDefinitions dsdefs : list) {
			for (IDsDefinition def : dsdefs.getDsDefinitions()) {
				SysDataSource e = new SysDataSource();
				e.setName(def.getName());
				e.setModel(def.getModelClass().getCanonicalName());
				e.setActive(true);
				e.setIsAsgn(def.isAsgn());

				Class<?> theClass = def.getModelClass();
				List<String> _tmp = new ArrayList<String>();
				while (theClass != null) {
					Field[] fields = theClass.getDeclaredFields();
					for (Field field : fields) {
						String fieldName = field.getName();
						if (!Modifier.isStatic(field.getModifiers())) {
							if (!fieldName.equals("_entity_")
									&& !fieldName.equals("__clientRecordId__")
									&& !_tmp.contains(fieldName)) {
								SysDsField f = new SysDsField();
								f.setName(fieldName);
								f.setActive(true);
								f.setDataType(field.getType()
										.getCanonicalName());
								e.addToFields(f);
								_tmp.add(fieldName);
							}
						}
					}
					theClass = theClass.getSuperclass();
				}

				List<String> serviceMethods = def.getServiceMethods();
				if (serviceMethods != null) {
					for (String sm : serviceMethods) {
						SysDsService sme = new SysDsService();
						sme.setActive(true);
						sme.setDataSource(e);
						sme.setName(sm);
						e.addToServiceMethods(sme);
					}
				}
				//
				result.add(e);
			}
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", Session.user.get().getClientId());

		srv.update("delete from " + SysDsField.class.getSimpleName()
				+ "  where clientId = :clientId", params);
		srv.update("delete from " + SysDsService.class.getSimpleName()
				+ "  where clientId = :clientId", params);
		srv.update("delete from " + SysDataSource.class.getSimpleName()
				+ "  where clientId = :clientId", params);
		srv.insert(result);
	}
}