Ext.ns("net.nan21.dnet.module.bd.geo.lovs");
net.nan21.dnet.module.bd.geo.lovs.Countries = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.bd.geo.ds.model.CountryLovDs		
				,_dataProviderName_:"CountryLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.geo.frame.CountryMD_UI",bundle:"nan21.dnet.module.bd.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bd.geo.lovs.Countries.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bd.geo.lovs.Countries", net.nan21.dnet.module.bd.geo.lovs.Countries);
 
