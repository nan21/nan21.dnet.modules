Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/PayScaleDs", "nan21.dnet.module.hr.ui.extjs/dc/PayScale", "nan21.dnet.module.hr.ui.extjs/ds/PayScalePointDs", "nan21.dnet.module.hr.ui.extjs/dc/PayScalePoint"]);

Ext.define("net.nan21.dnet.module.hr.grade.frame.PayScale_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.grade.frame.PayScale_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.grade.frame.PayScale_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("scale", new net.nan21.dnet.module.hr.grade.dc.PayScale({}))
		.addDc("point", new net.nan21.dnet.module.hr.grade.dc.PayScalePoint({multiEdit:true}))		
		.linkDc("point", "scale",{fields:[ {childField:"payScaleId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("scale",{ name:"scaleFilter", xtype:"net.nan21.dnet.module.hr.grade.dc.PayScale$Filter",height:40})	 
		.addDcView("scale",{ name:"scaleList", xtype:"net.nan21.dnet.module.hr.grade.dc.PayScale$List"})	 
		.addDcFormView("scale",{ name:"scaleEdit", xtype:"net.nan21.dnet.module.hr.grade.dc.PayScale$Edit",height:120})	 
		.addDcView("point",{ name:"pointEditList", xtype:"net.nan21.dnet.module.hr.grade.dc.PayScalePoint$CtxEditList", frame:true,title:"Progression points"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["scaleFilter","scaleList"] ,["north","center"])	
		.addChildrenTo("canvas2",["scaleEdit","pointEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbScaleList")	  	
	 	.addToolbarTo("canvas2","tlbScaleEdit")	  	
	 	.addToolbarTo("pointEditList","tlbPointEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbScaleList", {dc:"scale"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbScaleEdit", {dc:"scale"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbPointEditList", {dc:"point"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Progression points"}).end(); 	
	}

});  
