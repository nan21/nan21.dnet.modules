Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/AccDocDs", "nan21.dnet.module.md.ui.extjs/dc/AccDoc", "nan21.dnet.module.md.ui.extjs/ds/AccDocLineDs", "nan21.dnet.module.md.ui.extjs/dc/AccDocLine","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.bd.ui.extjs/lov/AccSchemas","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.bd.ui.extjs/lov/AccSchemas"]);

Ext.define("net.nan21.dnet.module.md.tx.fin.frame.AccDoc_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.frame.AccDoc_UI",
	
	 _name_ : "net.nan21.dnet.module.md.tx.fin.frame.AccDoc_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("doc", new net.nan21.dnet.module.md.tx.fin.dc.AccDoc({}))
		.addDc("line", new net.nan21.dnet.module.md.tx.fin.dc.AccDocLine({}))		
		.linkDc("line", "doc",{fields:[ {childField:"accDocId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("doc",{ name:"docFilter", xtype:"net.nan21.dnet.module.md.tx.fin.dc.AccDoc$Filter",height:90})	 
		.addDcGridView("doc",{ name:"docList", xtype:"net.nan21.dnet.module.md.tx.fin.dc.AccDoc$List"})	 
		.addDcFormView("doc",{ name:"docEdit", xtype:"net.nan21.dnet.module.md.tx.fin.dc.AccDoc$Edit"})	 
		.addDcGridView("line",{ name:"lineList", xtype:"net.nan21.dnet.module.md.tx.fin.dc.AccDocLine$List",height:200})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["docFilter","docList","lineList"] ,["north","center","south"])	
	 	.addToolbarTo("canvas1","tlbDocList")	  	
	 	.addToolbarTo("lineList","tlbLineList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbDocList", {dc:"doc"}).addQuery().addReports().end()
			.beginToolbar("tlbLineList", {dc:"line"}).addQuery().addSeparator().addAutoLoad().addReports().end(); 	
	}

});  
