   

Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationType", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeDs",
	filterModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeDsFilter",
	paramModel: "net.nan21.dnet.module.bd.org.ds.param.OrganizationTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.org.dc.OrganizationType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"external", dataIndex:"external",anchor:"-20"  })
		.addBooleanField({ name:"carrier", dataIndex:"carrier",anchor:"-20"  })
		.addBooleanField({ name:"inventory", dataIndex:"inventory",anchor:"-20"  })
		.addBooleanField({ name:"warehouse", dataIndex:"warehouse",anchor:"-20"  })
		.addBooleanField({ name:"legalEntity", dataIndex:"legalEntity",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:200}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","active","external"])
		.addChildrenTo("col2",["legalEntity","inventory","carrier"])
    	.addAuditFilter({})	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.org.dc.OrganizationType$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"virtualEntity", dataIndex:"virtualEntity", width:80})
		.addBooleanColumn({ name:"legalEntity", dataIndex:"legalEntity", width:80})
		.addBooleanColumn({ name:"external", dataIndex:"external", width:80})
		.addBooleanColumn({ name:"inventory", dataIndex:"inventory", width:80})
		.addBooleanColumn({ name:"warehouse", dataIndex:"warehouse", width:80})
		.addBooleanColumn({ name:"carrier", dataIndex:"carrier", width:80})
		.addBooleanColumn({ name:"accountingEnabled", dataIndex:"accountingEnabled", hidden:true, width:80})
		.addBooleanColumn({ name:"active", dataIndex:"active", width:80})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
