   

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActTaskInstanceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addCheckbox({ name:"hideActive" ,paramIndex:"hideActive" ,listeners:{change:{scope:this, fn:this._doQuery_}} })
		.addCheckbox({ name:"hideCompleted" ,paramIndex:"hideCompleted" ,listeners:{change:{scope:this, fn:this._doQuery_}} })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210, defaults:{
labelAlign:"right",labelWidth:150}}) 
		.addPanel({ name:"col2", layout:"anchor",width:210, defaults:{
labelAlign:"right",labelWidth:150}}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["hideActive"])
		.addChildrenTo("col2",["hideCompleted"])
    		
	}
	,_doQuery_: function() {	
		this._controller_.doQuery();
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$List",
	
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"id", dataIndex:"id", hidden:true,width:200 })   	
		.addTextColumn({ name:"processId", dataIndex:"processId", hidden:true,width:200 })   	
		.addTextColumn({ name:"taskKey", dataIndex:"taskKey",width:200 })   	
		.addTextColumn({ name:"processInstanceId", dataIndex:"processInstanceId", hidden:true,width:200 })   	
		.addTextColumn({ name:"executionId", dataIndex:"executionId", hidden:true,width:200 })   	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
		.addTextColumn({ name:"assignee", dataIndex:"assignee",width:100 })   	
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"endTime", dataIndex:"endTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addNumberColumn({ name:"priority", dataIndex:"priority", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"dueDate", dataIndex:"dueDate", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$AssignForm", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$AssignForm",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"assignee", dataIndex:"assignee",anchor:"-20" ,maxLength:32  })
		//containers
		.addPanel({ name:"main", layout:"anchor" , autoScroll:true,width:250})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["assignee"])
;
	}	
});
