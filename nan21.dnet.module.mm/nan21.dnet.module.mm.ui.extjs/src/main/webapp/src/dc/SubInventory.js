   

Ext.define("net.nan21.dnet.module.mm.inventory.dc.SubInventory", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.inventory.ds.model.SubInventoryDs",
	filterModel: "net.nan21.dnet.module.mm.inventory.ds.model.SubInventoryDsFilter",
	paramModel: "net.nan21.dnet.module.mm.inventory.ds.param.SubInventoryDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.mm.inventory.dc.SubInventory$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.SubInventory$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"inventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"inventory",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "inventoryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","inventory"])
		.addChildrenTo("col2",["active"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.mm.inventory.dc.SubInventory$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.mm.inventory.dc.SubInventory$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"inventory", dataIndex:"inventory",width:100 })   	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
		.addNumberColumn({ name:"inventoryId", dataIndex:"inventoryId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.mm.inventory.dc.SubInventory$Edit", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.SubInventory$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"description", dataIndex:"description",height:60,anchor:"-20"   })
		.addLov({ name:"inventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"inventory",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "inventoryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:400})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","description","inventory"])
		.addChildrenTo("col2",["active"])
;
	}	
});
