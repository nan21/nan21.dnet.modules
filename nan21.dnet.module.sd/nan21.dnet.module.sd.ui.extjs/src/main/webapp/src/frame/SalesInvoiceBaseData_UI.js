 
Dnet.import(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceTypeDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoiceType", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceStatusDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoiceStatus"]);

Ext.ns("net.nan21.dnet.module.sd.invoice.frame");
net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI"
	
	,_defineDcs_: function () {	
		var  invType = new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceType({multiEdit:true}), invStatus = new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceStatus({multiEdit:true});	 	
		
		this._dcs_.add("invType", invType);			
		
		this._dcs_.add("invStatus", invStatus);			
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
            children: [{ text:"Invoice type", leaf: true , name:"canvas1"},{ text:"Invoice status", leaf: true , name:"canvas2"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		});	 
		this._elems_.add("invTypeFilter", { xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceType$Filter", id:Ext.id(), _controller_:this._dcs_.get("invType"),height:30 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("invTypeEditList", { xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceType$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("invType") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("invStatusFilter", { xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceStatus$Filter", id:Ext.id(), _controller_:this._dcs_.get("invStatus"),height:30 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("invStatusEditList", { xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceStatus$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("invStatus") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Invoice type",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Invoice status",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
			
		this._elems_.get("main")["region"] = "center";
		this._elems_.get("_toc_")["region"] = "west";
		this._elems_.get("_main_with_toc_")["items"] = [ this._elems_.get("main") , this._elems_.get("_toc_")];
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("invTypeFilter")["region"] = "north";			
			this._elems_.get("invTypeEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("invTypeFilter") , this._elems_.get("invTypeEditList") ]; 				 		
 
			this._elems_.get("invStatusFilter")["region"] = "north";			
			this._elems_.get("invStatusEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("invStatusFilter") , this._elems_.get("invStatusEditList") ]; 				 		
	 	this._linkToolbar_("tlbInvType", "canvas1");	 	  	
	 	this._linkToolbar_("tlbInvStatus", "canvas2");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbInvType__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("invType").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvType-load"
		this._tlbitms_.add("tlbInvType__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("invType").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbInvType-save_mr"
		this._tlbitms_.add("tlbInvType__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("invType").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvType-new_mr"
		this._tlbitms_.add("tlbInvType__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("invType").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvType-copy_mr"
		this._tlbitms_.add("tlbInvType__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("invType").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvType-delete_mr"
		this._tlbitms_.add("tlbInvType__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("invType").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvType-rollback_mr"
		this._tlbitms_.add("tlbInvType___S00_", "-") ;
		this._tlbitms_.add("tlbInvType___S01_", "-") ;
		this._tlbitms_.add("tlbInvType___TITLE_",  {xtype:"tbtext", text:"SalesInvoiceType"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbInvType__") != -1); } )
		this._tlbs_.add("tlbInvType" , t.getRange() );
	


			this._getDc_("invType").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbInvType__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("invType").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbInvType__load")) this._tlbitms_.get("tlbInvType__load").enable();
                 if(this._tlbitms_.get("tlbInvType__new_sr"))this._tlbitms_.get("tlbInvType__new_sr").enable();
                 if(this._tlbitms_.get("tlbInvType__new_mr"))this._tlbitms_.get("tlbInvType__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("invType").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbInvType__copy_mr")) this._tlbitms_.get("tlbInvType__copy_mr").enable();
                        if(this._tlbitms_.get("tlbInvType__delete_mr")) this._tlbitms_.get("tlbInvType__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbInvType__copy_mr")) this._tlbitms_.get("tlbInvType__copy_mr").disable();
                       if(this._tlbitms_.get("tlbInvType__delete_mr")) this._tlbitms_.get("tlbInvType__delete_mr").disable();
					}

			  } , this );
			this._getDc_("invType").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbInvType__load")) this._tlbitms_.get("tlbInvType__load").disable();		  			 
                    if(this._tlbitms_.get("tlbInvType__save_mr")) this._tlbitms_.get("tlbInvType__save_mr").enable();
                    if(this._tlbitms_.get("tlbInvType__rollback_record_mr"))this._tlbitms_.get("tlbInvType__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbInvType__rollback_mr"))this._tlbitms_.get("tlbInvType__rollback_mr").enable();
			  } , this );

			this._getDc_("invType").on("cleanRecord" , function() {
		  		  if (this._getDc_("invType").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbInvType__load")) this._tlbitms_.get("tlbInvType__load").disable();	                
                    if(this._tlbitms_.get("tlbInvType__save_mr"))this._tlbitms_.get("tlbInvType__save_mr").enable();
                    if(this._tlbitms_.get("tlbInvType__rollback_record_mr"))this._tlbitms_.get("tlbInvType__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbInvType__rollback_mr"))this._tlbitms_.get("tlbInvType__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbInvType__load")) this._tlbitms_.get("tlbInvType__load").enable();	
                  	if(this._tlbitms_.get("tlbInvType__back_mr"))this._tlbitms_.get("tlbInvType__back_mr").enable();
                  	if(this._tlbitms_.get("tlbInvType__save_mr"))this._tlbitms_.get("tlbInvType__save_mr").disable();
                  	if(this._tlbitms_.get("tlbInvType__rollback_record_mr"))this._tlbitms_.get("tlbInvType__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbInvType__rollback_mr"))this._tlbitms_.get("tlbInvType__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbInvStatus__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("invStatus").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvStatus-load"
		this._tlbitms_.add("tlbInvStatus__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("invStatus").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbInvStatus-save_mr"
		this._tlbitms_.add("tlbInvStatus__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("invStatus").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvStatus-new_mr"
		this._tlbitms_.add("tlbInvStatus__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("invStatus").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvStatus-copy_mr"
		this._tlbitms_.add("tlbInvStatus__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("invStatus").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvStatus-delete_mr"
		this._tlbitms_.add("tlbInvStatus__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("invStatus").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbInvStatus-rollback_mr"
		this._tlbitms_.add("tlbInvStatus___S00_", "-") ;
		this._tlbitms_.add("tlbInvStatus___S01_", "-") ;
		this._tlbitms_.add("tlbInvStatus___TITLE_",  {xtype:"tbtext", text:"SalesInvoiceStatus"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbInvStatus__") != -1); } )
		this._tlbs_.add("tlbInvStatus" , t.getRange() );
	


			this._getDc_("invStatus").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbInvStatus__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("invStatus").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbInvStatus__load")) this._tlbitms_.get("tlbInvStatus__load").enable();
                 if(this._tlbitms_.get("tlbInvStatus__new_sr"))this._tlbitms_.get("tlbInvStatus__new_sr").enable();
                 if(this._tlbitms_.get("tlbInvStatus__new_mr"))this._tlbitms_.get("tlbInvStatus__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("invStatus").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbInvStatus__copy_mr")) this._tlbitms_.get("tlbInvStatus__copy_mr").enable();
                        if(this._tlbitms_.get("tlbInvStatus__delete_mr")) this._tlbitms_.get("tlbInvStatus__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbInvStatus__copy_mr")) this._tlbitms_.get("tlbInvStatus__copy_mr").disable();
                       if(this._tlbitms_.get("tlbInvStatus__delete_mr")) this._tlbitms_.get("tlbInvStatus__delete_mr").disable();
					}

			  } , this );
			this._getDc_("invStatus").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbInvStatus__load")) this._tlbitms_.get("tlbInvStatus__load").disable();		  			 
                    if(this._tlbitms_.get("tlbInvStatus__save_mr")) this._tlbitms_.get("tlbInvStatus__save_mr").enable();
                    if(this._tlbitms_.get("tlbInvStatus__rollback_record_mr"))this._tlbitms_.get("tlbInvStatus__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbInvStatus__rollback_mr"))this._tlbitms_.get("tlbInvStatus__rollback_mr").enable();
			  } , this );

			this._getDc_("invStatus").on("cleanRecord" , function() {
		  		  if (this._getDc_("invStatus").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbInvStatus__load")) this._tlbitms_.get("tlbInvStatus__load").disable();	                
                    if(this._tlbitms_.get("tlbInvStatus__save_mr"))this._tlbitms_.get("tlbInvStatus__save_mr").enable();
                    if(this._tlbitms_.get("tlbInvStatus__rollback_record_mr"))this._tlbitms_.get("tlbInvStatus__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbInvStatus__rollback_mr"))this._tlbitms_.get("tlbInvStatus__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbInvStatus__load")) this._tlbitms_.get("tlbInvStatus__load").enable();	
                  	if(this._tlbitms_.get("tlbInvStatus__back_mr"))this._tlbitms_.get("tlbInvStatus__back_mr").enable();
                  	if(this._tlbitms_.get("tlbInvStatus__save_mr"))this._tlbitms_.get("tlbInvStatus__save_mr").disable();
                  	if(this._tlbitms_.get("tlbInvStatus__rollback_record_mr"))this._tlbitms_.get("tlbInvStatus__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbInvStatus__rollback_mr"))this._tlbitms_.get("tlbInvStatus__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("invType").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("invStatus").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI", net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI);   
