Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/EducationTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/EducationType", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeContactRelationshipDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeContactRelationship", "nan21.dnet.module.hr.ui.extjs/ds/LicenseTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/LicenseType", "nan21.dnet.module.hr.ui.extjs/ds/EmploymentTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/EmploymentType", "nan21.dnet.module.hr.ui.extjs/ds/EmplAttachmentTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/EmplAttachmentType"]);

Ext.ns("net.nan21.dnet.module.hr.employee.frame");
net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("educType", new net.nan21.dnet.module.hr.employee.dc.EducationType({multiEdit:true}))
		.addDc("contactRel", new net.nan21.dnet.module.hr.employee.dc.EmployeeContactRelationship({multiEdit:true}))
		.addDc("licType", new net.nan21.dnet.module.hr.employee.dc.LicenseType({multiEdit:true}))
		.addDc("asgnType", new net.nan21.dnet.module.hr.employee.dc.EmploymentType({multiEdit:true}))
		.addDc("attchType", new net.nan21.dnet.module.hr.employee.dc.EmplAttachmentType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("educType",{ name:"educTypeFilter", xtype:"net.nan21.dnet.module.hr.employee.dc.EducationType$Filter",height:40})	 
		.addDcView("educType",{ name:"educTypeEditList", xtype:"net.nan21.dnet.module.hr.employee.dc.EducationType$EditList", frame:true})	 
		.addDcFilterFormView("contactRel",{ name:"contactRelFilter", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeContactRelationship$Filter",height:40})	 
		.addDcView("contactRel",{ name:"contactRelEditList", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeContactRelationship$EditList", frame:true})	 
		.addDcFilterFormView("licType",{ name:"licTypeFilter", xtype:"net.nan21.dnet.module.hr.employee.dc.LicenseType$Filter",height:40})	 
		.addDcView("licType",{ name:"licTypeEditList", xtype:"net.nan21.dnet.module.hr.employee.dc.LicenseType$EditList", frame:true})	 
		.addDcFilterFormView("asgnType",{ name:"asgnTypeFilter", xtype:"net.nan21.dnet.module.hr.employee.dc.EmploymentType$Filter",height:40})	 
		.addDcView("asgnType",{ name:"asgnTypeEditList", xtype:"net.nan21.dnet.module.hr.employee.dc.EmploymentType$EditList", frame:true})	 
		.addDcFilterFormView("attchType",{ name:"attchTypeFilter", xtype:"net.nan21.dnet.module.hr.employee.dc.EmplAttachmentType$Filter",height:70})	 
		.addDcView("attchType",{ name:"attchTypeEditList", xtype:"net.nan21.dnet.module.hr.employee.dc.EmplAttachmentType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasEducType", layout:"border", defaults:{split:true},title:"Education type",header:false})  	 
		.addPanel({name: "canvasContactRel", layout:"border", defaults:{split:true},title:"Contact relationship",header:false})  	 
		.addPanel({name: "canvasLicType", layout:"border", defaults:{split:true},title:"License types",header:false})  	 
		.addPanel({name: "canvasAsgnType", layout:"border", defaults:{split:true},title:"Employment types",header:false})  	 
		.addPanel({name: "canvasAttchType", layout:"border", defaults:{split:true},title:"Attachment types",header:false})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasEducType","canvasContactRel","canvasLicType","canvasAsgnType","canvasAttchType"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasEducType","canvasContactRel","canvasLicType","canvasAsgnType","canvasAttchType"]) 				 		
		.addChildrenTo("canvasEducType",["educTypeFilter","educTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasContactRel",["contactRelFilter","contactRelEditList"] ,["north","center"])	
		.addChildrenTo("canvasLicType",["licTypeFilter","licTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasAsgnType",["asgnTypeFilter","asgnTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasAttchType",["attchTypeFilter","attchTypeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasEducType","educTypeTlb")	  	
	 	.addToolbarTo("canvasContactRel","contactRelTlb")	  	
	 	.addToolbarTo("canvasLicType","licTypeTlb")	  	
	 	.addToolbarTo("canvasAsgnType","asgnTypeTlb")	  	
	 	.addToolbarTo("canvasAttchType","attchTypeTlb")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("educTypeTlb", {dc:"educType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Education type"}).end()
			.beginToolbar("contactRelTlb", {dc:"contactRel"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Contact relationship"}).end()
			.beginToolbar("licTypeTlb", {dc:"licType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"License types"}).end()
			.beginToolbar("asgnTypeTlb", {dc:"asgnType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Employment types"}).end()
			.beginToolbar("attchTypeTlb", {dc:"attchType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Attachment types"}).end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI", net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI);   
