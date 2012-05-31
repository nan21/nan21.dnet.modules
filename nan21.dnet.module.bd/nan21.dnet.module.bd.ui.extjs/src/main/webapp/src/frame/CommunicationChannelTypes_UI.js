Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelTypeDs", "nan21.dnet.module.bd.ui.extjs/dc/CommunicationChannelType"]);

Ext.define("net.nan21.dnet.module.bd.contact.frame.CommunicationChannelTypes_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.contact.frame.CommunicationChannelTypes_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.contact.frame.CommunicationChannelTypes_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("ctype", new net.nan21.dnet.module.bd.contact.dc.CommunicationChannelType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("ctype",{ name:"ctypeFilter", xtype:"net.nan21.dnet.module.bd.contact.dc.CommunicationChannelType$Filter",height:80})	 
		.addDcEditGridView("ctype",{ name:"ctypeEditList", xtype:"net.nan21.dnet.module.bd.contact.dc.CommunicationChannelType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["ctypeFilter","ctypeEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbCtypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCtypeEditList", {dc:"ctype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Communication methods"}).end(); 	
	}

});  
