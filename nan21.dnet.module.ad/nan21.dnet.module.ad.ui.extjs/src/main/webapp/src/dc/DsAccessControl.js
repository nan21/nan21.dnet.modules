   

Ext.define("net.nan21.dnet.module.ad.usr.dc.DsAccessControl", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.DsAccessControlDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.DsAccessControl$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.usr.dc.DsAccessControl$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"dsName", xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSourceDs", dataIndex:"dsName",anchor:"-20",maxLength:255,retFieldMapping: []  })
		.addLov({ name:"accessControl", xtype:"net.nan21.dnet.module.ad.usr.lovs.AccessControls", dataIndex:"accessControl",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accessControlId"} ]  })
		.addBooleanField({ name:"queryAllowed", dataIndex:"queryAllowed",anchor:"-20"  })
		.addBooleanField({ name:"insertAllowed", dataIndex:"insertAllowed",anchor:"-20"  })
		.addBooleanField({ name:"updateAllowed", dataIndex:"updateAllowed",anchor:"-20"  })
		.addBooleanField({ name:"deleteAllowed", dataIndex:"deleteAllowed",anchor:"-20"  })
		.addBooleanField({ name:"importAllowed", dataIndex:"importAllowed",anchor:"-20"  })
		.addBooleanField({ name:"exportAllowed", dataIndex:"exportAllowed",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form", width:180}) 
		.addPanel({ name:"col3", layout:"form", width:180}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["accessControl","dsName"])
		.addChildrenTo("col2",["queryAllowed","importAllowed","exportAllowed"])
		.addChildrenTo("col3",["insertAllowed","updateAllowed","deleteAllowed"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.ad.usr.dc.DsAccessControl$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.DsAccessControl$EditList",
	
	_bulkEditFields_ : ["queryAllowed","insertAllowed","updateAllowed","deleteAllowed","importAllowed","exportAllowed"],
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accessControl", xtype:"gridcolumn", dataIndex:"accessControl",width:120,editor:{xtype:"net.nan21.dnet.module.ad.usr.lovs.AccessControls" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accessControlId"} ]} })
		.addLov({name:"dsName", xtype:"gridcolumn", dataIndex:"dsName",width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSourceDs" , selectOnFocus:true ,maxLength:255,retFieldMapping: []} })
		.addBooleanColumn({ name:"queryAllowed", dataIndex:"queryAllowed"})
		.addBooleanColumn({ name:"insertAllowed", dataIndex:"insertAllowed"})
		.addBooleanColumn({ name:"updateAllowed", dataIndex:"updateAllowed"})
		.addBooleanColumn({ name:"deleteAllowed", dataIndex:"deleteAllowed"})
		.addBooleanColumn({ name:"importAllowed", dataIndex:"importAllowed"})
		.addBooleanColumn({ name:"exportAllowed", dataIndex:"exportAllowed"})
		.addNumberColumn({ name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.ad.usr.dc.DsAccessControl$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.DsAccessControl$CtxEditList",
	
	_noImport_: true,
	_noExport_: true,
	_bulkEditFields_ : ["queryAllowed","insertAllowed","updateAllowed","deleteAllowed","importAllowed","exportAllowed"],
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"dsName", xtype:"gridcolumn", dataIndex:"dsName",width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSourceDs" , selectOnFocus:true ,maxLength:255,retFieldMapping: []} })
		.addBooleanColumn({ name:"queryAllowed", dataIndex:"queryAllowed"})
		.addBooleanColumn({ name:"insertAllowed", dataIndex:"insertAllowed"})
		.addBooleanColumn({ name:"updateAllowed", dataIndex:"updateAllowed"})
		.addBooleanColumn({ name:"deleteAllowed", dataIndex:"deleteAllowed"})
		.addBooleanColumn({ name:"importAllowed", dataIndex:"importAllowed"})
		.addBooleanColumn({ name:"exportAllowed", dataIndex:"exportAllowed"})
		.addNumberColumn({ name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
