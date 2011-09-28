   

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransactionType", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionTypeDs",
	paramModel: "net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"sourceType", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionSourceTypeS", dataIndex:"sourceType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "sourceTypeId"} ]  })
		.addLov({ name:"action", xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionActions", dataIndex:"action",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "actionId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","active"])
		.addChildrenTo("col2",["sourceType","action"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addLov({name:"sourceType", xtype:"gridcolumn", dataIndex:"sourceType",width:120,editor:{xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionSourceTypeS" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "sourceTypeId"} ]} })
		.addLov({name:"action", xtype:"gridcolumn", dataIndex:"action",width:120,editor:{xtype:"net.nan21.dnet.module.mm.inventory.lovs.InvTransactionActions" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "actionId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"sourceTypeId", dataIndex:"sourceTypeId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"actionId", dataIndex:"actionId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
