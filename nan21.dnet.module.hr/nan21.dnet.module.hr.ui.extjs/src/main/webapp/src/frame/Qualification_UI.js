Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/QualificationDs", "nan21.dnet.module.hr.ui.extjs/dc/Qualification", "nan21.dnet.module.hr.ui.extjs/ds/QualificationSkillDs", "nan21.dnet.module.hr.ui.extjs/dc/QualificationSkill","nan21.dnet.module.hr.ui.extjs/ds/SkillLovDs","nan21.dnet.module.hr.ui.extjs/lov/Skills","nan21.dnet.module.hr.ui.extjs/ds/RatingLevelLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingLevels"]);

Ext.define("net.nan21.dnet.module.hr.skill.frame.Qualification_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.skill.frame.Qualification_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.skill.frame.Qualification_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("qualif", new net.nan21.dnet.module.hr.skill.dc.Qualification({multiEdit:true}))
		.addDc("skill", new net.nan21.dnet.module.hr.skill.dc.QualificationSkill({multiEdit:true}))		
		.linkDc("skill", "qualif",{fields:[ {childField:"qualificationId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("qualif",{ name:"qualifFilter", xtype:"net.nan21.dnet.module.hr.skill.dc.Qualification$Filter",height:40})	 
		.addDcEditGridView("qualif",{ name:"qualifEditList", xtype:"net.nan21.dnet.module.hr.skill.dc.Qualification$EditList", frame:true})	 
		.addDcEditGridView("skill",{ name:"skillCtxEditList", xtype:"net.nan21.dnet.module.hr.skill.dc.QualificationSkill$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "panelRequirements", layout:"accordion", activeItem:0, id:Ext.id(),width:500}) 	  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["qualifFilter","qualifEditList","panelRequirements"] ,["north","center","east"])	
	 	.addChildrenTo("panelRequirements", ["skillCtxEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbQualifEditList")	  	
	 	.addToolbarTo("skillCtxEditList","tlbSkillCtxEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbQualifEditList", {dc:"qualif"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Qualifications"}).end()
			.beginToolbar("tlbSkillCtxEditList", {dc:"skill"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Required competences"}).end(); 	
	}

});  
