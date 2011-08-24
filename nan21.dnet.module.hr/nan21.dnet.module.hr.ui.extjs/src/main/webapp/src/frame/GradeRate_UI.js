Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/GradeRateDs", "nan21.dnet.module.hr.ui.extjs/dc/GradeRate", "nan21.dnet.module.hr.ui.extjs/ds/GradeRateValueDs", "nan21.dnet.module.hr.ui.extjs/dc/GradeRateValue","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.hr.ui.extjs/ds/GradeLovDs","nan21.dnet.module.hr.ui.extjs/lov/Grades"]);

Ext.ns("net.nan21.dnet.module.hr.grade.frame");
net.nan21.dnet.module.hr.grade.frame.GradeRate_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.grade.frame.GradeRate_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("rate", new net.nan21.dnet.module.hr.grade.dc.GradeRate())
		.addDc("value", new net.nan21.dnet.module.hr.grade.dc.GradeRateValue({multiEdit:true}))		
		.linkDc("value", "rate",{fields:[ {childField:"gradeRateId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcFilterFormView("rate",{ name:"rateFilter", xtype:"net.nan21.dnet.module.hr.grade.dc.GradeRate$Filter"})	 
		.addDcView("rate",{ name:"rateList", xtype:"net.nan21.dnet.module.hr.grade.dc.GradeRate$List"})	 
		.addDcFormView("rate",{ name:"rateEdit", xtype:"net.nan21.dnet.module.hr.grade.dc.GradeRate$Edit",height:120})	 
		.addDcView("value",{ name:"valueEditList", xtype:"net.nan21.dnet.module.hr.grade.dc.GradeRateValue$CtxEditList4GradeRate", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["rateFilter","rateList"] ,["north","center"])	
		.addChildrenTo("canvas2",["rateEdit","valueEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbRateList")	  	
	 	.addToolbarTo("canvas2","tlbRateEdit")	  	
	 	.addToolbarTo("valueEditList","tlbValueEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbRateList", {dc:"rate"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbRateEdit", {dc:"rate"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbValueEditList", {dc:"value"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.grade.frame.GradeRate_UI", net.nan21.dnet.module.hr.grade.frame.GradeRate_UI);   
