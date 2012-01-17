
Ext.define("net.nan21.dnet.module.bp.base.lovs.VendorGroup", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bp.base.lovs.VendorGroup",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI",bundle:"nan21.dnet.module.bp.ui.extjs",tocElement: "canvasVendGroup"},
	recordModel: "net.nan21.dnet.module.bp.base.ds.model.VendorGroupLovDs",
	_dataProviderName_:"VendorGroupLovDs"	 		
	
}); 
 
