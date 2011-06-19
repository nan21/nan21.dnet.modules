Ext.ns("net.nan21.dnet.module.bd.geo.lovs");
net.nan21.dnet.module.bd.geo.lovs.Locations = Ext.extend( dnet.base.AbstractCombo, {	
	 initComponent : function(){
		Ext.apply(
		    this, {
                 mode: "remote"
				,displayField:"asString"
				,triggerAction :"query"
				,pageSize:30
				,autoSelect:true
				,listWidth:250 
				,tpl: '<tpl for="."><div class="x-combo-list-item"><div style="">{asString}</div></div></tpl>'
				,minChars:0	
				,_dataProviderFields_: 	net.nan21.dnet.module.bd.geo.ds.model.LocationLovDs		
				,_dataProviderName_:"LocationLovDs"				 
				
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bd.geo.lovs.Locations.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bd.geo.lovs.Locations", net.nan21.dnet.module.bd.geo.lovs.Locations);
 
