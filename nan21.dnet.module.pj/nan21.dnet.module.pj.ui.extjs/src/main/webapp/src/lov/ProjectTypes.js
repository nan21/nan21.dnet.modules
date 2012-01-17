
Ext.define("net.nan21.dnet.module.pj.base.lovs.ProjectTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.base.lovs.ProjectTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.ProjectBaseData_UI",bundle:"nan21.dnet.module.pj.ui.extjs",tocElement: "canvasType"},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.ProjectTypeLovDs",
	_dataProviderName_:"ProjectTypeLovDs"	 		
	
}); 
 
