   

Ext.define("net.nan21.dnet.module.ad.usr.dc.AccessControl", {
	extend: "dnet.core.dc.AbstractDc",
 
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
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.usr.dc.AccessControl$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"withRole", xtype:"net.nan21.dnet.module.ad.usr.lovs.Roles", paramIndex:"withRole",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "withRoleId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form", width:170}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","withRole"])
		.addChildrenTo("col2",["active"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.ad.usr.dc.AccessControl$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.AccessControl$EditList",
	
	_bulkEditFields_ : ["active","description"],
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"description", dataIndex:"description", width:300,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.ad.usr.dc.AccessControl$CopyRulesFromSource", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.ad.usr.dc.AccessControl$CopyRulesFromSource",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"copyFrom", xtype:"net.nan21.dnet.module.ad.usr.lovs.AccessControls", paramIndex:"copyFrom" ,retFieldMapping: [{lovField:"id", dsParam: "copyFromId"} ]  })
		.addCheckbox({ name:"skipDs", paramIndex:"skipDs"  })
		.addCheckbox({ name:"skipAsgn", paramIndex:"skipAsgn"  })
		.addCheckbox({ name:"resetRules", paramIndex:"resetRules"  })
		//containers
		.addPanel({ name:"main", layout:"form" , autoScroll:true})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["copyFrom","skipDs","skipAsgn","resetRules"])
;
	}	
});
 	
