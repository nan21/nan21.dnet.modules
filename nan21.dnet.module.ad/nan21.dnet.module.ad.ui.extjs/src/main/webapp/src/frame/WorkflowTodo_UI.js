Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/ActMyTaskDs", "nan21.dnet.module.ad.ui.extjs/dc/ActMyTask", "nan21.dnet.module.ad.ui.extjs/ds/ActAvailableTaskDs", "nan21.dnet.module.ad.ui.extjs/dc/ActAvailableTask", "nan21.dnet.module.ad.ui.extjs/ds/ActMyTaskHistoryDs", "nan21.dnet.module.ad.ui.extjs/dc/ActMyTaskHistory"]);

Ext.define("net.nan21.dnet.module.ad.workflow.frame.WorkflowTodo_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.workflow.frame.WorkflowTodo_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.workflow.frame.WorkflowTodo_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("dcMytask", new net.nan21.dnet.module.ad.workflow.dc.ActMyTask({}))
		.addDc("dcAvailabletask", new net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask({}))
		.addDc("dcMyhistory", new net.nan21.dnet.module.ad.workflow.dc.ActMyTaskHistory({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnCompleteTask",text:"Complete task", tooltip:"Mark selected task as completed.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnCompleteTask,scope:this,stateManager:{name:"selected_one", dc:"dcMytask" }	})	
							 	
		.addButton({name:"btnClaimTask",text:"Claim task", tooltip:"Claim the selected task.",disabled:true
			,handler: this.onBtnClaimTask,scope:this,stateManager:{name:"selected_one", dc:"dcAvailabletask" }	})	
							 	
		.addDcFilterFormView("dcMytask",{ name:"filterMytask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActMyTask$Filter",height:40})	 
		.addDcGridView("dcMytask",{ name:"listMytask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActMyTask$List",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnCompleteTask") ]}]})	 
		.addDcFilterFormView("dcAvailabletask",{ name:"filterAvailabletask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$Filter",height:40})	 
		.addDcGridView("dcAvailabletask",{ name:"listAvailabletask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$List",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnClaimTask") ]}]})	 
		.addDcFilterFormView("dcMyhistory",{ name:"filterMyhistory", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActMyTaskHistory$Filter",height:40})	 
		.addDcGridView("dcMyhistory",{ name:"listMyhistory", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActMyTaskHistory$List"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Current tasks",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Available tasks",preventHeader:true})  	 
		.addPanel({name: "canvas3", layout:"border", defaults:{split:true},title:"History",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvas1","canvas2","canvas3"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2","canvas3"]) 				 		
		.addChildrenTo("canvas1",["filterMytask","listMytask"] ,["north","center"])	
		.addChildrenTo("canvas2",["filterAvailabletask","listAvailabletask"] ,["north","center"])	
		.addChildrenTo("canvas3",["filterMyhistory","listMyhistory"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvas1","tlbMytaskList")	  	
	 	.addToolbarTo("canvas2","tlbAvailabletaskList")	  	
	 	.addToolbarTo("canvas3","tlbMyhistoryList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMytaskList", {dc:"dcMytask"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Current tasks"}).end()
			.beginToolbar("tlbAvailabletaskList", {dc:"dcAvailabletask"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Available tasks"}).end()
			.beginToolbar("tlbMyhistoryList", {dc:"dcMyhistory"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"History"}).end(); 	
	}


	,onBtnClaimTask: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 			this._getDc_("dcAvailabletask").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("dcAvailabletask").doService("assignTask", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
	,doCompleteTask: function(result) {	
		
		var rec = this._getDc_("dcMytask").getRecord() ;
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
	,onBtnCompleteTask: function() {	
		
		var taskId = this._getDc_("dcMytask").getRecord().data.id;
		Dnet.doWithGetResult(Dnet.wfTaskAPI(taskId).properties, null, this.doCompleteTask, this);
		
	}
});  
