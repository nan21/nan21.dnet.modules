   

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceHistoryDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceHistoryDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActTaskInstanceHistoryDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$Filter",
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
		.addPanel({ name:"main", layout:"form", autoScroll:true,width:210}) 
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["id","processDefinitionId","taskDefinitionKey","processInstanceId","executionId","name","description","assignee"])
    		
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$List",
	
	_noImport_: true,
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"processDefinitionId", dataIndex:"processDefinitionId", hidden:true,width:200 })   	
		.addTextColumn({ name:"taskDefinitionKey", dataIndex:"taskDefinitionKey", hidden:true,width:200 })   	
		.addTextColumn({ name:"processInstanceId", dataIndex:"processInstanceId", hidden:true,width:200 })   	
		.addTextColumn({ name:"executionId", dataIndex:"executionId", hidden:true,width:200 })   	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
		.addTextColumn({ name:"assignee", dataIndex:"assignee",width:100 })   	
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addNumberColumn({ name:"priority", dataIndex:"priority", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"dueDate", dataIndex:"dueDate", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
	  	.addDefaults()
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$AssignForm", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$AssignForm",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"assignee", dataIndex:"assignee",anchor:"-20" ,maxLength:32  })
		//containers
		.addPanel({ name:"main", layout:"form" , autoScroll:true})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["assignee"])
;
	}	
});
