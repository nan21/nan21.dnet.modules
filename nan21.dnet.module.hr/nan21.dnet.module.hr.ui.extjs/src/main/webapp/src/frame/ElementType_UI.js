Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/ElementCategoryDs", "nan21.dnet.module.hr.ui.extjs/dc/ElementCategory", "nan21.dnet.module.hr.ui.extjs/ds/ElementTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/ElementType","nan21.dnet.module.hr.ui.extjs/ds/ElementCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/ElementCategories","nan21.dnet.module.hr.ui.extjs/ds/ElementCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/ElementCategories"]);

Ext.ns("net.nan21.dnet.module.hr.payroll.frame");
net.nan21.dnet.module.hr.payroll.frame.ElementType_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.ElementType_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("ecateg", new net.nan21.dnet.module.hr.payroll.dc.ElementCategory({multiEdit:true}))
		.addDc("etype", new net.nan21.dnet.module.hr.payroll.dc.ElementType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("ecateg",{ name:"ecategFilter", xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementCategory$Filter",height:40})	 
		.addDcView("ecateg",{ name:"ecategEditList", xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementCategory$EditList", frame:true})	 
		.addDcFilterFormView("etype",{ name:"etypeFilter", xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementType$Filter",height:60})	 
		.addDcView("etype",{ name:"etypeEditList", xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCateg", layout:"border", defaults:{split:true},title:"Element categories",header:false})  	 
		.addPanel({name: "canvasType", layout:"border", defaults:{split:true},title:"Element types",header:false})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasCateg","canvasType"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasCateg","canvasType"]) 				 		
		.addChildrenTo("canvasCateg",["ecategFilter","ecategEditList"] ,["north","center"])	
		.addChildrenTo("canvasType",["etypeFilter","etypeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCateg","tlbEcategEditList")	  	
	 	.addToolbarTo("canvasType","tlbEtypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbEcategEditList", {dc:"ecateg"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Element categories"}).end()
			.beginToolbar("tlbEtypeEditList", {dc:"etype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Element types"}).end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.payroll.frame.ElementType_UI", net.nan21.dnet.module.hr.payroll.frame.ElementType_UI);   
