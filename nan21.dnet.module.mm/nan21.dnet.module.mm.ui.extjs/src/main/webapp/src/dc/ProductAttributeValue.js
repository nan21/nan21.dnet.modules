   

Ext.define("net.nan21.dnet.module.mm.md.dc.ProductAttributeValue", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProductAttributeValueDs",
	filterModel: "net.nan21.dnet.module.mm.md.ds.model.ProductAttributeValueDsFilter",
	paramModel: "net.nan21.dnet.module.mm.md.ds.param.ProductAttributeValueDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"productCode", xtype:"net.nan21.dnet.module.mm.md.lovs.Products", dataIndex:"productCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ]  })
		.addLov({ name:"attribute", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductAttribute", dataIndex:"attribute",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "attributeId"} ]  })
		.addTextField({ name:"value", dataIndex:"value",anchor:"-20",maxLength:400  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductAttributeType", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addCombo({ name:"dataType", xtype:"combo", dataIndex:"dataType",anchor:"-20",store:[ "string", "text", "integer", "decimal", "boolean", "date"]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:280}) 
		.addPanel({ name:"col2", layout:"anchor", width:250}) 
		.addPanel({ name:"col3", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["productCode","attribute"])
		.addChildrenTo("col2",["type","dataType"])
		.addChildrenTo("col3",["value"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"attribute", dataIndex:"attribute", hidden:true,width:120 })
		.addTextColumn({ name:"title", dataIndex:"title",width:200 })
		.addTextColumn({ name:"value", dataIndex:"value",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addTextColumn({ name:"uom", dataIndex:"uom",width:100 })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"attributeId", dataIndex:"attributeId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
	,_getCustomCellEditor_: function(record,column) {	
		
		var ed = null;
		
		if (!Ext.isEmpty(record.data.listOfvalues)) {
	    	ed = new dnet.base.LocalCombo({store:record.data.listOfvalues.split(",")});
	    }
		else if (record.data.dataType == "integer" || record.data.dataType == "decimal") {
	    	ed = new Ext.form.field.Number({ });
	    }
	    else if (record.data.dataType == "date") {
	    	ed = new Ext.form.field.Date({});
	    }
	    else if (record.data.dataType == "boolean") {
	    	ed = new dnet.base.LocalCombo({store:["true","false"]});
	    }
 
	    if(ed){
		    ed._dcView_ =  this;
	    }

	    return ed;
	    
	}
});
 	
 	 
Ext.define("net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$EditList",
	
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"product", dataIndex:"productCode", width:150 })
		.addTextColumn({ name:"attribute", dataIndex:"attribute", hidden:true,width:120 })
		.addTextColumn({ name:"title", dataIndex:"title",width:200 })
		.addTextColumn({ name:"value", dataIndex:"value",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addTextColumn({ name:"uom", dataIndex:"uom",width:100 })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"attributeId", dataIndex:"attributeId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
	,_getCustomCellEditor_: function(record,column) {	
		
		var ed = null;
		
		if (!Ext.isEmpty(record.data.listOfvalues)) {
	    	ed = new dnet.base.LocalCombo({store:record.data.listOfvalues.split(",")});
	    }
		else if (record.data.dataType == "integer" || record.data.dataType == "decimal") {
	    	ed = new Ext.form.field.Number({ });
	    }
	    else if (record.data.dataType == "date") {
	    	ed = new Ext.form.field.Date({});
	    }
	    else if (record.data.dataType == "boolean") {
	    	ed = new dnet.base.LocalCombo({store:["true","false"]});
	    }
 
	    if(ed){
		    ed._dcView_ =  this;
	    }

	    return ed;
	    
	}
});
