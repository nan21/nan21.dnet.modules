   

Ext.define("net.nan21.dnet.module.mm.inventory.dc.StockLocator", {
	extend: "dnet.base.AbstractDc",
 
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
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.StockLocator$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addTextField({ name:"subInventory", dataIndex:"subInventory",anchor:"-20",maxLength:255  })
		.addLov({ name:"locatorType", xtype:"net.nan21.dnet.module.mm.inventory.lovs.StockLocatorTypes", dataIndex:"locatorType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "locatorTypeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
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
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.StockLocator$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addLov({name:"locatorType", xtype:"gridcolumn", dataIndex:"locatorType",width:120,editor:{xtype:"net.nan21.dnet.module.mm.inventory.lovs.StockLocatorTypes" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "locatorTypeId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"subInventoryId", dataIndex:"subInventoryId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"locatorTypeId", dataIndex:"locatorTypeId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
