   

Ext.define("net.nan21.dnet.module.pj.md.dc.Item", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ItemDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.ItemDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.ItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.Item$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.Item$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addNumberField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20"  })
		.addTextField({ name:"projectCode", dataIndex:"projectCode",anchor:"-20",maxLength:32  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemStatus", dataIndex:"status",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priority", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemPriorities", dataIndex:"priority",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"resolution", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemResolutions", dataIndex:"resolution",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "resolutionId"} ]  })
		.addLov({ name:"severity", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemSeverities", dataIndex:"severity",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "severityId"} ]  })
		.addTextField({ name:"assignee", dataIndex:"assignee",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor", width:250}) 
		.addPanel({ name:"col3", layout:"anchor", width:250}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["id","projectCode","assignee"])
		.addChildrenTo("col2",["type","status"])
		.addChildrenTo("col3",["priority","severity","resolution"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.pj.md.dc.Item$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.pj.md.dc.Item$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addNumberColumn({ name:"projectId", dataIndex:"projectId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"projectCode", dataIndex:"projectCode",width:100 })   	
		.addTextColumn({ name:"project", dataIndex:"project",width:200 })   	
		.addTextColumn({ name:"instanceType", dataIndex:"instanceType",width:60 })   	
		.addTextColumn({ name:"summary", dataIndex:"summary",width:200 })   	
		.addDateColumn({ name:"dueDate", dataIndex:"dueDate",format:Ext.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"resolutionDate", dataIndex:"resolutionDate",format:Ext.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"status", dataIndex:"status",width:120 })   	
		.addTextColumn({ name:"priority", dataIndex:"priority",width:120 })   	
		.addTextColumn({ name:"resolution", dataIndex:"resolution",width:120 })   	
		.addTextColumn({ name:"severity", dataIndex:"severity",width:120 })   	
		.addNumberColumn({ name:"assigneeId", dataIndex:"assigneeId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"assignee", dataIndex:"assignee",width:120 })   	
		.addNumberColumn({ name:"assigneeRoleId", dataIndex:"assigneeRoleId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"assigneeRole", dataIndex:"assigneeRole",width:120 })   	
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.Item$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.Item$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addNumberField({ name:"projectId", dataIndex:"projectId",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		.addTextField({ name:"projectCode", dataIndex:"projectCode",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		.addTextField({ name:"project", dataIndex:"project",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"summary", dataIndex:"summary",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addDateField({ name:"dueDate", dataIndex:"dueDate",anchor:"-20" })
		.addDateField({ name:"resolutionDate", dataIndex:"resolutionDate",anchor:"-20" })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemTypes", dataIndex:"type",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemStatus", dataIndex:"status",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priority", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemPriorities", dataIndex:"priority",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"resolution", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemResolutions", dataIndex:"resolution",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "resolutionId"} ]  })
		.addLov({ name:"severity", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemSeverities", dataIndex:"severity",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "severityId"} ]  })
		.addTextField({ name:"assignee", dataIndex:"assignee",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"assigneeRole", dataIndex:"assigneeRole",anchor:"-20" ,maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300})     
		.addPanel({ name:"col2", layout:"anchor" , width:300})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["projectCode","summary","dueDate","resolutionDate"])
		.addChildrenTo("col2",["type","status","priority","resolution","severity","assignee"])
;
	}	
});
