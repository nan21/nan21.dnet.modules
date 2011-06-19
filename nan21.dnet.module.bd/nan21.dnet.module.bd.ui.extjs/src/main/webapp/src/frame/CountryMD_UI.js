 
Dnet.import(["", "nan21.dnet.module.bd.ui.extjs/ds/CountryDs", "nan21.dnet.module.bd.ui.extjs/dc/Country", "nan21.dnet.module.bd.ui.extjs/ds/RegionDs", "nan21.dnet.module.bd.ui.extjs/dc/Region"]);

Ext.ns("net.nan21.dnet.module.bd.geo.frame");
net.nan21.dnet.module.bd.geo.frame.CountryMD_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bd.geo.frame.CountryMD_UI"
	
	,_defineDcs_: function () {	
		var  country = new net.nan21.dnet.module.bd.geo.dc.Country({multiEdit:false}), region = new net.nan21.dnet.module.bd.geo.dc.Region({multiEdit:true});	 	
		
		this._dcs_.add("country", country);			
		region.setDcContext(new dnet.base.DcContext({childDc:region, parentDc:country, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"countryId", parentField:"id"} ]}}));country.addChild(region);
		this._dcs_.add("region", region);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("countryFilter", { xtype:"net.nan21.dnet.module.bd.geo.dc.Country$Filter", id:Ext.id(), _controller_:this._dcs_.get("country") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("countryList", { xtype:"net.nan21.dnet.module.bd.geo.dc.Country$List", id:Ext.id(), _controller_:this._dcs_.get("country") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("countryEdit", { xtype:"net.nan21.dnet.module.bd.geo.dc.Country$Edit", id:Ext.id(), _controller_:this._dcs_.get("country"),height:120 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("country").isRecordValid = this._dcs_.get("country").isRecordValid.createInterceptor(function() { return this._getElement_("countryEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("regionEditList", { xtype:"net.nan21.dnet.module.bd.geo.dc.Region$EditListContext", frame:true, id:Ext.id(), _controller_:this._dcs_.get("region") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("countryFilter")["region"] = "north";			
			this._elems_.get("countryList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("countryFilter") , this._elems_.get("countryList") ]; 				 		
 
			this._elems_.get("countryEdit")["region"] = "north";			
			this._elems_.get("regionEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("countryEdit") , this._elems_.get("regionEditList") ]; 				 		
	 	this._linkToolbar_("tlbCountryList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbCountryEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbRegionList", "regionEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbCountryList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("country").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCountryList-load"
		this._tlbitms_.add("tlbCountryList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("country")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbCountryList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCountryList-edit_sr"
		this._tlbitms_.add("tlbCountryList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("country").doNew(); this._invokeTlbItem_("tlbCountryList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCountryList-new_sr"
		this._tlbitms_.add("tlbCountryList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("country").doCopy(); this._invokeTlbItem_("tlbCountryList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCountryList-copy_sr"
		this._tlbitms_.add("tlbCountryList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("country").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCountryList-delete_selected_sr"
		this._tlbitms_.add("tlbCountryList___S00_", "-") ;
		this._tlbitms_.add("tlbCountryList___S01_", "-") ;
		this._tlbitms_.add("tlbCountryList___TITLE_",  {xtype:"tbtext", text:"Country"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbCountryList__") != -1); } )
		this._tlbs_.add("tlbCountryList" , t.getRange() );

		this._getDc_("country").on("onEdit", function() {this._invokeTlbItem_("tlbCountryList__edit_sr");} , this);

	


			this._getDc_("country").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbCountryList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("country").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbCountryList__load")) this._tlbitms_.get("tlbCountryList__load").enable();
                 if(this._tlbitms_.get("tlbCountryList__new_sr"))this._tlbitms_.get("tlbCountryList__new_sr").enable();
                 if(this._tlbitms_.get("tlbCountryList__new_mr"))this._tlbitms_.get("tlbCountryList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("country").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbCountryList__edit_sr")) this._tlbitms_.get("tlbCountryList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbCountryList__copy_sr")) this._tlbitms_.get("tlbCountryList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbCountryList__delete_selected_sr")) this._tlbitms_.get("tlbCountryList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbCountryList__edit_sr")) this._tlbitms_.get("tlbCountryList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbCountryList__copy_sr")) this._tlbitms_.get("tlbCountryList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbCountryList__delete_selected_sr")) this._tlbitms_.get("tlbCountryList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbCountryEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("country")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbCountryEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCountryEdit-back_sr"
		this._tlbitms_.add("tlbCountryEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("country").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCountryEdit-save"
		this._tlbitms_.add("tlbCountryEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("country").doNew(); this._invokeTlbItem_("tlbCountryEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCountryEdit-new_sr"
		this._tlbitms_.add("tlbCountryEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("country").doCopy(); this._invokeTlbItem_("tlbCountryEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCountryEdit-copy_sr"
		this._tlbitms_.add("tlbCountryEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("country").getCurrentRecord().phantom) {this._getDc_("country").discardChanges();this._invokeTlbItem_("tlbCountryEdit__back_sr");} else  {this._getDc_("country").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCountryEdit-rollback_sr"
		this._tlbitms_.add("tlbCountryEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("country").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCountryEdit-prev_rec_sr"
		this._tlbitms_.add("tlbCountryEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("country").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCountryEdit-next_rec_sr"
		this._tlbitms_.add("tlbCountryEdit___S00_", "-") ;
		this._tlbitms_.add("tlbCountryEdit___S01_", "-") ;
		this._tlbitms_.add("tlbCountryEdit___TITLE_",  {xtype:"tbtext", text:"Country"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbCountryEdit__") != -1); } )
		this._tlbs_.add("tlbCountryEdit" , t.getRange() );
	


			this._getDc_("country").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbCountryEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("country").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbCountryEdit__load")) this._tlbitms_.get("tlbCountryEdit__load").enable();
                 if(this._tlbitms_.get("tlbCountryEdit__new_sr"))this._tlbitms_.get("tlbCountryEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbCountryEdit__new_mr"))this._tlbitms_.get("tlbCountryEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("country").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbCountryEdit__back_sr")) this._tlbitms_.get("tlbCountryEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbCountryEdit__save")) this._tlbitms_.get("tlbCountryEdit__save").enable();
                    if(this._tlbitms_.get("tlbCountryEdit__new_sr")) this._tlbitms_.get("tlbCountryEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbCountryEdit__copy_sr")) this._tlbitms_.get("tlbCountryEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbCountryEdit__rollback_record_sr")) this._tlbitms_.get("tlbCountryEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbCountryEdit__rollback_sr")) this._tlbitms_.get("tlbCountryEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbCountryEdit__prev_rec_sr")) this._tlbitms_.get("tlbCountryEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbCountryEdit__next_rec_sr")) this._tlbitms_.get("tlbCountryEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("country").on("cleanRecord" , function() {
		  		  if (this._getDc_("country").isDirty() ) {
                    if(this._tlbitms_.get("tlbCountryEdit__back_sr")) this._tlbitms_.get("tlbCountryEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbCountryEdit__save")) this._tlbitms_.get("tlbCountryEdit__save").enable();
                    if(this._tlbitms_.get("tlbCountryEdit__new_sr")) this._tlbitms_.get("tlbCountryEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbCountryEdit__copy_sr")) this._tlbitms_.get("tlbCountryEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbCountryEdit__rollback_record_sr")) this._tlbitms_.get("tlbCountryEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbCountryEdit__rollback_sr")) this._tlbitms_.get("tlbCountryEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbCountryEdit__prev_rec_sr")) this._tlbitms_.get("tlbCountryEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbCountryEdit__next_rec_sr")) this._tlbitms_.get("tlbCountryEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbCountryEdit__back_sr")) this._tlbitms_.get("tlbCountryEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbCountryEdit__save")) this._tlbitms_.get("tlbCountryEdit__save").disable();
                  	if(this._tlbitms_.get("tlbCountryEdit__new_sr")) this._tlbitms_.get("tlbCountryEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbCountryEdit__copy_sr")) this._tlbitms_.get("tlbCountryEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbCountryEdit__rollback_record_sr")) this._tlbitms_.get("tlbCountryEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbCountryEdit__rollback_sr")) this._tlbitms_.get("tlbCountryEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbCountryEdit__prev_rec_sr")) this._tlbitms_.get("tlbCountryEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbCountryEdit__next_rec_sr")) this._tlbitms_.get("tlbCountryEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("country").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbCountryEdit__copy_sr")) this._tlbitms_.get("tlbCountryEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbRegionList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("region").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRegionList-load"
		this._tlbitms_.add("tlbRegionList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("region").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRegionList-save_mr"
		this._tlbitms_.add("tlbRegionList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("region").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRegionList-new_mr"
		this._tlbitms_.add("tlbRegionList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("region").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRegionList-copy_mr"
		this._tlbitms_.add("tlbRegionList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("region").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRegionList-delete_mr"
		this._tlbitms_.add("tlbRegionList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("region").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRegionList-rollback_mr"
		this._tlbitms_.add("tlbRegionList___S00_", "-") ;
		this._tlbitms_.add("tlbRegionList___S01_", "-") ;
		this._tlbitms_.add("tlbRegionList___TITLE_",  {xtype:"tbtext", text:"Region"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbRegionList__") != -1); } )
		this._tlbs_.add("tlbRegionList" , t.getRange() );
	


			this._getDc_("region").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbRegionList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("region").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbRegionList__load")) this._tlbitms_.get("tlbRegionList__load").enable();
                 if(this._tlbitms_.get("tlbRegionList__new_sr"))this._tlbitms_.get("tlbRegionList__new_sr").enable();
                 if(this._tlbitms_.get("tlbRegionList__new_mr"))this._tlbitms_.get("tlbRegionList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("region").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbRegionList__copy_mr")) this._tlbitms_.get("tlbRegionList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbRegionList__delete_mr")) this._tlbitms_.get("tlbRegionList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbRegionList__copy_mr")) this._tlbitms_.get("tlbRegionList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbRegionList__delete_mr")) this._tlbitms_.get("tlbRegionList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("region").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbRegionList__load")) this._tlbitms_.get("tlbRegionList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbRegionList__save_mr")) this._tlbitms_.get("tlbRegionList__save_mr").enable();
                    if(this._tlbitms_.get("tlbRegionList__rollback_record_mr"))this._tlbitms_.get("tlbRegionList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbRegionList__rollback_mr"))this._tlbitms_.get("tlbRegionList__rollback_mr").enable();
			  } , this );

			this._getDc_("region").on("cleanRecord" , function() {
		  		  if (this._getDc_("region").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbRegionList__load")) this._tlbitms_.get("tlbRegionList__load").disable();	                
                    if(this._tlbitms_.get("tlbRegionList__save_mr"))this._tlbitms_.get("tlbRegionList__save_mr").enable();
                    if(this._tlbitms_.get("tlbRegionList__rollback_record_mr"))this._tlbitms_.get("tlbRegionList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbRegionList__rollback_mr"))this._tlbitms_.get("tlbRegionList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbRegionList__load")) this._tlbitms_.get("tlbRegionList__load").enable();	
                  	if(this._tlbitms_.get("tlbRegionList__back_mr"))this._tlbitms_.get("tlbRegionList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbRegionList__save_mr"))this._tlbitms_.get("tlbRegionList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbRegionList__rollback_record_mr"))this._tlbitms_.get("tlbRegionList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbRegionList__rollback_mr"))this._tlbitms_.get("tlbRegionList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("country").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("countryEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("region").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.bd.geo.frame.CountryMD_UI", net.nan21.dnet.module.bd.geo.frame.CountryMD_UI);   
