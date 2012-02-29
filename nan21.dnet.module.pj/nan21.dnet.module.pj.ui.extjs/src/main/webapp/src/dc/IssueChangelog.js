   

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueChangelog", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueChangelogDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.IssueChangelogDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.IssueChangelogDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.IssueChangelog$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.IssueChangelog$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"project", xtype:"net.nan21.dnet.module.pj.md.lovs.Projects", dataIndex:"project",anchor:"-20",allowBlank:false,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "projectId"} ]  })
		.addLov({ name:"fixedInVersion", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions", dataIndex:"fixedInVersion",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fixedInVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"summary", dataIndex:"summary",anchor:"-20",maxLength:255  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.pj.base.lovs.IssueStatus", dataIndex:"status",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addDateField({ name:"fixedInVersionDate_From", dataIndex:"fixedInVersionDate_From", emptyText:"From" })
		.addDateField({ name:"fixedInVersionDate_To", dataIndex:"fixedInVersionDate_To", emptyText:"To" })
		.addFieldContainer({name: "fixedInVersionDate", fieldLabel:"Fixed In Version Date"}) 
		.addChildrenTo("fixedInVersionDate",["fixedInVersionDate_From", "fixedInVersionDate_To"]) 

		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"col3", layout:"form", width:300}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["project","fixedInVersion"])
		.addChildrenTo("col2",["type","status"])
		.addChildrenTo("col3",["fixedInVersionDate"])
    		
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.pj.md.dc.IssueChangelog$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.pj.md.dc.IssueChangelog$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"project", dataIndex:"project",width:100 })   	
		.addTextColumn({ name:"projectName", dataIndex:"projectName", hidden:true,width:200 })   	
		.addTextColumn({ name:"fixedInVersion", dataIndex:"fixedInVersion",width:120 })   	
		.addDateColumn({ name:"fixedInVersionDate", dataIndex:"fixedInVersionDate", hidden:true,format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"summary", dataIndex:"summary",width:200 })   	
		.addTextColumn({ name:"status", dataIndex:"status",width:120 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addNumberColumn({ name:"projectId", dataIndex:"projectId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
