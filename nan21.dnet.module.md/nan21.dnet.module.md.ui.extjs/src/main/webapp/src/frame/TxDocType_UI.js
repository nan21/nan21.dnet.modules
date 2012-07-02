Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/TxDocTypeDs", "nan21.dnet.module.md.ui.extjs/dc/TxDocType", "nan21.dnet.module.md.ui.extjs/ds/TxDocSequenceDs", "nan21.dnet.module.md.ui.extjs/dc/TxDocSequence","nan21.dnet.module.md.ui.extjs/ds/AccJournalLovDs","nan21.dnet.module.md.ui.extjs/lov/AccJournals","nan21.dnet.module.md.ui.extjs/ds/AccJournalLovDs","nan21.dnet.module.md.ui.extjs/lov/AccJournals"]);

Ext.define("net.nan21.dnet.module.md.base.tx.frame.TxDocType_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.base.tx.frame.TxDocType_UI",
	
	 _name_ : "net.nan21.dnet.module.md.base.tx.frame.TxDocType_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("docType", new net.nan21.dnet.module.md.base.tx.dc.TxDocType({multiEdit:true}))
		.addDc("seq", new net.nan21.dnet.module.md.base.tx.dc.TxDocSequence({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("docType",{ name:"docTypeFilter", xtype:"net.nan21.dnet.module.md.base.tx.dc.TxDocType$Filter",height:80})	 
		.addDcEditGridView("docType",{ name:"docTypeEditList", xtype:"net.nan21.dnet.module.md.base.tx.dc.TxDocType$EditList", frame:true})	 
		.addDcFilterFormView("seq",{ name:"seqFilter", xtype:"net.nan21.dnet.module.md.base.tx.dc.TxDocSequence$Filter"})	 
		.addDcEditGridView("seq",{ name:"seqEditList", xtype:"net.nan21.dnet.module.md.base.tx.dc.TxDocSequence$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasDocType", layout:"border", defaults:{split:true},title:"Document types",preventHeader:true})  	 
		.addPanel({name: "canvasDocSeq", layout:"border", defaults:{split:true},title:"Document sequences",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasDocType","canvasDocSeq"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasDocType","canvasDocSeq"]) 				 		
		.addChildrenTo("canvasDocType",["docTypeFilter","docTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasDocSeq",["seqFilter","seqEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasDocType","tlbdocType")	  	
	 	.addToolbarTo("canvasDocSeq","tlbSeqEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbdocType", {dc:"docType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Document types"}).end()
			.beginToolbar("tlbSeqEditList", {dc:"seq"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Document sequences"}).end(); 	
	}

});  
