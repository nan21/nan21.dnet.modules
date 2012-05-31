   

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.Payment", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentDs",
	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.fin.ds.param.PaymentDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.Payment$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.fin.dc.Payment$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20",maxLength:255  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentMethod", dataIndex:"paymentMethod",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]  })
		.addLov({ name:"fromOrg", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"fromOrg",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "fromOrgId"} ]  })
		.addLov({ name:"toOrg", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"toOrg",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "toOrgId"} ]  })
		.addLov({ name:"fromAccount", xtype:"net.nan21.dnet.module.md.org.lovs.PayAccounts", dataIndex:"fromAccount",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fromAccountId"} ]  })
		.addLov({ name:"toAccount", xtype:"net.nan21.dnet.module.md.org.lovs.PayAccounts", dataIndex:"toAccount",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "toAccountId"} ]  })
		.addLov({ name:"businessPartner", xtype:"net.nan21.dnet.module.md.bp.lovs.BusinessPartnersName", dataIndex:"businessPartner",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "businessPartnerId"} ]  })
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
		.addPanel({ name:"col2", layout:"form", width:280}) 
		.addPanel({ name:"col3", layout:"form", width:180}) 
		.addPanel({ name:"col4", layout:"form", width:300}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["fromOrg","toOrg","docNo","code"])
		.addChildrenTo("col2",["fromAccount","toAccount","businessPartner","paymentMethod"])
		.addChildrenTo("col3",["currency","confirmed","posted"])
		.addChildrenTo("col4",["docDate","amount"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.Payment$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.dc.Payment$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"fromOrg", dataIndex:"fromOrg",width:100 })   	
		.addTextColumn({ name:"toOrg", dataIndex:"toOrg",width:100 })   	
		.addTextColumn({ name:"businessPartner", dataIndex:"businessPartner", width:100 })   	
		.addTextColumn({ name:"fromAccount", dataIndex:"fromAccount",width:120 })   	
		.addTextColumn({ name:"toAccount", dataIndex:"toAccount",width:120 })   	
		.addNumberColumn({ name:"amount", dataIndex:"amount",decimals:2 })  
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addTextColumn({ name:"paymentMethod", dataIndex:"paymentMethod", width:80 })   	
		.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed", width:60})   	     
		.addBooleanColumn({ name:"posted", dataIndex:"posted", width:60})   	     
		.addNumberColumn({ name:"fromOrgId", dataIndex:"fromOrgId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"toOrgId", dataIndex:"toOrgId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"fromAccountId", dataIndex:"fromAccountId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"toAccountId", dataIndex:"toAccountId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"businessPartnerd", dataIndex:"businessPartnerId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
