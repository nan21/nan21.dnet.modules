Ext.ns("net.nan21.dnet.module.bd.org.lovs");
net.nan21.dnet.module.bd.org.lovs.OrganizationTypes = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeLovDs		
				,_dataProviderName_:"OrganizationTypeLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.org.frame.OrgType_UI",bundle:"nan21.dnet.module.bd.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bd.org.lovs.OrganizationTypes.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bd.org.lovs.OrganizationTypes", net.nan21.dnet.module.bd.org.lovs.OrganizationTypes);
 
