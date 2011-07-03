Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/OrganizationTypeDs", "nan21.dnet.module.ad.ui.extjs/dc/OrganizationType"]);

Ext.ns("net.nan21.dnet.module.ad.org.frame");
net.nan21.dnet.module.ad.org.frame.OrgType_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.org.frame.OrgType_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("orgtype", new net.nan21.dnet.module.ad.org.dc.OrganizationType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("orgtype",{ name:"orgtypeFilter", xtype:"net.nan21.dnet.module.ad.org.dc.OrganizationType$Filter"})	 
		.addDcView("orgtype",{ name:"orgtypeEditList", xtype:"net.nan21.dnet.module.ad.org.dc.OrganizationType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["orgtypeFilter","orgtypeEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbOrgtypeList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOrgtypeList", {dc:"orgtype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.ad.org.frame.OrgType_UI", net.nan21.dnet.module.ad.org.frame.OrgType_UI);   
