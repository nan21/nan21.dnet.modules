
Ext.define("net.nan21.dnet.module.bp.base.lovs.CustomerGroup", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bp.base.lovs.CustomerGroup",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI",bundle:"nan21.dnet.module.bp.ui.extjs",tocElement: "canvasCustGroup"},
	recordModel: "net.nan21.dnet.module.bp.base.ds.model.CustomerGroupLovDs",
	_dataProviderName_:"CustomerGroupLovDs"	 		
	
}); 
 
