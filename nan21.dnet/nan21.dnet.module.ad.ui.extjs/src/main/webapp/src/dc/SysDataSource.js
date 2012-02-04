   

Ext.define("net.nan21.dnet.module.ad.system.dc.SysDataSource", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysDataSourceDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.SysDataSourceDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysDataSourceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.system.dc.SysDataSource$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.system.dc.SysDataSource$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"model", dataIndex:"model",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"isAsgn", dataIndex:"isAsgn",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["name","model","isAsgn"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.system.dc.SysDataSource$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.system.dc.SysDataSource$List",
	
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name", width:200 })   	
		.addTextColumn({ name:"model", dataIndex:"model", width:350 })   	
		.addBooleanColumn({ name:"isAsgn", dataIndex:"isAsgn"})   	     
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true,width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 