Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/RatingLevelDs", "nan21.dnet.module.hr.ui.extjs/dc/RatingLevel","nan21.dnet.module.hr.ui.extjs/ds/RatingScaleLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingScales","nan21.dnet.module.hr.ui.extjs/ds/RatingScaleLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingScales"]);

Ext.ns("net.nan21.dnet.module.hr.skill.frame");
net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.hr.skill.dc.RatingLevel({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("m",{ name:"mFilter", xtype:"net.nan21.dnet.module.hr.skill.dc.RatingLevel$Filter"})	 
		.addDcView("m",{ name:"mEditList", xtype:"net.nan21.dnet.module.hr.skill.dc.RatingLevel$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["mFilter","mEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbMEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMEditList", {dc:"m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
	}

});
Ext.reg("net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI", net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI);   
