   

Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementInput", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementInputDs",
	filterModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementInputDsFilter",
	paramModel: "net.nan21.dnet.module.bd.elem.ds.param.ElementInputDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementInput$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.elem.dc.ElementInput$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"alias", dataIndex:"alias",anchor:"-20",maxLength:32  })
		.addLov({ name:"reference", xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementsCode", dataIndex:"reference",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "referenceId"} ]  })
		.addLov({ name:"engine", xtype:"net.nan21.dnet.module.bd.elem.lovs.Engines", dataIndex:"engine",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "engineId"} ]  })
		.addLov({ name:"element", xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementsCode", dataIndex:"element",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "elementId"} ],filterFieldMapping: [{lovField:"engineId", dsField: "engineId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["engine","element"])
		.addChildrenTo("col2",["reference","alias"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementInput$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.elem.dc.ElementInput$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"engine", xtype:"gridcolumn", dataIndex:"engine",width:120,editor:{xtype:"net.nan21.dnet.module.bd.elem.lovs.Engines" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "engineId"} ]} })
		.addLov({name:"element", xtype:"gridcolumn", dataIndex:"element", width:150,editor:{xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementsCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "elementId"} ,{lovField:"name", dsField: "elementName"} ],filterFieldMapping: [{lovField:"engineId", dsField: "engineId"} ]} })
		.addTextColumn({ name:"elementName", dataIndex:"elementName", width:200 })
		.addLov({name:"reference", xtype:"gridcolumn", dataIndex:"reference", width:150,editor:{xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementsCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "referenceId"} ,{lovField:"code", dsField: "alias"} ,{lovField:"name", dsField: "referenceName"} ]} })
		.addTextColumn({ name:"referenceName", dataIndex:"referenceName", width:200 })
		.addTextColumn({ name:"alias", dataIndex:"alias",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"referenceId", dataIndex:"referenceId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementInput$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.elem.dc.ElementInput$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"reference", xtype:"gridcolumn", dataIndex:"reference", width:150,editor:{xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementsCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "referenceId"} ,{lovField:"code", dsField: "alias"} ,{lovField:"name", dsField: "referenceName"} ]} })
		.addTextColumn({ name:"referenceName", dataIndex:"referenceName", width:200 })
		.addTextColumn({ name:"alias", dataIndex:"alias",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"referenceId", dataIndex:"referenceId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
