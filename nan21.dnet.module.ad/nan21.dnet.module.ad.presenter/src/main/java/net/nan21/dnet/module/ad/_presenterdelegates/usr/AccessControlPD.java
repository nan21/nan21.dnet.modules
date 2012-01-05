package net.nan21.dnet.module.ad._presenterdelegates.usr;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.usr.business.service.IAsgnAccessControlService;
import net.nan21.dnet.module.ad.usr.business.service.IDsAccessControlService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.AsgnAccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.DsAccessControl;
import net.nan21.dnet.module.ad.usr.ds.model.AccessControlDs;
import net.nan21.dnet.module.ad.usr.ds.param.AccessControlDsParam;

public class AccessControlPD extends AbstractDsDelegate {
 
	public void copyRulesFromAccessControl(AccessControlDs ds, AccessControlDsParam params) throws Exception {	
		if (params.getCopyFromId() == null ) {
			throw new Exception("No value provided for source access control ID to copy rules from!");
		}
		if (params.getSkipAsgn() && params.getSkipDs()) {
			return;
		}
		
		IDsAccessControlService dsACService = (IDsAccessControlService) this.findEntityService(DsAccessControl.class);
		
		AccessControl ac = dsACService.getEntityManager().find(AccessControl.class, ds.getId());
		 
		if (!params.getSkipDs()) {
			
			List<DsAccessControl> sourceDsRulesList = dsACService.findByAccessControlId(params.getCopyFromId());
			List<DsAccessControl> targetDsRulesList = new ArrayList<DsAccessControl>();
			 
			for (DsAccessControl s: sourceDsRulesList) {
				 DsAccessControl t = new DsAccessControl();
				 t.setAccessControl(ac);
				 t.setDsName(s.getDsName());
				 if (!params.getResetRules()) {
					 t.setQueryAllowed(s.getQueryAllowed());
					 t.setInsertAllowed(s.getInsertAllowed());
					 t.setUpdateAllowed(s.getUpdateAllowed());
					 t.setDeleteAllowed(s.getDeleteAllowed());
					 t.setImportAllowed(s.getImportAllowed());
					 t.setExportAllowed(s.getExportAllowed());
				 }
				 targetDsRulesList.add(t);
			}
			dsACService.insert(targetDsRulesList);
		}
		
		
		
		if (!params.getSkipAsgn()) {
			IAsgnAccessControlService asgnACService = (IAsgnAccessControlService) this.findEntityService(AsgnAccessControl.class);
			
			List<AsgnAccessControl> sourceAsgnRulesList = asgnACService.findByAccessControlId(params.getCopyFromId());
			List<AsgnAccessControl> targetAsgnRulesList = new ArrayList<AsgnAccessControl>();
			 
			for (AsgnAccessControl s: sourceAsgnRulesList) {
				AsgnAccessControl t = new AsgnAccessControl();
				 t.setAccessControl(ac);
				 t.setDsName(s.getDsName());
				 if (!params.getResetRules()) {
					 t.setQueryAllowed(s.getQueryAllowed());
					 t.setUpdateAllowed(s.getUpdateAllowed());
					 t.setImportAllowed(s.getImportAllowed());
					 t.setExportAllowed(s.getExportAllowed());
					 targetAsgnRulesList.add(t);
				 }
			}
			 
			asgnACService.insert(targetAsgnRulesList); 
			
		}
		
		 
		 
	}
	
}
