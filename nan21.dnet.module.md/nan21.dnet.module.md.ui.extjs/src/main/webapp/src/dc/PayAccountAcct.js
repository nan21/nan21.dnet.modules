   

Ext.define("net.nan21.dnet.module.md.org.dc.PayAccountAcct", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.org.ds.model.PayAccountAcctDs",
	filterModel: "net.nan21.dnet.module.md.org.ds.model.PayAccountAcctDsFilter",
	paramModel: "net.nan21.dnet.module.md.org.ds.param.PayAccountAcctDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.org.dc.PayAccountAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.org.dc.PayAccountAcct$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"payAccount", dataIndex:"payAccount",anchor:"-20",maxLength:255  })
		.addLov({ name:"accSchema", xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas", dataIndex:"accSchema",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]  })
		.addLov({ name:"depositAccount", xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts", dataIndex:"depositAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "depositAccountId"} ]  })
		.addLov({ name:"withdrawalAccount", xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts", dataIndex:"withdrawalAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "withdrawalAccountId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["payAccount","accSchema"])
		.addChildrenTo("col2",["depositAccount","withdrawalAccount"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.org.dc.PayAccountAcct$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.org.dc.PayAccountAcct$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"payAccount", dataIndex:"payAccount",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addLov({name:"accSchema", xtype:"gridcolumn", dataIndex:"accSchema",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]} })
		.addLov({name:"depositAccount", xtype:"gridcolumn", dataIndex:"depositAccount",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "depositAccountId"} ]} })
		.addLov({name:"withdrawalAccount", xtype:"gridcolumn", dataIndex:"withdrawalAccount",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "withdrawalAccountId"} ]} })
		.addNumberColumn({ name:"payAccountId", dataIndex:"payAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"depositAccountId", dataIndex:"depositAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"withdrawalAccountId", dataIndex:"withdrawalAccountId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.org.dc.PayAccountAcct$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.org.dc.PayAccountAcct$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accSchema", xtype:"gridcolumn", dataIndex:"accSchema",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]} })
		.addLov({name:"depositAccount", xtype:"gridcolumn", dataIndex:"depositAccount",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "depositAccountId"} ]} })
		.addLov({name:"withdrawalAccount", xtype:"gridcolumn", dataIndex:"withdrawalAccount",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "withdrawalAccountId"} ]} })
		.addNumberColumn({ name:"payAccountId", dataIndex:"payAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"depositAccountId", dataIndex:"depositAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"withdrawalAccountId", dataIndex:"withdrawalAccountId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
