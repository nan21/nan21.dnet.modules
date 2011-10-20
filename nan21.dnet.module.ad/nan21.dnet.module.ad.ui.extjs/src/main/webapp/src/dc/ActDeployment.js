   

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActDeployment", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentDs",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActDeploymentDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActDeployment$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.ActDeployment$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addDateField({ name:"from", paramIndex:"from",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"to", paramIndex:"to",anchor:"-20" ,format:Ext.DATE_FORMAT })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name"])
		.addChildrenTo("col2",["from","to"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActDeployment$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.workflow.dc.ActDeployment$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"id", dataIndex:"id", hidden:true,width:200 })   	
		.addTextColumn({ name:"name", dataIndex:"name", width:300 })   	
		.addDateColumn({ name:"deployTime", dataIndex:"deployTime", width:150,format:Ext.DATETIME_FORMAT})   	      	     
	  ;		   
	}
});
 
