Ext.ns("net.nan21.dnet.module.ad.report.lovs");
net.nan21.dnet.module.ad.report.lovs.ReportServers = Ext.extend( dnet.base.AbstractCombo, {	
	 initComponent : function(){
		Ext.apply(
		    this, {
                 mode: "remote"
				,displayField:"name"
				,triggerAction :"query"
				,pageSize:30
				,autoSelect:true
				,listWidth:250 
				,tpl: '<tpl for="."><div class="x-combo-list-item"><div style="">{name}</div></div></tpl>'
				,minChars:0	
				,_dataProviderFields_: 	net.nan21.dnet.module.ad.report.ds.model.ReportServerLovDs		
				,_dataProviderName_:"ReportServerLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.report.frame.ReportServers_UI",bundle:"nan21.dnet.module.ad.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.ad.report.lovs.ReportServers.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.ad.report.lovs.ReportServers", net.nan21.dnet.module.ad.report.lovs.ReportServers);
 
