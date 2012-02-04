Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelTypeDs", "nan21.dnet.module.bd.ui.extjs/dc/CommunicationChannelType"]);

Ext.define("net.nan21.dnet.module.bd.contact.frame.CommunicationChannelTypes_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.contact.frame.CommunicationChannelTypes_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.contact.frame.CommunicationChannelTypes_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.bd.contact.dc.CommunicationChannelType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("m",{ name:"mFilter", xtype:"net.nan21.dnet.module.bd.contact.dc.CommunicationChannelType$Filter",height:40})	 
		.addDcView("m",{ name:"mEditList", xtype:"net.nan21.dnet.module.bd.contact.dc.CommunicationChannelType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["mFilter","mEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbMEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMEditList", {dc:"m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Edit list"}).end(); 	
	}

});  
