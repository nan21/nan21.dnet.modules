   

Ext.define("net.nan21.dnet.module.mm.md.dc.ProductAttributeValue", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProductAttributeValueDs",
	paramModel: "net.nan21.dnet.module.mm.md.ds.param.ProductAttributeValueDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	
 	 
Ext.define("net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$EditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"attribute", dataIndex:"attribute", hidden:true,width:120 })
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })
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
