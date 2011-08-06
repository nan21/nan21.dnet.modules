Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeDs", "nan21.dnet.module.hr.ui.extjs/dc/Employee", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeSkillDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeSkill", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeContactDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeContact", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelDs", "nan21.dnet.module.bd.ui.extjs/dc/CommunicationChannel", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeEducationDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeEducation", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeWorkExperienceDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeWorkExperience", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeLicenseDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeLicense", "nan21.dnet.module.bd.ui.extjs/ds/LocationDs", "nan21.dnet.module.bd.ui.extjs/dc/Location","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/RegionLovDs","nan21.dnet.module.bd.ui.extjs/lov/Regions","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.hr.ui.extjs/ds/EmployeeContactRelationshipLovDs","nan21.dnet.module.hr.ui.extjs/lov/EmployeeContactRelationships","nan21.dnet.module.hr.ui.extjs/ds/SkillLovDs","nan21.dnet.module.hr.ui.extjs/lov/Skills","nan21.dnet.module.hr.ui.extjs/ds/RatingLevelLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingLevels","nan21.dnet.module.hr.ui.extjs/ds/EducationTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/EducationTypes","nan21.dnet.module.hr.ui.extjs/ds/LicenseTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/LicenseTypes","nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/CommunicationChannelTypes"]);

Ext.ns("net.nan21.dnet.module.hr.employee.frame");
net.nan21.dnet.module.hr.employee.frame.Employee_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.employee.frame.Employee_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("emp", new net.nan21.dnet.module.hr.employee.dc.Employee())
		.addDc("skill", new net.nan21.dnet.module.hr.skill.dc.EmployeeSkill({multiEdit:true}))
		.addDc("cont", new net.nan21.dnet.module.hr.employee.dc.EmployeeContact({multiEdit:true}))
		.addDc("communic", new net.nan21.dnet.module.bd.contact.dc.CommunicationChannel({multiEdit:true}))
		.addDc("educ", new net.nan21.dnet.module.hr.employee.dc.EmployeeEducation({multiEdit:true}))
		.addDc("work", new net.nan21.dnet.module.hr.employee.dc.EmployeeWorkExperience({multiEdit:true}))
		.addDc("lic", new net.nan21.dnet.module.hr.employee.dc.EmployeeLicense({multiEdit:true}))
		.addDc("address", new net.nan21.dnet.module.bd.geo.dc.Location())		
		.linkDc("skill", "emp",{fields:[ {childField:"employeeId", parentField:"id"} ]} )
		.linkDc("cont", "emp",{fields:[ {childField:"employeeId", parentField:"id"} ]} )
		.linkDc("communic", "emp",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("educ", "emp",{fields:[ {childField:"employeeId", parentField:"id"} ]} )
		.linkDc("work", "emp",{fields:[ {childField:"employeeId", parentField:"id"} ]} )
		.linkDc("lic", "emp",{fields:[ {childField:"employeeId", parentField:"id"} ]} )
		.linkDc("address", "emp",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]} );		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("emp",{ name:"empFilter", xtype:"net.nan21.dnet.module.hr.employee.dc.Employee$Filter"})	 
		.addDcView("emp",{ name:"empList", xtype:"net.nan21.dnet.module.hr.employee.dc.Employee$List"})	 
		.addDcView("emp",{ name:"empEditMain", xtype:"net.nan21.dnet.module.hr.employee.dc.Employee$EditMain",height:100})	 
		.addDcView("emp",{ name:"empEditOther", xtype:"net.nan21.dnet.module.hr.employee.dc.Employee$EditOther",title:"Details"})	 
		.addDcView("cont",{ name:"contEditList", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeContact$CtxEditList", frame:true,title:"Contacts"})	 
		.addDcView("skill",{ name:"skillEditList", xtype:"net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$EditList", frame:true,title:"Competences"})	 
		.addDcView("educ",{ name:"educEditList", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeEducation$EditList", frame:true,title:"Education"})	 
		.addDcView("work",{ name:"workEditList", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeWorkExperience$EditList", frame:true,title:"Work experience"})	 
		.addDcView("lic",{ name:"licEditList", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeLicense$EditList", frame:true,title:"Licenses"})	 
		.addDcView("communic",{ name:"communicEditList", xtype:"net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList", frame:true,title:"Communication"})	 
		.addDcView("address",{ name:"addressList", xtype:"net.nan21.dnet.module.bd.geo.dc.Location$ListCtx"})	 
		.addDcView("address",{ name:"addressEdit", xtype:"net.nan21.dnet.module.bd.geo.dc.Location$EditCtx"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "addressPanel",layout:"card", activeItem:0,title:"Address"})  	 
		.addPanel({name: "empDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
		.addPanel({name: "addressEditWrapper", layout:"fit"})
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["empFilter","empList"] ,["north","center"])	
		.addChildrenTo("canvas2",["empEditMain","empDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("empDetailsTab", ["empEditOther","communicEditList","addressPanel","contEditList","skillEditList","licEditList","educEditList","workEditList"]) 				 		
	 	.addChildrenTo("addressPanel", ["addressList","addressEditWrapper"]) 				 		
	 	.addChildrenTo("addressEditWrapper", ["addressEdit"]) 				 		
	 	.addToolbarTo("canvas1","tlbEmpList")	  	
	 	.addToolbarTo("canvas2","tlbEmpEdit")	  	
	 	.addToolbarTo("skillEditList","tlbSkillList")	  	
	 	.addToolbarTo("contEditList","tlbContList")	  	
	 	.addToolbarTo("educEditList","tlbEducList")	  	
	 	.addToolbarTo("workEditList","tlbWorkList")	  	
	 	.addToolbarTo("licEditList","tlbLicList")	  	
	 	.addToolbarTo("communicEditList","tlbCommunicEditList")	  	
	 	.addToolbarTo("addressList","tlbAddressList")	  	
	 	.addToolbarTo("addressEditWrapper","tlbAddressEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbEmpList", {dc:"emp"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbEmpEdit", {dc:"emp"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbSkillList", {dc:"skill"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbContList", {dc:"cont"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbEducList", {dc:"educ"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbWorkList", {dc:"work"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbLicList", {dc:"lic"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbCommunicEditList", {dc:"communic"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbAddressList", {dc:"address"}).addQuery().addEdit({inContainer:"addressPanel",showView:"addressEditWrapper"}).addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbAddressEdit", {dc:"address"}).addBack({inContainer:"addressPanel",showView:"addressList"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.employee.frame.Employee_UI", net.nan21.dnet.module.hr.employee.frame.Employee_UI);   
