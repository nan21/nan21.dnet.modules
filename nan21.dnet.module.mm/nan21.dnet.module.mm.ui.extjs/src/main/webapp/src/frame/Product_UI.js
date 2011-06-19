 
Dnet.import(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductDs", "nan21.dnet.module.mm.ui.extjs/dc/Product","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers"]);

Ext.ns("net.nan21.dnet.module.mm.md.frame");
net.nan21.dnet.module.mm.md.frame.Product_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.mm.md.frame.Product_UI"
	
	,_defineDcs_: function () {	
		var  prod = new net.nan21.dnet.module.mm.md.dc.Product({multiEdit:false});	 	
		
		this._dcs_.add("prod", prod);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("prodFilter", { xtype:"net.nan21.dnet.module.mm.md.dc.Product$Filter", id:Ext.id(), _controller_:this._dcs_.get("prod") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("prodList", { xtype:"net.nan21.dnet.module.mm.md.dc.Product$List", id:Ext.id(), _controller_:this._dcs_.get("prod") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("prodEdit", { xtype:"net.nan21.dnet.module.mm.md.dc.Product$Edit", id:Ext.id(), _controller_:this._dcs_.get("prod"),height:150 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("prod").isRecordValid = this._dcs_.get("prod").isRecordValid.createInterceptor(function() { return this._getElement_("prodEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("prodFilter")["region"] = "north";			
			this._elems_.get("prodList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("prodFilter") , this._elems_.get("prodList") ]; 				 		
 
			this._elems_.get("prodEdit")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("prodEdit") ]; 				 		
	 	this._linkToolbar_("tlbProdList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbProdEdit", "canvas2");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbProdList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("prod").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbProdList-load"
		this._tlbitms_.add("tlbProdList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("prod")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbProdList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbProdList-edit_sr"
		this._tlbitms_.add("tlbProdList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("prod").doNew(); this._invokeTlbItem_("tlbProdList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProdList-new_sr"
		this._tlbitms_.add("tlbProdList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("prod").doCopy(); this._invokeTlbItem_("tlbProdList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProdList-copy_sr"
		this._tlbitms_.add("tlbProdList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("prod").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProdList-delete_selected_sr"
		this._tlbitms_.add("tlbProdList___S00_", "-") ;
		this._tlbitms_.add("tlbProdList___S01_", "-") ;
		this._tlbitms_.add("tlbProdList___TITLE_",  {xtype:"tbtext", text:"Product"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbProdList__") != -1); } )
		this._tlbs_.add("tlbProdList" , t.getRange() );

		this._getDc_("prod").on("onEdit", function() {this._invokeTlbItem_("tlbProdList__edit_sr");} , this);

	


			this._getDc_("prod").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbProdList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("prod").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbProdList__load")) this._tlbitms_.get("tlbProdList__load").enable();
                 if(this._tlbitms_.get("tlbProdList__new_sr"))this._tlbitms_.get("tlbProdList__new_sr").enable();
                 if(this._tlbitms_.get("tlbProdList__new_mr"))this._tlbitms_.get("tlbProdList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("prod").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbProdList__edit_sr")) this._tlbitms_.get("tlbProdList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbProdList__copy_sr")) this._tlbitms_.get("tlbProdList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbProdList__delete_selected_sr")) this._tlbitms_.get("tlbProdList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbProdList__edit_sr")) this._tlbitms_.get("tlbProdList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbProdList__copy_sr")) this._tlbitms_.get("tlbProdList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbProdList__delete_selected_sr")) this._tlbitms_.get("tlbProdList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbProdEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("prod")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbProdEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbProdEdit-back_sr"
		this._tlbitms_.add("tlbProdEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("prod").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProdEdit-save"
		this._tlbitms_.add("tlbProdEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("prod").doNew(); this._invokeTlbItem_("tlbProdEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProdEdit-new_sr"
		this._tlbitms_.add("tlbProdEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("prod").doCopy(); this._invokeTlbItem_("tlbProdEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProdEdit-copy_sr"
		this._tlbitms_.add("tlbProdEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("prod").getCurrentRecord().phantom) {this._getDc_("prod").discardChanges();this._invokeTlbItem_("tlbProdEdit__back_sr");} else  {this._getDc_("prod").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbProdEdit-rollback_sr"
		this._tlbitms_.add("tlbProdEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("prod").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbProdEdit-prev_rec_sr"
		this._tlbitms_.add("tlbProdEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("prod").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProdEdit-next_rec_sr"
		this._tlbitms_.add("tlbProdEdit___S00_", "-") ;
		this._tlbitms_.add("tlbProdEdit___S01_", "-") ;
		this._tlbitms_.add("tlbProdEdit___TITLE_",  {xtype:"tbtext", text:"Product"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbProdEdit__") != -1); } )
		this._tlbs_.add("tlbProdEdit" , t.getRange() );
	


			this._getDc_("prod").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbProdEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("prod").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbProdEdit__load")) this._tlbitms_.get("tlbProdEdit__load").enable();
                 if(this._tlbitms_.get("tlbProdEdit__new_sr"))this._tlbitms_.get("tlbProdEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbProdEdit__new_mr"))this._tlbitms_.get("tlbProdEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("prod").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbProdEdit__back_sr")) this._tlbitms_.get("tlbProdEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbProdEdit__save")) this._tlbitms_.get("tlbProdEdit__save").enable();
                    if(this._tlbitms_.get("tlbProdEdit__new_sr")) this._tlbitms_.get("tlbProdEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbProdEdit__copy_sr")) this._tlbitms_.get("tlbProdEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbProdEdit__rollback_record_sr")) this._tlbitms_.get("tlbProdEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbProdEdit__rollback_sr")) this._tlbitms_.get("tlbProdEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbProdEdit__prev_rec_sr")) this._tlbitms_.get("tlbProdEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbProdEdit__next_rec_sr")) this._tlbitms_.get("tlbProdEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("prod").on("cleanRecord" , function() {
		  		  if (this._getDc_("prod").isDirty() ) {
                    if(this._tlbitms_.get("tlbProdEdit__back_sr")) this._tlbitms_.get("tlbProdEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbProdEdit__save")) this._tlbitms_.get("tlbProdEdit__save").enable();
                    if(this._tlbitms_.get("tlbProdEdit__new_sr")) this._tlbitms_.get("tlbProdEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbProdEdit__copy_sr")) this._tlbitms_.get("tlbProdEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbProdEdit__rollback_record_sr")) this._tlbitms_.get("tlbProdEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbProdEdit__rollback_sr")) this._tlbitms_.get("tlbProdEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbProdEdit__prev_rec_sr")) this._tlbitms_.get("tlbProdEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbProdEdit__next_rec_sr")) this._tlbitms_.get("tlbProdEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbProdEdit__back_sr")) this._tlbitms_.get("tlbProdEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbProdEdit__save")) this._tlbitms_.get("tlbProdEdit__save").disable();
                  	if(this._tlbitms_.get("tlbProdEdit__new_sr")) this._tlbitms_.get("tlbProdEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbProdEdit__copy_sr")) this._tlbitms_.get("tlbProdEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbProdEdit__rollback_record_sr")) this._tlbitms_.get("tlbProdEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbProdEdit__rollback_sr")) this._tlbitms_.get("tlbProdEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbProdEdit__prev_rec_sr")) this._tlbitms_.get("tlbProdEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbProdEdit__next_rec_sr")) this._tlbitms_.get("tlbProdEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("prod").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbProdEdit__copy_sr")) this._tlbitms_.get("tlbProdEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("prod").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("prodEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.mm.md.frame.Product_UI", net.nan21.dnet.module.mm.md.frame.Product_UI);   
