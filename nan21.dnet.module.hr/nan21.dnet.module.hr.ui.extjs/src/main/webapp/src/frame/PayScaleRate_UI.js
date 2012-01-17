Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/PayScaleRateDs", "nan21.dnet.module.hr.ui.extjs/dc/PayScaleRate", "nan21.dnet.module.hr.ui.extjs/ds/PayScaleRateValueDs", "nan21.dnet.module.hr.ui.extjs/dc/PayScaleRateValue","nan21.dnet.module.hr.ui.extjs/ds/PayScaleLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayScales","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.hr.ui.extjs/ds/PayScaleLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayScales","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.hr.ui.extjs/ds/PayScalePointLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayScalePoints"]);

Ext.define("net.nan21.dnet.module.hr.grade.frame.PayScaleRate_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.grade.frame.PayScaleRate_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.grade.frame.PayScaleRate_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("srate", new net.nan21.dnet.module.hr.grade.dc.PayScaleRate({}))
		.addDc("value", new net.nan21.dnet.module.hr.grade.dc.PayScaleRateValue({multiEdit:true}))		
		.linkDc("value", "srate",{fields:[ {childField:"scaleRateId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("srate",{ name:"srateFilter", xtype:"net.nan21.dnet.module.hr.grade.dc.PayScaleRate$Filter",height:120})	 
		.addDcView("srate",{ name:"srateList", xtype:"net.nan21.dnet.module.hr.grade.dc.PayScaleRate$List"})	 
		.addDcFormView("srate",{ name:"srateEdit", xtype:"net.nan21.dnet.module.hr.grade.dc.PayScaleRate$Edit",height:120})	 
		.addDcView("value",{ name:"valueEditList", xtype:"net.nan21.dnet.module.hr.grade.dc.PayScaleRateValue$CtxEditList", frame:true,title:"Progression point rates"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["srateFilter","srateList"] ,["north","center"])	
		.addChildrenTo("canvas2",["srateEdit","valueEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbSrateList")	  	
	 	.addToolbarTo("canvas2","tlbSrateEdit")	  	
	 	.addToolbarTo("valueEditList","tlbSalueEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSrateList", {dc:"srate"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbSrateEdit", {dc:"srate"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbSalueEditList", {dc:"value"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Progression point rates"}).end(); 	
	}

});  
