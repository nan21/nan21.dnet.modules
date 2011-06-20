 
Dnet.import(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrder", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderItemDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrderItem","nan21.dnet.module.sd.ui.extjs/ds/SalesOrderStatusLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesOrderStatus","nan21.dnet.module.sd.ui.extjs/ds/SalesOrderTypeLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesOrderType","nan21.dnet.module.sd.ui.extjs/ds/PriceListLovDs","nan21.dnet.module.sd.ui.extjs/lov/PriceLists","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bp.ui.extjs/ds/DeliveryMethodLovDs","nan21.dnet.module.bp.ui.extjs/lov/DeliveryMethods","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/Customers","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bd.ui.extjs/ds/LocationToBillLovDs","nan21.dnet.module.bd.ui.extjs/lov/LocationsToBill","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bd.ui.extjs/ds/LocationToShipLovDs","nan21.dnet.module.bd.ui.extjs/lov/LocationsToShip","nan21.dnet.module.bp.ui.extjs/ds/DeliveryMethodLovDs","nan21.dnet.module.bp.ui.extjs/lov/DeliveryMethods","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/Customers","nan21.dnet.module.sd.ui.extjs/ds/SalesOrderStatusLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesOrderStatus","nan21.dnet.module.sd.ui.extjs/ds/SalesOrderTypeLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesOrderType","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure"]);

Ext.ns("net.nan21.dnet.module.sd.order.frame");
net.nan21.dnet.module.sd.order.frame.SalesOrder_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.sd.order.frame.SalesOrder_UI"
	
	,_defineDcs_: function () {	
		var  order = new net.nan21.dnet.module.sd.order.dc.SalesOrder({multiEdit:false}), item = new net.nan21.dnet.module.sd.order.dc.SalesOrderItem({multiEdit:true});	 	
		
		this._dcs_.add("order", order);			
		item.setDcContext(new dnet.base.DcContext({childDc:item, parentDc:order, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"salesOrderId", parentField:"id"} ]}}));order.addChild(item);
		this._dcs_.add("item", item);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("orderFilter", { xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$Filter", id:Ext.id(), _controller_:this._dcs_.get("order") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("orderList", { xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$List", id:Ext.id(), _controller_:this._dcs_.get("order") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("orderEdit", { xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$Edit", id:Ext.id(), _controller_:this._dcs_.get("order"),height:150 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("order").isRecordValid = this._dcs_.get("order").isRecordValid.createInterceptor(function() { return this._getElement_("orderEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("itemEditList", { xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderItem$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("item") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("orderFilter")["region"] = "north";			
			this._elems_.get("orderList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("orderFilter") , this._elems_.get("orderList") ]; 				 		
 
			this._elems_.get("orderEdit")["region"] = "north";			
			this._elems_.get("itemEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("orderEdit") , this._elems_.get("itemEditList") ]; 				 		
	 	this._linkToolbar_("tlbOrderList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbOrderEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbItemEditList", "itemEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbOrderList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("order").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderList-load"
		this._tlbitms_.add("tlbOrderList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("order")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbOrderList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderList-edit_sr"
		this._tlbitms_.add("tlbOrderList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("order").doNew(); this._invokeTlbItem_("tlbOrderList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrderList-new_sr"
		this._tlbitms_.add("tlbOrderList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("order").doCopy(); this._invokeTlbItem_("tlbOrderList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrderList-copy_sr"
		this._tlbitms_.add("tlbOrderList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("order").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrderList-delete_selected_sr"
		this._tlbitms_.add("tlbOrderList___S00_", "-") ;
		this._tlbitms_.add("tlbOrderList___S01_", "-") ;
		this._tlbitms_.add("tlbOrderList___TITLE_",  {xtype:"tbtext", text:"SalesOrder"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbOrderList__") != -1); } )
		this._tlbs_.add("tlbOrderList" , t.getRange() );

		this._getDc_("order").on("onEdit", function() {this._invokeTlbItem_("tlbOrderList__edit_sr");} , this);

	


			this._getDc_("order").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbOrderList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("order").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbOrderList__load")) this._tlbitms_.get("tlbOrderList__load").enable();
                 if(this._tlbitms_.get("tlbOrderList__new_sr"))this._tlbitms_.get("tlbOrderList__new_sr").enable();
                 if(this._tlbitms_.get("tlbOrderList__new_mr"))this._tlbitms_.get("tlbOrderList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("order").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbOrderList__edit_sr")) this._tlbitms_.get("tlbOrderList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbOrderList__copy_sr")) this._tlbitms_.get("tlbOrderList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbOrderList__delete_selected_sr")) this._tlbitms_.get("tlbOrderList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbOrderList__edit_sr")) this._tlbitms_.get("tlbOrderList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbOrderList__copy_sr")) this._tlbitms_.get("tlbOrderList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbOrderList__delete_selected_sr")) this._tlbitms_.get("tlbOrderList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbOrderEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("order")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbOrderEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderEdit-back_sr"
		this._tlbitms_.add("tlbOrderEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("order").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrderEdit-save"
		this._tlbitms_.add("tlbOrderEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("order").doNew(); this._invokeTlbItem_("tlbOrderEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrderEdit-new_sr"
		this._tlbitms_.add("tlbOrderEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("order").doCopy(); this._invokeTlbItem_("tlbOrderEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrderEdit-copy_sr"
		this._tlbitms_.add("tlbOrderEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("order").getCurrentRecord().phantom) {this._getDc_("order").discardChanges();this._invokeTlbItem_("tlbOrderEdit__back_sr");} else  {this._getDc_("order").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderEdit-rollback_sr"
		this._tlbitms_.add("tlbOrderEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("order").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderEdit-prev_rec_sr"
		this._tlbitms_.add("tlbOrderEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("order").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrderEdit-next_rec_sr"
		this._tlbitms_.add("tlbOrderEdit___S00_", "-") ;
		this._tlbitms_.add("tlbOrderEdit___S01_", "-") ;
		this._tlbitms_.add("tlbOrderEdit___TITLE_",  {xtype:"tbtext", text:"SalesOrder"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbOrderEdit__") != -1); } )
		this._tlbs_.add("tlbOrderEdit" , t.getRange() );
	


			this._getDc_("order").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbOrderEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("order").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbOrderEdit__load")) this._tlbitms_.get("tlbOrderEdit__load").enable();
                 if(this._tlbitms_.get("tlbOrderEdit__new_sr"))this._tlbitms_.get("tlbOrderEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbOrderEdit__new_mr"))this._tlbitms_.get("tlbOrderEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("order").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbOrderEdit__back_sr")) this._tlbitms_.get("tlbOrderEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbOrderEdit__save")) this._tlbitms_.get("tlbOrderEdit__save").enable();
                    if(this._tlbitms_.get("tlbOrderEdit__new_sr")) this._tlbitms_.get("tlbOrderEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbOrderEdit__copy_sr")) this._tlbitms_.get("tlbOrderEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbOrderEdit__rollback_record_sr")) this._tlbitms_.get("tlbOrderEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbOrderEdit__rollback_sr")) this._tlbitms_.get("tlbOrderEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbOrderEdit__prev_rec_sr")) this._tlbitms_.get("tlbOrderEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbOrderEdit__next_rec_sr")) this._tlbitms_.get("tlbOrderEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("order").on("cleanRecord" , function() {
		  		  if (this._getDc_("order").isDirty() ) {
                    if(this._tlbitms_.get("tlbOrderEdit__back_sr")) this._tlbitms_.get("tlbOrderEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbOrderEdit__save")) this._tlbitms_.get("tlbOrderEdit__save").enable();
                    if(this._tlbitms_.get("tlbOrderEdit__new_sr")) this._tlbitms_.get("tlbOrderEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbOrderEdit__copy_sr")) this._tlbitms_.get("tlbOrderEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbOrderEdit__rollback_record_sr")) this._tlbitms_.get("tlbOrderEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbOrderEdit__rollback_sr")) this._tlbitms_.get("tlbOrderEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbOrderEdit__prev_rec_sr")) this._tlbitms_.get("tlbOrderEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbOrderEdit__next_rec_sr")) this._tlbitms_.get("tlbOrderEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbOrderEdit__back_sr")) this._tlbitms_.get("tlbOrderEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbOrderEdit__save")) this._tlbitms_.get("tlbOrderEdit__save").disable();
                  	if(this._tlbitms_.get("tlbOrderEdit__new_sr")) this._tlbitms_.get("tlbOrderEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbOrderEdit__copy_sr")) this._tlbitms_.get("tlbOrderEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbOrderEdit__rollback_record_sr")) this._tlbitms_.get("tlbOrderEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbOrderEdit__rollback_sr")) this._tlbitms_.get("tlbOrderEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbOrderEdit__prev_rec_sr")) this._tlbitms_.get("tlbOrderEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbOrderEdit__next_rec_sr")) this._tlbitms_.get("tlbOrderEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("order").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbOrderEdit__copy_sr")) this._tlbitms_.get("tlbOrderEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbItemEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("item").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-load"
		this._tlbitms_.add("tlbItemEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("item").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbItemEditList-save_mr"
		this._tlbitms_.add("tlbItemEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("item").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-new_mr"
		this._tlbitms_.add("tlbItemEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("item").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-copy_mr"
		this._tlbitms_.add("tlbItemEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("item").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-delete_mr"
		this._tlbitms_.add("tlbItemEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("item").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-rollback_mr"
		this._tlbitms_.add("tlbItemEditList___S00_", "-") ;
		this._tlbitms_.add("tlbItemEditList___S01_", "-") ;
		this._tlbitms_.add("tlbItemEditList___TITLE_",  {xtype:"tbtext", text:"SalesOrderItem"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbItemEditList__") != -1); } )
		this._tlbs_.add("tlbItemEditList" , t.getRange() );
	


			this._getDc_("item").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbItemEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("item").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbItemEditList__load")) this._tlbitms_.get("tlbItemEditList__load").enable();
                 if(this._tlbitms_.get("tlbItemEditList__new_sr"))this._tlbitms_.get("tlbItemEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbItemEditList__new_mr"))this._tlbitms_.get("tlbItemEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("item").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbItemEditList__copy_mr")) this._tlbitms_.get("tlbItemEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbItemEditList__delete_mr")) this._tlbitms_.get("tlbItemEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbItemEditList__copy_mr")) this._tlbitms_.get("tlbItemEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbItemEditList__delete_mr")) this._tlbitms_.get("tlbItemEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("item").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbItemEditList__load")) this._tlbitms_.get("tlbItemEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbItemEditList__save_mr")) this._tlbitms_.get("tlbItemEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbItemEditList__rollback_record_mr"))this._tlbitms_.get("tlbItemEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbItemEditList__rollback_mr"))this._tlbitms_.get("tlbItemEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("item").on("cleanRecord" , function() {
		  		  if (this._getDc_("item").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbItemEditList__load")) this._tlbitms_.get("tlbItemEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbItemEditList__save_mr"))this._tlbitms_.get("tlbItemEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbItemEditList__rollback_record_mr"))this._tlbitms_.get("tlbItemEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbItemEditList__rollback_mr"))this._tlbitms_.get("tlbItemEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbItemEditList__load")) this._tlbitms_.get("tlbItemEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbItemEditList__back_mr"))this._tlbitms_.get("tlbItemEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbItemEditList__save_mr"))this._tlbitms_.get("tlbItemEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbItemEditList__rollback_record_mr"))this._tlbitms_.get("tlbItemEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbItemEditList__rollback_mr"))this._tlbitms_.get("tlbItemEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("order").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("orderEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("item").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.sd.order.frame.SalesOrder_UI", net.nan21.dnet.module.sd.order.frame.SalesOrder_UI);   
