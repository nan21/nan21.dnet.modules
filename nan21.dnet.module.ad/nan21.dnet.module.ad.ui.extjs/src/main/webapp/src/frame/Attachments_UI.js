Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes"]);

Ext.define("net.nan21.dnet.module.ad.data.frame.Attachments_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.data.frame.Attachments_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.data.frame.Attachments_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("atch",{ name:"atchFilter", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$Filter"})	 
		.addDcEditGridView("atch",{ name:"atchList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$List", frame:true})	 
		.addPanel({name: "main", layout:"border", defaults:{split:true}})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
		.addChildrenTo("main",["atchFilter","atchList"] ,["north","center"])	
	 	.addToolbarTo("main","tlbAtchList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addDeleteSelected().end(); 	
	}

});  
