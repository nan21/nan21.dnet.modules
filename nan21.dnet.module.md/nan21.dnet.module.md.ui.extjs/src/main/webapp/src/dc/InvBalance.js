   

Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvBalance", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvBalanceDs",
	filterModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvBalanceDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.inventory.ds.param.InvBalanceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvBalance$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.inventory.dc.InvBalance$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"subInventory", xtype:"net.nan21.dnet.module.md.org.lovs.SubInventorys", dataIndex:"subInventory",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "subInventoryId"} ]  })
		.addLov({ name:"locator", xtype:"net.nan21.dnet.module.md.org.lovs.StockLocators", dataIndex:"locator",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "locatorId"} ]  })
		.addLov({ name:"item", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.Products", dataIndex:"item",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "itemId"} ]  })
		.addLov({ name:"uom", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"uom",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["subInventory","locator"])
		.addChildrenTo("col2",["item","uom"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvBalance$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.inventory.dc.InvBalance$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"subInventory", dataIndex:"subInventory",width:120 })   	
		.addTextColumn({ name:"locator", dataIndex:"locator",width:120 })   	
		.addTextColumn({ name:"item", dataIndex:"item",width:100 })   	
		.addTextColumn({ name:"itemName", dataIndex:"itemName",width:200 })   	
		.addNumberColumn({ name:"quantity", dataIndex:"quantity",decimals:2 })  
		.addTextColumn({ name:"uom", dataIndex:"uom",width:100 })   	
		.addNumberColumn({ name:"subInventoryId", dataIndex:"subInventoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"locatorId", dataIndex:"locatorId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvBalance$CtxListProduct", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.inventory.dc.InvBalance$CtxListProduct",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"inventory", dataIndex:"inventory",width:200 })   	
		.addTextColumn({ name:"subInventory", dataIndex:"subInventory",width:120 })   	
		.addTextColumn({ name:"locator", dataIndex:"locator",width:120 })   	
		.addTextColumn({ name:"item", dataIndex:"item", hidden:true,width:100 })   	
		.addNumberColumn({ name:"quantity", dataIndex:"quantity",decimals:2 })  
		.addTextColumn({ name:"uom", dataIndex:"uom",width:100 })   	
		.addNumberColumn({ name:"inventoryId", dataIndex:"inventoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"subInventoryId", dataIndex:"subInventoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"locatorId", dataIndex:"locatorId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvBalance$CtxFilterProduct", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
 	alias: "widget.net.nan21.dnet.module.md.tx.inventory.dc.InvBalance$CtxFilterProduct",
	_defineElements_: function () {	
		this._getBuilder_()	
		.addLov({ name:"subInventory", dataIndex:"subInventory",editor:{ xtype:"net.nan21.dnet.module.md.org.lovs.SubInventorys", selectOnFocus:true,retFieldMapping: [{lovField:"id", dsField: "subInventoryId"} ]}  })
		.addLov({ name:"locator", dataIndex:"locator",editor:{ xtype:"net.nan21.dnet.module.md.org.lovs.StockLocators", selectOnFocus:true,retFieldMapping: [{lovField:"id", dsField: "locatorId"} ],filterFieldMapping: [{lovField:"subInventoryId", dsField: "subInventoryId"} ]}  })
		 
		
	}
	
}); 
 	
