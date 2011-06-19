 
Dnet.import(["", "nan21.dnet.module.bp.ui.extjs/ds/BankDs", "nan21.dnet.module.bp.ui.extjs/dc/Bank"]);

Ext.ns("net.nan21.dnet.module.bp.base.frame");
net.nan21.dnet.module.bp.base.frame.Bank_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bp.base.frame.Bank_UI"
	
	,_defineDcs_: function () {	
		var  bank = new net.nan21.dnet.module.bp.base.dc.Bank({multiEdit:true});	 	
		
		this._dcs_.add("bank", bank);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("bankFilter", { xtype:"net.nan21.dnet.module.bp.base.dc.Bank$Filter", id:Ext.id(), _controller_:this._dcs_.get("bank") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("bankEditList", { xtype:"net.nan21.dnet.module.bp.base.dc.Bank$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("bank") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Edit list",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") ]; 				 		
 
			this._elems_.get("bankFilter")["region"] = "north";			
			this._elems_.get("bankEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("bankFilter") , this._elems_.get("bankEditList") ]; 				 		
	 	this._linkToolbar_("tlb", "canvas1");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlb__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("bank").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlb-load"
		this._tlbitms_.add("tlb__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bank").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlb-save_mr"
		this._tlbitms_.add("tlb__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("bank").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlb-new_mr"
		this._tlbitms_.add("tlb__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bank").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlb-copy_mr"
		this._tlbitms_.add("tlb__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("bank").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlb-delete_mr"
		this._tlbitms_.add("tlb__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("bank").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlb-rollback_mr"
		this._tlbitms_.add("tlb___S00_", "-") ;
		this._tlbitms_.add("tlb___S01_", "-") ;
		this._tlbitms_.add("tlb___TITLE_",  {xtype:"tbtext", text:"Bank"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlb__") != -1); } )
		this._tlbs_.add("tlb" , t.getRange() );
	


			this._getDc_("bank").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlb__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("bank").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlb__load")) this._tlbitms_.get("tlb__load").enable();
                 if(this._tlbitms_.get("tlb__new_sr"))this._tlbitms_.get("tlb__new_sr").enable();
                 if(this._tlbitms_.get("tlb__new_mr"))this._tlbitms_.get("tlb__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("bank").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlb__copy_mr")) this._tlbitms_.get("tlb__copy_mr").enable();
                        if(this._tlbitms_.get("tlb__delete_mr")) this._tlbitms_.get("tlb__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlb__copy_mr")) this._tlbitms_.get("tlb__copy_mr").disable();
                       if(this._tlbitms_.get("tlb__delete_mr")) this._tlbitms_.get("tlb__delete_mr").disable();
					}

			  } , this );
			this._getDc_("bank").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlb__load")) this._tlbitms_.get("tlb__load").disable();		  			 
                    if(this._tlbitms_.get("tlb__save_mr")) this._tlbitms_.get("tlb__save_mr").enable();
                    if(this._tlbitms_.get("tlb__rollback_record_mr"))this._tlbitms_.get("tlb__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlb__rollback_mr"))this._tlbitms_.get("tlb__rollback_mr").enable();
			  } , this );

			this._getDc_("bank").on("cleanRecord" , function() {
		  		  if (this._getDc_("bank").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlb__load")) this._tlbitms_.get("tlb__load").disable();	                
                    if(this._tlbitms_.get("tlb__save_mr"))this._tlbitms_.get("tlb__save_mr").enable();
                    if(this._tlbitms_.get("tlb__rollback_record_mr"))this._tlbitms_.get("tlb__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlb__rollback_mr"))this._tlbitms_.get("tlb__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlb__load")) this._tlbitms_.get("tlb__load").enable();	
                  	if(this._tlbitms_.get("tlb__back_mr"))this._tlbitms_.get("tlb__back_mr").enable();
                  	if(this._tlbitms_.get("tlb__save_mr"))this._tlbitms_.get("tlb__save_mr").disable();
                  	if(this._tlbitms_.get("tlb__rollback_record_mr"))this._tlbitms_.get("tlb__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlb__rollback_mr"))this._tlbitms_.get("tlb__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("bank").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.bp.base.frame.Bank_UI", net.nan21.dnet.module.bp.base.frame.Bank_UI);   
