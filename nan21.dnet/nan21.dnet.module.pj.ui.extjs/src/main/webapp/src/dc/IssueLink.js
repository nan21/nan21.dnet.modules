   

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueLink", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueLinkDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.IssueLinkDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.IssueLinkDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueLink$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueLink$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"sourceIssue", xtype:"net.nan21.dnet.module.pj.md.lovs.Issues", dataIndex:"sourceIssue",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "sourceIssueId"} ]  })
		.addLov({ name:"targetIssue", xtype:"net.nan21.dnet.module.pj.md.lovs.Issues", dataIndex:"targetIssue",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "targetIssueId"} ]  })
		.addLov({ name:"linkType", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueLinkTypes", dataIndex:"linkType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "linkTypeId"} ]  })
		//containers
		.addPanel({ name:"main", layout:"hbox", autoScroll:true, defaults:{labelAlign:"right",labelWidth:80,width:210 }})
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		this._elems_.get("main")["items"] = [
	    {layout:"anchor", border:false 
	      ,items:[ this._elems_.get("linkType")] }
	  ,	    {layout:"anchor", border:false 
	      ,items:[ this._elems_.get("sourceIssue")] }
	  ,	    {layout:"anchor", border:false 
	      ,items:[ this._elems_.get("targetIssue")] }
];
    		
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.pj.md.dc.IssueLink$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.pj.md.dc.IssueLink$CtxList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addNumberColumn({ name:"sourceIssueId", dataIndex:"sourceIssueId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"sourceIssue", dataIndex:"sourceIssue", width:60 })   	
		.addTextColumn({ name:"sourceSummary", dataIndex:"sourceSummary", width:150 })   	
		.addTextColumn({ name:"linkType", dataIndex:"linkType", width:100 })   	
		.addNumberColumn({ name:"targetIssueId", dataIndex:"targetIssueId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"targetIssue", dataIndex:"targetIssue", width:60 })   	
		.addTextColumn({ name:"targetSummary", dataIndex:"targetSummary", width:150 })   	
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueLink$CtxCreate", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueLink$CtxCreate",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"targetIssue", xtype:"net.nan21.dnet.module.pj.md.lovs.Issues", dataIndex:"targetIssue",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "targetIssueId"} ]  })
		.addLov({ name:"linkType", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueLinkTypes", dataIndex:"linkType",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "linkTypeId"} ]  })
		//containers
		.addPanel({ name:"main", layout:"anchor" , autoScroll:true,width:250})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["linkType","targetIssue"])
;
	}	
});
