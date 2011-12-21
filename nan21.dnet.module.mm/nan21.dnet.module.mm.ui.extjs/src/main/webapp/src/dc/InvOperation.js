   

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvOperation", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.inventory.ds.model.InvOperationDs",
	filterModel: "net.nan21.dnet.module.mm.inventory.ds.model.InvOperationDsFilter",
	paramModel: "net.nan21.dnet.module.mm.inventory.ds.param.InvOperationDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvOperation$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.InvOperation$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"itemCode", xtype:"net.nan21.dnet.module.mm.md.lovs.Products", dataIndex:"itemCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "itemId"} ]  })
		.addTextField({ name:"item", dataIndex:"item",anchor:"-20",maxLength:255  })
		.addLov({ name:"inventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"inventory",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "inventoryId"} ]  })
		.addLov({ name:"subInventory", xtype:"net.nan21.dnet.module.mm.inventory.lovs.SubInventorys", dataIndex:"subInventory",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "subInventoryId"} ],filterFieldMapping: [{lovField:"inventoryId", dsField: "inventoryId"} ]  })
		.addLov({ name:"locator", xtype:"net.nan21.dnet.module.mm.inventory.lovs.StockLocators", dataIndex:"locator",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "locatorId"} ],filterFieldMapping: [{lovField:"subInventoryId", dsField: "subInventoryId"} ]  })
		.addCombo({ name:"direction", xtype:"combo", dataIndex:"direction",anchor:"-20",store:[ "in", "out"]  })
		.addNumberField({ name:"transactionId", dataIndex:"transactionId",anchor:"-20"  })
		.addNumberField({ name:"transactionLineId", dataIndex:"transactionLineId",anchor:"-20"  })
		.addNumberField({ name:"quantity", dataIndex:"quantity",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor", width:250}) 
		.addPanel({ name:"col3", layout:"anchor",width:210}) 
		.addPanel({ name:"col4", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["itemCode","inventory"])
		.addChildrenTo("col2",["subInventory","locator"])
		.addChildrenTo("col3",["direction"])
		.addChildrenTo("col4",["transactionId","transactionLineId"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvOperation$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.mm.inventory.dc.InvOperation$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"itemCode", dataIndex:"itemCode",width:100 })   	
		.addTextColumn({ name:"item", dataIndex:"item",width:200 })   	
		.addTextColumn({ name:"inventory", dataIndex:"inventory",width:100 })   	
		.addTextColumn({ name:"inventoryName", dataIndex:"inventoryName", hidden:true,width:200 })   	
		.addTextColumn({ name:"subInventory", dataIndex:"subInventory",width:120 })   	
		.addTextColumn({ name:"locator", dataIndex:"locator",width:120 })   	
		.addTextColumn({ name:"direction", dataIndex:"direction",width:60 })   	
		.addNumberColumn({ name:"quantity", dataIndex:"quantity",decimals:2 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"inventoryId", dataIndex:"inventoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"subInventoryId", dataIndex:"subInventoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"locatorId", dataIndex:"locatorId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"transactionId", dataIndex:"transactionId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"transactionLineId", dataIndex:"transactionLineId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
