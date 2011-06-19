Ext.ns("net.nan21.dnet.module.ad.system.lovs");
net.nan21.dnet.module.ad.system.lovs.SysDataSourceModel = Ext.extend( dnet.base.AbstractCombo, {	
	 initComponent : function(){
		Ext.apply(
		    this, {
                 mode: "remote"
				,displayField:"model"
				,triggerAction :"query"
				,pageSize:30
				,autoSelect:true
				,listWidth:250 
				,tpl: '<tpl for="."><div class="x-combo-list-item"><div style="">{name}</div><div style="padding-left:30px;">{model}</div></div></tpl>'
				,minChars:0	
				,_dataProviderFields_: 	net.nan21.dnet.module.ad.system.ds.model.SysDataSourceModelLovDs		
				,_dataProviderName_:"SysDataSourceModelLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.system.frame.SysDataSources_UI",bundle:"nan21.dnet.module.ad.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.ad.system.lovs.SysDataSourceModel.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.ad.system.lovs.SysDataSourceModel", net.nan21.dnet.module.ad.system.lovs.SysDataSourceModel);
 
