Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/AccDocDs", "nan21.dnet.module.md.ui.extjs/dc/AccDoc", "nan21.dnet.module.md.ui.extjs/ds/AccDocLineDs", "nan21.dnet.module.md.ui.extjs/dc/AccDocLine","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.md.ui.extjs/lov/AccSchemas","nan21.dnet.module.md.ui.extjs/ds/TxDocTypeLovDs","nan21.dnet.module.md.ui.extjs/lov/TxDocTypes","nan21.dnet.module.md.ui.extjs/ds/FiscalPeriodLovDs","nan21.dnet.module.md.ui.extjs/lov/FiscalPeriods","nan21.dnet.module.md.ui.extjs/ds/AccJournalLovDs","nan21.dnet.module.md.ui.extjs/lov/AccJournals","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName"]);

Ext.define("net.nan21.dnet.module.md.tx.acc.frame.AccDoc_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.tx.acc.frame.AccDoc_UI",
	
	 _name_ : "net.nan21.dnet.module.md.tx.acc.frame.AccDoc_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("doc", new net.nan21.dnet.module.md.tx.acc.dc.AccDoc({}))
		.addDc("line", new net.nan21.dnet.module.md.tx.acc.dc.AccDocLine({}))		
		.linkDc("line", "doc",{fields:[ {childField:"accDocId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnPost",text:"Post", tooltip:"Post document to G/L.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnPost,scope:this,stateManager:{name:"selected_one_clean", dc:"doc" , and: function(dc) {return (dc.record  && !dc.record.get("posted"));}}	})	
							 	
		.addButton({name:"btnUnPost",text:"Un-Post", tooltip:"Un-Post document from G/L.",iconCls:"icon-action-rollback",disabled:true
			,handler: this.onBtnUnPost,scope:this,stateManager:{name:"selected_one_clean", dc:"doc" , and: function(dc) {return (dc.record && dc.record.get("posted") );}}	})	
							 	
		.addDcFilterFormView("doc",{ name:"docFilter", xtype:"net.nan21.dnet.module.md.tx.acc.dc.AccDoc$Filter",height:130})	 
		.addDcGridView("doc",{ name:"docList", xtype:"net.nan21.dnet.module.md.tx.acc.dc.AccDoc$List",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnPost") ,this._elems_.get("btnUnPost") ]}]})	 
		.addDcGridView("line",{ name:"lineList", xtype:"net.nan21.dnet.module.md.tx.acc.dc.AccDocLine$List",width:380,title:"Lines", collapsible:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["docFilter","docList","lineList"] ,["north","center","east"])	
	 	.addToolbarTo("canvas1","tlbDocList")	  	
	 	.addToolbarTo("lineList","tlbLineList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbDocList", {dc:"doc"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Accounting document"}).end()
			.beginToolbar("tlbLineList", {dc:"line"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Lines"}).end(); 	
	}


	,onBtnPost: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("doc").doService("post", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnUnPost: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("doc").doService("unPost", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});  
