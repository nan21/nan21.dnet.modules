 
Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/WfDefNodeTypeDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDefNodeType"]);

Ext.ns("net.nan21.dnet.module.ad.workflow.frame");
net.nan21.dnet.module.ad.workflow.frame.WfDefNodeType_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.workflow.frame.WfDefNodeType_UI"
	
	,_defineDcs_: function () {	
		var  dcNodeType = new net.nan21.dnet.module.ad.workflow.dc.WfDefNodeType({multiEdit:true});	 	
		
		this._dcs_.add("dcNodeType", dcNodeType);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("filterNodeType", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefNodeType$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcNodeType") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("elistNodeType", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefNodeType$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("dcNodeType") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") ]; 				 		
 
			this._elems_.get("filterNodeType")["region"] = "north";			
			this._elems_.get("elistNodeType")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("filterNodeType") , this._elems_.get("elistNodeType") ]; 				 		
	 	this._linkToolbar_("tlbNodeTypeEditList", "canvas1");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbNodeTypeEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcNodeType").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbNodeTypeEditList-load"
		this._tlbitms_.add("tlbNodeTypeEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcNodeType").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbNodeTypeEditList-save_mr"
		this._tlbitms_.add("tlbNodeTypeEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcNodeType").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbNodeTypeEditList-new_mr"
		this._tlbitms_.add("tlbNodeTypeEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcNodeType").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbNodeTypeEditList-copy_mr"
		this._tlbitms_.add("tlbNodeTypeEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcNodeType").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbNodeTypeEditList-delete_mr"
		this._tlbitms_.add("tlbNodeTypeEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("dcNodeType").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbNodeTypeEditList-rollback_mr"
		this._tlbitms_.add("tlbNodeTypeEditList___S00_", "-") ;
		this._tlbitms_.add("tlbNodeTypeEditList___S01_", "-") ;
		this._tlbitms_.add("tlbNodeTypeEditList___TITLE_",  {xtype:"tbtext", text:"WfDefNodeType"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbNodeTypeEditList__") != -1); } )
		this._tlbs_.add("tlbNodeTypeEditList" , t.getRange() );
	


			this._getDc_("dcNodeType").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbNodeTypeEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcNodeType").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbNodeTypeEditList__load")) this._tlbitms_.get("tlbNodeTypeEditList__load").enable();
                 if(this._tlbitms_.get("tlbNodeTypeEditList__new_sr"))this._tlbitms_.get("tlbNodeTypeEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbNodeTypeEditList__new_mr"))this._tlbitms_.get("tlbNodeTypeEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("dcNodeType").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbNodeTypeEditList__copy_mr")) this._tlbitms_.get("tlbNodeTypeEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbNodeTypeEditList__delete_mr")) this._tlbitms_.get("tlbNodeTypeEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbNodeTypeEditList__copy_mr")) this._tlbitms_.get("tlbNodeTypeEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbNodeTypeEditList__delete_mr")) this._tlbitms_.get("tlbNodeTypeEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("dcNodeType").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbNodeTypeEditList__load")) this._tlbitms_.get("tlbNodeTypeEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbNodeTypeEditList__save_mr")) this._tlbitms_.get("tlbNodeTypeEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbNodeTypeEditList__rollback_record_mr"))this._tlbitms_.get("tlbNodeTypeEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbNodeTypeEditList__rollback_mr"))this._tlbitms_.get("tlbNodeTypeEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("dcNodeType").on("cleanRecord" , function() {
		  		  if (this._getDc_("dcNodeType").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbNodeTypeEditList__load")) this._tlbitms_.get("tlbNodeTypeEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbNodeTypeEditList__save_mr"))this._tlbitms_.get("tlbNodeTypeEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbNodeTypeEditList__rollback_record_mr"))this._tlbitms_.get("tlbNodeTypeEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbNodeTypeEditList__rollback_mr"))this._tlbitms_.get("tlbNodeTypeEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbNodeTypeEditList__load")) this._tlbitms_.get("tlbNodeTypeEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbNodeTypeEditList__back_mr"))this._tlbitms_.get("tlbNodeTypeEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbNodeTypeEditList__save_mr"))this._tlbitms_.get("tlbNodeTypeEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbNodeTypeEditList__rollback_record_mr"))this._tlbitms_.get("tlbNodeTypeEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbNodeTypeEditList__rollback_mr"))this._tlbitms_.get("tlbNodeTypeEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("dcNodeType").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.ad.workflow.frame.WfDefNodeType_UI", net.nan21.dnet.module.ad.workflow.frame.WfDefNodeType_UI);   
