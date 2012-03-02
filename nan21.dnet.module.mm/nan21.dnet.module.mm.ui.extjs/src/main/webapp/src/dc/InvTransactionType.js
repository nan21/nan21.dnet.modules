   

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransactionType", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionTypeDs",
	filterModel: "net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionTypeDsFilter",
	paramModel: "net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"hasFromInventory", dataIndex:"hasFromInventory",anchor:"-20"  })
		.addBooleanField({ name:"hasToInventory", dataIndex:"hasToInventory",anchor:"-20"  })
		.addLov({ name:"sourceType", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionSourceTypeS", dataIndex:"sourceType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "sourceTypeId"} ]  })
		.addLov({ name:"action", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionActions", dataIndex:"action",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "actionId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"col3", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name","active"])
		.addChildrenTo("col2",["sourceType","action"])
		.addChildrenTo("col3",["hasFromInventory","hasToInventory"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:400} })
		.addLov({name:"sourceType", xtype:"gridcolumn", dataIndex:"sourceType",width:120,editor:{xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionSourceTypeS" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "sourceTypeId"} ]} })
		.addLov({name:"action", xtype:"gridcolumn", dataIndex:"action",width:120,editor:{xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionActions" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "actionId"} ]} })
		.addBooleanColumn({ name:"hasFromInventory", dataIndex:"hasFromInventory"})
		.addBooleanColumn({ name:"hasToInventory", dataIndex:"hasToInventory"})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"sourceTypeId", dataIndex:"sourceTypeId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"actionId", dataIndex:"actionId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
