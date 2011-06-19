 
Dnet.import(["", "nan21.dnet.module.bd.ui.extjs/ds/RegionDs", "nan21.dnet.module.bd.ui.extjs/dc/Region", "nan21.dnet.module.bd.ui.extjs/ds/CityDs", "nan21.dnet.module.bd.ui.extjs/dc/City","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries"]);

Ext.ns("net.nan21.dnet.module.bd.geo.frame");
net.nan21.dnet.module.bd.geo.frame.RegionMD_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bd.geo.frame.RegionMD_UI"
	
	,_defineDcs_: function () {	
		var  region = new net.nan21.dnet.module.bd.geo.dc.Region({multiEdit:false}), city = new net.nan21.dnet.module.bd.geo.dc.City({multiEdit:true});	 	
		
		this._dcs_.add("region", region);			
		city.setDcContext(new dnet.base.DcContext({childDc:city, parentDc:region, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"regionId", parentField:"id"},{childField:"countryId", parentField:"countryId"} ]}}));region.addChild(city);
		this._dcs_.add("city", city);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("regionFilter", { xtype:"net.nan21.dnet.module.bd.geo.dc.Region$Filter", id:Ext.id(), _controller_:this._dcs_.get("region") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("regionList", { xtype:"net.nan21.dnet.module.bd.geo.dc.Region$List", id:Ext.id(), _controller_:this._dcs_.get("region") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("regionEdit", { xtype:"net.nan21.dnet.module.bd.geo.dc.Region$Edit", id:Ext.id(), _controller_:this._dcs_.get("region"),height:100 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("region").isRecordValid = this._dcs_.get("region").isRecordValid.createInterceptor(function() { return this._getElement_("regionEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("cityEditList", { xtype:"net.nan21.dnet.module.bd.geo.dc.City$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("city") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("regionFilter")["region"] = "north";			
			this._elems_.get("regionList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("regionFilter") , this._elems_.get("regionList") ]; 				 		
 
			this._elems_.get("regionEdit")["region"] = "north";			
			this._elems_.get("cityEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("regionEdit") , this._elems_.get("cityEditList") ]; 				 		
	 	this._linkToolbar_("tlbRegionList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbRegionEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbCityList", "cityEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbRegionList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("region").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRegionList-load"
		this._tlbitms_.add("tlbRegionList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("region")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbRegionList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRegionList-edit_sr"
		this._tlbitms_.add("tlbRegionList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("region").doNew(); this._invokeTlbItem_("tlbRegionList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRegionList-new_sr"
		this._tlbitms_.add("tlbRegionList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("region").doCopy(); this._invokeTlbItem_("tlbRegionList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRegionList-copy_sr"
		this._tlbitms_.add("tlbRegionList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("region").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRegionList-delete_selected_sr"
		this._tlbitms_.add("tlbRegionList___S00_", "-") ;
		this._tlbitms_.add("tlbRegionList___S01_", "-") ;
		this._tlbitms_.add("tlbRegionList___TITLE_",  {xtype:"tbtext", text:"Region"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbRegionList__") != -1); } )
		this._tlbs_.add("tlbRegionList" , t.getRange() );

		this._getDc_("region").on("onEdit", function() {this._invokeTlbItem_("tlbRegionList__edit_sr");} , this);

	


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
                        if(this._tlbitms_.get("tlbRegionList__edit_sr")) this._tlbitms_.get("tlbRegionList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbRegionList__copy_sr")) this._tlbitms_.get("tlbRegionList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbRegionList__delete_selected_sr")) this._tlbitms_.get("tlbRegionList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbRegionList__edit_sr")) this._tlbitms_.get("tlbRegionList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbRegionList__copy_sr")) this._tlbitms_.get("tlbRegionList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbRegionList__delete_selected_sr")) this._tlbitms_.get("tlbRegionList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbRegionEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("region")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbRegionEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRegionEdit-back_sr"
		this._tlbitms_.add("tlbRegionEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("region").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRegionEdit-save"
		this._tlbitms_.add("tlbRegionEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("region").doNew(); this._invokeTlbItem_("tlbRegionEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRegionEdit-new_sr"
		this._tlbitms_.add("tlbRegionEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("region").doCopy(); this._invokeTlbItem_("tlbRegionEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRegionEdit-copy_sr"
		this._tlbitms_.add("tlbRegionEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("region").getCurrentRecord().phantom) {this._getDc_("region").discardChanges();this._invokeTlbItem_("tlbRegionEdit__back_sr");} else  {this._getDc_("region").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRegionEdit-rollback_sr"
		this._tlbitms_.add("tlbRegionEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("region").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRegionEdit-prev_rec_sr"
		this._tlbitms_.add("tlbRegionEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("region").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRegionEdit-next_rec_sr"
		this._tlbitms_.add("tlbRegionEdit___S00_", "-") ;
		this._tlbitms_.add("tlbRegionEdit___S01_", "-") ;
		this._tlbitms_.add("tlbRegionEdit___TITLE_",  {xtype:"tbtext", text:"Region"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbRegionEdit__") != -1); } )
		this._tlbs_.add("tlbRegionEdit" , t.getRange() );
	


			this._getDc_("region").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbRegionEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("region").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbRegionEdit__load")) this._tlbitms_.get("tlbRegionEdit__load").enable();
                 if(this._tlbitms_.get("tlbRegionEdit__new_sr"))this._tlbitms_.get("tlbRegionEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbRegionEdit__new_mr"))this._tlbitms_.get("tlbRegionEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("region").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbRegionEdit__back_sr")) this._tlbitms_.get("tlbRegionEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbRegionEdit__save")) this._tlbitms_.get("tlbRegionEdit__save").enable();
                    if(this._tlbitms_.get("tlbRegionEdit__new_sr")) this._tlbitms_.get("tlbRegionEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbRegionEdit__copy_sr")) this._tlbitms_.get("tlbRegionEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbRegionEdit__rollback_record_sr")) this._tlbitms_.get("tlbRegionEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbRegionEdit__rollback_sr")) this._tlbitms_.get("tlbRegionEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbRegionEdit__prev_rec_sr")) this._tlbitms_.get("tlbRegionEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbRegionEdit__next_rec_sr")) this._tlbitms_.get("tlbRegionEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("region").on("cleanRecord" , function() {
		  		  if (this._getDc_("region").isDirty() ) {
                    if(this._tlbitms_.get("tlbRegionEdit__back_sr")) this._tlbitms_.get("tlbRegionEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbRegionEdit__save")) this._tlbitms_.get("tlbRegionEdit__save").enable();
                    if(this._tlbitms_.get("tlbRegionEdit__new_sr")) this._tlbitms_.get("tlbRegionEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbRegionEdit__copy_sr")) this._tlbitms_.get("tlbRegionEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbRegionEdit__rollback_record_sr")) this._tlbitms_.get("tlbRegionEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbRegionEdit__rollback_sr")) this._tlbitms_.get("tlbRegionEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbRegionEdit__prev_rec_sr")) this._tlbitms_.get("tlbRegionEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbRegionEdit__next_rec_sr")) this._tlbitms_.get("tlbRegionEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbRegionEdit__back_sr")) this._tlbitms_.get("tlbRegionEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbRegionEdit__save")) this._tlbitms_.get("tlbRegionEdit__save").disable();
                  	if(this._tlbitms_.get("tlbRegionEdit__new_sr")) this._tlbitms_.get("tlbRegionEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbRegionEdit__copy_sr")) this._tlbitms_.get("tlbRegionEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbRegionEdit__rollback_record_sr")) this._tlbitms_.get("tlbRegionEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbRegionEdit__rollback_sr")) this._tlbitms_.get("tlbRegionEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbRegionEdit__prev_rec_sr")) this._tlbitms_.get("tlbRegionEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbRegionEdit__next_rec_sr")) this._tlbitms_.get("tlbRegionEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("region").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbRegionEdit__copy_sr")) this._tlbitms_.get("tlbRegionEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbCityList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("city").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCityList-load"
		this._tlbitms_.add("tlbCityList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("city").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCityList-save_mr"
		this._tlbitms_.add("tlbCityList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("city").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCityList-new_mr"
		this._tlbitms_.add("tlbCityList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("city").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCityList-copy_mr"
		this._tlbitms_.add("tlbCityList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("city").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCityList-delete_mr"
		this._tlbitms_.add("tlbCityList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("city").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCityList-rollback_mr"
		this._tlbitms_.add("tlbCityList___S00_", "-") ;
		this._tlbitms_.add("tlbCityList___S01_", "-") ;
		this._tlbitms_.add("tlbCityList___TITLE_",  {xtype:"tbtext", text:"City"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbCityList__") != -1); } )
		this._tlbs_.add("tlbCityList" , t.getRange() );
	


			this._getDc_("city").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbCityList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("city").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbCityList__load")) this._tlbitms_.get("tlbCityList__load").enable();
                 if(this._tlbitms_.get("tlbCityList__new_sr"))this._tlbitms_.get("tlbCityList__new_sr").enable();
                 if(this._tlbitms_.get("tlbCityList__new_mr"))this._tlbitms_.get("tlbCityList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("city").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbCityList__copy_mr")) this._tlbitms_.get("tlbCityList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbCityList__delete_mr")) this._tlbitms_.get("tlbCityList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbCityList__copy_mr")) this._tlbitms_.get("tlbCityList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbCityList__delete_mr")) this._tlbitms_.get("tlbCityList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("city").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbCityList__load")) this._tlbitms_.get("tlbCityList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbCityList__save_mr")) this._tlbitms_.get("tlbCityList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCityList__rollback_record_mr"))this._tlbitms_.get("tlbCityList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCityList__rollback_mr"))this._tlbitms_.get("tlbCityList__rollback_mr").enable();
			  } , this );

			this._getDc_("city").on("cleanRecord" , function() {
		  		  if (this._getDc_("city").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbCityList__load")) this._tlbitms_.get("tlbCityList__load").disable();	                
                    if(this._tlbitms_.get("tlbCityList__save_mr"))this._tlbitms_.get("tlbCityList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCityList__rollback_record_mr"))this._tlbitms_.get("tlbCityList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCityList__rollback_mr"))this._tlbitms_.get("tlbCityList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbCityList__load")) this._tlbitms_.get("tlbCityList__load").enable();	
                  	if(this._tlbitms_.get("tlbCityList__back_mr"))this._tlbitms_.get("tlbCityList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbCityList__save_mr"))this._tlbitms_.get("tlbCityList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbCityList__rollback_record_mr"))this._tlbitms_.get("tlbCityList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbCityList__rollback_mr"))this._tlbitms_.get("tlbCityList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("region").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("regionEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("city").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.bd.geo.frame.RegionMD_UI", net.nan21.dnet.module.bd.geo.frame.RegionMD_UI);   
