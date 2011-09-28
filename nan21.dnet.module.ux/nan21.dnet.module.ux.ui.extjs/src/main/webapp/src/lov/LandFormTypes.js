
Ext.define("net.nan21.dnet.module.ux.example.lovs.LandFormTypes", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ux.example.lovs.LandFormTypes",
	
	queryMode: "remote",
	displayField:"name",
	triggerAction :"query",
	pageSize:30,
	autoSelect:true,
	listConfig: {
		width:250
	},	
	tpl: '<tpl for="."><div class="x-combo-list-item"><div style="">{name}</div></div></tpl>',
	minChars:0,
	recordModel: "net.nan21.dnet.module.ux.example.ds.model.LandFormTypeLovDs",
	_dataProviderName_:"LandFormTypeLovDs",		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.geo.frame.CountryMD_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	 		
	initComponent : function(){		 	
		this._createStore_(); 
        this.callParent(arguments);	
	}	 
}); 
 
