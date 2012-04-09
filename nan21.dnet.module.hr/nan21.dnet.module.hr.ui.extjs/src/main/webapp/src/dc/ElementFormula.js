   

Ext.define("net.nan21.dnet.module.hr.payroll.dc.ElementFormula", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.ElementFormulaDs",
	filterModel: "net.nan21.dnet.module.hr.payroll.ds.model.ElementFormulaDsFilter",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.param.ElementFormulaDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.payroll.dc.ElementFormula$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.ElementFormula$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"element", xtype:"net.nan21.dnet.module.hr.payroll.lovs.ElementsCode", dataIndex:"element",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "elementId"} ]  })
		.addDateField({ name:"validFrom_From", dataIndex:"validFrom_From", emptyText:"From" })
		.addDateField({ name:"validFrom_To", dataIndex:"validFrom_To", emptyText:"To" })
		.addFieldContainer({name: "validFrom", fieldLabel:"Valid From"}) 
		.addChildrenTo("validFrom",["validFrom_From", "validFrom_To"]) 

		.addDateField({ name:"validTo_From", dataIndex:"validTo_From", emptyText:"From" })
		.addDateField({ name:"validTo_To", dataIndex:"validTo_To", emptyText:"To" })
		.addFieldContainer({name: "validTo", fieldLabel:"Valid To"}) 
		.addChildrenTo("validTo",["validTo_From", "validTo_To"]) 

		//containers
		.addPanel({ name:"col1", layout:"form", width:300}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["element","validFrom","validTo"])
    	.addAuditFilter({})	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.ElementFormula$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.ElementFormula$EditList",
	
	_bulkEditFields_ : ["validFrom","validTo"],
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right"})
		.addLov({name:"element", xtype:"gridcolumn", dataIndex:"element", width:150,editor:{xtype:"net.nan21.dnet.module.hr.payroll.lovs.ElementsCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "elementId"} ,{lovField:"name", dsField: "elementName"} ]} })
		.addTextColumn({ name:"elementName", dataIndex:"elementName", width:200 })
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"validTo", dataIndex:"validTo",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.ElementFormula$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.ElementFormula$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"validTo", dataIndex:"validTo",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.hr.payroll.dc.ElementFormula$EditExpression", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.ElementFormula$EditExpression",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextArea({ name:"expression", dataIndex:"expression",height:200,anchor:"-20"   })
		//containers
		.addPanel({ name:"main", layout:"form" , autoScroll:true, defaults:{
labelAlign:"top"}})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["expression"])
;
	}	
});
 	
