   

Ext.define("net.nan21.dnet.module.mm.inventory.dc.StockLocator", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorDs",
	filterModel: "net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorDsFilter",
	paramModel: "net.nan21.dnet.module.mm.inventory.ds.param.StockLocatorDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.mm.inventory.dc.StockLocator$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.StockLocator$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addTextField({ name:"subInventory", dataIndex:"subInventory",anchor:"-20",maxLength:255  })
		.addLov({ name:"locatorType", xtype:"net.nan21.dnet.module.mm.inventory.lovs.StockLocatorTypes", dataIndex:"locatorType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "locatorTypeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","subInventory","locatorType"])
		.addChildrenTo("col2",["active"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.mm.inventory.dc.StockLocator$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.StockLocator$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addLov({name:"locatorType", xtype:"gridcolumn", dataIndex:"locatorType",width:120,editor:{xtype:"net.nan21.dnet.module.mm.inventory.lovs.StockLocatorTypes" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "locatorTypeId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"subInventoryId", dataIndex:"subInventoryId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"locatorTypeId", dataIndex:"locatorTypeId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
