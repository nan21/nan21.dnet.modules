   

Ext.define("net.nan21.dnet.module.md.bp.dc.VendorGroupAcct", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.VendorGroupAcctDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.VendorGroupAcctDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.VendorGroupAcctDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.bp.dc.VendorGroupAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.bp.dc.VendorGroupAcct$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"accSchema", xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas", dataIndex:"accSchema",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]  })
		.addTextField({ name:"vendorGroup", dataIndex:"vendorGroup",anchor:"-20",maxLength:32  })
		.addLov({ name:"purchaseAccount", xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts", dataIndex:"purchaseAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "purchaseAccountId"} ]  })
		.addLov({ name:"prepayAccount", xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts", dataIndex:"prepayAccount",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "prepayAccountId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["vendorGroup","accSchema"])
		.addChildrenTo("col2",["purchaseAccount","prepayAccount"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.bp.dc.VendorGroupAcct$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.bp.dc.VendorGroupAcct$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accSchema", xtype:"gridcolumn", dataIndex:"accSchema",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]} })
		.addTextColumn({ name:"vendorGroup", dataIndex:"vendorGroup",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addLov({name:"purchaseAccount", xtype:"gridcolumn", dataIndex:"purchaseAccount",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "purchaseAccountId"} ]} })
		.addLov({name:"prepayAccount", xtype:"gridcolumn", dataIndex:"prepayAccount",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "prepayAccountId"} ]} })
		.addNumberColumn({ name:"vendorGroupId", dataIndex:"vendorGroupId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"purchaseAccountId", dataIndex:"purchaseAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"prepayAccountId", dataIndex:"prepayAccountId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.bp.dc.VendorGroupAcct$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.bp.dc.VendorGroupAcct$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accSchema", xtype:"gridcolumn", dataIndex:"accSchema",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.AccSchemas" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]} })
		.addLov({name:"purchaseAccount", xtype:"gridcolumn", dataIndex:"purchaseAccount",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "purchaseAccountId"} ]} })
		.addLov({name:"prepayAccount", xtype:"gridcolumn", dataIndex:"prepayAccount",width:100,editor:{xtype:"net.nan21.dnet.module.bd.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "prepayAccountId"} ]} })
		.addNumberColumn({ name:"vendorGroupId", dataIndex:"vendorGroupId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"purchaseAccountId", dataIndex:"purchaseAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"prepayAccountId", dataIndex:"prepayAccountId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
