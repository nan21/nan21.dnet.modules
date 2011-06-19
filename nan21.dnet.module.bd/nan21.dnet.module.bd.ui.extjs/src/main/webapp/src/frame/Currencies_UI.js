 
Dnet.import(["", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyDs", "nan21.dnet.module.bd.ui.extjs/dc/Currency"]);

Ext.ns("net.nan21.dnet.module.bd.currency.frame");
net.nan21.dnet.module.bd.currency.frame.Currencies_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bd.currency.frame.Currencies_UI"
	
	,_defineDcs_: function () {	
		var  currency = new net.nan21.dnet.module.bd.currency.dc.Currency({multiEdit:true});	 	
		
		this._dcs_.add("currency", currency);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("currencyFilter", { xtype:"net.nan21.dnet.module.bd.currency.dc.Currency$Filter", id:Ext.id(), _controller_:this._dcs_.get("currency") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("currencyList", { xtype:"net.nan21.dnet.module.bd.currency.dc.Currency$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("currency") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Edit list",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") ]; 				 		
 
			this._elems_.get("currencyFilter")["region"] = "north";			
			this._elems_.get("currencyList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("currencyFilter") , this._elems_.get("currencyList") ]; 				 		
	 	this._linkToolbar_("tlbMain", "main");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbMain__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("currency").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMain-load"
		this._tlbitms_.add("tlbMain__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("currency").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbMain-save_mr"
		this._tlbitms_.add("tlbMain__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("currency").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMain-new_mr"
		this._tlbitms_.add("tlbMain__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("currency").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMain-copy_mr"
		this._tlbitms_.add("tlbMain__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("currency").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMain-delete_mr"
		this._tlbitms_.add("tlbMain__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("currency").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMain-rollback_mr"
		this._tlbitms_.add("tlbMain___S00_", "-") ;
		this._tlbitms_.add("tlbMain___S01_", "-") ;
		this._tlbitms_.add("tlbMain___TITLE_",  {xtype:"tbtext", text:"Currency"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbMain__") != -1); } )
		this._tlbs_.add("tlbMain" , t.getRange() );
	


			this._getDc_("currency").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbMain__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("currency").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbMain__load")) this._tlbitms_.get("tlbMain__load").enable();
                 if(this._tlbitms_.get("tlbMain__new_sr"))this._tlbitms_.get("tlbMain__new_sr").enable();
                 if(this._tlbitms_.get("tlbMain__new_mr"))this._tlbitms_.get("tlbMain__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("currency").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbMain__copy_mr")) this._tlbitms_.get("tlbMain__copy_mr").enable();
                        if(this._tlbitms_.get("tlbMain__delete_mr")) this._tlbitms_.get("tlbMain__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbMain__copy_mr")) this._tlbitms_.get("tlbMain__copy_mr").disable();
                       if(this._tlbitms_.get("tlbMain__delete_mr")) this._tlbitms_.get("tlbMain__delete_mr").disable();
					}

			  } , this );
			this._getDc_("currency").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbMain__load")) this._tlbitms_.get("tlbMain__load").disable();		  			 
                    if(this._tlbitms_.get("tlbMain__save_mr")) this._tlbitms_.get("tlbMain__save_mr").enable();
                    if(this._tlbitms_.get("tlbMain__rollback_record_mr"))this._tlbitms_.get("tlbMain__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbMain__rollback_mr"))this._tlbitms_.get("tlbMain__rollback_mr").enable();
			  } , this );

			this._getDc_("currency").on("cleanRecord" , function() {
		  		  if (this._getDc_("currency").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbMain__load")) this._tlbitms_.get("tlbMain__load").disable();	                
                    if(this._tlbitms_.get("tlbMain__save_mr"))this._tlbitms_.get("tlbMain__save_mr").enable();
                    if(this._tlbitms_.get("tlbMain__rollback_record_mr"))this._tlbitms_.get("tlbMain__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbMain__rollback_mr"))this._tlbitms_.get("tlbMain__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbMain__load")) this._tlbitms_.get("tlbMain__load").enable();	
                  	if(this._tlbitms_.get("tlbMain__back_mr"))this._tlbitms_.get("tlbMain__back_mr").enable();
                  	if(this._tlbitms_.get("tlbMain__save_mr"))this._tlbitms_.get("tlbMain__save_mr").disable();
                  	if(this._tlbitms_.get("tlbMain__rollback_record_mr"))this._tlbitms_.get("tlbMain__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbMain__rollback_mr"))this._tlbitms_.get("tlbMain__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("currency").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.bd.currency.frame.Currencies_UI", net.nan21.dnet.module.bd.currency.frame.Currencies_UI);   
