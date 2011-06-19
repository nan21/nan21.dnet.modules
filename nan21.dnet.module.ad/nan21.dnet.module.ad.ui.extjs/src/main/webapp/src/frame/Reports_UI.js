 
Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/ReportDs", "nan21.dnet.module.ad.ui.extjs/dc/Report", "nan21.dnet.module.ad.ui.extjs/ds/ReportParamDs", "nan21.dnet.module.ad.ui.extjs/dc/ReportParam", "nan21.dnet.module.ad.ui.extjs/ds/DsReportDs", "nan21.dnet.module.ad.ui.extjs/dc/DsReport", "nan21.dnet.module.ad.ui.extjs/ds/DsReportParamDs", "nan21.dnet.module.ad.ui.extjs/dc/DsReportParam","nan21.dnet.module.ad.ui.extjs/ds/ReportServerLovDs","nan21.dnet.module.ad.ui.extjs/lov/ReportServers","nan21.dnet.module.ad.ui.extjs/ds/ReportServerLovDs","nan21.dnet.module.ad.ui.extjs/lov/ReportServers","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSource","nan21.dnet.module.ad.ui.extjs/ds/ReportParamLovDs","nan21.dnet.module.ad.ui.extjs/lov/ReportParams","nan21.dnet.module.ad.ui.extjs/ds/SysDsFieldLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDsFields"]);

Ext.ns("net.nan21.dnet.module.ad.report.frame");
net.nan21.dnet.module.ad.report.frame.Reports_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.report.frame.Reports_UI"
	
	,_defineDcs_: function () {	
		var  rep = new net.nan21.dnet.module.ad.report.dc.Report({multiEdit:false}), params = new net.nan21.dnet.module.ad.report.dc.ReportParam({multiEdit:true}), dsrep = new net.nan21.dnet.module.ad.report.dc.DsReport({multiEdit:true}), dsparam = new net.nan21.dnet.module.ad.report.dc.DsReportParam({multiEdit:true});	 	
		
		this._dcs_.add("rep", rep);			
		params.setDcContext(new dnet.base.DcContext({childDc:params, parentDc:rep, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"reportId", parentField:"id"} ]}}));rep.addChild(params);
		this._dcs_.add("params", params);			
		dsrep.setDcContext(new dnet.base.DcContext({childDc:dsrep, parentDc:rep, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"reportId", parentField:"id"} ]}}));rep.addChild(dsrep);
		this._dcs_.add("dsrep", dsrep);			
		dsparam.setDcContext(new dnet.base.DcContext({childDc:dsparam, parentDc:dsrep, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"dsReportId", parentField:"id"},{childField:"reportId", parentField:"reportId"},{childField:"dataSource", parentField:"dataSource"} ]}}));dsrep.addChild(dsparam);
		this._dcs_.add("dsparam", dsparam);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("repFilter", { xtype:"net.nan21.dnet.module.ad.report.dc.Report$Filter", id:Ext.id(), _controller_:this._dcs_.get("rep") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("repList", { xtype:"net.nan21.dnet.module.ad.report.dc.Report$List", id:Ext.id(), _controller_:this._dcs_.get("rep") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("repEdit", { xtype:"net.nan21.dnet.module.ad.report.dc.Report$Edit", id:Ext.id(), _controller_:this._dcs_.get("rep"),height:120 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("rep").isRecordValid = this._dcs_.get("rep").isRecordValid.createInterceptor(function() { return this._getElement_("repEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("paramEditList", { xtype:"net.nan21.dnet.module.ad.report.dc.ReportParam$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("params"),title:"Parameters" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("dsrepList", { xtype:"net.nan21.dnet.module.ad.report.dc.DsReport$ReportCtxList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("dsrep") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("dsparamList", { xtype:"net.nan21.dnet.module.ad.report.dc.DsReportParam$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("dsparam") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });		
		this._elems_.add("repDetailsTab", {layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()	}  }); 	 
		
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("dsRep", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Data-source links",listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);      } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("repFilter")["region"] = "north";			
			this._elems_.get("repList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("repFilter") , this._elems_.get("repList") ]; 				 		
 
			this._elems_.get("repEdit")["region"] = "north";			
			this._elems_.get("repDetailsTab")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("repEdit") , this._elems_.get("repDetailsTab") ]; 				 		
 
		this._elems_.get("repDetailsTab")["items"]["items"] = [ this._elems_.get("paramEditList") , this._elems_.get("dsRep") ];	
 
			this._elems_.get("dsrepList")["region"] = "west";			
			this._elems_.get("dsparamList")["region"] = "center";			
		   
	
	 	this._elems_.get("dsRep")["items"] = [ this._elems_.get("dsrepList") , this._elems_.get("dsparamList") ]; 				 		
	 	this._linkToolbar_("tlbRepList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbRepEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbParamList", "paramEditList");	 	  	
	 	this._linkToolbar_("tlbDsRepList", "dsrepList");	 	  	
	 	this._linkToolbar_("tlbDsParamList", "dsparamList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbRepList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("rep").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRepList-load"
		this._tlbitms_.add("tlbRepList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rep")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbRepList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRepList-edit_sr"
		this._tlbitms_.add("tlbRepList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("rep").doNew(); this._invokeTlbItem_("tlbRepList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRepList-new_sr"
		this._tlbitms_.add("tlbRepList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rep").doCopy(); this._invokeTlbItem_("tlbRepList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRepList-copy_sr"
		this._tlbitms_.add("tlbRepList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rep").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRepList-delete_selected_sr"
		this._tlbitms_.add("tlbRepList___S00_", "-") ;
		this._tlbitms_.add("tlbRepList___S01_", "-") ;
		this._tlbitms_.add("tlbRepList___TITLE_",  {xtype:"tbtext", text:"Report"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbRepList__") != -1); } )
		this._tlbs_.add("tlbRepList" , t.getRange() );

		this._getDc_("rep").on("onEdit", function() {this._invokeTlbItem_("tlbRepList__edit_sr");} , this);

	


			this._getDc_("rep").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbRepList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("rep").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbRepList__load")) this._tlbitms_.get("tlbRepList__load").enable();
                 if(this._tlbitms_.get("tlbRepList__new_sr"))this._tlbitms_.get("tlbRepList__new_sr").enable();
                 if(this._tlbitms_.get("tlbRepList__new_mr"))this._tlbitms_.get("tlbRepList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("rep").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbRepList__edit_sr")) this._tlbitms_.get("tlbRepList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbRepList__copy_sr")) this._tlbitms_.get("tlbRepList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbRepList__delete_selected_sr")) this._tlbitms_.get("tlbRepList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbRepList__edit_sr")) this._tlbitms_.get("tlbRepList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbRepList__copy_sr")) this._tlbitms_.get("tlbRepList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbRepList__delete_selected_sr")) this._tlbitms_.get("tlbRepList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbRepEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("rep")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbRepEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRepEdit-back_sr"
		this._tlbitms_.add("tlbRepEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rep").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRepEdit-save"
		this._tlbitms_.add("tlbRepEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("rep").doNew(); this._invokeTlbItem_("tlbRepEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRepEdit-new_sr"
		this._tlbitms_.add("tlbRepEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rep").doCopy(); this._invokeTlbItem_("tlbRepEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRepEdit-copy_sr"
		this._tlbitms_.add("tlbRepEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("rep").getCurrentRecord().phantom) {this._getDc_("rep").discardChanges();this._invokeTlbItem_("tlbRepEdit__back_sr");} else  {this._getDc_("rep").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRepEdit-rollback_sr"
		this._tlbitms_.add("tlbRepEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("rep").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRepEdit-prev_rec_sr"
		this._tlbitms_.add("tlbRepEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("rep").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRepEdit-next_rec_sr"
		this._tlbitms_.add("tlbRepEdit___S00_", "-") ;
		this._tlbitms_.add("tlbRepEdit___S01_", "-") ;
		this._tlbitms_.add("tlbRepEdit___TITLE_",  {xtype:"tbtext", text:"Report"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbRepEdit__") != -1); } )
		this._tlbs_.add("tlbRepEdit" , t.getRange() );
	


			this._getDc_("rep").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbRepEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("rep").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbRepEdit__load")) this._tlbitms_.get("tlbRepEdit__load").enable();
                 if(this._tlbitms_.get("tlbRepEdit__new_sr"))this._tlbitms_.get("tlbRepEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbRepEdit__new_mr"))this._tlbitms_.get("tlbRepEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("rep").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbRepEdit__back_sr")) this._tlbitms_.get("tlbRepEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbRepEdit__save")) this._tlbitms_.get("tlbRepEdit__save").enable();
                    if(this._tlbitms_.get("tlbRepEdit__new_sr")) this._tlbitms_.get("tlbRepEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbRepEdit__copy_sr")) this._tlbitms_.get("tlbRepEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbRepEdit__rollback_record_sr")) this._tlbitms_.get("tlbRepEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbRepEdit__rollback_sr")) this._tlbitms_.get("tlbRepEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbRepEdit__prev_rec_sr")) this._tlbitms_.get("tlbRepEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbRepEdit__next_rec_sr")) this._tlbitms_.get("tlbRepEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("rep").on("cleanRecord" , function() {
		  		  if (this._getDc_("rep").isDirty() ) {
                    if(this._tlbitms_.get("tlbRepEdit__back_sr")) this._tlbitms_.get("tlbRepEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbRepEdit__save")) this._tlbitms_.get("tlbRepEdit__save").enable();
                    if(this._tlbitms_.get("tlbRepEdit__new_sr")) this._tlbitms_.get("tlbRepEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbRepEdit__copy_sr")) this._tlbitms_.get("tlbRepEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbRepEdit__rollback_record_sr")) this._tlbitms_.get("tlbRepEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbRepEdit__rollback_sr")) this._tlbitms_.get("tlbRepEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbRepEdit__prev_rec_sr")) this._tlbitms_.get("tlbRepEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbRepEdit__next_rec_sr")) this._tlbitms_.get("tlbRepEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbRepEdit__back_sr")) this._tlbitms_.get("tlbRepEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbRepEdit__save")) this._tlbitms_.get("tlbRepEdit__save").disable();
                  	if(this._tlbitms_.get("tlbRepEdit__new_sr")) this._tlbitms_.get("tlbRepEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbRepEdit__copy_sr")) this._tlbitms_.get("tlbRepEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbRepEdit__rollback_record_sr")) this._tlbitms_.get("tlbRepEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbRepEdit__rollback_sr")) this._tlbitms_.get("tlbRepEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbRepEdit__prev_rec_sr")) this._tlbitms_.get("tlbRepEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbRepEdit__next_rec_sr")) this._tlbitms_.get("tlbRepEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("rep").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbRepEdit__copy_sr")) this._tlbitms_.get("tlbRepEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbParamList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("params").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbParamList-load"
		this._tlbitms_.add("tlbParamList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("params").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbParamList-save_mr"
		this._tlbitms_.add("tlbParamList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("params").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbParamList-new_mr"
		this._tlbitms_.add("tlbParamList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("params").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbParamList-copy_mr"
		this._tlbitms_.add("tlbParamList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("params").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbParamList-delete_mr"
		this._tlbitms_.add("tlbParamList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("params").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbParamList-rollback_mr"
		this._tlbitms_.add("tlbParamList___S00_", "-") ;
		this._tlbitms_.add("tlbParamList___S01_", "-") ;
		this._tlbitms_.add("tlbParamList___TITLE_",  {xtype:"tbtext", text:"ReportParam"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbParamList__") != -1); } )
		this._tlbs_.add("tlbParamList" , t.getRange() );
	


			this._getDc_("params").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbParamList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("params").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbParamList__load")) this._tlbitms_.get("tlbParamList__load").enable();
                 if(this._tlbitms_.get("tlbParamList__new_sr"))this._tlbitms_.get("tlbParamList__new_sr").enable();
                 if(this._tlbitms_.get("tlbParamList__new_mr"))this._tlbitms_.get("tlbParamList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("params").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbParamList__copy_mr")) this._tlbitms_.get("tlbParamList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbParamList__delete_mr")) this._tlbitms_.get("tlbParamList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbParamList__copy_mr")) this._tlbitms_.get("tlbParamList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbParamList__delete_mr")) this._tlbitms_.get("tlbParamList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("params").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbParamList__load")) this._tlbitms_.get("tlbParamList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbParamList__save_mr")) this._tlbitms_.get("tlbParamList__save_mr").enable();
                    if(this._tlbitms_.get("tlbParamList__rollback_record_mr"))this._tlbitms_.get("tlbParamList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbParamList__rollback_mr"))this._tlbitms_.get("tlbParamList__rollback_mr").enable();
			  } , this );

			this._getDc_("params").on("cleanRecord" , function() {
		  		  if (this._getDc_("params").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbParamList__load")) this._tlbitms_.get("tlbParamList__load").disable();	                
                    if(this._tlbitms_.get("tlbParamList__save_mr"))this._tlbitms_.get("tlbParamList__save_mr").enable();
                    if(this._tlbitms_.get("tlbParamList__rollback_record_mr"))this._tlbitms_.get("tlbParamList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbParamList__rollback_mr"))this._tlbitms_.get("tlbParamList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbParamList__load")) this._tlbitms_.get("tlbParamList__load").enable();	
                  	if(this._tlbitms_.get("tlbParamList__back_mr"))this._tlbitms_.get("tlbParamList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbParamList__save_mr"))this._tlbitms_.get("tlbParamList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbParamList__rollback_record_mr"))this._tlbitms_.get("tlbParamList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbParamList__rollback_mr"))this._tlbitms_.get("tlbParamList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbDsRepList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dsrep").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbDsRepList-load"
		this._tlbitms_.add("tlbDsRepList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dsrep").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbDsRepList-save_mr"
		this._tlbitms_.add("tlbDsRepList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dsrep").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbDsRepList-new_mr"
		this._tlbitms_.add("tlbDsRepList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dsrep").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbDsRepList-copy_mr"
		this._tlbitms_.add("tlbDsRepList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dsrep").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbDsRepList-delete_mr"
		this._tlbitms_.add("tlbDsRepList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("dsrep").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbDsRepList-rollback_mr"
		this._tlbitms_.add("tlbDsRepList___S00_", "-") ;
		this._tlbitms_.add("tlbDsRepList___S01_", "-") ;
		this._tlbitms_.add("tlbDsRepList___TITLE_",  {xtype:"tbtext", text:"DsReport"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbDsRepList__") != -1); } )
		this._tlbs_.add("tlbDsRepList" , t.getRange() );
	


			this._getDc_("dsrep").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbDsRepList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dsrep").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbDsRepList__load")) this._tlbitms_.get("tlbDsRepList__load").enable();
                 if(this._tlbitms_.get("tlbDsRepList__new_sr"))this._tlbitms_.get("tlbDsRepList__new_sr").enable();
                 if(this._tlbitms_.get("tlbDsRepList__new_mr"))this._tlbitms_.get("tlbDsRepList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("dsrep").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbDsRepList__copy_mr")) this._tlbitms_.get("tlbDsRepList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbDsRepList__delete_mr")) this._tlbitms_.get("tlbDsRepList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbDsRepList__copy_mr")) this._tlbitms_.get("tlbDsRepList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbDsRepList__delete_mr")) this._tlbitms_.get("tlbDsRepList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("dsrep").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbDsRepList__load")) this._tlbitms_.get("tlbDsRepList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbDsRepList__save_mr")) this._tlbitms_.get("tlbDsRepList__save_mr").enable();
                    if(this._tlbitms_.get("tlbDsRepList__rollback_record_mr"))this._tlbitms_.get("tlbDsRepList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbDsRepList__rollback_mr"))this._tlbitms_.get("tlbDsRepList__rollback_mr").enable();
			  } , this );

			this._getDc_("dsrep").on("cleanRecord" , function() {
		  		  if (this._getDc_("dsrep").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbDsRepList__load")) this._tlbitms_.get("tlbDsRepList__load").disable();	                
                    if(this._tlbitms_.get("tlbDsRepList__save_mr"))this._tlbitms_.get("tlbDsRepList__save_mr").enable();
                    if(this._tlbitms_.get("tlbDsRepList__rollback_record_mr"))this._tlbitms_.get("tlbDsRepList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbDsRepList__rollback_mr"))this._tlbitms_.get("tlbDsRepList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbDsRepList__load")) this._tlbitms_.get("tlbDsRepList__load").enable();	
                  	if(this._tlbitms_.get("tlbDsRepList__back_mr"))this._tlbitms_.get("tlbDsRepList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbDsRepList__save_mr"))this._tlbitms_.get("tlbDsRepList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbDsRepList__rollback_record_mr"))this._tlbitms_.get("tlbDsRepList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbDsRepList__rollback_mr"))this._tlbitms_.get("tlbDsRepList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbDsParamList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dsparam").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbDsParamList-load"
		this._tlbitms_.add("tlbDsParamList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dsparam").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbDsParamList-save_mr"
		this._tlbitms_.add("tlbDsParamList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dsparam").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbDsParamList-new_mr"
		this._tlbitms_.add("tlbDsParamList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dsparam").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbDsParamList-copy_mr"
		this._tlbitms_.add("tlbDsParamList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dsparam").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbDsParamList-delete_mr"
		this._tlbitms_.add("tlbDsParamList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("dsparam").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbDsParamList-rollback_mr"
		this._tlbitms_.add("tlbDsParamList___S00_", "-") ;
		this._tlbitms_.add("tlbDsParamList___S01_", "-") ;
		this._tlbitms_.add("tlbDsParamList___TITLE_",  {xtype:"tbtext", text:"DsReportParam"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbDsParamList__") != -1); } )
		this._tlbs_.add("tlbDsParamList" , t.getRange() );
	


			this._getDc_("dsparam").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbDsParamList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dsparam").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbDsParamList__load")) this._tlbitms_.get("tlbDsParamList__load").enable();
                 if(this._tlbitms_.get("tlbDsParamList__new_sr"))this._tlbitms_.get("tlbDsParamList__new_sr").enable();
                 if(this._tlbitms_.get("tlbDsParamList__new_mr"))this._tlbitms_.get("tlbDsParamList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("dsparam").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbDsParamList__copy_mr")) this._tlbitms_.get("tlbDsParamList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbDsParamList__delete_mr")) this._tlbitms_.get("tlbDsParamList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbDsParamList__copy_mr")) this._tlbitms_.get("tlbDsParamList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbDsParamList__delete_mr")) this._tlbitms_.get("tlbDsParamList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("dsparam").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbDsParamList__load")) this._tlbitms_.get("tlbDsParamList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbDsParamList__save_mr")) this._tlbitms_.get("tlbDsParamList__save_mr").enable();
                    if(this._tlbitms_.get("tlbDsParamList__rollback_record_mr"))this._tlbitms_.get("tlbDsParamList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbDsParamList__rollback_mr"))this._tlbitms_.get("tlbDsParamList__rollback_mr").enable();
			  } , this );

			this._getDc_("dsparam").on("cleanRecord" , function() {
		  		  if (this._getDc_("dsparam").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbDsParamList__load")) this._tlbitms_.get("tlbDsParamList__load").disable();	                
                    if(this._tlbitms_.get("tlbDsParamList__save_mr"))this._tlbitms_.get("tlbDsParamList__save_mr").enable();
                    if(this._tlbitms_.get("tlbDsParamList__rollback_record_mr"))this._tlbitms_.get("tlbDsParamList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbDsParamList__rollback_mr"))this._tlbitms_.get("tlbDsParamList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbDsParamList__load")) this._tlbitms_.get("tlbDsParamList__load").enable();	
                  	if(this._tlbitms_.get("tlbDsParamList__back_mr"))this._tlbitms_.get("tlbDsParamList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbDsParamList__save_mr"))this._tlbitms_.get("tlbDsParamList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbDsParamList__rollback_record_mr"))this._tlbitms_.get("tlbDsParamList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbDsParamList__rollback_mr"))this._tlbitms_.get("tlbDsParamList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("rep").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("repEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("params").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("dsrep").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("dsparam").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.ad.report.frame.Reports_UI", net.nan21.dnet.module.ad.report.frame.Reports_UI);   
