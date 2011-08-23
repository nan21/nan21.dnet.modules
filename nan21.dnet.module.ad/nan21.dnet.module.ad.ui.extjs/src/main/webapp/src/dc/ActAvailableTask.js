   
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"ActAvailableTask" 		 
			,ds: new net.nan21.dnet.module.ad.workflow.ds.ActAvailableTaskDs()			  
		});
	 	net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc'); 
net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["name"])
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$Filter", net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 	 
net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"id", dataIndex:"id", hidden:true,width:200 })   	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Ext.DATETIME_FORMAT})   	      	     
		.addNumberColumn({ name:"priority", dataIndex:"priority", hidden:true,format:Ext.NUMBER_FORMAT_INT })  
		.addDateColumn({ name:"dueDate", dataIndex:"dueDate",format:Ext.DATETIME_FORMAT})   	      	     
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$List", net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$List ); 
