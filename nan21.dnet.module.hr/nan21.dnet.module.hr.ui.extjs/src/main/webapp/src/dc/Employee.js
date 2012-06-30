   

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
		//containers
		.addPanel({ name:"col1", layout:"form", width:220}) 
		.addPanel({ name:"col2", layout:"form", width:220}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["employerCode","firstName","lastName","code"])
		.addChildrenTo("col2",["gender","maritalStatus"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.employee.dc.Employee$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"employerCode", dataIndex:"employerCode",width:100 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"firstName", dataIndex:"firstName", width:100 })   	
		.addTextColumn({ name:"middleName", dataIndex:"middleName",width:200 })   	
		.addTextColumn({ name:"lastName", dataIndex:"lastName", width:100 })   	
		.addTextColumn({ name:"gender", dataIndex:"gender",width:60 })   	
		.addTextColumn({ name:"maritalStatus", dataIndex:"maritalStatus",width:60 })   	
		.addDateColumn({ name:"currentHireDate", dataIndex:"currentHireDate",format:Dnet.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"firstHireDate", dataIndex:"firstHireDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"officeEmail", dataIndex:"officeEmail",width:100 })   	
		.addTextColumn({ name:"citizenshipCode", dataIndex:"citizenshipCode", hidden:true,width:100 })   	
		.addDateColumn({ name:"birthdate", dataIndex:"birthdate",format:Dnet.DATE_FORMAT})   	      	     
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
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ])
		.addChildrenTo("col1",["citizenshipCode","passportNo","ssnNo","sinNo","officeEmail","currentHireDate","firstHireDate"])
;
	}	
});
 	
