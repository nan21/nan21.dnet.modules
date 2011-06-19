Ext.ns("net.nan21.dnet.module.ad.system.lovs");
net.nan21.dnet.module.ad.system.lovs.SysDsFields = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.ad.system.ds.model.SysDsFieldLovDs		
				,_dataProviderName_:"SysDsFieldLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.system.frame.SysDataSources_UI",bundle:"nan21.dnet.module.ad.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.ad.system.lovs.SysDsFields.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.ad.system.lovs.SysDsFields", net.nan21.dnet.module.ad.system.lovs.SysDsFields);
 
