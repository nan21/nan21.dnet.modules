 
Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/RoleDs", "nan21.dnet.module.ad.ui.extjs/dc/Role"]);

Ext.ns("net.nan21.dnet.module.ad.usr.frame");
net.nan21.dnet.module.ad.usr.frame.Role_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.Role_UI"
	
	,_defineDcs_: function () {	
		var  rol = new net.nan21.dnet.module.ad.usr.dc.Role({multiEdit:true});	 	
		
		this._dcs_.add("rol", rol);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
			this._elems_.add("btnAsgnToUsers", { xtype:"button", name:"btnAsgnToUsers", id:Ext.id() 
					,text:"Users", tooltip:"Assign selected role to users"
					,disabled:true
					,handler: function() {

			var iid = Ext.id();
			var wdwConfig = {
				layout:"fit"
				,items:[{xtype:"tAsgnRolesOfUser", id:iid, _objectId_: objectId}]
				,title:"Assign role to users"
				//,width:700
				//,height:400
				,closable:true, modal:true
			}
			var objectId = this._dcs_.get("rol").record["id"];
			var aw=new Ext.Window(wdwConfig);
			aw.show();
			Ext.getCmp(iid)._controller_.params.objectId = objectId ;
			Ext.getCmp(iid)._controller_.initAssignement();				 	

 
}					 	
 ,scope:this });	
			this._getDc_("rol").on("recordChanged", function(evnt) {
		 	       if ((evnt.state=='clean') ) { var btn = this._getElement_("btnAsgnToUsers"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnAsgnToUsers");if(btn) btn.disable();  }
			 }, this );					 	
		this._elems_.add("rolFilter", { xtype:"net.nan21.dnet.module.ad.usr.dc.Role$Filter", id:Ext.id(), _controller_:this._dcs_.get("rol") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("rolList", { xtype:"net.nan21.dnet.module.ad.usr.dc.Role$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("rol"),buttons:[ this._elems_.get("btnAsgnToUsers") ] ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") ]; 				 		
 
			this._elems_.get("rolFilter")["region"] = "north";			
			this._elems_.get("rolList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("rolFilter") , this._elems_.get("rolList") ]; 				 		
	 	this._linkToolbar_("tlbRolList", "canvas1");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbRolList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("rol").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRolList-load"
		this._tlbitms_.add("tlbRolList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rol").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRolList-save_mr"
		this._tlbitms_.add("tlbRolList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("rol").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRolList-new_mr"
		this._tlbitms_.add("tlbRolList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rol").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRolList-copy_mr"
		this._tlbitms_.add("tlbRolList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rol").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRolList-delete_mr"
		this._tlbitms_.add("tlbRolList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("rol").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRolList-rollback_mr"
		this._tlbitms_.add("tlbRolList___S00_", "-") ;
		this._tlbitms_.add("tlbRolList___S01_", "-") ;
		this._tlbitms_.add("tlbRolList___TITLE_",  {xtype:"tbtext", text:"Role"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbRolList__") != -1); } )
		this._tlbs_.add("tlbRolList" , t.getRange() );
	


			this._getDc_("rol").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbRolList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("rol").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbRolList__load")) this._tlbitms_.get("tlbRolList__load").enable();
                 if(this._tlbitms_.get("tlbRolList__new_sr"))this._tlbitms_.get("tlbRolList__new_sr").enable();
                 if(this._tlbitms_.get("tlbRolList__new_mr"))this._tlbitms_.get("tlbRolList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("rol").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbRolList__copy_mr")) this._tlbitms_.get("tlbRolList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbRolList__delete_mr")) this._tlbitms_.get("tlbRolList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbRolList__copy_mr")) this._tlbitms_.get("tlbRolList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbRolList__delete_mr")) this._tlbitms_.get("tlbRolList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("rol").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbRolList__load")) this._tlbitms_.get("tlbRolList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbRolList__save_mr")) this._tlbitms_.get("tlbRolList__save_mr").enable();
                    if(this._tlbitms_.get("tlbRolList__rollback_record_mr"))this._tlbitms_.get("tlbRolList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbRolList__rollback_mr"))this._tlbitms_.get("tlbRolList__rollback_mr").enable();
			  } , this );

			this._getDc_("rol").on("cleanRecord" , function() {
		  		  if (this._getDc_("rol").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbRolList__load")) this._tlbitms_.get("tlbRolList__load").disable();	                
                    if(this._tlbitms_.get("tlbRolList__save_mr"))this._tlbitms_.get("tlbRolList__save_mr").enable();
                    if(this._tlbitms_.get("tlbRolList__rollback_record_mr"))this._tlbitms_.get("tlbRolList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbRolList__rollback_mr"))this._tlbitms_.get("tlbRolList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbRolList__load")) this._tlbitms_.get("tlbRolList__load").enable();	
                  	if(this._tlbitms_.get("tlbRolList__back_mr"))this._tlbitms_.get("tlbRolList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbRolList__save_mr"))this._tlbitms_.get("tlbRolList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbRolList__rollback_record_mr"))this._tlbitms_.get("tlbRolList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbRolList__rollback_mr"))this._tlbitms_.get("tlbRolList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("rol").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.ad.usr.frame.Role_UI", net.nan21.dnet.module.ad.usr.frame.Role_UI);   
