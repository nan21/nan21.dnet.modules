 
Dnet.import(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoice", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceItemDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoiceItem","nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceStatusLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesInvoiceStatus","nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceTypeLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesInvoiceType","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/LocationToBillLovDs","nan21.dnet.module.bd.ui.extjs/lov/LocationsToBill","nan21.dnet.module.bp.ui.extjs/ds/BpContactLovDs","nan21.dnet.module.bp.ui.extjs/lov/BpContacts","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/Customers","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/Customers","nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceStatusLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesInvoiceStatus","nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceTypeLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesInvoiceType","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure"]);

Ext.ns("net.nan21.dnet.module.sd.invoice.frame");
net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI"
	
	,_defineDcs_: function () {	
		var  inv = new net.nan21.dnet.module.sd.invoice.dc.SalesInvoice({multiEdit:false}), item = new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem({multiEdit:true});	 	
		
		this._dcs_.add("inv", inv);			
		item.setDcContext(new dnet.base.DcContext({childDc:item, parentDc:inv, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"invoiceId", parentField:"id"} ]}}));inv.addChild(item);
		this._dcs_.add("item", item);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("invFilter", { xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter", id:Ext.id(), _controller_:this._dcs_.get("inv") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("invList", { xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List", id:Ext.id(), _controller_:this._dcs_.get("inv") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("invEdit", { xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Edit", id:Ext.id(), _controller_:this._dcs_.get("inv"),height:150 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("inv").isRecordValid = this._dcs_.get("inv").isRecordValid.createInterceptor(function() { return this._getElement_("invEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("itemEditList", { xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("item") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("invFilter")["region"] = "north";			
			this._elems_.get("invList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("invFilter") , this._elems_.get("invList") ]; 				 		
 
			this._elems_.get("invEdit")["region"] = "north";			
			this._elems_.get("itemEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("invEdit") , this._elems_.get("itemEditList") ]; 				 		
	 	this._linkToolbar_("tlbInvList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbInvEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbItemEditList", "itemEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbInvList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("inv").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvList-load"
		this._tlbitms_.add("tlbInvList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("inv")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbInvList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvList-edit_sr"
		this._tlbitms_.add("tlbInvList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("inv").doNew(); this._invokeTlbItem_("tlbInvList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbInvList-new_sr"
		this._tlbitms_.add("tlbInvList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("inv").doCopy(); this._invokeTlbItem_("tlbInvList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbInvList-copy_sr"
		this._tlbitms_.add("tlbInvList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("inv").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbInvList-delete_selected_sr"
		this._tlbitms_.add("tlbInvList___S00_", "-") ;
		this._tlbitms_.add("tlbInvList___S01_", "-") ;
		this._tlbitms_.add("tlbInvList___TITLE_",  {xtype:"tbtext", text:"SalesInvoice"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbInvList__") != -1); } )
		this._tlbs_.add("tlbInvList" , t.getRange() );

		this._getDc_("inv").on("onEdit", function() {this._invokeTlbItem_("tlbInvList__edit_sr");} , this);

	


			this._getDc_("inv").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbInvList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("inv").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbInvList__load")) this._tlbitms_.get("tlbInvList__load").enable();
                 if(this._tlbitms_.get("tlbInvList__new_sr"))this._tlbitms_.get("tlbInvList__new_sr").enable();
                 if(this._tlbitms_.get("tlbInvList__new_mr"))this._tlbitms_.get("tlbInvList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("inv").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbInvList__edit_sr")) this._tlbitms_.get("tlbInvList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbInvList__copy_sr")) this._tlbitms_.get("tlbInvList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbInvList__delete_selected_sr")) this._tlbitms_.get("tlbInvList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbInvList__edit_sr")) this._tlbitms_.get("tlbInvList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbInvList__copy_sr")) this._tlbitms_.get("tlbInvList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbInvList__delete_selected_sr")) this._tlbitms_.get("tlbInvList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbInvEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("inv")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbInvEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvEdit-back_sr"
		this._tlbitms_.add("tlbInvEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("inv").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbInvEdit-save"
		this._tlbitms_.add("tlbInvEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("inv").doNew(); this._invokeTlbItem_("tlbInvEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbInvEdit-new_sr"
		this._tlbitms_.add("tlbInvEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("inv").doCopy(); this._invokeTlbItem_("tlbInvEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbInvEdit-copy_sr"
		this._tlbitms_.add("tlbInvEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("inv").getCurrentRecord().phantom) {this._getDc_("inv").discardChanges();this._invokeTlbItem_("tlbInvEdit__back_sr");} else  {this._getDc_("inv").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvEdit-rollback_sr"
		this._tlbitms_.add("tlbInvEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("inv").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvEdit-prev_rec_sr"
		this._tlbitms_.add("tlbInvEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("inv").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbInvEdit-next_rec_sr"
		this._tlbitms_.add("tlbInvEdit___S00_", "-") ;
		this._tlbitms_.add("tlbInvEdit___S01_", "-") ;
		this._tlbitms_.add("tlbInvEdit___TITLE_",  {xtype:"tbtext", text:"SalesInvoice"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbInvEdit__") != -1); } )
		this._tlbs_.add("tlbInvEdit" , t.getRange() );
	


			this._getDc_("inv").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbInvEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("inv").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbInvEdit__load")) this._tlbitms_.get("tlbInvEdit__load").enable();
                 if(this._tlbitms_.get("tlbInvEdit__new_sr"))this._tlbitms_.get("tlbInvEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbInvEdit__new_mr"))this._tlbitms_.get("tlbInvEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("inv").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbInvEdit__back_sr")) this._tlbitms_.get("tlbInvEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbInvEdit__save")) this._tlbitms_.get("tlbInvEdit__save").enable();
                    if(this._tlbitms_.get("tlbInvEdit__new_sr")) this._tlbitms_.get("tlbInvEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbInvEdit__copy_sr")) this._tlbitms_.get("tlbInvEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbInvEdit__rollback_record_sr")) this._tlbitms_.get("tlbInvEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbInvEdit__rollback_sr")) this._tlbitms_.get("tlbInvEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbInvEdit__prev_rec_sr")) this._tlbitms_.get("tlbInvEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbInvEdit__next_rec_sr")) this._tlbitms_.get("tlbInvEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("inv").on("cleanRecord" , function() {
		  		  if (this._getDc_("inv").isDirty() ) {
                    if(this._tlbitms_.get("tlbInvEdit__back_sr")) this._tlbitms_.get("tlbInvEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbInvEdit__save")) this._tlbitms_.get("tlbInvEdit__save").enable();
                    if(this._tlbitms_.get("tlbInvEdit__new_sr")) this._tlbitms_.get("tlbInvEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbInvEdit__copy_sr")) this._tlbitms_.get("tlbInvEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbInvEdit__rollback_record_sr")) this._tlbitms_.get("tlbInvEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbInvEdit__rollback_sr")) this._tlbitms_.get("tlbInvEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbInvEdit__prev_rec_sr")) this._tlbitms_.get("tlbInvEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbInvEdit__next_rec_sr")) this._tlbitms_.get("tlbInvEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbInvEdit__back_sr")) this._tlbitms_.get("tlbInvEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbInvEdit__save")) this._tlbitms_.get("tlbInvEdit__save").disable();
                  	if(this._tlbitms_.get("tlbInvEdit__new_sr")) this._tlbitms_.get("tlbInvEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbInvEdit__copy_sr")) this._tlbitms_.get("tlbInvEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbInvEdit__rollback_record_sr")) this._tlbitms_.get("tlbInvEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbInvEdit__rollback_sr")) this._tlbitms_.get("tlbInvEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbInvEdit__prev_rec_sr")) this._tlbitms_.get("tlbInvEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbInvEdit__next_rec_sr")) this._tlbitms_.get("tlbInvEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("inv").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbInvEdit__copy_sr")) this._tlbitms_.get("tlbInvEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbItemEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("item").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-load"
		this._tlbitms_.add("tlbItemEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("item").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbItemEditList-save_mr"
		this._tlbitms_.add("tlbItemEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("item").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-new_mr"
		this._tlbitms_.add("tlbItemEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("item").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-copy_mr"
		this._tlbitms_.add("tlbItemEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("item").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-delete_mr"
		this._tlbitms_.add("tlbItemEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("item").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-rollback_mr"
		this._tlbitms_.add("tlbItemEditList___S00_", "-") ;
		this._tlbitms_.add("tlbItemEditList___S01_", "-") ;
		this._tlbitms_.add("tlbItemEditList___TITLE_",  {xtype:"tbtext", text:"SalesInvoiceItem"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbItemEditList__") != -1); } )
		this._tlbs_.add("tlbItemEditList" , t.getRange() );
	


			this._getDc_("item").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbItemEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("item").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbItemEditList__load")) this._tlbitms_.get("tlbItemEditList__load").enable();
                 if(this._tlbitms_.get("tlbItemEditList__new_sr"))this._tlbitms_.get("tlbItemEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbItemEditList__new_mr"))this._tlbitms_.get("tlbItemEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("item").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbItemEditList__copy_mr")) this._tlbitms_.get("tlbItemEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbItemEditList__delete_mr")) this._tlbitms_.get("tlbItemEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbItemEditList__copy_mr")) this._tlbitms_.get("tlbItemEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbItemEditList__delete_mr")) this._tlbitms_.get("tlbItemEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("item").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbItemEditList__load")) this._tlbitms_.get("tlbItemEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbItemEditList__save_mr")) this._tlbitms_.get("tlbItemEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbItemEditList__rollback_record_mr"))this._tlbitms_.get("tlbItemEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbItemEditList__rollback_mr"))this._tlbitms_.get("tlbItemEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("item").on("cleanRecord" , function() {
		  		  if (this._getDc_("item").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbItemEditList__load")) this._tlbitms_.get("tlbItemEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbItemEditList__save_mr"))this._tlbitms_.get("tlbItemEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbItemEditList__rollback_record_mr"))this._tlbitms_.get("tlbItemEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbItemEditList__rollback_mr"))this._tlbitms_.get("tlbItemEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbItemEditList__load")) this._tlbitms_.get("tlbItemEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbItemEditList__back_mr"))this._tlbitms_.get("tlbItemEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbItemEditList__save_mr"))this._tlbitms_.get("tlbItemEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbItemEditList__rollback_record_mr"))this._tlbitms_.get("tlbItemEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbItemEditList__rollback_mr"))this._tlbitms_.get("tlbItemEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("inv").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("invEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("item").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI", net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI);   
