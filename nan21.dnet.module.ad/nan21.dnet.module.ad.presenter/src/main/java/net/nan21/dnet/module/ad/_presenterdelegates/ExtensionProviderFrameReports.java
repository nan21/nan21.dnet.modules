package net.nan21.dnet.module.ad._presenterdelegates;

import java.util.List;

import org.eclipse.persistence.sessions.Session;

import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.core.api.ui.extjs.IExtensionContentProvider;
import net.nan21.dnet.core.api.ui.extjs.IExtensionContentProviderFrame;
import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.report.domain.entity.Report;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;
import net.nan21.dnet.module.ad.report.ds.filter.DsReportParamRtDsFilter;
import net.nan21.dnet.module.ad.report.ds.filter.DsReportUsageRtDsFilter;
import net.nan21.dnet.module.ad.report.ds.model.DsReportParamRtDs;
import net.nan21.dnet.module.ad.report.ds.model.DsReportUsageRtDs;

public class ExtensionProviderFrameReports extends AbstractDsDelegate implements
		IExtensionContentProviderFrame {

	@Override
	public String getContent(String targetFrame) throws Exception {

		StringBuffer sb = new StringBuffer();
		this.addFrameReports(targetFrame, sb);
		return sb.toString();
	}

	protected void addFrameReports(String targetFrame, StringBuffer sb)
			throws Exception {

		// TODO: for production mode use a cache

		IDsService srv = this.findDsService("DsReportUsageRtDs");
		DsReportUsageRtDsFilter filter = new DsReportUsageRtDsFilter();
		filter.setFrameName(targetFrame);
		List<DsReportUsageRtDs> reports = srv.find(filter);

		IDsService srvParam = this.findDsService("DsReportParamRtDs");
		DsReportParamRtDsFilter filterParam = new DsReportParamRtDsFilter();

		IEntityService<ReportParam> rpsrv = this.findEntityService(ReportParam.class);
		 
		int i = 0;
		sb.append("frameReports = [");
		for (DsReportUsageRtDs report : reports) {
			if (i > 0) {
				sb.append(",");
			}
			sb.append("{");
			sb.append("dcAlias:\"" + report.getDcKey() + "\"");
			sb.append(",report:\"" + report.getReportCode() + "\"");
			sb.append(",title:\"" + report.getReportTitle() + "\"");
			sb.append(",toolbar:\"" + report.getToolbarKey() + "\"");
			sb.append(",url:\"" + report.getServerUrl() + "\"");
			
			if(report.getReportContextPath()!= null && !report.getReportContextPath().equals("")) {
				sb.append(",contextPath:\"" + report.getReportContextPath() + "\"");
			}
			 
			sb.append(",params:[");
			filterParam.setDsReportId(report.getDsReportId());

			List<DsReportParamRtDs> params = srvParam.find(filterParam);
			int j = 0;
			for (DsReportParamRtDs param : params) {
				if (j > 0) {
					sb.append(",");
				}
				sb.append("{");

				sb.append(" code:\"" + param.getParamCode() + "\"");
				sb.append(",type:\"" + param.getParamDataType() + "\"");
				sb.append(",mandatory:\"" + param.getParamMandatory() + "\"");
				if(param.getDsField() != null && !param.getDsField().equals("")) {
					sb.append(",dsField:\"" + param.getDsField() + "\"");
				}
				if(param.getParamListOfValues() != null && !param.getParamListOfValues().equals("")) {
					sb.append(",listOfValues:\"" + param.getParamListOfValues() + "\"");
				} 
				
				if(param.getStaticValue() != null && !param.getStaticValue().equals("")) {
					sb.append(",value:\"" + param.getStaticValue() + "\"");
				} else {
					sb.append(",value:\"" + ((param.getParamDefaultValue()!=null)?param.getParamDefaultValue():"" )+ "\"");
				}
				sb.append("}");
				j++;
			}
			
			List<ReportParam> rplist = rpsrv.getEntityManager()
			.createQuery("select e from " +ReportParam.class.getSimpleName() + " e " +
					"where e.report.id = :reportId" +
					"  and e.active = true " +
					"  and e.id not in (select t.reportParam.id from DsReportParam t where t.dsReport.report.id = :reportId) ")
					.setParameter("reportId", report.getReportId())
					.getResultList();
			int k = 0;
			for (ReportParam rparam : rplist) {
				if (j>0 || k > 0) {
					sb.append(",");
				}
				sb.append("{");

				sb.append(" code:\"" + rparam.getCode() + "\"");
				sb.append(",type:\"" + rparam.getDataType() + "\"");
				sb.append(",mandatory:\"" + rparam.getMandatory() + "\"");
				 
				if(rparam.getListOfValues() != null && !rparam.getListOfValues().equals("")) {
					sb.append(",listOfValues:\"" + rparam.getListOfValues() + "\"");
				} 
				
				 
				sb.append(",value:\"" + ((rparam.getDefaultValue()!=null)?rparam.getDefaultValue():"" )+ "\"");
				 
				sb.append("}");
				k++;
			}
			
			// params
			sb.append("]");
			sb.append("}");
			i++;
		}
		sb.append("];");
	}

}
