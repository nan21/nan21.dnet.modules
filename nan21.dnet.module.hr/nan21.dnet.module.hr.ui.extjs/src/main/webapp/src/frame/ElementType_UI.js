 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/ElementCategoryDs", "nan21.dnet.module.hr.ui.extjs/dc/ElementCategory", "nan21.dnet.module.hr.ui.extjs/ds/ElementTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/ElementType","nan21.dnet.module.hr.ui.extjs/ds/ElementCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/ElementCategories","nan21.dnet.module.hr.ui.extjs/ds/ElementCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/ElementCategories"]);

Ext.ns("net.nan21.dnet.module.hr.payroll.frame");
net.nan21.dnet.module.hr.payroll.frame.ElementType_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.ElementType_UI"
	
	,_defineDcs_: function () {	
		var  ecateg = new net.nan21.dnet.module.hr.payroll.dc.ElementCategory({multiEdit:true}), etype = new net.nan21.dnet.module.hr.payroll.dc.ElementType({multiEdit:true});	 	
		
		this._dcs_.add("ecateg", ecateg);			
		
		this._dcs_.add("etype", etype);			
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
            children: [{ text:"Element categories", leaf: true , name:"canvasCateg"},{ text:"Element types", leaf: true , name:"canvasType"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		});	 
		this._elems_.add("ecategFilter", { xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementCategory$Filter", id:Ext.id(), _controller_:this._dcs_.get("ecateg"),height:40 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("ecategEditList", { xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementCategory$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("ecateg") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("etypeFilter", { xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementType$Filter", id:Ext.id(), _controller_:this._dcs_.get("etype"),height:60 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("etypeEditList", { xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementType$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("etype") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvasCateg", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Element categories",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvasType", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Element types",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
			
		this._elems_.get("main")["region"] = "center";
		this._elems_.get("_toc_")["region"] = "west";
		this._elems_.get("_main_with_toc_")["items"] = [ this._elems_.get("main") , this._elems_.get("_toc_")];
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvasCateg") , this._elems_.get("canvasType") ]; 				 		
 
			this._elems_.get("ecategFilter")["region"] = "north";			
			this._elems_.get("ecategEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvasCateg")["items"] = [ this._elems_.get("ecategFilter") , this._elems_.get("ecategEditList") ]; 				 		
 
			this._elems_.get("etypeFilter")["region"] = "north";			
			this._elems_.get("etypeEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvasType")["items"] = [ this._elems_.get("etypeFilter") , this._elems_.get("etypeEditList") ]; 				 		
	 	this._linkToolbar_("tlbEcategEditList", "canvasCateg");	 	  	
	 	this._linkToolbar_("tlbEtypeEditList", "canvasType");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbEcategEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("ecateg").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEcategEditList-load"
		this._tlbitms_.add("tlbEcategEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("ecateg").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbEcategEditList-save_mr"
		this._tlbitms_.add("tlbEcategEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("ecateg").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEcategEditList-new_mr"
		this._tlbitms_.add("tlbEcategEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("ecateg").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEcategEditList-copy_mr"
		this._tlbitms_.add("tlbEcategEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("ecateg").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEcategEditList-delete_mr"
		this._tlbitms_.add("tlbEcategEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("ecateg").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEcategEditList-rollback_mr"
		this._tlbitms_.add("tlbEcategEditList___S00_", "-") ;
		this._tlbitms_.add("tlbEcategEditList___S01_", "-") ;
		this._tlbitms_.add("tlbEcategEditList___TITLE_",  {xtype:"tbtext", text:"ElementCategory"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbEcategEditList__") != -1); } )
		this._tlbs_.add("tlbEcategEditList" , t.getRange() );
	


			this._getDc_("ecateg").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbEcategEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("ecateg").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbEcategEditList__load")) this._tlbitms_.get("tlbEcategEditList__load").enable();
                 if(this._tlbitms_.get("tlbEcategEditList__new_sr"))this._tlbitms_.get("tlbEcategEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbEcategEditList__new_mr"))this._tlbitms_.get("tlbEcategEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("ecateg").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbEcategEditList__copy_mr")) this._tlbitms_.get("tlbEcategEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbEcategEditList__delete_mr")) this._tlbitms_.get("tlbEcategEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbEcategEditList__copy_mr")) this._tlbitms_.get("tlbEcategEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbEcategEditList__delete_mr")) this._tlbitms_.get("tlbEcategEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("ecateg").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbEcategEditList__load")) this._tlbitms_.get("tlbEcategEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbEcategEditList__save_mr")) this._tlbitms_.get("tlbEcategEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbEcategEditList__rollback_record_mr"))this._tlbitms_.get("tlbEcategEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbEcategEditList__rollback_mr"))this._tlbitms_.get("tlbEcategEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("ecateg").on("cleanRecord" , function() {
		  		  if (this._getDc_("ecateg").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbEcategEditList__load")) this._tlbitms_.get("tlbEcategEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbEcategEditList__save_mr"))this._tlbitms_.get("tlbEcategEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbEcategEditList__rollback_record_mr"))this._tlbitms_.get("tlbEcategEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbEcategEditList__rollback_mr"))this._tlbitms_.get("tlbEcategEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbEcategEditList__load")) this._tlbitms_.get("tlbEcategEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbEcategEditList__back_mr"))this._tlbitms_.get("tlbEcategEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbEcategEditList__save_mr"))this._tlbitms_.get("tlbEcategEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbEcategEditList__rollback_record_mr"))this._tlbitms_.get("tlbEcategEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbEcategEditList__rollback_mr"))this._tlbitms_.get("tlbEcategEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbEtypeEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("etype").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEtypeEditList-load"
		this._tlbitms_.add("tlbEtypeEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("etype").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbEtypeEditList-save_mr"
		this._tlbitms_.add("tlbEtypeEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("etype").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEtypeEditList-new_mr"
		this._tlbitms_.add("tlbEtypeEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("etype").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEtypeEditList-copy_mr"
		this._tlbitms_.add("tlbEtypeEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("etype").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEtypeEditList-delete_mr"
		this._tlbitms_.add("tlbEtypeEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("etype").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbEtypeEditList-rollback_mr"
		this._tlbitms_.add("tlbEtypeEditList___S00_", "-") ;
		this._tlbitms_.add("tlbEtypeEditList___S01_", "-") ;
		this._tlbitms_.add("tlbEtypeEditList___TITLE_",  {xtype:"tbtext", text:"ElementType"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbEtypeEditList__") != -1); } )
		this._tlbs_.add("tlbEtypeEditList" , t.getRange() );
	


			this._getDc_("etype").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbEtypeEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("etype").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbEtypeEditList__load")) this._tlbitms_.get("tlbEtypeEditList__load").enable();
                 if(this._tlbitms_.get("tlbEtypeEditList__new_sr"))this._tlbitms_.get("tlbEtypeEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbEtypeEditList__new_mr"))this._tlbitms_.get("tlbEtypeEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("etype").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbEtypeEditList__copy_mr")) this._tlbitms_.get("tlbEtypeEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbEtypeEditList__delete_mr")) this._tlbitms_.get("tlbEtypeEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbEtypeEditList__copy_mr")) this._tlbitms_.get("tlbEtypeEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbEtypeEditList__delete_mr")) this._tlbitms_.get("tlbEtypeEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("etype").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbEtypeEditList__load")) this._tlbitms_.get("tlbEtypeEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbEtypeEditList__save_mr")) this._tlbitms_.get("tlbEtypeEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbEtypeEditList__rollback_record_mr"))this._tlbitms_.get("tlbEtypeEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbEtypeEditList__rollback_mr"))this._tlbitms_.get("tlbEtypeEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("etype").on("cleanRecord" , function() {
		  		  if (this._getDc_("etype").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbEtypeEditList__load")) this._tlbitms_.get("tlbEtypeEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbEtypeEditList__save_mr"))this._tlbitms_.get("tlbEtypeEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbEtypeEditList__rollback_record_mr"))this._tlbitms_.get("tlbEtypeEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbEtypeEditList__rollback_mr"))this._tlbitms_.get("tlbEtypeEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbEtypeEditList__load")) this._tlbitms_.get("tlbEtypeEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbEtypeEditList__back_mr"))this._tlbitms_.get("tlbEtypeEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbEtypeEditList__save_mr"))this._tlbitms_.get("tlbEtypeEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbEtypeEditList__rollback_record_mr"))this._tlbitms_.get("tlbEtypeEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbEtypeEditList__rollback_mr"))this._tlbitms_.get("tlbEtypeEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("ecateg").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("etype").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.payroll.frame.ElementType_UI", net.nan21.dnet.module.hr.payroll.frame.ElementType_UI);   
