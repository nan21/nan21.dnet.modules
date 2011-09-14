   
Ext.ns('net.nan21.dnet.module.mm.md.dc');	 
net.nan21.dnet.module.mm.md.dc.ProductAttributeValue = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"ProductAttributeValue" 		 
			,ds: new net.nan21.dnet.module.mm.md.ds.ProductAttributeValueDs()			  
		});
	 	net.nan21.dnet.module.mm.md.dc.ProductAttributeValue.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.mm.md.dc');	 	 
net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$EditList = Ext.extend(dnet.base.AbstractDcvEditableGridCustEditor, {
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"attribute", dataIndex:"attribute", hidden:true,width:120,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"type", dataIndex:"type",width:120,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"title", dataIndex:"title",width:200,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"value", dataIndex:"value",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addTextColumn({ name:"uom", dataIndex:"uom",width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"} })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"attributeId", dataIndex:"attributeId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
	  ;  		   
	}  
	,_getCustomCellEditor_: function(col,row,record) {	
		
		var ed = null;
		
		if (!Ext.isEmpty(record.data.listOfvalues)) {
	    	ed = new Ext.form.ComboBox({ mode: "local", selectOnFocus:true, 
				store:record.data.listOfvalues.split(","),
				triggerAction:"all", forceSelection:true });
	    }
		else if (record.data.dataType == "integer" || record.data.dataType == "decimal") {
	    	ed = new Ext.form.NumberField({ });
	    }
	    else if (record.data.dataType == "date") {
	    	ed = new Ext.form.DateField({});
	    }
	    else if (record.data.dataType == "boolean") {
	    	ed = new Ext.form.ComboBox({ mode: "local", selectOnFocus:true, 
				store:["true","false"],
					triggerAction:"all", forceSelection:true });
	    }
	    else{
	    	return this.colModel.getCellEditor(col, row);
	    }
	 	
	    if(ed){
		    ed.gridEditor = new Ext.grid.GridEditor(ed);
		    ed = ed.gridEditor;
	    }

	    return ed;
	    
	}
});
Ext.reg("net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$EditList", net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$EditList ); 
