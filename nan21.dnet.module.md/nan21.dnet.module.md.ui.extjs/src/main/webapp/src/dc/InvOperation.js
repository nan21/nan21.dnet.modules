   

Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvOperation", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvOperationDs",
	filterModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvOperationDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.inventory.ds.param.InvOperationDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvOperation$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.inventory.dc.InvOperation$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDateField({ name:"eventDate_From", dataIndex:"eventDate_From", emptyText:"From" })
		.addDateField({ name:"eventDate_To", dataIndex:"eventDate_To", emptyText:"To" })
		.addFieldContainer({name: "eventDate", fieldLabel:"Event Date"}) 
		.addChildrenTo("eventDate",["eventDate_From", "eventDate_To"]) 

		.addLov({ name:"itemCode", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.Products", dataIndex:"itemCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "itemId"} ]  })
		.addTextField({ name:"item", dataIndex:"item",anchor:"-20",maxLength:255  })
		.addLov({ name:"inventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"inventory",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "inventoryId"} ]  })
		.addLov({ name:"subInventory", xtype:"net.nan21.dnet.module.md.org.lovs.SubInventorys", dataIndex:"subInventory",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "subInventoryId"} ],filterFieldMapping: [{lovField:"inventoryId", dsField: "inventoryId"} ]  })
		.addLov({ name:"locator", xtype:"net.nan21.dnet.module.md.org.lovs.StockLocators", dataIndex:"locator",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "locatorId"} ],filterFieldMapping: [{lovField:"subInventoryId", dsField: "subInventoryId"} ]  })
		.addCombo({ name:"direction", xtype:"combo", dataIndex:"direction",anchor:"-20",store:[ "in", "out"]  })
		.addNumberField({ name:"transactionId", dataIndex:"transactionId",anchor:"-20"  })
		.addNumberField({ name:"transactionLineId", dataIndex:"transactionLineId",anchor:"-20"  })
		.addNumberField({ name:"quantity", dataIndex:"quantity",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:300}) 
		.addPanel({ name:"col2", layout:"form", width:220}) 
		.addPanel({ name:"col3", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["itemCode","eventDate"])
		.addChildrenTo("col2",["inventory","subInventory","locator"])
		.addChildrenTo("col3",["direction","transactionId","transactionLineId"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvOperation$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.inventory.dc.InvOperation$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addDateColumn({ name:"eventDate", dataIndex:"eventDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"itemCode", dataIndex:"itemCode",width:100 })   	
		.addTextColumn({ name:"item", dataIndex:"item",width:200 })   	
		.addTextColumn({ name:"inventory", dataIndex:"inventory",width:100 })   	
		.addTextColumn({ name:"inventoryName", dataIndex:"inventoryName", hidden:true,width:200 })   	
		.addTextColumn({ name:"subInventory", dataIndex:"subInventory",width:120 })   	
		.addTextColumn({ name:"locator", dataIndex:"locator",width:120 })   	
		.addTextColumn({ name:"direction", dataIndex:"direction",width:60 })   	
		.addNumberColumn({ name:"quantity", dataIndex:"quantity",decimals:2 })  
		.addTextColumn({ name:"uom", dataIndex:"uom", width:80 })   	
		.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"inventoryId", dataIndex:"inventoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"subInventoryId", dataIndex:"subInventoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"locatorId", dataIndex:"locatorId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"transactionId", dataIndex:"transactionId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"transactionLineId", dataIndex:"transactionLineId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
