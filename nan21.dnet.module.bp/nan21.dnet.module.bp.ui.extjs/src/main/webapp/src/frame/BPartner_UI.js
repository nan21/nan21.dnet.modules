 
Dnet.import(["", "nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerDs", "nan21.dnet.module.bp.ui.extjs/dc/BusinessPartner", "nan21.dnet.module.bp.ui.extjs/ds/ContactDs", "nan21.dnet.module.bp.ui.extjs/dc/Contact", "nan21.dnet.module.bd.ui.extjs/ds/LocationDs", "nan21.dnet.module.bd.ui.extjs/dc/Location", "nan21.dnet.module.bp.ui.extjs/ds/BpBankAccountDs", "nan21.dnet.module.bp.ui.extjs/dc/BpBankAccount", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelDs", "nan21.dnet.module.bd.ui.extjs/dc/CommunicationChannel","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/RegionLovDs","nan21.dnet.module.bd.ui.extjs/lov/Regions","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bp.ui.extjs/ds/BankLovDs","nan21.dnet.module.bp.ui.extjs/lov/Banks","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/CommunicationChannelTypes"]);

Ext.ns("net.nan21.dnet.module.bp.md.frame");
net.nan21.dnet.module.bp.md.frame.BPartner_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bp.md.frame.BPartner_UI"
	
	,_defineDcs_: function () {	
		var  bp = new net.nan21.dnet.module.bp.md.dc.BusinessPartner({multiEdit:false}), bpContact = new net.nan21.dnet.module.bp.md.dc.Contact({multiEdit:true}), address = new net.nan21.dnet.module.bd.geo.dc.Location({multiEdit:false}), bpBankAcct = new net.nan21.dnet.module.bp.md.dc.BpBankAccount({multiEdit:true}), bpPhone = new net.nan21.dnet.module.bd.contact.dc.CommunicationChannel({multiEdit:true});	 	
		
		this._dcs_.add("bp", bp);			
		bpContact.setDcContext(new dnet.base.DcContext({childDc:bpContact, parentDc:bp, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"bpartnerId", parentField:"id"} ]}}));bp.addChild(bpContact);
		this._dcs_.add("bpContact", bpContact);			
		address.setDcContext(new dnet.base.DcContext({childDc:address, parentDc:bp, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]}}));bp.addChild(address);
		this._dcs_.add("address", address);			
		bpBankAcct.setDcContext(new dnet.base.DcContext({childDc:bpBankAcct, parentDc:bp, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"bpartnerId", parentField:"id"} ]}}));bp.addChild(bpBankAcct);
		this._dcs_.add("bpBankAcct", bpBankAcct);			
		bpPhone.setDcContext(new dnet.base.DcContext({childDc:bpPhone, parentDc:bp, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]}}));bp.addChild(bpPhone);
		this._dcs_.add("bpPhone", bpPhone);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("bpFilter", { xtype:"net.nan21.dnet.module.bp.md.dc.BusinessPartner$Filter", id:Ext.id(), _controller_:this._dcs_.get("bp") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("bpList", { xtype:"net.nan21.dnet.module.bp.md.dc.BusinessPartner$List", id:Ext.id(), _controller_:this._dcs_.get("bp") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("bpEdit", { xtype:"net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit", id:Ext.id(), _controller_:this._dcs_.get("bp"),height:120 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("bp").isRecordValid = this._dcs_.get("bp").isRecordValid.createInterceptor(function() { return this._getElement_("bpEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("bpContactEditList", { xtype:"net.nan21.dnet.module.bp.md.dc.Contact$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("bpContact"),title:"Contact" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("addressList", { xtype:"net.nan21.dnet.module.bd.geo.dc.Location$ListCtx", id:Ext.id(), _controller_:this._dcs_.get("address") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("addressEdit", { xtype:"net.nan21.dnet.module.bd.geo.dc.Location$EditCtx", id:Ext.id(), _controller_:this._dcs_.get("address") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("address").isRecordValid = this._dcs_.get("address").isRecordValid.createInterceptor(function() { return this._getElement_("addressEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("bpBankAccountEditList", { xtype:"net.nan21.dnet.module.bp.md.dc.BpBankAccount$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("bpBankAcct"),title:"Bank account" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("bpPhoneEditList", { xtype:"net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("bpPhone"),title:"Communication" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });		this._elems_.add("addressPanel", { layout:"card", activeItem:0, id:Ext.id(),title:"Address",listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });		
		this._elems_.add("bpDetailsTab", {layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()	}  }); 	 
		
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
		
		this._elems_.add("addressEditWrapper", { layout:"fit", id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);} }} }); 
	
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("bpFilter")["region"] = "north";			
			this._elems_.get("bpList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("bpFilter") , this._elems_.get("bpList") ]; 				 		
 
			this._elems_.get("bpEdit")["region"] = "north";			
			this._elems_.get("bpDetailsTab")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("bpEdit") , this._elems_.get("bpDetailsTab") ]; 				 		
 
		this._elems_.get("bpDetailsTab")["items"]["items"] = [ this._elems_.get("bpPhoneEditList") , this._elems_.get("addressPanel") , this._elems_.get("bpContactEditList") , this._elems_.get("bpBankAccountEditList") ];	
 
	
	 	this._elems_.get("addressPanel")["items"] = [ this._elems_.get("addressList") , this._elems_.get("addressEditWrapper") ]; 				 		
 
	
	 	this._elems_.get("addressEditWrapper")["items"] = [ this._elems_.get("addressEdit") ]; 				 		
	 	this._linkToolbar_("tlbBpList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbBpEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbBpContactList", "bpContactEditList");	 	  	
	 	this._linkToolbar_("tlbAddressList", "addressList");	 	  	
	 	this._linkToolbar_("tlbAddressEdit", "addressEditWrapper");	 	  	
	 	this._linkToolbar_("tlbBpBankAccountList", "bpBankAccountEditList");	 	  	
	 	this._linkToolbar_("tlbBpPhoneNumber", "bpPhoneEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbBpList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("bp").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpList-load"
		this._tlbitms_.add("tlbBpList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bp")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbBpList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpList-edit_sr"
		this._tlbitms_.add("tlbBpList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("bp").doNew(); this._invokeTlbItem_("tlbBpList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbBpList-new_sr"
		this._tlbitms_.add("tlbBpList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bp").doCopy(); this._invokeTlbItem_("tlbBpList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbBpList-copy_sr"
		this._tlbitms_.add("tlbBpList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bp").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbBpList-delete_selected_sr"
		this._tlbitms_.add("tlbBpList___S00_", "-") ;
		this._tlbitms_.add("tlbBpList___S01_", "-") ;
		this._tlbitms_.add("tlbBpList___TITLE_",  {xtype:"tbtext", text:"BusinessPartner"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbBpList__") != -1); } )
		this._tlbs_.add("tlbBpList" , t.getRange() );

		this._getDc_("bp").on("onEdit", function() {this._invokeTlbItem_("tlbBpList__edit_sr");} , this);

	


			this._getDc_("bp").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbBpList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("bp").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbBpList__load")) this._tlbitms_.get("tlbBpList__load").enable();
                 if(this._tlbitms_.get("tlbBpList__new_sr"))this._tlbitms_.get("tlbBpList__new_sr").enable();
                 if(this._tlbitms_.get("tlbBpList__new_mr"))this._tlbitms_.get("tlbBpList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("bp").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbBpList__edit_sr")) this._tlbitms_.get("tlbBpList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbBpList__copy_sr")) this._tlbitms_.get("tlbBpList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbBpList__delete_selected_sr")) this._tlbitms_.get("tlbBpList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbBpList__edit_sr")) this._tlbitms_.get("tlbBpList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbBpList__copy_sr")) this._tlbitms_.get("tlbBpList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbBpList__delete_selected_sr")) this._tlbitms_.get("tlbBpList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbBpEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("bp")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbBpEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpEdit-back_sr"
		this._tlbitms_.add("tlbBpEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bp").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbBpEdit-save"
		this._tlbitms_.add("tlbBpEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("bp").doNew(); this._invokeTlbItem_("tlbBpEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbBpEdit-new_sr"
		this._tlbitms_.add("tlbBpEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bp").doCopy(); this._invokeTlbItem_("tlbBpEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbBpEdit-copy_sr"
		this._tlbitms_.add("tlbBpEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("bp").getCurrentRecord().phantom) {this._getDc_("bp").discardChanges();this._invokeTlbItem_("tlbBpEdit__back_sr");} else  {this._getDc_("bp").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpEdit-rollback_sr"
		this._tlbitms_.add("tlbBpEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("bp").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpEdit-prev_rec_sr"
		this._tlbitms_.add("tlbBpEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("bp").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbBpEdit-next_rec_sr"
		this._tlbitms_.add("tlbBpEdit___S00_", "-") ;
		this._tlbitms_.add("tlbBpEdit___S01_", "-") ;
		this._tlbitms_.add("tlbBpEdit___TITLE_",  {xtype:"tbtext", text:"BusinessPartner"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbBpEdit__") != -1); } )
		this._tlbs_.add("tlbBpEdit" , t.getRange() );
	


			this._getDc_("bp").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbBpEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("bp").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbBpEdit__load")) this._tlbitms_.get("tlbBpEdit__load").enable();
                 if(this._tlbitms_.get("tlbBpEdit__new_sr"))this._tlbitms_.get("tlbBpEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbBpEdit__new_mr"))this._tlbitms_.get("tlbBpEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("bp").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbBpEdit__back_sr")) this._tlbitms_.get("tlbBpEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbBpEdit__save")) this._tlbitms_.get("tlbBpEdit__save").enable();
                    if(this._tlbitms_.get("tlbBpEdit__new_sr")) this._tlbitms_.get("tlbBpEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbBpEdit__copy_sr")) this._tlbitms_.get("tlbBpEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbBpEdit__rollback_record_sr")) this._tlbitms_.get("tlbBpEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbBpEdit__rollback_sr")) this._tlbitms_.get("tlbBpEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbBpEdit__prev_rec_sr")) this._tlbitms_.get("tlbBpEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbBpEdit__next_rec_sr")) this._tlbitms_.get("tlbBpEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("bp").on("cleanRecord" , function() {
		  		  if (this._getDc_("bp").isDirty() ) {
                    if(this._tlbitms_.get("tlbBpEdit__back_sr")) this._tlbitms_.get("tlbBpEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbBpEdit__save")) this._tlbitms_.get("tlbBpEdit__save").enable();
                    if(this._tlbitms_.get("tlbBpEdit__new_sr")) this._tlbitms_.get("tlbBpEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbBpEdit__copy_sr")) this._tlbitms_.get("tlbBpEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbBpEdit__rollback_record_sr")) this._tlbitms_.get("tlbBpEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbBpEdit__rollback_sr")) this._tlbitms_.get("tlbBpEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbBpEdit__prev_rec_sr")) this._tlbitms_.get("tlbBpEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbBpEdit__next_rec_sr")) this._tlbitms_.get("tlbBpEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbBpEdit__back_sr")) this._tlbitms_.get("tlbBpEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbBpEdit__save")) this._tlbitms_.get("tlbBpEdit__save").disable();
                  	if(this._tlbitms_.get("tlbBpEdit__new_sr")) this._tlbitms_.get("tlbBpEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbBpEdit__copy_sr")) this._tlbitms_.get("tlbBpEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbBpEdit__rollback_record_sr")) this._tlbitms_.get("tlbBpEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbBpEdit__rollback_sr")) this._tlbitms_.get("tlbBpEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbBpEdit__prev_rec_sr")) this._tlbitms_.get("tlbBpEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbBpEdit__next_rec_sr")) this._tlbitms_.get("tlbBpEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("bp").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbBpEdit__copy_sr")) this._tlbitms_.get("tlbBpEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbBpContactList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("bpContact").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpContactList-load"
		this._tlbitms_.add("tlbBpContactList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bpContact").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbBpContactList-save_mr"
		this._tlbitms_.add("tlbBpContactList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("bpContact").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpContactList-new_mr"
		this._tlbitms_.add("tlbBpContactList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bpContact").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpContactList-copy_mr"
		this._tlbitms_.add("tlbBpContactList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bpContact").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpContactList-delete_mr"
		this._tlbitms_.add("tlbBpContactList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("bpContact").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpContactList-rollback_mr"
		this._tlbitms_.add("tlbBpContactList___S00_", "-") ;
		this._tlbitms_.add("tlbBpContactList___S01_", "-") ;
		this._tlbitms_.add("tlbBpContactList___TITLE_",  {xtype:"tbtext", text:"Contact"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbBpContactList__") != -1); } )
		this._tlbs_.add("tlbBpContactList" , t.getRange() );
	


			this._getDc_("bpContact").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbBpContactList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("bpContact").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbBpContactList__load")) this._tlbitms_.get("tlbBpContactList__load").enable();
                 if(this._tlbitms_.get("tlbBpContactList__new_sr"))this._tlbitms_.get("tlbBpContactList__new_sr").enable();
                 if(this._tlbitms_.get("tlbBpContactList__new_mr"))this._tlbitms_.get("tlbBpContactList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("bpContact").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbBpContactList__copy_mr")) this._tlbitms_.get("tlbBpContactList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbBpContactList__delete_mr")) this._tlbitms_.get("tlbBpContactList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbBpContactList__copy_mr")) this._tlbitms_.get("tlbBpContactList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbBpContactList__delete_mr")) this._tlbitms_.get("tlbBpContactList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("bpContact").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbBpContactList__load")) this._tlbitms_.get("tlbBpContactList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbBpContactList__save_mr")) this._tlbitms_.get("tlbBpContactList__save_mr").enable();
                    if(this._tlbitms_.get("tlbBpContactList__rollback_record_mr"))this._tlbitms_.get("tlbBpContactList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbBpContactList__rollback_mr"))this._tlbitms_.get("tlbBpContactList__rollback_mr").enable();
			  } , this );

			this._getDc_("bpContact").on("cleanRecord" , function() {
		  		  if (this._getDc_("bpContact").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbBpContactList__load")) this._tlbitms_.get("tlbBpContactList__load").disable();	                
                    if(this._tlbitms_.get("tlbBpContactList__save_mr"))this._tlbitms_.get("tlbBpContactList__save_mr").enable();
                    if(this._tlbitms_.get("tlbBpContactList__rollback_record_mr"))this._tlbitms_.get("tlbBpContactList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbBpContactList__rollback_mr"))this._tlbitms_.get("tlbBpContactList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbBpContactList__load")) this._tlbitms_.get("tlbBpContactList__load").enable();	
                  	if(this._tlbitms_.get("tlbBpContactList__back_mr"))this._tlbitms_.get("tlbBpContactList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbBpContactList__save_mr"))this._tlbitms_.get("tlbBpContactList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbBpContactList__rollback_record_mr"))this._tlbitms_.get("tlbBpContactList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbBpContactList__rollback_mr"))this._tlbitms_.get("tlbBpContactList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbAddressList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("address").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAddressList-load"
		this._tlbitms_.add("tlbAddressList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("address")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbAddressList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAddressList-edit_sr"
		this._tlbitms_.add("tlbAddressList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("address").doNew(); this._invokeTlbItem_("tlbAddressList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressList-new_sr"
		this._tlbitms_.add("tlbAddressList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("address").doCopy(); this._invokeTlbItem_("tlbAddressList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressList-copy_sr"
		this._tlbitms_.add("tlbAddressList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("address").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressList-delete_selected_sr"
		this._tlbitms_.add("tlbAddressList___S00_", "-") ;
		this._tlbitms_.add("tlbAddressList___S01_", "-") ;
		this._tlbitms_.add("tlbAddressList___TITLE_",  {xtype:"tbtext", text:"Location"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbAddressList__") != -1); } )
		this._tlbs_.add("tlbAddressList" , t.getRange() );

		this._getDc_("address").on("onEdit", function() {this._invokeTlbItem_("tlbAddressList__edit_sr");} , this);

	


			this._getDc_("address").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbAddressList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("address").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbAddressList__load")) this._tlbitms_.get("tlbAddressList__load").enable();
                 if(this._tlbitms_.get("tlbAddressList__new_sr"))this._tlbitms_.get("tlbAddressList__new_sr").enable();
                 if(this._tlbitms_.get("tlbAddressList__new_mr"))this._tlbitms_.get("tlbAddressList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("address").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbAddressList__edit_sr")) this._tlbitms_.get("tlbAddressList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbAddressList__copy_sr")) this._tlbitms_.get("tlbAddressList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbAddressList__delete_selected_sr")) this._tlbitms_.get("tlbAddressList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbAddressList__edit_sr")) this._tlbitms_.get("tlbAddressList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbAddressList__copy_sr")) this._tlbitms_.get("tlbAddressList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbAddressList__delete_selected_sr")) this._tlbitms_.get("tlbAddressList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbAddressEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("address")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbAddressEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAddressEdit-back_sr"
		this._tlbitms_.add("tlbAddressEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("address").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressEdit-save"
		this._tlbitms_.add("tlbAddressEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("address").doNew(); this._invokeTlbItem_("tlbAddressEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressEdit-new_sr"
		this._tlbitms_.add("tlbAddressEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("address").doCopy(); this._invokeTlbItem_("tlbAddressEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressEdit-copy_sr"
		this._tlbitms_.add("tlbAddressEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("address").getCurrentRecord().phantom) {this._getDc_("address").discardChanges();this._invokeTlbItem_("tlbAddressEdit__back_sr");} else  {this._getDc_("address").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAddressEdit-rollback_sr"
		this._tlbitms_.add("tlbAddressEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("address").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAddressEdit-prev_rec_sr"
		this._tlbitms_.add("tlbAddressEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("address").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAddressEdit-next_rec_sr"
		this._tlbitms_.add("tlbAddressEdit___S00_", "-") ;
		this._tlbitms_.add("tlbAddressEdit___S01_", "-") ;
		this._tlbitms_.add("tlbAddressEdit___TITLE_",  {xtype:"tbtext", text:"Location"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbAddressEdit__") != -1); } )
		this._tlbs_.add("tlbAddressEdit" , t.getRange() );
	


			this._getDc_("address").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbAddressEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("address").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbAddressEdit__load")) this._tlbitms_.get("tlbAddressEdit__load").enable();
                 if(this._tlbitms_.get("tlbAddressEdit__new_sr"))this._tlbitms_.get("tlbAddressEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbAddressEdit__new_mr"))this._tlbitms_.get("tlbAddressEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("address").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbAddressEdit__back_sr")) this._tlbitms_.get("tlbAddressEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__save")) this._tlbitms_.get("tlbAddressEdit__save").enable();
                    if(this._tlbitms_.get("tlbAddressEdit__new_sr")) this._tlbitms_.get("tlbAddressEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__copy_sr")) this._tlbitms_.get("tlbAddressEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__rollback_record_sr")) this._tlbitms_.get("tlbAddressEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbAddressEdit__rollback_sr")) this._tlbitms_.get("tlbAddressEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbAddressEdit__prev_rec_sr")) this._tlbitms_.get("tlbAddressEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__next_rec_sr")) this._tlbitms_.get("tlbAddressEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("address").on("cleanRecord" , function() {
		  		  if (this._getDc_("address").isDirty() ) {
                    if(this._tlbitms_.get("tlbAddressEdit__back_sr")) this._tlbitms_.get("tlbAddressEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__save")) this._tlbitms_.get("tlbAddressEdit__save").enable();
                    if(this._tlbitms_.get("tlbAddressEdit__new_sr")) this._tlbitms_.get("tlbAddressEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__copy_sr")) this._tlbitms_.get("tlbAddressEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__rollback_record_sr")) this._tlbitms_.get("tlbAddressEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbAddressEdit__rollback_sr")) this._tlbitms_.get("tlbAddressEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbAddressEdit__prev_rec_sr")) this._tlbitms_.get("tlbAddressEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbAddressEdit__next_rec_sr")) this._tlbitms_.get("tlbAddressEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbAddressEdit__back_sr")) this._tlbitms_.get("tlbAddressEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbAddressEdit__save")) this._tlbitms_.get("tlbAddressEdit__save").disable();
                  	if(this._tlbitms_.get("tlbAddressEdit__new_sr")) this._tlbitms_.get("tlbAddressEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbAddressEdit__copy_sr")) this._tlbitms_.get("tlbAddressEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbAddressEdit__rollback_record_sr")) this._tlbitms_.get("tlbAddressEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbAddressEdit__rollback_sr")) this._tlbitms_.get("tlbAddressEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbAddressEdit__prev_rec_sr")) this._tlbitms_.get("tlbAddressEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbAddressEdit__next_rec_sr")) this._tlbitms_.get("tlbAddressEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("address").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbAddressEdit__copy_sr")) this._tlbitms_.get("tlbAddressEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbBpBankAccountList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("bpBankAcct").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpBankAccountList-load"
		this._tlbitms_.add("tlbBpBankAccountList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bpBankAcct").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbBpBankAccountList-save_mr"
		this._tlbitms_.add("tlbBpBankAccountList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("bpBankAcct").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpBankAccountList-new_mr"
		this._tlbitms_.add("tlbBpBankAccountList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bpBankAcct").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpBankAccountList-copy_mr"
		this._tlbitms_.add("tlbBpBankAccountList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bpBankAcct").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpBankAccountList-delete_mr"
		this._tlbitms_.add("tlbBpBankAccountList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("bpBankAcct").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpBankAccountList-rollback_mr"
		this._tlbitms_.add("tlbBpBankAccountList___S00_", "-") ;
		this._tlbitms_.add("tlbBpBankAccountList___S01_", "-") ;
		this._tlbitms_.add("tlbBpBankAccountList___TITLE_",  {xtype:"tbtext", text:"BpBankAccount"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbBpBankAccountList__") != -1); } )
		this._tlbs_.add("tlbBpBankAccountList" , t.getRange() );
	


			this._getDc_("bpBankAcct").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbBpBankAccountList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("bpBankAcct").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbBpBankAccountList__load")) this._tlbitms_.get("tlbBpBankAccountList__load").enable();
                 if(this._tlbitms_.get("tlbBpBankAccountList__new_sr"))this._tlbitms_.get("tlbBpBankAccountList__new_sr").enable();
                 if(this._tlbitms_.get("tlbBpBankAccountList__new_mr"))this._tlbitms_.get("tlbBpBankAccountList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("bpBankAcct").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbBpBankAccountList__copy_mr")) this._tlbitms_.get("tlbBpBankAccountList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbBpBankAccountList__delete_mr")) this._tlbitms_.get("tlbBpBankAccountList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbBpBankAccountList__copy_mr")) this._tlbitms_.get("tlbBpBankAccountList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbBpBankAccountList__delete_mr")) this._tlbitms_.get("tlbBpBankAccountList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("bpBankAcct").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbBpBankAccountList__load")) this._tlbitms_.get("tlbBpBankAccountList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbBpBankAccountList__save_mr")) this._tlbitms_.get("tlbBpBankAccountList__save_mr").enable();
                    if(this._tlbitms_.get("tlbBpBankAccountList__rollback_record_mr"))this._tlbitms_.get("tlbBpBankAccountList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbBpBankAccountList__rollback_mr"))this._tlbitms_.get("tlbBpBankAccountList__rollback_mr").enable();
			  } , this );

			this._getDc_("bpBankAcct").on("cleanRecord" , function() {
		  		  if (this._getDc_("bpBankAcct").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbBpBankAccountList__load")) this._tlbitms_.get("tlbBpBankAccountList__load").disable();	                
                    if(this._tlbitms_.get("tlbBpBankAccountList__save_mr"))this._tlbitms_.get("tlbBpBankAccountList__save_mr").enable();
                    if(this._tlbitms_.get("tlbBpBankAccountList__rollback_record_mr"))this._tlbitms_.get("tlbBpBankAccountList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbBpBankAccountList__rollback_mr"))this._tlbitms_.get("tlbBpBankAccountList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbBpBankAccountList__load")) this._tlbitms_.get("tlbBpBankAccountList__load").enable();	
                  	if(this._tlbitms_.get("tlbBpBankAccountList__back_mr"))this._tlbitms_.get("tlbBpBankAccountList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbBpBankAccountList__save_mr"))this._tlbitms_.get("tlbBpBankAccountList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbBpBankAccountList__rollback_record_mr"))this._tlbitms_.get("tlbBpBankAccountList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbBpBankAccountList__rollback_mr"))this._tlbitms_.get("tlbBpBankAccountList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbBpPhoneNumber__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("bpPhone").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpPhoneNumber-load"
		this._tlbitms_.add("tlbBpPhoneNumber__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bpPhone").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbBpPhoneNumber-save_mr"
		this._tlbitms_.add("tlbBpPhoneNumber__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("bpPhone").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpPhoneNumber-new_mr"
		this._tlbitms_.add("tlbBpPhoneNumber__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bpPhone").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpPhoneNumber-copy_mr"
		this._tlbitms_.add("tlbBpPhoneNumber__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bpPhone").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpPhoneNumber-delete_mr"
		this._tlbitms_.add("tlbBpPhoneNumber__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("bpPhone").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbBpPhoneNumber-rollback_mr"
		this._tlbitms_.add("tlbBpPhoneNumber___S00_", "-") ;
		this._tlbitms_.add("tlbBpPhoneNumber___S01_", "-") ;
		this._tlbitms_.add("tlbBpPhoneNumber___TITLE_",  {xtype:"tbtext", text:"CommunicationChannel"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbBpPhoneNumber__") != -1); } )
		this._tlbs_.add("tlbBpPhoneNumber" , t.getRange() );
	


			this._getDc_("bpPhone").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbBpPhoneNumber__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("bpPhone").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbBpPhoneNumber__load")) this._tlbitms_.get("tlbBpPhoneNumber__load").enable();
                 if(this._tlbitms_.get("tlbBpPhoneNumber__new_sr"))this._tlbitms_.get("tlbBpPhoneNumber__new_sr").enable();
                 if(this._tlbitms_.get("tlbBpPhoneNumber__new_mr"))this._tlbitms_.get("tlbBpPhoneNumber__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("bpPhone").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbBpPhoneNumber__copy_mr")) this._tlbitms_.get("tlbBpPhoneNumber__copy_mr").enable();
                        if(this._tlbitms_.get("tlbBpPhoneNumber__delete_mr")) this._tlbitms_.get("tlbBpPhoneNumber__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbBpPhoneNumber__copy_mr")) this._tlbitms_.get("tlbBpPhoneNumber__copy_mr").disable();
                       if(this._tlbitms_.get("tlbBpPhoneNumber__delete_mr")) this._tlbitms_.get("tlbBpPhoneNumber__delete_mr").disable();
					}

			  } , this );
			this._getDc_("bpPhone").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbBpPhoneNumber__load")) this._tlbitms_.get("tlbBpPhoneNumber__load").disable();		  			 
                    if(this._tlbitms_.get("tlbBpPhoneNumber__save_mr")) this._tlbitms_.get("tlbBpPhoneNumber__save_mr").enable();
                    if(this._tlbitms_.get("tlbBpPhoneNumber__rollback_record_mr"))this._tlbitms_.get("tlbBpPhoneNumber__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbBpPhoneNumber__rollback_mr"))this._tlbitms_.get("tlbBpPhoneNumber__rollback_mr").enable();
			  } , this );

			this._getDc_("bpPhone").on("cleanRecord" , function() {
		  		  if (this._getDc_("bpPhone").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbBpPhoneNumber__load")) this._tlbitms_.get("tlbBpPhoneNumber__load").disable();	                
                    if(this._tlbitms_.get("tlbBpPhoneNumber__save_mr"))this._tlbitms_.get("tlbBpPhoneNumber__save_mr").enable();
                    if(this._tlbitms_.get("tlbBpPhoneNumber__rollback_record_mr"))this._tlbitms_.get("tlbBpPhoneNumber__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbBpPhoneNumber__rollback_mr"))this._tlbitms_.get("tlbBpPhoneNumber__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbBpPhoneNumber__load")) this._tlbitms_.get("tlbBpPhoneNumber__load").enable();	
                  	if(this._tlbitms_.get("tlbBpPhoneNumber__back_mr"))this._tlbitms_.get("tlbBpPhoneNumber__back_mr").enable();
                  	if(this._tlbitms_.get("tlbBpPhoneNumber__save_mr"))this._tlbitms_.get("tlbBpPhoneNumber__save_mr").disable();
                  	if(this._tlbitms_.get("tlbBpPhoneNumber__rollback_record_mr"))this._tlbitms_.get("tlbBpPhoneNumber__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbBpPhoneNumber__rollback_mr"))this._tlbitms_.get("tlbBpPhoneNumber__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("bp").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("bpEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("bpContact").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("address").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("addressEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("bpBankAcct").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("bpPhone").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.bp.md.frame.BPartner_UI", net.nan21.dnet.module.bp.md.frame.BPartner_UI);   
