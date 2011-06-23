   
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.WfProcess = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"WfProcess" 		 
			,ds: new net.nan21.dnet.module.ad.workflow.ds.WfProcessDs()			  
		});
	 	net.nan21.dnet.module.ad.workflow.dc.WfProcess.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc'); 
net.nan21.dnet.module.ad.workflow.dc.WfProcess$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:255  })
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"category", dataIndex:"category",anchor:"-20",maxLength:255  })
		.addTextField({ name:"resourceName", dataIndex:"resourceName",anchor:"-20",maxLength:255  })
		.addLov({ name:"deployment", xtype:"net.nan21.dnet.module.ad.workflow.lovs.WfDeployments", dataIndex:"deployment",anchor:"-20",retFieldMapping: [{lovField:"id", dsField: "deploymentId"} ,{lovField:"fullName", dsParam: "deployment"} ],listeners: {change: {scope:this, fn:function(f,nv,ov) {this._controller_.setParamValue("deployment", nv);} }}  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col3", layout:"form", width:280,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		; 
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["code","name"])
		.addChildrenTo("col2",["category","resourceName"])
		.addChildrenTo("col3",["deployment"])
;
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfProcess$Filter", net.nan21.dnet.module.ad.workflow.dc.WfProcess$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 	 
net.nan21.dnet.module.ad.workflow.dc.WfProcess$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"id", dataIndex:"id", hidden:true,width:200 })   	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addNumberColumn({ name:"version", dataIndex:"version",format:"0",width:70 })  
		.addTextColumn({ name:"code", dataIndex:"code",width:200 })   	
		.addTextColumn({ name:"category", dataIndex:"category",width:200 })   	
		.addTextColumn({ name:"resourceName", dataIndex:"resourceName",width:100 })   	
		.addTextColumn({ name:"diagramResourceName", dataIndex:"diagramResourceName", hidden:true,width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.WfProcess$List", net.nan21.dnet.module.ad.workflow.dc.WfProcess$List ); 
