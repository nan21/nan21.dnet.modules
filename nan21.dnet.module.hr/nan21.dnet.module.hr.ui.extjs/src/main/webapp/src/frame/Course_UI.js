Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/CourseDs", "nan21.dnet.module.hr.ui.extjs/dc/Course", "nan21.dnet.module.hr.ui.extjs/ds/JobCourseDs", "nan21.dnet.module.hr.ui.extjs/dc/JobCourse", "nan21.dnet.module.hr.ui.extjs/ds/PositionCourseDs", "nan21.dnet.module.hr.ui.extjs/dc/PositionCourse","nan21.dnet.module.hr.ui.extjs/ds/CourseTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/CourseTypes","nan21.dnet.module.hr.ui.extjs/ds/CourseTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/CourseTypes","nan21.dnet.module.hr.ui.extjs/ds/JobLovDs","nan21.dnet.module.hr.ui.extjs/lov/Jobs","nan21.dnet.module.hr.ui.extjs/ds/PositionLovDs","nan21.dnet.module.hr.ui.extjs/lov/Positions"]);

Ext.ns("net.nan21.dnet.module.hr.training.frame");
net.nan21.dnet.module.hr.training.frame.Course_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.training.frame.Course_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("course", new net.nan21.dnet.module.hr.training.dc.Course())
		.addDc("job", new net.nan21.dnet.module.hr.training.dc.JobCourse({multiEdit:true}))
		.addDc("position", new net.nan21.dnet.module.hr.training.dc.PositionCourse({multiEdit:true}))		
		.linkDc("job", "course",{fields:[ {childField:"courseId", parentField:"id"} ]} )
		.linkDc("position", "course",{fields:[ {childField:"courseId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("course",{ name:"courseFilter", xtype:"net.nan21.dnet.module.hr.training.dc.Course$Filter"})	 
		.addDcView("course",{ name:"courseList", xtype:"net.nan21.dnet.module.hr.training.dc.Course$List"})	 
		.addDcFormView("course",{ name:"courseEdit", xtype:"net.nan21.dnet.module.hr.training.dc.Course$Edit"})	 
		.addDcView("job",{ name:"jobList", xtype:"net.nan21.dnet.module.hr.training.dc.JobCourse$CourseCtxEditList", frame:true,title:"Jobs"})	 
		.addDcView("position",{ name:"positionList", xtype:"net.nan21.dnet.module.hr.training.dc.PositionCourse$CourseCtxEditList", frame:true,title:"Positions"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "details", _wrapped_:true, layout:"fit",frame:"false" ,items:{ layout:"accordion", activeItem:0, id:Ext.id(),width:450}}) 	  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["courseFilter","courseList"] ,["north","center"])	
		.addChildrenTo("canvas2",["courseEdit","details"] ,["center","east"])	
	 	.addChildrenTo("details", ["jobList","positionList"]) 				 		
	 	.addToolbarTo("canvas1","tlbCourseList")	  	
	 	.addToolbarTo("canvas2","tlbCourseEdit")	  	
	 	.addToolbarTo("jobList","tlbJobList")	  	
	 	.addToolbarTo("positionList","tlbPositionList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCourseList", {dc:"course"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbCourseEdit", {dc:"course"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbJobList", {dc:"job"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Jobs"}).end()
			.beginToolbar("tlbPositionList", {dc:"position"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Positions"}).end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.training.frame.Course_UI", net.nan21.dnet.module.hr.training.frame.Course_UI);   
