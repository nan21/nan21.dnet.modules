   

Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionLineDs",
	filterModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionLineDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.inventory.ds.param.InvTransactionLineDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"itemCode", dataIndex:"itemCode",anchor:"-20",maxLength:32  })
		.addTextField({ name:"item", dataIndex:"item",anchor:"-20",maxLength:255  })
		.addTextField({ name:"fromSubInventory", dataIndex:"fromSubInventory",anchor:"-20",maxLength:255  })
		.addTextField({ name:"fromLocator", dataIndex:"fromLocator",anchor:"-20",maxLength:255  })
		.addTextField({ name:"toSubInventory", dataIndex:"toSubInventory",anchor:"-20",maxLength:255  })
		.addTextField({ name:"toLocator", dataIndex:"toLocator",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["itemCode"])
		.addChildrenTo("col2",["fromSubInventory","fromLocator"])
		.addChildrenTo("col3",["toSubInventory","toLocator"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"itemCode", dataIndex:"itemCode", width:150 })   	
		.addTextColumn({ name:"item", dataIndex:"item", hidden:true,width:200 })   	
		.addTextColumn({ name:"fromSubInventory", dataIndex:"fromSubInventory", width:150 })   	
		.addTextColumn({ name:"fromLocator", dataIndex:"fromLocator", width:150 })   	
		.addTextColumn({ name:"toSubInventory", dataIndex:"toSubInventory", width:150 })   	
		.addTextColumn({ name:"toLocator", dataIndex:"toLocator", width:150 })   	
		.addNumberColumn({ name:"quantity", dataIndex:"quantity",decimals:2 })  
		.addTextColumn({ name:"uom", dataIndex:"uom",width:100 })   	
		.addNumberColumn({ name:"transactionId", dataIndex:"transactionId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"fromInventoryId", dataIndex:"fromInventoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"fromSubInventoryId", dataIndex:"fromSubInventoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"fromLocatorId", dataIndex:"fromLocatorId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"toInventoryId", dataIndex:"toInventoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"toSubInventoryId", dataIndex:"toSubInventoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"toLocatorId", dataIndex:"toLocatorId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"itemCode", xtype:"gridcolumn", dataIndex:"itemCode", width:150,editor:{xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductsWithUom" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "itemId"} ,{lovField:"name", dsField: "item"} ,{lovField:"uomId", dsField: "uomId"} ,{lovField:"uom", dsField: "uom"} ]} })
		.addTextColumn({ name:"item", dataIndex:"item", hidden:true,width:200 })
		.addLov({name:"fromSubInventory", xtype:"gridcolumn", dataIndex:"fromSubInventory", width:150,editor:{xtype:"net.nan21.dnet.module.md.org.lovs.SubInventorys" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fromSubInventoryId"} ],filterFieldMapping: [{lovField:"inventoryId", dsField: "fromInventoryId"} ]} })
		.addLov({name:"fromLocator", xtype:"gridcolumn", dataIndex:"fromLocator", width:150,editor:{xtype:"net.nan21.dnet.module.md.org.lovs.StockLocators" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fromLocatorId"} ],filterFieldMapping: [{lovField:"subInventoryId", dsField: "fromSubInventoryId"} ]} })
		.addLov({name:"toSubInventory", xtype:"gridcolumn", dataIndex:"toSubInventory", width:150,editor:{xtype:"net.nan21.dnet.module.md.org.lovs.SubInventorys" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "toSubInventoryId"} ],filterFieldMapping: [{lovField:"inventoryId", dsField: "toInventoryId"} ]} })
		.addLov({name:"toLocator", xtype:"gridcolumn", dataIndex:"toLocator", width:150,editor:{xtype:"net.nan21.dnet.module.md.org.lovs.StockLocators" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "toLocatorId"} ],filterFieldMapping: [{lovField:"subInventoryId", dsField: "toSubInventoryId"} ]} })
		.addNumberColumn({ name:"quantity", dataIndex:"quantity", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({name:"uom", xtype:"gridcolumn", dataIndex:"uom",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasureCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]} })
		.addNumberColumn({ name:"transactionId", dataIndex:"transactionId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"fromSubInventoryId", dataIndex:"fromSubInventoryId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"fromLocatorId", dataIndex:"fromLocatorId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"toSubInventoryId", dataIndex:"toSubInventoryId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"toLocatorId", dataIndex:"toLocatorId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$EditListFrom", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$EditListFrom",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"itemCode", xtype:"gridcolumn", dataIndex:"itemCode", width:150,editor:{xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductsWithUom" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "itemId"} ,{lovField:"name", dsField: "item"} ,{lovField:"uomId", dsField: "uomId"} ,{lovField:"uom", dsField: "uom"} ]} })
		.addTextColumn({ name:"item", dataIndex:"item", hidden:true,width:200 })
		.addLov({name:"fromSubInventory", xtype:"gridcolumn", dataIndex:"fromSubInventory", width:150,editor:{xtype:"net.nan21.dnet.module.md.org.lovs.SubInventorys" , selectOnFocus:true,allowBlank:false ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fromSubInventoryId"} ],filterFieldMapping: [{lovField:"inventoryId", dsField: "fromInventoryId"} ]} })
		.addLov({name:"fromLocator", xtype:"gridcolumn", dataIndex:"fromLocator", width:150,editor:{xtype:"net.nan21.dnet.module.md.org.lovs.StockLocators" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fromLocatorId"} ],filterFieldMapping: [{lovField:"subInventoryId", dsField: "fromSubInventoryId"} ]} })
		.addNumberColumn({ name:"quantity", dataIndex:"quantity", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({name:"uom", xtype:"gridcolumn", dataIndex:"uom",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasureCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]} })
		.addNumberColumn({ name:"transactionId", dataIndex:"transactionId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"fromSubInventoryId", dataIndex:"fromSubInventoryId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"fromLocatorId", dataIndex:"fromLocatorId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$EditListTo", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$EditListTo",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"itemCode", xtype:"gridcolumn", dataIndex:"itemCode", width:150,editor:{xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductsWithUom" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "itemId"} ,{lovField:"name", dsField: "item"} ,{lovField:"uomId", dsField: "uomId"} ,{lovField:"uom", dsField: "uom"} ]} })
		.addTextColumn({ name:"item", dataIndex:"item", hidden:true,width:200 })
		.addLov({name:"toSubInventory", xtype:"gridcolumn", dataIndex:"toSubInventory", width:150,editor:{xtype:"net.nan21.dnet.module.md.org.lovs.SubInventorys" , selectOnFocus:true,allowBlank:false ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "toSubInventoryId"} ],filterFieldMapping: [{lovField:"inventoryId", dsField: "toInventoryId"} ]} })
		.addLov({name:"toLocator", xtype:"gridcolumn", dataIndex:"toLocator", width:150,editor:{xtype:"net.nan21.dnet.module.md.org.lovs.StockLocators" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "toLocatorId"} ],filterFieldMapping: [{lovField:"subInventoryId", dsField: "toSubInventoryId"} ]} })
		.addNumberColumn({ name:"quantity", dataIndex:"quantity", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({name:"uom", xtype:"gridcolumn", dataIndex:"uom",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasureCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]} })
		.addNumberColumn({ name:"transactionId", dataIndex:"transactionId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"toSubInventoryId", dataIndex:"toSubInventoryId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"toLocatorId", dataIndex:"toLocatorId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$CtxFormView", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$CtxFormView",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDisplayFieldText({ name:"item", dataIndex:"item", fieldCls:"displayfield important-field"  })
		.addDisplayFieldNumber({name:"quantity", dataIndex:"quantity",decimals:2, fieldCls:"displayfield important-field"  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:500})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["item"])
		.addChildrenTo("col2",["quantity"])
;
	}	
});
 	
