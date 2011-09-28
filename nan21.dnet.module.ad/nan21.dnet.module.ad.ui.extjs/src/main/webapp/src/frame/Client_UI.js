Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/ClientDs", "nan21.dnet.module.ad.ui.extjs/dc/Client"]);

Ext.define("net.nan21.dnet.module.ad.client.frame.Client_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.client.frame.Client_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.client.frame.Client_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("client", new net.nan21.dnet.module.ad.client.dc.Client())		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFormView("client",{ name:"clientEdit", xtype:"net.nan21.dnet.module.ad.client.dc.Client$Edit"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["clientEdit"] ,["center"])	
	 	.addToolbarTo("canvas1","clientEditTlb")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("clientEditTlb", {dc:"client"}).addSave().addCancel().addSeparator().addSeparator().addTitle({"text":"Editor"}).end(); 	
	}

	,loadCurrentClient: function() {	
		
  		var client = this._getDc_('client');
		client.getFilter().set('id',getApplication().getSession().getClientId());
		client.doQuery();
	}
	,_afterDefineDcs_: function() {	
		this.loadCurrentClient();
	}
});  
