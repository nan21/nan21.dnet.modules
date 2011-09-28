
Ext.define("net.nan21.dnet.module.ad.workflow.lovs.ActProcessDefinitions", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.workflow.lovs.ActProcessDefinitions",
 
	displayField:"fullName",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{fullName}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.workflow.frame.WorkflowAdmin_UI",bundle:"nan21.dnet.module.ad.ui.extjs",tocElement: "canvasProcess"},
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionLovDs",
	_dataProviderName_:"ActProcessDefinitionLovDs"	 		
	
}); 
 
