   

Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs",
	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"supplier",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20",maxLength:32  })
		.addDateField({ name:"docDate", dataIndex:"docDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bp.md.lovs.CustomersName", dataIndex:"customer",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceStatus", dataIndex:"status",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceType", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor", width:250}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["docNo","docDate","currency"])
		.addChildrenTo("col2",["supplier","customer","type","status"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"docNo", dataIndex:"docNo",width:100 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"status", dataIndex:"status",width:120 })   	
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2 })  
		.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2 })  
		.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount",decimals:2 })  
		.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"customerCode", dataIndex:"customerCode",width:100 })   	
		.addNumberColumn({ name:"salesOrderId", dataIndex:"salesOrderId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"supplier",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20" ,maxLength:32  })
		.addDateField({ name:"docDate", dataIndex:"docDate",anchor:"-20" ,allowBlank:false})
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceStatus", dataIndex:"status",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceType", dataIndex:"type",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"billToLocation", xtype:"net.nan21.dnet.module.bd.geo.lovs.LocationsToBill", dataIndex:"billToLocation",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "billToLocationId"} ],filterFieldMapping: [{lovField:"targetId", dsField: "customerId"} ]  })
		.addLov({ name:"billToContact", xtype:"net.nan21.dnet.module.bp.md.lovs.BpContacts", dataIndex:"billToContact",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "billToContactId"} ],filterFieldMapping: [{lovField:"bpartnerId", dsField: "customerId"} ]  })
		.addDisplayFieldNumber({name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalAmount", dataIndex:"totalAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bp.md.lovs.CustomersName", dataIndex:"customer",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" ,width:250})     
		.addPanel({ name:"col2", layout:"anchor" , width:300})     
		.addPanel({ name:"col3", layout:"anchor" ,width:250})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["supplier","customer","type","status","currency"])
		.addChildrenTo("col2",["docNo","docDate","billToLocation","billToContact"])
		.addChildrenTo("col3",["totalNetAmount","totalTaxAmount","totalAmount"])
;
	}	
});
