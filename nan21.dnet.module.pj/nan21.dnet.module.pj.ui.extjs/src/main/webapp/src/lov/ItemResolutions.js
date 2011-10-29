
Ext.define("net.nan21.dnet.module.pj.base.lovs.ItemResolutions", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.base.lovs.ItemResolutions",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.ItemBaseData_UI",bundle:"nan21.dnet.module.pj.ui.extjs",tocElement: "canvasResolution"},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.ItemResolutionLovDs",
	_dataProviderName_:"ItemResolutionLovDs"	 		
	
}); 
 
