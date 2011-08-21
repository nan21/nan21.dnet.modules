   
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"ActTaskInstanceHistory" 		 
			,ds: new net.nan21.dnet.module.ad.workflow.ds.ActTaskInstanceHistoryDs()			  
		});
	 	net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc'); 
net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20",maxLength:255  })
		.addTextField({ name:"processDefinitionId", dataIndex:"processDefinitionId",anchor:"-20",maxLength:255  })
		.addTextField({ name:"taskDefinitionKey", dataIndex:"taskDefinitionKey",anchor:"-20",maxLength:255  })
		.addTextField({ name:"processInstanceId", dataIndex:"processInstanceId",anchor:"-20",maxLength:255  })
		.addTextField({ name:"executionId", dataIndex:"executionId",anchor:"-20",maxLength:255  })
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"description",_sharedLabel_:true, dataIndex:"description",anchor:"-20",maxLength:4000  })
		.addTextField({ name:"assignee", dataIndex:"assignee",anchor:"-20",maxLength:32  })
		//containers
		.addPanel({ name:"main", layout:"form", autoScroll:true,width:210,labelWidth:0 })
		; 
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["id","processDefinitionId","taskDefinitionKey","processInstanceId","executionId","name","description","assignee"])
;
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$Filter", net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 	 
net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"id", dataIndex:"id", hidden:true,width:200 })   	
		.addTextColumn({ name:"processDefinitionId", dataIndex:"processDefinitionId", hidden:true,width:200 })   	
		.addTextColumn({ name:"taskDefinitionKey", dataIndex:"taskDefinitionKey", hidden:true,width:200 })   	
		.addTextColumn({ name:"processInstanceId", dataIndex:"processInstanceId", hidden:true,width:200 })   	
		.addTextColumn({ name:"executionId", dataIndex:"executionId", hidden:true,width:200 })   	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
		.addTextColumn({ name:"assignee", dataIndex:"assignee",width:100 })   	
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Ext.DATETIME_FORMAT})   	      	     
		.addNumberColumn({ name:"priority", dataIndex:"priority", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"dueDate", dataIndex:"dueDate", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$List", net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$List ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$AssignForm = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"assignee", dataIndex:"assignee",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		//containers
		.addPanel({ name:"main", layout:"form" , autoScroll:true,width:250,labelWidth:0 })     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["assignee"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$AssignForm", net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$AssignForm ); 
