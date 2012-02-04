   

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActProcessDefinitionDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20",maxLength:255  })
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"category", dataIndex:"category",anchor:"-20",maxLength:255  })
		.addTextField({ name:"resourceName", dataIndex:"resourceName",anchor:"-20",maxLength:255  })
		.addLov({ name:"deployment", xtype:"net.nan21.dnet.module.ad.workflow.lovs.ActDeployments", paramIndex:"deployment",anchor:"-20",retFieldMapping: [{lovField:"id", dsField: "deploymentId"} ,{lovField:"fullName", dsParam: "deployment"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form", width:280}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name"])
		.addChildrenTo("col2",["category","resourceName"])
		.addChildrenTo("col3",["deployment"])
    		
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition$List",
	
	 _noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name", width:200 })   	
		.addTextColumn({ name:"category", dataIndex:"category",width:200 })   	
		.addTextColumn({ name:"resourceName", dataIndex:"resourceName", width:200 })   	
		.addTextColumn({ name:"diagramResourceName", dataIndex:"diagramResourceName", hidden:true, width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
