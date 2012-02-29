Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/RatingScaleDs", "nan21.dnet.module.hr.ui.extjs/dc/RatingScale", "nan21.dnet.module.hr.ui.extjs/ds/RatingLevelDs", "nan21.dnet.module.hr.ui.extjs/dc/RatingLevel"]);

Ext.define("net.nan21.dnet.module.hr.skill.frame.RatingScale_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.skill.frame.RatingScale_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.skill.frame.RatingScale_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("scale", new net.nan21.dnet.module.hr.skill.dc.RatingScale({}))
		.addDc("level", new net.nan21.dnet.module.hr.skill.dc.RatingLevel({multiEdit:true}))		
		.linkDc("level", "scale",{fields:[ {childField:"ratingScaleId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("scale",{ name:"scaleFilter", xtype:"net.nan21.dnet.module.hr.skill.dc.RatingScale$Filter",height:120})	 
		.addDcGridView("scale",{ name:"scaleList", xtype:"net.nan21.dnet.module.hr.skill.dc.RatingScale$List"})	 
		.addDcFormView("scale",{ name:"scaleEdit", xtype:"net.nan21.dnet.module.hr.skill.dc.RatingScale$Edit",height:120})	 
		.addDcEditGridView("level",{ name:"levelCtxEditList", xtype:"net.nan21.dnet.module.hr.skill.dc.RatingLevel$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["scaleFilter","scaleList"] ,["north","center"])	
		.addChildrenTo("canvas2",["scaleEdit","levelCtxEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbScaleList")	  	
	 	.addToolbarTo("canvas2","tlbScaleEdit")	  	
	 	.addToolbarTo("levelCtxEditList","tlbLevelCtxEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbScaleList", {dc:"scale"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Rating scales"}).end()
			.beginToolbar("tlbScaleEdit", {dc:"scale"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Rating scale"}).end()
			.beginToolbar("tlbLevelCtxEditList", {dc:"level"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Proficiency levels"}).end(); 	
	}

});  
