   

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesDelivery", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesDeliveryDs",
	filterModel: "net.nan21.dnet.module.sd.order.ds.model.SalesDeliveryDsFilter",
	paramModel: "net.nan21.dnet.module.sd.order.ds.param.SalesDeliveryDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesDelivery$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sd.order.dc.SalesDelivery$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20",maxLength:255  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomersName", dataIndex:"customer",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"transactionType", xtype:"net.nan21.dnet.module.md.tx.inventory.lovs.InvTransactionTypes", dataIndex:"transactionType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "transactionTypeId"} ]  })
		.addLov({ name:"warehouse", xtype:"net.nan21.dnet.module.bd.org.lovs.WarehouseOrganizations", dataIndex:"warehouse",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "warehouseId"} ]  })
		.addLov({ name:"carrier", xtype:"net.nan21.dnet.module.bd.org.lovs.CarrierOrganizations", dataIndex:"carrier",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "carrierId"} ]  })
		.addDateField({ name:"eventDate_From", dataIndex:"eventDate_From", emptyText:"From" })
		.addDateField({ name:"eventDate_To", dataIndex:"eventDate_To", emptyText:"To" })
		.addFieldContainer({name: "eventDate", fieldLabel:"Event Date"}) 
		.addChildrenTo("eventDate",["eventDate_From", "eventDate_To"]) 

		.addDateField({ name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
		.addDateField({ name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
		.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"}) 
		.addChildrenTo("docDate",["docDate_From", "docDate_To"]) 

		.addBooleanField({ name:"confirmed", dataIndex:"confirmed",anchor:"-20"  })
		.addBooleanField({ name:"posted", dataIndex:"posted",anchor:"-20"  })
		.addTextField({ name:"salesOrder", dataIndex:"salesOrder",anchor:"-20",maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form", width:200}) 
		.addPanel({ name:"col3", layout:"form", width:300}) 
		.addPanel({ name:"col4", layout:"form", width:170}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["warehouse","customer","carrier","transactionType"])
		.addChildrenTo("col2",["code","docNo","salesOrder"])
		.addChildrenTo("col3",["docDate","eventDate"])
		.addChildrenTo("col4",["confirmed","posted"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.sd.order.dc.SalesDelivery$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sd.order.dc.SalesDelivery$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"docNo", dataIndex:"docNo", width:70 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"eventDate", dataIndex:"eventDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"transactionType", dataIndex:"transactionType",width:120 })   	
		.addTextColumn({ name:"warehouse", dataIndex:"warehouse",width:100 })   	
		.addTextColumn({ name:"customer", dataIndex:"customer",width:200 })   	
		.addTextColumn({ name:"carrier", dataIndex:"carrier",width:100 })   	
		.addTextColumn({ name:"salesOrder", dataIndex:"salesOrder",width:100 })   	
		.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})   	     
		.addBooleanColumn({ name:"posted", dataIndex:"posted"})   	     
		.addNumberColumn({ name:"warehouseId", dataIndex:"warehouseId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"transactionTypeId", dataIndex:"transactionTypeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"carrierId", dataIndex:"carrierId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesDelivery$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sd.order.dc.SalesDelivery$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDisplayFieldText({ name:"code", dataIndex:"code"  })
		.addTextField({ name:"docNo", dataIndex:"docNo" ,maxLength:255  })
		.addDateField({ name:"docDate", dataIndex:"docDate" ,allowBlank:false})
		.addDisplayFieldDate({name:"eventDate", dataIndex:"eventDate"  })
		.addDisplayFieldText({ name:"salesOrder", dataIndex:"salesOrder"  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomersName", dataIndex:"customer" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"warehouse", xtype:"net.nan21.dnet.module.bd.org.lovs.WarehouseOrganizations", dataIndex:"warehouse" ,noUpdate:true ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "warehouseId"} ]  })
		.addLov({ name:"carrier", xtype:"net.nan21.dnet.module.bd.org.lovs.CarrierOrganizations", dataIndex:"carrier" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "carrierId"} ]  })
		.addLov({ name:"transactionType", xtype:"net.nan21.dnet.module.md.tx.inventory.lovs.InvTransactionTypes", dataIndex:"transactionType" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "transactionTypeId"} ]  })
		.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed"  })
		.addDisplayFieldBoolean({ name:"posted", dataIndex:"posted"  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:280})     
		.addPanel({ name:"col2", layout:"form" , width:300})     
		.addPanel({ name:"col3", layout:"form" , width:200})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["transactionType","warehouse","customer","carrier"])
		.addChildrenTo("col2",["docDate","docNo","code","eventDate","salesOrder"])
		.addChildrenTo("col3",["confirmed","posted"])
;
	}	
	,_beforeApplyStates_: function(record) {	
		
			if (record.get("confirmed") || record.get("posted") ) {
				this._disableAllFields_();
				return false;
			}
	}
	,_endDefine_: function() {	
		
			this._controller_.on("afterDoServiceSuccess", function(dc, response, name, options) {
			 	this._applyStates_(dc.record);
			 } , this )
	}
});
 	
