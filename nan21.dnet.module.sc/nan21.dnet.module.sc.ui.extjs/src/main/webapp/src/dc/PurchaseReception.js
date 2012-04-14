   

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseReception", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseReceptionDs",
	filterModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseReceptionDsFilter",
	paramModel: "net.nan21.dnet.module.sc.order.ds.param.PurchaseReceptionDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseReception$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sc.order.dc.PurchaseReception$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.bp.md.lovs.CustomersName", dataIndex:"supplier",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.bd.fin.lovs.FinDocTypes", dataIndex:"docType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addLov({ name:"transactionType", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionTypes", dataIndex:"transactionType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "transactionTypeId"} ],filterFieldMapping: [{lovField:"docTypeId", dsField: "docTypeId"} ]  })
		.addLov({ name:"warehouse", xtype:"net.nan21.dnet.module.bd.org.lovs.WarehouseOrganizations", dataIndex:"warehouse",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "warehouseId"} ]  })
		.addLov({ name:"carrier", xtype:"net.nan21.dnet.module.bd.org.lovs.CarrierOrganizations", dataIndex:"carrier",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "carrierId"} ]  })
		.addDateField({ name:"eventDate_From", dataIndex:"eventDate_From", emptyText:"From" })
		.addDateField({ name:"eventDate_To", dataIndex:"eventDate_To", emptyText:"To" })
		.addFieldContainer({name: "eventDate", fieldLabel:"Event Date"}) 
		.addChildrenTo("eventDate",["eventDate_From", "eventDate_To"]) 

		.addBooleanField({ name:"confirmed", dataIndex:"confirmed",anchor:"-20"  })
		.addBooleanField({ name:"posted", dataIndex:"posted",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form", width:300}) 
		.addPanel({ name:"col3", layout:"form", width:180}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["supplier","warehouse","carrier"])
		.addChildrenTo("col2",["docType","transactionType","eventDate"])
		.addChildrenTo("col3",["confirmed","posted"])
    	.addAuditFilter({})	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseReception$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sc.order.dc.PurchaseReception$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"warehouse", dataIndex:"warehouse",width:100 })   	
		.addTextColumn({ name:"docType", dataIndex:"docType",width:120 })   	
		.addTextColumn({ name:"transactionType", dataIndex:"transactionType",width:120 })   	
		.addDateColumn({ name:"eventDate", dataIndex:"eventDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"supplier", dataIndex:"supplier",width:200 })   	
		.addTextColumn({ name:"carrier", dataIndex:"carrier",width:100 })   	
		.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})   	     
		.addBooleanColumn({ name:"posted", dataIndex:"posted"})   	     
		.addNumberColumn({ name:"warehouseId", dataIndex:"warehouseId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"docTypeId", dataIndex:"docTypeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"transactionTypeId", dataIndex:"transactionTypeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"carrierId", dataIndex:"carrierId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseReception$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sc.order.dc.PurchaseReception$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.bp.md.lovs.CustomersName", dataIndex:"supplier",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addLov({ name:"warehouse", xtype:"net.nan21.dnet.module.bd.org.lovs.WarehouseOrganizations", dataIndex:"warehouse",anchor:"-20" ,noUpdate:true ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "warehouseId"} ]  })
		.addLov({ name:"carrier", xtype:"net.nan21.dnet.module.bd.org.lovs.CarrierOrganizations", dataIndex:"carrier",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "carrierId"} ]  })
		.addDateField({ name:"eventDate", dataIndex:"eventDate",anchor:"-20" })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.bd.fin.lovs.FinDocTypes", dataIndex:"docType",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addLov({ name:"transactionType", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionTypes", dataIndex:"transactionType",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "transactionTypeId"} ],filterFieldMapping: [{lovField:"docTypeId", dsField: "docTypeId"} ]  })
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
		.addChildrenTo("col1",["warehouse","supplier","carrier"])
		.addChildrenTo("col2",["docType","transactionType"])
		.addChildrenTo("col3",["eventDate","confirmed","posted"])
;
	}	
});
 	
