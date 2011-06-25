Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementDs", "nan21.dnet.module.hr.ui.extjs/dc/WorkRequirement","nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/WorkRequirementTypes","nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/WorkRequirementTypes"]);

Ext.ns("net.nan21.dnet.module.hr.job.frame");
net.nan21.dnet.module.hr.job.frame.WorkRequirement_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.job.frame.WorkRequirement_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.hr.job.dc.WorkRequirement({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("m",{ name:"mFilter", xtype:"net.nan21.dnet.module.hr.job.dc.WorkRequirement$Filter"})	 
		.addDcView("m",{ name:"mEditList", xtype:"net.nan21.dnet.module.hr.job.dc.WorkRequirement$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["mFilter","mEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlb")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlb", {dc:"m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
	}

});
Ext.reg("net.nan21.dnet.module.hr.job.frame.WorkRequirement_UI", net.nan21.dnet.module.hr.job.frame.WorkRequirement_UI);   
