   

Ext.define("net.nan21.dnet.module.mm.md.dc.ProductAttributeGroupAttribute", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProductAttributeGroupAttributeDs",
	filterModel: "net.nan21.dnet.module.mm.md.ds.model.ProductAttributeGroupAttributeDsFilter",
	paramModel: "net.nan21.dnet.module.mm.md.ds.param.ProductAttributeGroupAttributeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.md.dc.ProductAttributeGroupAttribute$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.md.dc.ProductAttributeGroupAttribute$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"group", dataIndex:"group",anchor:"-20",maxLength:255  })
		.addTextField({ name:"attribute", dataIndex:"attribute",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"inDescription", dataIndex:"inDescription",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["group"])
		.addChildrenTo("col2",["attribute"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.mm.md.dc.ProductAttributeGroupAttribute$CEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.md.dc.ProductAttributeGroupAttribute$CEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"group", dataIndex:"group", hidden:true,width:120 })
		.addNumberColumn({ name:"attributeId", dataIndex:"attributeId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addLov({name:"attribute", xtype:"gridcolumn", dataIndex:"attribute",width:120,editor:{xtype:"net.nan21.dnet.module.mm.md.lovs.ProductAttribute" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "attributeId"} ]} })
		.addBooleanColumn({ name:"inDescription", dataIndex:"inDescription"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"groupId", dataIndex:"groupId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
