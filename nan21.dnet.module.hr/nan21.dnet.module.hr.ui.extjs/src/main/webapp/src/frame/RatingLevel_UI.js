Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/RatingLevelDs", "nan21.dnet.module.hr.ui.extjs/dc/RatingLevel","nan21.dnet.module.hr.ui.extjs/ds/RatingScaleLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingScales","nan21.dnet.module.hr.ui.extjs/ds/RatingScaleLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingScales"]);

Ext.define("net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.hr.skill.dc.RatingLevel({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("m",{ name:"mFilter", xtype:"net.nan21.dnet.module.hr.skill.dc.RatingLevel$Filter",height:120})	 
		.addDcView("m",{ name:"mEditList", xtype:"net.nan21.dnet.module.hr.skill.dc.RatingLevel$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["mFilter","mEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbMEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMEditList", {dc:"m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Rating levels"}).end(); 	
	}

});  
