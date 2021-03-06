   

Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs",
	filterModel: "net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDsFilter",
	paramModel: "net.nan21.dnet.module.ad.impex.ds.param.ImportMapItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
 	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx$Filter",
	_defineElements_: function () {	
		this._getBuilder_()	
		.addLov({ name:"dataSource", dataIndex:"dataSource",editor:{ xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSource", selectOnFocus:true,retFieldMapping: []}  })
		.addTextField({ name:"fileName", dataIndex:"fileName",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		 
		
	}
	
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ImportMapItemCtx$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({name:"dataSource", xtype:"gridcolumn", dataIndex:"dataSource",width:150,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSource" , selectOnFocus:true ,maxLength:255,retFieldMapping: []} })
		.addTextColumn({ name:"path", dataIndex:"path", width:150,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"fileName", dataIndex:"fileName", width:300,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"ukFieldName", dataIndex:"ukFieldName",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
