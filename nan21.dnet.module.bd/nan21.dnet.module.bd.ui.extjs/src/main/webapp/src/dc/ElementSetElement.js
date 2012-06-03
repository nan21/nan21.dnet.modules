   

Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementSetElement", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementSetElementDs",
	filterModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementSetElementDsFilter",
	paramModel: "net.nan21.dnet.module.bd.elem.ds.param.ElementSetElementDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementSetElement$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.elem.dc.ElementSetElement$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"elementSet", xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementSets", dataIndex:"elementSet",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "elementSetId"} ]  })
		.addLov({ name:"element", xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementsCode", dataIndex:"element",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "elementId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["elementSet"])
		.addChildrenTo("col2",["element"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementSetElement$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.elem.dc.ElementSetElement$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"elementSet", xtype:"gridcolumn", dataIndex:"elementSet",width:120,editor:{xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementSets" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "elementSetId"} ]} })
		.addLov({name:"element", xtype:"gridcolumn", dataIndex:"element",width:100,editor:{xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementsCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "elementId"} ]} })
		.addTextColumn({ name:"elementName", dataIndex:"elementName",width:200 })
		.addNumberColumn({ name:"elementSetId", dataIndex:"elementSetId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"engineId", dataIndex:"engineId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementSetElement$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.elem.dc.ElementSetElement$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({name:"element", xtype:"gridcolumn", dataIndex:"element", width:150,editor:{xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementsCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "elementId"} ,{lovField:"name", dsField: "printLabel"} ,{lovField:"name", dsField: "elementName"} ]} })
		.addTextColumn({ name:"elementName", dataIndex:"elementName", width:250 })
		.addTextColumn({ name:"printLabel", dataIndex:"printLabel",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addNumberColumn({ name:"elementSetId", dataIndex:"elementSetId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"engineId", dataIndex:"engineId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
