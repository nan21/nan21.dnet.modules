package net.nan21.dnet.module.ad._presenterdelegates.system;

import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.system.ds.model.SysParamDs;

public class SysParamDelegate  extends BaseDsDelegate<SysParamDs, EmptyParam> {
	public void reloadSysConfig(SysParamDs ds) throws Exception {
		this.getSystemConfig().reloadSysparams() ;
	}
}
