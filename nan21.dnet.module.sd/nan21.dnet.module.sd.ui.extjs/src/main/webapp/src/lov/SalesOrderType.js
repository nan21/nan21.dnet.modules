Ext.ns("net.nan21.dnet.module.sd.order.lovs");
net.nan21.dnet.module.sd.order.lovs.SalesOrderType = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.sd.order.ds.model.SalesOrderTypeLovDs		
				,_dataProviderName_:"SalesOrderTypeLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.sd.order.frame.SalesOrderBaseData_UI",bundle:"nan21.dnet.module.sd.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.sd.order.lovs.SalesOrderType.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.sd.order.lovs.SalesOrderType", net.nan21.dnet.module.sd.order.lovs.SalesOrderType);
 
