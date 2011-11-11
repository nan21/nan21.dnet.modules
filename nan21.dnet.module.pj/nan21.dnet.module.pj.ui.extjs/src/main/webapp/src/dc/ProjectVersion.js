   

Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectVersion", {
	extend: "dnet.base.AbstractDc",
 
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
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.ProjectVersion$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addTextField({ name:"projectCode", dataIndex:"projectCode",anchor:"-20",maxLength:32  })
		.addTextField({ name:"project", dataIndex:"project",anchor:"-20",maxLength:255  })
		.addDateField({ name:"planDate", dataIndex:"planDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"releaseDate", dataIndex:"releaseDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addTextField({ name:"projectVersion", dataIndex:"projectVersion",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","projectCode","project","projectVersion"])
		.addChildrenTo("col2",["name","projectCode","project","projectVersion"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectVersion$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.ProjectVersion$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addTextColumn({ name:"projectCode", dataIndex:"projectCode",width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"project", dataIndex:"project",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addDateColumn({ name:"planDate", dataIndex:"planDate",format:Ext.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT}})
		.addDateColumn({ name:"releaseDate", dataIndex:"releaseDate",format:Ext.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT}})
		.addNumberColumn({ name:"projectVersionId", dataIndex:"projectVersionId", hidden:true, align:"right",format:"0",width:70})
		.addTextColumn({ name:"projectVersion", dataIndex:"projectVersion",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"projectId", dataIndex:"projectId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
 	
 	 
Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectVersion$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.ProjectVersion$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"projectCode", dataIndex:"projectCode", hidden:true,width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addDateColumn({ name:"planDate", dataIndex:"planDate",format:Ext.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT}})
		.addDateColumn({ name:"releaseDate", dataIndex:"releaseDate",format:Ext.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT}})
		.addLov({name:"projectVersion", xtype:"gridcolumn", dataIndex:"projectVersion",width:120,editor:{xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectVersions" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "projectVersionId"} ],filterFieldMapping: [{lovField:"projectId", dsField: "projectId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"projectId", dataIndex:"projectId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"projectVersionId", dataIndex:"projectVersionId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
