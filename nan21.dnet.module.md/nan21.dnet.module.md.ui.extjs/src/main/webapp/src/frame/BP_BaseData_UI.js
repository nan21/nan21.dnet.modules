Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/CustomerGroupDs", "nan21.dnet.module.md.ui.extjs/dc/CustomerGroup", "nan21.dnet.module.md.ui.extjs/ds/CustomerGroupAcctDs", "nan21.dnet.module.md.ui.extjs/dc/CustomerGroupAcct", "nan21.dnet.module.md.ui.extjs/ds/VendorGroupDs", "nan21.dnet.module.md.ui.extjs/dc/VendorGroup", "nan21.dnet.module.md.ui.extjs/ds/VendorGroupAcctDs", "nan21.dnet.module.md.ui.extjs/dc/VendorGroupAcct", "nan21.dnet.module.md.ui.extjs/ds/CompanyLegalFormDs", "nan21.dnet.module.md.ui.extjs/dc/CompanyLegalForm","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.md.ui.extjs/lov/AccSchemas","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.md.ui.extjs/lov/AccSchemas","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries"]);

Ext.define("net.nan21.dnet.module.md.bp.frame.BP_BaseData_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.bp.frame.BP_BaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.md.bp.frame.BP_BaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("custGroup", new net.nan21.dnet.module.md.bp.dc.CustomerGroup({multiEdit:true}))
		.addDc("custGroupAcct", new net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct({multiEdit:true}))
		.addDc("vendGroup", new net.nan21.dnet.module.md.bp.dc.VendorGroup({multiEdit:true}))
		.addDc("vendGroupAcct", new net.nan21.dnet.module.md.bp.dc.VendorGroupAcct({multiEdit:true}))
		.addDc("legalForm", new net.nan21.dnet.module.md.bp.dc.CompanyLegalForm({multiEdit:true}))		
		.linkDc("custGroupAcct", "custGroup",{fields:[ {childField:"custGroupId", parentField:"id"} ]} )
		.linkDc("vendGroupAcct", "vendGroup",{fields:[ {childField:"vendorGroupId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("custGroup",{ name:"custGroupFilter", xtype:"net.nan21.dnet.module.md.bp.dc.CustomerGroup$Filter",height:120})	 
		.addDcEditGridView("custGroup",{ name:"custGroupEditList", xtype:"net.nan21.dnet.module.md.bp.dc.CustomerGroup$EditList", frame:true})	 
		.addDcEditGridView("custGroupAcct",{ name:"custGroupAcctEditList", xtype:"net.nan21.dnet.module.md.bp.dc.CustomerGroupAcct$CtxEditList", frame:true,height:200})	 
		.addDcFilterFormView("vendGroup",{ name:"vendGroupFilter", xtype:"net.nan21.dnet.module.md.bp.dc.VendorGroup$Filter",height:120})	 
		.addDcEditGridView("vendGroup",{ name:"vendGroupEditList", xtype:"net.nan21.dnet.module.md.bp.dc.VendorGroup$EditList", frame:true})	 
		.addDcEditGridView("vendGroupAcct",{ name:"vendGroupAcctEditList", xtype:"net.nan21.dnet.module.md.bp.dc.VendorGroupAcct$CtxEditList", frame:true,height:200})	 
		.addDcFilterFormView("legalForm",{ name:"legalFormFilter", xtype:"net.nan21.dnet.module.md.bp.dc.CompanyLegalForm$Filter",height:120})	 
		.addDcEditGridView("legalForm",{ name:"legalFormEditList", xtype:"net.nan21.dnet.module.md.bp.dc.CompanyLegalForm$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCustGroup", layout:"border", defaults:{split:true},title:"Customer groups",preventHeader:true})  	 
		.addPanel({name: "canvasVendGroup", layout:"border", defaults:{split:true},title:"Vendor groups",preventHeader:true})  	 
		.addPanel({name: "canvasLegalForm", layout:"border", defaults:{split:true},title:"Company legal form",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasLegalForm","canvasCustGroup","canvasVendGroup"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasLegalForm","canvasCustGroup","canvasVendGroup"]) 				 		
		.addChildrenTo("canvasCustGroup",["custGroupFilter","custGroupEditList","custGroupAcctEditList"] ,["north","center","south"])	
		.addChildrenTo("canvasVendGroup",["vendGroupFilter","vendGroupEditList","vendGroupAcctEditList"] ,["north","center","south"])	
		.addChildrenTo("canvasLegalForm",["legalFormFilter","legalFormEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCustGroup","tlbCustGroup")	  	
	 	.addToolbarTo("canvasVendGroup","tlbVendGroup")	  	
	 	.addToolbarTo("custGroupAcctEditList","tlbCustGroupAcct")	  	
	 	.addToolbarTo("vendGroupAcctEditList","tlbVendGroupAcct")	  	
	 	.addToolbarTo("canvasLegalForm","tlblegalForm")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCustGroup", {dc:"custGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Customer groups"}).end()
			.beginToolbar("tlbVendGroup", {dc:"vendGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Vendor groups"}).end()
			.beginToolbar("tlbCustGroupAcct", {dc:"custGroupAcct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Accounting"}).end()
			.beginToolbar("tlbVendGroupAcct", {dc:"vendGroupAcct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Accounting"}).end()
			.beginToolbar("tlblegalForm", {dc:"legalForm"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Company legal form"}).end(); 	
	}

});  
