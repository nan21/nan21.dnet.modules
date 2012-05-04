   

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PaymentOut", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.param.PaymentOutDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PaymentOut$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sc.invoice.dc.PaymentOut$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"payTo", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomersName", dataIndex:"payTo",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "payToId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentMethodOut", dataIndex:"paymentMethod",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]  })
		.addLov({ name:"fromAccount", xtype:"net.nan21.dnet.module.md.org.lovs.PayAccounts", dataIndex:"fromAccount",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fromAccountId"} ]  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20",maxLength:255  })
		.addDateField({ name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
		.addDateField({ name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
		.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"}) 
		.addChildrenTo("docDate",["docDate_From", "docDate_To"]) 

		.addNumberField({ name:"amount_From", dataIndex:"amount_From", emptyText:"From" })
		.addNumberField({ name:"amount_To", dataIndex:"amount_To", emptyText:"To" })
		.addFieldContainer({name: "amount", fieldLabel:"Amount"})  
		.addChildrenTo("amount",["amount_From", "amount_To"]) 

		.addBooleanField({ name:"confirmed", dataIndex:"confirmed",anchor:"-20"  })
		.addBooleanField({ name:"posted", dataIndex:"posted",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form", width:170}) 
		.addPanel({ name:"col4", layout:"form", width:300}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["payTo","org","paymentMethod","fromAccount"])
		.addChildrenTo("col2",["docNo","code","currency"])
		.addChildrenTo("col3",["confirmed","posted"])
		.addChildrenTo("col4",["docDate","amount"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PaymentOut$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sc.invoice.dc.PaymentOut$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"payTo", dataIndex:"payTo",width:100 })   	
		.addTextColumn({ name:"payToName", dataIndex:"payToName",width:200 })   	
		.addTextColumn({ name:"org", dataIndex:"org",width:100 })   	
		.addTextColumn({ name:"fromAccount", dataIndex:"fromAccount",width:120 })   	
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addTextColumn({ name:"paymentMethod", dataIndex:"paymentMethod",width:120 })   	
		.addNumberColumn({ name:"amount", dataIndex:"amount",decimals:2 })  
		.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})   	     
		.addBooleanColumn({ name:"posted", dataIndex:"posted"})   	     
		.addNumberColumn({ name:"payToId", dataIndex:"payToId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PaymentOut$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sc.invoice.dc.PaymentOut$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"payTo", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomersName", dataIndex:"payTo",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "payToId"} ]  })
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentMethodOut", dataIndex:"paymentMethod",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ,{lovField:"type", dsField: "paymentMethodType"} ]  })
		.addLov({ name:"fromAccount", xtype:"net.nan21.dnet.module.md.org.lovs.PayAccounts", dataIndex:"fromAccount",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fromAccountId"} ],filterFieldMapping: [{lovField:"currencyId", dsField: "currencyId"} ,{lovField:"type", dsField: "paymentMethodType"} ]  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20",noEdit:true  ,maxLength:32  })
		.addDateField({ name:"docDate", dataIndex:"docDate",anchor:"-20" ,allowBlank:false})
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20" ,maxLength:255  })
		.addNumberField({ name:"amount", dataIndex:"amount",anchor:"-20" ,allowBlank:false , style: "text-align:right;" })
		.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed"  })
		.addDisplayFieldBoolean({ name:"posted", dataIndex:"posted"  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:280})     
		.addPanel({ name:"col2", layout:"form" , width:220})     
		.addPanel({ name:"col3", layout:"form" , width:300})     
		.addPanel({ name:"col4", layout:"form" , width:180})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ,"col4" ])
		.addChildrenTo("col1",["org","payTo","amount","currency"])
		.addChildrenTo("col2",["docDate","docNo","code"])
		.addChildrenTo("col3",["paymentMethod","fromAccount"])
		.addChildrenTo("col4",["confirmed","posted"])
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
 	
