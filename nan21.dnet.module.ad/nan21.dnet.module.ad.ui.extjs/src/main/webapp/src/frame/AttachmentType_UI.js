Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeDs", "nan21.dnet.module.ad.ui.extjs/dc/AttachmentType"]);

Ext.define("net.nan21.dnet.module.ad.data.frame.AttachmentType_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.data.frame.AttachmentType_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.data.frame.AttachmentType_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("attchType", new net.nan21.dnet.module.ad.data.dc.AttachmentType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("attchType",{ name:"attchTypeFilter", xtype:"net.nan21.dnet.module.ad.data.dc.AttachmentType$Filter",height:120})	 
		.addDcView("attchType",{ name:"attchTypeEditList", xtype:"net.nan21.dnet.module.ad.data.dc.AttachmentType$EditList", frame:true})	 
		.addPanel({name: "main", layout:"border", defaults:{split:true}})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
		.addChildrenTo("main",["attchTypeFilter","attchTypeEditList"] ,["north","center"])	
	 	.addToolbarTo("main","tlbAttchTypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAttchTypeEditList", {dc:"attchType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});  
