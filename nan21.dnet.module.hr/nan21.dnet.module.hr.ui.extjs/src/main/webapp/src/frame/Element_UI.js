Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/ElementDs", "nan21.dnet.module.hr.ui.extjs/dc/Element", "nan21.dnet.module.hr.ui.extjs/ds/VariableDs", "nan21.dnet.module.hr.ui.extjs/dc/Variable","nan21.dnet.module.hr.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/ElementTypes","nan21.dnet.module.hr.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/ElementTypes","nan21.dnet.module.hr.ui.extjs/ds/ElementLovDs","nan21.dnet.module.hr.ui.extjs/lov/Elements"]);

Ext.ns("net.nan21.dnet.module.hr.payroll.frame");
net.nan21.dnet.module.hr.payroll.frame.Element_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.Element_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("expr", new net.nan21.dnet.module.hr.payroll.dc.Element())
		.addDc("vars", new net.nan21.dnet.module.hr.payroll.dc.Variable({multiEdit:true}))		
		.linkDc("vars", "expr",{fields:[ {childField:"elementId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("expr",{ name:"exprFilter", xtype:"net.nan21.dnet.module.hr.payroll.dc.Element$Filter"})	 
		.addDcView("expr",{ name:"exprList", xtype:"net.nan21.dnet.module.hr.payroll.dc.Element$List"})	 
		.addDcView("expr",{ name:"exprEdit", xtype:"net.nan21.dnet.module.hr.payroll.dc.Element$Edit",height:120})	 
		.addDcView("vars",{ name:"varEditList", xtype:"net.nan21.dnet.module.hr.payroll.dc.Variable$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["exprFilter","exprList"] ,["north","center"])	
		.addChildrenTo("canvas2",["exprEdit","varEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbExprList")	  	
	 	.addToolbarTo("canvas2","tlbExprEdit")	  	
	 	.addToolbarTo("varEditList","tlbVarEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbExprList", {dc:"expr"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbExprEdit", {dc:"expr"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbVarEditList", {dc:"vars"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.payroll.frame.Element_UI", net.nan21.dnet.module.hr.payroll.frame.Element_UI);   
