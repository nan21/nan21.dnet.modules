Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/ItemDs", "nan21.dnet.module.pj.ui.extjs/dc/Item", "nan21.dnet.module.pj.ui.extjs/ds/ItemLinkDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemLink","nan21.dnet.module.pj.ui.extjs/ds/ItemTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemTypes","nan21.dnet.module.pj.ui.extjs/ds/ItemStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemStatus","nan21.dnet.module.pj.ui.extjs/ds/ItemPriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemPriorities","nan21.dnet.module.pj.ui.extjs/ds/ItemResolutionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemResolutions","nan21.dnet.module.pj.ui.extjs/ds/ItemSeverityLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemSeverities","nan21.dnet.module.pj.ui.extjs/ds/ItemTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemTypes","nan21.dnet.module.pj.ui.extjs/ds/ItemStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemStatus","nan21.dnet.module.pj.ui.extjs/ds/ItemPriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemPriorities","nan21.dnet.module.pj.ui.extjs/ds/ItemResolutionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemResolutions","nan21.dnet.module.pj.ui.extjs/ds/ItemSeverityLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemSeverities"]);

Ext.define("net.nan21.dnet.module.pj.md.frame.Items_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.md.frame.Items_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.md.frame.Items_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("item", new net.nan21.dnet.module.pj.md.dc.Item({}))
		.addDc("link", new net.nan21.dnet.module.pj.md.dc.ItemLink({multiEdit:true}))		
		.linkDc("link", "item",{fields:[ {childField:"sourceItemId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("item",{ name:"itemFilter", xtype:"net.nan21.dnet.module.pj.md.dc.Item$Filter",height:120})	 
		.addDcView("item",{ name:"itemList", xtype:"net.nan21.dnet.module.pj.md.dc.Item$List"})	 
		.addDcFormView("item",{ name:"itemEdit", xtype:"net.nan21.dnet.module.pj.md.dc.Item$Edit",height:180})	 
		.addDcFilterFormView("link",{ name:"linkFilter", xtype:"net.nan21.dnet.module.pj.md.dc.ItemLink$Filter"})	 
		.addDcView("link",{ name:"linkEditList", xtype:"net.nan21.dnet.module.pj.md.dc.ItemLink$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["itemFilter","itemList"] ,["north","center"])	
		.addChildrenTo("canvas2",["itemEdit","linkEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbItemList")	  	
	 	.addToolbarTo("canvas2","tlbItemEdit")	  	
	 	.addToolbarTo("linkEditList","tlbLinkEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbItemList", {dc:"item"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbItemEdit", {dc:"item"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbLinkEditList", {dc:"link"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end(); 	
	}

});  
