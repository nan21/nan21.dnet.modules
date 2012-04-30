   

Ext.define("net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.DsMethodAccessControlDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.DsMethodAccessControlDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.DsMethodAccessControlDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"dsName", xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSourceDs", dataIndex:"dsName",anchor:"-20",maxLength:255,retFieldMapping: []  })
		.addLov({ name:"accessControl", xtype:"net.nan21.dnet.module.ad.usr.lovs.AccessControls", dataIndex:"accessControl",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accessControlId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["accessControl","dsName"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accessControl", xtype:"gridcolumn", dataIndex:"accessControl",width:120,editor:{xtype:"net.nan21.dnet.module.ad.usr.lovs.AccessControls" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accessControlId"} ]} })
		.addLov({name:"dsName", xtype:"gridcolumn", dataIndex:"dsName",width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSourceDs" , selectOnFocus:true ,maxLength:255,retFieldMapping: []} })
		.addLov({name:"serviceMethod", xtype:"gridcolumn", dataIndex:"serviceMethod",width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDsServices" , selectOnFocus:true ,maxLength:255,retFieldMapping: [],filterFieldMapping: [{lovField:"dataSourceName", dsField: "dsName"} ]} })
		.addNumberColumn({ name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl$CtxEditList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"dsName", xtype:"gridcolumn", dataIndex:"dsName",width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSourceDs" , selectOnFocus:true ,maxLength:255,retFieldMapping: []} })
		.addLov({name:"serviceMethod", xtype:"gridcolumn", dataIndex:"serviceMethod",width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDsServices" , selectOnFocus:true ,maxLength:255,retFieldMapping: [],filterFieldMapping: [{lovField:"dataSourceName", dsField: "dsName"} ]} })
		.addNumberColumn({ name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
