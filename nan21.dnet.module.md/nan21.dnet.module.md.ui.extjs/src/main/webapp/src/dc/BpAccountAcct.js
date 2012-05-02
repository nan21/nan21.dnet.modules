   

Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccountAcct", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.BpAccountAcctDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.BpAccountAcctDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.BpAccountAcctDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccountAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.bp.dc.BpAccountAcct$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"accSchema", xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas", dataIndex:"accSchema",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]  })
		.addLov({ name:"custSalesAccount", xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts", dataIndex:"custSalesAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "custSalesAccountId"} ]  })
		.addLov({ name:"custPrepayAccount", xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts", dataIndex:"custPrepayAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "custPrepayAccountId"} ]  })
		.addLov({ name:"vendorPurchaseAccount", xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts", dataIndex:"vendorPurchaseAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "vendorPurchaseAccountId"} ]  })
		.addLov({ name:"vendorPrepayAccount", xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts", dataIndex:"vendorPrepayAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "vendorPrepayAccountId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["accSchema"])
		.addChildrenTo("col2",["custSalesAccount","custPrepayAccount","vendorPurchaseAccount","vendorPrepayAccount"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccountAcct$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.bp.dc.BpAccountAcct$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accSchema", xtype:"gridcolumn", dataIndex:"accSchema",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]} })
		.addLov({name:"custSalesAccount", xtype:"gridcolumn", dataIndex:"custSalesAccount", width:150,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "custSalesAccountId"} ]} })
		.addLov({name:"custPrepayAccount", xtype:"gridcolumn", dataIndex:"custPrepayAccount", width:150,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "custPrepayAccountId"} ]} })
		.addLov({name:"vendorPurchaseAccount", xtype:"gridcolumn", dataIndex:"vendorPurchaseAccount", width:150,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "vendorPurchaseAccountId"} ]} })
		.addLov({name:"vendorPrepayAccount", xtype:"gridcolumn", dataIndex:"vendorPrepayAccount", width:150,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "vendorPrepayAccountId"} ]} })
		.addNumberColumn({ name:"custPrepayAccountId", dataIndex:"custPrepayAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"bpAccountId", dataIndex:"bpAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"custSalesAccountId", dataIndex:"custSalesAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"vendorPurchaseAccountId", dataIndex:"vendorPurchaseAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"vendorPrepayAccountId", dataIndex:"vendorPrepayAccountId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
