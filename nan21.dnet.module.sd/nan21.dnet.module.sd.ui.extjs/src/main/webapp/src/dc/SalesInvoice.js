   
Ext.ns('net.nan21.dnet.module.sd.invoice.dc');	 
net.nan21.dnet.module.sd.invoice.dc.SalesInvoice = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"SalesInvoice" 		 
			,ds: new net.nan21.dnet.module.sd.invoice.ds.SalesInvoiceDs()			  
		});
	 	net.nan21.dnet.module.sd.invoice.dc.SalesInvoice.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.sd.invoice.dc'); 
net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20",maxLength:32  })
		.addDateField({ name:"docDate", dataIndex:"docDate",width:100 ,format:Ext.DATE_FORMAT })
		.addLov({ name:"customerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.Customers", dataIndex:"customerCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceStatus", dataIndex:"status",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceType", dataIndex:"type",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"currencyCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currencyCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col3", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		; 
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["docNo","docDate"])
		.addChildrenTo("col2",["customerCode","currencyCode"])
		.addChildrenTo("col3",["type","status"])
;
	}
}); 
Ext.reg("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter", net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.sd.invoice.dc');	 	 
net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"docNo", dataIndex:"docNo",width:100 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Ext.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"status", dataIndex:"status",width:120 })   	
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"currencyCode", dataIndex:"currencyCode",width:100 })   	
		.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount",format:Ext.NUMBER_FORMAT_DEC })  
		.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount",format:Ext.NUMBER_FORMAT_DEC })  
		.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount",format:Ext.NUMBER_FORMAT_DEC })  
		.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"customerCode", dataIndex:"customerCode",width:100 })   	
		.addNumberColumn({ name:"salesOrderId", dataIndex:"salesOrderId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List", net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List ); 
 	
Ext.ns('net.nan21.dnet.module.sd.invoice.dc');	 
net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20" ,allowBlank:false,maxLength:32,vtype:"alphanum"  })
		.addDateField({ name:"docDate", dataIndex:"docDate",width:100 ,allowBlank:false})
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceStatus", dataIndex:"status",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceType", dataIndex:"type",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"currencyCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currencyCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"billToLocation", xtype:"net.nan21.dnet.module.bd.geo.lovs.LocationsToBill", dataIndex:"billToLocation",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "billToLocationId"} ],filterFieldMapping: [{lovField:"targetId", dsField: "customerId"} ]  })
		.addLov({ name:"billToContact", xtype:"net.nan21.dnet.module.bp.md.lovs.BpContacts", dataIndex:"billToContact",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "billToContactId"} ],filterFieldMapping: [{lovField:"bpartnerId", dsField: "customerId"} ]  })
		.addNumberField({ name:"totalNetAmount", dataIndex:"totalNetAmount",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addNumberField({ name:"totalTaxAmount", dataIndex:"totalTaxAmount",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addNumberField({ name:"totalAmount", dataIndex:"totalAmount",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addLov({ name:"customerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.Customers", dataIndex:"customerCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" ,width:250,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" , width:300,labelWidth:0 })     
		.addPanel({ name:"col3", layout:"form" ,width:250,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["customerCode","type","status","currencyCode"])
		.addChildrenTo("col2",["docNo","docDate","billToLocation","billToContact"])
		.addChildrenTo("col3",["totalNetAmount","totalTaxAmount","totalAmount"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Edit", net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Edit ); 
