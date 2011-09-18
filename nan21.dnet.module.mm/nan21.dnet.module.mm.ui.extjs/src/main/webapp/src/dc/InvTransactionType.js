   
Ext.ns('net.nan21.dnet.module.mm.inventory.dc');	 
net.nan21.dnet.module.mm.inventory.dc.InvTransactionType = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"InvTransactionType" 		 
			,ds: new net.nan21.dnet.module.mm.inventory.ds.InvTransactionTypeDs()			  
		});
	 	net.nan21.dnet.module.mm.inventory.dc.InvTransactionType.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.mm.inventory.dc'); 
net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active"  })
		.addLov({ name:"sourceType", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionSourceTypeS", dataIndex:"sourceType",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "sourceTypeId"} ]  })
		.addLov({ name:"action", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionActions", dataIndex:"action",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "actionId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","active"])
		.addChildrenTo("col2",["sourceType","action"])
	}
}); 
Ext.reg("net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$Filter", net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.mm.inventory.dc');	 	 
net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addLov({name:"sourceType", xtype:"gridcolumn", dataIndex:"sourceType",width:120,editor:{xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionSourceTypeS" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "sourceTypeId"} ]} })
		.addLov({name:"action", xtype:"gridcolumn", dataIndex:"action",width:120,editor:{xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionActions" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "actionId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})

		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"sourceTypeId", dataIndex:"sourceTypeId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"actionId", dataIndex:"actionId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$EditList", net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$EditList ); 
