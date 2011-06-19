 
Dnet.import(["", "nan21.dnet.module.bd.ui.extjs/ds/UomDs", "nan21.dnet.module.bd.ui.extjs/dc/Uom", "nan21.dnet.module.bd.ui.extjs/ds/UomConversionDs", "nan21.dnet.module.bd.ui.extjs/dc/UomConversion","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure"]);

Ext.ns("net.nan21.dnet.module.bd.uom.frame");
net.nan21.dnet.module.bd.uom.frame.UomMD_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bd.uom.frame.UomMD_UI"
	
	,_defineDcs_: function () {	
		var  uom = new net.nan21.dnet.module.bd.uom.dc.Uom({multiEdit:false}), cnv = new net.nan21.dnet.module.bd.uom.dc.UomConversion({multiEdit:true});	 	
		
		this._dcs_.add("uom", uom);			
		cnv.setDcContext(new dnet.base.DcContext({childDc:cnv, parentDc:uom, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"sourceId", parentField:"id"},{childField:"sourceCode", parentField:"code"} ]}}));uom.addChild(cnv);
		this._dcs_.add("cnv", cnv);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("uomFilter", { xtype:"net.nan21.dnet.module.bd.uom.dc.Uom$Filter", id:Ext.id(), _controller_:this._dcs_.get("uom") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("uomList", { xtype:"net.nan21.dnet.module.bd.uom.dc.Uom$List", id:Ext.id(), _controller_:this._dcs_.get("uom") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("uomEdit", { xtype:"net.nan21.dnet.module.bd.uom.dc.Uom$Edit", id:Ext.id(), _controller_:this._dcs_.get("uom"),height:125 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("uom").isRecordValid = this._dcs_.get("uom").isRecordValid.createInterceptor(function() { return this._getElement_("uomEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("cnvEditList", { xtype:"net.nan21.dnet.module.bd.uom.dc.UomConversion$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("cnv") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("uomFilter")["region"] = "north";			
			this._elems_.get("uomList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("uomFilter") , this._elems_.get("uomList") ]; 				 		
 
			this._elems_.get("uomEdit")["region"] = "north";			
			this._elems_.get("cnvEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("uomEdit") , this._elems_.get("cnvEditList") ]; 				 		
	 	this._linkToolbar_("tlbUomList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbUomEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbCnvEditList", "cnvEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbUomList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("uom").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbUomList-load"
		this._tlbitms_.add("tlbUomList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("uom")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbUomList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbUomList-edit_sr"
		this._tlbitms_.add("tlbUomList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("uom").doNew(); this._invokeTlbItem_("tlbUomList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUomList-new_sr"
		this._tlbitms_.add("tlbUomList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("uom").doCopy(); this._invokeTlbItem_("tlbUomList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUomList-copy_sr"
		this._tlbitms_.add("tlbUomList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("uom").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUomList-delete_selected_sr"
		this._tlbitms_.add("tlbUomList___S00_", "-") ;
		this._tlbitms_.add("tlbUomList___S01_", "-") ;
		this._tlbitms_.add("tlbUomList___TITLE_",  {xtype:"tbtext", text:"Uom"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbUomList__") != -1); } )
		this._tlbs_.add("tlbUomList" , t.getRange() );

		this._getDc_("uom").on("onEdit", function() {this._invokeTlbItem_("tlbUomList__edit_sr");} , this);

	


			this._getDc_("uom").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbUomList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("uom").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbUomList__load")) this._tlbitms_.get("tlbUomList__load").enable();
                 if(this._tlbitms_.get("tlbUomList__new_sr"))this._tlbitms_.get("tlbUomList__new_sr").enable();
                 if(this._tlbitms_.get("tlbUomList__new_mr"))this._tlbitms_.get("tlbUomList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("uom").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbUomList__edit_sr")) this._tlbitms_.get("tlbUomList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbUomList__copy_sr")) this._tlbitms_.get("tlbUomList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbUomList__delete_selected_sr")) this._tlbitms_.get("tlbUomList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbUomList__edit_sr")) this._tlbitms_.get("tlbUomList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbUomList__copy_sr")) this._tlbitms_.get("tlbUomList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbUomList__delete_selected_sr")) this._tlbitms_.get("tlbUomList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbUomEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("uom")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbUomEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbUomEdit-back_sr"
		this._tlbitms_.add("tlbUomEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("uom").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUomEdit-save"
		this._tlbitms_.add("tlbUomEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("uom").doNew(); this._invokeTlbItem_("tlbUomEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUomEdit-new_sr"
		this._tlbitms_.add("tlbUomEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("uom").doCopy(); this._invokeTlbItem_("tlbUomEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUomEdit-copy_sr"
		this._tlbitms_.add("tlbUomEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("uom").getCurrentRecord().phantom) {this._getDc_("uom").discardChanges();this._invokeTlbItem_("tlbUomEdit__back_sr");} else  {this._getDc_("uom").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbUomEdit-rollback_sr"
		this._tlbitms_.add("tlbUomEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("uom").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbUomEdit-prev_rec_sr"
		this._tlbitms_.add("tlbUomEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("uom").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbUomEdit-next_rec_sr"
		this._tlbitms_.add("tlbUomEdit___S00_", "-") ;
		this._tlbitms_.add("tlbUomEdit___S01_", "-") ;
		this._tlbitms_.add("tlbUomEdit___TITLE_",  {xtype:"tbtext", text:"Uom"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbUomEdit__") != -1); } )
		this._tlbs_.add("tlbUomEdit" , t.getRange() );
	


			this._getDc_("uom").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbUomEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("uom").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbUomEdit__load")) this._tlbitms_.get("tlbUomEdit__load").enable();
                 if(this._tlbitms_.get("tlbUomEdit__new_sr"))this._tlbitms_.get("tlbUomEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbUomEdit__new_mr"))this._tlbitms_.get("tlbUomEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("uom").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbUomEdit__back_sr")) this._tlbitms_.get("tlbUomEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbUomEdit__save")) this._tlbitms_.get("tlbUomEdit__save").enable();
                    if(this._tlbitms_.get("tlbUomEdit__new_sr")) this._tlbitms_.get("tlbUomEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbUomEdit__copy_sr")) this._tlbitms_.get("tlbUomEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbUomEdit__rollback_record_sr")) this._tlbitms_.get("tlbUomEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbUomEdit__rollback_sr")) this._tlbitms_.get("tlbUomEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbUomEdit__prev_rec_sr")) this._tlbitms_.get("tlbUomEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbUomEdit__next_rec_sr")) this._tlbitms_.get("tlbUomEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("uom").on("cleanRecord" , function() {
		  		  if (this._getDc_("uom").isDirty() ) {
                    if(this._tlbitms_.get("tlbUomEdit__back_sr")) this._tlbitms_.get("tlbUomEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbUomEdit__save")) this._tlbitms_.get("tlbUomEdit__save").enable();
                    if(this._tlbitms_.get("tlbUomEdit__new_sr")) this._tlbitms_.get("tlbUomEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbUomEdit__copy_sr")) this._tlbitms_.get("tlbUomEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbUomEdit__rollback_record_sr")) this._tlbitms_.get("tlbUomEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbUomEdit__rollback_sr")) this._tlbitms_.get("tlbUomEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbUomEdit__prev_rec_sr")) this._tlbitms_.get("tlbUomEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbUomEdit__next_rec_sr")) this._tlbitms_.get("tlbUomEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbUomEdit__back_sr")) this._tlbitms_.get("tlbUomEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbUomEdit__save")) this._tlbitms_.get("tlbUomEdit__save").disable();
                  	if(this._tlbitms_.get("tlbUomEdit__new_sr")) this._tlbitms_.get("tlbUomEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbUomEdit__copy_sr")) this._tlbitms_.get("tlbUomEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbUomEdit__rollback_record_sr")) this._tlbitms_.get("tlbUomEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbUomEdit__rollback_sr")) this._tlbitms_.get("tlbUomEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbUomEdit__prev_rec_sr")) this._tlbitms_.get("tlbUomEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbUomEdit__next_rec_sr")) this._tlbitms_.get("tlbUomEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("uom").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbUomEdit__copy_sr")) this._tlbitms_.get("tlbUomEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbCnvEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("cnv").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCnvEditList-load"
		this._tlbitms_.add("tlbCnvEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("cnv").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCnvEditList-save_mr"
		this._tlbitms_.add("tlbCnvEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("cnv").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCnvEditList-new_mr"
		this._tlbitms_.add("tlbCnvEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("cnv").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCnvEditList-copy_mr"
		this._tlbitms_.add("tlbCnvEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("cnv").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCnvEditList-delete_mr"
		this._tlbitms_.add("tlbCnvEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("cnv").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCnvEditList-rollback_mr"
		this._tlbitms_.add("tlbCnvEditList___S00_", "-") ;
		this._tlbitms_.add("tlbCnvEditList___S01_", "-") ;
		this._tlbitms_.add("tlbCnvEditList___TITLE_",  {xtype:"tbtext", text:"UomConversion"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbCnvEditList__") != -1); } )
		this._tlbs_.add("tlbCnvEditList" , t.getRange() );
	


			this._getDc_("cnv").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbCnvEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("cnv").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbCnvEditList__load")) this._tlbitms_.get("tlbCnvEditList__load").enable();
                 if(this._tlbitms_.get("tlbCnvEditList__new_sr"))this._tlbitms_.get("tlbCnvEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbCnvEditList__new_mr"))this._tlbitms_.get("tlbCnvEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("cnv").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbCnvEditList__copy_mr")) this._tlbitms_.get("tlbCnvEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbCnvEditList__delete_mr")) this._tlbitms_.get("tlbCnvEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbCnvEditList__copy_mr")) this._tlbitms_.get("tlbCnvEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbCnvEditList__delete_mr")) this._tlbitms_.get("tlbCnvEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("cnv").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbCnvEditList__load")) this._tlbitms_.get("tlbCnvEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbCnvEditList__save_mr")) this._tlbitms_.get("tlbCnvEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCnvEditList__rollback_record_mr"))this._tlbitms_.get("tlbCnvEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCnvEditList__rollback_mr"))this._tlbitms_.get("tlbCnvEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("cnv").on("cleanRecord" , function() {
		  		  if (this._getDc_("cnv").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbCnvEditList__load")) this._tlbitms_.get("tlbCnvEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbCnvEditList__save_mr"))this._tlbitms_.get("tlbCnvEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCnvEditList__rollback_record_mr"))this._tlbitms_.get("tlbCnvEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCnvEditList__rollback_mr"))this._tlbitms_.get("tlbCnvEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbCnvEditList__load")) this._tlbitms_.get("tlbCnvEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbCnvEditList__back_mr"))this._tlbitms_.get("tlbCnvEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbCnvEditList__save_mr"))this._tlbitms_.get("tlbCnvEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbCnvEditList__rollback_record_mr"))this._tlbitms_.get("tlbCnvEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbCnvEditList__rollback_mr"))this._tlbitms_.get("tlbCnvEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("uom").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("uomEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("cnv").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.bd.uom.frame.UomMD_UI", net.nan21.dnet.module.bd.uom.frame.UomMD_UI);   
