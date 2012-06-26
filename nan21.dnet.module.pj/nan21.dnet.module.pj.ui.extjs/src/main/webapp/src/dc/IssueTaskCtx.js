   

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTaskCtx", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueTaskDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.IssueTaskDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.IssueTaskDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTaskTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTaskStatuses", dataIndex:"status",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"assignee", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectMembers", dataIndex:"assignee",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assigneeId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		//containers
		.addPanel({ name:"main", layout:"hbox", autoScroll:true, defaults:{labelAlign:"right",labelWidth:80,width:210 }})
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		this._elems_.get("main")["items"] = [
	    {layout:"anchor", border:false 
	      ,items:[ this._elems_.get("type")] }
	  ,	    {layout:"anchor", border:false 
	      ,items:[ this._elems_.get("status")] }
	  ,	    {layout:"anchor", border:false 
	      ,items:[ this._elems_.get("assignee")] }
];
    		
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"assignee", dataIndex:"assignee",width:120 })   	
		.addTextColumn({ name:"status", dataIndex:"status",width:120 })   	
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true,width:200 })   	
		.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"assigneeId", dataIndex:"assigneeId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code",noEdit:true  ,maxLength:32  })
		.addTextArea({ name:"description", dataIndex:"description",height:120   })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTaskTypes", dataIndex:"type" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTaskStatuses", dataIndex:"status" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"assignee", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectMembers", dataIndex:"assignee" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assigneeId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:280})     
		.addPanel({ name:"col2", layout:"form" , width:500})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["type","assignee","status","code"])
		.addChildrenTo("col2",["description"])
;
	}	
});
 	
