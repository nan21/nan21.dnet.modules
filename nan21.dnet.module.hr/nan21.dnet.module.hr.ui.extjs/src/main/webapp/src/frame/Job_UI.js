Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/JobDs", "nan21.dnet.module.hr.ui.extjs/dc/Job", "nan21.dnet.module.hr.ui.extjs/ds/JobSkillDs", "nan21.dnet.module.hr.ui.extjs/dc/JobSkill", "nan21.dnet.module.hr.ui.extjs/ds/JobRequirementDs", "nan21.dnet.module.hr.ui.extjs/dc/JobRequirement", "nan21.dnet.module.hr.ui.extjs/ds/JobCourseDs", "nan21.dnet.module.hr.ui.extjs/dc/JobCourse","nan21.dnet.module.hr.ui.extjs/ds/JobTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/JobTypes","nan21.dnet.module.hr.ui.extjs/ds/JobTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/JobTypes","nan21.dnet.module.hr.ui.extjs/ds/SkillLovDs","nan21.dnet.module.hr.ui.extjs/lov/Skills","nan21.dnet.module.hr.ui.extjs/ds/RatingLevelLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingLevels","nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementLovDs","nan21.dnet.module.hr.ui.extjs/lov/WorkRequirements","nan21.dnet.module.hr.ui.extjs/ds/CourseLovDs","nan21.dnet.module.hr.ui.extjs/lov/Courses"]);

Ext.define("net.nan21.dnet.module.hr.job.frame.Job_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.job.frame.Job_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.job.frame.Job_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("job", new net.nan21.dnet.module.hr.job.dc.Job({}))
		.addDc("skill", new net.nan21.dnet.module.hr.skill.dc.JobSkill({multiEdit:true}))
		.addDc("req", new net.nan21.dnet.module.hr.job.dc.JobRequirement({multiEdit:true}))
		.addDc("course", new net.nan21.dnet.module.hr.training.dc.JobCourse({multiEdit:true}))		
		.linkDc("skill", "job",{fields:[ {childField:"jobId", parentField:"id"} ]} )
		.linkDc("req", "job",{fields:[ {childField:"jobId", parentField:"id"} ]} )
		.linkDc("course", "job",{fields:[ {childField:"jobId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("job",{ name:"jobFilter", xtype:"net.nan21.dnet.module.hr.job.dc.Job$Filter"})	 
		.addDcView("job",{ name:"jobList", xtype:"net.nan21.dnet.module.hr.job.dc.Job$List"})	 
		.addDcView("job",{ name:"jobEditList", xtype:"net.nan21.dnet.module.hr.job.dc.Job$EditList", frame:true})	 
		.addDcFormView("job",{ name:"jobEdit", xtype:"net.nan21.dnet.module.hr.job.dc.Job$Edit",height:120})	 
		.addDcView("skill",{ name:"skillCtxEditList", xtype:"net.nan21.dnet.module.hr.skill.dc.JobSkill$CtxEditList", frame:true,title:"Competences"})	 
		.addDcView("req",{ name:"reqCtxEditList", xtype:"net.nan21.dnet.module.hr.job.dc.JobRequirement$CtxEditList", frame:true,title:"Requirements"})	 
		.addDcView("course",{ name:"courseCtxEditList", xtype:"net.nan21.dnet.module.hr.training.dc.JobCourse$JobCtxEditList", frame:true,title:"Courses"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "detailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["jobFilter","jobList"] ,["north","center"])	
		.addChildrenTo("canvas2",["jobEdit","detailsTab"] ,["north","center"])	
	 	.addChildrenTo("detailsTab", ["reqCtxEditList","skillCtxEditList","courseCtxEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbJobList")	  	
	 	.addToolbarTo("canvas2","tlbJobEdit")	  	
	 	.addToolbarTo("skillCtxEditList","tlbSkillCtxEditList")	  	
	 	.addToolbarTo("reqCtxEditList","tlbReqCtxEditList")	  	
	 	.addToolbarTo("courseCtxEditList","tlbCourseCtxEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbJobList", {dc:"job"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbJobEdit", {dc:"job"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbSkillCtxEditList", {dc:"skill"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Competences"}).end()
			.beginToolbar("tlbReqCtxEditList", {dc:"req"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Requirements"}).end()
			.beginToolbar("tlbCourseCtxEditList", {dc:"course"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Courses"}).end(); 	
	}

});  
