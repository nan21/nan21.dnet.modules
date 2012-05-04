Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/PaymentMethodDs", "nan21.dnet.module.bd.ui.extjs/dc/PaymentMethod", "nan21.dnet.module.bd.ui.extjs/ds/PaymentTermDs", "nan21.dnet.module.bd.ui.extjs/dc/PaymentTerm", "nan21.dnet.module.bd.ui.extjs/ds/DeliveryMethodDs", "nan21.dnet.module.bd.ui.extjs/dc/DeliveryMethod","nan21.dnet.module.bd.ui.extjs/ds/TxDocTypePayLovDs","nan21.dnet.module.bd.ui.extjs/lov/TxDocTypesPay","nan21.dnet.module.bd.ui.extjs/ds/TxDocTypePayLovDs","nan21.dnet.module.bd.ui.extjs/lov/TxDocTypesPay"]);

Ext.define("net.nan21.dnet.module.bd.tx.frame.TxBaseData_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.tx.frame.TxBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.tx.frame.TxBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("payMtd", new net.nan21.dnet.module.bd.tx.dc.PaymentMethod({multiEdit:true}))
		.addDc("payTerm", new net.nan21.dnet.module.bd.tx.dc.PaymentTerm({multiEdit:true}))
		.addDc("delivMtd", new net.nan21.dnet.module.bd.tx.dc.DeliveryMethod({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("payMtd",{ name:"payMtdFilter", xtype:"net.nan21.dnet.module.bd.tx.dc.PaymentMethod$Filter",height:120})	 
		.addDcEditGridView("payMtd",{ name:"payMtdEditList", xtype:"net.nan21.dnet.module.bd.tx.dc.PaymentMethod$EditList", frame:true})	 
		.addDcFilterFormView("payTerm",{ name:"payTermFilter", xtype:"net.nan21.dnet.module.bd.tx.dc.PaymentTerm$Filter",height:120})	 
		.addDcEditGridView("payTerm",{ name:"payTermEditList", xtype:"net.nan21.dnet.module.bd.tx.dc.PaymentTerm$EditList", frame:true})	 
		.addDcFilterFormView("delivMtd",{ name:"delivMtdFilter", xtype:"net.nan21.dnet.module.bd.tx.dc.DeliveryMethod$Filter",height:120})	 
		.addDcEditGridView("delivMtd",{ name:"delivMtdEditList", xtype:"net.nan21.dnet.module.bd.tx.dc.DeliveryMethod$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasPayMtd", layout:"border", defaults:{split:true},title:"Payment methods",preventHeader:true})  	 
		.addPanel({name: "canvasPayTerm", layout:"border", defaults:{split:true},title:"Payment terms",preventHeader:true})  	 
		.addPanel({name: "canvasDelivMtd", layout:"border", defaults:{split:true},title:"Delivery methods",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasPayMtd","canvasPayTerm","canvasDelivMtd"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasPayMtd","canvasPayTerm","canvasDelivMtd"]) 				 		
		.addChildrenTo("canvasPayMtd",["payMtdFilter","payMtdEditList"] ,["north","center"])	
		.addChildrenTo("canvasPayTerm",["payTermFilter","payTermEditList"] ,["north","center"])	
		.addChildrenTo("canvasDelivMtd",["delivMtdFilter","delivMtdEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasPayMtd","tlbpayMtd")	  	
	 	.addToolbarTo("canvasPayTerm","tlbpayTerm")	  	
	 	.addToolbarTo("canvasDelivMtd","tlbdelivMtd")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbpayMtd", {dc:"payMtd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Payment methods"}).end()
			.beginToolbar("tlbpayTerm", {dc:"payTerm"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Payment terms"}).end()
			.beginToolbar("tlbdelivMtd", {dc:"delivMtd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Delivery methods"}).end(); 	
	}

});  
