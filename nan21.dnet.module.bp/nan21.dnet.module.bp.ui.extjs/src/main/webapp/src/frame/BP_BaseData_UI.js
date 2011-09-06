Dnet.import(["", "nan21.dnet.module.bp.ui.extjs/ds/CustomerGroupDs", "nan21.dnet.module.bp.ui.extjs/dc/CustomerGroup", "nan21.dnet.module.bp.ui.extjs/ds/VendorGroupDs", "nan21.dnet.module.bp.ui.extjs/dc/VendorGroup", "nan21.dnet.module.bp.ui.extjs/ds/DeliveryMethodDs", "nan21.dnet.module.bp.ui.extjs/dc/DeliveryMethod", "nan21.dnet.module.bp.ui.extjs/ds/PaymentMethodDs", "nan21.dnet.module.bp.ui.extjs/dc/PaymentMethod", "nan21.dnet.module.bp.ui.extjs/ds/PaymentTermDs", "nan21.dnet.module.bp.ui.extjs/dc/PaymentTerm"]);

Ext.ns("net.nan21.dnet.module.bp.base.frame");
net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("custGroup", new net.nan21.dnet.module.bp.base.dc.CustomerGroup({multiEdit:true}))
		.addDc("vendGroup", new net.nan21.dnet.module.bp.base.dc.VendorGroup({multiEdit:true}))
		.addDc("delivMtd", new net.nan21.dnet.module.bp.base.dc.DeliveryMethod({multiEdit:true}))
		.addDc("payMtd", new net.nan21.dnet.module.bp.base.dc.PaymentMethod({multiEdit:true}))
		.addDc("payTerm", new net.nan21.dnet.module.bp.base.dc.PaymentTerm({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("custGroup",{ name:"custGroupFilter", xtype:"net.nan21.dnet.module.bp.base.dc.CustomerGroup$Filter",height:40})	 
		.addDcView("custGroup",{ name:"custGroupEditList", xtype:"net.nan21.dnet.module.bp.base.dc.CustomerGroup$EditList", frame:true})	 
		.addDcFilterFormView("vendGroup",{ name:"vendGroupFilter", xtype:"net.nan21.dnet.module.bp.base.dc.VendorGroup$Filter",height:40})	 
		.addDcView("vendGroup",{ name:"vendGroupEditList", xtype:"net.nan21.dnet.module.bp.base.dc.VendorGroup$EditList", frame:true})	 
		.addDcFilterFormView("delivMtd",{ name:"delivMtdFilter", xtype:"net.nan21.dnet.module.bp.base.dc.DeliveryMethod$Filter",height:40})	 
		.addDcView("delivMtd",{ name:"delivMtdEditList", xtype:"net.nan21.dnet.module.bp.base.dc.DeliveryMethod$EditList", frame:true})	 
		.addDcFilterFormView("payMtd",{ name:"payMtdFilter", xtype:"net.nan21.dnet.module.bp.base.dc.PaymentMethod$Filter",height:40})	 
		.addDcView("payMtd",{ name:"payMtdEditList", xtype:"net.nan21.dnet.module.bp.base.dc.PaymentMethod$EditList", frame:true})	 
		.addDcFilterFormView("payTerm",{ name:"payTermFilter", xtype:"net.nan21.dnet.module.bp.base.dc.PaymentTerm$Filter",height:40})	 
		.addDcView("payTerm",{ name:"payTermEditList", xtype:"net.nan21.dnet.module.bp.base.dc.PaymentTerm$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCustGroup", layout:"border", defaults:{split:true},title:"Customer groups",header:false})  	 
		.addPanel({name: "canvasVendGroup", layout:"border", defaults:{split:true},title:"Vendor groups",header:false})  	 
		.addPanel({name: "canvasDelivMtd", layout:"border", defaults:{split:true},title:"Delivery methods",header:false})  	 
		.addPanel({name: "canvasPayMtd", layout:"border", defaults:{split:true},title:"Payment methods",header:false})  	 
		.addPanel({name: "canvasPayTerm", layout:"border", defaults:{split:true},title:"Payment terms",header:false})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasCustGroup","canvasVendGroup","canvasDelivMtd","canvasPayMtd","canvasPayTerm"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasCustGroup","canvasVendGroup","canvasDelivMtd","canvasPayMtd","canvasPayTerm"]) 				 		
		.addChildrenTo("canvasCustGroup",["custGroupFilter","custGroupEditList"] ,["north","center"])	
		.addChildrenTo("canvasVendGroup",["vendGroupFilter","vendGroupEditList"] ,["north","center"])	
		.addChildrenTo("canvasDelivMtd",["delivMtdFilter","delivMtdEditList"] ,["north","center"])	
		.addChildrenTo("canvasPayMtd",["payMtdFilter","payMtdEditList"] ,["north","center"])	
		.addChildrenTo("canvasPayTerm",["payTermFilter","payTermEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCustGroup","tlbcustGroup")	  	
	 	.addToolbarTo("canvasVendGroup","tlbvendGroup")	  	
	 	.addToolbarTo("canvasDelivMtd","tlbdelivMtd")	  	
	 	.addToolbarTo("canvasPayMtd","tlbpayMtd")	  	
	 	.addToolbarTo("canvasPayTerm","tlbpayTerm")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbcustGroup", {dc:"custGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Customer groups"}).end()
			.beginToolbar("tlbvendGroup", {dc:"vendGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Vendor groups"}).end()
			.beginToolbar("tlbdelivMtd", {dc:"delivMtd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Delivery methods"}).end()
			.beginToolbar("tlbpayMtd", {dc:"payMtd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Payment methods"}).end()
			.beginToolbar("tlbpayTerm", {dc:"payTerm"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Payment terms"}).end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI", net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI);   
