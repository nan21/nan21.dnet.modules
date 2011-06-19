 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/SkillCategoryDs", "nan21.dnet.module.hr.ui.extjs/dc/SkillCategory", "nan21.dnet.module.hr.ui.extjs/ds/SkillTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/SkillType","nan21.dnet.module.hr.ui.extjs/ds/SkillCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/SkillCategories","nan21.dnet.module.hr.ui.extjs/ds/SkillCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/SkillCategories"]);

Ext.ns("net.nan21.dnet.module.hr.skill.frame");
net.nan21.dnet.module.hr.skill.frame.SkillType_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.skill.frame.SkillType_UI"
	
	,_defineDcs_: function () {	
		var  scateg = new net.nan21.dnet.module.hr.skill.dc.SkillCategory({multiEdit:true}), stype = new net.nan21.dnet.module.hr.skill.dc.SkillType({multiEdit:true});	 	
		
		this._dcs_.add("scateg", scateg);			
		
		this._dcs_.add("stype", stype);			
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
            children: [{ text:"Categories", leaf: true , name:"canvasCateg"},{ text:"Types", leaf: true , name:"canvasType"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		});	 
		this._elems_.add("scategFilter", { xtype:"net.nan21.dnet.module.hr.skill.dc.SkillCategory$Filter", id:Ext.id(), _controller_:this._dcs_.get("scateg"),height:35 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("scategEditList", { xtype:"net.nan21.dnet.module.hr.skill.dc.SkillCategory$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("scateg") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("stypeFilter", { xtype:"net.nan21.dnet.module.hr.skill.dc.SkillType$Filter", id:Ext.id(), _controller_:this._dcs_.get("stype"),height:60 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("stypeEditList", { xtype:"net.nan21.dnet.module.hr.skill.dc.SkillType$EditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("stype") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvasCateg", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Categories",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvasType", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Types",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
			
		this._elems_.get("main")["region"] = "center";
		this._elems_.get("_toc_")["region"] = "west";
		this._elems_.get("_main_with_toc_")["items"] = [ this._elems_.get("main") , this._elems_.get("_toc_")];
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvasCateg") , this._elems_.get("canvasType") ]; 				 		
 
			this._elems_.get("scategFilter")["region"] = "north";			
			this._elems_.get("scategEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvasCateg")["items"] = [ this._elems_.get("scategFilter") , this._elems_.get("scategEditList") ]; 				 		
 
			this._elems_.get("stypeFilter")["region"] = "north";			
			this._elems_.get("stypeEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvasType")["items"] = [ this._elems_.get("stypeFilter") , this._elems_.get("stypeEditList") ]; 				 		
	 	this._linkToolbar_("tlbscateg", "canvasCateg");	 	  	
	 	this._linkToolbar_("tlbstype", "canvasType");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbscateg__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("scateg").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbscateg-load"
		this._tlbitms_.add("tlbscateg__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("scateg").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbscateg-save_mr"
		this._tlbitms_.add("tlbscateg__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("scateg").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbscateg-new_mr"
		this._tlbitms_.add("tlbscateg__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("scateg").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbscateg-copy_mr"
		this._tlbitms_.add("tlbscateg__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("scateg").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbscateg-delete_mr"
		this._tlbitms_.add("tlbscateg__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("scateg").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbscateg-rollback_mr"
		this._tlbitms_.add("tlbscateg___S00_", "-") ;
		this._tlbitms_.add("tlbscateg___S01_", "-") ;
		this._tlbitms_.add("tlbscateg___TITLE_",  {xtype:"tbtext", text:"SkillCategory"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbscateg__") != -1); } )
		this._tlbs_.add("tlbscateg" , t.getRange() );
	


			this._getDc_("scateg").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbscateg__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("scateg").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbscateg__load")) this._tlbitms_.get("tlbscateg__load").enable();
                 if(this._tlbitms_.get("tlbscateg__new_sr"))this._tlbitms_.get("tlbscateg__new_sr").enable();
                 if(this._tlbitms_.get("tlbscateg__new_mr"))this._tlbitms_.get("tlbscateg__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("scateg").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbscateg__copy_mr")) this._tlbitms_.get("tlbscateg__copy_mr").enable();
                        if(this._tlbitms_.get("tlbscateg__delete_mr")) this._tlbitms_.get("tlbscateg__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbscateg__copy_mr")) this._tlbitms_.get("tlbscateg__copy_mr").disable();
                       if(this._tlbitms_.get("tlbscateg__delete_mr")) this._tlbitms_.get("tlbscateg__delete_mr").disable();
					}

			  } , this );
			this._getDc_("scateg").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbscateg__load")) this._tlbitms_.get("tlbscateg__load").disable();		  			 
                    if(this._tlbitms_.get("tlbscateg__save_mr")) this._tlbitms_.get("tlbscateg__save_mr").enable();
                    if(this._tlbitms_.get("tlbscateg__rollback_record_mr"))this._tlbitms_.get("tlbscateg__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbscateg__rollback_mr"))this._tlbitms_.get("tlbscateg__rollback_mr").enable();
			  } , this );

			this._getDc_("scateg").on("cleanRecord" , function() {
		  		  if (this._getDc_("scateg").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbscateg__load")) this._tlbitms_.get("tlbscateg__load").disable();	                
                    if(this._tlbitms_.get("tlbscateg__save_mr"))this._tlbitms_.get("tlbscateg__save_mr").enable();
                    if(this._tlbitms_.get("tlbscateg__rollback_record_mr"))this._tlbitms_.get("tlbscateg__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbscateg__rollback_mr"))this._tlbitms_.get("tlbscateg__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbscateg__load")) this._tlbitms_.get("tlbscateg__load").enable();	
                  	if(this._tlbitms_.get("tlbscateg__back_mr"))this._tlbitms_.get("tlbscateg__back_mr").enable();
                  	if(this._tlbitms_.get("tlbscateg__save_mr"))this._tlbitms_.get("tlbscateg__save_mr").disable();
                  	if(this._tlbitms_.get("tlbscateg__rollback_record_mr"))this._tlbitms_.get("tlbscateg__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbscateg__rollback_mr"))this._tlbitms_.get("tlbscateg__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbstype__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("stype").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbstype-load"
		this._tlbitms_.add("tlbstype__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("stype").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbstype-save_mr"
		this._tlbitms_.add("tlbstype__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("stype").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbstype-new_mr"
		this._tlbitms_.add("tlbstype__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("stype").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbstype-copy_mr"
		this._tlbitms_.add("tlbstype__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("stype").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbstype-delete_mr"
		this._tlbitms_.add("tlbstype__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("stype").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbstype-rollback_mr"
		this._tlbitms_.add("tlbstype___S00_", "-") ;
		this._tlbitms_.add("tlbstype___S01_", "-") ;
		this._tlbitms_.add("tlbstype___TITLE_",  {xtype:"tbtext", text:"SkillType"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbstype__") != -1); } )
		this._tlbs_.add("tlbstype" , t.getRange() );
	


			this._getDc_("stype").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbstype__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("stype").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbstype__load")) this._tlbitms_.get("tlbstype__load").enable();
                 if(this._tlbitms_.get("tlbstype__new_sr"))this._tlbitms_.get("tlbstype__new_sr").enable();
                 if(this._tlbitms_.get("tlbstype__new_mr"))this._tlbitms_.get("tlbstype__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("stype").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbstype__copy_mr")) this._tlbitms_.get("tlbstype__copy_mr").enable();
                        if(this._tlbitms_.get("tlbstype__delete_mr")) this._tlbitms_.get("tlbstype__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbstype__copy_mr")) this._tlbitms_.get("tlbstype__copy_mr").disable();
                       if(this._tlbitms_.get("tlbstype__delete_mr")) this._tlbitms_.get("tlbstype__delete_mr").disable();
					}

			  } , this );
			this._getDc_("stype").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbstype__load")) this._tlbitms_.get("tlbstype__load").disable();		  			 
                    if(this._tlbitms_.get("tlbstype__save_mr")) this._tlbitms_.get("tlbstype__save_mr").enable();
                    if(this._tlbitms_.get("tlbstype__rollback_record_mr"))this._tlbitms_.get("tlbstype__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbstype__rollback_mr"))this._tlbitms_.get("tlbstype__rollback_mr").enable();
			  } , this );

			this._getDc_("stype").on("cleanRecord" , function() {
		  		  if (this._getDc_("stype").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbstype__load")) this._tlbitms_.get("tlbstype__load").disable();	                
                    if(this._tlbitms_.get("tlbstype__save_mr"))this._tlbitms_.get("tlbstype__save_mr").enable();
                    if(this._tlbitms_.get("tlbstype__rollback_record_mr"))this._tlbitms_.get("tlbstype__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbstype__rollback_mr"))this._tlbitms_.get("tlbstype__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbstype__load")) this._tlbitms_.get("tlbstype__load").enable();	
                  	if(this._tlbitms_.get("tlbstype__back_mr"))this._tlbitms_.get("tlbstype__back_mr").enable();
                  	if(this._tlbitms_.get("tlbstype__save_mr"))this._tlbitms_.get("tlbstype__save_mr").disable();
                  	if(this._tlbitms_.get("tlbstype__rollback_record_mr"))this._tlbitms_.get("tlbstype__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbstype__rollback_mr"))this._tlbitms_.get("tlbstype__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("scateg").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("stype").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.skill.frame.SkillType_UI", net.nan21.dnet.module.hr.skill.frame.SkillType_UI);   
