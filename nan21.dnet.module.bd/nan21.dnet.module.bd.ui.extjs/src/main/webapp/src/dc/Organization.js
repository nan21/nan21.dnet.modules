   

Ext.define("net.nan21.dnet.module.bd.org.dc.Organization", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationDs",
	filterModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationDsFilter",
	paramModel: "net.nan21.dnet.module.bd.org.ds.param.OrganizationDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.org.dc.Organization$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.org.dc.Organization$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.bd.org.lovs.OrganizationTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"calendar", xtype:"net.nan21.dnet.module.bd.org.lovs.Calendars", dataIndex:"calendar",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "calendarId"} ]  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"col3", layout:"form", width:170}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["type","calendar"])
		.addChildrenTo("col3",["active"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.bd.org.dc.Organization$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bd.org.dc.Organization$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"calendar", dataIndex:"calendar",width:120 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addBooleanColumn({ name:"valid", dataIndex:"valid"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.bd.org.dc.Organization$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.bd.org.dc.Organization$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code" ,allowBlank:false,maxLength:32  })
		.addLov({ name:"calendar", xtype:"net.nan21.dnet.module.bd.org.lovs.Calendars", dataIndex:"calendar" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "calendarId"} ]  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:80   })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addCheckbox({ name:"valid", dataIndex:"valid"  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.bd.org.lovs.OrganizationTypes", dataIndex:"type" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:400})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","notes"])
		.addChildrenTo("col2",["type","calendar","active","valid"])
;
	}	
});
 	
