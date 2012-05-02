   

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccountAcct", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountAcctDs",
	filterModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountAcctDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.prod.ds.param.ProductAccountAcctDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccountAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.ProductAccountAcct$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"accSchema", xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas", dataIndex:"accSchema",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]  })
		.addLov({ name:"expenseAccount", xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts", dataIndex:"expenseAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "expenseAccountId"} ]  })
		.addLov({ name:"revenueAccount", xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts", dataIndex:"revenueAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "revenueAccountId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["accSchema"])
		.addChildrenTo("col2",["expenseAccount","revenueAccount"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccountAcct$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.ProductAccountAcct$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accSchema", xtype:"gridcolumn", dataIndex:"accSchema",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]} })
		.addLov({name:"expenseAccount", xtype:"gridcolumn", dataIndex:"expenseAccount",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "expenseAccountId"} ]} })
		.addLov({name:"revenueAccount", xtype:"gridcolumn", dataIndex:"revenueAccount",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "revenueAccountId"} ]} })
		.addNumberColumn({ name:"prodAccountId", dataIndex:"prodAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"revenueAccountId", dataIndex:"revenueAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"expenseAccountId", dataIndex:"expenseAccountId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
