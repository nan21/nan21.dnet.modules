 
Dnet.import(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderTypeDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrderType", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderStatusDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrderStatus"]);

Ext.ns("net.nan21.dnet.module.sd.order.frame");
net.nan21.dnet.module.sd.order.frame.SD_BaseData_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.sd.order.frame.SD_BaseData_UI"
	
	,_defineDcs_: function () {	
		var  orderType = new net.nan21.dnet.module.sd.order.dc.SalesOrderType({multiEdit:true}), orderStatus = new net.nan21.dnet.module.sd.order.dc.SalesOrderStatus({multiEdit:true});	 	
		
		this._dcs_.add("orderType", orderType);			
		
		this._dcs_.add("orderStatus", orderStatus);			
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
            children: [{ text:"Order type", leaf: true , name:"canvas1"},{ text:"Order status", leaf: true , name:"canvas2"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		});	 
		this._elems_.add("orderTypeFilter", { xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderType$Filter", id:Ext.id(), _controller_:this._dcs_.get("orderType"),height:35 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("orderTypeEditList", { xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderType$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("orderType") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("orderStatusFilter", { xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderStatus$Filter", id:Ext.id(), _controller_:this._dcs_.get("orderStatus"),height:30 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("orderStatusEditList", { xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderStatus$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("orderStatus") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Order type",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Order status",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
			
		this._elems_.get("main")["region"] = "center";
		this._elems_.get("_toc_")["region"] = "west";
		this._elems_.get("_main_with_toc_")["items"] = [ this._elems_.get("main") , this._elems_.get("_toc_")];
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("orderTypeFilter")["region"] = "north";			
			this._elems_.get("orderTypeEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("orderTypeFilter") , this._elems_.get("orderTypeEditList") ]; 				 		
 
			this._elems_.get("orderStatusFilter")["region"] = "north";			
			this._elems_.get("orderStatusEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("orderStatusFilter") , this._elems_.get("orderStatusEditList") ]; 				 		
	 	this._linkToolbar_("tlbOrderType", "canvas1");	 	  	
	 	this._linkToolbar_("tlbOrderStatus", "canvas2");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbOrderType__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("orderType").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderType-load"
		this._tlbitms_.add("tlbOrderType__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("orderType").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrderType-save_mr"
		this._tlbitms_.add("tlbOrderType__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("orderType").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderType-new_mr"
		this._tlbitms_.add("tlbOrderType__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("orderType").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderType-copy_mr"
		this._tlbitms_.add("tlbOrderType__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("orderType").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderType-delete_mr"
		this._tlbitms_.add("tlbOrderType__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("orderType").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderType-rollback_mr"
		this._tlbitms_.add("tlbOrderType___S00_", "-") ;
		this._tlbitms_.add("tlbOrderType___S01_", "-") ;
		this._tlbitms_.add("tlbOrderType___TITLE_",  {xtype:"tbtext", text:"SalesOrderType"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbOrderType__") != -1); } )
		this._tlbs_.add("tlbOrderType" , t.getRange() );
	


			this._getDc_("orderType").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbOrderType__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("orderType").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbOrderType__load")) this._tlbitms_.get("tlbOrderType__load").enable();
                 if(this._tlbitms_.get("tlbOrderType__new_sr"))this._tlbitms_.get("tlbOrderType__new_sr").enable();
                 if(this._tlbitms_.get("tlbOrderType__new_mr"))this._tlbitms_.get("tlbOrderType__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("orderType").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbOrderType__copy_mr")) this._tlbitms_.get("tlbOrderType__copy_mr").enable();
                        if(this._tlbitms_.get("tlbOrderType__delete_mr")) this._tlbitms_.get("tlbOrderType__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbOrderType__copy_mr")) this._tlbitms_.get("tlbOrderType__copy_mr").disable();
                       if(this._tlbitms_.get("tlbOrderType__delete_mr")) this._tlbitms_.get("tlbOrderType__delete_mr").disable();
					}

			  } , this );
			this._getDc_("orderType").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbOrderType__load")) this._tlbitms_.get("tlbOrderType__load").disable();		  			 
                    if(this._tlbitms_.get("tlbOrderType__save_mr")) this._tlbitms_.get("tlbOrderType__save_mr").enable();
                    if(this._tlbitms_.get("tlbOrderType__rollback_record_mr"))this._tlbitms_.get("tlbOrderType__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbOrderType__rollback_mr"))this._tlbitms_.get("tlbOrderType__rollback_mr").enable();
			  } , this );

			this._getDc_("orderType").on("cleanRecord" , function() {
		  		  if (this._getDc_("orderType").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbOrderType__load")) this._tlbitms_.get("tlbOrderType__load").disable();	                
                    if(this._tlbitms_.get("tlbOrderType__save_mr"))this._tlbitms_.get("tlbOrderType__save_mr").enable();
                    if(this._tlbitms_.get("tlbOrderType__rollback_record_mr"))this._tlbitms_.get("tlbOrderType__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbOrderType__rollback_mr"))this._tlbitms_.get("tlbOrderType__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbOrderType__load")) this._tlbitms_.get("tlbOrderType__load").enable();	
                  	if(this._tlbitms_.get("tlbOrderType__back_mr"))this._tlbitms_.get("tlbOrderType__back_mr").enable();
                  	if(this._tlbitms_.get("tlbOrderType__save_mr"))this._tlbitms_.get("tlbOrderType__save_mr").disable();
                  	if(this._tlbitms_.get("tlbOrderType__rollback_record_mr"))this._tlbitms_.get("tlbOrderType__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbOrderType__rollback_mr"))this._tlbitms_.get("tlbOrderType__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbOrderStatus__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("orderStatus").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderStatus-load"
		this._tlbitms_.add("tlbOrderStatus__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("orderStatus").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrderStatus-save_mr"
		this._tlbitms_.add("tlbOrderStatus__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("orderStatus").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderStatus-new_mr"
		this._tlbitms_.add("tlbOrderStatus__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("orderStatus").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderStatus-copy_mr"
		this._tlbitms_.add("tlbOrderStatus__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("orderStatus").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderStatus-delete_mr"
		this._tlbitms_.add("tlbOrderStatus__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("orderStatus").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrderStatus-rollback_mr"
		this._tlbitms_.add("tlbOrderStatus___S00_", "-") ;
		this._tlbitms_.add("tlbOrderStatus___S01_", "-") ;
		this._tlbitms_.add("tlbOrderStatus___TITLE_",  {xtype:"tbtext", text:"SalesOrderStatus"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbOrderStatus__") != -1); } )
		this._tlbs_.add("tlbOrderStatus" , t.getRange() );
	


			this._getDc_("orderStatus").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbOrderStatus__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("orderStatus").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbOrderStatus__load")) this._tlbitms_.get("tlbOrderStatus__load").enable();
                 if(this._tlbitms_.get("tlbOrderStatus__new_sr"))this._tlbitms_.get("tlbOrderStatus__new_sr").enable();
                 if(this._tlbitms_.get("tlbOrderStatus__new_mr"))this._tlbitms_.get("tlbOrderStatus__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("orderStatus").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbOrderStatus__copy_mr")) this._tlbitms_.get("tlbOrderStatus__copy_mr").enable();
                        if(this._tlbitms_.get("tlbOrderStatus__delete_mr")) this._tlbitms_.get("tlbOrderStatus__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbOrderStatus__copy_mr")) this._tlbitms_.get("tlbOrderStatus__copy_mr").disable();
                       if(this._tlbitms_.get("tlbOrderStatus__delete_mr")) this._tlbitms_.get("tlbOrderStatus__delete_mr").disable();
					}

			  } , this );
			this._getDc_("orderStatus").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbOrderStatus__load")) this._tlbitms_.get("tlbOrderStatus__load").disable();		  			 
                    if(this._tlbitms_.get("tlbOrderStatus__save_mr")) this._tlbitms_.get("tlbOrderStatus__save_mr").enable();
                    if(this._tlbitms_.get("tlbOrderStatus__rollback_record_mr"))this._tlbitms_.get("tlbOrderStatus__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbOrderStatus__rollback_mr"))this._tlbitms_.get("tlbOrderStatus__rollback_mr").enable();
			  } , this );

			this._getDc_("orderStatus").on("cleanRecord" , function() {
		  		  if (this._getDc_("orderStatus").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbOrderStatus__load")) this._tlbitms_.get("tlbOrderStatus__load").disable();	                
                    if(this._tlbitms_.get("tlbOrderStatus__save_mr"))this._tlbitms_.get("tlbOrderStatus__save_mr").enable();
                    if(this._tlbitms_.get("tlbOrderStatus__rollback_record_mr"))this._tlbitms_.get("tlbOrderStatus__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbOrderStatus__rollback_mr"))this._tlbitms_.get("tlbOrderStatus__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbOrderStatus__load")) this._tlbitms_.get("tlbOrderStatus__load").enable();	
                  	if(this._tlbitms_.get("tlbOrderStatus__back_mr"))this._tlbitms_.get("tlbOrderStatus__back_mr").enable();
                  	if(this._tlbitms_.get("tlbOrderStatus__save_mr"))this._tlbitms_.get("tlbOrderStatus__save_mr").disable();
                  	if(this._tlbitms_.get("tlbOrderStatus__rollback_record_mr"))this._tlbitms_.get("tlbOrderStatus__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbOrderStatus__rollback_mr"))this._tlbitms_.get("tlbOrderStatus__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("orderType").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("orderStatus").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.sd.order.frame.SD_BaseData_UI", net.nan21.dnet.module.sd.order.frame.SD_BaseData_UI);   
