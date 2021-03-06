Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/ActProcessDefinitionDs", "nan21.dnet.module.ad.ui.extjs/dc/ActProcessDefinition", "nan21.dnet.module.ad.ui.extjs/ds/ActProcessInstanceDs", "nan21.dnet.module.ad.ui.extjs/dc/ActProcessInstance", "nan21.dnet.module.ad.ui.extjs/ds/ActTaskInstanceDs", "nan21.dnet.module.ad.ui.extjs/dc/ActTaskInstance", "nan21.dnet.module.ad.ui.extjs/ds/ActProcessInstanceHistoryDs", "nan21.dnet.module.ad.ui.extjs/dc/ActProcessInstanceHistory", "nan21.dnet.module.ad.ui.extjs/ds/ActTaskInstanceHistoryDs", "nan21.dnet.module.ad.ui.extjs/dc/ActTaskInstanceHistory", "nan21.dnet.module.ad.ui.extjs/ds/ActVariableDs", "nan21.dnet.module.ad.ui.extjs/dc/ActVariable", "nan21.dnet.module.ad.ui.extjs/ds/ActDeploymentDs", "nan21.dnet.module.ad.ui.extjs/dc/ActDeployment","nan21.dnet.module.ad.ui.extjs/ds/ActDeploymentLovDs","nan21.dnet.module.ad.ui.extjs/lov/ActDeployments","nan21.dnet.module.ad.ui.extjs/ds/ActProcessDefinitionLovDs","nan21.dnet.module.ad.ui.extjs/lov/ActProcessDefinitions","nan21.dnet.module.ad.ui.extjs/ds/ActProcessDefinitionLovDs","nan21.dnet.module.ad.ui.extjs/lov/ActProcessDefinitions"]);

Ext.define("net.nan21.dnet.module.ad.workflow.frame.WorkflowAdmin_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.workflow.frame.WorkflowAdmin_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.workflow.frame.WorkflowAdmin_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("dcProcess", new net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition({}))
		.addDc("dcRunningInstance", new net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance({}))
		.addDc("dcRunningTask", new net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance({}))
		.addDc("dcFinishedInstance", new net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory({}))
		.addDc("dcFinishedTask", new net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory({}))
		.addDc("dcVar", new net.nan21.dnet.module.ad.workflow.dc.ActVariable({}))
		.addDc("dcDeployment", new net.nan21.dnet.module.ad.workflow.dc.ActDeployment({}))		
		.linkDc("dcRunningTask", "dcRunningInstance",{fetchMode:"auto",fields:[ {childField:"processInstanceId", parentField:"processInstanceId"} ]} )
		.linkDc("dcFinishedTask", "dcFinishedInstance",{fetchMode:"auto",fields:[ {childField:"processInstanceId", parentField:"processInstanceId"} ]} )
		.linkDc("dcVar", "dcRunningInstance",{fetchMode:"auto",fields:[ {childField:"processInstanceId", parentField:"processInstanceId"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnStartProcess",text:"Start Instance", tooltip:"Start an instance of the selected process",iconCls:"icon-gears",disabled:true
			,handler: this.onBtnStartProcess,scope:this,stateManager:{name:"selected_one", dc:"dcProcess" }	})	
							 	
		.addButton({name:"btnGetProcessDefinitionDiagram",text:"Show diagram", tooltip:"Show diagram for the selected process definition",disabled:true
			,handler: this.onBtnGetProcessDefinitionDiagram,scope:this,stateManager:{name:"selected_one", dc:"dcProcess" }	})	
							 	
		.addButton({name:"btnGetProcessDefinitionXml",text:"Show XML", tooltip:"Show xml for the selected process definition",disabled:true
			,handler: this.onBtnGetProcessDefinitionXml,scope:this,stateManager:{name:"selected_one", dc:"dcProcess" }	})	
							 	
		.addButton({name:"btnGetProcessInstanceXml",text:"Show XML", tooltip:"Show xml for the selected process.",disabled:true
			,handler: this.onBtnGetProcessInstanceXml,scope:this,stateManager:{name:"selected_one", dc:"dcRunningInstance" }	})	
							 	
		.addButton({name:"btnGetProcessInstanceDiagram",text:"Show diagram", tooltip:"Show diagram for the selected process instance",disabled:true
			,handler: this.onBtnGetProcessInstanceDiagram,scope:this,stateManager:{name:"selected_one", dc:"dcRunningInstance" }	})	
							 	
		.addButton({name:"btnKillProcessInstance",text:"Kill Instance", tooltip:"Kill the selected process instance",iconCls:"icon-action-reset",disabled:true
			,handler: this.onBtnKillProcessInstance,scope:this,stateManager:{name:"selected_one", dc:"dcRunningInstance" }	})	
							 	
		.addButton({name:"btnSaveAssignTask",text:"Save", tooltip:"Save assignement. Leave field empty to un-assign it.",iconCls:"icon-action-save",disabled:true
			,handler: this.onBtnSaveAssignTask,scope:this,stateManager:{name:"record_is_dirty", dc:"dcRunningTask" , and: function(dc) {return (!dc.record.data.endTime);}}	})	
							 	
		.addButton({name:"btnCompleteTask",text:"Complete task", tooltip:"Mark selected task as completed.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnCompleteTask,scope:this,stateManager:{name:"selected_one", dc:"dcRunningTask" , and: function(dc) {return (!dc.record.data.endTime);}}	})	
							 	
		.addButton({name:"btnOpenAsignTaskWindow",text:"Assign task", tooltip:"(Re-)Assign the selected task.",disabled:true
			,handler: this.onBtnOpenAsignTaskWindow,scope:this,stateManager:{name:"selected_one", dc:"dcRunningTask" , and: function(dc) {return (!dc.record.data.endTime);}}	})	
							 	
		.addButton({name:"btnUploadForDeployment",text:"Upload...", tooltip:"Upload process definition archive to be deployed.",disabled:false
			,handler: this.onBtnUploadForDeployment,scope:this	})	
							 	
		.addButton({name:"btnDeleteDeployment",text:"Delete", tooltip:"Delete selected deployments.",disabled:true
			,handler: this.onBtnDeleteDeployment,scope:this,stateManager:{name:"selected_not_zero", dc:"dcDeployment" }	})	
							 	
		.addButton({name:"btnDeleteCascadeDeployment",text:"Delete cascade", tooltip:"Delete selected deployments with dependecies.",disabled:true
			,handler: this.onBtnDeleteCascadeDeployment,scope:this,stateManager:{name:"selected_not_zero", dc:"dcDeployment" }	})	
							 	
		.addDcFilterFormView("dcDeployment",{ name:"filterDeployment", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActDeployment$Filter",height:80})	 
		.addDcGridView("dcDeployment",{ name:"listDeployment", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActDeployment$List",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnUploadForDeployment") ,this._elems_.get("btnDeleteDeployment") ,this._elems_.get("btnDeleteCascadeDeployment") ]}]})	 
		.addDcFilterFormView("dcProcess",{ name:"filterProcess", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition$Filter",height:80})	 
		.addDcGridView("dcProcess",{ name:"listProcess", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition$List",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnStartProcess") ,this._elems_.get("btnGetProcessDefinitionDiagram") ,this._elems_.get("btnGetProcessDefinitionXml") ]}]})	 
		.addDcFilterFormView("dcRunningInstance",{ name:"filterRunningInstance", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance$Filter",height:80})	 
		.addDcGridView("dcRunningInstance",{ name:"listRunningInstance", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance$List",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'right', weight:-1, items:[ this._elems_.get("btnKillProcessInstance") ,this._elems_.get("btnGetProcessInstanceDiagram") ,this._elems_.get("btnGetProcessInstanceXml") ]}]})	 
		.addDcGridView("dcVar",{ name:"listVars", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActVariable$List",title:"Variables"})	 
		.addDcFilterFormView("dcRunningTask",{ name:"filterRunningTask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$Filter",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'right', weight:-1, items:[ this._elems_.get("btnOpenAsignTaskWindow") ,this._elems_.get("btnCompleteTask") ]}]})	 
		.addDcGridView("dcRunningTask",{ name:"listRunningTask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$List"})	 
		.addDcFormView("dcRunningTask",{ name:"formRunningTaskAsgn", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$AssignForm"})	 
		.addDcFilterFormView("dcFinishedInstance",{ name:"filterFinishedInstance", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory$Filter",height:80})	 
		.addDcGridView("dcFinishedInstance",{ name:"listFinishedInstance", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory$List"})	 
		.addDcGridView("dcFinishedTask",{ name:"listFinishedTask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$List",height:180})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 

		.addPanel({name: "detailsTabRI", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false, id:Ext.id(),height:240}) 	 
		.addPanel({name: "canvasProcess", layout:"border", defaults:{split:true},title:"Processes defined",preventHeader:true})  	 
		.addPanel({name: "canvasRunningInstance", layout:"border", defaults:{split:true},title:"Running instances",preventHeader:true})  	 
		.addPanel({name: "panelRunningTask", layout:"border", defaults:{split:true},title:"Tasks"})  	 
		.addPanel({name: "canvasFinishedInstance", layout:"border", defaults:{split:true},title:"Finished instances",preventHeader:true})  	 
		.addPanel({name: "canvasDeployment", layout:"border", defaults:{split:true},title:"Deployments",preventHeader:true})  	 
		
		.addWindow({name:"wdwAssignTask", closeAction:'hide', resizable:true, layout:"fit", items:[this._elems_.get("formRunningTaskAsgn")]
,title:"Assign task",modal:true,width:300,height:100,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnSaveAssignTask") ]}}) 	
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasProcess","canvasRunningInstance","canvasFinishedInstance","canvasDeployment"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasProcess","canvasRunningInstance","canvasFinishedInstance","canvasDeployment"]) 				 		
		.addChildrenTo("canvasProcess",["filterProcess","listProcess"] ,["north","center"])	
		.addChildrenTo("canvasRunningInstance",["filterRunningInstance","listRunningInstance","detailsTabRI"] ,["north","center","south"])	
	 	.addChildrenTo("detailsTabRI", ["panelRunningTask","listVars"]) 				 		
		.addChildrenTo("panelRunningTask",["filterRunningTask","listRunningTask"] ,["east","center"])	
		.addChildrenTo("canvasFinishedInstance",["filterFinishedInstance","listFinishedInstance","listFinishedTask"] ,["north","center","south"])	
		.addChildrenTo("canvasDeployment",["filterDeployment","listDeployment"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasProcess","tlbProcessList")	  	
	 	.addToolbarTo("canvasRunningInstance","tlbRunningInstanceList")	  	
	 	.addToolbarTo("canvasFinishedInstance","tlbFinishedInstanceList")	  	
	 	.addToolbarTo("canvasDeployment","tlbDeploymentList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProcessList", {dc:"dcProcess"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Processes defined"}).end()
			.beginToolbar("tlbRunningInstanceList", {dc:"dcRunningInstance"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Running instances"}).end()
			.beginToolbar("tlbFinishedInstanceList", {dc:"dcFinishedInstance"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Finished instances"}).end()
			.beginToolbar("tlbDeploymentList", {dc:"dcDeployment"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Deployments"}).end(); 	
	}


	,onBtnKillProcessInstance: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 			this._getDc_("dcRunningInstance").doQuery();			 	
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
		var successFn = function(dc,response,serviceName,specs) { 			this._getWindow_("wdwAssignTask").close();			 	
;			this._getDc_("dcRunningTask").doCancel();			 	
;			this._getDc_("dcRunningTask").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		var failureFn = function(dc,response,serviceName,specs) { 			this._getDc_("dcRunningTask").doCancel();			 	
			}; 
		s.callbacks['failureFn'] = failureFn; 
		s.callbacks['failureScope'] = this;
		try{ 
			this._getDc_("dcRunningTask").doService("assignTask", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnOpenAsignTaskWindow: function() {
		this._getWindow_("wdwAssignTask").show();			 	
	}					 	
	,doStartProcessInstance: function(result) {	
		
		var rec = this._getDc_("dcProcess").getRecord() ;
		var processDefinitionId = result.processDefinitionId;
		if (!Ext.isEmpty(result.formKey)) { alert("Not implemented");
			//dnet.core.base.WorkflowFormFactory.createStartForm(this._getDc_("dcProcess").getRecord().data.id );
		} else if (result.properties.length > 0 ) {
			// read preperties and create for fields
			(new dnet.core.base.WfStartFormWindowExtjs({
				_formProperties_:result.properties,
				_processDefinitionId_:processDefinitionId, 
				title:rec.data.name })).show();	
		} else {
			Ext.Msg.wait("Working...");
			Dnet.doWithGetResult(Dnet.wfProcessInstanceAPI(null).start,
				{processDefinitionId:processDefinitionId}, 
				function(r) { 
					Ext.Msg.hide(); 
					Ext.Msg.alert("Success","Started process instance with ID: "+r.id);
				} );
		}
		
	}
	,doCompleteTask: function(result) {	
		
		var rec = this._getDc_("dcRunningTask").getRecord() ;
		var taskId = rec.data.id;
		
		if (!Ext.isEmpty(result.formKey)) {alert("Not implemented");
			//dnet.core.base.WorkflowFormFactory.createStartForm(this._getDc_("dcProcess").getRecord().data.id );
		} else if (result.properties.length > 0 ) {
			// read preperties and create for fields
			(new dnet.core.base.WfTaskFormWindowExtjs({
				_formProperties_:result.properties,
				_taskId_:taskId, 
				_taskName_:result.taskName,
				_taskDescription_:result.taskDescription,
				title:result.taskName })).show();	
		} else {
			Ext.Msg.wait("Working...");
			Dnet.doWithGetResult(Dnet.wfTaskAPI(taskId).complete,
				{taskId:taskId}, 
				function(r) { 
					Ext.Msg.hide(); 
					Ext.Msg.alert("Success","Task completed successfully.");
				} );
		}
		
	}
	,onBtnStartProcess: function() {	
		
			var procDefId = this._getDc_("dcProcess").getRecord().data.id;
			Dnet.doWithGetResult(Dnet.wfProcessDefinitionAPI(procDefId).properties, null, this.doStartProcessInstance, this);
		
	}
	,onBtnCompleteTask: function() {	
		
		var taskId = this._getDc_("dcRunningTask").getRecord().data.id;
		Dnet.doWithGetResult(Dnet.wfTaskAPI(taskId).properties, null, this.doCompleteTask, this);
		
	}
	,onBtnGetProcessDefinitionXml: function() {	
		
		var id = this._getDc_("dcProcess").getRecord().get("id");
		window.open(Dnet.wfProcessDefinitionAPI(id).xml,"ProcessDefinition","width=550,height=450,scrollbars=1,status=1");
	}
	,onBtnGetProcessInstanceXml: function() {	
		
		var id = this._getDc_("dcRunningInstance").getRecord().get("processId");
		window.open(Dnet.wfProcessDefinitionAPI(id).xml,"ProcessDefinition","width=550,height=450,scrollbars=1,status=1");
	}
	,onBtnGetProcessDefinitionDiagram: function() {	
		
		var id = this._getDc_("dcProcess").getRecord().get("id");
		window.open(Dnet.wfProcessDefinitionAPI(id).diagram,"ProcessDiagram","width=550,height=450,scrollbars=1,status=1");
	}
	,onBtnGetProcessInstanceDiagram: function() {	
		
		var id = this._getDc_("dcRunningInstance").getRecord().get("id");
		window.open(Dnet.wfProcessInstanceAPI(id).diagram,"ProcessDiagram","width=550,height=450,scrollbars=1,status=1");
	}
	,onBtnUploadForDeployment: function() {	
		var w=new dnet.core.base.FileUploadWindow({_uploadUrl_:"/nan21.dnet.core.web/upload/deployUploadedWorkflow"});w.show();
	}
	,onBtnDeleteDeployment: function() {	
		
		this.onDeleteDeploymentDelegate(false); 
	}
	,onBtnDeleteCascadeDeployment: function() {	
		
		this.onDeleteDeploymentDelegate(true);
	}
	,onDeleteDeploymentDelegate: function(cascade) {	
		
		var sel = this._getDc_("dcDeployment").getSelectedRecords(); 
		var ids = "";
		for(var i=0,len=sel.length; i<len; i++) {
			if (i>0) {ids+=",";}
			ids+=sel[i].data.id;
		}		
		Ext.Ajax.request({
			url: Dnet.wfDeploymentAPI().destroy, method:"POST", params: {ids: ids, cascade:cascade}
			,success :function() {this._getDc_("dcDeployment").doQuery();}
			//,failure: this.onAjaxRequestFailure	
			,scope: this			 
		});
	
	}
});  
