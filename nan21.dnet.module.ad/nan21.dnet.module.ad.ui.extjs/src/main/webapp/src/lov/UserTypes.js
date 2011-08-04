Ext.ns("net.nan21.dnet.module.ad.usr.lovs");
net.nan21.dnet.module.ad.usr.lovs.UserTypes = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.ad.usr.ds.model.UserTypeLovDs		
				,_dataProviderName_:"UserTypeLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.usr.frame.UserTypes_UI",bundle:"nan21.dnet.module.ad.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.ad.usr.lovs.UserTypes.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.ad.usr.lovs.UserTypes", net.nan21.dnet.module.ad.usr.lovs.UserTypes);
 
