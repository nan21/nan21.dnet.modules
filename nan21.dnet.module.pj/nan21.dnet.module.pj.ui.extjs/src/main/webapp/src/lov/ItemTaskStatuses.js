
Ext.define("net.nan21.dnet.module.pj.base.lovs.ItemTaskStatuses", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.base.lovs.ItemTaskStatuses",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.ItemBaseData_UI",bundle:"nan21.dnet.module.pj.ui.extjs",tocElement: "canvasTaskstatus"},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.ItemTaskStatusLovDs",
	_dataProviderName_:"ItemTaskStatusLovDs"	 		
	
}); 
 