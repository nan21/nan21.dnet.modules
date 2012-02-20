Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/PayScaleDs", "nan21.dnet.module.hr.ui.extjs/dc/PayScale", "nan21.dnet.module.hr.ui.extjs/ds/PayScalePointDs", "nan21.dnet.module.hr.ui.extjs/dc/PayScalePoint"]);

Ext.define("net.nan21.dnet.module.hr.grade.frame.PayScale_UI", {  
	extend: "dnet.core.ui.AbstractUi",
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
		.addDcFilterFormView("scale",{ name:"scaleFilter", xtype:"net.nan21.dnet.module.hr.grade.dc.PayScale$Filter",height:120})	 
		.addDcGridView("scale",{ name:"scaleList", xtype:"net.nan21.dnet.module.hr.grade.dc.PayScale$List"})	 
		.addDcFormView("scale",{ name:"scaleEdit", xtype:"net.nan21.dnet.module.hr.grade.dc.PayScale$Edit",height:120})	 
		.addDcEditGridView("point",{ name:"pointEditList", xtype:"net.nan21.dnet.module.hr.grade.dc.PayScalePoint$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
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
			.beginToolbar("tlbScaleList", {dc:"scale"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Pay scales"}).end()
			.beginToolbar("tlbScaleEdit", {dc:"scale"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Pay scale"}).end()
			.beginToolbar("tlbPointEditList", {dc:"point"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Progression points"}).end(); 	
	}

});  
