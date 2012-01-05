   

Ext.define("net.nan21.dnet.module.hr.payroll.dc.ElementValue", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.ElementValueDs",
	filterModel: "net.nan21.dnet.module.hr.payroll.ds.model.ElementValueDsFilter",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.param.ElementValueDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.hr.payroll.dc.ElementValue$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.ElementValue$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"element", xtype:"net.nan21.dnet.module.hr.payroll.lovs.Elements", dataIndex:"element",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "elementId"} ]  })
		.addLov({ name:"employeeName", xtype:"net.nan21.dnet.module.hr.employee.lovs.Employees", dataIndex:"employeeName",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "employeeId"} ]  })
		.addLov({ name:"period", xtype:"net.nan21.dnet.module.hr.payroll.lovs.PayrollPeriods", dataIndex:"period",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "periodId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["element","period","employeeName"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.ElementValue$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.payroll.dc.ElementValue$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"element", dataIndex:"element",width:200 })   	
		.addNumberColumn({ name:"employeeId", dataIndex:"employeeId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"employeeName", dataIndex:"employeeName",width:200 })   	
		.addTextColumn({ name:"value", dataIndex:"value",width:200 })   	
		.addNumberColumn({ name:"periodId", dataIndex:"periodId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"period", dataIndex:"period",width:120 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
	  ;		   
	}
});
 
