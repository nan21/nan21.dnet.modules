
Ext.define("net.nan21.dnet.module.sd.opportunity.lovs.OpportunitySources", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.sd.opportunity.lovs.OpportunitySources",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.sd.opportunity.frame.OpportunityBaseData_UI",bundle:"nan21.dnet.module.sd.ui.extjs",tocElement: "canvasSource"},
	recordModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunitySourceLovDs",
	_dataProviderName_:"OpportunitySourceLovDs"	 		
	
}); 
 
