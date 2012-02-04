Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/AccessControlDs", "nan21.dnet.module.ad.ui.extjs/dc/AccessControl", "nan21.dnet.module.ad.ui.extjs/ds/DsAccessControlDs", "nan21.dnet.module.ad.ui.extjs/dc/DsAccessControl", "nan21.dnet.module.ad.ui.extjs/ds/AsgnAccessControlDs", "nan21.dnet.module.ad.ui.extjs/dc/AsgnAccessControl","nan21.dnet.module.ad.ui.extjs/ds/AccessControlLovDs","nan21.dnet.module.ad.ui.extjs/lov/AccessControls","nan21.dnet.module.ad.ui.extjs/ds/RoleLovDs","nan21.dnet.module.ad.ui.extjs/lov/Roles","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceDsLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSourceDs","nan21.dnet.module.ad.ui.extjs/ds/AccessControlLovDs","nan21.dnet.module.ad.ui.extjs/lov/AccessControls","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceAsgnLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSourceAsgn","nan21.dnet.module.ad.ui.extjs/ds/AccessControlLovDs","nan21.dnet.module.ad.ui.extjs/lov/AccessControls","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceDsLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSourceDs","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceAsgnLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSourceAsgn","nan21.dnet.module.ad.ui.extjs/asgn/AccessControlRoles"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.AccessControl_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.usr.frame.AccessControl_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.AccessControl_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("ctrl", new net.nan21.dnet.module.ad.usr.dc.AccessControl({multiEdit:true}))
		.addDc("dsAccess", new net.nan21.dnet.module.ad.usr.dc.DsAccessControl({multiEdit:true}))
		.addDc("asgnAccess", new net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl({multiEdit:true}))		
		.linkDc("dsAccess", "ctrl",{fetchMode:"auto",fields:[ {childField:"accessControlId", parentField:"id"} ]} )
		.linkDc("asgnAccess", "ctrl",{fetchMode:"auto",fields:[ {childField:"accessControlId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnAsgnRoleToAccessCtrl",text:"Roles", tooltip:"Assign selected privilege to roles",disabled:true
			,handler: this.onBtnAsgnRoleToAccessCtrl,scope:this,stateManager:{name:"selected_one_clean", dc:"ctrl" }	})	
							 	
		.addButton({name:"btnShowUiAsgnRules",text:"ASGN rules", tooltip:"Open assignment rules frame",disabled:false
			,handler: this.onBtnShowUiAsgnRules,scope:this	})	
							 	
		.addButton({name:"btnShowUiDsRules",text:"DS rules", tooltip:"Open data-source rules frame",disabled:false
			,handler: this.onBtnShowUiDsRules,scope:this	})	
							 	
		.addButton({name:"btnCopyRules",text:"Copy rules", tooltip:"Copy rules from another privilege",disabled:true
			,handler: this.onBtnCopyRules,scope:this,stateManager:{name:"selected_one_clean", dc:"ctrl" }	})	
							 	
		.addButton({name:"btnCopyRulesExec",text:"OK", tooltip:"Copy rules from selected privilege",disabled:false
			,handler: this.onBtnCopyRulesExec,scope:this	})	
							 	
		.addDcFilterFormView("ctrl",{ name:"privilegeFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.AccessControl$Filter",height:110})	 
		.addDcView("ctrl",{ name:"privilegeEditList", xtype:"net.nan21.dnet.module.ad.usr.dc.AccessControl$EditList", frame:true,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnAsgnRoleToAccessCtrl") ,this._elems_.get("btnCopyRules") ,this._elems_.get("btnShowUiDsRules") ,this._elems_.get("btnShowUiAsgnRules") ]}]})	 
		.addDcFormView("ctrl",{ name:"privilegeCopyRules", xtype:"net.nan21.dnet.module.ad.usr.dc.AccessControl$CopyRulesFromSource"})	 
		.addDcFilterFormView("dsAccess",{ name:"dsAccessFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.DsAccessControl$Filter"})	 
		.addDcView("dsAccess",{ name:"dsAccessCtxEditList", xtype:"net.nan21.dnet.module.ad.usr.dc.DsAccessControl$CtxEditList", frame:true,title:"Data-source"})	 
		.addDcFilterFormView("asgnAccess",{ name:"asgnAccessFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$Filter"})	 
		.addDcView("asgnAccess",{ name:"asgnAccessCtxEditList", xtype:"net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$CtxEditList", frame:true,title:"Assignment"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "detailTabs", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id(),height:220}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		
		.addWindow({name:"wdwCopyRules", closable:true, closeAction:'hide', resizable:true, layout:"fit", items:[this._elems_.get("privilegeCopyRules")]
,title:"Select source",modal:true,width:400,height:180,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnCopyRulesExec") ]}}) 	
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["privilegeFilter","privilegeEditList","detailTabs"] ,["north","center","south"])	
	 	.addChildrenTo("detailTabs", ["dsAccessCtxEditList","asgnAccessCtxEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbCtrlEditList")	  	
	 	.addToolbarTo("dsAccessCtxEditList","tlbDsAccessCtxEditList")	  	
	 	.addToolbarTo("asgnAccessCtxEditList","tlbAsgnAccessCtxEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCtrlEditList", {dc:"ctrl"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Privileges"}).end()
			.beginToolbar("tlbDsAccessCtxEditList", {dc:"dsAccess"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"DS rules"}).end()
			.beginToolbar("tlbAsgnAccessCtxEditList", {dc:"asgnAccess"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"ASGN rules"}).end(); 	
	}


	,onBtnAsgnRoleToAccessCtrl: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$Ui ,{dc:"ctrl",objectIdField:"id"});
	}					 	

	,onBtnShowUiAsgnRules: function() {
		var bundle = "nan21.dnet.module.ad.ui.extjs";
		var frame = "net.nan21.dnet.module.ad.usr.frame.AsgnAccessControl_UI";
		
		getApplication().showFrameByName("nan21.dnet.module.ad.ui.extjs","net.nan21.dnet.module.ad.usr.frame.AsgnAccessControl_UI");
		
		
	}					 	

	,onBtnShowUiDsRules: function() {
		var bundle = "nan21.dnet.module.ad.ui.extjs";
		var frame = "net.nan21.dnet.module.ad.usr.frame.DsAccessControl_UI";
		
		getApplication().showFrameByName("nan21.dnet.module.ad.ui.extjs","net.nan21.dnet.module.ad.usr.frame.DsAccessControl_UI");
		
		
	}					 	

	,onBtnCopyRules: function() {
this._getWindow_("wdwCopyRules").show();			 	
	}					 	

	,onBtnCopyRulesExec: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 	this._getWindow_("wdwCopyRules").close();			 	
;	this._getDc_("dsAccess").doQuery();			 	
;	this._getDc_("asgnAccess").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("ctrl").doService("copyRulesFromAccessControl", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});  
