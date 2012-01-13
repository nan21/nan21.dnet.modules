   

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory", {
	extend: "dnet.base.AbstractDc",
 
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
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20",maxLength:255  })
		.addLov({ name:"processFullName", xtype:"net.nan21.dnet.module.ad.workflow.lovs.ActProcessDefinitions", paramIndex:"processFullName",anchor:"-20",retFieldMapping: [{lovField:"id", dsField: "processId"} ]  })
		.addTextField({ name:"startedBy", dataIndex:"startedBy",anchor:"-20",maxLength:32  })
		.addDateField({ name:"startTime", dataIndex:"startTime",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"endTime", dataIndex:"endTime",anchor:"-20" ,format:Ext.DATE_FORMAT })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:300}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"col3", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
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
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory$List",
	
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"id", dataIndex:"id", hidden:true,width:200 })   	
		.addTextColumn({ name:"process", dataIndex:"process",width:200 })   	
		.addNumberColumn({ name:"processVersion", dataIndex:"processVersion",format:"0",width:70 })  
		.addTextColumn({ name:"processInstanceId", dataIndex:"processInstanceId", hidden:true,width:200 })   	
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"endTime", dataIndex:"endTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addNumberColumn({ name:"duration", dataIndex:"duration",format:"0",width:70 })  
		.addTextColumn({ name:"startedBy", dataIndex:"startedBy",width:100 })   	
		.addTextColumn({ name:"startAction", dataIndex:"startAction", width:100 })   	
		.addTextColumn({ name:"endAction", dataIndex:"endAction", width:100 })   	
	  ;		   
	}
});
 
