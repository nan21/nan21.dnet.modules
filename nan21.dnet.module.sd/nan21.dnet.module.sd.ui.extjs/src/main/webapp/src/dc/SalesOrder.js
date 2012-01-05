   

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs",
	filterModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderDsFilter",
	paramModel: "net.nan21.dnet.module.sd.order.ds.param.SalesOrderDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sd.order.dc.SalesOrder$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20",maxLength:32  })
		.addDateField({ name:"docDate", dataIndex:"docDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addLov({ name:"deliveryMethod", xtype:"net.nan21.dnet.module.bp.base.lovs.DeliveryMethods", dataIndex:"deliveryMethod",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "deliveryMethodId"} ]  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bp.md.lovs.CustomersName", dataIndex:"customer",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.sd.order.lovs.SalesOrderStatus", dataIndex:"status",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.sd.order.lovs.SalesOrderType", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor", width:250}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["docNo","docDate","currency","type","status"])
		.addChildrenTo("col2",["customer","deliveryMethod"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sd.order.dc.SalesOrder$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"supplierCode", dataIndex:"supplier",width:100 })   	
		.addTextColumn({ name:"docNo", dataIndex:"docNo",width:100 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"status", dataIndex:"status",width:120 })   	
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addTextColumn({ name:"customerCode", dataIndex:"customerCode", hidden:true,width:100 })   	
		.addTextColumn({ name:"customer", dataIndex:"customer",width:200 })   	
		.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2 })  
		.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2 })  
		.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount",decimals:2 })  
		.addNumberColumn({ name:"deliveryMethodId", dataIndex:"deliveryMethodId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"deliveryMethod", dataIndex:"deliveryMethod", hidden:true,width:120 })   	
		.addTextColumn({ name:"billTo", dataIndex:"billTo", hidden:true,width:200 })   	
		.addTextColumn({ name:"billToCode", dataIndex:"billToCode", hidden:true,width:100 })   	
		.addTextColumn({ name:"shipTo", dataIndex:"shipTo", hidden:true,width:200 })   	
		.addTextColumn({ name:"shipToCode", dataIndex:"shipToCode", hidden:true,width:100 })   	
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"billToId", dataIndex:"billToId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"shipToId", dataIndex:"shipToId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.sd.order.dc.SalesOrder$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.sd.order.lovs.SalesOrderStatus", dataIndex:"status",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.sd.order.lovs.SalesOrderType", dataIndex:"type",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20" ,maxLength:32  })
		.addDateField({ name:"docDate", dataIndex:"docDate",anchor:"-20" ,allowBlank:false})
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"deliveryMethod", xtype:"net.nan21.dnet.module.bp.base.lovs.DeliveryMethods", dataIndex:"deliveryMethod",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "deliveryMethodId"} ]  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bp.md.lovs.CustomersName", dataIndex:"customer",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerId"} ,{lovField:"id", dsField: "billToId"} ,{lovField:"name", dsField: "billTo"} ,{lovField:"id", dsField: "shipToId"} ,{lovField:"name", dsField: "shipTo"} ]  })
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"supplier",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addLov({ name:"billTo", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartnersName", dataIndex:"billTo",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "billToId"} ]  })
		.addLov({ name:"billToLocation", xtype:"net.nan21.dnet.module.bd.geo.lovs.LocationsToBill", dataIndex:"billToLocation",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "billToLocationId"} ],filterFieldMapping: [{lovField:"targetId", dsField: "billToId"} ]  })
		.addLov({ name:"shipTo", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartnersName", dataIndex:"shipTo",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "shipToId"} ]  })
		.addLov({ name:"shipToLocation", xtype:"net.nan21.dnet.module.bd.geo.lovs.LocationsToShip", dataIndex:"shipToLocation",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "shipToLocationId"} ],filterFieldMapping: [{lovField:"targetId", dsField: "billToId"} ]  })
		.addNumberField({ name:"totalNetAmount", dataIndex:"totalNetAmount",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		.addNumberField({ name:"totalTaxAmount", dataIndex:"totalTaxAmount",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		.addNumberField({ name:"totalAmount", dataIndex:"totalAmount",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		//containers
		.addPanel({ name:"col1", layout:"anchor" ,width:250})     
		.addPanel({ name:"col2", layout:"anchor" ,width:250})     
		.addPanel({ name:"col3", layout:"anchor" , width:300})     
		.addPanel({ name:"col4", layout:"anchor" ,width:250})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ,"col4" ])
		.addChildrenTo("col1",["supplier","customer","type","status","currency"])
		.addChildrenTo("col2",["docNo","docDate","deliveryMethod"])
		.addChildrenTo("col3",["billTo","billToLocation","shipTo","shipToLocation"])
		.addChildrenTo("col4",["totalNetAmount","totalTaxAmount","totalAmount"])
;
	}	
});
