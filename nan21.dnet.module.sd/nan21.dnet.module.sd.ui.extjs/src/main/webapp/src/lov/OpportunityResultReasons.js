
Ext.define("net.nan21.dnet.module.sd.opportunity.lovs.OpportunityResultReasons", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.sd.opportunity.lovs.OpportunityResultReasons",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.sd.opportunity.frame.OpportunityBaseData_UI",bundle:"nan21.dnet.module.sd.ui.extjs",tocElement: "canvasResult"},
	recordModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityResultReasonLovDs",
	_dataProviderName_:"OpportunityResultReasonLovDs"	 		
	
}); 
 
