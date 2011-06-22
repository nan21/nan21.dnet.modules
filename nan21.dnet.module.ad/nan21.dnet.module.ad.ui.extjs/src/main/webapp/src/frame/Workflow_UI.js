 
Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/WfProcessDs", "nan21.dnet.module.ad.ui.extjs/dc/WfProcess", "nan21.dnet.module.ad.ui.extjs/ds/WfProcessInstanceRunningDs", "nan21.dnet.module.ad.ui.extjs/dc/WfProcessInstanceRunning", "nan21.dnet.module.ad.ui.extjs/ds/WfTaskInstanceDs", "nan21.dnet.module.ad.ui.extjs/dc/WfTaskInstance", "nan21.dnet.module.ad.ui.extjs/ds/WfProcessInstanceFinishedDs", "nan21.dnet.module.ad.ui.extjs/dc/WfProcessInstanceFinished", "nan21.dnet.module.ad.ui.extjs/ds/WfTaskInstanceDs", "nan21.dnet.module.ad.ui.extjs/dc/WfTaskInstance", "nan21.dnet.module.ad.ui.extjs/ds/WfDeploymentDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDeployment","nan21.dnet.module.ad.ui.extjs/ds/WfDeploymentDs","nan21.dnet.module.ad.ui.extjs/lov/WfDeployments","nan21.dnet.module.ad.ui.extjs/ds/WfProcessLovDs","nan21.dnet.module.ad.ui.extjs/lov/WfProcesses","nan21.dnet.module.ad.ui.extjs/ds/WfProcessLovDs","nan21.dnet.module.ad.ui.extjs/lov/WfProcesses"]);

Ext.ns("net.nan21.dnet.module.ad.workflow.frame");
net.nan21.dnet.module.ad.workflow.frame.Workflow_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.workflow.frame.Workflow_UI"
	
	,_defineDcs_: function () {	
		var  dcProcess = new net.nan21.dnet.module.ad.workflow.dc.WfProcess({multiEdit:false}), dcRunningInstance = new net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning({multiEdit:false}), dcRunningTask = new net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance({multiEdit:false}), dcFinishedInstance = new net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceFinished({multiEdit:false}), dcFinishedTask = new net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance({multiEdit:false}), dcDeployment = new net.nan21.dnet.module.ad.workflow.dc.WfDeployment({multiEdit:false});	 	
		
		this._dcs_.add("dcProcess", dcProcess);			
		
		this._dcs_.add("dcRunningInstance", dcRunningInstance);			
		dcRunningTask.setDcContext(new dnet.base.DcContext({childDc:dcRunningTask, parentDc:dcRunningInstance, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"processInstanceId", parentField:"processInstanceId"} ]}}));dcRunningInstance.addChild(dcRunningTask);
		this._dcs_.add("dcRunningTask", dcRunningTask);			
		
		this._dcs_.add("dcFinishedInstance", dcFinishedInstance);			
		dcFinishedTask.setDcContext(new dnet.base.DcContext({childDc:dcFinishedTask, parentDc:dcFinishedInstance, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"processInstanceId", parentField:"processInstanceId"} ]}}));dcFinishedInstance.addChild(dcFinishedTask);
		this._dcs_.add("dcFinishedTask", dcFinishedTask);			
		
		this._dcs_.add("dcDeployment", dcDeployment);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
			
		this._mainViewName_  = "_main_with_toc_";
		this._elems_.add("_main_with_toc_", { layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		});
		this._elems_.add("_toc_", { xtype: 'treepanel',collapsible: true, title: 'Navigation',width: 250,autoScroll: true,split: true,rootVisible: false,loader: new Ext.tree.TreeLoader()
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
			this._elems_.add("btnStartProcess", { xtype:"button", name:"btnStartProcess", id:Ext.id(),iconCls:"icon-gears" 
					,text:"Start Instance", tooltip:"Start an instance of the selected process"
					,disabled:true
					,handler: function() {
					var s={modal:true, callbacks:{} };
							try{ this._getDc_("dcProcess").doService("serviceStartProcess", s); }catch(e){dnet.base.DcExceptions.showMessage(e);}

 
}					 	
 ,scope:this });	
			this._getDc_("dcProcess").on("selectionChanged", function(evnt) {
		 	       if ((evnt.dc.selectedRecords.length == 1) ) { var btn = this._getElement_("btnStartProcess"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnStartProcess");if(btn) btn.disable();  }
			 }, this );					 	
			this._elems_.add("btnKillProcessInstance", { xtype:"button", name:"btnKillProcessInstance", id:Ext.id(),iconCls:"icon-action-reset" 
					,text:"Kill Instance", tooltip:"Kill the selected process instance"
					,disabled:true
					,handler: function() {
					var s={modal:true, callbacks:{} };					var successFn = function(dc,response,serviceName,specs) {							 
this._getDc_("dcRunningInstance").doQuery();			 	

							 
							}; s.callbacks['successFn'] = successFn; s.callbacks['successScope'] = this;
							
							try{ this._getDc_("dcRunningInstance").doService("killProcessInstance", s); }catch(e){dnet.base.DcExceptions.showMessage(e);}

 
}					 	
 ,scope:this });	
			this._getDc_("dcRunningInstance").on("selectionChanged", function(evnt) {
		 	       if ((evnt.dc.selectedRecords.length == 1) ) { var btn = this._getElement_("btnKillProcessInstance"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnKillProcessInstance");if(btn) btn.disable();  }
			 }, this );					 	
			this._elems_.add("btnSaveAssignTask", { xtype:"button", name:"btnSaveAssignTask", id:Ext.id(),iconCls:"icon-action-save" 
					,text:"Save", tooltip:"Save assignement. Leave field empty to un-assign it."
					,disabled:true
					,handler: function() {
					var s={modal:true, callbacks:{} };					var successFn = function(dc,response,serviceName,specs) {							 
this._getWindow_("wdwAssignTask").close();			 	

;	this._getDc_("dcRunningTask").discardChanges();			 	

;	this._getDc_("dcRunningTask").doQuery();			 	

							 
							}; s.callbacks['successFn'] = successFn; s.callbacks['successScope'] = this;
							
							try{ this._getDc_("dcRunningTask").doService("assignTask", s); }catch(e){dnet.base.DcExceptions.showMessage(e);}

 
}					 	
 ,scope:this });	
			this._getDc_("dcRunningTask").on("recordChanged", function(evnt) {
		 	       if ((evnt.state=='dirty') ) { var btn = this._getElement_("btnSaveAssignTask"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnSaveAssignTask");if(btn) btn.disable();  }
			 }, this );					 	
			this._elems_.add("btnCompleteTask", { xtype:"button", name:"btnCompleteTask", id:Ext.id(),iconCls:"icon-action-commit" 
					,text:"Complete task", tooltip:"Mark selected task as completed."
					,disabled:true
					,handler: function() {
					var s={modal:true, callbacks:{} };					var successFn = function(dc,response,serviceName,specs) {							 
this._getDc_("dcRunningTask").doQuery();			 	

							 
							}; s.callbacks['successFn'] = successFn; s.callbacks['successScope'] = this;
							
							try{ this._getDc_("dcRunningTask").doService("completeTask", s); }catch(e){dnet.base.DcExceptions.showMessage(e);}

 
}					 	
 ,scope:this });	
			this._getDc_("dcRunningTask").on("selectionChanged", function(evnt) {
		 	       if ((evnt.dc.selectedRecords.length == 1) && (!evnt.record.data.endTime)) { var btn = this._getElement_("btnCompleteTask"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnCompleteTask");if(btn) btn.disable();  }
			 }, this );					 	
			this._elems_.add("btnOpenAsignTaskWindow", { xtype:"button", name:"btnOpenAsignTaskWindow", id:Ext.id() 
					,text:"Assign task", tooltip:"(Re-)Assign the selected task."
					,disabled:true
					,handler: function() {
this._getWindow_("wdwAssignTask").show();			 	

 
}					 	
 ,scope:this });	
			this._getDc_("dcRunningTask").on("selectionChanged", function(evnt) {
		 	       if ((evnt.dc.selectedRecords.length == 1) && (!evnt.record.data.endTime)) { var btn = this._getElement_("btnOpenAsignTaskWindow"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnOpenAsignTaskWindow");if(btn) btn.disable();  }
			 }, this );					 	
		this._elems_.add("filterDeployment", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDeployment$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcDeployment"),height:65 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listDeployment", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDeployment$List", id:Ext.id(), _controller_:this._dcs_.get("dcDeployment") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("filterProcess", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfProcess$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcProcess"),height:65 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listProcess", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfProcess$List", id:Ext.id(), _controller_:this._dcs_.get("dcProcess"),buttons:[ this._elems_.get("btnStartProcess") ] ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("filterRunningInstance", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcRunningInstance"),height:65 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listRunningInstance", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceRunning$List", id:Ext.id(), _controller_:this._dcs_.get("dcRunningInstance"),buttons:[ this._elems_.get("btnKillProcessInstance") ,this._elems_.get("btnOpenAsignTaskWindow") ,this._elems_.get("btnCompleteTask") ] ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("filterRunningTask", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcRunningTask") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listRunningTask", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$List", id:Ext.id(), _controller_:this._dcs_.get("dcRunningTask"),height:150 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("formRunningTaskAsgn", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$AssignForm", id:Ext.id(), _controller_:this._dcs_.get("dcRunningTask") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("dcRunningTask").isRecordValid = this._dcs_.get("dcRunningTask").isRecordValid.createInterceptor(function() { return this._getElement_("formRunningTaskAsgn")._isValid_(); }, this);		 
		  
		this._elems_.add("filterFinishedInstance", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceFinished$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcFinishedInstance"),height:65 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listFinishedInstance", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfProcessInstanceFinished$List", id:Ext.id(), _controller_:this._dcs_.get("dcFinishedInstance") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("filterFinishedTask", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcFinishedTask") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listFinishedTask", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfTaskInstance$List", id:Ext.id(), _controller_:this._dcs_.get("dcFinishedTask"),height:150 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Processes defined",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Running instances",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas3", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Finished instances",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas4", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Deployments",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
		
		this._elems_.add("wdwAssignTask", { _window_:true, resizable:true, layout:"fit", id:Ext.id(), items:[this._elems_.get("formRunningTaskAsgn")]
,title:"Assign task",modal:true,width:300,height:100,buttons:[ this._elems_.get("btnSaveAssignTask") ]				}); 	
			 	
	}

	,_linkElements_: function () {	
			
		this._elems_.get("main")["region"] = "center";
		this._elems_.get("_toc_")["region"] = "west";
		this._elems_.get("_main_with_toc_")["items"] = [ this._elems_.get("main") , this._elems_.get("_toc_")];
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") , this._elems_.get("canvas3") , this._elems_.get("canvas4") ]; 				 		
 
			this._elems_.get("filterProcess")["region"] = "north";			
			this._elems_.get("listProcess")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("filterProcess") , this._elems_.get("listProcess") ]; 				 		
 
			this._elems_.get("filterRunningInstance")["region"] = "north";			
			this._elems_.get("listRunningInstance")["region"] = "center";			
			this._elems_.get("listRunningTask")["region"] = "south";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("filterRunningInstance") , this._elems_.get("listRunningInstance") , this._elems_.get("listRunningTask") ]; 				 		
 
			this._elems_.get("filterFinishedInstance")["region"] = "north";			
			this._elems_.get("listFinishedInstance")["region"] = "center";			
			this._elems_.get("listFinishedTask")["region"] = "south";			
		   
	
	 	this._elems_.get("canvas3")["items"] = [ this._elems_.get("filterFinishedInstance") , this._elems_.get("listFinishedInstance") , this._elems_.get("listFinishedTask") ]; 				 		
 
			this._elems_.get("filterDeployment")["region"] = "north";			
			this._elems_.get("listDeployment")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas4")["items"] = [ this._elems_.get("filterDeployment") , this._elems_.get("listDeployment") ]; 				 		
	 	this._linkToolbar_("tlbProcessList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbRunningInstanceList", "canvas2");	 	  	
	 	this._linkToolbar_("tlbFinishedInstanceList", "canvas3");	 	  	
	 	this._linkToolbar_("tlbDeploymentList", "canvas4");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbProcessList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcProcess").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbProcessList-load"
		this._tlbitms_.add("tlbProcessList___S00_", "-") ;
		this._tlbitms_.add("tlbProcessList___S01_", "-") ;
		this._tlbitms_.add("tlbProcessList___TITLE_",  {xtype:"tbtext", text:"WfProcess"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbProcessList__") != -1); } )
		this._tlbs_.add("tlbProcessList" , t.getRange() );
	


			this._getDc_("dcProcess").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbProcessList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcProcess").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbProcessList__load")) this._tlbitms_.get("tlbProcessList__load").enable();
                 if(this._tlbitms_.get("tlbProcessList__new_sr"))this._tlbitms_.get("tlbProcessList__new_sr").enable();
                 if(this._tlbitms_.get("tlbProcessList__new_mr"))this._tlbitms_.get("tlbProcessList__new_mr").enable();
			  } , this );
			  
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbRunningInstanceList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcRunningInstance").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRunningInstanceList-load"
		this._tlbitms_.add("tlbRunningInstanceList___S00_", "-") ;
		this._tlbitms_.add("tlbRunningInstanceList___S01_", "-") ;
		this._tlbitms_.add("tlbRunningInstanceList___TITLE_",  {xtype:"tbtext", text:"WfProcessInstanceRunning"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbRunningInstanceList__") != -1); } )
		this._tlbs_.add("tlbRunningInstanceList" , t.getRange() );
	


			this._getDc_("dcRunningInstance").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbRunningInstanceList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcRunningInstance").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbRunningInstanceList__load")) this._tlbitms_.get("tlbRunningInstanceList__load").enable();
                 if(this._tlbitms_.get("tlbRunningInstanceList__new_sr"))this._tlbitms_.get("tlbRunningInstanceList__new_sr").enable();
                 if(this._tlbitms_.get("tlbRunningInstanceList__new_mr"))this._tlbitms_.get("tlbRunningInstanceList__new_mr").enable();
			  } , this );
			  
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbFinishedInstanceList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcFinishedInstance").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbFinishedInstanceList-load"
		this._tlbitms_.add("tlbFinishedInstanceList___S00_", "-") ;
		this._tlbitms_.add("tlbFinishedInstanceList___S01_", "-") ;
		this._tlbitms_.add("tlbFinishedInstanceList___TITLE_",  {xtype:"tbtext", text:"WfProcessInstanceFinished"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbFinishedInstanceList__") != -1); } )
		this._tlbs_.add("tlbFinishedInstanceList" , t.getRange() );
	


			this._getDc_("dcFinishedInstance").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbFinishedInstanceList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcFinishedInstance").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbFinishedInstanceList__load")) this._tlbitms_.get("tlbFinishedInstanceList__load").enable();
                 if(this._tlbitms_.get("tlbFinishedInstanceList__new_sr"))this._tlbitms_.get("tlbFinishedInstanceList__new_sr").enable();
                 if(this._tlbitms_.get("tlbFinishedInstanceList__new_mr"))this._tlbitms_.get("tlbFinishedInstanceList__new_mr").enable();
			  } , this );
			  
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbDeploymentList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcDeployment").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbDeploymentList-load"
		this._tlbitms_.add("tlbDeploymentList___S00_", "-") ;
		this._tlbitms_.add("tlbDeploymentList___S01_", "-") ;
		this._tlbitms_.add("tlbDeploymentList___TITLE_",  {xtype:"tbtext", text:"WfDeployment"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbDeploymentList__") != -1); } )
		this._tlbs_.add("tlbDeploymentList" , t.getRange() );
	


			this._getDc_("dcDeployment").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbDeploymentList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcDeployment").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbDeploymentList__load")) this._tlbitms_.get("tlbDeploymentList__load").enable();
                 if(this._tlbitms_.get("tlbDeploymentList__new_sr"))this._tlbitms_.get("tlbDeploymentList__new_sr").enable();
                 if(this._tlbitms_.get("tlbDeploymentList__new_mr"))this._tlbitms_.get("tlbDeploymentList__new_mr").enable();
			  } , this );
			  
	

				  	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("dcProcess").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("dcRunningInstance").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("dcRunningTask").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("formRunningTaskAsgn").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("dcFinishedInstance").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("dcFinishedTask").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("formRunningTaskAsgn").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("dcDeployment").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.ad.workflow.frame.Workflow_UI", net.nan21.dnet.module.ad.workflow.frame.Workflow_UI);   
