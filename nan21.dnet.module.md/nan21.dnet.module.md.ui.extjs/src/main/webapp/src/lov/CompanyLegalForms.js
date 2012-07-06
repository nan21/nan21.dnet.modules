
Ext.define("net.nan21.dnet.module.md.bp.lovs.CompanyLegalForms", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.bp.lovs.CompanyLegalForms",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.bp.frame.BP_BaseData_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasLegalForm"},
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.CompanyLegalFormLovDs",
	_dataProviderName_:"CompanyLegalFormLovDs"	 		
	
}); 
 
