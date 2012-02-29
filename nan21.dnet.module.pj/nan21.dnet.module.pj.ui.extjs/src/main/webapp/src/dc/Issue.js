   

Ext.define("net.nan21.dnet.module.pj.md.dc.Issue", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.IssueDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.IssueDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.Issue$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.Issue$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"summary", dataIndex:"summary",anchor:"-20",maxLength:255  })
		.addTextField({ name:"description",_sharedLabel_:true, dataIndex:"description",anchor:"-20",maxLength:4000  })
		.addLov({ name:"project", xtype:"net.nan21.dnet.module.pj.md.lovs.Projects", dataIndex:"project",anchor:"-20",allowBlank:false,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "projectId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueStatus", dataIndex:"status",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priority", xtype:"net.nan21.dnet.module.pj.base.lovs.IssuePriorities", dataIndex:"priority",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"resolution", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueResolutions", dataIndex:"resolution",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "resolutionId"} ]  })
		.addLov({ name:"severity", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueSeverities", dataIndex:"severity",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "severityId"} ]  })
		.addLov({ name:"assignee", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectMembers", dataIndex:"assignee",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assigneeId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addLov({ name:"reportedVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"reportedVersion",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "reportedVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addLov({ name:"targetVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"targetVersion",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "targetVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addLov({ name:"fixedInVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"fixedInVersion",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fixedInVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addLov({ name:"affectedVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", paramIndex:"affectedVersion",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "affectedVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addLov({ name:"affectedComponent", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectComponents", paramIndex:"affectedComponent",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "affectedComponentId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:200, defaults:{
labelAlign:"right",labelWidth:70}}) 
		.addPanel({ name:"col2", layout:"form", width:200, defaults:{
labelAlign:"right",labelWidth:70}}) 
		.addPanel({ name:"col4", layout:"form", width:200}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col4"])
		.addChildrenTo("col1",["project","type","code","summary","description"])
		.addChildrenTo("col2",["status","severity","priority","resolution","assignee"])
		.addChildrenTo("col4",["reportedVersion","targetVersion","fixedInVersion","affectedComponent","affectedVersion"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.pj.md.dc.Issue$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.pj.md.dc.Issue$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"code", dataIndex:"code", width:80 })   	
		.addTextColumn({ name:"project", dataIndex:"project", width:80 })   	
		.addTextColumn({ name:"projectName", dataIndex:"projectName", hidden:true,width:200 })   	
		.addTextColumn({ name:"summary", dataIndex:"summary",width:200 })   	
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true,width:200 })   	
		.addDateColumn({ name:"dueDate", dataIndex:"dueDate", width:80,format:Dnet.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"resolutionDate", dataIndex:"resolutionDate", hidden:true, width:80,format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"type", dataIndex:"type", width:80 })   	
		.addTextColumn({ name:"status", dataIndex:"status", width:80 })   	
		.addTextColumn({ name:"priority", dataIndex:"priority", width:80 })   	
		.addTextColumn({ name:"resolution", dataIndex:"resolution", width:80 })   	
		.addTextColumn({ name:"severity", dataIndex:"severity", width:80 })   	
		.addTextColumn({ name:"assignee", dataIndex:"assignee",width:120 })   	
		.addTextColumn({ name:"assigneeRole", dataIndex:"assigneeRole", hidden:true,width:120 })   	
		.addTextColumn({ name:"reportedVersion", dataIndex:"reportedVersion", hidden:true,width:120 })   	
		.addTextColumn({ name:"targetVersion", dataIndex:"targetVersion", hidden:true,width:120 })   	
		.addTextColumn({ name:"fixedInVersion", dataIndex:"fixedInVersion", hidden:true,width:120 })   	
		.addNumberColumn({ name:"businessValue", dataIndex:"businessValue", width:80 })  
		.addNumberColumn({ name:"estimatedEffort", dataIndex:"estimatedEffort", hidden:true, width:80 })  
		.addNumberColumn({ name:"clarity", dataIndex:"clarity", hidden:true, width:80 })  
		.addNumberColumn({ name:"projectId", dataIndex:"projectId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"assigneeId", dataIndex:"assigneeId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.Issue$Edit", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.Issue$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDisplayFieldText({ name:"code", dataIndex:"code"  })
		.addLov({ name:"project", xtype:"net.nan21.dnet.module.pj.md.lovs.Projects", dataIndex:"project",anchor:"-20" ,noUpdate:true ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "projectId"} ,{lovField:"name", dsField: "projectName"} ]  })
		.addDisplayFieldText({ name:"projectName", dataIndex:"projectName"  })
		.addTextField({ name:"summary", dataIndex:"summary",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addDateField({ name:"dueDate", dataIndex:"dueDate",anchor:"-20" })
		.addDisplayFieldDate({name:"resolutionDate", dataIndex:"resolutionDate"  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTypes", dataIndex:"type",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueStatus", dataIndex:"status",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priority", xtype:"net.nan21.dnet.module.pj.base.lovs.IssuePriorities", dataIndex:"priority",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"resolution", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueResolutions", dataIndex:"resolution",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "resolutionId"} ]  })
		.addLov({ name:"severity", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueSeverities", dataIndex:"severity",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "severityId"} ]  })
		.addLov({ name:"assignee", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectMembers", dataIndex:"assignee",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assigneeId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addTextField({ name:"assigneeRole", dataIndex:"assigneeRole",anchor:"-20" ,maxLength:255  })
		.addLov({ name:"reportedVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersionsReleased", dataIndex:"reportedVersion",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "reportedVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addLov({ name:"targetVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersionsPlanned", dataIndex:"targetVersion",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "targetVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addLov({ name:"fixedInVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"fixedInVersion",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fixedInVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addNumberField({ name:"businessValue", dataIndex:"businessValue",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"estimatedEffort", dataIndex:"estimatedEffort",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"clarity", dataIndex:"clarity",anchor:"-20"  , style: "text-align:right;" })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:260})     
		.addPanel({ name:"row1", layout:"form" , width:600})     
		.addPanel({ name:"col3", layout:"form" , width:250})     
		.addPanel({ name:"col4", layout:"form" ,title:"Versions", width:220,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"col5", layout:"form" , width:200})     
		.addPanel({ name:"col2"  })      	 
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		.addPanel({ name:"row2",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["project","projectName","type","status","code"])
		.addChildrenTo("col2",["row1" ,"row2" ])
		.addChildrenTo("row1",["summary"])
		.addChildrenTo("row2",["col3" ,"col4" ,"col5" ])
		.addChildrenTo("col3",["assignee","priority","severity","resolution"])
		.addChildrenTo("col4",["reportedVersion","targetVersion","fixedInVersion"])
		.addChildrenTo("col5",["dueDate","resolutionDate","businessValue","clarity","estimatedEffort"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.Issue$EditText", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.Issue$EditText",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextArea({ name:"description", dataIndex:"description",height:250,anchor:"-20"   })
		//containers
		.addPanel({ name:"r1", layout:"form" , width:"90%", defaults:{
labelAlign:"top"}})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["r1" ])
		.addChildrenTo("r1",["description"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.Issue$ViewDescription", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.Issue$ViewDescription",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDisplayFieldText({ name:"description", dataIndex:"description", asText:true, fieldStyle:"height:auto;"  })
		//containers
		.addPanel({ name:"r1", layout:"form" , width:"90%", defaults:{
labelAlign:"top"}})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["r1" ])
		.addChildrenTo("r1",["description"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.Issue$View", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.Issue$View",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDisplayFieldText({ name:"code", dataIndex:"code"  })
		.addDisplayFieldNumber({name:"projectId", dataIndex:"projectId"  })
		.addDisplayFieldText({ name:"project", dataIndex:"project"  })
		.addDisplayFieldText({ name:"projectName", dataIndex:"projectName"  })
		.addDisplayFieldText({ name:"summary", dataIndex:"summary"  })
		.addDisplayFieldDate({name:"dueDate", dataIndex:"dueDate"  })
		.addDisplayFieldDate({name:"resolutionDate", dataIndex:"resolutionDate"  })
		.addDisplayFieldText({ name:"type", dataIndex:"type"  })
		.addDisplayFieldText({ name:"status", dataIndex:"status"  })
		.addDisplayFieldText({ name:"priority", dataIndex:"priority"  })
		.addDisplayFieldText({ name:"resolution", dataIndex:"resolution"  })
		.addDisplayFieldText({ name:"severity", dataIndex:"severity"  })
		.addDisplayFieldText({ name:"assignee", dataIndex:"assignee"  })
		.addDisplayFieldText({ name:"assigneeRole", dataIndex:"assigneeRole"  })
		.addDisplayFieldText({ name:"reportedVersion", dataIndex:"reportedVersion"  })
		.addDisplayFieldText({ name:"targetVersion", dataIndex:"targetVersion"  })
		.addDisplayFieldText({ name:"fixedInVersion", dataIndex:"fixedInVersion"  })
		.addDisplayFieldNumber({name:"businessValue", dataIndex:"businessValue"  })
		.addDisplayFieldNumber({name:"estimatedEffort", dataIndex:"estimatedEffort"  })
		.addDisplayFieldNumber({name:"clarity", dataIndex:"clarity"  })
		.addDisplayFieldText({ name:"description", dataIndex:"description", asText:true, fieldStyle:"height:auto;"  })
		//containers
		.addPanel({ name:"r2", layout:"form" , width:"90%", defaults:{
labelAlign:"top"}})     
		.addPanel({ name:"col1", layout:"form" , width:260})     
		.addPanel({ name:"row1", layout:"form" , width:600})     
		.addPanel({ name:"col3", layout:"form" , width:250})     
		.addPanel({ name:"col4", layout:"form" ,title:"Versions", width:250,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"col5", layout:"form" , width:250})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		.addPanel({ name:"col2"  })      	 
		.addPanel({ name:"r1",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		.addPanel({ name:"row2",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["r1" ,"r2" ])
		.addChildrenTo("r2",["description"])
		.addChildrenTo("r1",["col1" ,"col2" ])
		.addChildrenTo("col1",["project","projectName","type","severity","priority","code"])
		.addChildrenTo("col2",["row1" ,"row2" ])
		.addChildrenTo("row1",["summary"])
		.addChildrenTo("row2",["col3" ,"col4" ,"col5" ])
		.addChildrenTo("col3",["assignee","status","resolution"])
		.addChildrenTo("col4",["reportedVersion","targetVersion","fixedInVersion"])
		.addChildrenTo("col5",["dueDate","resolutionDate","businessValue","clarity","estimatedEffort"])
;
	}	
});
