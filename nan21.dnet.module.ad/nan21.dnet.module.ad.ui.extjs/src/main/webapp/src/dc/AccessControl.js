   

Ext.define("net.nan21.dnet.module.ad.usr.dc.AccessControl", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.AccessControlDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.AccessControlDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.AccessControlDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.AccessControl$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.usr.dc.AccessControl$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"withRole", xtype:"net.nan21.dnet.module.ad.usr.lovs.Roles", paramIndex:"withRole",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "withRoleId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["name","active","withRole"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.ad.usr.dc.AccessControl$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.AccessControl$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"description", dataIndex:"description", width:300,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.AccessControl$CopyRulesFromSource", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.AccessControl$CopyRulesFromSource",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"copyFrom", xtype:"net.nan21.dnet.module.ad.usr.lovs.AccessControls", paramIndex:"copyFrom",anchor:"-20" ,retFieldMapping: [{lovField:"id", dsParam: "copyFromId"} ]  })
		.addCheckbox({ name:"skipDs", paramIndex:"skipDs"  })
		.addCheckbox({ name:"skipAsgn", paramIndex:"skipAsgn"  })
		.addCheckbox({ name:"resetRules", paramIndex:"resetRules"  })
		//containers
		.addPanel({ name:"main", layout:"anchor" , autoScroll:true,width:250})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["copyFrom","skipDs","skipAsgn","resetRules"])
;
	}	
});
