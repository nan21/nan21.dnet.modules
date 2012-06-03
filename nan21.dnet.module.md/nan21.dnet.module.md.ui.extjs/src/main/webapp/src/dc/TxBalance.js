   

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.TxBalance", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.TxBalanceDs",
	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.TxBalanceDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.fin.ds.param.TxBalanceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.TxBalance$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.fin.dc.TxBalance$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"businessPartner", dataIndex:"businessPartner",anchor:"-20",maxLength:32  })
		.addTextField({ name:"organization", dataIndex:"organization",anchor:"-20",maxLength:32  })
		.addTextField({ name:"currency", dataIndex:"currency",anchor:"-20",maxLength:32  })
		.addNumberField({ name:"amount_From", dataIndex:"amount_From", emptyText:"From" })
		.addNumberField({ name:"amount_To", dataIndex:"amount_To", emptyText:"To" })
		.addFieldContainer({name: "amount", fieldLabel:"Amount"})  
		.addChildrenTo("amount",["amount_From", "amount_To"]) 

		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["businessPartner","organization","currency"])
		.addChildrenTo("col2",["amount"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.TxBalance$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.dc.TxBalance$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"businessPartner", dataIndex:"businessPartner",width:100 })   	
		.addTextColumn({ name:"organization", dataIndex:"organization",width:100 })   	
		.addNumberColumn({ name:"amount", dataIndex:"amount",decimals:2 })  
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addNumberColumn({ name:"businessPartnerId", dataIndex:"businessPartnerId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"organizationId", dataIndex:"organizationId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.TxBalance$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.dc.TxBalance$CtxList",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"organization", dataIndex:"organization",width:100 })   	
		.addNumberColumn({ name:"amount", dataIndex:"amount",decimals:2 })  
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addNumberColumn({ name:"businessPartnerId", dataIndex:"businessPartnerId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"organizationId", dataIndex:"organizationId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
