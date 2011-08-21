   
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"ActTaskInstance" 		 
			,ds: new net.nan21.dnet.module.ad.workflow.ds.ActTaskInstanceDs()			  
		});
	 	net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc'); 
net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addCheckbox({ name:"showActive" ,dataIndex:"showActive", _isParam_:true ,listeners:{check:{scope:this, fn:this._doQuery_}} })
		.addCheckbox({ name:"showCompleted" ,dataIndex:"showCompleted", _isParam_:true ,listeners:{check:{scope:this, fn:this._doQuery_}} })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelAlign:"right",labelWidth:150 })
		.addPanel({ name:"col2", layout:"form",width:210,labelAlign:"right",labelWidth:150 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["showActive"])
		.addChildrenTo("col2",["showCompleted"])
	}
	,_doQuery_: function() {	
		this._controller_.doQuery();//.defer(200,this._controller_);
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$Filter", net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 	 
net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$List = Ext.extend(dnet.base.AbstractDcvGrid, {
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
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"endTime", dataIndex:"endTime",format:Ext.DATETIME_FORMAT})   	      	     
		.addNumberColumn({ name:"priority", dataIndex:"priority", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"dueDate", dataIndex:"dueDate", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$List", net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$List ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$AssignForm = Ext.extend(dnet.base.AbstractDcvForm, {
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
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$AssignForm", net.nan21.dnet.module.ad.workflow.dc.ActTaskInstance$AssignForm ); 
