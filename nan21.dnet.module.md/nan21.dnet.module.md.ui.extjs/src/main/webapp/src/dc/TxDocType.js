   

Ext.define("net.nan21.dnet.module.md.base.tx.dc.TxDocType", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.base.tx.ds.model.TxDocTypeDs",
	filterModel: "net.nan21.dnet.module.md.base.tx.ds.model.TxDocTypeDsFilter",
	paramModel: "net.nan21.dnet.module.md.base.tx.ds.param.TxDocTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.base.tx.dc.TxDocType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.base.tx.dc.TxDocType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addCombo({ name:"category", xtype:"combo", dataIndex:"category",anchor:"-20",store:[ "sales-order", "sales-invoice", "sales-inventory-in", "sales-inventory-out", "purchase-order", "purchase-invoice", "purchase-inventory-in", "purchase-inventory-out", "inventory-transfer", "payment-in", "payment-out"]  })
		.addLov({ name:"journal", xtype:"net.nan21.dnet.module.md.acc.lovs.AccJournals", dataIndex:"journal",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "journalId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","active"])
		.addChildrenTo("col2",["category","journal"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.base.tx.dc.TxDocType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.base.tx.dc.TxDocType$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addComboColumn({ name:"category", dataIndex:"category", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true 	, valueField: 'bv', displayField: 'tv' ,store:[ "sales-order", "sales-invoice", "sales-inventory-in", "sales-inventory-out", "purchase-order", "purchase-invoice", "purchase-inventory-in", "purchase-inventory-out", "inventory-transfer", "payment-in", "payment-out"] , triggerAction:'all', forceSelection:true }})
		.addLov({name:"journal", xtype:"gridcolumn", dataIndex:"journal",width:120,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.AccJournals" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "journalId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
