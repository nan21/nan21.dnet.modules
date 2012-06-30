   

Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeAssignmentDs",
	filterModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeAssignmentDsFilter",
	paramModel: "net.nan21.dnet.module.hr.employee.ds.param.EmployeeAssignmentDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"employeeCode", dataIndex:"employeeCode",anchor:"-20",maxLength:32  })
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20",maxLength:255  })
		.addDateField({ name:"validAt", paramIndex:"validAt",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addLov({ name:"name", xtype:"net.nan21.dnet.module.hr.employee.lovs.Employees", dataIndex:"name",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "employeeId"} ]  })
		.addLov({ name:"employerCode", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"employerCode",anchor:"-20",allowBlank:false,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "employerId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.employee.lovs.EmploymentTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"job", xtype:"net.nan21.dnet.module.hr.job.lovs.Jobs", dataIndex:"jobCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "jobId"} ]  })
		.addLov({ name:"position", xtype:"net.nan21.dnet.module.hr.job.lovs.Positions", dataIndex:"positionCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "positionId"} ]  })
		.addLov({ name:"payroll", xtype:"net.nan21.dnet.module.hr.payroll.lovs.Payrolls", dataIndex:"payroll",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "payrollId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:220}) 
		.addPanel({ name:"col2", layout:"form", width:220}) 
		.addPanel({ name:"col3", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["employerCode","firstName","lastName","employeeCode"])
		.addChildrenTo("col2",["type","payroll","validAt"])
		.addChildrenTo("col3",["job","position","name"])
    	.addAuditFilter()	
	}
}); 
 	
 	

Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$FilterCtx", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
 	alias: "widget.net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$FilterCtx",
	_defineElements_: function () {	
		this._getBuilder_()	
		.addLov({ name:"type", dataIndex:"type",editor:{ xtype:"net.nan21.dnet.module.hr.employee.lovs.EmploymentTypes", selectOnFocus:true,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]}  })
		.addDateField({ name:"validAt", dataIndex:"validFrom" ,format:Ext.DATE_FORMAT })
		 
		
	}
	
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"employeeCode", dataIndex:"employeeCode",width:100 })   	
		.addTextColumn({ name:"firstName", dataIndex:"firstName", width:100 })   	
		.addTextColumn({ name:"lastName", dataIndex:"lastName", width:100 })   	
		.addTextColumn({ name:"employerCode", dataIndex:"employerCode",width:100 })   	
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"validTo", dataIndex:"validTo",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"positionCode", dataIndex:"positionCode",width:100 })   	
		.addTextColumn({ name:"positionName", dataIndex:"positionName", hidden:true,width:200 })   	
		.addTextColumn({ name:"org", dataIndex:"org",width:100 })   	
		.addTextColumn({ name:"jobCode", dataIndex:"jobCode",width:100 })   	
		.addTextColumn({ name:"jobName", dataIndex:"jobName", hidden:true,width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 		 
Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$CtxList",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"validTo", dataIndex:"validTo",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addBooleanColumn({ name:"assignToPosition", dataIndex:"assignToPosition"})   	     
		.addTextColumn({ name:"positionCode", dataIndex:"positionCode",width:100 })   	
		.addTextColumn({ name:"positionName", dataIndex:"positionName", hidden:true,width:200 })   	
		.addTextColumn({ name:"posOrg", dataIndex:"posOrg",width:100 })   	
		.addTextColumn({ name:"jobCode", dataIndex:"jobCode",width:100 })   	
		.addTextColumn({ name:"jobName", dataIndex:"jobName", hidden:true,width:200 })   	
		.addTextColumn({ name:"org", dataIndex:"org",width:100 })   	
		.addTextColumn({ name:"gradeCode", dataIndex:"gradeCode",width:100 })   	
		.addTextColumn({ name:"payroll", dataIndex:"payroll",width:120 })   	
		.addNumberColumn({ name:"baseSalary", dataIndex:"baseSalary",decimals:2 })  
		.addTextColumn({ name:"typeId", dataIndex:"typeId", hidden:true,width:70 })   	
		.addNumberColumn({ name:"gradeId", dataIndex:"gradeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"payrollId", dataIndex:"payrollId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"posOrgId", dataIndex:"posOrgId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 		 
Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$CtxListJobPos", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$CtxListJobPos",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"employerCode", dataIndex:"employerCode",width:100 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"validTo", dataIndex:"validTo",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"firstName", dataIndex:"firstName",width:200 })   	
		.addTextColumn({ name:"lastName", dataIndex:"lastName",width:200 })   	
		.addTextColumn({ name:"employeeCode", dataIndex:"employeeCode",width:100 })   	
		.addTextColumn({ name:"gradeCode", dataIndex:"gradeCode",width:100 })   	
		.addTextColumn({ name:"payroll", dataIndex:"payroll", hidden:true,width:120 })   	
		.addTextColumn({ name:"typeId", dataIndex:"typeId", hidden:true,width:70 })   	
		.addNumberColumn({ name:"gradeId", dataIndex:"gradeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"payrollId", dataIndex:"payrollId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$EditEmployee", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$EditEmployee",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"name", xtype:"net.nan21.dnet.module.hr.employee.lovs.Employees", dataIndex:"name" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "employeeId"} ,{lovField:"name", dsField: "name"} ,{lovField:"code", dsField: "employeeCode"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:400})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ])
		.addChildrenTo("col1",["name"])
;
	}	
});
 	
 	

Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDateField({ name:"validFrom", dataIndex:"validFrom" ,allowBlank:false})
		.addDateField({ name:"validTo", dataIndex:"validTo" })
		.addCheckbox({ name:"assignToPosition", dataIndex:"assignToPosition",listeners:{change:{scope:this, fn:this.onAssignToPositionChange}}  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.employee.lovs.EmploymentTypes", dataIndex:"type" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"positionCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Positions", dataIndex:"positionCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "positionId"} ,{lovField:"name", dsField: "positionName"} ]  })
		.addDisplayFieldText({ name:"positionName", dataIndex:"positionName"  })
		.addLov({ name:"jobCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Jobs", dataIndex:"jobCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "jobId"} ,{lovField:"name", dsField: "jobName"} ]  })
		.addDisplayFieldText({ name:"jobName", dataIndex:"jobName"  })
		.addLov({ name:"gradeCode", xtype:"net.nan21.dnet.module.hr.grade.lovs.Grades", dataIndex:"gradeCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "gradeId"} ]  })
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.Organizations", dataIndex:"org" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addNumberField({ name:"baseSalary", dataIndex:"baseSalary"  , style: "text-align:right;" })
		.addLov({ name:"payroll", xtype:"net.nan21.dnet.module.hr.payroll.lovs.Payrolls", dataIndex:"payroll" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "payrollId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" ,width:250, defaults:{
labelAlign:"right",labelWidth:110}})     
		.addPanel({ name:"col2", layout:"form" ,width:250, defaults:{
labelAlign:"right",labelWidth:110}})     
		.addPanel({ name:"col3", layout:"form" , width:350, defaults:{
labelAlign:"right",labelWidth:110}})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["validFrom","validTo","type","payroll","baseSalary"])
		.addChildrenTo("col2",["assignToPosition","positionCode","jobCode","org"])
		.addChildrenTo("col3",["gradeCode","positionName","jobName"])
;
	}	
	,onAssignToPositionChange: function() {	
		var r = this._getController_().getRecord();
		if (r.get("assignToPosition")) {
			r.set("jobId", "");
            r.set("jobCode", "");
            r.set("jobName", "");

            r.set("organizationId", "");
            r.set("org", "");
            r.set("organizationName", "");
		} else {
            r.set("positionId", "");
            r.set("positionCode", "");
            r.set("positionName", "");
		}
		this._doEnableJobOrPosition_(r.data.assignToPosition);
	}
	,_doEnableJobOrPosition_: function(enablePosition) {	
		if (enablePosition) {
			this._getElement_("positionCode").enable();
			this._getElement_("jobCode").disable();
            this._getElement_("org").disable();
		} else {
			this._getElement_("positionCode").disable();
			this._getElement_("jobCode").enable();
            this._getElement_("org").enable();
		}
	}
	,_afterBind_: function(record) {	
		if (record) {
			this._doEnableJobOrPosition_(record.data.assignToPosition);
		}
	}
});
 	
