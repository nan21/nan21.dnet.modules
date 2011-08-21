   
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 
net.nan21.dnet.module.ad.workflow.dc.ActDeployment = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"ActDeployment" 		 
			,ds: new net.nan21.dnet.module.ad.workflow.ds.ActDeploymentDs()			  
		});
	 	net.nan21.dnet.module.ad.workflow.dc.ActDeployment.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc'); 
net.nan21.dnet.module.ad.workflow.dc.ActDeployment$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addDateField({ name:"from", dataIndex:"from",width:100,listeners: {change: {scope:this, fn:function(f,nv,ov) {this._controller_.setParamValue("from", nv);} }} ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"to", dataIndex:"to",width:100,listeners: {change: {scope:this, fn:function(f,nv,ov) {this._controller_.setParamValue("to", nv);} }} ,format:Ext.DATE_FORMAT })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		; 
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name"])
		.addChildrenTo("col2",["from","to"])
;
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.ActDeployment$Filter", net.nan21.dnet.module.ad.workflow.dc.ActDeployment$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.workflow.dc');	 	 
net.nan21.dnet.module.ad.workflow.dc.ActDeployment$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"id", dataIndex:"id", hidden:true,width:200 })   	
		.addTextColumn({ name:"name", dataIndex:"name", width:300 })   	
		.addDateColumn({ name:"deployTime", dataIndex:"deployTime", width:150,format:Ext.DATETIME_FORMAT})   	      	     
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.workflow.dc.ActDeployment$List", net.nan21.dnet.module.ad.workflow.dc.ActDeployment$List ); 
