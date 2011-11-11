   

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
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addLov({ name:"project", xtype:"net.nan21.dnet.module.pj.md.lovs.Projects", dataIndex:"project",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "projectId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemStatus", dataIndex:"status",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priority", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemPriorities", dataIndex:"priority",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"resolution", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemResolutions", dataIndex:"resolution",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "resolutionId"} ]  })
		.addLov({ name:"severity", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemSeverities", dataIndex:"severity",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "severityId"} ]  })
		.addLov({ name:"assignee", xtype:"net.nan21.dnet.module.ad.usr.lovs.Assignables", dataIndex:"assignee",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assigneeId"} ]  })
		.addLov({ name:"reportedVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"reportedVersion",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "reportedVersionId"} ]  })
		.addLov({ name:"targetVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"targetVersion",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "targetVersionId"} ]  })
		.addLov({ name:"fixedInVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"fixedInVersion",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fixedInVersionId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor", width:250}) 
		.addPanel({ name:"col4", layout:"anchor", width:250}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col4"])
		.addChildrenTo("col1",["id","code","project","type","assignee"])
		.addChildrenTo("col2",["severity","priority","status","resolution"])
		.addChildrenTo("col4",["reportedVersion","targetVersion","fixedInVersion"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.pj.md.dc.Item$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.pj.md.dc.Item$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"project", dataIndex:"project",width:100 })   	
		.addTextColumn({ name:"projectName", dataIndex:"projectName", hidden:true,width:200 })   	
		.addTextColumn({ name:"summary", dataIndex:"summary",width:200 })   	
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true,width:200 })   	
		.addDateColumn({ name:"dueDate", dataIndex:"dueDate",format:Ext.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"resolutionDate", dataIndex:"resolutionDate", hidden:true,format:Ext.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"status", dataIndex:"status",width:120 })   	
		.addTextColumn({ name:"priority", dataIndex:"priority",width:120 })   	
		.addTextColumn({ name:"resolution", dataIndex:"resolution",width:120 })   	
		.addTextColumn({ name:"severity", dataIndex:"severity",width:120 })   	
		.addTextColumn({ name:"assignee", dataIndex:"assignee",width:120 })   	
		.addTextColumn({ name:"assigneeRole", dataIndex:"assigneeRole", hidden:true,width:120 })   	
		.addTextColumn({ name:"reportedVersion", dataIndex:"reportedVersion", hidden:true,width:120 })   	
		.addTextColumn({ name:"targetVersion", dataIndex:"targetVersion", hidden:true,width:120 })   	
		.addTextColumn({ name:"fixedInVersion", dataIndex:"fixedInVersion", hidden:true,width:120 })   	
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
		.addNumberColumn({ name:"projectId", dataIndex:"projectId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"assigneeId", dataIndex:"assigneeId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.Item$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.Item$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addNumberField({ name:"id", dataIndex:"id",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20",noEdit:true  ,maxLength:32  })
		.addNumberField({ name:"projectId", dataIndex:"projectId",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		.addLov({ name:"project", xtype:"net.nan21.dnet.module.pj.md.lovs.Projects", dataIndex:"project",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "projectId"} ,{lovField:"name", dsField: "projectName"} ]  })
		.addTextField({ name:"projectName", dataIndex:"projectName",anchor:"-20",noEdit:true  ,maxLength:255  })
		.addTextField({ name:"summary", dataIndex:"summary",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addDateField({ name:"dueDate", dataIndex:"dueDate",anchor:"-20" })
		.addDateField({ name:"resolutionDate", dataIndex:"resolutionDate",anchor:"-20",noEdit:true, hideTrigger:true })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemTypes", dataIndex:"type",anchor:"-20" ,noUpdate:true ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemStatus", dataIndex:"status",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priority", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemPriorities", dataIndex:"priority",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"resolution", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemResolutions", dataIndex:"resolution",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "resolutionId"} ]  })
		.addLov({ name:"severity", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemSeverities", dataIndex:"severity",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "severityId"} ]  })
		.addLov({ name:"assignee", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectMembers", dataIndex:"assignee",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assigneeId"} ]  })
		.addTextField({ name:"assigneeRole", dataIndex:"assigneeRole",anchor:"-20" ,maxLength:255  })
		.addLov({ name:"reportedVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"reportedVersion",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "reportedVersionId"} ]  })
		.addLov({ name:"targetVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"targetVersion",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "targetVersionId"} ]  })
		.addLov({ name:"fixedInVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"fixedInVersion",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fixedInVersionId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:260})     
		.addPanel({ name:"row1", layout:"anchor" , width:600})     
		.addPanel({ name:"col3", layout:"anchor" , width:250})     
		.addPanel({ name:"col4", layout:"anchor" ,title:"Versions", width:250,xtype:"fieldset", border:false, collapsible:true})     
		.addPanel({ name:"col5", layout:"anchor" , width:250})     
		.addPanel({ name:"col2"  })      	 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		.addPanel({ name:"row2", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, width:750 }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["project","projectName","type","severity","priority","code","id"])
		.addChildrenTo("col2",["row1" ,"row2" ])
		.addChildrenTo("row1",["summary"])
		.addChildrenTo("row2",["col3" ,"col4" ,"col5" ])
		.addChildrenTo("col3",["assignee","status","resolution"])
		.addChildrenTo("col4",["reportedVersion","targetVersion","fixedInVersion"])
		.addChildrenTo("col5",["dueDate","resolutionDate"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.Item$EditText", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.Item$EditText",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextArea({ name:"description", dataIndex:"description",height:250,anchor:"-20"   })
		//containers
		.addPanel({ name:"main", layout:"anchor" , autoScroll:true,width:250, defaults:{
labelAlign:"top"}})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["description"])
;
	}	
});
