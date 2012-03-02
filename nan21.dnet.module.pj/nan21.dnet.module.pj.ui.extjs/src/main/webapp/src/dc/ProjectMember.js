   

Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectMember", {
	extend: "dnet.core.dc.AbstractDc",
 
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
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.ProjectMember$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"project", dataIndex:"project",anchor:"-20",maxLength:32  })
		.addTextField({ name:"role", dataIndex:"role",anchor:"-20",maxLength:255  })
		.addTextField({ name:"member", dataIndex:"member",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["project"])
		.addChildrenTo("col2",["role","member"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.pj.md.dc.ProjectMember$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.ProjectMember$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"project", dataIndex:"project", hidden:true,width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addLov({name:"member", xtype:"gridcolumn", dataIndex:"member", width:150,editor:{xtype:"net.nan21.dnet.module.ad.usr.lovs.Assignables" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "memberId"} ]} })
		.addLov({name:"role", xtype:"gridcolumn", dataIndex:"role", width:150,editor:{xtype:"net.nan21.dnet.module.pj.base.lovs.ProjectRoles" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "roleId"} ]} })
		.addNumberColumn({ name:"roleId", dataIndex:"roleId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"memberId", dataIndex:"memberId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
