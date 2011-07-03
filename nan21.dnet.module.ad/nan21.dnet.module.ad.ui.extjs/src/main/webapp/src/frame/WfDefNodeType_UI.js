Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/WfDefNodeTypeDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDefNodeType"]);

Ext.ns("net.nan21.dnet.module.ad.workflow.frame");
net.nan21.dnet.module.ad.workflow.frame.WfDefNodeType_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.workflow.frame.WfDefNodeType_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("dcNodeType", new net.nan21.dnet.module.ad.workflow.dc.WfDefNodeType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("dcNodeType",{ name:"filterNodeType", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefNodeType$Filter"})	 
		.addDcView("dcNodeType",{ name:"elistNodeType", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefNodeType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["filterNodeType","elistNodeType"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbNodeTypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbNodeTypeEditList", {dc:"dcNodeType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.ad.workflow.frame.WfDefNodeType_UI", net.nan21.dnet.module.ad.workflow.frame.WfDefNodeType_UI);   
