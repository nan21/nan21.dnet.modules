   

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransaction", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionDs",
	filterModel: "net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionDsFilter",
	paramModel: "net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addNumberField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20"  })
		.addLov({ name:"fromInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"fromInventory",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "fromInventoryId"} ]  })
		.addLov({ name:"toInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"toInventory",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "toInventoryId"} ]  })
		.addLov({ name:"transactionType", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionTypes", dataIndex:"transactionType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "transactionTypeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["transactionType"])
		.addChildrenTo("col2",["id"])
    		
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransaction$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.mm.inventory.dc.InvTransaction$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addNumberColumn({ name:"id", dataIndex:"id",format:"0",width:70 })  
		.addDateColumn({ name:"eventDate", dataIndex:"eventDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"transactionType", dataIndex:"transactionType", width:150 })   	
		.addTextColumn({ name:"fromInventory", dataIndex:"fromInventory", width:150 })   	
		.addTextColumn({ name:"toInventory", dataIndex:"toInventory", width:150 })   	
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
		.addNumberColumn({ name:"transactionTypeId", dataIndex:"transactionTypeId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDateField({ name:"eventDate", dataIndex:"eventDate",anchor:"-20",noEdit:true, hideTrigger:true })
		.addLov({ name:"transactionType", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionTypes", dataIndex:"transactionType",anchor:"-20" ,noUpdate:true ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "transactionTypeId"} ]  })
		.addLov({ name:"fromInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"fromInventory",anchor:"-20" ,noUpdate:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "fromInventoryId"} ]  })
		.addLov({ name:"toInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"toInventory",anchor:"-20" ,noUpdate:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "toInventoryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300})     
		.addPanel({ name:"col2", layout:"anchor" , width:300})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["transactionType","eventDate"])
		.addChildrenTo("col2",["fromInventory","toInventory"])
;
	}	
});
