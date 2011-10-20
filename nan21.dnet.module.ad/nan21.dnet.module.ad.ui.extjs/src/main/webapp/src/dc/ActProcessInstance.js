   

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDs",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActProcessInstanceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20",maxLength:255  })
		.addLov({ name:"process", xtype:"net.nan21.dnet.module.ad.workflow.lovs.ActProcessDefinitions", dataIndex:"process",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "processId"} ]  })
		.addTextField({ name:"startedBy", dataIndex:"startedBy",anchor:"-20",maxLength:32  })
		.addDateField({ name:"from", paramIndex:"from",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"to", paramIndex:"to",anchor:"-20" ,format:Ext.DATE_FORMAT })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:300,labelWidth:0 })
		.addPanel({ name:"col2", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"col3", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["process"])
		.addChildrenTo("col2",["from","to"])
		.addChildrenTo("col3",["startedBy","id"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance$List",
	
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"id", dataIndex:"id", hidden:true,width:200 })   	
		.addTextColumn({ name:"process", dataIndex:"process",width:200 })   	
		.addTextColumn({ name:"processInstanceId", dataIndex:"processInstanceId", hidden:true,width:200 })   	
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"startedBy", dataIndex:"startedBy",width:100 })   	
		.addTextColumn({ name:"startAction", dataIndex:"startAction", width:100 })   	
	  ;		   
	}
});
 
