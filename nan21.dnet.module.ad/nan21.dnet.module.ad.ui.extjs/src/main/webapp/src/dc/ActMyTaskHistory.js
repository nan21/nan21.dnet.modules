   

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActMyTaskHistory", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskHistoryDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskHistoryDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActMyTaskHistoryDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActMyTaskHistory$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.ActMyTaskHistory$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"deleteReason", dataIndex:"deleteReason", width:100,maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["name"])
    		
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActMyTaskHistory$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.workflow.dc.ActMyTaskHistory$List",
	
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"id", dataIndex:"id", hidden:true,width:200 })   	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"endTime", dataIndex:"endTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addNumberColumn({ name:"priority", dataIndex:"priority", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"dueDate", dataIndex:"dueDate",format:Dnet.DATETIME_FORMAT})   	      	     
	  ;		   
	}
});
 
