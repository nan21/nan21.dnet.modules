 
Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/UserDs", "nan21.dnet.module.ad.ui.extjs/dc/User"]);

Ext.ns("net.nan21.dnet.module.ad.usr.frame");
net.nan21.dnet.module.ad.usr.frame.Users_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.Users_UI"
	
	,_defineDcs_: function () {	
		var  usr = new net.nan21.dnet.module.ad.usr.dc.User({multiEdit:false});	 	
		
		this._dcs_.add("usr", usr);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
			this._elems_.add("btnAsgnRoles", { xtype:"button", name:"btnAsgnRoles", id:Ext.id() 
					,text:"Roles", tooltip:"Assign roles"
					,disabled:true
					,handler: function() {

			var iid = Ext.id();
			var wdwConfig = {
				layout:"fit"
				,items:[{xtype:"tAsgnUserRoles", id:iid, _objectId_: objectId}]
				,title:"Assign roles to user"
				//,width:700
				//,height:400
				,closable:true, modal:true
			}
			var objectId = this._dcs_.get("usr").record["id"];
			var aw=new Ext.Window(wdwConfig);
			aw.show();
			Ext.getCmp(iid)._controller_.params.objectId = objectId ;
			Ext.getCmp(iid)._controller_.initAssignement();				 	

 
}					 	
 ,scope:this });	
			this._getDc_("usr").on("recordChanged", function(evnt) {
		 	       if ((evnt.state=='clean') ) { var btn = this._getElement_("btnAsgnRoles"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnAsgnRoles");if(btn) btn.disable();  }
			 }, this );					 	
			this._elems_.add("btnAsgnGroups", { xtype:"button", name:"btnAsgnGroups", id:Ext.id() 
					,text:"Groups", tooltip:"Add to user-groups"
					,disabled:true
					,handler: function() {

			var iid = Ext.id();
			var wdwConfig = {
				layout:"fit"
				,items:[{xtype:"tAsgnUserUserGroups", id:iid, _objectId_: objectId}]
				,title:"Assign groups to user"
				//,width:700
				//,height:400
				,closable:true, modal:true
			}
			var objectId = this._dcs_.get("usr").record["id"];
			var aw=new Ext.Window(wdwConfig);
			aw.show();
			Ext.getCmp(iid)._controller_.params.objectId = objectId ;
			Ext.getCmp(iid)._controller_.initAssignement();				 	

 
}					 	
 ,scope:this });	
			this._getDc_("usr").on("recordChanged", function(evnt) {
		 	       if ((evnt.state=='clean') ) { var btn = this._getElement_("btnAsgnGroups"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnAsgnGroups");if(btn) btn.disable();  }
			 }, this );					 	
		this._elems_.add("usrFilter", { xtype:"net.nan21.dnet.module.ad.usr.dc.User$Filter", id:Ext.id(), _controller_:this._dcs_.get("usr") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("usrList", { xtype:"net.nan21.dnet.module.ad.usr.dc.User$List", id:Ext.id(), _controller_:this._dcs_.get("usr") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("usrEdit", { xtype:"net.nan21.dnet.module.ad.usr.dc.User$Edit", id:Ext.id(), _controller_:this._dcs_.get("usr"),buttons:[ this._elems_.get("btnAsgnRoles") ,this._elems_.get("btnAsgnGroups") ] ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("usr").isRecordValid = this._dcs_.get("usr").isRecordValid.createInterceptor(function() { return this._getElement_("usrEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("usrFilter")["region"] = "north";			
			this._elems_.get("usrList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("usrFilter") , this._elems_.get("usrList") ]; 				 		
 
			this._elems_.get("usrEdit")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("usrEdit") ]; 				 		
	 	this._linkToolbar_("tlbUsrList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbUsrEdit", "canvas2");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbUsrList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("usr").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbUsrList-load"
		this._tlbitms_.add("tlbUsrList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("usr")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbUsrList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbUsrList-edit_sr"
		this._tlbitms_.add("tlbUsrList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("usr").doNew(); this._invokeTlbItem_("tlbUsrList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUsrList-new_sr"
		this._tlbitms_.add("tlbUsrList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("usr").doCopy(); this._invokeTlbItem_("tlbUsrList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUsrList-copy_sr"
		this._tlbitms_.add("tlbUsrList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("usr").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUsrList-delete_selected_sr"
		this._tlbitms_.add("tlbUsrList___S00_", "-") ;
		this._tlbitms_.add("tlbUsrList___S01_", "-") ;
		this._tlbitms_.add("tlbUsrList___TITLE_",  {xtype:"tbtext", text:"User"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbUsrList__") != -1); } )
		this._tlbs_.add("tlbUsrList" , t.getRange() );

		this._getDc_("usr").on("onEdit", function() {this._invokeTlbItem_("tlbUsrList__edit_sr");} , this);

	


			this._getDc_("usr").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbUsrList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("usr").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbUsrList__load")) this._tlbitms_.get("tlbUsrList__load").enable();
                 if(this._tlbitms_.get("tlbUsrList__new_sr"))this._tlbitms_.get("tlbUsrList__new_sr").enable();
                 if(this._tlbitms_.get("tlbUsrList__new_mr"))this._tlbitms_.get("tlbUsrList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("usr").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbUsrList__edit_sr")) this._tlbitms_.get("tlbUsrList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbUsrList__copy_sr")) this._tlbitms_.get("tlbUsrList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbUsrList__delete_selected_sr")) this._tlbitms_.get("tlbUsrList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbUsrList__edit_sr")) this._tlbitms_.get("tlbUsrList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbUsrList__copy_sr")) this._tlbitms_.get("tlbUsrList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbUsrList__delete_selected_sr")) this._tlbitms_.get("tlbUsrList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbUsrEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("usr")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbUsrEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbUsrEdit-back_sr"
		this._tlbitms_.add("tlbUsrEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("usr").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUsrEdit-save"
		this._tlbitms_.add("tlbUsrEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("usr").doNew(); this._invokeTlbItem_("tlbUsrEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUsrEdit-new_sr"
		this._tlbitms_.add("tlbUsrEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("usr").doCopy(); this._invokeTlbItem_("tlbUsrEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUsrEdit-copy_sr"
		this._tlbitms_.add("tlbUsrEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("usr").getCurrentRecord().phantom) {this._getDc_("usr").discardChanges();this._invokeTlbItem_("tlbUsrEdit__back_sr");} else  {this._getDc_("usr").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbUsrEdit-rollback_sr"
		this._tlbitms_.add("tlbUsrEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("usr").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbUsrEdit-prev_rec_sr"
		this._tlbitms_.add("tlbUsrEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("usr").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUsrEdit-next_rec_sr"
		this._tlbitms_.add("tlbUsrEdit___S00_", "-") ;
		this._tlbitms_.add("tlbUsrEdit___S01_", "-") ;
		this._tlbitms_.add("tlbUsrEdit___TITLE_",  {xtype:"tbtext", text:"User"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbUsrEdit__") != -1); } )
		this._tlbs_.add("tlbUsrEdit" , t.getRange() );
	


			this._getDc_("usr").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbUsrEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("usr").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbUsrEdit__load")) this._tlbitms_.get("tlbUsrEdit__load").enable();
                 if(this._tlbitms_.get("tlbUsrEdit__new_sr"))this._tlbitms_.get("tlbUsrEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbUsrEdit__new_mr"))this._tlbitms_.get("tlbUsrEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("usr").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbUsrEdit__back_sr")) this._tlbitms_.get("tlbUsrEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbUsrEdit__save")) this._tlbitms_.get("tlbUsrEdit__save").enable();
                    if(this._tlbitms_.get("tlbUsrEdit__new_sr")) this._tlbitms_.get("tlbUsrEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbUsrEdit__copy_sr")) this._tlbitms_.get("tlbUsrEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbUsrEdit__rollback_record_sr")) this._tlbitms_.get("tlbUsrEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbUsrEdit__rollback_sr")) this._tlbitms_.get("tlbUsrEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbUsrEdit__prev_rec_sr")) this._tlbitms_.get("tlbUsrEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbUsrEdit__next_rec_sr")) this._tlbitms_.get("tlbUsrEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("usr").on("cleanRecord" , function() {
		  		  if (this._getDc_("usr").isDirty() ) {
                    if(this._tlbitms_.get("tlbUsrEdit__back_sr")) this._tlbitms_.get("tlbUsrEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbUsrEdit__save")) this._tlbitms_.get("tlbUsrEdit__save").enable();
                    if(this._tlbitms_.get("tlbUsrEdit__new_sr")) this._tlbitms_.get("tlbUsrEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbUsrEdit__copy_sr")) this._tlbitms_.get("tlbUsrEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbUsrEdit__rollback_record_sr")) this._tlbitms_.get("tlbUsrEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbUsrEdit__rollback_sr")) this._tlbitms_.get("tlbUsrEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbUsrEdit__prev_rec_sr")) this._tlbitms_.get("tlbUsrEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbUsrEdit__next_rec_sr")) this._tlbitms_.get("tlbUsrEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbUsrEdit__back_sr")) this._tlbitms_.get("tlbUsrEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbUsrEdit__save")) this._tlbitms_.get("tlbUsrEdit__save").disable();
                  	if(this._tlbitms_.get("tlbUsrEdit__new_sr")) this._tlbitms_.get("tlbUsrEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbUsrEdit__copy_sr")) this._tlbitms_.get("tlbUsrEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbUsrEdit__rollback_record_sr")) this._tlbitms_.get("tlbUsrEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbUsrEdit__rollback_sr")) this._tlbitms_.get("tlbUsrEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbUsrEdit__prev_rec_sr")) this._tlbitms_.get("tlbUsrEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbUsrEdit__next_rec_sr")) this._tlbitms_.get("tlbUsrEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("usr").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbUsrEdit__copy_sr")) this._tlbitms_.get("tlbUsrEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("usr").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("usrEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.ad.usr.frame.Users_UI", net.nan21.dnet.module.ad.usr.frame.Users_UI);   
