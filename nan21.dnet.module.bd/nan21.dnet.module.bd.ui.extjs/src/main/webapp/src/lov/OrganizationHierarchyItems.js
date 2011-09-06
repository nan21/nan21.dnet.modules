Ext.ns("net.nan21.dnet.module.bd.org.lovs");
net.nan21.dnet.module.bd.org.lovs.OrganizationHierarchyItems = Ext.extend( dnet.base.AbstractCombo, {	
	 initComponent : function(){
		Ext.apply(
		    this, {
                 mode: "remote"
				,displayField:"organizationCode"
				,triggerAction :"query"
				,pageSize:30
				,autoSelect:true
				,listWidth:250 
				,tpl: '<tpl for="."><div class="x-combo-list-item"><div style="">{organizationCode}</div></div></tpl>'
				,minChars:0	
				,_dataProviderFields_: 	net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemLovDs		
				,_dataProviderName_:"OrganizationHierarchyItemLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.org.frame.Org_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasHierarchy"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bd.org.lovs.OrganizationHierarchyItems.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bd.org.lovs.OrganizationHierarchyItems", net.nan21.dnet.module.bd.org.lovs.OrganizationHierarchyItems);
 
