   
Ext.ns('net.nan21.dnet.module.hr.employee.dc');	 
net.nan21.dnet.module.hr.employee.dc.Employee = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Employee" 		 
			,ds: new net.nan21.dnet.module.hr.employee.ds.EmployeeDs()			  
		});
	 	net.nan21.dnet.module.hr.employee.dc.Employee.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.employee.dc'); 
net.nan21.dnet.module.hr.employee.dc.Employee$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20",maxLength:255  })
		.addCombo({ name:"gender", xtype:"combo", dataIndex:"gender", id:Ext.id(),anchor:"-20",store:[ "male", "female"]  })
		.addCombo({ name:"maritalStatus", xtype:"combo", dataIndex:"maritalStatus", id:Ext.id(),anchor:"-20",store:[ "single", "married", "divorced", "widow", "other"]  })
		.addLov({ name:"employerCode", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"employerCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "employerId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:220,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form", width:220,labelWidth:0 })
		.addPanel({ name:"col3", layout:"form", width:220,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["firstName","lastName"])
		.addChildrenTo("col2",["employerCode","code"])
		.addChildrenTo("col3",["gender","maritalStatus"])
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.employee.dc.Employee$Filter", net.nan21.dnet.module.hr.employee.dc.Employee$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.employee.dc');	 	 
net.nan21.dnet.module.hr.employee.dc.Employee$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"firstName", dataIndex:"firstName", width:100 })   	
		.addTextColumn({ name:"lastName", dataIndex:"lastName", width:100 })   	
		.addTextColumn({ name:"employerCode", dataIndex:"employerCode",width:100 })   	
		.addDateColumn({ name:"birthdate", dataIndex:"birthdate", hidden:true,format:Ext.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"gender", dataIndex:"gender",width:60 })   	
		.addTextColumn({ name:"maritalStatus", dataIndex:"maritalStatus",width:60 })   	
		.addDateColumn({ name:"currentHireDate", dataIndex:"currentHireDate", hidden:true,format:Ext.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"firstHireDate", dataIndex:"firstHireDate", hidden:true,format:Ext.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"officeEmail", dataIndex:"officeEmail",width:100 })   	
		.addTextColumn({ name:"citizenshipCode", dataIndex:"citizenshipCode", hidden:true,width:100 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"positionCode", dataIndex:"positionCode",width:100 })   	
		.addTextColumn({ name:"positionName", dataIndex:"positionName", hidden:true,width:200 })   	
		.addTextColumn({ name:"organizationCode", dataIndex:"organizationCode",width:100 })   	
		.addTextColumn({ name:"jobCode", dataIndex:"jobCode",width:100 })   	
		.addTextColumn({ name:"jobName", dataIndex:"jobName", hidden:true,width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.hr.employee.dc.Employee$List", net.nan21.dnet.module.hr.employee.dc.Employee$List ); 
 	
Ext.ns('net.nan21.dnet.module.hr.employee.dc');	 
net.nan21.dnet.module.hr.employee.dc.Employee$EditMain = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"middleName", dataIndex:"middleName",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32,vtype:"alphanum"  })
		.addLov({ name:"employerCode", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"employerCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "employerId"} ]  })
		.addDateField({ name:"birthdate", dataIndex:"birthdate",width:100 })
		.addCombo({ name:"gender", xtype:"combo", dataIndex:"gender",anchor:"-20",store:[ "male", "female"]  })
		.addCombo({ name:"maritalStatus", xtype:"combo", dataIndex:"maritalStatus",anchor:"-20",store:[ "single", "married", "divorced", "widow", "other"]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" ,width:250,labelWidth:0 })     
		.addPanel({ name:"col3", layout:"form" ,width:250,labelWidth:0 })     
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
Ext.reg("net.nan21.dnet.module.hr.employee.dc.Employee$EditMain", net.nan21.dnet.module.hr.employee.dc.Employee$EditMain ); 
 	
Ext.ns('net.nan21.dnet.module.hr.employee.dc');	 
net.nan21.dnet.module.hr.employee.dc.Employee$EditOther = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDateField({ name:"firstHireDate", dataIndex:"firstHireDate",width:100 })
		.addDateField({ name:"currentHireDate", dataIndex:"currentHireDate",width:100 })
		.addTextField({ name:"officeEmail", dataIndex:"officeEmail",anchor:"-20" ,maxLength:128,vtype:"email"  })
		.addCheckbox({ name:"hasDisability", dataIndex:"hasDisability"  })
		.addLov({ name:"citizenshipCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"citizenshipCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "citizenshipId"} ]  })
		.addTextField({ name:"passportNo", dataIndex:"passportNo",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		.addTextField({ name:"sinNo", dataIndex:"sinNo",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		.addTextField({ name:"ssnNo", dataIndex:"ssnNo",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		.addCheckbox({ name:"assignToPosition", dataIndex:"assignToPosition"  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.employee.lovs.EmploymentTypes", dataIndex:"type",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"positionCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Positions", dataIndex:"positionCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "positionId"} ,{lovField:"name", dsField: "positionName"} ]  })
		.addTextField({ name:"positionName", dataIndex:"positionName",anchor:"-20",disabled:true  ,maxLength:255  })
		.addLov({ name:"jobCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Jobs", dataIndex:"jobCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "jobId"} ,{lovField:"name", dsField: "jobName"} ]  })
		.addTextField({ name:"jobName", dataIndex:"jobName",anchor:"-20",disabled:true  ,maxLength:255  })
		.addLov({ name:"gradeCode", xtype:"net.nan21.dnet.module.hr.grade.lovs.Grades", dataIndex:"gradeCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "gradeId"} ]  })
		.addLov({ name:"organizationCode", xtype:"net.nan21.dnet.module.bd.org.lovs.Organizations", dataIndex:"organizationCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" ,width:250,labelWidth:110 })     
		.addPanel({ name:"col3", layout:"form" , width:350,labelWidth:110 })     
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
});
Ext.reg("net.nan21.dnet.module.hr.employee.dc.Employee$EditOther", net.nan21.dnet.module.hr.employee.dc.Employee$EditOther ); 
