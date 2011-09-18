Ext.ns("net.nan21.dnet.module.mm.inventory.lovs");
net.nan21.dnet.module.mm.inventory.lovs.InvTransactionSourceTypeS = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionSourceTypeLovDs		
				,_dataProviderName_:"InvTransactionSourceTypeLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.inventory.frame.InventoryBaseData_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasTxsrctype"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.mm.inventory.lovs.InvTransactionSourceTypeS.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.mm.inventory.lovs.InvTransactionSourceTypeS", net.nan21.dnet.module.mm.inventory.lovs.InvTransactionSourceTypeS);
 
