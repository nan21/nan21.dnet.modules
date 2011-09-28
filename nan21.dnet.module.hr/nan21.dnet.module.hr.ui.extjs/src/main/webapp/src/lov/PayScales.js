
Ext.define("net.nan21.dnet.module.hr.grade.lovs.PayScales", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.grade.lovs.PayScales",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.grade.frame.PayScale_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScaleLovDs",
	_dataProviderName_:"PayScaleLovDs"	 		
	
}); 
 
