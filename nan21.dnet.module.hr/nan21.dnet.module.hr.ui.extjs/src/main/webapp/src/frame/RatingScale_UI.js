Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/RatingScaleDs", "nan21.dnet.module.hr.ui.extjs/dc/RatingScale", "nan21.dnet.module.hr.ui.extjs/ds/RatingLevelDs", "nan21.dnet.module.hr.ui.extjs/dc/RatingLevel"]);

Ext.ns("net.nan21.dnet.module.hr.skill.frame");
net.nan21.dnet.module.hr.skill.frame.RatingScale_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.skill.frame.RatingScale_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("scale", new net.nan21.dnet.module.hr.skill.dc.RatingScale())
		.addDc("level", new net.nan21.dnet.module.hr.skill.dc.RatingLevel({multiEdit:true}))		
		.linkDc("level", "scale",{fields:[ {childField:"ratingScaleId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("scale",{ name:"scaleFilter", xtype:"net.nan21.dnet.module.hr.skill.dc.RatingScale$Filter"})	 
		.addDcView("scale",{ name:"scaleList", xtype:"net.nan21.dnet.module.hr.skill.dc.RatingScale$List"})	 
		.addDcView("scale",{ name:"scaleEdit", xtype:"net.nan21.dnet.module.hr.skill.dc.RatingScale$Edit",height:120})	 
		.addDcView("level",{ name:"levelCtxEditList", xtype:"net.nan21.dnet.module.hr.skill.dc.RatingLevel$CtxEditList", frame:true,title:"Proficiency levels"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
			 	
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
			.beginToolbar("tlbScaleList", {dc:"scale"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbScaleEdit", {dc:"scale"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbLevelCtxEditList", {dc:"level"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.skill.frame.RatingScale_UI", net.nan21.dnet.module.hr.skill.frame.RatingScale_UI);   
