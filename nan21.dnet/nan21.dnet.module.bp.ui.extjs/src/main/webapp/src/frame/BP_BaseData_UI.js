Dnet.doImport(["", "nan21.dnet.module.bp.ui.extjs/ds/CustomerGroupDs", "nan21.dnet.module.bp.ui.extjs/dc/CustomerGroup", "nan21.dnet.module.bp.ui.extjs/ds/VendorGroupDs", "nan21.dnet.module.bp.ui.extjs/dc/VendorGroup", "nan21.dnet.module.bp.ui.extjs/ds/DeliveryMethodDs", "nan21.dnet.module.bp.ui.extjs/dc/DeliveryMethod", "nan21.dnet.module.bp.ui.extjs/ds/PaymentMethodDs", "nan21.dnet.module.bp.ui.extjs/dc/PaymentMethod", "nan21.dnet.module.bp.ui.extjs/ds/PaymentTermDs", "nan21.dnet.module.bp.ui.extjs/dc/PaymentTerm", "nan21.dnet.module.bp.ui.extjs/ds/CompanyLegalFormDs", "nan21.dnet.module.bp.ui.extjs/dc/CompanyLegalForm","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries"]);

Ext.define("net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("custGroup", new net.nan21.dnet.module.bp.base.dc.CustomerGroup({multiEdit:true}))
		.addDc("vendGroup", new net.nan21.dnet.module.bp.base.dc.VendorGroup({multiEdit:true}))
		.addDc("delivMtd", new net.nan21.dnet.module.bp.base.dc.DeliveryMethod({multiEdit:true}))
		.addDc("payMtd", new net.nan21.dnet.module.bp.base.dc.PaymentMethod({multiEdit:true}))
		.addDc("payTerm", new net.nan21.dnet.module.bp.base.dc.PaymentTerm({multiEdit:true}))
		.addDc("legalForm", new net.nan21.dnet.module.bp.base.dc.CompanyLegalForm({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("custGroup",{ name:"custGroupFilter", xtype:"net.nan21.dnet.module.bp.base.dc.CustomerGroup$Filter",height:120})	 
		.addDcView("custGroup",{ name:"custGroupEditList", xtype:"net.nan21.dnet.module.bp.base.dc.CustomerGroup$EditList", frame:true})	 
		.addDcFilterFormView("vendGroup",{ name:"vendGroupFilter", xtype:"net.nan21.dnet.module.bp.base.dc.VendorGroup$Filter",height:120})	 
		.addDcView("vendGroup",{ name:"vendGroupEditList", xtype:"net.nan21.dnet.module.bp.base.dc.VendorGroup$EditList", frame:true})	 
		.addDcFilterFormView("delivMtd",{ name:"delivMtdFilter", xtype:"net.nan21.dnet.module.bp.base.dc.DeliveryMethod$Filter",height:120})	 
		.addDcView("delivMtd",{ name:"delivMtdEditList", xtype:"net.nan21.dnet.module.bp.base.dc.DeliveryMethod$EditList", frame:true})	 
		.addDcFilterFormView("payMtd",{ name:"payMtdFilter", xtype:"net.nan21.dnet.module.bp.base.dc.PaymentMethod$Filter",height:120})	 
		.addDcView("payMtd",{ name:"payMtdEditList", xtype:"net.nan21.dnet.module.bp.base.dc.PaymentMethod$EditList", frame:true})	 
		.addDcFilterFormView("payTerm",{ name:"payTermFilter", xtype:"net.nan21.dnet.module.bp.base.dc.PaymentTerm$Filter",height:120})	 
		.addDcView("payTerm",{ name:"payTermEditList", xtype:"net.nan21.dnet.module.bp.base.dc.PaymentTerm$EditList", frame:true})	 
		.addDcFilterFormView("legalForm",{ name:"legalFormFilter", xtype:"net.nan21.dnet.module.bp.base.dc.CompanyLegalForm$Filter",height:120})	 
		.addDcView("legalForm",{ name:"legalFormEditList", xtype:"net.nan21.dnet.module.bp.base.dc.CompanyLegalForm$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCustGroup", layout:"border", defaults:{split:true},title:"Customer groups",preventHeader:true})  	 
		.addPanel({name: "canvasVendGroup", layout:"border", defaults:{split:true},title:"Vendor groups",preventHeader:true})  	 
		.addPanel({name: "canvasDelivMtd", layout:"border", defaults:{split:true},title:"Delivery methods",preventHeader:true})  	 
		.addPanel({name: "canvasPayMtd", layout:"border", defaults:{split:true},title:"Payment methods",preventHeader:true})  	 
		.addPanel({name: "canvasPayTerm", layout:"border", defaults:{split:true},title:"Payment terms",preventHeader:true})  	 
		.addPanel({name: "canvasLegalForm", layout:"border", defaults:{split:true},title:"Company legal form",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasLegalForm","canvasCustGroup","canvasVendGroup","canvasDelivMtd","canvasPayMtd","canvasPayTerm"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasLegalForm","canvasCustGroup","canvasVendGroup","canvasDelivMtd","canvasPayMtd","canvasPayTerm"]) 				 		
		.addChildrenTo("canvasCustGroup",["custGroupFilter","custGroupEditList"] ,["north","center"])	
		.addChildrenTo("canvasVendGroup",["vendGroupFilter","vendGroupEditList"] ,["north","center"])	
		.addChildrenTo("canvasDelivMtd",["delivMtdFilter","delivMtdEditList"] ,["north","center"])	
		.addChildrenTo("canvasPayMtd",["payMtdFilter","payMtdEditList"] ,["north","center"])	
		.addChildrenTo("canvasPayTerm",["payTermFilter","payTermEditList"] ,["north","center"])	
		.addChildrenTo("canvasLegalForm",["legalFormFilter","legalFormEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCustGroup","tlbcustGroup")	  	
	 	.addToolbarTo("canvasVendGroup","tlbvendGroup")	  	
	 	.addToolbarTo("canvasLegalForm","tlblegalForm")	  	
	 	.addToolbarTo("canvasDelivMtd","tlbdelivMtd")	  	
	 	.addToolbarTo("canvasPayMtd","tlbpayMtd")	  	
	 	.addToolbarTo("canvasPayTerm","tlbpayTerm")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbcustGroup", {dc:"custGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Customer groups"}).end()
			.beginToolbar("tlbvendGroup", {dc:"vendGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Vendor groups"}).end()
			.beginToolbar("tlblegalForm", {dc:"legalForm"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Company legal form"}).end()
			.beginToolbar("tlbdelivMtd", {dc:"delivMtd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Delivery methods"}).end()
			.beginToolbar("tlbpayMtd", {dc:"payMtd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Payment methods"}).end()
			.beginToolbar("tlbpayTerm", {dc:"payTerm"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Payment terms"}).end(); 	
	}

});  