
Ext.define("net.nan21.dnet.module.hr.grade.lovs.PayScalePoints", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.grade.lovs.PayScalePoints",
 
	displayField:"id",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	
	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScalePointLovDs",
	_dataProviderName_:"PayScalePointLovDs"	 		
	
}); 
 
