Ext.ns("net.nan21.dnet.module.ad.impex.lovs");
net.nan21.dnet.module.ad.impex.lovs.ImportMap = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.ad.impex.ds.model.ImportMapLovDs		
				,_dataProviderName_:"ImportMapLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.impex.frame.ImportMap_UI",bundle:"nan21.dnet.module.ad.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.ad.impex.lovs.ImportMap.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.ad.impex.lovs.ImportMap", net.nan21.dnet.module.ad.impex.lovs.ImportMap);
 
