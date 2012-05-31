   

Ext.define("net.nan21.dnet.module.md.acc.dc.AccItemAcct", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.acc.ds.model.AccItemAcctDs",
	filterModel: "net.nan21.dnet.module.md.acc.ds.model.AccItemAcctDsFilter",
	paramModel: "net.nan21.dnet.module.md.acc.ds.param.AccItemAcctDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.acc.dc.AccItemAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.acc.dc.AccItemAcct$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"accItem", dataIndex:"accItem",anchor:"-20",maxLength:255  })
		.addTextField({ name:"accSchema", dataIndex:"accSchema",anchor:"-20",maxLength:32  })
		.addTextField({ name:"crAccount", dataIndex:"crAccount",anchor:"-20",maxLength:32  })
		.addTextField({ name:"dbAccount", dataIndex:"dbAccount",anchor:"-20",maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["accItem","accSchema"])
		.addChildrenTo("col2",["crAccount","dbAccount"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.acc.dc.AccItemAcct$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.acc.dc.AccItemAcct$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"accItem", dataIndex:"accItem",width:120 })   	
		.addTextColumn({ name:"accSchema", dataIndex:"accSchema",width:100 })   	
		.addTextColumn({ name:"crAccount", dataIndex:"crAccount",width:100 })   	
		.addTextColumn({ name:"dbAccount", dataIndex:"dbAccount",width:100 })   	
		.addNumberColumn({ name:"accItemId", dataIndex:"accItemId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"crAccountId", dataIndex:"crAccountId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"dbAccountId", dataIndex:"dbAccountId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.acc.dc.AccItemAcct$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.acc.dc.AccItemAcct$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accSchema", xtype:"gridcolumn", dataIndex:"accSchema",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.AccSchemas" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]} })
		.addLov({name:"crAccount", xtype:"gridcolumn", dataIndex:"crAccount",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "crAccountId"} ],filterFieldMapping: [{lovField:"accSchemaId", dsField: "accSchemaId"} ]} })
		.addLov({name:"dbAccount", xtype:"gridcolumn", dataIndex:"dbAccount",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "dbAccountId"} ],filterFieldMapping: [{lovField:"accSchemaId", dsField: "accSchemaId"} ]} })
		.addNumberColumn({ name:"accItemId", dataIndex:"accItemId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"crAccountId", dataIndex:"crAccountId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"dbAccountId", dataIndex:"dbAccountId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
