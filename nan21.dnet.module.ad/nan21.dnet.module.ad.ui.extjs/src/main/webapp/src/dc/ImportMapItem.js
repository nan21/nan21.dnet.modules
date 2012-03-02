   

Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItem", {
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



 	

Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItem$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ImportMapItem$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"importMapName", xtype:"net.nan21.dnet.module.ad.impex.lovs.ImportMap", dataIndex:"importMapName",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "importMapId"} ]  })
		.addLov({ name:"dataSource", xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSource", dataIndex:"dataSource",anchor:"-20",maxLength:255,retFieldMapping: []  })
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
		.addChildrenTo("col1",["importMapName","dataSource","fileName"])
		.addChildrenTo("col2",["active"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItem$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ImportMapItem$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"importMapId", dataIndex:"importMapId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"importMapName", xtype:"gridcolumn", dataIndex:"importMapName",width:120,editor:{xtype:"net.nan21.dnet.module.ad.impex.lovs.ImportMap" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "importMapId"} ]} })
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({name:"dataSource", xtype:"gridcolumn", dataIndex:"dataSource",width:150,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSource" , selectOnFocus:true ,maxLength:255,retFieldMapping: []} })
		.addTextColumn({ name:"fileName", dataIndex:"fileName", width:300,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255} })
		.addTextColumn({ name:"ukFieldName", dataIndex:"ukFieldName",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	

Ext.define("net.nan21.dnet.module.ad.impex.dc.ImportMapItem$ImportFileForm", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.impex.dc.ImportMapItem$ImportFileForm",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"importDataSource", xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSource", paramIndex:"importDataSource",anchor:"-20",retFieldMapping: []  })
		.addTextField({ name:"importFileLocation", paramIndex:"importFileLocation",anchor:"-20"  })
		.addTextField({ name:"importUkFieldName", paramIndex:"importUkFieldName",anchor:"-20"  })
		//containers
		.addPanel({ name:"main", layout:"form", autoScroll:true, width:400, defaults:{
labelAlign:"right",labelWidth:140}}) 
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["importFileLocation","importDataSource","importUkFieldName"])
    		
	}
}); 
