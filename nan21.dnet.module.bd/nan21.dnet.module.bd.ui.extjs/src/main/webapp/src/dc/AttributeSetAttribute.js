   

Ext.define("net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeSetAttributeDs",
	filterModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeSetAttributeDsFilter",
	paramModel: "net.nan21.dnet.module.bd.attr.ds.param.AttributeSetAttributeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"set", xtype:"net.nan21.dnet.module.bd.attr.lovs.AttributeSet", dataIndex:"set",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "setId"} ]  })
		.addLov({ name:"attribute", xtype:"net.nan21.dnet.module.bd.attr.lovs.Attribute", dataIndex:"attribute",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "attributeId"} ]  })
		.addBooleanField({ name:"inDescription", dataIndex:"inDescription",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["set","attribute"])
		.addChildrenTo("col2",["inDescription"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"set", dataIndex:"set", hidden:true,width:120 })
		.addNumberColumn({ name:"attributeId", dataIndex:"attributeId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({name:"attribute", xtype:"gridcolumn", dataIndex:"attribute",width:120,editor:{xtype:"net.nan21.dnet.module.bd.attr.lovs.Attribute" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "attributeId"} ]} })
		.addBooleanColumn({ name:"inDescription", dataIndex:"inDescription"})
		.addNumberColumn({ name:"setId", dataIndex:"setId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"set", xtype:"gridcolumn", dataIndex:"set",width:120,editor:{xtype:"net.nan21.dnet.module.bd.attr.lovs.AttributeSet" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "setId"} ]} })
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({name:"attribute", xtype:"gridcolumn", dataIndex:"attribute",width:120,editor:{xtype:"net.nan21.dnet.module.bd.attr.lovs.Attribute" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "attributeId"} ]} })
		.addBooleanColumn({ name:"inDescription", dataIndex:"inDescription"})
		.addNumberColumn({ name:"setId", dataIndex:"setId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"attributeId", dataIndex:"attributeId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
