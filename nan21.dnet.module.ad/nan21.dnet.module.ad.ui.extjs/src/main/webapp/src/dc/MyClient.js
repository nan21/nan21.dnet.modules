   

Ext.define("net.nan21.dnet.module.ad.client.dc.MyClient", {
	extend: "dnet.core.dc.AbstractDc",
 
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
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.ad.client.dc.MyClient$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDisplayFieldText({ name:"name", dataIndex:"name"  })
		.addDisplayFieldText({ name:"code", dataIndex:"code"  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60   })
		.addTextField({ name:"maintenanceLanguage", dataIndex:"maintenanceLanguage" ,maxLength:5,caseRestriction:"uppercase",vtype:"alpha"  })
		.addTextField({ name:"adminRole", dataIndex:"adminRole" ,allowBlank:false,maxLength:32  })
		.addDisplayFieldDate({name:"createdAt", dataIndex:"createdAt"  })
		.addDisplayFieldDate({name:"modifiedAt", dataIndex:"modifiedAt"  })
		.addDisplayFieldText({ name:"createdBy", dataIndex:"createdBy"  })
		.addDisplayFieldText({ name:"modifiedBy", dataIndex:"modifiedBy"  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:350})     
		.addPanel({ name:"col3", layout:"form" , width:220})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
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
 	
