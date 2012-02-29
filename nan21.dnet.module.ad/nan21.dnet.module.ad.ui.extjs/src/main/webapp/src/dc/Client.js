   

Ext.define("net.nan21.dnet.module.ad.client.dc.Client", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.client.ds.model.ClientDs",
	filterModel: "net.nan21.dnet.module.ad.client.ds.model.ClientDsFilter",
	paramModel: "net.nan21.dnet.module.ad.client.ds.param.ClientDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.client.dc.Client$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.client.dc.Client$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"systemClient", dataIndex:"systemClient",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["systemClient"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.client.dc.Client$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.client.dc.Client$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
		.addTextColumn({ name:"maintenanceLanguage", dataIndex:"maintenanceLanguage", hidden:true,width:80 })   	
		.addTextColumn({ name:"defaultImportPath", dataIndex:"defaultImportPath", hidden:true,width:200 })   	
		.addTextColumn({ name:"defaultExportPath", dataIndex:"defaultExportPath", hidden:true,width:200 })   	
		.addTextColumn({ name:"tempPath", dataIndex:"tempPath", hidden:true,width:200 })   	
		.addBooleanColumn({ name:"systemClient", dataIndex:"systemClient"})   	     
		.addTextColumn({ name:"adminRole", dataIndex:"adminRole", hidden:true,width:100 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.ad.client.dc.Client$Edit", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.client.dc.Client$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addTextField({ name:"defaultImportPath", dataIndex:"defaultImportPath",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"defaultExportPath", dataIndex:"defaultExportPath",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"tempPath", dataIndex:"tempPath",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addCheckbox({ name:"systemClient", dataIndex:"systemClient"  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:350})     
		.addPanel({ name:"col2", layout:"form" , width:450, defaults:{
labelAlign:"right",labelWidth:120}})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","notes","systemClient"])
		.addChildrenTo("col2",["defaultImportPath","defaultExportPath","tempPath"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.ad.client.dc.Client$Create", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.client.dc.Client$Create",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addTextField({ name:"defaultImportPath", dataIndex:"defaultImportPath",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"defaultExportPath", dataIndex:"defaultExportPath",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"tempPath", dataIndex:"tempPath",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"adminUserName", paramIndex:"adminUserName",anchor:"-20" ,allowBlank:false  })
		.addTextField({ name:"adminUserCode", paramIndex:"adminUserCode",anchor:"-20" ,allowBlank:false  })
		.addTextField({ name:"adminPassword", paramIndex:"adminPassword",anchor:"-20" ,allowBlank:false  })
		.addCheckbox({ name:"systemClient", dataIndex:"systemClient"  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:350})     
		.addPanel({ name:"col2", layout:"form" , width:250})     
		.addPanel({ name:"col3", layout:"form" , width:400})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["name","code","notes","systemClient"])
		.addChildrenTo("col2",["adminUserName","adminUserCode","adminPassword"])
		.addChildrenTo("col3",["defaultImportPath","defaultExportPath","tempPath"])
;
	}	
	,_shouldValidate_: function() {	
		return this._controller_.record.phantom;
	}
});
