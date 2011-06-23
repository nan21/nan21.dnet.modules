   
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.WfProcessInstance = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"WfProcessInstance" 		 
			,ds: new net.nan21.dnet.module.ad.workflow.ds.WfProcessInstanceDs()			  
		});
	 	net.nan21.dnet.module.ad.workflow.dc.WfProcessInstance.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc'); 
net.nan21.dnet.module.ad.workflow.dc.WfProcessInstance$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20",maxLength:255  })
		.addLov({ name:"process", xtype:"net.nan21.dnet.module.ad.workflow.lovs.WfProcesses", dataIndex:"process",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "processId"} ]  })
		.addTextField({ name:"startedBy", dataIndex:"startedBy",anchor:"-20",maxLength:32  })
		.addDateField({ name:"startTime", dataIndex:"startTime",width:100 ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"endTime", dataIndex:"endTime",width:100 ,format:Ext.DATE_FORMAT })
		//containers
		.addPanel({ name:"col1", layout:"form", width:300,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col3", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		; 
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["process"])
		.addChildrenTo("col2",["startTime","endTime"])
		.addChildrenTo("col3",["startedBy","id"])
;
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfProcessInstance$Filter", net.nan21.dnet.module.ad.workflow.dc.WfProcessInstance$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 	 
net.nan21.dnet.module.ad.workflow.dc.WfProcessInstance$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"id", dataIndex:"id", hidden:true,width:200 })   	
		.addTextColumn({ name:"process", dataIndex:"process",width:200 })   	
		.addTextColumn({ name:"processInstanceId", dataIndex:"processInstanceId", hidden:true,width:200 })   	
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"endTime", dataIndex:"endTime",format:Ext.DATETIME_FORMAT})   	      	     
		.addNumberColumn({ name:"duration", dataIndex:"duration",format:"0",width:70 })  
		.addTextColumn({ name:"startedBy", dataIndex:"startedBy",width:100 })   	
		.addTextColumn({ name:"startAction", dataIndex:"startAction", width:100 })   	
		.addTextColumn({ name:"endAction", dataIndex:"endAction", width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfProcessInstance$List", net.nan21.dnet.module.ad.workflow.dc.WfProcessInstance$List ); 
