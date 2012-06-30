   

Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollManualValue", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollManualValueDs",
	filterModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollManualValueDsFilter",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.param.PayrollManualValueDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollManualValue$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.PayrollManualValue$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"element", xtype:"net.nan21.dnet.module.hr.payroll.lovs.PayrollElementsCode", dataIndex:"element",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "elementId"} ]  })
		.addLov({ name:"employeeName", xtype:"net.nan21.dnet.module.hr.employee.lovs.Employees", dataIndex:"employeeName",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "employeeId"} ]  })
		.addLov({ name:"period", xtype:"net.nan21.dnet.module.hr.payroll.lovs.PayrollPeriods", dataIndex:"period",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "periodId"} ]  })
		.addLov({ name:"employer", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"employer",anchor:"-20",allowBlank:false,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "employerId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addDateField({ name:"periodStart_From", dataIndex:"periodStart_From", emptyText:"From" })
		.addDateField({ name:"periodStart_To", dataIndex:"periodStart_To", emptyText:"To" })
		.addFieldContainer({name: "periodStart", fieldLabel:"Period Start"}) 
		.addChildrenTo("periodStart",["periodStart_From", "periodStart_To"]) 

		.addDateField({ name:"periodEnd_From", dataIndex:"periodEnd_From", emptyText:"From" })
		.addDateField({ name:"periodEnd_To", dataIndex:"periodEnd_To", emptyText:"To" })
		.addFieldContainer({name: "periodEnd", fieldLabel:"Period End"}) 
		.addChildrenTo("periodEnd",["periodEnd_From", "periodEnd_To"]) 

		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"col3", layout:"form", width:300}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["employer","period","element"])
		.addChildrenTo("col2",["type","employeeName"])
		.addChildrenTo("col3",["periodStart","periodEnd"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollManualValue$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.PayrollManualValue$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"employer", dataIndex:"employer",width:100 })
		.addTextColumn({ name:"period", dataIndex:"period",width:120 })
		.addDateColumn({ name:"periodStart", dataIndex:"periodStart", hidden:true,format:Dnet.DATE_FORMAT})
		.addDateColumn({ name:"periodEnd", dataIndex:"periodEnd", hidden:true,format:Dnet.DATE_FORMAT})
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right"})
		.addTextColumn({ name:"element", dataIndex:"element",width:100 })
		.addTextColumn({ name:"elementName", dataIndex:"elementName",width:200 })
		.addTextColumn({ name:"employeeName", dataIndex:"employeeName",width:200 })
		.addTextColumn({ name:"value", dataIndex:"value",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"jobCode", dataIndex:"jobCode",width:100 })
		.addTextColumn({ name:"positionCode", dataIndex:"positionCode",width:100 })
		.addNumberColumn({ name:"periodId", dataIndex:"periodId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"employeeId", dataIndex:"employeeId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
