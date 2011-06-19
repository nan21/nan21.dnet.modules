Ext.ns("net.nan21.dnet.module.bp.base.lovs");
net.nan21.dnet.module.bp.base.lovs.CustomerGroup = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.bp.base.ds.model.CustomerGroupLovDs		
				,_dataProviderName_:"CustomerGroupLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI",bundle:"nan21.dnet.module.bp.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bp.base.lovs.CustomerGroup.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bp.base.lovs.CustomerGroup", net.nan21.dnet.module.bp.base.lovs.CustomerGroup);
 
