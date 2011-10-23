
Ext.define("net.nan21.dnet.module.bp.base.lovs.CompanyLegalForms", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bp.base.lovs.CompanyLegalForms",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI",bundle:"nan21.dnet.module.bp.ui.extjs",tocElement: "canvasLegalForm"},
	recordModel: "net.nan21.dnet.module.bp.base.ds.model.CompanyLegalFormLovDs",
	_dataProviderName_:"CompanyLegalFormLovDs"	 		
	
}); 
 
