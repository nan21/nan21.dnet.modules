   

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActAvailableTaskDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActAvailableTaskDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActAvailableTaskDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["name"])
    		
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.workflow.dc.ActAvailableTask$List",
	
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addNumberColumn({ name:"priority", dataIndex:"priority", hidden:true })  
		.addDateColumn({ name:"dueDate", dataIndex:"dueDate",format:Dnet.DATETIME_FORMAT})   	      	     
	  	.addDefaults()
	  ;		   
	}
});
 
