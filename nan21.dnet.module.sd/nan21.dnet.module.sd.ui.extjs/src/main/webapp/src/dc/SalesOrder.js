   
Ext.ns('net.nan21.dnet.module.sd.order.dc');	 
net.nan21.dnet.module.sd.order.dc.SalesOrder = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"SalesOrder" 		 
			,ds: new net.nan21.dnet.module.sd.order.ds.SalesOrderDs()			  
		});
	 	net.nan21.dnet.module.sd.order.dc.SalesOrder.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.sd.order.dc'); 
net.nan21.dnet.module.sd.order.dc.SalesOrder$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20",maxLength:32  })
		.addDateField({ name:"docDate", dataIndex:"docDate",width:100 ,format:Ext.DATE_FORMAT })
		.addLov({ name:"deliveryMethod", xtype:"net.nan21.dnet.module.bp.base.lovs.DeliveryMethods", dataIndex:"deliveryMethod",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "deliveryMethodId"} ]  })
		.addLov({ name:"customerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.Customers", dataIndex:"customerCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.sd.order.lovs.SalesOrderStatus", dataIndex:"status",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.sd.order.lovs.SalesOrderType", dataIndex:"type",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"currencyCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currencyCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col3", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["docNo","docDate","currencyCode"])
		.addChildrenTo("col2",["type","status"])
		.addChildrenTo("col3",["customerCode","deliveryMethod"])
	}
}); 
Ext.reg("net.nan21.dnet.module.sd.order.dc.SalesOrder$Filter", net.nan21.dnet.module.sd.order.dc.SalesOrder$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.sd.order.dc');	 	 
net.nan21.dnet.module.sd.order.dc.SalesOrder$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"docNo", dataIndex:"docNo",width:100 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Ext.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"status", dataIndex:"status",width:120 })   	
		.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"customerCode", dataIndex:"customerCode",width:100 })   	
		.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"supplierCode", dataIndex:"supplierCode",width:100 })   	
		.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount",format:Ext.NUMBER_FORMAT_DEC })  
		.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount",format:Ext.NUMBER_FORMAT_DEC })  
		.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount",format:Ext.NUMBER_FORMAT_DEC })  
		.addNumberColumn({ name:"deliveryMethodId", dataIndex:"deliveryMethodId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"deliveryMethod", dataIndex:"deliveryMethod", hidden:true,width:120 })   	
		.addNumberColumn({ name:"billToId", dataIndex:"billToId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"billToCode", dataIndex:"billToCode", hidden:true,width:100 })   	
		.addNumberColumn({ name:"shipToId", dataIndex:"shipToId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"shipToCode", dataIndex:"shipToCode", hidden:true,width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.sd.order.dc.SalesOrder$List", net.nan21.dnet.module.sd.order.dc.SalesOrder$List ); 
 	
Ext.ns('net.nan21.dnet.module.sd.order.dc');	 
net.nan21.dnet.module.sd.order.dc.SalesOrder$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.sd.order.lovs.SalesOrderStatus", dataIndex:"status",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.sd.order.lovs.SalesOrderType", dataIndex:"type",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20" ,allowBlank:false,maxLength:32,vtype:"alphanum"  })
		.addDateField({ name:"docDate", dataIndex:"docDate",width:100 ,allowBlank:false})
		.addLov({ name:"priceListName", xtype:"net.nan21.dnet.module.sd.price.lovs.PriceLists", dataIndex:"priceListName",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "priceListId"} ]  })
		.addLov({ name:"currencyCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currencyCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"deliveryMethod", xtype:"net.nan21.dnet.module.bp.base.lovs.DeliveryMethods", dataIndex:"deliveryMethod",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "deliveryMethodId"} ]  })
		.addLov({ name:"customerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.Customers", dataIndex:"customerCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "customerId"} ,{lovField:"id", dsField: "billToId"} ,{lovField:"code", dsField: "billToCode"} ,{lovField:"id", dsField: "shipToId"} ,{lovField:"code", dsField: "shipToCode"} ]  })
		.addTextField({ name:"supplierCode", dataIndex:"supplierCode",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		.addLov({ name:"billToCode", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartners", dataIndex:"billToCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "billToId"} ]  })
		.addLov({ name:"billToLocation", xtype:"net.nan21.dnet.module.bd.geo.lovs.LocationsToBill", dataIndex:"billToLocation",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "billToLocationId"} ],filterFieldMapping: [{lovField:"targetId", dsField: "billToId"} ]  })
		.addLov({ name:"shipToCode", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartners", dataIndex:"shipToCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "shipToId"} ]  })
		.addLov({ name:"shipToLocation", xtype:"net.nan21.dnet.module.bd.geo.lovs.LocationsToShip", dataIndex:"shipToLocation",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "shipToLocationId"} ],filterFieldMapping: [{lovField:"targetId", dsField: "billToId"} ]  })
		.addNumberField({ name:"totalNetAmount", dataIndex:"totalNetAmount",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addNumberField({ name:"totalTaxAmount", dataIndex:"totalTaxAmount",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addNumberField({ name:"totalAmount", dataIndex:"totalAmount",anchor:"-20",disabled:true   , style: "text-align:right;" })
		//containers
		.addPanel({ name:"col1", layout:"form" ,width:250,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" ,width:250,labelWidth:0 })     
		.addPanel({ name:"col3", layout:"form" , width:300,labelWidth:0 })     
		.addPanel({ name:"col4", layout:"form" ,width:250,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ,"col4" ])
		.addChildrenTo("col1",["customerCode","type","status","currencyCode"])
		.addChildrenTo("col2",["docNo","docDate","priceListName","deliveryMethod"])
		.addChildrenTo("col3",["billToCode","billToLocation","shipToCode","shipToLocation"])
		.addChildrenTo("col4",["totalNetAmount","totalTaxAmount","totalAmount"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.sd.order.dc.SalesOrder$Edit", net.nan21.dnet.module.sd.order.dc.SalesOrder$Edit ); 
