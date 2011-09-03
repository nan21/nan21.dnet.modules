Dnet.import(["", "nan21.dnet.module.ux.ui.extjs/ds/LandFormTypeDs", "nan21.dnet.module.ux.ui.extjs/dc/LandFormType"]);

Ext.ns("net.nan21.dnet.module.ux.example.frame");
net.nan21.dnet.module.ux.example.frame.LandFormType_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ux.example.frame.LandFormType_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.ux.example.dc.LandFormType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcFilterFormView("m",{ name:"mFilter", xtype:"net.nan21.dnet.module.ux.example.dc.LandFormType$Filter"})	 
		.addDcView("m",{ name:"mEditList", xtype:"net.nan21.dnet.module.ux.example.dc.LandFormType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["mFilter","mEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbMEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMEditList", {dc:"m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.ux.example.frame.LandFormType_UI", net.nan21.dnet.module.ux.example.frame.LandFormType_UI);   
