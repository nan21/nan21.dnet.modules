 
Dnet.import(["", "nan21.dnet.module.bp.ui.extjs/ds/CustomerGroupDs", "nan21.dnet.module.bp.ui.extjs/dc/CustomerGroup", "nan21.dnet.module.bp.ui.extjs/ds/VendorGroupDs", "nan21.dnet.module.bp.ui.extjs/dc/VendorGroup", "nan21.dnet.module.bp.ui.extjs/ds/DeliveryMethodDs", "nan21.dnet.module.bp.ui.extjs/dc/DeliveryMethod", "nan21.dnet.module.bp.ui.extjs/ds/PaymentMethodDs", "nan21.dnet.module.bp.ui.extjs/dc/PaymentMethod", "nan21.dnet.module.bp.ui.extjs/ds/PaymentTermDs", "nan21.dnet.module.bp.ui.extjs/dc/PaymentTerm"]);

Ext.ns("net.nan21.dnet.module.bp.base.frame");
net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI"
	
	,_defineDcs_: function () {	
		var  custGroup = new net.nan21.dnet.module.bp.base.dc.CustomerGroup({multiEdit:true}), vendGroup = new net.nan21.dnet.module.bp.base.dc.VendorGroup({multiEdit:true}), delivMtd = new net.nan21.dnet.module.bp.base.dc.DeliveryMethod({multiEdit:true}), payMtd = new net.nan21.dnet.module.bp.base.dc.PaymentMethod({multiEdit:true}), payTerm = new net.nan21.dnet.module.bp.base.dc.PaymentTerm({multiEdit:true});	 	
		
		this._dcs_.add("custGroup", custGroup);			
		
		this._dcs_.add("vendGroup", vendGroup);			
		
		this._dcs_.add("delivMtd", delivMtd);			
		
		this._dcs_.add("payMtd", payMtd);			
		
		this._dcs_.add("payTerm", payTerm);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
			
		this._mainViewName_  = "_main_with_toc_";
		this._elems_.add("_main_with_toc_", { layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		});
		this._elems_.add("_toc_", { xtype: 'treepanel',collapsible: true, title: 'Navigation',width: 250,autoScroll: true,split: true,rootVisible: false,loader: new Ext.tree.TreeLoader()
			,minWidth:150, maxWidth:500
			,root: new Ext.tree.AsyncTreeNode({expanded: true,
            children: [{ text:"Customer groups", leaf: true , name:"canvas1"},{ text:"Vendor groups", leaf: true , name:"canvas2"},{ text:"Delivery methods", leaf: true , name:"canvas3"},{ text:"Payment methods", leaf: true , name:"canvas4"},{ text:"Payment terms", leaf: true , name:"canvas5"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		});	 
		this._elems_.add("custGroupFilter", { xtype:"net.nan21.dnet.module.bp.base.dc.CustomerGroup$Filter", id:Ext.id(), _controller_:this._dcs_.get("custGroup"),height:40 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("custGroupEditList", { xtype:"net.nan21.dnet.module.bp.base.dc.CustomerGroup$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("custGroup") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("vendGroupFilter", { xtype:"net.nan21.dnet.module.bp.base.dc.VendorGroup$Filter", id:Ext.id(), _controller_:this._dcs_.get("vendGroup"),height:40 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("vendGroupEditList", { xtype:"net.nan21.dnet.module.bp.base.dc.VendorGroup$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("vendGroup") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("delivMtdFilter", { xtype:"net.nan21.dnet.module.bp.base.dc.DeliveryMethod$Filter", id:Ext.id(), _controller_:this._dcs_.get("delivMtd"),height:40 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("delivMtdEditList", { xtype:"net.nan21.dnet.module.bp.base.dc.DeliveryMethod$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("delivMtd") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("payMtdFilter", { xtype:"net.nan21.dnet.module.bp.base.dc.PaymentMethod$Filter", id:Ext.id(), _controller_:this._dcs_.get("payMtd"),height:40 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("payMtdEditList", { xtype:"net.nan21.dnet.module.bp.base.dc.PaymentMethod$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("payMtd") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("payTermFilter", { xtype:"net.nan21.dnet.module.bp.base.dc.PaymentTerm$Filter", id:Ext.id(), _controller_:this._dcs_.get("payTerm"),height:40 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("payTermEditList", { xtype:"net.nan21.dnet.module.bp.base.dc.PaymentTerm$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("payTerm") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Customer groups",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Vendor groups",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas3", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Delivery methods",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas4", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Payment methods",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas5", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Payment terms",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
			
		this._elems_.get("main")["region"] = "center";
		this._elems_.get("_toc_")["region"] = "west";
		this._elems_.get("_main_with_toc_")["items"] = [ this._elems_.get("main") , this._elems_.get("_toc_")];
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") , this._elems_.get("canvas3") , this._elems_.get("canvas4") , this._elems_.get("canvas5") ]; 				 		
 
			this._elems_.get("custGroupFilter")["region"] = "north";			
			this._elems_.get("custGroupEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("custGroupFilter") , this._elems_.get("custGroupEditList") ]; 				 		
 
			this._elems_.get("vendGroupFilter")["region"] = "north";			
			this._elems_.get("vendGroupEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("vendGroupFilter") , this._elems_.get("vendGroupEditList") ]; 				 		
 
			this._elems_.get("delivMtdFilter")["region"] = "north";			
			this._elems_.get("delivMtdEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas3")["items"] = [ this._elems_.get("delivMtdFilter") , this._elems_.get("delivMtdEditList") ]; 				 		
 
			this._elems_.get("payMtdFilter")["region"] = "north";			
			this._elems_.get("payMtdEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas4")["items"] = [ this._elems_.get("payMtdFilter") , this._elems_.get("payMtdEditList") ]; 				 		
 
			this._elems_.get("payTermFilter")["region"] = "north";			
			this._elems_.get("payTermEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas5")["items"] = [ this._elems_.get("payTermFilter") , this._elems_.get("payTermEditList") ]; 				 		
	 	this._linkToolbar_("tlbcustGroup", "canvas1");	 	  	
	 	this._linkToolbar_("tlbvendGroup", "canvas2");	 	  	
	 	this._linkToolbar_("tlbdelivMtd", "canvas3");	 	  	
	 	this._linkToolbar_("tlbpayMtd", "canvas4");	 	  	
	 	this._linkToolbar_("tlbpayTerm", "canvas5");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbcustGroup__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("custGroup").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbcustGroup-load"
		this._tlbitms_.add("tlbcustGroup__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("custGroup").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbcustGroup-save_mr"
		this._tlbitms_.add("tlbcustGroup__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("custGroup").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbcustGroup-new_mr"
		this._tlbitms_.add("tlbcustGroup__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("custGroup").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbcustGroup-copy_mr"
		this._tlbitms_.add("tlbcustGroup__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("custGroup").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbcustGroup-delete_mr"
		this._tlbitms_.add("tlbcustGroup__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("custGroup").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbcustGroup-rollback_mr"
		this._tlbitms_.add("tlbcustGroup___S00_", "-") ;
		this._tlbitms_.add("tlbcustGroup___S01_", "-") ;
		this._tlbitms_.add("tlbcustGroup___TITLE_",  {xtype:"tbtext", text:"CustomerGroup"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbcustGroup__") != -1); } )
		this._tlbs_.add("tlbcustGroup" , t.getRange() );
	


			this._getDc_("custGroup").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbcustGroup__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("custGroup").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbcustGroup__load")) this._tlbitms_.get("tlbcustGroup__load").enable();
                 if(this._tlbitms_.get("tlbcustGroup__new_sr"))this._tlbitms_.get("tlbcustGroup__new_sr").enable();
                 if(this._tlbitms_.get("tlbcustGroup__new_mr"))this._tlbitms_.get("tlbcustGroup__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("custGroup").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbcustGroup__copy_mr")) this._tlbitms_.get("tlbcustGroup__copy_mr").enable();
                        if(this._tlbitms_.get("tlbcustGroup__delete_mr")) this._tlbitms_.get("tlbcustGroup__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbcustGroup__copy_mr")) this._tlbitms_.get("tlbcustGroup__copy_mr").disable();
                       if(this._tlbitms_.get("tlbcustGroup__delete_mr")) this._tlbitms_.get("tlbcustGroup__delete_mr").disable();
					}

			  } , this );
			this._getDc_("custGroup").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbcustGroup__load")) this._tlbitms_.get("tlbcustGroup__load").disable();		  			 
                    if(this._tlbitms_.get("tlbcustGroup__save_mr")) this._tlbitms_.get("tlbcustGroup__save_mr").enable();
                    if(this._tlbitms_.get("tlbcustGroup__rollback_record_mr"))this._tlbitms_.get("tlbcustGroup__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbcustGroup__rollback_mr"))this._tlbitms_.get("tlbcustGroup__rollback_mr").enable();
			  } , this );

			this._getDc_("custGroup").on("cleanRecord" , function() {
		  		  if (this._getDc_("custGroup").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbcustGroup__load")) this._tlbitms_.get("tlbcustGroup__load").disable();	                
                    if(this._tlbitms_.get("tlbcustGroup__save_mr"))this._tlbitms_.get("tlbcustGroup__save_mr").enable();
                    if(this._tlbitms_.get("tlbcustGroup__rollback_record_mr"))this._tlbitms_.get("tlbcustGroup__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbcustGroup__rollback_mr"))this._tlbitms_.get("tlbcustGroup__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbcustGroup__load")) this._tlbitms_.get("tlbcustGroup__load").enable();	
                  	if(this._tlbitms_.get("tlbcustGroup__back_mr"))this._tlbitms_.get("tlbcustGroup__back_mr").enable();
                  	if(this._tlbitms_.get("tlbcustGroup__save_mr"))this._tlbitms_.get("tlbcustGroup__save_mr").disable();
                  	if(this._tlbitms_.get("tlbcustGroup__rollback_record_mr"))this._tlbitms_.get("tlbcustGroup__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbcustGroup__rollback_mr"))this._tlbitms_.get("tlbcustGroup__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbvendGroup__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("vendGroup").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbvendGroup-load"
		this._tlbitms_.add("tlbvendGroup__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("vendGroup").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbvendGroup-save_mr"
		this._tlbitms_.add("tlbvendGroup__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("vendGroup").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbvendGroup-new_mr"
		this._tlbitms_.add("tlbvendGroup__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("vendGroup").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbvendGroup-copy_mr"
		this._tlbitms_.add("tlbvendGroup__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("vendGroup").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbvendGroup-delete_mr"
		this._tlbitms_.add("tlbvendGroup__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("vendGroup").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbvendGroup-rollback_mr"
		this._tlbitms_.add("tlbvendGroup___S00_", "-") ;
		this._tlbitms_.add("tlbvendGroup___S01_", "-") ;
		this._tlbitms_.add("tlbvendGroup___TITLE_",  {xtype:"tbtext", text:"VendorGroup"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbvendGroup__") != -1); } )
		this._tlbs_.add("tlbvendGroup" , t.getRange() );
	


			this._getDc_("vendGroup").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbvendGroup__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("vendGroup").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbvendGroup__load")) this._tlbitms_.get("tlbvendGroup__load").enable();
                 if(this._tlbitms_.get("tlbvendGroup__new_sr"))this._tlbitms_.get("tlbvendGroup__new_sr").enable();
                 if(this._tlbitms_.get("tlbvendGroup__new_mr"))this._tlbitms_.get("tlbvendGroup__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("vendGroup").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbvendGroup__copy_mr")) this._tlbitms_.get("tlbvendGroup__copy_mr").enable();
                        if(this._tlbitms_.get("tlbvendGroup__delete_mr")) this._tlbitms_.get("tlbvendGroup__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbvendGroup__copy_mr")) this._tlbitms_.get("tlbvendGroup__copy_mr").disable();
                       if(this._tlbitms_.get("tlbvendGroup__delete_mr")) this._tlbitms_.get("tlbvendGroup__delete_mr").disable();
					}

			  } , this );
			this._getDc_("vendGroup").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbvendGroup__load")) this._tlbitms_.get("tlbvendGroup__load").disable();		  			 
                    if(this._tlbitms_.get("tlbvendGroup__save_mr")) this._tlbitms_.get("tlbvendGroup__save_mr").enable();
                    if(this._tlbitms_.get("tlbvendGroup__rollback_record_mr"))this._tlbitms_.get("tlbvendGroup__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbvendGroup__rollback_mr"))this._tlbitms_.get("tlbvendGroup__rollback_mr").enable();
			  } , this );

			this._getDc_("vendGroup").on("cleanRecord" , function() {
		  		  if (this._getDc_("vendGroup").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbvendGroup__load")) this._tlbitms_.get("tlbvendGroup__load").disable();	                
                    if(this._tlbitms_.get("tlbvendGroup__save_mr"))this._tlbitms_.get("tlbvendGroup__save_mr").enable();
                    if(this._tlbitms_.get("tlbvendGroup__rollback_record_mr"))this._tlbitms_.get("tlbvendGroup__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbvendGroup__rollback_mr"))this._tlbitms_.get("tlbvendGroup__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbvendGroup__load")) this._tlbitms_.get("tlbvendGroup__load").enable();	
                  	if(this._tlbitms_.get("tlbvendGroup__back_mr"))this._tlbitms_.get("tlbvendGroup__back_mr").enable();
                  	if(this._tlbitms_.get("tlbvendGroup__save_mr"))this._tlbitms_.get("tlbvendGroup__save_mr").disable();
                  	if(this._tlbitms_.get("tlbvendGroup__rollback_record_mr"))this._tlbitms_.get("tlbvendGroup__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbvendGroup__rollback_mr"))this._tlbitms_.get("tlbvendGroup__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbdelivMtd__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("delivMtd").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbdelivMtd-load"
		this._tlbitms_.add("tlbdelivMtd__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("delivMtd").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbdelivMtd-save_mr"
		this._tlbitms_.add("tlbdelivMtd__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("delivMtd").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbdelivMtd-new_mr"
		this._tlbitms_.add("tlbdelivMtd__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("delivMtd").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbdelivMtd-copy_mr"
		this._tlbitms_.add("tlbdelivMtd__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("delivMtd").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbdelivMtd-delete_mr"
		this._tlbitms_.add("tlbdelivMtd__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("delivMtd").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbdelivMtd-rollback_mr"
		this._tlbitms_.add("tlbdelivMtd___S00_", "-") ;
		this._tlbitms_.add("tlbdelivMtd___S01_", "-") ;
		this._tlbitms_.add("tlbdelivMtd___TITLE_",  {xtype:"tbtext", text:"DeliveryMethod"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbdelivMtd__") != -1); } )
		this._tlbs_.add("tlbdelivMtd" , t.getRange() );
	


			this._getDc_("delivMtd").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbdelivMtd__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("delivMtd").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbdelivMtd__load")) this._tlbitms_.get("tlbdelivMtd__load").enable();
                 if(this._tlbitms_.get("tlbdelivMtd__new_sr"))this._tlbitms_.get("tlbdelivMtd__new_sr").enable();
                 if(this._tlbitms_.get("tlbdelivMtd__new_mr"))this._tlbitms_.get("tlbdelivMtd__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("delivMtd").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbdelivMtd__copy_mr")) this._tlbitms_.get("tlbdelivMtd__copy_mr").enable();
                        if(this._tlbitms_.get("tlbdelivMtd__delete_mr")) this._tlbitms_.get("tlbdelivMtd__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbdelivMtd__copy_mr")) this._tlbitms_.get("tlbdelivMtd__copy_mr").disable();
                       if(this._tlbitms_.get("tlbdelivMtd__delete_mr")) this._tlbitms_.get("tlbdelivMtd__delete_mr").disable();
					}

			  } , this );
			this._getDc_("delivMtd").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbdelivMtd__load")) this._tlbitms_.get("tlbdelivMtd__load").disable();		  			 
                    if(this._tlbitms_.get("tlbdelivMtd__save_mr")) this._tlbitms_.get("tlbdelivMtd__save_mr").enable();
                    if(this._tlbitms_.get("tlbdelivMtd__rollback_record_mr"))this._tlbitms_.get("tlbdelivMtd__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbdelivMtd__rollback_mr"))this._tlbitms_.get("tlbdelivMtd__rollback_mr").enable();
			  } , this );

			this._getDc_("delivMtd").on("cleanRecord" , function() {
		  		  if (this._getDc_("delivMtd").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbdelivMtd__load")) this._tlbitms_.get("tlbdelivMtd__load").disable();	                
                    if(this._tlbitms_.get("tlbdelivMtd__save_mr"))this._tlbitms_.get("tlbdelivMtd__save_mr").enable();
                    if(this._tlbitms_.get("tlbdelivMtd__rollback_record_mr"))this._tlbitms_.get("tlbdelivMtd__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbdelivMtd__rollback_mr"))this._tlbitms_.get("tlbdelivMtd__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbdelivMtd__load")) this._tlbitms_.get("tlbdelivMtd__load").enable();	
                  	if(this._tlbitms_.get("tlbdelivMtd__back_mr"))this._tlbitms_.get("tlbdelivMtd__back_mr").enable();
                  	if(this._tlbitms_.get("tlbdelivMtd__save_mr"))this._tlbitms_.get("tlbdelivMtd__save_mr").disable();
                  	if(this._tlbitms_.get("tlbdelivMtd__rollback_record_mr"))this._tlbitms_.get("tlbdelivMtd__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbdelivMtd__rollback_mr"))this._tlbitms_.get("tlbdelivMtd__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbpayMtd__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("payMtd").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbpayMtd-load"
		this._tlbitms_.add("tlbpayMtd__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("payMtd").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbpayMtd-save_mr"
		this._tlbitms_.add("tlbpayMtd__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("payMtd").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbpayMtd-new_mr"
		this._tlbitms_.add("tlbpayMtd__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("payMtd").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbpayMtd-copy_mr"
		this._tlbitms_.add("tlbpayMtd__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("payMtd").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbpayMtd-delete_mr"
		this._tlbitms_.add("tlbpayMtd__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("payMtd").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbpayMtd-rollback_mr"
		this._tlbitms_.add("tlbpayMtd___S00_", "-") ;
		this._tlbitms_.add("tlbpayMtd___S01_", "-") ;
		this._tlbitms_.add("tlbpayMtd___TITLE_",  {xtype:"tbtext", text:"PaymentMethod"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbpayMtd__") != -1); } )
		this._tlbs_.add("tlbpayMtd" , t.getRange() );
	


			this._getDc_("payMtd").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbpayMtd__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("payMtd").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbpayMtd__load")) this._tlbitms_.get("tlbpayMtd__load").enable();
                 if(this._tlbitms_.get("tlbpayMtd__new_sr"))this._tlbitms_.get("tlbpayMtd__new_sr").enable();
                 if(this._tlbitms_.get("tlbpayMtd__new_mr"))this._tlbitms_.get("tlbpayMtd__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("payMtd").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbpayMtd__copy_mr")) this._tlbitms_.get("tlbpayMtd__copy_mr").enable();
                        if(this._tlbitms_.get("tlbpayMtd__delete_mr")) this._tlbitms_.get("tlbpayMtd__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbpayMtd__copy_mr")) this._tlbitms_.get("tlbpayMtd__copy_mr").disable();
                       if(this._tlbitms_.get("tlbpayMtd__delete_mr")) this._tlbitms_.get("tlbpayMtd__delete_mr").disable();
					}

			  } , this );
			this._getDc_("payMtd").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbpayMtd__load")) this._tlbitms_.get("tlbpayMtd__load").disable();		  			 
                    if(this._tlbitms_.get("tlbpayMtd__save_mr")) this._tlbitms_.get("tlbpayMtd__save_mr").enable();
                    if(this._tlbitms_.get("tlbpayMtd__rollback_record_mr"))this._tlbitms_.get("tlbpayMtd__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbpayMtd__rollback_mr"))this._tlbitms_.get("tlbpayMtd__rollback_mr").enable();
			  } , this );

			this._getDc_("payMtd").on("cleanRecord" , function() {
		  		  if (this._getDc_("payMtd").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbpayMtd__load")) this._tlbitms_.get("tlbpayMtd__load").disable();	                
                    if(this._tlbitms_.get("tlbpayMtd__save_mr"))this._tlbitms_.get("tlbpayMtd__save_mr").enable();
                    if(this._tlbitms_.get("tlbpayMtd__rollback_record_mr"))this._tlbitms_.get("tlbpayMtd__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbpayMtd__rollback_mr"))this._tlbitms_.get("tlbpayMtd__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbpayMtd__load")) this._tlbitms_.get("tlbpayMtd__load").enable();	
                  	if(this._tlbitms_.get("tlbpayMtd__back_mr"))this._tlbitms_.get("tlbpayMtd__back_mr").enable();
                  	if(this._tlbitms_.get("tlbpayMtd__save_mr"))this._tlbitms_.get("tlbpayMtd__save_mr").disable();
                  	if(this._tlbitms_.get("tlbpayMtd__rollback_record_mr"))this._tlbitms_.get("tlbpayMtd__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbpayMtd__rollback_mr"))this._tlbitms_.get("tlbpayMtd__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbpayTerm__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("payTerm").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbpayTerm-load"
		this._tlbitms_.add("tlbpayTerm__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("payTerm").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbpayTerm-save_mr"
		this._tlbitms_.add("tlbpayTerm__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("payTerm").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbpayTerm-new_mr"
		this._tlbitms_.add("tlbpayTerm__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("payTerm").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbpayTerm-copy_mr"
		this._tlbitms_.add("tlbpayTerm__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("payTerm").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbpayTerm-delete_mr"
		this._tlbitms_.add("tlbpayTerm__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("payTerm").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbpayTerm-rollback_mr"
		this._tlbitms_.add("tlbpayTerm___S00_", "-") ;
		this._tlbitms_.add("tlbpayTerm___S01_", "-") ;
		this._tlbitms_.add("tlbpayTerm___TITLE_",  {xtype:"tbtext", text:"PaymentTerm"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbpayTerm__") != -1); } )
		this._tlbs_.add("tlbpayTerm" , t.getRange() );
	


			this._getDc_("payTerm").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbpayTerm__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("payTerm").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbpayTerm__load")) this._tlbitms_.get("tlbpayTerm__load").enable();
                 if(this._tlbitms_.get("tlbpayTerm__new_sr"))this._tlbitms_.get("tlbpayTerm__new_sr").enable();
                 if(this._tlbitms_.get("tlbpayTerm__new_mr"))this._tlbitms_.get("tlbpayTerm__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("payTerm").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbpayTerm__copy_mr")) this._tlbitms_.get("tlbpayTerm__copy_mr").enable();
                        if(this._tlbitms_.get("tlbpayTerm__delete_mr")) this._tlbitms_.get("tlbpayTerm__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbpayTerm__copy_mr")) this._tlbitms_.get("tlbpayTerm__copy_mr").disable();
                       if(this._tlbitms_.get("tlbpayTerm__delete_mr")) this._tlbitms_.get("tlbpayTerm__delete_mr").disable();
					}

			  } , this );
			this._getDc_("payTerm").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbpayTerm__load")) this._tlbitms_.get("tlbpayTerm__load").disable();		  			 
                    if(this._tlbitms_.get("tlbpayTerm__save_mr")) this._tlbitms_.get("tlbpayTerm__save_mr").enable();
                    if(this._tlbitms_.get("tlbpayTerm__rollback_record_mr"))this._tlbitms_.get("tlbpayTerm__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbpayTerm__rollback_mr"))this._tlbitms_.get("tlbpayTerm__rollback_mr").enable();
			  } , this );

			this._getDc_("payTerm").on("cleanRecord" , function() {
		  		  if (this._getDc_("payTerm").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbpayTerm__load")) this._tlbitms_.get("tlbpayTerm__load").disable();	                
                    if(this._tlbitms_.get("tlbpayTerm__save_mr"))this._tlbitms_.get("tlbpayTerm__save_mr").enable();
                    if(this._tlbitms_.get("tlbpayTerm__rollback_record_mr"))this._tlbitms_.get("tlbpayTerm__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbpayTerm__rollback_mr"))this._tlbitms_.get("tlbpayTerm__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbpayTerm__load")) this._tlbitms_.get("tlbpayTerm__load").enable();	
                  	if(this._tlbitms_.get("tlbpayTerm__back_mr"))this._tlbitms_.get("tlbpayTerm__back_mr").enable();
                  	if(this._tlbitms_.get("tlbpayTerm__save_mr"))this._tlbitms_.get("tlbpayTerm__save_mr").disable();
                  	if(this._tlbitms_.get("tlbpayTerm__rollback_record_mr"))this._tlbitms_.get("tlbpayTerm__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbpayTerm__rollback_mr"))this._tlbitms_.get("tlbpayTerm__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("custGroup").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("vendGroup").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("delivMtd").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("payMtd").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("payTerm").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI", net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI);   
