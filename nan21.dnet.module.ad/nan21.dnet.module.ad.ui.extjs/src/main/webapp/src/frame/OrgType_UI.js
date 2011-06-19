 
Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/OrganizationTypeDs", "nan21.dnet.module.ad.ui.extjs/dc/OrganizationType"]);

Ext.ns("net.nan21.dnet.module.ad.org.frame");
net.nan21.dnet.module.ad.org.frame.OrgType_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.org.frame.OrgType_UI"
	
	,_defineDcs_: function () {	
		var  orgtype = new net.nan21.dnet.module.ad.org.dc.OrganizationType({multiEdit:true});	 	
		
		this._dcs_.add("orgtype", orgtype);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("orgtypeFilter", { xtype:"net.nan21.dnet.module.ad.org.dc.OrganizationType$Filter", id:Ext.id(), _controller_:this._dcs_.get("orgtype") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("orgtypeEditList", { xtype:"net.nan21.dnet.module.ad.org.dc.OrganizationType$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("orgtype") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Edit list",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") ]; 				 		
 
			this._elems_.get("orgtypeFilter")["region"] = "north";			
			this._elems_.get("orgtypeEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("orgtypeFilter") , this._elems_.get("orgtypeEditList") ]; 				 		
	 	this._linkToolbar_("tlbOrgtypeList", "canvas1");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbOrgtypeList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("orgtype").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrgtypeList-load"
		this._tlbitms_.add("tlbOrgtypeList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("orgtype").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrgtypeList-save_mr"
		this._tlbitms_.add("tlbOrgtypeList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("orgtype").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrgtypeList-new_mr"
		this._tlbitms_.add("tlbOrgtypeList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("orgtype").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrgtypeList-copy_mr"
		this._tlbitms_.add("tlbOrgtypeList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("orgtype").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrgtypeList-delete_mr"
		this._tlbitms_.add("tlbOrgtypeList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("orgtype").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrgtypeList-rollback_mr"
		this._tlbitms_.add("tlbOrgtypeList___S00_", "-") ;
		this._tlbitms_.add("tlbOrgtypeList___S01_", "-") ;
		this._tlbitms_.add("tlbOrgtypeList___TITLE_",  {xtype:"tbtext", text:"OrganizationType"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbOrgtypeList__") != -1); } )
		this._tlbs_.add("tlbOrgtypeList" , t.getRange() );
	


			this._getDc_("orgtype").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbOrgtypeList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("orgtype").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbOrgtypeList__load")) this._tlbitms_.get("tlbOrgtypeList__load").enable();
                 if(this._tlbitms_.get("tlbOrgtypeList__new_sr"))this._tlbitms_.get("tlbOrgtypeList__new_sr").enable();
                 if(this._tlbitms_.get("tlbOrgtypeList__new_mr"))this._tlbitms_.get("tlbOrgtypeList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("orgtype").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbOrgtypeList__copy_mr")) this._tlbitms_.get("tlbOrgtypeList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbOrgtypeList__delete_mr")) this._tlbitms_.get("tlbOrgtypeList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbOrgtypeList__copy_mr")) this._tlbitms_.get("tlbOrgtypeList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbOrgtypeList__delete_mr")) this._tlbitms_.get("tlbOrgtypeList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("orgtype").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbOrgtypeList__load")) this._tlbitms_.get("tlbOrgtypeList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbOrgtypeList__save_mr")) this._tlbitms_.get("tlbOrgtypeList__save_mr").enable();
                    if(this._tlbitms_.get("tlbOrgtypeList__rollback_record_mr"))this._tlbitms_.get("tlbOrgtypeList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbOrgtypeList__rollback_mr"))this._tlbitms_.get("tlbOrgtypeList__rollback_mr").enable();
			  } , this );

			this._getDc_("orgtype").on("cleanRecord" , function() {
		  		  if (this._getDc_("orgtype").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbOrgtypeList__load")) this._tlbitms_.get("tlbOrgtypeList__load").disable();	                
                    if(this._tlbitms_.get("tlbOrgtypeList__save_mr"))this._tlbitms_.get("tlbOrgtypeList__save_mr").enable();
                    if(this._tlbitms_.get("tlbOrgtypeList__rollback_record_mr"))this._tlbitms_.get("tlbOrgtypeList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbOrgtypeList__rollback_mr"))this._tlbitms_.get("tlbOrgtypeList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbOrgtypeList__load")) this._tlbitms_.get("tlbOrgtypeList__load").enable();	
                  	if(this._tlbitms_.get("tlbOrgtypeList__back_mr"))this._tlbitms_.get("tlbOrgtypeList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbOrgtypeList__save_mr"))this._tlbitms_.get("tlbOrgtypeList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbOrgtypeList__rollback_record_mr"))this._tlbitms_.get("tlbOrgtypeList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbOrgtypeList__rollback_mr"))this._tlbitms_.get("tlbOrgtypeList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("orgtype").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.ad.org.frame.OrgType_UI", net.nan21.dnet.module.ad.org.frame.OrgType_UI);   
