
Ext.define("net.nan21.dnet.module.sd.opportunity.lovs.OpportunityPriorities", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.sd.opportunity.lovs.OpportunityPriorities",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.sd.opportunity.frame.OpportunityBaseData_UI",bundle:"nan21.dnet.module.sd.ui.extjs",tocElement: "canvasPriority"},
	recordModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityPriorityLovDs",
	_dataProviderName_:"OpportunityPriorityLovDs"	 		
	
}); 
 
