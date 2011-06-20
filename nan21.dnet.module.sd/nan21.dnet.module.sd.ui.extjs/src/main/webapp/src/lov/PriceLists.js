Ext.ns("net.nan21.dnet.module.sd.price.lovs");
net.nan21.dnet.module.sd.price.lovs.PriceLists = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.sd.price.ds.model.PriceListLovDs		
				,_dataProviderName_:"PriceListLovDs"				 
				
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.sd.price.lovs.PriceLists.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.sd.price.lovs.PriceLists", net.nan21.dnet.module.sd.price.lovs.PriceLists);
 
