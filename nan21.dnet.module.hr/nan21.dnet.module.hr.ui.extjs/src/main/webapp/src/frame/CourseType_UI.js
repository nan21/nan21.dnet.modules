Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/CourseCategoryDs", "nan21.dnet.module.hr.ui.extjs/dc/CourseCategory", "nan21.dnet.module.hr.ui.extjs/ds/CourseTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/CourseType","nan21.dnet.module.hr.ui.extjs/ds/CourseCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/CourseCategories","nan21.dnet.module.hr.ui.extjs/ds/CourseCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/CourseCategories"]);

Ext.define("net.nan21.dnet.module.hr.training.frame.CourseType_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.training.frame.CourseType_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.training.frame.CourseType_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("ccateg", new net.nan21.dnet.module.hr.training.dc.CourseCategory({multiEdit:true}))
		.addDc("ctype", new net.nan21.dnet.module.hr.training.dc.CourseType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("ccateg",{ name:"ccategFilter", xtype:"net.nan21.dnet.module.hr.training.dc.CourseCategory$Filter",height:120})	 
		.addDcEditGridView("ccateg",{ name:"ccategEditList", xtype:"net.nan21.dnet.module.hr.training.dc.CourseCategory$EditList", frame:true})	 
		.addDcFilterFormView("ctype",{ name:"ctypeFilter", xtype:"net.nan21.dnet.module.hr.training.dc.CourseType$Filter",height:120})	 
		.addDcEditGridView("ctype",{ name:"ctypeEditList", xtype:"net.nan21.dnet.module.hr.training.dc.CourseType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCategory", layout:"border", defaults:{split:true},title:"Course categories",preventHeader:true})  	 
		.addPanel({name: "canvasType", layout:"border", defaults:{split:true},title:"Course types",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasCategory","canvasType"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasCategory","canvasType"]) 				 		
		.addChildrenTo("canvasCategory",["ccategFilter","ccategEditList"] ,["north","center"])	
		.addChildrenTo("canvasType",["ctypeFilter","ctypeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCategory","tlbCcategEditList")	  	
	 	.addToolbarTo("canvasType","tlbCtypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCcategEditList", {dc:"ccateg"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Course categories"}).end()
			.beginToolbar("tlbCtypeEditList", {dc:"ctype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Course types"}).end(); 	
	}

});  
