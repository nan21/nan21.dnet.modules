   

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueMnt", {
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



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueMnt$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueMnt$Filter",
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
		.addLov({ name:"assignee", xtype:"net.nan21.dnet.module.ad.usr.lovs.Assignables", dataIndex:"assignee",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assigneeId"} ]  })
		.addLov({ name:"reportedVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"reportedVersion",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "reportedVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addLov({ name:"targetVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"targetVersion",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "targetVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addLov({ name:"fixedInVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"fixedInVersion",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fixedInVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addLov({ name:"affectedComponent", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectComponents", paramIndex:"affectedComponent",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "affectedComponentId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addLov({ name:"affectedVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", paramIndex:"affectedVersion",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "affectedVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
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
 	
 	 
Ext.define("net.nan21.dnet.module.pj.md.dc.IssueMnt$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueMnt$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_bulkEditFields_ : ["dueDate","type","status","priority","severity","assignee","reportedVersion","targetVersion","fixedInVersion","resolution","businessValue","estimatedEffort","clarity"]
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code", width:80 })
		.addTextColumn({ name:"project", dataIndex:"project", width:80 })
		.addTextColumn({ name:"projectName", dataIndex:"projectName", hidden:true,width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"summary", dataIndex:"summary",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addDateColumn({ name:"dueDate", dataIndex:"dueDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addLov({name:"type", xtype:"gridcolumn", dataIndex:"type", width:80,editor:{xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTypes" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]} })
		.addLov({name:"status", xtype:"gridcolumn", dataIndex:"status", width:80,editor:{xtype:"net.nan21.dnet.module.pj.base.lovs.IssueStatus" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "statusId"} ]} })
		.addLov({name:"priority", xtype:"gridcolumn", dataIndex:"priority", width:80,editor:{xtype:"net.nan21.dnet.module.pj.base.lovs.IssuePriorities" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]} })
		.addLov({name:"severity", xtype:"gridcolumn", dataIndex:"severity", width:80,editor:{xtype:"net.nan21.dnet.module.pj.base.lovs.IssueSeverities" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "severityId"} ]} })
		.addLov({name:"assignee", xtype:"gridcolumn", dataIndex:"assignee", width:80,editor:{xtype:"net.nan21.dnet.module.ad.usr.lovs.Assignables" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "assigneeId"} ]} })
		.addLov({name:"reportedVersion", xtype:"gridcolumn", dataIndex:"reportedVersion", width:80,editor:{xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "reportedVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]} })
		.addLov({name:"targetVersion", xtype:"gridcolumn", dataIndex:"targetVersion", width:80,editor:{xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "targetVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]} })
		.addLov({name:"fixedInVersion", xtype:"gridcolumn", dataIndex:"fixedInVersion", width:80,editor:{xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "fixedInVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]} })
		.addLov({name:"resolution", xtype:"gridcolumn", dataIndex:"resolution", hidden:true, width:80,editor:{xtype:"net.nan21.dnet.module.pj.base.lovs.IssueResolutions" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "resolutionId"} ]} })
		.addNumberColumn({ name:"businessValue", dataIndex:"businessValue", align:"right", width:80,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"estimatedEffort", dataIndex:"estimatedEffort", hidden:true, align:"right", width:80,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"clarity", dataIndex:"clarity", hidden:true, align:"right", width:80,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueMnt$ViewText", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueMnt$ViewText",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDisplayFieldText({ name:"description", dataIndex:"description", asText:true, fieldStyle:"height:auto;"  })
		//containers
		.addPanel({ name:"main", layout:"form" , autoScroll:true, defaults:{
labelAlign:"top"}})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["description"])
;
	}	
});
