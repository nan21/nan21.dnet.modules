Dnet.import(["", "nan21.dnet.module.bp.ui.extjs/ds/BpAccountDs", "nan21.dnet.module.bp.ui.extjs/dc/BpAccount","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bd.ui.extjs/ds/OrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/Organizations","nan21.dnet.module.bp.ui.extjs/ds/CustomerGroupLovDs","nan21.dnet.module.bp.ui.extjs/lov/CustomerGroup","nan21.dnet.module.bp.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.bp.ui.extjs/lov/PaymentMethod","nan21.dnet.module.bp.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.bp.ui.extjs/lov/PaymentTerm","nan21.dnet.module.bp.ui.extjs/ds/VendorGroupLovDs","nan21.dnet.module.bp.ui.extjs/lov/VendorGroup","nan21.dnet.module.bp.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.bp.ui.extjs/lov/PaymentMethod","nan21.dnet.module.bp.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.bp.ui.extjs/lov/PaymentTerm","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bd.ui.extjs/ds/OrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/Organizations","nan21.dnet.module.bp.ui.extjs/ds/CustomerGroupLovDs","nan21.dnet.module.bp.ui.extjs/lov/CustomerGroup","nan21.dnet.module.bp.ui.extjs/ds/VendorGroupLovDs","nan21.dnet.module.bp.ui.extjs/lov/VendorGroup"]);

Ext.ns("net.nan21.dnet.module.bp.md.frame");
net.nan21.dnet.module.bp.md.frame.BpAccount_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bp.md.frame.BpAccount_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.bp.md.dc.BpAccount())		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcFilterFormView("m",{ name:"mFilter", xtype:"net.nan21.dnet.module.bp.md.dc.BpAccount$Filter"})	 
		.addDcView("m",{ name:"mList", xtype:"net.nan21.dnet.module.bp.md.dc.BpAccount$List"})	 
		.addDcFormView("m",{ name:"mEdit", xtype:"net.nan21.dnet.module.bp.md.dc.BpAccount$Edit"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["mFilter","mList"] ,["north","center"])	
		.addChildrenTo("canvas2",["mEdit"] ,["center"])	
	 	.addToolbarTo("canvas1","tlbMList")	  	
	 	.addToolbarTo("canvas2","tlbMEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMList", {dc:"m"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbMEdit", {dc:"m"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.bp.md.frame.BpAccount_UI", net.nan21.dnet.module.bp.md.frame.BpAccount_UI);   
