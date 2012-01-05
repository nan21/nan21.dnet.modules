   

Ext.define("net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.AsgnAccessControlDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.AsgnAccessControlDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.AsgnAccessControlDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"dsName", xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSourceAsgn", dataIndex:"dsName",anchor:"-20",maxLength:255,retFieldMapping: []  })
		.addLov({ name:"accessControl", xtype:"net.nan21.dnet.module.ad.usr.lovs.AccessControls", dataIndex:"accessControl",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accessControlId"} ]  })
		.addBooleanField({ name:"queryAllowed", dataIndex:"queryAllowed",anchor:"-20"  })
		.addBooleanField({ name:"updateAllowed", dataIndex:"updateAllowed",anchor:"-20"  })
		.addBooleanField({ name:"importAllowed", dataIndex:"importAllowed",anchor:"-20"  })
		.addBooleanField({ name:"exportAllowed", dataIndex:"exportAllowed",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor", width:200}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["accessControl","dsName"])
		.addChildrenTo("col2",["queryAllowed","updateAllowed"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accessControl", xtype:"gridcolumn", dataIndex:"accessControl",width:120,editor:{xtype:"net.nan21.dnet.module.ad.usr.lovs.AccessControls" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "accessControlId"} ]} })
		.addLov({name:"dsName", xtype:"gridcolumn", dataIndex:"dsName",width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSourceAsgn" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: []} })
		.addBooleanColumn({ name:"queryAllowed", dataIndex:"queryAllowed"})
		.addBooleanColumn({ name:"updateAllowed", dataIndex:"updateAllowed"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
 	
 	 
Ext.define("net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"dsName", xtype:"gridcolumn", dataIndex:"dsName",width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSourceAsgn" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: []} })
		.addBooleanColumn({ name:"queryAllowed", dataIndex:"queryAllowed"})
		.addBooleanColumn({ name:"updateAllowed", dataIndex:"updateAllowed"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
