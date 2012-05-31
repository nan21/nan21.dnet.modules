   

Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccBalance", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccBalanceDs",
	filterModel: "net.nan21.dnet.module.md.tx.acc.ds.model.AccBalanceDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.acc.ds.param.AccBalanceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccBalance$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.acc.dc.AccBalance$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"account", dataIndex:"account",anchor:"-20",maxLength:255  })
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20",allowBlank:false,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"accSchema", xtype:"net.nan21.dnet.module.md.acc.lovs.AccSchemas", dataIndex:"accSchema",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]  })
		.addLov({ name:"period", xtype:"net.nan21.dnet.module.md.base.period.lovs.FiscalPeriods", dataIndex:"period",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "periodId"} ]  })
		.addNumberField({ name:"initialAmount_From", dataIndex:"initialAmount_From", emptyText:"From" })
		.addNumberField({ name:"initialAmount_To", dataIndex:"initialAmount_To", emptyText:"To" })
		.addFieldContainer({name: "initialAmount", fieldLabel:"Initial Amount"})  
		.addChildrenTo("initialAmount",["initialAmount_From", "initialAmount_To"]) 

		.addNumberField({ name:"amount_From", dataIndex:"amount_From", emptyText:"From" })
		.addNumberField({ name:"amount_To", dataIndex:"amount_To", emptyText:"To" })
		.addFieldContainer({name: "amount", fieldLabel:"Amount"})  
		.addChildrenTo("amount",["amount_From", "amount_To"]) 

		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form", width:300}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["org","accSchema","period"])
		.addChildrenTo("col2",["account"])
		.addChildrenTo("col3",["initialAmount","amount"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.acc.dc.AccBalance$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.acc.dc.AccBalance$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"org", dataIndex:"org", width:80 })   	
		.addTextColumn({ name:"accSchema", dataIndex:"accSchema", width:80 })   	
		.addTextColumn({ name:"period", dataIndex:"period",width:100 })   	
		.addTextColumn({ name:"account", dataIndex:"account",width:200 })   	
		.addNumberColumn({ name:"initialAmount", dataIndex:"initialAmount",decimals:2 })  
		.addNumberColumn({ name:"amount", dataIndex:"amount",decimals:2 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
