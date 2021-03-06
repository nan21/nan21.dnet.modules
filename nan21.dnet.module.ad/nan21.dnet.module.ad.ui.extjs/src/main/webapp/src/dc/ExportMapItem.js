   

Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportMapItem", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ExportMapItemDs",
	filterModel: "net.nan21.dnet.module.ad.impex.ds.model.ExportMapItemDsFilter",
	paramModel: "net.nan21.dnet.module.ad.impex.ds.param.ExportMapItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportMapItem$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ExportMapItem$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"exportMap", dataIndex:"exportMap",anchor:"-20",maxLength:255  })
		.addTextField({ name:"csvExport", dataIndex:"csvExport",anchor:"-20",maxLength:255  })
		.addTextField({ name:"fileName", dataIndex:"fileName",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["exportMap","csvExport"])
		.addChildrenTo("col2",["active"])
    	.addAuditFilter()	
	}
}); 
 	
 	

Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportMapItem$FilterCtx", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
 	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ExportMapItem$FilterCtx",
	_defineElements_: function () {	
		this._getBuilder_()	
		.addTextField({ name:"csvExport", dataIndex:"csvExport",maxLength:255  })
		.addTextField({ name:"fileName", dataIndex:"fileName",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		 
		
	}
	
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportMapItem$EditListCtxExpMap", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ExportMapItem$EditListCtxExpMap",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"exportMap", dataIndex:"exportMap", hidden:true,width:120 })
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({name:"csvExport", xtype:"gridcolumn", dataIndex:"csvExport",width:120,editor:{xtype:"net.nan21.dnet.module.ad.impex.lovs.CsvExports" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "csvExportId"} ]} })
		.addTextColumn({ name:"path", dataIndex:"path", width:150,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"fileName", dataIndex:"fileName", width:150,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"csvExportId", dataIndex:"csvExportId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportMapItem$EditListCtxCsvExp", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ExportMapItem$EditListCtxCsvExp",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"csvExport", dataIndex:"csvExport", hidden:true,width:120 })
		.addLov({name:"exportMap", xtype:"gridcolumn", dataIndex:"exportMap",width:120,editor:{xtype:"net.nan21.dnet.module.ad.impex.lovs.ExportMaps" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "exportMapId"} ]} })
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextColumn({ name:"path", dataIndex:"path", width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"fileName", dataIndex:"fileName", width:150,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"csvExportId", dataIndex:"csvExportId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
