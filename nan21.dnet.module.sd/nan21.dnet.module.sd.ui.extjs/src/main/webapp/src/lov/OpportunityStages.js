
Ext.define("net.nan21.dnet.module.sd.opportunity.lovs.OpportunityStages", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.sd.opportunity.lovs.OpportunityStages",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.sd.opportunity.frame.OpportunityBaseData_UI",bundle:"nan21.dnet.module.sd.ui.extjs",tocElement: "canvasStage"},
	recordModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityStageLovDs",
	_dataProviderName_:"OpportunityStageLovDs"	 		
	
}); 
 
