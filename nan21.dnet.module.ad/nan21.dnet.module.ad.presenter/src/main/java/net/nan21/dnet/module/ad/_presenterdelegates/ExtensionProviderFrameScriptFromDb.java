package net.nan21.dnet.module.ad._presenterdelegates;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.api.ui.extjs.ExtensionScript;

import net.nan21.dnet.core.api.ui.extjs.IExtensionProviderFrame;
import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.report.ds.filter.DsReportUsageRtDsFilter;
import net.nan21.dnet.module.ad.report.ds.model.DsReportUsageRtDs;
import net.nan21.dnet.module.ad.system.ds.filter.SysFrameExtensionDsFilter;
import net.nan21.dnet.module.ad.system.ds.model.SysFrameExtensionDs;

public class ExtensionProviderFrameScriptFromDb extends AbstractDsDelegate
		implements IExtensionProviderFrame {

	@Override
	public List<ExtensionScript> getFiles(String targetFrame) throws Exception {

		List<ExtensionScript> files = new ArrayList<ExtensionScript>();

		IDsService srv = this.findDsService("SysFrameExtensionDs");
		SysFrameExtensionDsFilter filter = new SysFrameExtensionDsFilter();
		filter.setFrameFQN(targetFrame);
		filter.setActive(true);
		List<SysFrameExtensionDs> extensions = srv.find(filter);
		
		for (SysFrameExtensionDs extension : extensions) {
			files.add(new ExtensionScript(extension.getFileLocation(), extension.getRelativePath()));
		}
		 
		return files;

	}

}
