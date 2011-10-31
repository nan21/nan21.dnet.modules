   

Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectMember", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectMemberDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectMemberDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.ProjectMemberDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectMember$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.ProjectMember$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"projectCode", dataIndex:"projectCode",anchor:"-20",maxLength:32  })
		.addTextField({ name:"role", dataIndex:"role",anchor:"-20",maxLength:255  })
		.addTextField({ name:"member", dataIndex:"member",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["projectCode"])
		.addChildrenTo("col2",["role","member"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectMember$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.ProjectMember$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"member", xtype:"gridcolumn", dataIndex:"member", width:150,editor:{xtype:"net.nan21.dnet.module.ad.usr.lovs.Assignables" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "memberId"} ]} })
		.addLov({name:"role", xtype:"gridcolumn", dataIndex:"role", width:150,editor:{xtype:"net.nan21.dnet.module.pj.base.lovs.ProjectRoles" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "roleId"} ]} })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"roleId", dataIndex:"roleId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"memberId", dataIndex:"memberId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
