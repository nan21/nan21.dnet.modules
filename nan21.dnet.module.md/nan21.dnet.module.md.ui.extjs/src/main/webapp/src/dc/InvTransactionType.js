   

Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionType", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionTypeDs",
	filterModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionTypeDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.inventory.ds.param.InvTransactionTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"hasFromInventory", dataIndex:"hasFromInventory",anchor:"-20"  })
		.addBooleanField({ name:"hasToInventory", dataIndex:"hasToInventory",anchor:"-20"  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.md.base.tx.lovs.TxDocTypes", dataIndex:"docType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form", width:200, defaults:{
labelAlign:"right",labelWidth:120}}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","docType"])
		.addChildrenTo("col2",["active","hasFromInventory","hasToInventory"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionType$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addLov({name:"docType", xtype:"gridcolumn", dataIndex:"docType",width:120,editor:{xtype:"net.nan21.dnet.module.md.base.tx.lovs.TxDocTypes" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]} })
		.addBooleanColumn({ name:"hasFromInventory", dataIndex:"hasFromInventory"})
		.addBooleanColumn({ name:"hasToInventory", dataIndex:"hasToInventory"})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"docTypeId", dataIndex:"docTypeId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
