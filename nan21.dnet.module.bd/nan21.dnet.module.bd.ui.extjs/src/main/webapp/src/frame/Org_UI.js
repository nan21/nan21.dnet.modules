Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationDs", "nan21.dnet.module.bd.ui.extjs/dc/Organization", "nan21.dnet.module.bd.ui.extjs/ds/LocationDs", "nan21.dnet.module.bd.ui.extjs/dc/Location", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationHierarchyDs", "nan21.dnet.module.bd.ui.extjs/dc/OrganizationHierarchy", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationHierarchyItemDs", "nan21.dnet.module.bd.ui.extjs/dc/OrganizationHierarchyItem", "nan21.dnet.module.bd.ui.extjs/ds/OrganizationTypeDs", "nan21.dnet.module.bd.ui.extjs/dc/OrganizationType","nan21.dnet.module.bd.ui.extjs/ds/OrganizationTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/OrganizationTypes","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/RegionLovDs","nan21.dnet.module.bd.ui.extjs/lov/Regions","nan21.dnet.module.bd.ui.extjs/ds/OrganizationTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/OrganizationTypes","nan21.dnet.module.bd.ui.extjs/ds/OrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/Organizations","nan21.dnet.module.bd.ui.extjs/ds/OrganizationHierarchyItemLovDs","nan21.dnet.module.bd.ui.extjs/lov/OrganizationHierarchyItems"]);

Ext.define("net.nan21.dnet.module.bd.org.frame.Org_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.org.frame.Org_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.org.frame.Org_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("org", new net.nan21.dnet.module.bd.org.dc.Organization({}))
		.addDc("address", new net.nan21.dnet.module.bd.geo.dc.Location({}))
		.addDc("hierarchy", new net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy({}))
		.addDc("items", new net.nan21.dnet.module.bd.org.dc.OrganizationHierarchyItem({multiEdit:true}))
		.addDc("orgtype", new net.nan21.dnet.module.bd.org.dc.OrganizationType({multiEdit:true}))		
		.linkDc("address", "org",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("items", "hierarchy",{fields:[ {childField:"hierarchyId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("org",{ name:"orgFilter", xtype:"net.nan21.dnet.module.bd.org.dc.Organization$Filter",height:80})	 
		.addDcView("org",{ name:"orgList", xtype:"net.nan21.dnet.module.bd.org.dc.Organization$List"})	 
		.addDcFormView("org",{ name:"orgEdit", xtype:"net.nan21.dnet.module.bd.org.dc.Organization$Edit",height:150})	 
		.addDcFilterFormView("hierarchy",{ name:"hierarchyFilter", xtype:"net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$Filter",height:40})	 
		.addDcView("hierarchy",{ name:"hierarchyList", xtype:"net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$List"})	 
		.addDcFormView("hierarchy",{ name:"hierarchyEdit", xtype:"net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$Edit",height:100})	 
		.addDcFilterFormView("orgtype",{ name:"orgtypeFilter", xtype:"net.nan21.dnet.module.bd.org.dc.OrganizationType$Filter",height:80})	 
		.addDcView("orgtype",{ name:"orgtypeEditList", xtype:"net.nan21.dnet.module.bd.org.dc.OrganizationType$EditList", frame:true})	 
		.addDcView("address",{ name:"addressList", xtype:"net.nan21.dnet.module.bd.geo.dc.Location$ListCtx"})	 
		.addDcFormView("address",{ name:"addressEdit", xtype:"net.nan21.dnet.module.bd.geo.dc.Location$EditCtx"})	 
		.addDcView("items",{ name:"itemsEditList", xtype:"net.nan21.dnet.module.bd.org.dc.OrganizationHierarchyItem$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "panelHierarchy",layout:"card", activeItem:0})  	 
		.addPanel({name: "addressPanel",layout:"card", activeItem:0,title:"Address"})  	 
		.addPanel({name: "canvasOrg", layout:"border", defaults:{split:true},title:"Organizations",preventHeader:true})  	 
		.addPanel({name: "canvasOrgEdit", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
		.addPanel({name: "canvasHierarchy", layout:"border", defaults:{split:true},title:"Hierarchies",preventHeader:true})  	 
		.addPanel({name: "panelHierarchyList", layout:"border", defaults:{split:true},title:"Hierarchies > List"})  	 
		.addPanel({name: "panelHierarchyEdit", layout:"border", defaults:{split:true},title:"Hierarchies > Editor"})  	 
		.addPanel({name: "canvasOrgType", layout:"border", defaults:{split:true},title:"Organization types",preventHeader:true})  	 
		.addPanel({name: "addressEditWrapper", layout:"fit"})
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasOrg","canvasHierarchy","canvasOrgType"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasOrg","canvasOrgEdit","canvasHierarchy","canvasOrgType"]) 				 		
		.addChildrenTo("canvasOrg",["orgFilter","orgList"] ,["north","center"])	
		.addChildrenTo("canvasOrgEdit",["orgEdit","addressPanel"] ,["north","center"])	
		.addChildrenTo("canvasHierarchy",["panelHierarchy"] ,["center"])	
	 	.addChildrenTo("panelHierarchy", ["panelHierarchyList","panelHierarchyEdit"]) 				 		
		.addChildrenTo("panelHierarchyList",["hierarchyFilter","hierarchyList"] ,["north","center"])	
		.addChildrenTo("panelHierarchyEdit",["hierarchyEdit","itemsEditList"] ,["north","center"])	
	 	.addChildrenTo("addressPanel", ["addressList","addressEditWrapper"]) 				 		
	 	.addChildrenTo("addressEditWrapper", ["addressEdit"]) 				 		
		.addChildrenTo("canvasOrgType",["orgtypeFilter","orgtypeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasOrg","tlbOrgList")	  	
	 	.addToolbarTo("canvasOrgEdit","tlbOrgEdit")	  	
	 	.addToolbarTo("panelHierarchyList","tlbHierarchyList")	  	
	 	.addToolbarTo("panelHierarchyEdit","tlbHierarchyEdit")	  	
	 	.addToolbarTo("itemsEditList","tlbItemsEditList")	  	
	 	.addToolbarTo("canvasOrgType","tlbOrgtypeList")	  	
	 	.addToolbarTo("addressList","tlbAddressList")	  	
	 	.addToolbarTo("addressEditWrapper","tlbAddressEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOrgList", {dc:"org"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Organizations"}).end()
			.beginToolbar("tlbOrgEdit", {dc:"org"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbHierarchyList", {dc:"hierarchy"}).addQuery().addEdit({inContainer:"panelHierarchy",showView:"panelHierarchyEdit"}).addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Hierarchies > List"}).end()
			.beginToolbar("tlbHierarchyEdit", {dc:"hierarchy"}).addBack({inContainer:"panelHierarchy",showView:"panelHierarchyList"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Hierarchies > Editor"}).end()
			.beginToolbar("tlbItemsEditList", {dc:"items"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbOrgtypeList", {dc:"orgtype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Organization types"}).end()
			.beginToolbar("tlbAddressList", {dc:"address"}).addQuery().addEdit({inContainer:"addressPanel",showView:"addressEditWrapper"}).addNew().addCopy().addDeleteSelected().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbAddressEdit", {dc:"address"}).addBack({inContainer:"addressPanel",showView:"addressList"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addAutoLoad().end(); 	
	}

});  
