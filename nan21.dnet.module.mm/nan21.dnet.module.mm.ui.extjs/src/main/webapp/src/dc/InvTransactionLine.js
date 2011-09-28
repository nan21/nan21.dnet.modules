   

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransactionLine", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionLineDs",
	paramModel: "net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionLineDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransactionLine$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.InvTransactionLine$Filter",
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
		.addPanel({ name:"col1", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"col3", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["itemCode"])
		.addChildrenTo("col2",["fromSubInventory","fromLocator"])
		.addChildrenTo("col3",["toSubInventory","toLocator"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransactionLine$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.InvTransactionLine$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"itemCode", xtype:"gridcolumn", dataIndex:"itemCode",width:100,editor:{xtype:"net.nan21.dnet.module.mm.md.lovs.Products" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "itemId"} ,{lovField:"name", dsField: "item"} ]} })
		.addTextColumn({ name:"item", dataIndex:"item", hidden:true,width:200 })
		.addLov({name:"fromSubInventory", xtype:"gridcolumn", dataIndex:"fromSubInventory",width:120,editor:{xtype:"net.nan21.dnet.module.mm.inventory.lovs.SubInventorys" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "fromSubInventoryId"} ],filterFieldMapping: [{lovField:"inventoryId", dsField: "fromInventoryId"} ]} })
		.addLov({name:"fromLocator", xtype:"gridcolumn", dataIndex:"fromLocator",width:120,editor:{xtype:"net.nan21.dnet.module.mm.inventory.lovs.StockLocators" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "fromLocatorId"} ],filterFieldMapping: [{lovField:"subInventoryId", dsField: "fromSubInventoryId"} ]} })
		.addLov({name:"toSubInventory", xtype:"gridcolumn", dataIndex:"toSubInventory",width:120,editor:{xtype:"net.nan21.dnet.module.mm.inventory.lovs.SubInventorys" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "toSubInventoryId"} ],filterFieldMapping: [{lovField:"inventoryId", dsField: "toInventoryId"} ]} })
		.addLov({name:"toLocator", xtype:"gridcolumn", dataIndex:"toLocator",width:120,editor:{xtype:"net.nan21.dnet.module.mm.inventory.lovs.StockLocators" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "toLocatorId"} ],filterFieldMapping: [{lovField:"subInventoryId", dsField: "toSubInventoryId"} ]} })
		.addNumberColumn({ name:"quantity", dataIndex:"quantity", align:"right",format:Ext.NUMBER_FORMAT_DEC,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"transactionId", dataIndex:"transactionId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"fromSubInventoryId", dataIndex:"fromSubInventoryId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"fromLocatorId", dataIndex:"fromLocatorId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"toSubInventoryId", dataIndex:"toSubInventoryId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"toLocatorId", dataIndex:"toLocatorId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
 	

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransactionLine$CtxFormView", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.InvTransactionLine$CtxFormView",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"item", dataIndex:"item",anchor:"-20",disabled:true  ,maxLength:255  })
		.addNumberField({ name:"quantity", dataIndex:"quantity",anchor:"-20",disabled:true  ,allowBlank:false , style: "text-align:right;" })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:500,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"anchor" ,width:250,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
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
