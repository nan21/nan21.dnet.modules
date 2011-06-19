 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/RatingLevelDs", "nan21.dnet.module.hr.ui.extjs/dc/RatingLevel","nan21.dnet.module.hr.ui.extjs/ds/RatingScaleLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingScales","nan21.dnet.module.hr.ui.extjs/ds/RatingScaleLovDs","nan21.dnet.module.hr.ui.extjs/lov/RatingScales"]);

Ext.ns("net.nan21.dnet.module.hr.skill.frame");
net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI"
	
	,_defineDcs_: function () {	
		var  m = new net.nan21.dnet.module.hr.skill.dc.RatingLevel({multiEdit:true});	 	
		
		this._dcs_.add("m", m);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("mFilter", { xtype:"net.nan21.dnet.module.hr.skill.dc.RatingLevel$Filter", id:Ext.id(), _controller_:this._dcs_.get("m") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("mEditList", { xtype:"net.nan21.dnet.module.hr.skill.dc.RatingLevel$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("m") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Edit list",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") ]; 				 		
 
			this._elems_.get("mFilter")["region"] = "north";			
			this._elems_.get("mEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("mFilter") , this._elems_.get("mEditList") ]; 				 		
	 	this._linkToolbar_("tlbMEditList", "canvas1");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbMEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("m").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMEditList-load"
		this._tlbitms_.add("tlbMEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("m").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbMEditList-save_mr"
		this._tlbitms_.add("tlbMEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("m").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMEditList-new_mr"
		this._tlbitms_.add("tlbMEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("m").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMEditList-copy_mr"
		this._tlbitms_.add("tlbMEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("m").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMEditList-delete_mr"
		this._tlbitms_.add("tlbMEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("m").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMEditList-rollback_mr"
		this._tlbitms_.add("tlbMEditList___S00_", "-") ;
		this._tlbitms_.add("tlbMEditList___S01_", "-") ;
		this._tlbitms_.add("tlbMEditList___TITLE_",  {xtype:"tbtext", text:"RatingLevel"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbMEditList__") != -1); } )
		this._tlbs_.add("tlbMEditList" , t.getRange() );
	


			this._getDc_("m").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbMEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("m").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbMEditList__load")) this._tlbitms_.get("tlbMEditList__load").enable();
                 if(this._tlbitms_.get("tlbMEditList__new_sr"))this._tlbitms_.get("tlbMEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbMEditList__new_mr"))this._tlbitms_.get("tlbMEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("m").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbMEditList__copy_mr")) this._tlbitms_.get("tlbMEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbMEditList__delete_mr")) this._tlbitms_.get("tlbMEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbMEditList__copy_mr")) this._tlbitms_.get("tlbMEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbMEditList__delete_mr")) this._tlbitms_.get("tlbMEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("m").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbMEditList__load")) this._tlbitms_.get("tlbMEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbMEditList__save_mr")) this._tlbitms_.get("tlbMEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbMEditList__rollback_record_mr"))this._tlbitms_.get("tlbMEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbMEditList__rollback_mr"))this._tlbitms_.get("tlbMEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("m").on("cleanRecord" , function() {
		  		  if (this._getDc_("m").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbMEditList__load")) this._tlbitms_.get("tlbMEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbMEditList__save_mr"))this._tlbitms_.get("tlbMEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbMEditList__rollback_record_mr"))this._tlbitms_.get("tlbMEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbMEditList__rollback_mr"))this._tlbitms_.get("tlbMEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbMEditList__load")) this._tlbitms_.get("tlbMEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbMEditList__back_mr"))this._tlbitms_.get("tlbMEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbMEditList__save_mr"))this._tlbitms_.get("tlbMEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbMEditList__rollback_record_mr"))this._tlbitms_.get("tlbMEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbMEditList__rollback_mr"))this._tlbitms_.get("tlbMEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("m").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI", net.nan21.dnet.module.hr.skill.frame.RatingLevel_UI);   
