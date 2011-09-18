Ext.ns("net.nan21.dnet.module.mm.inventory.lovs");
net.nan21.dnet.module.mm.inventory.lovs.InvTransactionActions = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionActionLovDs		
				,_dataProviderName_:"InvTransactionActionLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.inventory.frame.InventoryBaseData_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasTxaction"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.mm.inventory.lovs.InvTransactionActions.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.mm.inventory.lovs.InvTransactionActions", net.nan21.dnet.module.mm.inventory.lovs.InvTransactionActions);
 
