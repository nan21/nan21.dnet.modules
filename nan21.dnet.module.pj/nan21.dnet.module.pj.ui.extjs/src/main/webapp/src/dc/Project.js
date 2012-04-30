   

Ext.define("net.nan21.dnet.module.pj.md.dc.Project", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.ProjectDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.Project$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.Project$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"isPublic", dataIndex:"isPublic",anchor:"-20"  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.ProjectTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"projectLead", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectMembers", dataIndex:"projectLead",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "projectLeadId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["type","projectLead"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.pj.md.dc.Project$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.pj.md.dc.Project$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"projectLead", dataIndex:"projectLead",width:120 })   	
		.addBooleanColumn({ name:"isPublic", dataIndex:"isPublic"})   	     
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
		.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"projectLeadId", dataIndex:"projectLeadId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.Project$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.Project$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addCheckbox({ name:"isPublic", dataIndex:"isPublic"  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:100,anchor:"-20"   })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.pj.base.lovs.ProjectTypes", dataIndex:"type",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"projectLead", xtype:"net.nan21.dnet.module.pj.md.lovs.ProjectMembers", dataIndex:"projectLead",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "projectLeadId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:400, defaults:{
labelAlign:"top"}})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","type","projectLead","active","isPublic"])
		.addChildrenTo("col2",["notes"])
;
	}	
});
 	
