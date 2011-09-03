Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/ActProcessDefinitionDs", "nan21.dnet.module.ad.ui.extjs/dc/ActProcessDefinition", "nan21.dnet.module.ad.ui.extjs/ds/ActProcessInstanceDs", "nan21.dnet.module.ad.ui.extjs/dc/ActProcessInstance", "nan21.dnet.module.ad.ui.extjs/ds/ActTaskInstanceDs", "nan21.dnet.module.ad.ui.extjs/dc/ActTaskInstance", "nan21.dnet.module.ad.ui.extjs/ds/ActProcessInstanceHistoryDs", "nan21.dnet.module.ad.ui.extjs/dc/ActProcessInstanceHistory", "nan21.dnet.module.ad.ui.extjs/ds/ActTaskInstanceHistoryDs", "nan21.dnet.module.ad.ui.extjs/dc/ActTaskInstanceHistory", "nan21.dnet.module.ad.ui.extjs/ds/ActDeploymentDs", "nan21.dnet.module.ad.ui.extjs/dc/ActDeployment","nan21.dnet.module.ad.ui.extjs/ds/ActDeploymentLovDs","nan21.dnet.module.ad.ui.extjs/lov/ActDeployments","nan21.dnet.module.ad.ui.extjs/ds/ActProcessDefinitionLovDs","nan21.dnet.module.ad.ui.extjs/lov/ActProcessDefinitions","nan21.dnet.module.ad.ui.extjs/ds/ActProcessDefinitionLovDs","nan21.dnet.module.ad.ui.extjs/lov/ActProcessDefinitions"]);

Ext.ns("net.nan21.dnet.module.ad.workflow.frame");
net.nan21.dnet.module.ad.workflow.frame.WorkflowAdmin_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.workflow.frame.WorkflowAdmin_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("dcProcess", new net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition())
		.addDc("dcRunningInstance", new net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance())
		.addDc("dcRunningTask", new net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance())
		.addDc("dcFinishedInstance", new net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory())
		.addDc("dcFinishedTask", new net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory())
		.addDc("dcDeployment", new net.nan21.dnet.module.ad.workflow.dc.ActDeployment())		
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
			,handler: this.startProcessInstance,scope:this,stateManager:{name:"selected_one", dc:"dcProcess" }	})	
							 	
		.addButton({name:"btnGetProcessDefinitionDiagram",text:"Show diagram", tooltip:"Show diagram for the selected process definition",disabled:true
			,handler: this.onBtnGetProcessDefinitionDiagram,scope:this,stateManager:{name:"selected_one", dc:"dcProcess" }	})	
							 	
		.addButton({name:"btnGetProcessInstanceDiagram",text:"Show diagram", tooltip:"Show diagram for the selected process instance",disabled:true
			,handler: this.onBtnGetProcessInstanceDiagram,scope:this,stateManager:{name:"selected_one", dc:"dcRunningInstance" }	})	
							 	
		.addButton({name:"btnKillProcessInstance",text:"Kill Instance", tooltip:"Kill the selected process instance",iconCls:"icon-action-reset",disabled:true
			,handler: this.onBtnKillProcessInstance,scope:this,stateManager:{name:"selected_one", dc:"dcRunningInstance" }	})	
							 	
		.addButton({name:"btnSaveAssignTask",text:"Save", tooltip:"Save assignement. Leave field empty to un-assign it.",iconCls:"icon-action-save",disabled:true
			,handler: this.onBtnSaveAssignTask,scope:this,stateManager:{name:"record_is_dirty", dc:"dcRunningTask" , and: function(evnt) {return (!evnt.record.data.endTime);}}	})	
							 	
		.addButton({name:"btnCompleteTask",text:"Complete task", tooltip:"Mark selected task as completed.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnCompleteTask,scope:this,stateManager:{name:"selected_one", dc:"dcRunningTask" , and: function(evnt) {return (!evnt.dc.record.data.endTime);}}	})	
							 	
		.addButton({name:"btnOpenAsignTaskWindow",text:"Assign task", tooltip:"(Re-)Assign the selected task.",disabled:true
			,handler: this.onBtnOpenAsignTaskWindow,scope:this,stateManager:{name:"selected_one", dc:"dcRunningTask" , and: function(evnt) {return (!evnt.dc.record.data.endTime);}}	})	
							 	
		.addButton({name:"btnUploadForDeployment",text:"Upload...", tooltip:"Upload process definition archive to be deployed.",disabled:false
			,handler: this.onBtnUploadForDeployment,scope:this	})	
							 	
		.addButton({name:"btnDeleteDeployment",text:"Delete", tooltip:"Delete selected deployments.",disabled:true
			,handler: this.onBtnDeleteDeployment,scope:this,stateManager:{name:"selected_not_zero", dc:"dcDeployment" }	})	
							 	
		.addButton({name:"btnDeleteCascadeDeployment",text:"Delete cascade", tooltip:"Delete selected deployments with dependecies.",disabled:true
			,handler: this.onBtnDeleteCascadeDeployment,scope:this,stateManager:{name:"selected_not_zero", dc:"dcDeployment" }	})	
							 	
		.addDcFilterFormView("dcDeployment",{ name:"filterDeployment", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActDeployment$Filter",height:65})	 
		.addDcView("dcDeployment",{ name:"listDeployment", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActDeployment$List",buttons:[ this._elems_.get("btnUploadForDeployment") ,this._elems_.get("btnDeleteDeployment") ,this._elems_.get("btnDeleteCascadeDeployment") ]})	 
		.addDcFilterFormView("dcProcess",{ name:"filterProcess", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition$Filter",height:65})	 
		.addDcView("dcProcess",{ name:"listProcess", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition$List",buttons:[ this._elems_.get("btnStartProcess") ,this._elems_.get("btnGetProcessDefinitionDiagram") ]})	 
		.addDcFilterFormView("dcRunningInstance",{ name:"filterRunningInstance", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance$Filter",height:65})	 
		.addDcView("dcRunningInstance",{ name:"listRunningInstance", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance$List",buttons:[ this._elems_.get("btnKillProcessInstance") ,this._elems_.get("btnGetProcessInstanceDiagram") ,this._elems_.get("btnOpenAsignTaskWindow") ,this._elems_.get("btnCompleteTask") ]})	 
		.addDcFilterFormView("dcRunningTask",{ name:"filterRunningTask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$Filter",height:30})	 
		.addDcView("dcRunningTask",{ name:"listRunningTask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$List"})	 
		.addDcFormView("dcRunningTask",{ name:"formRunningTaskAsgn", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$AssignForm"})	 
		.addDcFilterFormView("dcFinishedInstance",{ name:"filterFinishedInstance", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory$Filter",height:65})	 
		.addDcView("dcFinishedInstance",{ name:"listFinishedInstance", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory$List"})	 
		.addDcView("dcFinishedTask",{ name:"listFinishedTask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$List",height:180})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Processes defined",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Running instances",header:false})  	 
		.addPanel({name: "panelRunningTask", layout:"border", defaults:{split:true},height:220})  	 
		.addPanel({name: "canvas3", layout:"border", defaults:{split:true},title:"Finished instances",header:false})  	 
		.addPanel({name: "canvas4", layout:"border", defaults:{split:true},title:"Deployments",header:false})  	 
		
		this._elems_.add("wdwAssignTask", { _window_:true, resizable:true, layout:"fit", id:Ext.id(), items:[this._elems_.get("formRunningTaskAsgn")]
,title:"Assign task",modal:true,width:300,height:100,buttons:[ this._elems_.get("btnSaveAssignTask") ]}); 	
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2","canvas3","canvas4"]) 				 		
		.addChildrenTo("canvas1",["filterProcess","listProcess"] ,["north","center"])	
		.addChildrenTo("canvas2",["filterRunningInstance","listRunningInstance","panelRunningTask"] ,["north","center","south"])	
		.addChildrenTo("panelRunningTask",["filterRunningTask","listRunningTask"] ,["north","center"])	
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

	,onBtnOpenAsignTaskWindow: function() {
this._getWindow_("wdwAssignTask").show();			 	
	}					 	
	,startProcess: function() {	
this._getDc_("dcDeployment").doQuery();			 	
	}
	,startProcessInstanceNoForm: function() {	
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("dcProcess").doService("serviceStartProcess", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	,startProcessInstanceWithForm: function() {	
		
		dnet.base.WorkflowFormFactory.createStartForm(this._getDc_("dcProcess").getRecord().data.id );
	}
	,onBtnCompleteTask: function() {	
		
		dnet.base.WorkflowFormFactory.createTaskForm(this._getDc_("dcRunningTask").getRecord().data.id ); 
	}
	,startProcessInstance: function() {	
		var p=this._getDc_("dcProcess").getRecord().data; 
			if(p.hasStartForm) {
				this.startProcessInstanceWithForm();
			} else {
				this.startProcessInstanceNoForm();
			}
	}
	,onBtnGetProcessDefinitionDiagram: function() {	
		
		var id = this._getDc_("dcProcess").getRecord().get("id");
		window.open(Dnet.wfProcessDefinitionAPI(id).diagram,"ProcessDiagram","width=500,height=400");
	}
	,onBtnGetProcessInstanceDiagram: function() {	
		
		var id = this._getDc_("dcRunningInstance").getRecord().get("id");
		window.open(Dnet.wfProcessInstanceAPI(id).diagram,"ProcessDiagram","width=500,height=400");
	}
	,onBtnUploadForDeployment: function() {	
		var w=new dnet.base.FileUploadWindow();w.show();
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
Ext.reg("net.nan21.dnet.module.ad.workflow.frame.WorkflowAdmin_UI", net.nan21.dnet.module.ad.workflow.frame.WorkflowAdmin_UI);   