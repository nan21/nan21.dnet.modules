
Ext.define("net.nan21.dnet.module.hr.skill.lovs.RatingScales", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.skill.lovs.RatingScales",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.skill.frame.RatingScale_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.RatingScaleLovDs",
	_dataProviderName_:"RatingScaleLovDs"	 		
	
}); 
 
