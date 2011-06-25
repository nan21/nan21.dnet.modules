Ext.ns("net.nan21.dnet.module.ux.example.lovs");
net.nan21.dnet.module.ux.example.lovs.LandFormTypes = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.ux.example.ds.model.LandFormTypeLovDs		
				,_dataProviderName_:"LandFormTypeLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.geo.frame.CountryMD_UI",bundle:"nan21.dnet.module.bd.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.ux.example.lovs.LandFormTypes.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.ux.example.lovs.LandFormTypes", net.nan21.dnet.module.ux.example.lovs.LandFormTypes);
 
