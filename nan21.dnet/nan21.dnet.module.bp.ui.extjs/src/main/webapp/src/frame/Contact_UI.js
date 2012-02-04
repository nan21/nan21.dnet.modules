Dnet.doImport(["", "nan21.dnet.module.bp.ui.extjs/ds/ContactDs", "nan21.dnet.module.bp.ui.extjs/dc/Contact", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelDs", "nan21.dnet.module.bd.ui.extjs/dc/CommunicationChannel","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartnersCode","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartnersCode","nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/CommunicationChannelTypes"]);

Ext.define("net.nan21.dnet.module.bp.md.frame.Contact_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bp.md.frame.Contact_UI",
	
	 _name_ : "net.nan21.dnet.module.bp.md.frame.Contact_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("c", new net.nan21.dnet.module.bp.md.dc.Contact({}))
		.addDc("communic", new net.nan21.dnet.module.bd.contact.dc.CommunicationChannel({multiEdit:true}))		
		.linkDc("communic", "c",{fields:[ {childField:"", parentField:"id"},{childField:"targetType", parentField:"className"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("c",{ name:"cFilter", xtype:"net.nan21.dnet.module.bp.md.dc.Contact$Filter",height:120})	 
		.addDcView("c",{ name:"cList", xtype:"net.nan21.dnet.module.bp.md.dc.Contact$List"})	 
		.addDcFormView("c",{ name:"cEdit", xtype:"net.nan21.dnet.module.bp.md.dc.Contact$Edit",height:120})	 
		.addDcView("communic",{ name:"communicEditList", xtype:"net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList", frame:true,title:"Communication"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "bpDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["cFilter","cList"] ,["north","center"])	
		.addChildrenTo("canvas2",["cEdit","bpDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("bpDetailsTab", ["communicEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbTList")	  	
	 	.addToolbarTo("canvas2","tlbTEdit")	  	
	 	.addToolbarTo("communicEditList","tlbCommunicEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTList", {dc:"c"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Contacts"}).end()
			.beginToolbar("tlbTEdit", {dc:"c"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Contact"}).end()
			.beginToolbar("tlbCommunicEditList", {dc:"communic"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Communication"}).end(); 	
	}

});  
