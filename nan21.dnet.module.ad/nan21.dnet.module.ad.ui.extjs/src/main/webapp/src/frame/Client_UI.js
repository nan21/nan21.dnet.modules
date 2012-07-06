Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/ClientDs", "nan21.dnet.module.ad.ui.extjs/dc/Client"]);

Ext.define("net.nan21.dnet.module.ad.client.frame.Client_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.client.frame.Client_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.client.frame.Client_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("client", new net.nan21.dnet.module.ad.client.dc.Client({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("client",{ name:"clientFilter", xtype:"net.nan21.dnet.module.ad.client.dc.Client$Filter",height:80})	 
		.addDcGridView("client",{ name:"clientList", xtype:"net.nan21.dnet.module.ad.client.dc.Client$List"})	 
		.addDcFormView("client",{ name:"clientEdit", xtype:"net.nan21.dnet.module.ad.client.dc.Client$Edit"})	 
		.addDcFormView("client",{ name:"clientCreate", xtype:"net.nan21.dnet.module.ad.client.dc.Client$Create"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas3", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2","canvas3"]) 				 		
		.addChildrenTo("canvas1",["clientFilter","clientList"] ,["north","center"])	
		.addChildrenTo("canvas2",["clientEdit"] ,["center"])	
		.addChildrenTo("canvas3",["clientCreate"] ,["center"])	
	 	.addToolbarTo("canvas1","tlbClientList")	  	
	 	.addToolbarTo("canvas2","tlbClientEdit")	  	
	 	.addToolbarTo("canvas3","tlbClientCreate")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbClientList", {dc:"client"}).addQuery().addEdit().addNew({autoEdit:"false",showView:"canvas3"}).addReports().addSeparator().addSeparator().addTitle({"text":"Clients"}).end()
			.beginToolbar("tlbClientEdit", {dc:"client"}).addBack().addSave().addNew({autoEdit:"false",showView:"canvas3"}).addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Client"}).end()
			.beginToolbar("tlbClientCreate", {dc:"client"}).addBack().addSave().addNew({autoEdit:"false",showView:"canvas3"}).addCancel().addPrevRec().addNextRec().addReports().end(); 	
	}

});  
