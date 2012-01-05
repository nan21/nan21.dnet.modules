Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/AssignableTypeDs", "nan21.dnet.module.ad.ui.extjs/dc/AssignableType", "nan21.dnet.module.ad.ui.extjs/ds/AssignableDs", "nan21.dnet.module.ad.ui.extjs/dc/Assignable","nan21.dnet.module.ad.ui.extjs/ds/AssignableTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AssignableTypes","nan21.dnet.module.ad.ui.extjs/ds/AssignableTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AssignableTypes"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.Assignables_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.usr.frame.Assignables_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.Assignables_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("assignableType", new net.nan21.dnet.module.ad.usr.dc.AssignableType({multiEdit:true}))
		.addDc("assignable", new net.nan21.dnet.module.ad.usr.dc.Assignable({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("assignableType",{ name:"assignableTypeFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.AssignableType$Filter",height:120})	 
		.addDcView("assignableType",{ name:"assignableTypeEditList", xtype:"net.nan21.dnet.module.ad.usr.dc.AssignableType$EditList", frame:true})	 
		.addDcFilterFormView("assignable",{ name:"assignableFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.Assignable$Filter",height:120})	 
		.addDcView("assignable",{ name:"assignableEditList", xtype:"net.nan21.dnet.module.ad.usr.dc.Assignable$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasType", layout:"border", defaults:{split:true},title:"Assignable types",preventHeader:true})  	 
		.addPanel({name: "canvasResource", layout:"border", defaults:{split:true},title:"Assignable resources",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasType","canvasResource"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasType","canvasResource"]) 				 		
		.addChildrenTo("canvasType",["assignableTypeFilter","assignableTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasResource",["assignableFilter","assignableEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasType","tlbAssignableTypeEditList")	  	
	 	.addToolbarTo("canvasResource","tlbAssignableEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAssignableTypeEditList", {dc:"assignableType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Assignable types"}).end()
			.beginToolbar("tlbAssignableEditList", {dc:"assignable"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Assignable resources"}).end(); 	
	}

});  
