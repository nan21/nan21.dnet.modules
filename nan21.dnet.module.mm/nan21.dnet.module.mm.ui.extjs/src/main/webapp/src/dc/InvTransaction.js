   

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransaction", {
	extend: "dnet.core.dc.AbstractDc",
 
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
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.bd.fin.lovs.FinDocTypes", dataIndex:"docType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addLov({ name:"transactionType", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionTypes", dataIndex:"transactionType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "transactionTypeId"} ],filterFieldMapping: [{lovField:"docTypeId", dsField: "docTypeId"} ]  })
		.addLov({ name:"fromInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"fromInventory",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "fromInventoryId"} ]  })
		.addLov({ name:"toInventory", xtype:"net.nan21.dnet.module.bd.org.lovs.InventoryOrganizations", dataIndex:"toInventory",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "toInventoryId"} ]  })
		.addDateField({ name:"eventDate_From", dataIndex:"eventDate_From", emptyText:"From" })
		.addDateField({ name:"eventDate_To", dataIndex:"eventDate_To", emptyText:"To" })
		.addFieldContainer({name: "eventDate", fieldLabel:"Event Date"}) 
		.addChildrenTo("eventDate",["eventDate_From", "eventDate_To"]) 

		.addDateField({ name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
		.addDateField({ name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
		.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"}) 
		.addChildrenTo("docDate",["docDate_From", "docDate_To"]) 

		.addBooleanField({ name:"confirmed", dataIndex:"confirmed",anchor:"-20"  })
		.addBooleanField({ name:"posted", dataIndex:"posted",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form", width:300}) 
		.addPanel({ name:"col4", layout:"form", width:180}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["docType","transactionType"])
		.addChildrenTo("col2",["fromInventory","toInventory"])
		.addChildrenTo("col3",["eventDate","docDate"])
		.addChildrenTo("col4",["confirmed","posted"])
    		
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransaction$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.mm.inventory.dc.InvTransaction$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"docType", dataIndex:"docType",width:120 })   	
		.addTextColumn({ name:"transactionType", dataIndex:"transactionType",width:120 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"eventDate", dataIndex:"eventDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"fromInventory", dataIndex:"fromInventory", width:150 })   	
		.addTextColumn({ name:"toInventory", dataIndex:"toInventory", width:150 })   	
		.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})   	     
		.addBooleanColumn({ name:"posted", dataIndex:"posted"})   	     
		.addNumberColumn({ name:"docTypeId", dataIndex:"docTypeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"transactionTypeId", dataIndex:"transactionTypeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"fromInventoryId", dataIndex:"fromInventoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"toInventoryId", dataIndex:"toInventoryId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
