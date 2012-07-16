Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/FiscalYearDs", "nan21.dnet.module.md.ui.extjs/dc/FiscalYear", "nan21.dnet.module.md.ui.extjs/ds/FiscalPeriodDs", "nan21.dnet.module.md.ui.extjs/dc/FiscalPeriod","nan21.dnet.module.bd.ui.extjs/ds/CalendarLovDs","nan21.dnet.module.bd.ui.extjs/lov/Calendars","nan21.dnet.module.bd.ui.extjs/ds/CalendarLovDs","nan21.dnet.module.bd.ui.extjs/lov/Calendars"]);

Ext.define("net.nan21.dnet.module.md.base.period.frame.FiscalYear_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.base.period.frame.FiscalYear_UI",
	
	 _name_ : "net.nan21.dnet.module.md.base.period.frame.FiscalYear_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("year", new net.nan21.dnet.module.md.base.period.dc.FiscalYear({multiEdit:true}))
		.addDc("period", new net.nan21.dnet.module.md.base.period.dc.FiscalPeriod({multiEdit:true}))		
		.linkDc("period", "year",{fields:[ {childField:"yearId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnCreateMonths",text:"Create months", tooltip:"Create monthly periods for selected year.",disabled:true
			,handler: this.onBtnCreateMonths,scope:this,stateManager:{name:"selected_one_clean", dc:"year" }	})	
							 	
		.addButton({name:"btnCreateQuarters",text:"Create quarters", tooltip:"Create quarter periods for selected year.",disabled:true
			,handler: this.onBtnCreateQuarters,scope:this,stateManager:{name:"selected_one_clean", dc:"year" }	})	
							 	
		.addButton({name:"btnCreateHalfYears",text:"Create half-years", tooltip:"Create half-year periods for selected year.",disabled:true
			,handler: this.onBtnCreateHalfYears,scope:this,stateManager:{name:"selected_one_clean", dc:"year" }	})	
							 	
		.addDcFilterFormView("year",{ name:"yearFilter", xtype:"net.nan21.dnet.module.md.base.period.dc.FiscalYear$Filter"})	 
		.addDcEditGridView("year",{ name:"yearEditList", xtype:"net.nan21.dnet.module.md.base.period.dc.FiscalYear$EditList", frame:true,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'right', weight:-1, items:[ this._elems_.get("btnCreateMonths") ,this._elems_.get("btnCreateQuarters") ,this._elems_.get("btnCreateHalfYears") ]}]})	 
		.addDcFilterFormView("period",{ name:"periodFilter", xtype:"net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$FilterCtx",width:250,title:"Filter", collapsible:true, collapsed:false})	 
		.addDcEditGridView("period",{ name:"periodEditList", xtype:"net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "periodPanel", layout:"border", defaults:{split:true},height:240})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["yearFilter","yearEditList","periodPanel"] ,["north","center","south"])	
		.addChildrenTo("periodPanel",["periodFilter","periodEditList"] ,["west","center"])	
	 	.addToolbarTo("canvas1","tlbYearList")	  	
	 	.addToolbarTo("periodPanel","tlbPeriodList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbYearList", {dc:"year"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Fiscal years"}).end()
			.beginToolbar("tlbPeriodList", {dc:"period"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Periods"}).end(); 	
	}


	,onBtnCreateMonths: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 			this._getDc_("period").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("year").doService("createMonths", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnCreateQuarters: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 			this._getDc_("period").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("year").doService("createQuarters", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnCreateHalfYears: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 			this._getDc_("period").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("year").doService("createHalfYears", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});  
