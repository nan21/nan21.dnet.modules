   

Ext.define("net.nan21.dnet.module.ad.client.dc.MyClient", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.client.ds.model.MyClientDs",
	filterModel: "net.nan21.dnet.module.ad.client.ds.model.MyClientDsFilter",
	paramModel: "net.nan21.dnet.module.ad.client.ds.param.MyClientDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.ad.client.dc.MyClient$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.client.dc.MyClient$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20",noEdit:true  ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20",noEdit:true  ,maxLength:32  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addTextField({ name:"maintenanceLanguage", dataIndex:"maintenanceLanguage",anchor:"-20" ,maxLength:5,caseRestriction:"uppercase",vtype:"alpha"  })
		.addTextField({ name:"adminRole", dataIndex:"adminRole",anchor:"-20" ,maxLength:32  })
		.addDateField({ name:"createdAt", dataIndex:"createdAt",anchor:"-20",noEdit:true, hideTrigger:true ,allowBlank:false})
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",anchor:"-20",noEdit:true, hideTrigger:true ,allowBlank:false})
		.addTextField({ name:"createdBy", dataIndex:"createdBy",anchor:"-20",noEdit:true  ,allowBlank:false,maxLength:32  })
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",anchor:"-20",noEdit:true  ,allowBlank:false,maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:350})     
		.addPanel({ name:"col3", layout:"anchor" , width:220})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col3" ])
		.addChildrenTo("col1",["name","code","notes","adminRole"])
		.addChildrenTo("col3",["createdAt","modifiedAt","createdBy","modifiedBy"])
;
	}	
});
