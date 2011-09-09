Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/PositionDs", "nan21.dnet.module.hr.ui.extjs/dc/Position", "nan21.dnet.module.hr.ui.extjs/ds/PositionSkillDs", "nan21.dnet.module.hr.ui.extjs/dc/PositionSkill", "nan21.dnet.module.hr.ui.extjs/ds/PositionRequirementDs", "nan21.dnet.module.hr.ui.extjs/dc/PositionRequirement", "nan21.dnet.module.hr.ui.extjs/ds/PositionCourseDs", "nan21.dnet.module.hr.ui.extjs/dc/PositionCourse","nan21.dnet.module.bd.ui.extjs/ds/OrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/Organizations","nan21.dnet.module.hr.ui.extjs/ds/JobLovDs","nan21.dnet.module.hr.ui.extjs/lov/Jobs","nan21.dnet.module.bd.ui.extjs/ds/OrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/Organizations","nan21.dnet.module.hr.ui.extjs/ds/JobLovDs","nan21.dnet.module.hr.ui.extjs/lov/Jobs","nan21.dnet.module.hr.ui.extjs/ds/SkillLovDs","nan21.dnet.module.hr.ui.extjs/lov/Skills","nan21.dnet.module.hr.ui.extjs/ds/RatingLevelLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingLevels","nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementLovDs","nan21.dnet.module.hr.ui.extjs/lov/WorkRequirements","nan21.dnet.module.hr.ui.extjs/ds/CourseLovDs","nan21.dnet.module.hr.ui.extjs/lov/Courses"]);

Ext.ns("net.nan21.dnet.module.hr.job.frame");
net.nan21.dnet.module.hr.job.frame.Position_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.job.frame.Position_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("pos", new net.nan21.dnet.module.hr.job.dc.Position())
		.addDc("skill", new net.nan21.dnet.module.hr.skill.dc.PositionSkill({multiEdit:true}))
		.addDc("req", new net.nan21.dnet.module.hr.job.dc.PositionRequirement({multiEdit:true}))
		.addDc("course", new net.nan21.dnet.module.hr.training.dc.PositionCourse({multiEdit:true}))		
		.linkDc("skill", "pos",{fields:[ {childField:"positionId", parentField:"id"} ]} )
		.linkDc("req", "pos",{fields:[ {childField:"positionId", parentField:"id"} ]} )
		.linkDc("course", "pos",{fields:[ {childField:"positionId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("pos",{ name:"posFilter", xtype:"net.nan21.dnet.module.hr.job.dc.Position$Filter"})	 
		.addDcView("pos",{ name:"posList", xtype:"net.nan21.dnet.module.hr.job.dc.Position$List"})	 
		.addDcFormView("pos",{ name:"posEdit", xtype:"net.nan21.dnet.module.hr.job.dc.Position$Edit",height:150})	 
		.addDcView("skill",{ name:"skillCtxEditList", xtype:"net.nan21.dnet.module.hr.skill.dc.PositionSkill$CtxEditList", frame:true,title:"Competences"})	 
		.addDcView("req",{ name:"reqCtxEditList", xtype:"net.nan21.dnet.module.hr.job.dc.PositionRequirement$CtxEditList", frame:true,title:"Requirements"})	 
		.addDcView("course",{ name:"courseCtxEditList", xtype:"net.nan21.dnet.module.hr.training.dc.PositionCourse$PositionCtxEditList", frame:true,title:"Courses"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "detailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["posFilter","posList"] ,["north","center"])	
		.addChildrenTo("canvas2",["posEdit","detailsTab"] ,["north","center"])	
	 	.addChildrenTo("detailsTab", ["reqCtxEditList","skillCtxEditList","courseCtxEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbPosList")	  	
	 	.addToolbarTo("canvas2","tlbPosEdit")	  	
	 	.addToolbarTo("skillCtxEditList","tlbSkillCtxEditList")	  	
	 	.addToolbarTo("reqCtxEditList","tlbReqCtxEditList")	  	
	 	.addToolbarTo("courseCtxEditList","tlbCourseCtxEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPosList", {dc:"pos"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbPosEdit", {dc:"pos"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbSkillCtxEditList", {dc:"skill"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Competences"}).end()
			.beginToolbar("tlbReqCtxEditList", {dc:"req"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Requirements"}).end()
			.beginToolbar("tlbCourseCtxEditList", {dc:"course"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Courses"}).end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.job.frame.Position_UI", net.nan21.dnet.module.hr.job.frame.Position_UI);   
