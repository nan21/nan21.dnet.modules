   

Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee", {
	extend: "dnet.base.AbstractDc",
 
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
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.employee.dc.Employee$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20",maxLength:255  })
		.addCombo({ name:"gender", xtype:"combo", dataIndex:"gender",anchor:"-20",store:[ "male", "female"]  })
		.addCombo({ name:"maritalStatus", xtype:"combo", dataIndex:"maritalStatus",anchor:"-20",store:[ "single", "married", "divorced", "widow", "other"]  })
		.addLov({ name:"employerCode", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"employerCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "employerId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:220}) 
		.addPanel({ name:"col2", layout:"anchor", width:220}) 
		.addPanel({ name:"col3", layout:"anchor", width:220}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["firstName","lastName"])
		.addChildrenTo("col2",["employerCode","code"])
		.addChildrenTo("col3",["gender","maritalStatus"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.employee.dc.Employee$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
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
		.addTextColumn({ name:"organizationCode", dataIndex:"organizationCode",width:100 })   	
		.addTextColumn({ name:"jobCode", dataIndex:"jobCode",width:100 })   	
		.addTextColumn({ name:"jobName", dataIndex:"jobName", hidden:true,width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee$EditMain", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.hr.employee.dc.Employee$EditMain",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"middleName", dataIndex:"middleName",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addLov({ name:"employerCode", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"employerCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "employerId"} ]  })
		.addDateField({ name:"birthdate", dataIndex:"birthdate",anchor:"-20" })
		.addCombo({ name:"gender", xtype:"localcombo", dataIndex:"gender",anchor:"-20" ,store:[ "male", "female"]  })
		.addCombo({ name:"maritalStatus", xtype:"localcombo", dataIndex:"maritalStatus",anchor:"-20" ,store:[ "single", "married", "divorced", "widow", "other"]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300})     
		.addPanel({ name:"col2", layout:"anchor" ,width:250})     
		.addPanel({ name:"col3", layout:"anchor" ,width:250})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["firstName","lastName","middleName"])
		.addChildrenTo("col2",["employerCode","code"])
		.addChildrenTo("col3",["gender","birthdate","maritalStatus"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee$EditOther", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.hr.employee.dc.Employee$EditOther",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDateField({ name:"firstHireDate", dataIndex:"firstHireDate",anchor:"-20" })
		.addDateField({ name:"currentHireDate", dataIndex:"currentHireDate",anchor:"-20" })
		.addTextField({ name:"officeEmail", dataIndex:"officeEmail",anchor:"-20" ,maxLength:128,vtype:"email"  })
		.addCheckbox({ name:"hasDisability", dataIndex:"hasDisability"  })
		.addLov({ name:"citizenshipCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"citizenshipCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "citizenshipId"} ]  })
		.addTextField({ name:"passportNo", dataIndex:"passportNo",anchor:"-20" ,maxLength:32  })
		.addTextField({ name:"sinNo", dataIndex:"sinNo",anchor:"-20" ,maxLength:32  })
		.addTextField({ name:"ssnNo", dataIndex:"ssnNo",anchor:"-20" ,maxLength:32  })
		.addCheckbox({ name:"assignToPosition", dataIndex:"assignToPosition",listeners:{change:{scope:this, fn:this.onAssignToPositionChange}}  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.employee.lovs.EmploymentTypes", dataIndex:"type",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"positionCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Positions", dataIndex:"positionCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "positionId"} ,{lovField:"name", dsField: "positionName"} ]  })
		.addDisplayFieldText({ name:"positionName", dataIndex:"positionName"  })
		.addLov({ name:"jobCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Jobs", dataIndex:"jobCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "jobId"} ,{lovField:"name", dsField: "jobName"} ]  })
		.addDisplayFieldText({ name:"jobName", dataIndex:"jobName"  })
		.addLov({ name:"gradeCode", xtype:"net.nan21.dnet.module.hr.grade.lovs.Grades", dataIndex:"gradeCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "gradeId"} ]  })
		.addLov({ name:"organizationCode", xtype:"net.nan21.dnet.module.bd.org.lovs.Organizations", dataIndex:"organizationCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300})     
		.addPanel({ name:"col2", layout:"anchor" ,width:250, defaults:{
labelAlign:"right",labelWidth:110}})     
		.addPanel({ name:"col3", layout:"anchor" , width:350, defaults:{
labelAlign:"right",labelWidth:110}})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["citizenshipCode","passportNo","ssnNo","sinNo","officeEmail","currentHireDate","firstHireDate"])
		.addChildrenTo("col2",["assignToPosition","positionCode","jobCode","organizationCode","gradeCode"])
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
            r.set("organizationCode", "");
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
            this._getElement_("organizationCode").disable();
		} else {
			this._getElement_("positionCode").disable();
			this._getElement_("jobCode").enable();
            this._getElement_("organizationCode").enable();
		}
	}
	,_afterBind_: function(record) {	
		if (record) {
				this._doEnableJobOrPosition_(record.data.assignToPosition);
			}
	}
});
