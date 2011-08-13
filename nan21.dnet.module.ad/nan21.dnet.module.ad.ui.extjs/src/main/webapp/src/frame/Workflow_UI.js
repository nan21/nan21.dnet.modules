Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/WfProcessDs", "nan21.dnet.module.ad.ui.extjs/dc/WfProcess", "nan21.dnet.module.ad.ui.extjs/ds/WfProcessInstanceRunningDs", "nan21.dnet.module.ad.ui.extjs/dc/WfProcessInstanceRunning", "nan21.dnet.module.ad.ui.extjs/ds/WfTaskInstanceDs", "nan21.dnet.module.ad.ui.extjs/dc/WfTaskInstance", "nan21.dnet.module.ad.ui.extjs/ds/WfProcessInstanceFinishedDs", "nan21.dnet.module.ad.ui.extjs/dc/WfProcessInstanceFinished", "nan21.dnet.module.ad.ui.extjs/ds/WfTaskInstanceDs", "nan21.dnet.module.ad.ui.extjs/dc/WfTaskInstance", "nan21.dnet.module.ad.ui.extjs/ds/WfDeploymentDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDeployment","nan21.dnet.module.ad.ui.extjs/ds/WfDeploymentDs","nan21.dnet.module.ad.ui.extjs/lov/WfDeployments","nan21.dnet.module.ad.ui.extjs/ds/WfProcessLovDs","nan21.dnet.module.ad.ui.extjs/lov/WfProcesses","nan21.dnet.module.ad.ui.extjs/ds/WfProcessLovDs","nan21.dnet.module.ad.ui.extjs/lov/WfProcesses"









]);

Ext.ns("net.nan21.dnet.module.ad.workflow.frame");
net.nan21.dnet.module.ad.workflow.frame.Workflow_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.workflow.frame.Workflow_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("dcProcess", new net.nan21.dnet.module.ad.workflow.dc.WfProcess())
		.addDc("dcRunningInstance", new net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning())
		.addDc("dcRunningTask", new net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance())
		.addDc("dcFinishedInstance", new net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceFinished())
		.addDc("dcFinishedTask", new net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance())
		.addDc("dcDeployment", new net.nan21.dnet.module.ad.workflow.dc.WfDeployment())		
		.linkDc("dcRunningTask", "dcRunningInstance",{fields:[ {childField:"processInstanceId", parentField:"processInstanceId"} ]} )
		.linkDc("dcFinishedTask", "dcFinishedInstance",{fields:[ {childField:"processInstanceId", parentField:"processInstanceId"} ]} );		
	}	 

	,_defineElements_: function() {					
			
		this._mainViewName_  = "_main_with_toc_";
		this._getBuilder_()
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addPanel({ name:"_toc_",xtype: 'treepanel',collapsible: true, region:"west", title: 'Navigation',width: 250,autoScroll: true,split: true,rootVisible: false,loader: new Ext.tree.TreeLoader()
			,minWidth:150, maxWidth:500
			,root: new Ext.tree.AsyncTreeNode({expanded: true,
            children: [{ text:"Processes defined", leaf: true , name:"canvas1"},{ text:"Running instances", leaf: true , name:"canvas2"},{ text:"Finished instances", leaf: true , name:"canvas3"},{ text:"Deployments", leaf: true , name:"canvas4"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		}); 
		this._getBuilder_()	
		.addButton({name:"btnStartProcess",text:"Start Instance", tooltip:"Start an instance of the selected process",iconCls:"icon-gears",disabled:true
			,handler: this.onBtnStartProcess,scope:this,stateManager:{name:"selected_one", dc:"dcProcess"}	})	
							 	
		.addButton({name:"btnKillProcessInstance",text:"Kill Instance", tooltip:"Kill the selected process instance",iconCls:"icon-action-reset",disabled:true
			,handler: this.onBtnKillProcessInstance,scope:this,stateManager:{name:"selected_one", dc:"dcRunningInstance"}	})	
							 	
		.addButton({name:"btnSaveAssignTask",text:"Save", tooltip:"Save assignement. Leave field empty to un-assign it.",iconCls:"icon-action-save",disabled:true
			,handler: this.onBtnSaveAssignTask,scope:this,stateManager:{name:"record_is_dirty", dc:"dcRunningTask"}	})	
							 	
		.addButton({name:"btnCompleteTask",text:"Complete task", tooltip:"Mark selected task as completed.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnCompleteTask,scope:this,stateManager:{name:"selected_one", dc:"dcRunningTask"}	})	
							 	
		.addButton({name:"btnOpenAsignTaskWindow",text:"Assign task", tooltip:"(Re-)Assign the selected task.",disabled:true
			,handler: this.onBtnOpenAsignTaskWindow,scope:this,stateManager:{name:"selected_one", dc:"dcRunningTask"}	})	
							 	
		.addDcView("dcDeployment",{ name:"filterDeployment", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDeployment$Filter",height:65})	 
		.addDcView("dcDeployment",{ name:"listDeployment", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDeployment$List"})	 
		.addDcView("dcProcess",{ name:"filterProcess", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfProcess$Filter",height:65})	 
		.addDcView("dcProcess",{ name:"listProcess", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfProcess$List",buttons:[ this._elems_.get("btnStartProcess") ]})	 
		.addDcView("dcRunningInstance",{ name:"filterRunningInstance", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning$Filter",height:65})	 
		.addDcView("dcRunningInstance",{ name:"listRunningInstance", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning$List",buttons:[ this._elems_.get("btnKillProcessInstance") ,this._elems_.get("btnOpenAsignTaskWindow") ,this._elems_.get("btnCompleteTask") ]})	 
		.addDcView("dcRunningTask",{ name:"filterRunningTask", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$Filter"})	 
		.addDcView("dcRunningTask",{ name:"listRunningTask", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$List",height:150})	 
		.addDcView("dcRunningTask",{ name:"formRunningTaskAsgn", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$AssignForm"})	 
		.addDcView("dcFinishedInstance",{ name:"filterFinishedInstance", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceFinished$Filter",height:65})	 
		.addDcView("dcFinishedInstance",{ name:"listFinishedInstance", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceFinished$List"})	 
		.addDcView("dcFinishedTask",{ name:"filterFinishedTask", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$Filter"})	 
		.addDcView("dcFinishedTask",{ name:"listFinishedTask", xtype:"net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$List",height:150})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Processes defined",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Running instances",header:false})  	 
		.addPanel({name: "canvas3", layout:"border", defaults:{split:true},title:"Finished instances",header:false})  	 
		.addPanel({name: "canvas4", layout:"border", defaults:{split:true},title:"Deployments",header:false})  	 
		
		this._elems_.add("wdwAssignTask", { _window_:true, resizable:true, layout:"fit", id:Ext.id(), items:[this._elems_.get("formRunningTaskAsgn")]
,title:"Assign task",modal:true,width:300,height:100,buttons:[ this._elems_.get("btnSaveAssignTask") ]}); 	
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2","canvas3","canvas4"]) 				 		
		.addChildrenTo("canvas1",["filterProcess","listProcess"] ,["north","center"])	
		.addChildrenTo("canvas2",["filterRunningInstance","listRunningInstance","listRunningTask"] ,["north","center","south"])	
		.addChildrenTo("canvas3",["filterFinishedInstance","listFinishedInstance","listFinishedTask"] ,["north","center","south"])	
		.addChildrenTo("canvas4",["filterDeployment","listDeployment"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvas1","tlbProcessList")	  	
	 	.addToolbarTo("canvas2","tlbRunningInstanceList")	  	
	 	.addToolbarTo("canvas3","tlbFinishedInstanceList")	  	
	 	.addToolbarTo("canvas4","tlbDeploymentList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProcessList", {dc:"dcProcess"}).addQuery().end()
			.beginToolbar("tlbRunningInstanceList", {dc:"dcRunningInstance"}).addQuery().end()
			.beginToolbar("tlbFinishedInstanceList", {dc:"dcFinishedInstance"}).addQuery().end()
			.beginToolbar("tlbDeploymentList", {dc:"dcDeployment"}).addQuery().end(); 	
	}


	,onBtnStartProcess: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("dcProcess").doService("serviceStartProcess", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnKillProcessInstance: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 	this._getDc_("dcRunningInstance").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("dcRunningInstance").doService("killProcessInstance", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnSaveAssignTask: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 	this._getWindow_("wdwAssignTask").close();			 	
;	this._getDc_("dcRunningTask").discardChanges();			 	
;	this._getDc_("dcRunningTask").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("dcRunningTask").doService("assignTask", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnCompleteTask: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 	this._getDc_("dcRunningTask").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("dcRunningTask").doService("completeTask", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnOpenAsignTaskWindow: function() {
this._getWindow_("wdwAssignTask").show();			 	
	}					 	
	,startProcessa: function() {	
this._getDc_("dcDeployment").doQuery();			 	
	}
});
Ext.reg("net.nan21.dnet.module.ad.workflow.frame.Workflow_UI", net.nan21.dnet.module.ad.workflow.frame.Workflow_UI);   
