Ext.ns("net.nan21.dnet.module.ad.report.lovs");
net.nan21.dnet.module.ad.report.lovs.ReportParams = Ext.extend( dnet.base.AbstractCombo, {	
	 initComponent : function(){
		Ext.apply(
		    this, {
                 mode: "remote"
				,displayField:"code"
				,triggerAction :"query"
				,pageSize:30
				,autoSelect:true
				,listWidth:250 
				,tpl: '<tpl for="."><div class="x-combo-list-item"><div style="">{code}</div><div style="padding-left:30px;">{name}</div></div></tpl>'
				,minChars:0	
				,_dataProviderFields_: 	net.nan21.dnet.module.ad.report.ds.model.ReportParamLovDs		
				,_dataProviderName_:"ReportParamLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.report.frame.Reports_UI",bundle:"nan21.dnet.module.ad.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.ad.report.lovs.ReportParams.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.ad.report.lovs.ReportParams", net.nan21.dnet.module.ad.report.lovs.ReportParams);
 
