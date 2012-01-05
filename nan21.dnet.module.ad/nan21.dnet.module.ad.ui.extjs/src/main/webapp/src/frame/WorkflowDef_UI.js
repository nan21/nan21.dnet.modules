Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/WfDefProcessDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDefProcess", "nan21.dnet.module.ad.ui.extjs/ds/WfDefNodeDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDefNode", "nan21.dnet.module.ad.ui.extjs/ds/WfDefNodeFieldDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDefNodeField"]);

Ext.define("net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("dcProcess", new net.nan21.dnet.module.ad.workflow.dc.WfDefProcess({}))
		.addDc("dcNode", new net.nan21.dnet.module.ad.workflow.dc.WfDefNode({multiEdit:true}))
		.addDc("dcField", new net.nan21.dnet.module.ad.workflow.dc.WfDefNodeField({multiEdit:true}))		
		.linkDc("dcNode", "dcProcess",{fields:[ {childField:"processId", parentField:"id"} ]} )
		.linkDc("dcField", "dcNode",{fields:[ {childField:"nodeId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnDeploy",text:"Deploy", tooltip:"Deploy process",iconCls:"icon-action-run",disabled:true
			,handler: this.onBtnDeploy,scope:this,stateManager:{name:"record_status_is_edit", dc:"dcProcess" }	})	
							 	
		.addButton({name:"btnGetProcessDiagram",text:"Show diagram", tooltip:"Show diagram for this process definition",disabled:true
			,handler: this.onBtnGetProcessDiagram,scope:this,stateManager:{name:"record_status_is_edit", dc:"dcProcess" }	})	
							 	
		.addDcFilterFormView("dcProcess",{ name:"filterProcess", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefProcess$Filter",height:120})	 
		.addDcView("dcProcess",{ name:"listProcess", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefProcess$List"})	 
		.addDcFormView("dcProcess",{ name:"formProcess", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefProcess$Edit",height:150,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnDeploy") ,this._elems_.get("btnGetProcessDiagram") ]}]})	 
		.addDcView("dcNode",{ name:"elistNode", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefNode$CtxEditList", frame:true})	 
		.addDcView("dcField",{ name:"elistField", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefNodeField$CtxEditList", frame:true,width:500})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
		.addPanel({name: "panelDetails", layout:"border", defaults:{split:true}})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["filterProcess","listProcess"] ,["north","center"])	
		.addChildrenTo("canvas2",["formProcess","panelDetails"] ,["north","center"])	
		.addChildrenTo("panelDetails",["elistNode","elistField"] ,["center","east"])	
	 	.addToolbarTo("canvas1","tlbProcessList")	  	
	 	.addToolbarTo("canvas2","tlbProcessEdit")	  	
	 	.addToolbarTo("elistNode","tlbNodeCtxEditList")	  	
	 	.addToolbarTo("elistField","tlbTransitionEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProcessList", {dc:"dcProcess"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbProcessEdit", {dc:"dcProcess"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbNodeCtxEditList", {dc:"dcNode"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbTransitionEditList", {dc:"dcField"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end(); 	
	}


	,onBtnDeploy: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("dcProcess").doService("deployProcess", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
	,onBtnGetProcessDiagram: function() {	
		window.open(this._getDc_("dcProcess").doServiceUrl("getDiagram"),"ProcessDiagram","width=500,height=400");
	}
});  
