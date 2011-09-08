Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/ReportServerDs", "nan21.dnet.module.ad.ui.extjs/dc/ReportServer"]);

Ext.ns("net.nan21.dnet.module.ad.report.frame");
net.nan21.dnet.module.ad.report.frame.ReportServers_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.report.frame.ReportServers_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.ad.report.dc.ReportServer())		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("m",{ name:"mFilter", xtype:"net.nan21.dnet.module.ad.report.dc.ReportServer$Filter"})	 
		.addDcView("m",{ name:"mEditList", xtype:"net.nan21.dnet.module.ad.report.dc.ReportServer$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["mFilter","mEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbMEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMEditList", {dc:"m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Edit list"}).end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.ad.report.frame.ReportServers_UI", net.nan21.dnet.module.ad.report.frame.ReportServers_UI);   
