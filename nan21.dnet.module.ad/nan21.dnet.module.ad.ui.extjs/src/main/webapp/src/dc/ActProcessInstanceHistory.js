   

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceHistoryDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceHistoryDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActProcessInstanceHistoryDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20",maxLength:64  })
		.addLov({ name:"processFullName", xtype:"net.nan21.dnet.module.ad.workflow.lovs.ActProcessDefinitions", paramIndex:"processFullName",anchor:"-20",retFieldMapping: [{lovField:"id", dsField: "processId"} ]  })
		.addTextField({ name:"startedBy", dataIndex:"startedBy",anchor:"-20",maxLength:32  })
		.addDateField({ name:"startTime", dataIndex:"startTime",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"endTime", dataIndex:"endTime",anchor:"-20" ,format:Ext.DATE_FORMAT })
		//containers
		.addPanel({ name:"col1", layout:"form", width:300}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["processFullName"])
		.addChildrenTo("col2",["startTime","endTime"])
		.addChildrenTo("col3",["startedBy","id"])
    		
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory$List",
	
	_noImport_: true,
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"process", dataIndex:"process",width:200 })   	
		.addNumberColumn({ name:"processVersion", dataIndex:"processVersion" })  
		.addTextColumn({ name:"processInstanceId", dataIndex:"processInstanceId", hidden:true,width:150 })   	
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"endTime", dataIndex:"endTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"duration", dataIndex:"durationText",width:200 })   	
		.addNumberColumn({ name:"durationMili", dataIndex:"duration", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"startedBy", dataIndex:"startedBy",width:100 })   	
		.addTextColumn({ name:"startAction", dataIndex:"startAction", width:100 })   	
		.addTextColumn({ name:"endAction", dataIndex:"endAction", width:100 })   	
		.addTextColumn({ name:"deleteReason", dataIndex:"deleteReason", width:100 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
