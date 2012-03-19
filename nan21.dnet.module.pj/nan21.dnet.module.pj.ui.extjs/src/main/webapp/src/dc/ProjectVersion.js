   

Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectVersion", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.ProjectVersionDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectVersion$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.ProjectVersion$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"project", xtype:"net.nan21.dnet.module.pj.md.lovs.Projects", dataIndex:"project",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "projectId"} ]  })
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addDateField({ name:"planDate_From", dataIndex:"planDate_From", emptyText:"From" })
		.addDateField({ name:"planDate_To", dataIndex:"planDate_To", emptyText:"To" })
		.addFieldContainer({name: "planDate", fieldLabel:"Plan Date"}) 
		.addChildrenTo("planDate",["planDate_From", "planDate_To"]) 

		.addDateField({ name:"releaseDate_From", dataIndex:"releaseDate_From", emptyText:"From" })
		.addDateField({ name:"releaseDate_To", dataIndex:"releaseDate_To", emptyText:"To" })
		.addFieldContainer({name: "releaseDate", fieldLabel:"Release Date"}) 
		.addChildrenTo("releaseDate",["releaseDate_From", "releaseDate_To"]) 

		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:300}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["project","name","active"])
		.addChildrenTo("col2",["planDate","releaseDate"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectVersion$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.ProjectVersion$EditList",
	
	_bulkEditFields_ : ["planDate","active","description"],
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"project", xtype:"gridcolumn", dataIndex:"project",width:100,editor:{xtype:"net.nan21.dnet.module.pj.md.lovs.Projects" , selectOnFocus:true ,noUpdate:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "projectId"} ]} })
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255} })
		.addDateColumn({ name:"planDate", dataIndex:"planDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"releaseDate", dataIndex:"releaseDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:400} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"projectId", dataIndex:"projectId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	 
Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectVersion$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.ProjectVersion$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"project", dataIndex:"project", hidden:true,width:100 })
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:400} })
		.addDateColumn({ name:"planDate", dataIndex:"planDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"releaseDate", dataIndex:"releaseDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"projectId", dataIndex:"projectId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
