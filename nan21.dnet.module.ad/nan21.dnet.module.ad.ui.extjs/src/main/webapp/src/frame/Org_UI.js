Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/OrganizationDs", "nan21.dnet.module.ad.ui.extjs/dc/Organization", "nan21.dnet.module.ad.ui.extjs/ds/OrganizationHierarchyDs", "nan21.dnet.module.ad.ui.extjs/dc/OrganizationHierarchy", "nan21.dnet.module.ad.ui.extjs/ds/OrganizationHierarchyItemDs", "nan21.dnet.module.ad.ui.extjs/dc/OrganizationHierarchyItem","nan21.dnet.module.ad.ui.extjs/ds/OrganizationTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/OrganizationTypes","nan21.dnet.module.ad.ui.extjs/ds/OrganizationTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/OrganizationTypes","nan21.dnet.module.ad.ui.extjs/ds/OrganizationLovDs","nan21.dnet.module.ad.ui.extjs/lov/Organizations","nan21.dnet.module.ad.ui.extjs/ds/OrganizationHierarchyItemLovDs","nan21.dnet.module.ad.ui.extjs/lov/OrganizationHierarchyItems"]);

Ext.ns("net.nan21.dnet.module.ad.org.frame");
net.nan21.dnet.module.ad.org.frame.Org_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.org.frame.Org_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("org", new net.nan21.dnet.module.ad.org.dc.Organization())
		.addDc("hierarchy", new net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy())
		.addDc("items", new net.nan21.dnet.module.ad.org.dc.OrganizationHierarchyItem({multiEdit:true}))		
		.linkDc("items", "hierarchy",{fields:[ {childField:"hierarchyId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {					
			
		this._mainViewName_  = "_main_with_toc_";
		this._getBuilder_()
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addPanel({ name:"_toc_",xtype: 'treepanel',collapsible: true, region:"west", title: 'Navigation',width: 250,autoScroll: true,split: true,rootVisible: false,loader: new Ext.tree.TreeLoader()
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
		this._getBuilder_()	
		.addDcView("org",{ name:"orgFilter", xtype:"net.nan21.dnet.module.ad.org.dc.Organization$Filter",height:65})	 
		.addDcView("org",{ name:"orgList", xtype:"net.nan21.dnet.module.ad.org.dc.Organization$List"})	 
		.addDcView("org",{ name:"orgEdit", xtype:"net.nan21.dnet.module.ad.org.dc.Organization$Edit"})	 
		.addDcView("hierarchy",{ name:"hierarchyFilter", xtype:"net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$Filter",height:35})	 
		.addDcView("hierarchy",{ name:"hierarchyList", xtype:"net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$List"})	 
		.addDcView("hierarchy",{ name:"hierarchyEdit", xtype:"net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$Edit",height:100})	 
		.addDcView("items",{ name:"itemsEditList", xtype:"net.nan21.dnet.module.ad.org.dc.OrganizationHierarchyItem$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "panelHierarchy",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Organizations",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
		.addPanel({name: "canvas3", layout:"border", defaults:{split:true},title:"Hierarchies",header:false})  	 
		.addPanel({name: "panelHierarchyList", layout:"border", defaults:{split:true}})  	 
		.addPanel({name: "panelHierarchyEdit", layout:"border", defaults:{split:true}})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2","canvas3"]) 				 		
		.addChildrenTo("canvas1",["orgFilter","orgList"] ,["north","center"])	
		.addChildrenTo("canvas2",["orgEdit"] ,["center"])	
		.addChildrenTo("canvas3",["panelHierarchy"] ,["center"])	
	 	.addChildrenTo("panelHierarchy", ["panelHierarchyList","panelHierarchyEdit"]) 				 		
		.addChildrenTo("panelHierarchyList",["hierarchyFilter","hierarchyList"] ,["north","center"])	
		.addChildrenTo("panelHierarchyEdit",["hierarchyEdit","itemsEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvas1","tlbOrgList")	  	
	 	.addToolbarTo("canvas2","tlbOrgEdit")	  	
	 	.addToolbarTo("panelHierarchyList","tlbHierarchyList")	  	
	 	.addToolbarTo("panelHierarchyEdit","tlbHierarchyEdit")	  	
	 	.addToolbarTo("itemsEditList","tlbItemsEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOrgList", {dc:"org"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbOrgEdit", {dc:"org"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbHierarchyList", {dc:"hierarchy"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbHierarchyEdit", {dc:"hierarchy"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbItemsEditList", {dc:"items"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.ad.org.frame.Org_UI", net.nan21.dnet.module.ad.org.frame.Org_UI);   
