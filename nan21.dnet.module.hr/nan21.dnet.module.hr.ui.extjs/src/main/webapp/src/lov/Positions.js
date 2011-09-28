
Ext.define("net.nan21.dnet.module.hr.job.lovs.Positions", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.job.lovs.Positions",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.job.frame.Position_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.PositionLovDs",
	_dataProviderName_:"PositionLovDs"	 		
	
}); 
 
