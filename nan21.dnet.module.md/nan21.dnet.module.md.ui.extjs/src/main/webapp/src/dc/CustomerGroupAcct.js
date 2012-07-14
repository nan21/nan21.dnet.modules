   

Ext.define("net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.CustomerGroupAcctDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.CustomerGroupAcctDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.CustomerGroupAcctDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"accSchema", xtype:"net.nan21.dnet.module.md.acc.lovs.AccSchemas", dataIndex:"accSchema",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]  })
		.addTextField({ name:"custGroup", dataIndex:"custGroup",anchor:"-20",maxLength:32  })
		.addLov({ name:"salesAccount", xtype:"net.nan21.dnet.module.md.acc.lovs.Accounts", dataIndex:"salesAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "salesAccountId"} ]  })
		.addLov({ name:"prepayAccount", xtype:"net.nan21.dnet.module.md.acc.lovs.Accounts", dataIndex:"prepayAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "prepayAccountId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["accSchema"])
		.addChildrenTo("col2",["custGroup","accSchema","salesAccount","prepayAccount"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accSchema", xtype:"gridcolumn", dataIndex:"accSchema",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.AccSchemas" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]} })
		.addTextColumn({ name:"custGroup", dataIndex:"custGroup",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addLov({name:"salesAccount", xtype:"gridcolumn", dataIndex:"salesAccount",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "salesAccountId"} ,{lovField:"name", dsField: "salesAccountName"} ]} })
		.addTextColumn({ name:"salesAccountName", dataIndex:"salesAccountName",width:200 })
		.addLov({name:"prepayAccount", xtype:"gridcolumn", dataIndex:"prepayAccount",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "prepayAccountId"} ,{lovField:"name", dsField: "prepayAccountName"} ]} })
		.addTextColumn({ name:"prepayAccountName", dataIndex:"prepayAccountName",width:200 })
		.addNumberColumn({ name:"custGroupId", dataIndex:"custGroupId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"salesAccountId", dataIndex:"salesAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"prepayAccountId", dataIndex:"prepayAccountId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accSchema", xtype:"gridcolumn", dataIndex:"accSchema",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.AccSchemas" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]} })
		.addLov({name:"salesAccount", xtype:"gridcolumn", dataIndex:"salesAccount",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "salesAccountId"} ,{lovField:"name", dsField: "salesAccountName"} ]} })
		.addTextColumn({ name:"salesAccountName", dataIndex:"salesAccountName",width:200 })
		.addLov({name:"prepayAccount", xtype:"gridcolumn", dataIndex:"prepayAccount",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "prepayAccountId"} ,{lovField:"name", dsField: "prepayAccountName"} ]} })
		.addTextColumn({ name:"prepayAccountName", dataIndex:"prepayAccountName",width:200 })
		.addNumberColumn({ name:"custGroupId", dataIndex:"custGroupId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"salesAccountId", dataIndex:"salesAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"prepayAccountId", dataIndex:"prepayAccountId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
