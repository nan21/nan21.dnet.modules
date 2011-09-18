   
Ext.ns('net.nan21.dnet.module.mm.inventory.dc');	 
net.nan21.dnet.module.mm.inventory.dc.InvTransaction = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"InvTransaction" 		 
			,ds: new net.nan21.dnet.module.mm.inventory.ds.InvTransactionDs()			  
		});
	 	net.nan21.dnet.module.mm.inventory.dc.InvTransaction.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.mm.inventory.dc'); 
net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addNumberField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20"  })
		.addLov({ name:"fromInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"fromInventory",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "fromInventoryId"} ]  })
		.addLov({ name:"toInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"toInventory",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "toInventoryId"} ]  })
		.addLov({ name:"transactionType", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionTypes", dataIndex:"transactionType",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "transactionTypeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["transactionType"])
		.addChildrenTo("col2",["id"])
	}
}); 
Ext.reg("net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Filter", net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.mm.inventory.dc');	 	 
net.nan21.dnet.module.mm.inventory.dc.InvTransaction$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"transactionType", dataIndex:"transactionType",width:120 })   	
		.addDateColumn({ name:"eventDate", dataIndex:"eventDate", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"fromInventory", dataIndex:"fromInventory",width:100 })   	
		.addTextColumn({ name:"toInventory", dataIndex:"toInventory",width:100 })   	
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"transactionTypeId", dataIndex:"transactionTypeId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.mm.inventory.dc.InvTransaction$List", net.nan21.dnet.module.mm.inventory.dc.InvTransaction$List ); 
 	
Ext.ns('net.nan21.dnet.module.mm.inventory.dc');	 
net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDateField({ name:"eventDate", dataIndex:"eventDate",width:100,disabled:true  })
		.addLov({ name:"transactionType", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionTypes", dataIndex:"transactionType",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "transactionTypeId"} ]  })
		.addLov({ name:"fromInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"fromInventory",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "fromInventoryId"} ]  })
		.addLov({ name:"toInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"toInventory",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "toInventoryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" , width:300,labelWidth:0 })     
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
Ext.reg("net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Edit", net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Edit ); 
