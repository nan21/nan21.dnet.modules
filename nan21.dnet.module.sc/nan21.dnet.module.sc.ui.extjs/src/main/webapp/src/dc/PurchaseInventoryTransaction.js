   

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseInventoryTransactionDs",
	filterModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseInventoryTransactionDsFilter",
	paramModel: "net.nan21.dnet.module.sc.order.ds.param.PurchaseInventoryTransactionDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomersName", dataIndex:"supplier",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addTextField({ name:"transactionType", dataIndex:"transactionType",anchor:"-20",maxLength:255  })
		.addLov({ name:"toInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"toInventory",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "toInventoryId"} ]  })
		.addLov({ name:"fromInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"fromInventory",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "fromInventoryId"} ]  })
		.addDateField({ name:"eventDate", dataIndex:"eventDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["supplier"])
		.addChildrenTo("col2",["transactionType","fromInventory","toInventory"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"supplier", dataIndex:"supplier",width:100 })   	
		.addNumberColumn({ name:"transactionTypeId", dataIndex:"transactionTypeId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"transactionType", dataIndex:"transactionType",width:120 })   	
		.addBooleanColumn({ name:"hasFromInventory", dataIndex:"hasFromInventory"})   	     
		.addBooleanColumn({ name:"hasToInventory", dataIndex:"hasToInventory"})   	     
		.addNumberColumn({ name:"fromInventoryId", dataIndex:"fromInventoryId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"fromInventory", dataIndex:"fromInventory",width:100 })   	
		.addNumberColumn({ name:"toInventoryId", dataIndex:"toInventoryId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"toInventory", dataIndex:"toInventory",width:100 })   	
		.addDateColumn({ name:"eventDate", dataIndex:"eventDate",format:Dnet.DATETIME_FORMAT})   	      	     
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomersName", dataIndex:"supplier",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addLov({ name:"fromInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"fromInventory",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "fromInventoryId"} ]  })
		.addLov({ name:"toInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"toInventory",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "toInventoryId"} ]  })
		.addDateField({ name:"eventDate", dataIndex:"eventDate",anchor:"-20" })
		.addLov({ name:"transactionType", xtype:"net.nan21.dnet.module.md.tx.inventory.lovs.InvTransactionTypes", dataIndex:"transactionType",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "transactionTypeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["supplier","transactionType"])
		.addChildrenTo("col2",["fromInventory","toInventory","eventDate"])
;
	}	
});
 	
