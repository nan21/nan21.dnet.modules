Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/AbsenceCategoryDs", "nan21.dnet.module.hr.ui.extjs/dc/AbsenceCategory", "nan21.dnet.module.hr.ui.extjs/ds/AbsenceTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/AbsenceType", "nan21.dnet.module.hr.ui.extjs/ds/AbsenceReasonDs", "nan21.dnet.module.hr.ui.extjs/dc/AbsenceReason","nan21.dnet.module.hr.ui.extjs/ds/AbsenceCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/AbsenceCategories","nan21.dnet.module.hr.ui.extjs/ds/AbsenceTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/AbsenceTypes","nan21.dnet.module.hr.ui.extjs/ds/AbsenceCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/AbsenceCategories","nan21.dnet.module.hr.ui.extjs/ds/AbsenceTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/AbsenceTypes"]);

Ext.ns("net.nan21.dnet.module.hr.time.frame");
net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("abscateg", new net.nan21.dnet.module.hr.time.dc.AbsenceCategory({multiEdit:true}))
		.addDc("abstype", new net.nan21.dnet.module.hr.time.dc.AbsenceType({multiEdit:true}))
		.addDc("absreason", new net.nan21.dnet.module.hr.time.dc.AbsenceReason({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("abscateg",{ name:"abscategFilter", xtype:"net.nan21.dnet.module.hr.time.dc.AbsenceCategory$Filter",height:35})	 
		.addDcView("abscateg",{ name:"abscategEditList", xtype:"net.nan21.dnet.module.hr.time.dc.AbsenceCategory$EditList", frame:true})	 
		.addDcFilterFormView("abstype",{ name:"abstypeFilter", xtype:"net.nan21.dnet.module.hr.time.dc.AbsenceType$Filter",height:35})	 
		.addDcView("abstype",{ name:"abstypeEditList", xtype:"net.nan21.dnet.module.hr.time.dc.AbsenceType$EditList", frame:true})	 
		.addDcFilterFormView("absreason",{ name:"absreasonFilter", xtype:"net.nan21.dnet.module.hr.time.dc.AbsenceReason$Filter",height:35})	 
		.addDcView("absreason",{ name:"absreasonEditList", xtype:"net.nan21.dnet.module.hr.time.dc.AbsenceReason$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCateg", layout:"border", defaults:{split:true},title:"Absence categories",header:false})  	 
		.addPanel({name: "canvasType", layout:"border", defaults:{split:true},title:"Absence types",header:false})  	 
		.addPanel({name: "canvasReason", layout:"border", defaults:{split:true},title:"Absence reasons",header:false})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasReason","canvasType","canvasCateg"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasCateg","canvasType","canvasReason"]) 				 		
		.addChildrenTo("canvasCateg",["abscategFilter","abscategEditList"] ,["north","center"])	
		.addChildrenTo("canvasType",["abstypeFilter","abstypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasReason",["absreasonFilter","absreasonEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCateg","tlbabcategFilter")	  	
	 	.addToolbarTo("canvasType","tlbabstypeFilter")	  	
	 	.addToolbarTo("canvasReason","tlbabsreasonFilter")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbabcategFilter", {dc:"abscateg"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Absence categories"}).end()
			.beginToolbar("tlbabstypeFilter", {dc:"abstype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Absence types"}).end()
			.beginToolbar("tlbabsreasonFilter", {dc:"absreason"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Absence reasons"}).end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI", net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI);   
