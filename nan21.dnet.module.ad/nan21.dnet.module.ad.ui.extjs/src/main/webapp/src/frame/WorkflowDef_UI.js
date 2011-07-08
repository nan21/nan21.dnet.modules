Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/WfDefProcessDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDefProcess", "nan21.dnet.module.ad.ui.extjs/ds/WfDefNodeDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDefNode", "nan21.dnet.module.ad.ui.extjs/ds/WfDefTransitionDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDefTransition","nan21.dnet.module.ad.ui.extjs/ds/WfDefNodeTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/WfDefNodeTypes"

]);

Ext.ns("net.nan21.dnet.module.ad.workflow.frame");
net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("dcProcess", new net.nan21.dnet.module.ad.workflow.dc.WfDefProcess())
		.addDc("dcNode", new net.nan21.dnet.module.ad.workflow.dc.WfDefNode({multiEdit:true}))
		.addDc("dcTransition", new net.nan21.dnet.module.ad.workflow.dc.WfDefTransition({multiEdit:true}))		
		.linkDc("dcNode", "dcProcess",{fields:[ {childField:"processId", parentField:"id"} ]} )
		.linkDc("dcTransition", "dcProcess",{fields:[ {childField:"processId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addButton({name:"btnDeploy",text:"Deploy", tooltip:"Deploy process",iconCls:"icon-action-run",disabled:true
			,handler: this.onBtnDeploy,scope:this,stateManager:{name:"record_status_is_edit", dc:"dcProcess"}	})	
							 	
		.addDcView("dcProcess",{ name:"filterProcess", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefProcess$Filter"})	 
		.addDcView("dcProcess",{ name:"listProcess", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefProcess$List"})	 
		.addDcView("dcProcess",{ name:"formProcess", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefProcess$Edit",height:100,buttons:[ this._elems_.get("btnDeploy") ]})	 
		.addDcView("dcNode",{ name:"elistNode", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefNode$CtxEditList", frame:true})	 
		.addDcView("dcTransition",{ name:"filterTransition", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefTransition$Filter"})	 
		.addDcView("dcTransition",{ name:"elistTransition", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefTransition$CtxEditList", frame:true,width:300})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
		.addPanel({name: "panelDetails", layout:"border", defaults:{split:true}})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["filterProcess","listProcess"] ,["north","center"])	
		.addChildrenTo("canvas2",["formProcess","panelDetails"] ,["north","center"])	
		.addChildrenTo("panelDetails",["elistNode","elistTransition"] ,["center","east"])	
	 	.addToolbarTo("canvas1","tlbProcessList")	  	
	 	.addToolbarTo("canvas2","tlbProcessEdit")	  	
	 	.addToolbarTo("elistNode","tlbNodeCtxEditList")	  	
	 	.addToolbarTo("elistTransition","tlbTransitionEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProcessList", {dc:"dcProcess"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbProcessEdit", {dc:"dcProcess"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbNodeCtxEditList", {dc:"dcNode"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbTransitionEditList", {dc:"dcTransition"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}


	,onBtnDeploy: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("dcProcess").doService("deployProcess", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});
Ext.reg("net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI", net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI);   
