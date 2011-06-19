 
Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/OrganizationDs", "nan21.dnet.module.ad.ui.extjs/dc/Organization", "nan21.dnet.module.ad.ui.extjs/ds/OrganizationHierarchyDs", "nan21.dnet.module.ad.ui.extjs/dc/OrganizationHierarchy", "nan21.dnet.module.ad.ui.extjs/ds/OrganizationHierarchyItemDs", "nan21.dnet.module.ad.ui.extjs/dc/OrganizationHierarchyItem","nan21.dnet.module.ad.ui.extjs/ds/OrganizationTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/OrganizationTypes","nan21.dnet.module.ad.ui.extjs/ds/OrganizationTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/OrganizationTypes","nan21.dnet.module.ad.ui.extjs/ds/OrganizationLovDs","nan21.dnet.module.ad.ui.extjs/lov/Organizations","nan21.dnet.module.ad.ui.extjs/ds/OrganizationHierarchyItemLovDs","nan21.dnet.module.ad.ui.extjs/lov/OrganizationHierarchyItems"]);

Ext.ns("net.nan21.dnet.module.ad.org.frame");
net.nan21.dnet.module.ad.org.frame.Org_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.org.frame.Org_UI"
	
	,_defineDcs_: function () {	
		var  org = new net.nan21.dnet.module.ad.org.dc.Organization({multiEdit:false}), hierarchy = new net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy({multiEdit:false}), items = new net.nan21.dnet.module.ad.org.dc.OrganizationHierarchyItem({multiEdit:true});	 	
		
		this._dcs_.add("org", org);			
		
		this._dcs_.add("hierarchy", hierarchy);			
		items.setDcContext(new dnet.base.DcContext({childDc:items, parentDc:hierarchy, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"hierarchyId", parentField:"id"} ]}}));hierarchy.addChild(items);
		this._dcs_.add("items", items);			
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
            children: [{ text:"Organizations", leaf: true , name:"canvas1"},{ text:"Hierarchies", leaf: true , name:"canvas3"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		});	 
		this._elems_.add("orgFilter", { xtype:"net.nan21.dnet.module.ad.org.dc.Organization$Filter", id:Ext.id(), _controller_:this._dcs_.get("org"),height:65 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("orgList", { xtype:"net.nan21.dnet.module.ad.org.dc.Organization$List", id:Ext.id(), _controller_:this._dcs_.get("org") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("orgEdit", { xtype:"net.nan21.dnet.module.ad.org.dc.Organization$Edit", id:Ext.id(), _controller_:this._dcs_.get("org") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("org").isRecordValid = this._dcs_.get("org").isRecordValid.createInterceptor(function() { return this._getElement_("orgEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("hierarchyFilter", { xtype:"net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$Filter", id:Ext.id(), _controller_:this._dcs_.get("hierarchy"),height:35 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("hierarchyList", { xtype:"net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$List", id:Ext.id(), _controller_:this._dcs_.get("hierarchy") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("hierarchyEdit", { xtype:"net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$Edit", id:Ext.id(), _controller_:this._dcs_.get("hierarchy"),height:100 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("hierarchy").isRecordValid = this._dcs_.get("hierarchy").isRecordValid.createInterceptor(function() { return this._getElement_("hierarchyEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("itemsEditList", { xtype:"net.nan21.dnet.module.ad.org.dc.OrganizationHierarchyItem$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("items") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });		this._elems_.add("panelHierarchy", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Organizations",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas3", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Hierarchies",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("panelHierarchyList", { layout:"border", id:Ext.id(), defaults:{split:true},listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);      } }} });
		this._elems_.add("panelHierarchyEdit", { layout:"border", id:Ext.id(), defaults:{split:true},listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);      } }} });					
			
					 	
	}

	,_linkElements_: function () {	
			
		this._elems_.get("main")["region"] = "center";
		this._elems_.get("_toc_")["region"] = "west";
		this._elems_.get("_main_with_toc_")["items"] = [ this._elems_.get("main") , this._elems_.get("_toc_")];
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") , this._elems_.get("canvas3") ]; 				 		
 
			this._elems_.get("orgFilter")["region"] = "north";			
			this._elems_.get("orgList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("orgFilter") , this._elems_.get("orgList") ]; 				 		
 
			this._elems_.get("orgEdit")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("orgEdit") ]; 				 		
 
			this._elems_.get("panelHierarchy")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas3")["items"] = [ this._elems_.get("panelHierarchy") ]; 				 		
 
	
	 	this._elems_.get("panelHierarchy")["items"] = [ this._elems_.get("panelHierarchyList") , this._elems_.get("panelHierarchyEdit") ]; 				 		
 
			this._elems_.get("hierarchyFilter")["region"] = "north";			
			this._elems_.get("hierarchyList")["region"] = "center";			
		   
	
	 	this._elems_.get("panelHierarchyList")["items"] = [ this._elems_.get("hierarchyFilter") , this._elems_.get("hierarchyList") ]; 				 		
 
			this._elems_.get("hierarchyEdit")["region"] = "north";			
			this._elems_.get("itemsEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("panelHierarchyEdit")["items"] = [ this._elems_.get("hierarchyEdit") , this._elems_.get("itemsEditList") ]; 				 		
	 	this._linkToolbar_("tlbOrgList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbOrgEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbHierarchyList", "panelHierarchyList");	 	  	
	 	this._linkToolbar_("tlbHierarchyEdit", "panelHierarchyEdit");	 	  	
	 	this._linkToolbar_("tlbItemsEditList", "itemsEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbOrgList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("org").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrgList-load"
		this._tlbitms_.add("tlbOrgList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("org")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbOrgList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrgList-edit_sr"
		this._tlbitms_.add("tlbOrgList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("org").doNew(); this._invokeTlbItem_("tlbOrgList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrgList-new_sr"
		this._tlbitms_.add("tlbOrgList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("org").doCopy(); this._invokeTlbItem_("tlbOrgList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrgList-copy_sr"
		this._tlbitms_.add("tlbOrgList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("org").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrgList-delete_selected_sr"
		this._tlbitms_.add("tlbOrgList___S00_", "-") ;
		this._tlbitms_.add("tlbOrgList___S01_", "-") ;
		this._tlbitms_.add("tlbOrgList___TITLE_",  {xtype:"tbtext", text:"Organization"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbOrgList__") != -1); } )
		this._tlbs_.add("tlbOrgList" , t.getRange() );

		this._getDc_("org").on("onEdit", function() {this._invokeTlbItem_("tlbOrgList__edit_sr");} , this);

	


			this._getDc_("org").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbOrgList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("org").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbOrgList__load")) this._tlbitms_.get("tlbOrgList__load").enable();
                 if(this._tlbitms_.get("tlbOrgList__new_sr"))this._tlbitms_.get("tlbOrgList__new_sr").enable();
                 if(this._tlbitms_.get("tlbOrgList__new_mr"))this._tlbitms_.get("tlbOrgList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("org").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbOrgList__edit_sr")) this._tlbitms_.get("tlbOrgList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbOrgList__copy_sr")) this._tlbitms_.get("tlbOrgList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbOrgList__delete_selected_sr")) this._tlbitms_.get("tlbOrgList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbOrgList__edit_sr")) this._tlbitms_.get("tlbOrgList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbOrgList__copy_sr")) this._tlbitms_.get("tlbOrgList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbOrgList__delete_selected_sr")) this._tlbitms_.get("tlbOrgList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbOrgEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("org")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbOrgEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrgEdit-back_sr"
		this._tlbitms_.add("tlbOrgEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("org").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrgEdit-save"
		this._tlbitms_.add("tlbOrgEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("org").doNew(); this._invokeTlbItem_("tlbOrgEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrgEdit-new_sr"
		this._tlbitms_.add("tlbOrgEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("org").doCopy(); this._invokeTlbItem_("tlbOrgEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrgEdit-copy_sr"
		this._tlbitms_.add("tlbOrgEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("org").getCurrentRecord().phantom) {this._getDc_("org").discardChanges();this._invokeTlbItem_("tlbOrgEdit__back_sr");} else  {this._getDc_("org").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrgEdit-rollback_sr"
		this._tlbitms_.add("tlbOrgEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("org").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbOrgEdit-prev_rec_sr"
		this._tlbitms_.add("tlbOrgEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("org").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbOrgEdit-next_rec_sr"
		this._tlbitms_.add("tlbOrgEdit___S00_", "-") ;
		this._tlbitms_.add("tlbOrgEdit___S01_", "-") ;
		this._tlbitms_.add("tlbOrgEdit___TITLE_",  {xtype:"tbtext", text:"Organization"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbOrgEdit__") != -1); } )
		this._tlbs_.add("tlbOrgEdit" , t.getRange() );
	


			this._getDc_("org").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbOrgEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("org").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbOrgEdit__load")) this._tlbitms_.get("tlbOrgEdit__load").enable();
                 if(this._tlbitms_.get("tlbOrgEdit__new_sr"))this._tlbitms_.get("tlbOrgEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbOrgEdit__new_mr"))this._tlbitms_.get("tlbOrgEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("org").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbOrgEdit__back_sr")) this._tlbitms_.get("tlbOrgEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbOrgEdit__save")) this._tlbitms_.get("tlbOrgEdit__save").enable();
                    if(this._tlbitms_.get("tlbOrgEdit__new_sr")) this._tlbitms_.get("tlbOrgEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbOrgEdit__copy_sr")) this._tlbitms_.get("tlbOrgEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbOrgEdit__rollback_record_sr")) this._tlbitms_.get("tlbOrgEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbOrgEdit__rollback_sr")) this._tlbitms_.get("tlbOrgEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbOrgEdit__prev_rec_sr")) this._tlbitms_.get("tlbOrgEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbOrgEdit__next_rec_sr")) this._tlbitms_.get("tlbOrgEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("org").on("cleanRecord" , function() {
		  		  if (this._getDc_("org").isDirty() ) {
                    if(this._tlbitms_.get("tlbOrgEdit__back_sr")) this._tlbitms_.get("tlbOrgEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbOrgEdit__save")) this._tlbitms_.get("tlbOrgEdit__save").enable();
                    if(this._tlbitms_.get("tlbOrgEdit__new_sr")) this._tlbitms_.get("tlbOrgEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbOrgEdit__copy_sr")) this._tlbitms_.get("tlbOrgEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbOrgEdit__rollback_record_sr")) this._tlbitms_.get("tlbOrgEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbOrgEdit__rollback_sr")) this._tlbitms_.get("tlbOrgEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbOrgEdit__prev_rec_sr")) this._tlbitms_.get("tlbOrgEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbOrgEdit__next_rec_sr")) this._tlbitms_.get("tlbOrgEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbOrgEdit__back_sr")) this._tlbitms_.get("tlbOrgEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbOrgEdit__save")) this._tlbitms_.get("tlbOrgEdit__save").disable();
                  	if(this._tlbitms_.get("tlbOrgEdit__new_sr")) this._tlbitms_.get("tlbOrgEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbOrgEdit__copy_sr")) this._tlbitms_.get("tlbOrgEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbOrgEdit__rollback_record_sr")) this._tlbitms_.get("tlbOrgEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbOrgEdit__rollback_sr")) this._tlbitms_.get("tlbOrgEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbOrgEdit__prev_rec_sr")) this._tlbitms_.get("tlbOrgEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbOrgEdit__next_rec_sr")) this._tlbitms_.get("tlbOrgEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("org").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbOrgEdit__copy_sr")) this._tlbitms_.get("tlbOrgEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbHierarchyList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("hierarchy").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbHierarchyList-load"
		this._tlbitms_.add("tlbHierarchyList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("hierarchy")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbHierarchyList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbHierarchyList-edit_sr"
		this._tlbitms_.add("tlbHierarchyList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("hierarchy").doNew(); this._invokeTlbItem_("tlbHierarchyList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbHierarchyList-new_sr"
		this._tlbitms_.add("tlbHierarchyList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("hierarchy").doCopy(); this._invokeTlbItem_("tlbHierarchyList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbHierarchyList-copy_sr"
		this._tlbitms_.add("tlbHierarchyList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("hierarchy").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbHierarchyList-delete_selected_sr"
		this._tlbitms_.add("tlbHierarchyList___S00_", "-") ;
		this._tlbitms_.add("tlbHierarchyList___S01_", "-") ;
		this._tlbitms_.add("tlbHierarchyList___TITLE_",  {xtype:"tbtext", text:"OrganizationHierarchy"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbHierarchyList__") != -1); } )
		this._tlbs_.add("tlbHierarchyList" , t.getRange() );

		this._getDc_("hierarchy").on("onEdit", function() {this._invokeTlbItem_("tlbHierarchyList__edit_sr");} , this);

	


			this._getDc_("hierarchy").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbHierarchyList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("hierarchy").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbHierarchyList__load")) this._tlbitms_.get("tlbHierarchyList__load").enable();
                 if(this._tlbitms_.get("tlbHierarchyList__new_sr"))this._tlbitms_.get("tlbHierarchyList__new_sr").enable();
                 if(this._tlbitms_.get("tlbHierarchyList__new_mr"))this._tlbitms_.get("tlbHierarchyList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("hierarchy").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbHierarchyList__edit_sr")) this._tlbitms_.get("tlbHierarchyList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbHierarchyList__copy_sr")) this._tlbitms_.get("tlbHierarchyList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbHierarchyList__delete_selected_sr")) this._tlbitms_.get("tlbHierarchyList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbHierarchyList__edit_sr")) this._tlbitms_.get("tlbHierarchyList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbHierarchyList__copy_sr")) this._tlbitms_.get("tlbHierarchyList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbHierarchyList__delete_selected_sr")) this._tlbitms_.get("tlbHierarchyList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbHierarchyEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("hierarchy")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbHierarchyEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbHierarchyEdit-back_sr"
		this._tlbitms_.add("tlbHierarchyEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("hierarchy").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbHierarchyEdit-save"
		this._tlbitms_.add("tlbHierarchyEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("hierarchy").doNew(); this._invokeTlbItem_("tlbHierarchyEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbHierarchyEdit-new_sr"
		this._tlbitms_.add("tlbHierarchyEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("hierarchy").doCopy(); this._invokeTlbItem_("tlbHierarchyEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbHierarchyEdit-copy_sr"
		this._tlbitms_.add("tlbHierarchyEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("hierarchy").getCurrentRecord().phantom) {this._getDc_("hierarchy").discardChanges();this._invokeTlbItem_("tlbHierarchyEdit__back_sr");} else  {this._getDc_("hierarchy").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbHierarchyEdit-rollback_sr"
		this._tlbitms_.add("tlbHierarchyEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("hierarchy").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbHierarchyEdit-prev_rec_sr"
		this._tlbitms_.add("tlbHierarchyEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("hierarchy").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbHierarchyEdit-next_rec_sr"
		this._tlbitms_.add("tlbHierarchyEdit___S00_", "-") ;
		this._tlbitms_.add("tlbHierarchyEdit___S01_", "-") ;
		this._tlbitms_.add("tlbHierarchyEdit___TITLE_",  {xtype:"tbtext", text:"OrganizationHierarchy"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbHierarchyEdit__") != -1); } )
		this._tlbs_.add("tlbHierarchyEdit" , t.getRange() );
	


			this._getDc_("hierarchy").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbHierarchyEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("hierarchy").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbHierarchyEdit__load")) this._tlbitms_.get("tlbHierarchyEdit__load").enable();
                 if(this._tlbitms_.get("tlbHierarchyEdit__new_sr"))this._tlbitms_.get("tlbHierarchyEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbHierarchyEdit__new_mr"))this._tlbitms_.get("tlbHierarchyEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("hierarchy").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbHierarchyEdit__back_sr")) this._tlbitms_.get("tlbHierarchyEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__save")) this._tlbitms_.get("tlbHierarchyEdit__save").enable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__new_sr")) this._tlbitms_.get("tlbHierarchyEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__copy_sr")) this._tlbitms_.get("tlbHierarchyEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__rollback_record_sr")) this._tlbitms_.get("tlbHierarchyEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__rollback_sr")) this._tlbitms_.get("tlbHierarchyEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbHierarchyEdit__prev_rec_sr")) this._tlbitms_.get("tlbHierarchyEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__next_rec_sr")) this._tlbitms_.get("tlbHierarchyEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("hierarchy").on("cleanRecord" , function() {
		  		  if (this._getDc_("hierarchy").isDirty() ) {
                    if(this._tlbitms_.get("tlbHierarchyEdit__back_sr")) this._tlbitms_.get("tlbHierarchyEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__save")) this._tlbitms_.get("tlbHierarchyEdit__save").enable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__new_sr")) this._tlbitms_.get("tlbHierarchyEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__copy_sr")) this._tlbitms_.get("tlbHierarchyEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__rollback_record_sr")) this._tlbitms_.get("tlbHierarchyEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__rollback_sr")) this._tlbitms_.get("tlbHierarchyEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__prev_rec_sr")) this._tlbitms_.get("tlbHierarchyEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__next_rec_sr")) this._tlbitms_.get("tlbHierarchyEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbHierarchyEdit__back_sr")) this._tlbitms_.get("tlbHierarchyEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbHierarchyEdit__save")) this._tlbitms_.get("tlbHierarchyEdit__save").disable();
                  	if(this._tlbitms_.get("tlbHierarchyEdit__new_sr")) this._tlbitms_.get("tlbHierarchyEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbHierarchyEdit__copy_sr")) this._tlbitms_.get("tlbHierarchyEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbHierarchyEdit__rollback_record_sr")) this._tlbitms_.get("tlbHierarchyEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbHierarchyEdit__rollback_sr")) this._tlbitms_.get("tlbHierarchyEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbHierarchyEdit__prev_rec_sr")) this._tlbitms_.get("tlbHierarchyEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbHierarchyEdit__next_rec_sr")) this._tlbitms_.get("tlbHierarchyEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("hierarchy").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbHierarchyEdit__copy_sr")) this._tlbitms_.get("tlbHierarchyEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbItemsEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("items").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemsEditList-load"
		this._tlbitms_.add("tlbItemsEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("items").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbItemsEditList-save_mr"
		this._tlbitms_.add("tlbItemsEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("items").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemsEditList-new_mr"
		this._tlbitms_.add("tlbItemsEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("items").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemsEditList-copy_mr"
		this._tlbitms_.add("tlbItemsEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("items").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemsEditList-delete_mr"
		this._tlbitms_.add("tlbItemsEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("items").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemsEditList-rollback_mr"
		this._tlbitms_.add("tlbItemsEditList___S00_", "-") ;
		this._tlbitms_.add("tlbItemsEditList___S01_", "-") ;
		this._tlbitms_.add("tlbItemsEditList___TITLE_",  {xtype:"tbtext", text:"OrganizationHierarchyItem"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbItemsEditList__") != -1); } )
		this._tlbs_.add("tlbItemsEditList" , t.getRange() );
	


			this._getDc_("items").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbItemsEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("items").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbItemsEditList__load")) this._tlbitms_.get("tlbItemsEditList__load").enable();
                 if(this._tlbitms_.get("tlbItemsEditList__new_sr"))this._tlbitms_.get("tlbItemsEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbItemsEditList__new_mr"))this._tlbitms_.get("tlbItemsEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("items").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbItemsEditList__copy_mr")) this._tlbitms_.get("tlbItemsEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbItemsEditList__delete_mr")) this._tlbitms_.get("tlbItemsEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbItemsEditList__copy_mr")) this._tlbitms_.get("tlbItemsEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbItemsEditList__delete_mr")) this._tlbitms_.get("tlbItemsEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("items").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbItemsEditList__load")) this._tlbitms_.get("tlbItemsEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbItemsEditList__save_mr")) this._tlbitms_.get("tlbItemsEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbItemsEditList__rollback_record_mr"))this._tlbitms_.get("tlbItemsEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbItemsEditList__rollback_mr"))this._tlbitms_.get("tlbItemsEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("items").on("cleanRecord" , function() {
		  		  if (this._getDc_("items").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbItemsEditList__load")) this._tlbitms_.get("tlbItemsEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbItemsEditList__save_mr"))this._tlbitms_.get("tlbItemsEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbItemsEditList__rollback_record_mr"))this._tlbitms_.get("tlbItemsEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbItemsEditList__rollback_mr"))this._tlbitms_.get("tlbItemsEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbItemsEditList__load")) this._tlbitms_.get("tlbItemsEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbItemsEditList__back_mr"))this._tlbitms_.get("tlbItemsEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbItemsEditList__save_mr"))this._tlbitms_.get("tlbItemsEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbItemsEditList__rollback_record_mr"))this._tlbitms_.get("tlbItemsEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbItemsEditList__rollback_mr"))this._tlbitms_.get("tlbItemsEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("org").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("orgEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("hierarchy").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("hierarchyEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("items").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.ad.org.frame.Org_UI", net.nan21.dnet.module.ad.org.frame.Org_UI);   
