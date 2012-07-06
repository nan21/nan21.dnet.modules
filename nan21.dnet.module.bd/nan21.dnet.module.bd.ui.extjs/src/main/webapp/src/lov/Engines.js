
Ext.define("net.nan21.dnet.module.bd.elem.lovs.Engines", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.elem.lovs.Engines",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.elem.frame.ElementBaseData_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasEngine"},
	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.EngineLovDs",
	_dataProviderName_:"EngineLovDs"	 		
	
}); 
 
