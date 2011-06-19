 
Dnet.import(["", "nan21.dnet.module.bp.ui.extjs/ds/ContactDs", "nan21.dnet.module.bp.ui.extjs/dc/Contact", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelDs", "nan21.dnet.module.bd.ui.extjs/dc/CommunicationChannel","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/CommunicationChannelTypes"]);

Ext.ns("net.nan21.dnet.module.bp.md.frame");
net.nan21.dnet.module.bp.md.frame.Contact_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bp.md.frame.Contact_UI"
	
	,_defineDcs_: function () {	
		var  c = new net.nan21.dnet.module.bp.md.dc.Contact({multiEdit:false}), communic = new net.nan21.dnet.module.bd.contact.dc.CommunicationChannel({multiEdit:true});	 	
		
		this._dcs_.add("c", c);			
		communic.setDcContext(new dnet.base.DcContext({childDc:communic, parentDc:c, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]}}));c.addChild(communic);
		this._dcs_.add("communic", communic);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("cFilter", { xtype:"net.nan21.dnet.module.bp.md.dc.Contact$Filter", id:Ext.id(), _controller_:this._dcs_.get("c") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("cList", { xtype:"net.nan21.dnet.module.bp.md.dc.Contact$List", id:Ext.id(), _controller_:this._dcs_.get("c") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("cEdit", { xtype:"net.nan21.dnet.module.bp.md.dc.Contact$Edit", id:Ext.id(), _controller_:this._dcs_.get("c"),height:120 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("c").isRecordValid = this._dcs_.get("c").isRecordValid.createInterceptor(function() { return this._getElement_("cEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("communicEditList", { xtype:"net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("communic"),title:"Communication" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });		
		this._elems_.add("bpDetailsTab", {layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()	}  }); 	 
		
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("cFilter")["region"] = "north";			
			this._elems_.get("cList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("cFilter") , this._elems_.get("cList") ]; 				 		
 
			this._elems_.get("cEdit")["region"] = "north";			
			this._elems_.get("bpDetailsTab")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("cEdit") , this._elems_.get("bpDetailsTab") ]; 				 		
 
		this._elems_.get("bpDetailsTab")["items"]["items"] = [ this._elems_.get("communicEditList") ];	
	 	this._linkToolbar_("tlbTList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbTEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbCommunicEditList", "communicEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbTList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("c").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbTList-load"
		this._tlbitms_.add("tlbTList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("c")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbTList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbTList-edit_sr"
		this._tlbitms_.add("tlbTList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("c").doNew(); this._invokeTlbItem_("tlbTList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbTList-new_sr"
		this._tlbitms_.add("tlbTList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("c").doCopy(); this._invokeTlbItem_("tlbTList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbTList-copy_sr"
		this._tlbitms_.add("tlbTList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("c").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbTList-delete_selected_sr"
		this._tlbitms_.add("tlbTList___S00_", "-") ;
		this._tlbitms_.add("tlbTList___S01_", "-") ;
		this._tlbitms_.add("tlbTList___TITLE_",  {xtype:"tbtext", text:"Contact"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbTList__") != -1); } )
		this._tlbs_.add("tlbTList" , t.getRange() );

		this._getDc_("c").on("onEdit", function() {this._invokeTlbItem_("tlbTList__edit_sr");} , this);

	


			this._getDc_("c").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbTList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("c").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbTList__load")) this._tlbitms_.get("tlbTList__load").enable();
                 if(this._tlbitms_.get("tlbTList__new_sr"))this._tlbitms_.get("tlbTList__new_sr").enable();
                 if(this._tlbitms_.get("tlbTList__new_mr"))this._tlbitms_.get("tlbTList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("c").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbTList__edit_sr")) this._tlbitms_.get("tlbTList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbTList__copy_sr")) this._tlbitms_.get("tlbTList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbTList__delete_selected_sr")) this._tlbitms_.get("tlbTList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbTList__edit_sr")) this._tlbitms_.get("tlbTList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbTList__copy_sr")) this._tlbitms_.get("tlbTList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbTList__delete_selected_sr")) this._tlbitms_.get("tlbTList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbTEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("c")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbTEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbTEdit-back_sr"
		this._tlbitms_.add("tlbTEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("c").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbTEdit-save"
		this._tlbitms_.add("tlbTEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("c").doNew(); this._invokeTlbItem_("tlbTEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbTEdit-new_sr"
		this._tlbitms_.add("tlbTEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("c").doCopy(); this._invokeTlbItem_("tlbTEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbTEdit-copy_sr"
		this._tlbitms_.add("tlbTEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("c").getCurrentRecord().phantom) {this._getDc_("c").discardChanges();this._invokeTlbItem_("tlbTEdit__back_sr");} else  {this._getDc_("c").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbTEdit-rollback_sr"
		this._tlbitms_.add("tlbTEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("c").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbTEdit-prev_rec_sr"
		this._tlbitms_.add("tlbTEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("c").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbTEdit-next_rec_sr"
		this._tlbitms_.add("tlbTEdit___S00_", "-") ;
		this._tlbitms_.add("tlbTEdit___S01_", "-") ;
		this._tlbitms_.add("tlbTEdit___TITLE_",  {xtype:"tbtext", text:"Contact"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbTEdit__") != -1); } )
		this._tlbs_.add("tlbTEdit" , t.getRange() );
	


			this._getDc_("c").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbTEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("c").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbTEdit__load")) this._tlbitms_.get("tlbTEdit__load").enable();
                 if(this._tlbitms_.get("tlbTEdit__new_sr"))this._tlbitms_.get("tlbTEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbTEdit__new_mr"))this._tlbitms_.get("tlbTEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("c").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbTEdit__back_sr")) this._tlbitms_.get("tlbTEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbTEdit__save")) this._tlbitms_.get("tlbTEdit__save").enable();
                    if(this._tlbitms_.get("tlbTEdit__new_sr")) this._tlbitms_.get("tlbTEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbTEdit__copy_sr")) this._tlbitms_.get("tlbTEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbTEdit__rollback_record_sr")) this._tlbitms_.get("tlbTEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbTEdit__rollback_sr")) this._tlbitms_.get("tlbTEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbTEdit__prev_rec_sr")) this._tlbitms_.get("tlbTEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbTEdit__next_rec_sr")) this._tlbitms_.get("tlbTEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("c").on("cleanRecord" , function() {
		  		  if (this._getDc_("c").isDirty() ) {
                    if(this._tlbitms_.get("tlbTEdit__back_sr")) this._tlbitms_.get("tlbTEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbTEdit__save")) this._tlbitms_.get("tlbTEdit__save").enable();
                    if(this._tlbitms_.get("tlbTEdit__new_sr")) this._tlbitms_.get("tlbTEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbTEdit__copy_sr")) this._tlbitms_.get("tlbTEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbTEdit__rollback_record_sr")) this._tlbitms_.get("tlbTEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbTEdit__rollback_sr")) this._tlbitms_.get("tlbTEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbTEdit__prev_rec_sr")) this._tlbitms_.get("tlbTEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbTEdit__next_rec_sr")) this._tlbitms_.get("tlbTEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbTEdit__back_sr")) this._tlbitms_.get("tlbTEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbTEdit__save")) this._tlbitms_.get("tlbTEdit__save").disable();
                  	if(this._tlbitms_.get("tlbTEdit__new_sr")) this._tlbitms_.get("tlbTEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbTEdit__copy_sr")) this._tlbitms_.get("tlbTEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbTEdit__rollback_record_sr")) this._tlbitms_.get("tlbTEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbTEdit__rollback_sr")) this._tlbitms_.get("tlbTEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbTEdit__prev_rec_sr")) this._tlbitms_.get("tlbTEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbTEdit__next_rec_sr")) this._tlbitms_.get("tlbTEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("c").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbTEdit__copy_sr")) this._tlbitms_.get("tlbTEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbCommunicEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("communic").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCommunicEditList-load"
		this._tlbitms_.add("tlbCommunicEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("communic").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCommunicEditList-save_mr"
		this._tlbitms_.add("tlbCommunicEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("communic").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCommunicEditList-new_mr"
		this._tlbitms_.add("tlbCommunicEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("communic").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCommunicEditList-copy_mr"
		this._tlbitms_.add("tlbCommunicEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("communic").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCommunicEditList-delete_mr"
		this._tlbitms_.add("tlbCommunicEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("communic").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCommunicEditList-rollback_mr"
		this._tlbitms_.add("tlbCommunicEditList___S00_", "-") ;
		this._tlbitms_.add("tlbCommunicEditList___S01_", "-") ;
		this._tlbitms_.add("tlbCommunicEditList___TITLE_",  {xtype:"tbtext", text:"CommunicationChannel"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbCommunicEditList__") != -1); } )
		this._tlbs_.add("tlbCommunicEditList" , t.getRange() );
	


			this._getDc_("communic").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbCommunicEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("communic").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbCommunicEditList__load")) this._tlbitms_.get("tlbCommunicEditList__load").enable();
                 if(this._tlbitms_.get("tlbCommunicEditList__new_sr"))this._tlbitms_.get("tlbCommunicEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbCommunicEditList__new_mr"))this._tlbitms_.get("tlbCommunicEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("communic").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbCommunicEditList__copy_mr")) this._tlbitms_.get("tlbCommunicEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbCommunicEditList__delete_mr")) this._tlbitms_.get("tlbCommunicEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbCommunicEditList__copy_mr")) this._tlbitms_.get("tlbCommunicEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbCommunicEditList__delete_mr")) this._tlbitms_.get("tlbCommunicEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("communic").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbCommunicEditList__load")) this._tlbitms_.get("tlbCommunicEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbCommunicEditList__save_mr")) this._tlbitms_.get("tlbCommunicEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCommunicEditList__rollback_record_mr"))this._tlbitms_.get("tlbCommunicEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCommunicEditList__rollback_mr"))this._tlbitms_.get("tlbCommunicEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("communic").on("cleanRecord" , function() {
		  		  if (this._getDc_("communic").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbCommunicEditList__load")) this._tlbitms_.get("tlbCommunicEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbCommunicEditList__save_mr"))this._tlbitms_.get("tlbCommunicEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCommunicEditList__rollback_record_mr"))this._tlbitms_.get("tlbCommunicEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCommunicEditList__rollback_mr"))this._tlbitms_.get("tlbCommunicEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbCommunicEditList__load")) this._tlbitms_.get("tlbCommunicEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbCommunicEditList__back_mr"))this._tlbitms_.get("tlbCommunicEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbCommunicEditList__save_mr"))this._tlbitms_.get("tlbCommunicEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbCommunicEditList__rollback_record_mr"))this._tlbitms_.get("tlbCommunicEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbCommunicEditList__rollback_mr"))this._tlbitms_.get("tlbCommunicEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("c").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("cEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("communic").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.bp.md.frame.Contact_UI", net.nan21.dnet.module.bp.md.frame.Contact_UI);   
