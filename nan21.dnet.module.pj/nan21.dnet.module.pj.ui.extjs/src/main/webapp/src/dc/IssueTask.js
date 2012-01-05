   

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTask", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueTaskDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.IssueTaskDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.IssueTaskDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTask$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueTask$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addNumberField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20"  })
		.addLov({ name:"issue", xtype:"net.nan21.dnet.module.pj.md.lovs.Issues", dataIndex:"issue",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "issueId"} ]  })
		.addLov({ name:"issueSeverity", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueSeverities", dataIndex:"issueSeverity",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "issueSeverityId"} ]  })
		.addLov({ name:"issueStatus", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueStatus", dataIndex:"issueStatus",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "issueStatusId"} ]  })
		.addLov({ name:"issueType", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTypes", dataIndex:"issueType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "issueTypeId"} ]  })
		.addLov({ name:"issuePriority", xtype:"net.nan21.dnet.module.pj.base.lovs.IssuePriorities", dataIndex:"issuePriority",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "issuePriorityId"} ]  })
		.addLov({ name:"project", xtype:"net.nan21.dnet.module.pj.md.lovs.Projects", dataIndex:"project",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "projectId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTaskTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTaskStatuses", dataIndex:"status",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"assignee", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectMembers", dataIndex:"assignee",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assigneeId"} ]  })
		.addNumberField({ name:"issueId", dataIndex:"issueId",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",title:"Task", width:250,xtype:"fieldset", border:true, collapsible:true, defaults:{
labelAlign:"right",labelWidth:70}}) 
		.addPanel({ name:"col2", layout:"anchor",width:210, defaults:{
labelAlign:"right",labelWidth:70}}) 
		.addPanel({ name:"col3", layout:"anchor",title:"Issue", width:270,xtype:"fieldset", border:true, collapsible:true}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["type","status","assignee","id"])
		.addChildrenTo("col2",["project","issue"])
		.addChildrenTo("col3",["issueType","issuePriority","issueSeverity","issueStatus"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTask$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.pj.md.dc.IssueTask$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addNumberColumn({ name:"id", dataIndex:"id",format:"0",width:70 })  
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"assignee", dataIndex:"assignee",width:120 })   	
		.addTextColumn({ name:"status", dataIndex:"status",width:120 })   	
		.addTextColumn({ name:"summary", dataIndex:"summary",width:200 })   	
		.addTextColumn({ name:"issue", dataIndex:"issue",width:100 })   	
		.addNumberColumn({ name:"prioritySequenceNo", dataIndex:"issuePrioritySequenceNo", hidden:true })  
		.addTextColumn({ name:"issuePriority", dataIndex:"issuePriority",width:120 })   	
		.addTextColumn({ name:"issueSeverity", dataIndex:"issueSeverity",width:120 })   	
		.addTextColumn({ name:"issueType", dataIndex:"issueType",width:120 })   	
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true,width:200 })   	
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
		.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"assigneeId", dataIndex:"assigneeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"issueId", dataIndex:"issueId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTask$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueTask$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"summary", dataIndex:"summary",anchor:"-20" ,maxLength:255  })
		.addTextArea({ name:"description", dataIndex:"description",height:80,anchor:"-20"   })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTaskTypes", dataIndex:"type",anchor:"-20" ,noUpdate:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTaskStatuses", dataIndex:"status",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"assignee", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectMembers", dataIndex:"assignee",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assigneeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300})     
		.addPanel({ name:"col2", layout:"anchor" , width:550})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["type","assignee","status"])
		.addChildrenTo("col2",["summary","description"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTask$ViewDescription", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueTask$ViewDescription",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"summary", dataIndex:"summary",anchor:"-20" ,maxLength:255  })
		.addTextArea({ name:"description", dataIndex:"description",height:60,anchor:"-20"   })
		.addTextArea({ name:"issueSummary", dataIndex:"issueSummary",height:60,anchor:"-20"   })
		.addTextField({ name:"type", dataIndex:"type",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"status", dataIndex:"status",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"assignee", dataIndex:"assignee",anchor:"-20" ,maxLength:255  })
		//containers
		.addPanel({ name:"main", layout:"anchor" , autoScroll:true,title:"Task info",width:250})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["summary","description","issueSummary"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTask$View", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueTask$View",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"summary", dataIndex:"summary",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"description", dataIndex:"description",anchor:"-20" ,maxLength:4000  })
		.addTextField({ name:"issue", dataIndex:"issue",anchor:"-20" ,maxLength:32  })
		.addTextField({ name:"issueSeverity", dataIndex:"issueSeverity",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"issueStatus", dataIndex:"issueStatus",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"issueType", dataIndex:"issueType",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"issuePriority", dataIndex:"issuePriority",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"project", dataIndex:"project",anchor:"-20" ,maxLength:32  })
		.addTextField({ name:"type", dataIndex:"type",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"status", dataIndex:"status",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"assignee", dataIndex:"assignee",anchor:"-20" ,maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" ,title:"Task info",width:250,xtype:"fieldset", border:false, collapsible:true})     
		.addPanel({ name:"col2", layout:"anchor" ,title:"Task description",width:250,xtype:"fieldset", border:false, collapsible:true})     
		.addPanel({ name:"col3", layout:"anchor" ,title:"Issue info",width:250,xtype:"fieldset", border:false, collapsible:true})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["type","status","assignee"])
		.addChildrenTo("col2",["summary","description"])
		.addChildrenTo("col3",["project","issue","issueType","issuePriority","issueSeverity","issueStatus"])
;
	}	
});
