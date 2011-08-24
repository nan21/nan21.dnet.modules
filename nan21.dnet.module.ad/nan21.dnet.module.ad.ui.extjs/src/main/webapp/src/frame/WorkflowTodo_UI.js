Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/ActMyTaskDs", "nan21.dnet.module.ad.ui.extjs/dc/ActMyTask", "nan21.dnet.module.ad.ui.extjs/ds/ActAvailableTaskDs", "nan21.dnet.module.ad.ui.extjs/dc/ActAvailableTask", "nan21.dnet.module.ad.ui.extjs/ds/ActMyTaskHistoryDs", "nan21.dnet.module.ad.ui.extjs/dc/ActMyTaskHistory"]);

Ext.ns("net.nan21.dnet.module.ad.workflow.frame");
net.nan21.dnet.module.ad.workflow.frame.WorkflowTodo_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.workflow.frame.WorkflowTodo_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("dcMytask", new net.nan21.dnet.module.ad.workflow.dc.ActMyTask())
		.addDc("dcAvailabletask", new net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask())
		.addDc("dcMyhistory", new net.nan21.dnet.module.ad.workflow.dc.ActMyTaskHistory())		;		
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
            children: [{ text:"Current tasks", leaf: true , name:"canvas1"},{ text:"Available tasks", leaf: true , name:"canvas2"},{ text:"History", leaf: true , name:"canvas3"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		}); 
		this._getBuilder_()	
		.addButton({name:"btnCompleteTask",text:"Complete task", tooltip:"Mark selected task as completed.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnCompleteTask,scope:this,stateManager:{name:"selected_one", dc:"dcMytask" }	})	
							 	
		.addButton({name:"btnClaimTask",text:"Claim task", tooltip:"Claim the selected task.",disabled:true
			,handler: this.onBtnClaimTask,scope:this,stateManager:{name:"selected_one", dc:"dcAvailabletask" }	})	
							 	
		.addDcFilterFormView("dcMytask",{ name:"filterMytask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActMyTask$Filter",height:40})	 
		.addDcView("dcMytask",{ name:"listMytask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActMyTask$List",buttons:[ this._elems_.get("btnCompleteTask") ]})	 
		.addDcFilterFormView("dcAvailabletask",{ name:"filterAvailabletask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$Filter",height:40})	 
		.addDcView("dcAvailabletask",{ name:"listAvailabletask", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$List",buttons:[ this._elems_.get("btnClaimTask") ]})	 
		.addDcFilterFormView("dcMyhistory",{ name:"filterMyhistory", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActMyTaskHistory$Filter",height:40})	 
		.addDcView("dcMyhistory",{ name:"listMyhistory", xtype:"net.nan21.dnet.module.ad.workflow.dc.ActMyTaskHistory$List"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Current tasks",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Available tasks",header:false})  	 
		.addPanel({name: "canvas3", layout:"border", defaults:{split:true},title:"History",header:false})  	 
			 	
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
			.beginToolbar("tlbMytaskList", {dc:"dcMytask"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbAvailabletaskList", {dc:"dcAvailabletask"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbMyhistoryList", {dc:"dcMyhistory"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}


	,onBtnCompleteTask: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("dcMytask").doService("completeTask", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnClaimTask: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 	this._getDc_("dcAvailabletask").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("dcAvailabletask").doService("assignTask", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});
Ext.reg("net.nan21.dnet.module.ad.workflow.frame.WorkflowTodo_UI", net.nan21.dnet.module.ad.workflow.frame.WorkflowTodo_UI);   
