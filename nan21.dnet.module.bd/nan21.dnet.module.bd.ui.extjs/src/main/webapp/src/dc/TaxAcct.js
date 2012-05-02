   

Ext.define("net.nan21.dnet.module.bd.fin.dc.TaxAcct", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.fin.ds.model.TaxAcctDs",
	filterModel: "net.nan21.dnet.module.bd.fin.ds.model.TaxAcctDsFilter",
	paramModel: "net.nan21.dnet.module.bd.fin.ds.param.TaxAcctDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.fin.dc.TaxAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.fin.dc.TaxAcct$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"tax", xtype:"net.nan21.dnet.module.bd.fin.lovs.Taxes", dataIndex:"tax",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "taxId"} ]  })
		.addLov({ name:"accSchema", xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas", dataIndex:"accSchema",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]  })
		.addLov({ name:"salesAccount", xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts", dataIndex:"salesAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "salesAccountId"} ]  })
		.addLov({ name:"purchaseAccount", xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts", dataIndex:"purchaseAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "purchaseAccountId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["tax","accSchema"])
		.addChildrenTo("col2",["salesAccount","purchaseAccount"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.fin.dc.TaxAcct$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.fin.dc.TaxAcct$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accSchema", xtype:"gridcolumn", dataIndex:"accSchema",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]} })
		.addLov({name:"salesAccount", xtype:"gridcolumn", dataIndex:"salesAccount",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "salesAccountId"} ]} })
		.addLov({name:"purchaseAccount", xtype:"gridcolumn", dataIndex:"purchaseAccount",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "purchaseAccountId"} ]} })
		.addNumberColumn({ name:"taxId", dataIndex:"taxId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"salesAccountId", dataIndex:"salesAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"purchaseAccountId", dataIndex:"purchaseAccountId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
