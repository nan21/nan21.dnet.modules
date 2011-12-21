   

Ext.define("net.nan21.dnet.module.ad.usr.dc.DsAccessControl", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.DsAccessControlDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.DsAccessControl$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.usr.dc.DsAccessControl$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"dsName", dataIndex:"dsName",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"queryAllowed", dataIndex:"queryAllowed",anchor:"-20"  })
		.addBooleanField({ name:"insertAllowed", dataIndex:"insertAllowed",anchor:"-20"  })
		.addBooleanField({ name:"updateAllowed", dataIndex:"updateAllowed",anchor:"-20"  })
		.addBooleanField({ name:"deleteAllowed", dataIndex:"deleteAllowed",anchor:"-20"  })
		.addBooleanField({ name:"importAllowed", dataIndex:"importAllowed",anchor:"-20"  })
		.addBooleanField({ name:"exportAllowed", dataIndex:"exportAllowed",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"col3", layout:"anchor",width:210}) 
		.addPanel({ name:"col4", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["dsName"])
		.addChildrenTo("col2",["queryAllowed","deleteAllowed"])
		.addChildrenTo("col3",["insertAllowed","updateAllowed"])
		.addChildrenTo("col4",["importAllowed","exportAllowed"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.ad.usr.dc.DsAccessControl$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.DsAccessControl$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"dsName", xtype:"gridcolumn", dataIndex:"dsName",width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSource" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: []} })
		.addBooleanColumn({ name:"queryAllowed", dataIndex:"queryAllowed"})
		.addBooleanColumn({ name:"insertAllowed", dataIndex:"insertAllowed"})
		.addBooleanColumn({ name:"updateAllowed", dataIndex:"updateAllowed"})
		.addBooleanColumn({ name:"deleteAllowed", dataIndex:"deleteAllowed"})
		.addBooleanColumn({ name:"importAllowed", dataIndex:"importAllowed"})
		.addBooleanColumn({ name:"exportAllowed", dataIndex:"exportAllowed"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
