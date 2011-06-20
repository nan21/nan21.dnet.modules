 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/CourseCategoryDs", "nan21.dnet.module.hr.ui.extjs/dc/CourseCategory", "nan21.dnet.module.hr.ui.extjs/ds/CourseTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/CourseType","nan21.dnet.module.hr.ui.extjs/ds/CourseTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/CourseTypes","nan21.dnet.module.hr.ui.extjs/ds/CourseTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/CourseTypes"]);

Ext.ns("net.nan21.dnet.module.hr.training.frame");
net.nan21.dnet.module.hr.training.frame.CourseType_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.training.frame.CourseType_UI"
	
	,_defineDcs_: function () {	
		var  ccateg = new net.nan21.dnet.module.hr.training.dc.CourseCategory({multiEdit:true}), ctype = new net.nan21.dnet.module.hr.training.dc.CourseType({multiEdit:true});	 	
		
		this._dcs_.add("ccateg", ccateg);			
		
		this._dcs_.add("ctype", ctype);			
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
            children: [{ text:"Course Categories", leaf: true , name:"canvasCategory"},{ text:"Course Types", leaf: true , name:"canvasType"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		});	 
		this._elems_.add("ccategFilter", { xtype:"net.nan21.dnet.module.hr.training.dc.CourseCategory$Filter", id:Ext.id(), _controller_:this._dcs_.get("ccateg"),height:35 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("ccategEditList", { xtype:"net.nan21.dnet.module.hr.training.dc.CourseCategory$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("ccateg") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("ctypeFilter", { xtype:"net.nan21.dnet.module.hr.training.dc.CourseType$Filter", id:Ext.id(), _controller_:this._dcs_.get("ctype"),height:60 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("ctypeEditList", { xtype:"net.nan21.dnet.module.hr.training.dc.CourseType$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("ctype") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvasCategory", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Course Categories",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvasType", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Course Types",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
			
		this._elems_.get("main")["region"] = "center";
		this._elems_.get("_toc_")["region"] = "west";
		this._elems_.get("_main_with_toc_")["items"] = [ this._elems_.get("main") , this._elems_.get("_toc_")];
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvasCategory") , this._elems_.get("canvasType") ]; 				 		
 
			this._elems_.get("ccategFilter")["region"] = "north";			
			this._elems_.get("ccategEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvasCategory")["items"] = [ this._elems_.get("ccategFilter") , this._elems_.get("ccategEditList") ]; 				 		
 
			this._elems_.get("ctypeFilter")["region"] = "north";			
			this._elems_.get("ctypeEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvasType")["items"] = [ this._elems_.get("ctypeFilter") , this._elems_.get("ctypeEditList") ]; 				 		
	 	this._linkToolbar_("tlbCcategEditList", "canvasCategory");	 	  	
	 	this._linkToolbar_("tlbCtypeEditList", "canvasType");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbCcategEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("ccateg").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCcategEditList-load"
		this._tlbitms_.add("tlbCcategEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("ccateg").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCcategEditList-save_mr"
		this._tlbitms_.add("tlbCcategEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("ccateg").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCcategEditList-new_mr"
		this._tlbitms_.add("tlbCcategEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("ccateg").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCcategEditList-copy_mr"
		this._tlbitms_.add("tlbCcategEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("ccateg").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCcategEditList-delete_mr"
		this._tlbitms_.add("tlbCcategEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("ccateg").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCcategEditList-rollback_mr"
		this._tlbitms_.add("tlbCcategEditList___S00_", "-") ;
		this._tlbitms_.add("tlbCcategEditList___S01_", "-") ;
		this._tlbitms_.add("tlbCcategEditList___TITLE_",  {xtype:"tbtext", text:"CourseCategory"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbCcategEditList__") != -1); } )
		this._tlbs_.add("tlbCcategEditList" , t.getRange() );
	


			this._getDc_("ccateg").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbCcategEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("ccateg").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbCcategEditList__load")) this._tlbitms_.get("tlbCcategEditList__load").enable();
                 if(this._tlbitms_.get("tlbCcategEditList__new_sr"))this._tlbitms_.get("tlbCcategEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbCcategEditList__new_mr"))this._tlbitms_.get("tlbCcategEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("ccateg").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbCcategEditList__copy_mr")) this._tlbitms_.get("tlbCcategEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbCcategEditList__delete_mr")) this._tlbitms_.get("tlbCcategEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbCcategEditList__copy_mr")) this._tlbitms_.get("tlbCcategEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbCcategEditList__delete_mr")) this._tlbitms_.get("tlbCcategEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("ccateg").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbCcategEditList__load")) this._tlbitms_.get("tlbCcategEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbCcategEditList__save_mr")) this._tlbitms_.get("tlbCcategEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCcategEditList__rollback_record_mr"))this._tlbitms_.get("tlbCcategEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCcategEditList__rollback_mr"))this._tlbitms_.get("tlbCcategEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("ccateg").on("cleanRecord" , function() {
		  		  if (this._getDc_("ccateg").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbCcategEditList__load")) this._tlbitms_.get("tlbCcategEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbCcategEditList__save_mr"))this._tlbitms_.get("tlbCcategEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCcategEditList__rollback_record_mr"))this._tlbitms_.get("tlbCcategEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCcategEditList__rollback_mr"))this._tlbitms_.get("tlbCcategEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbCcategEditList__load")) this._tlbitms_.get("tlbCcategEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbCcategEditList__back_mr"))this._tlbitms_.get("tlbCcategEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbCcategEditList__save_mr"))this._tlbitms_.get("tlbCcategEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbCcategEditList__rollback_record_mr"))this._tlbitms_.get("tlbCcategEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbCcategEditList__rollback_mr"))this._tlbitms_.get("tlbCcategEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbCtypeEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("ctype").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCtypeEditList-load"
		this._tlbitms_.add("tlbCtypeEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("ctype").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbCtypeEditList-save_mr"
		this._tlbitms_.add("tlbCtypeEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("ctype").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCtypeEditList-new_mr"
		this._tlbitms_.add("tlbCtypeEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("ctype").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCtypeEditList-copy_mr"
		this._tlbitms_.add("tlbCtypeEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("ctype").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCtypeEditList-delete_mr"
		this._tlbitms_.add("tlbCtypeEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("ctype").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbCtypeEditList-rollback_mr"
		this._tlbitms_.add("tlbCtypeEditList___S00_", "-") ;
		this._tlbitms_.add("tlbCtypeEditList___S01_", "-") ;
		this._tlbitms_.add("tlbCtypeEditList___TITLE_",  {xtype:"tbtext", text:"CourseType"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbCtypeEditList__") != -1); } )
		this._tlbs_.add("tlbCtypeEditList" , t.getRange() );
	


			this._getDc_("ctype").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbCtypeEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("ctype").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbCtypeEditList__load")) this._tlbitms_.get("tlbCtypeEditList__load").enable();
                 if(this._tlbitms_.get("tlbCtypeEditList__new_sr"))this._tlbitms_.get("tlbCtypeEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbCtypeEditList__new_mr"))this._tlbitms_.get("tlbCtypeEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("ctype").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbCtypeEditList__copy_mr")) this._tlbitms_.get("tlbCtypeEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbCtypeEditList__delete_mr")) this._tlbitms_.get("tlbCtypeEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbCtypeEditList__copy_mr")) this._tlbitms_.get("tlbCtypeEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbCtypeEditList__delete_mr")) this._tlbitms_.get("tlbCtypeEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("ctype").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbCtypeEditList__load")) this._tlbitms_.get("tlbCtypeEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbCtypeEditList__save_mr")) this._tlbitms_.get("tlbCtypeEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCtypeEditList__rollback_record_mr"))this._tlbitms_.get("tlbCtypeEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCtypeEditList__rollback_mr"))this._tlbitms_.get("tlbCtypeEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("ctype").on("cleanRecord" , function() {
		  		  if (this._getDc_("ctype").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbCtypeEditList__load")) this._tlbitms_.get("tlbCtypeEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbCtypeEditList__save_mr"))this._tlbitms_.get("tlbCtypeEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbCtypeEditList__rollback_record_mr"))this._tlbitms_.get("tlbCtypeEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbCtypeEditList__rollback_mr"))this._tlbitms_.get("tlbCtypeEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbCtypeEditList__load")) this._tlbitms_.get("tlbCtypeEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbCtypeEditList__back_mr"))this._tlbitms_.get("tlbCtypeEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbCtypeEditList__save_mr"))this._tlbitms_.get("tlbCtypeEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbCtypeEditList__rollback_record_mr"))this._tlbitms_.get("tlbCtypeEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbCtypeEditList__rollback_mr"))this._tlbitms_.get("tlbCtypeEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("ccateg").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("ctype").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.training.frame.CourseType_UI", net.nan21.dnet.module.hr.training.frame.CourseType_UI);   
