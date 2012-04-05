Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/PaymentMethodDs", "nan21.dnet.module.bd.ui.extjs/dc/PaymentMethod", "nan21.dnet.module.bd.ui.extjs/ds/PaymentTermDs", "nan21.dnet.module.bd.ui.extjs/dc/PaymentTerm", "nan21.dnet.module.bd.ui.extjs/ds/FinDocTypeDs", "nan21.dnet.module.bd.ui.extjs/dc/FinDocType"]);

Ext.define("net.nan21.dnet.module.bd.fin.frame.PaymentBaseData_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.fin.frame.PaymentBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.fin.frame.PaymentBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("payMtd", new net.nan21.dnet.module.bd.fin.dc.PaymentMethod({multiEdit:true}))
		.addDc("payTerm", new net.nan21.dnet.module.bd.fin.dc.PaymentTerm({multiEdit:true}))
		.addDc("docType", new net.nan21.dnet.module.bd.fin.dc.FinDocType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("payMtd",{ name:"payMtdFilter", xtype:"net.nan21.dnet.module.bd.fin.dc.PaymentMethod$Filter",height:120})	 
		.addDcEditGridView("payMtd",{ name:"payMtdEditList", xtype:"net.nan21.dnet.module.bd.fin.dc.PaymentMethod$EditList", frame:true})	 
		.addDcFilterFormView("payTerm",{ name:"payTermFilter", xtype:"net.nan21.dnet.module.bd.fin.dc.PaymentTerm$Filter",height:120})	 
		.addDcEditGridView("payTerm",{ name:"payTermEditList", xtype:"net.nan21.dnet.module.bd.fin.dc.PaymentTerm$EditList", frame:true})	 
		.addDcFilterFormView("docType",{ name:"docTypeFilter", xtype:"net.nan21.dnet.module.bd.fin.dc.FinDocType$Filter",height:120})	 
		.addDcEditGridView("docType",{ name:"docTypeEditList", xtype:"net.nan21.dnet.module.bd.fin.dc.FinDocType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasPayMtd", layout:"border", defaults:{split:true},title:"Payment methods",preventHeader:true})  	 
		.addPanel({name: "canvasPayTerm", layout:"border", defaults:{split:true},title:"Payment terms",preventHeader:true})  	 
		.addPanel({name: "canvasDocType", layout:"border", defaults:{split:true},title:"Document types",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasPayMtd","canvasPayTerm","canvasDocType"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasPayMtd","canvasPayTerm","canvasDocType"]) 				 		
		.addChildrenTo("canvasPayMtd",["payMtdFilter","payMtdEditList"] ,["north","center"])	
		.addChildrenTo("canvasPayTerm",["payTermFilter","payTermEditList"] ,["north","center"])	
		.addChildrenTo("canvasDocType",["docTypeFilter","docTypeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasPayMtd","tlbpayMtd")	  	
	 	.addToolbarTo("canvasPayTerm","tlbpayTerm")	  	
	 	.addToolbarTo("canvasDocType","tlbdocType")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbpayMtd", {dc:"payMtd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Payment methods"}).end()
			.beginToolbar("tlbpayTerm", {dc:"payTerm"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Payment terms"}).end()
			.beginToolbar("tlbdocType", {dc:"docType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Document types"}).end(); 	
	}

});  
