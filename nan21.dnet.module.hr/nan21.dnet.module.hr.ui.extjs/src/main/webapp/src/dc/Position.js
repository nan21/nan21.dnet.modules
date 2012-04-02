   

Ext.define("net.nan21.dnet.module.hr.job.dc.Position", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.PositionDs",
	filterModel: "net.nan21.dnet.module.hr.job.ds.model.PositionDsFilter",
	paramModel: "net.nan21.dnet.module.hr.job.ds.param.PositionDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.job.dc.Position$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.job.dc.Position$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addLov({ name:"organizationCode", xtype:"net.nan21.dnet.module.bd.org.lovs.Organizations", dataIndex:"organizationCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]  })
		.addLov({ name:"jobCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Jobs", dataIndex:"jobCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "jobId"} ]  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["jobCode","active"])
    	.addAuditFilter({})	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.hr.job.dc.Position$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.job.dc.Position$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name", width:250 })   	
		.addTextColumn({ name:"code", dataIndex:"code", width:150 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addNumberColumn({ name:"jobId", dataIndex:"jobId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"jobCode", dataIndex:"jobCode", width:150 })   	
		.addTextColumn({ name:"organizationCode", dataIndex:"organizationCode", width:150 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.hr.job.dc.Position$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.hr.job.dc.Position$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addLov({ name:"organizationCode", xtype:"net.nan21.dnet.module.bd.org.lovs.Organizations", dataIndex:"organizationCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]  })
		.addLov({ name:"jobCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Jobs", dataIndex:"jobCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "jobId"} ]  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:350})     
		.addPanel({ name:"col2", layout:"form" , width:300, defaults:{
labelAlign:"top"}})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","organizationCode","jobCode","active"])
		.addChildrenTo("col2",["notes"])
;
	}	
});
 	
