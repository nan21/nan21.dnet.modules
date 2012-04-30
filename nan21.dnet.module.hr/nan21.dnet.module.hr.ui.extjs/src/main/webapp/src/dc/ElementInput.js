   

Ext.define("net.nan21.dnet.module.hr.payroll.dc.ElementInput", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.ElementInputDs",
	filterModel: "net.nan21.dnet.module.hr.payroll.ds.model.ElementInputDsFilter",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.param.ElementInputDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.payroll.dc.ElementInput$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.ElementInput$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"alias", dataIndex:"alias",anchor:"-20",maxLength:32  })
		.addLov({ name:"reference", xtype:"net.nan21.dnet.module.hr.payroll.lovs.ElementsCode", dataIndex:"reference",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "referenceId"} ]  })
		.addLov({ name:"element", xtype:"net.nan21.dnet.module.hr.payroll.lovs.ElementsCode", dataIndex:"element",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "elementId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["element","reference","alias"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.ElementInput$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.ElementInput$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"element", xtype:"gridcolumn", dataIndex:"element", width:150,editor:{xtype:"net.nan21.dnet.module.hr.payroll.lovs.ElementsCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "elementId"} ,{lovField:"name", dsField: "elementName"} ]} })
		.addTextColumn({ name:"elementName", dataIndex:"elementName", width:200 })
		.addLov({name:"reference", xtype:"gridcolumn", dataIndex:"reference", width:150,editor:{xtype:"net.nan21.dnet.module.hr.payroll.lovs.ElementsCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "referenceId"} ,{lovField:"code", dsField: "alias"} ,{lovField:"name", dsField: "referenceName"} ]} })
		.addTextColumn({ name:"referenceName", dataIndex:"referenceName", width:200 })
		.addTextColumn({ name:"alias", dataIndex:"alias",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"referenceId", dataIndex:"referenceId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.ElementInput$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.ElementInput$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"reference", xtype:"gridcolumn", dataIndex:"reference", width:150,editor:{xtype:"net.nan21.dnet.module.hr.payroll.lovs.ElementsCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "referenceId"} ,{lovField:"code", dsField: "alias"} ,{lovField:"name", dsField: "referenceName"} ]} })
		.addTextColumn({ name:"referenceName", dataIndex:"referenceName", width:200 })
		.addTextColumn({ name:"alias", dataIndex:"alias",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"referenceId", dataIndex:"referenceId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
