 
Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/UserGroupDs", "nan21.dnet.module.ad.ui.extjs/dc/UserGroup"]);

Ext.ns("net.nan21.dnet.module.ad.usr.frame");
net.nan21.dnet.module.ad.usr.frame.UserGroups_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.UserGroups_UI"
	
	,_defineDcs_: function () {	
		var  dcGroup = new net.nan21.dnet.module.ad.usr.dc.UserGroup({multiEdit:true});	 	
		
		this._dcs_.add("dcGroup", dcGroup);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
			this._elems_.add("btnAsgnUsers", { xtype:"button", name:"btnAsgnUsers", id:Ext.id() 
					,text:"Users in group", tooltip:"Add users to selected group"
					,disabled:true
					,handler: function() {

			var iid = Ext.id();
			var wdwConfig = {
				layout:"fit"
				,items:[{xtype:"tAsgnUserGroupUsers", id:iid, _objectId_: objectId}]
				,title:"Assign users to group"
				//,width:700
				//,height:400
				,closable:true, modal:true
			}
			var objectId = this._dcs_.get("dcGroup").record["id"];
			var aw=new Ext.Window(wdwConfig);
			aw.show();
			Ext.getCmp(iid)._controller_.params.objectId = objectId ;
			Ext.getCmp(iid)._controller_.initAssignement();				 	

 
}					 	
 ,scope:this });	
			this._getDc_("dcGroup").on("selectionChanged", function(evnt) {
		 	       if ((evnt.dc.selectedRecords.length == 1) ) { var btn = this._getElement_("btnAsgnUsers"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnAsgnUsers");if(btn) btn.disable();  }
			 }, this );					 	
		this._elems_.add("filterGroup", { xtype:"net.nan21.dnet.module.ad.usr.dc.UserGroup$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcGroup") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("elistGroup", { xtype:"net.nan21.dnet.module.ad.usr.dc.UserGroup$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("dcGroup"),buttons:[ this._elems_.get("btnAsgnUsers") ] ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") ]; 				 		
 
			this._elems_.get("filterGroup")["region"] = "north";			
			this._elems_.get("elistGroup")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("filterGroup") , this._elems_.get("elistGroup") ]; 				 		
	 	this._linkToolbar_("tlbGroupEditList", "canvas1");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbGroupEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcGroup").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbGroupEditList-load"
		this._tlbitms_.add("tlbGroupEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcGroup").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbGroupEditList-save_mr"
		this._tlbitms_.add("tlbGroupEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcGroup").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbGroupEditList-new_mr"
		this._tlbitms_.add("tlbGroupEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcGroup").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbGroupEditList-copy_mr"
		this._tlbitms_.add("tlbGroupEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcGroup").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbGroupEditList-delete_mr"
		this._tlbitms_.add("tlbGroupEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("dcGroup").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbGroupEditList-rollback_mr"
		this._tlbitms_.add("tlbGroupEditList___S00_", "-") ;
		this._tlbitms_.add("tlbGroupEditList___S01_", "-") ;
		this._tlbitms_.add("tlbGroupEditList___TITLE_",  {xtype:"tbtext", text:"UserGroup"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbGroupEditList__") != -1); } )
		this._tlbs_.add("tlbGroupEditList" , t.getRange() );
	


			this._getDc_("dcGroup").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbGroupEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcGroup").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbGroupEditList__load")) this._tlbitms_.get("tlbGroupEditList__load").enable();
                 if(this._tlbitms_.get("tlbGroupEditList__new_sr"))this._tlbitms_.get("tlbGroupEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbGroupEditList__new_mr"))this._tlbitms_.get("tlbGroupEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("dcGroup").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbGroupEditList__copy_mr")) this._tlbitms_.get("tlbGroupEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbGroupEditList__delete_mr")) this._tlbitms_.get("tlbGroupEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbGroupEditList__copy_mr")) this._tlbitms_.get("tlbGroupEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbGroupEditList__delete_mr")) this._tlbitms_.get("tlbGroupEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("dcGroup").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbGroupEditList__load")) this._tlbitms_.get("tlbGroupEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbGroupEditList__save_mr")) this._tlbitms_.get("tlbGroupEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbGroupEditList__rollback_record_mr"))this._tlbitms_.get("tlbGroupEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbGroupEditList__rollback_mr"))this._tlbitms_.get("tlbGroupEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("dcGroup").on("cleanRecord" , function() {
		  		  if (this._getDc_("dcGroup").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbGroupEditList__load")) this._tlbitms_.get("tlbGroupEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbGroupEditList__save_mr"))this._tlbitms_.get("tlbGroupEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbGroupEditList__rollback_record_mr"))this._tlbitms_.get("tlbGroupEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbGroupEditList__rollback_mr"))this._tlbitms_.get("tlbGroupEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbGroupEditList__load")) this._tlbitms_.get("tlbGroupEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbGroupEditList__back_mr"))this._tlbitms_.get("tlbGroupEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbGroupEditList__save_mr"))this._tlbitms_.get("tlbGroupEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbGroupEditList__rollback_record_mr"))this._tlbitms_.get("tlbGroupEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbGroupEditList__rollback_mr"))this._tlbitms_.get("tlbGroupEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("dcGroup").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.ad.usr.frame.UserGroups_UI", net.nan21.dnet.module.ad.usr.frame.UserGroups_UI);   
