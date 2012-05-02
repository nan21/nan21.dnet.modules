
Ext.define("net.nan21.dnet.module.md.bp.lovs.CustomerGroup", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.bp.lovs.CustomerGroup",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.bp.frame.BP_BaseData_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasCustGroup"},
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.CustomerGroupLovDs",
	_dataProviderName_:"CustomerGroupLovDs"	 		
	
}); 
 
