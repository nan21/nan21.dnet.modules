   

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTaskCtx", {
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



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTaskTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTaskStatuses", dataIndex:"status",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"assignee", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectMembers", dataIndex:"assignee",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assigneeId"} ]  })
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
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"assignee", dataIndex:"assignee",width:120 })   	
		.addTextColumn({ name:"status", dataIndex:"status",width:120 })   	
		.addTextColumn({ name:"summary", dataIndex:"summary",width:200 })   	
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true,width:200 })   	
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"assigneeId", dataIndex:"assigneeId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"summary", dataIndex:"summary",anchor:"-20" ,maxLength:255  })
		.addTextArea({ name:"description", dataIndex:"description",height:80,anchor:"-20"   })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTaskTypes", dataIndex:"type",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTaskStatuses", dataIndex:"status",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"assignee", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectMembers", dataIndex:"assignee",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assigneeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:250})     
		.addPanel({ name:"col2", layout:"anchor" , width:500})     
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
