   

Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportMapItem", {
	extend: "dnet.base.AbstractDc",
 
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
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ExportMapItem$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"exportMap", dataIndex:"exportMap",anchor:"-20",maxLength:255  })
		.addTextField({ name:"csvExport", dataIndex:"csvExport",anchor:"-20",maxLength:255  })
		.addTextField({ name:"fileName", dataIndex:"fileName",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["exportMap","csvExport"])
		.addChildrenTo("col2",["active"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.ad.impex.dc.ExportMapItem$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ExportMapItem$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"exportMap", dataIndex:"exportMap", hidden:true,width:120 })
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",format:Ext.NUMBER_FORMAT_INT,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addLov({name:"csvExport", xtype:"gridcolumn", dataIndex:"csvExport",width:120,editor:{xtype:"net.nan21.dnet.module.ad.impex.lovs.CsvExports" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "csvExportId"} ]} })
		.addTextColumn({ name:"fileName", dataIndex:"fileName", width:300,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"csvExportId", dataIndex:"csvExportId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
