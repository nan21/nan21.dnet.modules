   

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
		.addBooleanField({ name:"legalEntity", dataIndex:"legalEntity",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor", width:200}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
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
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addBooleanColumn({ name:"virtualEntity", dataIndex:"virtualEntity", width:80})
		.addBooleanColumn({ name:"legalEntity", dataIndex:"legalEntity", width:80})
		.addBooleanColumn({ name:"external", dataIndex:"external", width:80})
		.addBooleanColumn({ name:"inventory", dataIndex:"inventory", width:80})
		.addBooleanColumn({ name:"carrier", dataIndex:"carrier", width:80})
		.addBooleanColumn({ name:"accountingEnabled", dataIndex:"accountingEnabled", hidden:true, width:80})
		.addBooleanColumn({ name:"active", dataIndex:"active", width:80})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
	  ;  		   
	}  
});
