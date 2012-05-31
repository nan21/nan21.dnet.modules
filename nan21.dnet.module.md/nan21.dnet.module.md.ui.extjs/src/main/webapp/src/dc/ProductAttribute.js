   

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAttribute", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeDs",
	filterModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.prod.ds.param.ProductAttributeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAttribute$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.ProductAttribute$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"productCode", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.Products", dataIndex:"productCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ]  })
		.addLov({ name:"attribute", xtype:"net.nan21.dnet.module.md.base.attr.lovs.Attribute", dataIndex:"attribute",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "attributeId"} ]  })
		.addTextField({ name:"value", dataIndex:"value",anchor:"-20",maxLength:400  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.md.base.attr.lovs.AttributeType", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addCombo({ name:"dataType", xtype:"combo", dataIndex:"dataType",anchor:"-20",store:[ "string", "text", "integer", "decimal", "boolean", "date"]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:280}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["productCode","attribute","value"])
		.addChildrenTo("col2",["type","dataType"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAttribute$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.ProductAttribute$CtxEditList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"attribute", dataIndex:"attribute", hidden:true,width:120 })
		.addTextColumn({ name:"title", dataIndex:"title",width:200 })
		.addTextColumn({ name:"value", dataIndex:"value",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"uom", dataIndex:"uom",width:100 })
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"attributeId", dataIndex:"attributeId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
	,_getCustomCellEditor_: function(record,column) {	
		
		var ed = null;
		
		if (!Ext.isEmpty(record.data.listOfvalues)) {
	    	ed = new dnet.core.lov.LocalCombo({store:record.data.listOfvalues.split(",")});
	    }
		else if (record.data.dataType == "integer" || record.data.dataType == "decimal") {
	    	ed = new Ext.form.field.Number({ });
	    }
	    else if (record.data.dataType == "date") {
	    	ed = new Ext.form.field.Date({});
	    }
	    else if (record.data.dataType == "boolean") {
	    	ed = new dnet.core.lov.LocalCombo({store:["true","false"]});
	    }
 
	    if(ed){
		    ed._dcView_ =  this;
	    }

	    return ed;
	    
	}
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAttribute$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.ProductAttribute$EditList",
	
	_noImport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"product", dataIndex:"productCode", width:150 })
		.addTextColumn({ name:"attribute", dataIndex:"attribute", hidden:true,width:120 })
		.addTextColumn({ name:"title", dataIndex:"title",width:200 })
		.addTextColumn({ name:"value", dataIndex:"value",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"uom", dataIndex:"uom",width:100 })
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"attributeId", dataIndex:"attributeId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
	,_getCustomCellEditor_: function(record,column) {	
		
		var ed = null;
		
		if (!Ext.isEmpty(record.data.listOfvalues)) {
	    	ed = new dnet.core.lov.LocalCombo({store:record.data.listOfvalues.split(",")});
	    }
		else if (record.data.dataType == "integer" || record.data.dataType == "decimal") {
	    	ed = new Ext.form.field.Number({ });
	    }
	    else if (record.data.dataType == "date") {
	    	ed = new Ext.form.field.Date({});
	    }
	    else if (record.data.dataType == "boolean") {
	    	ed = new dnet.core.lov.LocalCombo({store:["true","false"]});
	    }
 
	    if(ed){
		    ed._dcView_ =  this;
	    }

	    return ed;
	    
	}
});
 	
