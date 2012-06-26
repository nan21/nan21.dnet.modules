   

Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeDs",
	filterModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeDsFilter",
	paramModel: "net.nan21.dnet.module.hr.employee.ds.param.EmployeeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.employee.dc.Employee$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20",maxLength:255  })
		.addCombo({ name:"gender", xtype:"combo", dataIndex:"gender",anchor:"-20",store:[ "male", "female"]  })
		.addCombo({ name:"maritalStatus", xtype:"combo", dataIndex:"maritalStatus",anchor:"-20",store:[ "single", "married", "divorced", "widow", "other"]  })
		.addLov({ name:"employerCode", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"employerCode",anchor:"-20",allowBlank:false,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "employerId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.employee.lovs.EmploymentTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"jobCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Jobs", dataIndex:"jobCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "jobId"} ,{lovField:"name", dsField: "jobName"} ]  })
		.addLov({ name:"payroll", xtype:"net.nan21.dnet.module.hr.payroll.lovs.Payrolls", dataIndex:"payroll",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "payrollId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:220}) 
		.addPanel({ name:"col2", layout:"form", width:220}) 
		.addPanel({ name:"col3", layout:"form", width:220}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["employerCode","firstName","lastName","code"])
		.addChildrenTo("col2",["type","jobCode","payroll"])
		.addChildrenTo("col3",["gender","maritalStatus"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.employee.dc.Employee$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"firstName", dataIndex:"firstName", width:100 })   	
		.addTextColumn({ name:"lastName", dataIndex:"lastName", width:100 })   	
		.addTextColumn({ name:"employerCode", dataIndex:"employerCode",width:100 })   	
		.addDateColumn({ name:"birthdate", dataIndex:"birthdate", hidden:true,format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"gender", dataIndex:"gender",width:60 })   	
		.addTextColumn({ name:"maritalStatus", dataIndex:"maritalStatus",width:60 })   	
		.addDateColumn({ name:"currentHireDate", dataIndex:"currentHireDate", hidden:true,format:Dnet.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"firstHireDate", dataIndex:"firstHireDate", hidden:true,format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"officeEmail", dataIndex:"officeEmail",width:100 })   	
		.addTextColumn({ name:"citizenshipCode", dataIndex:"citizenshipCode", hidden:true,width:100 })   	
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
 
 	
 	

Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee$EditMain", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.hr.employee.dc.Employee$EditMain",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"firstName", dataIndex:"firstName" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"middleName", dataIndex:"middleName" ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code" ,maxLength:32  })
		.addLov({ name:"employerCode", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"employerCode" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "employerId"} ]  })
		.addDateField({ name:"birthdate", dataIndex:"birthdate" })
		.addCombo({ name:"gender", xtype:"localcombo", dataIndex:"gender" ,store:[ "male", "female"]  })
		.addCombo({ name:"maritalStatus", xtype:"localcombo", dataIndex:"maritalStatus" ,store:[ "single", "married", "divorced", "widow", "other"]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"col3", layout:"form" ,width:250})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["lastName","firstName","middleName"])
		.addChildrenTo("col2",["employerCode","code"])
		.addChildrenTo("col3",["gender","birthdate","maritalStatus"])
;
	}	
});
 	
 	

Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee$EditOther", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.hr.employee.dc.Employee$EditOther",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDateField({ name:"firstHireDate", dataIndex:"firstHireDate" })
		.addDateField({ name:"currentHireDate", dataIndex:"currentHireDate" })
		.addTextField({ name:"officeEmail", dataIndex:"officeEmail" ,maxLength:128,vtype:"email"  })
		.addCheckbox({ name:"hasDisability", dataIndex:"hasDisability"  })
		.addLov({ name:"citizenshipCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"citizenshipCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "citizenshipId"} ]  })
		.addTextField({ name:"passportNo", dataIndex:"passportNo" ,maxLength:32  })
		.addTextField({ name:"sinNo", dataIndex:"sinNo" ,maxLength:32  })
		.addTextField({ name:"ssnNo", dataIndex:"ssnNo" ,maxLength:32  })
		.addCheckbox({ name:"assignToPosition", dataIndex:"assignToPosition",listeners:{change:{scope:this, fn:this.onAssignToPositionChange}}  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.employee.lovs.EmploymentTypes", dataIndex:"type" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"positionCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Positions", dataIndex:"positionCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "positionId"} ,{lovField:"name", dsField: "positionName"} ]  })
		.addDisplayFieldText({ name:"positionName", dataIndex:"positionName"  })
		.addLov({ name:"jobCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Jobs", dataIndex:"jobCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "jobId"} ,{lovField:"name", dsField: "jobName"} ]  })
		.addDisplayFieldText({ name:"jobName", dataIndex:"jobName"  })
		.addLov({ name:"gradeCode", xtype:"net.nan21.dnet.module.hr.grade.lovs.Grades", dataIndex:"gradeCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "gradeId"} ]  })
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.Organizations", dataIndex:"org" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addNumberField({ name:"baseSalary", dataIndex:"baseSalary"  , style: "text-align:right;" })
		.addLov({ name:"payroll", xtype:"net.nan21.dnet.module.hr.payroll.lovs.Payrolls", dataIndex:"payroll" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "payrollId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
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
		.addChildrenTo("col1",["citizenshipCode","passportNo","ssnNo","sinNo","officeEmail","currentHireDate","firstHireDate"])
		.addChildrenTo("col2",["assignToPosition","positionCode","jobCode","org","gradeCode","payroll","baseSalary"])
		.addChildrenTo("col3",["type","positionName","jobName"])
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
 	
