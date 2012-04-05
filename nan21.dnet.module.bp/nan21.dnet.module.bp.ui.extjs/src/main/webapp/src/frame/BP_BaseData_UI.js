Dnet.doImport(["", "nan21.dnet.module.bp.ui.extjs/ds/CustomerGroupDs", "nan21.dnet.module.bp.ui.extjs/dc/CustomerGroup", "nan21.dnet.module.bp.ui.extjs/ds/VendorGroupDs", "nan21.dnet.module.bp.ui.extjs/dc/VendorGroup", "nan21.dnet.module.bp.ui.extjs/ds/DeliveryMethodDs", "nan21.dnet.module.bp.ui.extjs/dc/DeliveryMethod", "nan21.dnet.module.bp.ui.extjs/ds/CompanyLegalFormDs", "nan21.dnet.module.bp.ui.extjs/dc/CompanyLegalForm","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries"]);

Ext.define("net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("custGroup", new net.nan21.dnet.module.bp.base.dc.CustomerGroup({multiEdit:true}))
		.addDc("vendGroup", new net.nan21.dnet.module.bp.base.dc.VendorGroup({multiEdit:true}))
		.addDc("delivMtd", new net.nan21.dnet.module.bp.base.dc.DeliveryMethod({multiEdit:true}))
		.addDc("legalForm", new net.nan21.dnet.module.bp.base.dc.CompanyLegalForm({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("custGroup",{ name:"custGroupFilter", xtype:"net.nan21.dnet.module.bp.base.dc.CustomerGroup$Filter",height:120})	 
		.addDcEditGridView("custGroup",{ name:"custGroupEditList", xtype:"net.nan21.dnet.module.bp.base.dc.CustomerGroup$EditList", frame:true})	 
		.addDcFilterFormView("vendGroup",{ name:"vendGroupFilter", xtype:"net.nan21.dnet.module.bp.base.dc.VendorGroup$Filter",height:120})	 
		.addDcEditGridView("vendGroup",{ name:"vendGroupEditList", xtype:"net.nan21.dnet.module.bp.base.dc.VendorGroup$EditList", frame:true})	 
		.addDcFilterFormView("delivMtd",{ name:"delivMtdFilter", xtype:"net.nan21.dnet.module.bp.base.dc.DeliveryMethod$Filter",height:120})	 
		.addDcEditGridView("delivMtd",{ name:"delivMtdEditList", xtype:"net.nan21.dnet.module.bp.base.dc.DeliveryMethod$EditList", frame:true})	 
		.addDcFilterFormView("legalForm",{ name:"legalFormFilter", xtype:"net.nan21.dnet.module.bp.base.dc.CompanyLegalForm$Filter",height:120})	 
		.addDcEditGridView("legalForm",{ name:"legalFormEditList", xtype:"net.nan21.dnet.module.bp.base.dc.CompanyLegalForm$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCustGroup", layout:"border", defaults:{split:true},title:"Customer groups",preventHeader:true})  	 
		.addPanel({name: "canvasVendGroup", layout:"border", defaults:{split:true},title:"Vendor groups",preventHeader:true})  	 
		.addPanel({name: "canvasDelivMtd", layout:"border", defaults:{split:true},title:"Delivery methods",preventHeader:true})  	 
		.addPanel({name: "canvasLegalForm", layout:"border", defaults:{split:true},title:"Company legal form",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasLegalForm","canvasCustGroup","canvasVendGroup","canvasDelivMtd"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasLegalForm","canvasCustGroup","canvasVendGroup","canvasDelivMtd"]) 				 		
		.addChildrenTo("canvasCustGroup",["custGroupFilter","custGroupEditList"] ,["north","center"])	
		.addChildrenTo("canvasVendGroup",["vendGroupFilter","vendGroupEditList"] ,["north","center"])	
		.addChildrenTo("canvasDelivMtd",["delivMtdFilter","delivMtdEditList"] ,["north","center"])	
		.addChildrenTo("canvasLegalForm",["legalFormFilter","legalFormEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCustGroup","tlbcustGroup")	  	
	 	.addToolbarTo("canvasVendGroup","tlbvendGroup")	  	
	 	.addToolbarTo("canvasLegalForm","tlblegalForm")	  	
	 	.addToolbarTo("canvasDelivMtd","tlbdelivMtd")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbcustGroup", {dc:"custGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Customer groups"}).end()
			.beginToolbar("tlbvendGroup", {dc:"vendGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Vendor groups"}).end()
			.beginToolbar("tlblegalForm", {dc:"legalForm"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Company legal form"}).end()
			.beginToolbar("tlbdelivMtd", {dc:"delivMtd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Delivery methods"}).end(); 	
	}

});  
