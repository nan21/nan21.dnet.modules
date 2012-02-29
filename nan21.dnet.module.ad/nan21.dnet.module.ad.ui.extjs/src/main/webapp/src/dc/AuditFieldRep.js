   

Ext.define("net.nan21.dnet.module.ad.system.dc.AuditFieldRep", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.AuditFieldRepDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.AuditFieldRepDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.AuditFieldRepDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.system.dc.AuditFieldRep$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.system.dc.AuditFieldRep$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addCombo({ name:"operation", xtype:"combo", dataIndex:"operation",anchor:"-20",store:[ "insert", "update", "delete"]  })
		.addTextField({ name:"sourceFQN", dataIndex:"sourceFQN",anchor:"-20",maxLength:255  })
		.addTextField({ name:"sourceId", dataIndex:"sourceId",anchor:"-20",maxLength:255  })
		.addTextField({ name:"fieldName", dataIndex:"fieldName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"oldValue", dataIndex:"oldValue",anchor:"-20",maxLength:4000  })
		.addTextField({ name:"newValue", dataIndex:"newValue",anchor:"-20",maxLength:4000  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["sourceFQN","sourceId","operation"])
		.addChildrenTo("col2",["fieldName","oldValue","newValue"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.system.dc.AuditFieldRep$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.system.dc.AuditFieldRep$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"sourceFQN", dataIndex:"sourceFQN",width:150 })   	
		.addTextColumn({ name:"sourceId", dataIndex:"sourceId", width:80 })   	
		.addTextColumn({ name:"operation", dataIndex:"operation", width:80 })   	
		.addTextColumn({ name:"fieldName", dataIndex:"fieldName", width:100 })   	
		.addTextColumn({ name:"oldValue", dataIndex:"oldValue",width:200 })   	
		.addTextColumn({ name:"newValue", dataIndex:"newValue",width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
