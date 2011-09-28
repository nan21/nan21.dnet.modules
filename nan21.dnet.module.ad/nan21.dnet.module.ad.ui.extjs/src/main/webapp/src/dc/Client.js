   

Ext.define("net.nan21.dnet.module.ad.client.dc.Client", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.client.ds.model.ClientDs",
	paramModel: "net.nan21.dnet.module.ad.client.ds.param.ClientDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.ad.client.dc.Client$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.client.dc.Client$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addTextField({ name:"maintenanceLanguage", dataIndex:"maintenanceLanguage",anchor:"-20" ,maxLength:5,caseRestriction:"uppercase",vtype:"alpha"  })
		.addTextField({ name:"defaultImportPath", dataIndex:"defaultImportPath",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"defaultExportPath", dataIndex:"defaultExportPath",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"tempPath", dataIndex:"tempPath",anchor:"-20" ,maxLength:255  })
		.addCombo({ name:"defaultDsAccessRule", xtype:"combo", dataIndex:"defaultDsAccessRule",anchor:"-20",store:[ "allow", "deny"]  })
		.addTextField({ name:"adminRole", dataIndex:"adminRole",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		.addDateField({ name:"createdAt", dataIndex:"createdAt",anchor:"-20",disabled:true, hideTrigger:true ,allowBlank:false})
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",anchor:"-20",disabled:true, hideTrigger:true ,allowBlank:false})
		.addTextField({ name:"createdBy", dataIndex:"createdBy",anchor:"-20",disabled:true  ,allowBlank:false,maxLength:32  })
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",anchor:"-20",disabled:true  ,allowBlank:false,maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:350,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"anchor" , width:350,labelWidth:0 })     
		.addPanel({ name:"col3", layout:"anchor" , width:220,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["name","code","notes","adminRole"])
		.addChildrenTo("col2",["defaultImportPath","defaultExportPath","tempPath"])
		.addChildrenTo("col3",["createdAt","modifiedAt","createdBy","modifiedBy"])
;
	}	
});
