   

Ext.define("net.nan21.dnet.module.bd.tx.dc.PaymentMethod", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.tx.ds.model.PaymentMethodDs",
	filterModel: "net.nan21.dnet.module.bd.tx.ds.model.PaymentMethodDsFilter",
	paramModel: "net.nan21.dnet.module.bd.tx.ds.param.PaymentMethodDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.tx.dc.PaymentMethod$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.tx.dc.PaymentMethod$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.bd.tx.lovs.TxDocTypesPay", dataIndex:"docType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addCombo({ name:"type", xtype:"combo", dataIndex:"type",anchor:"-20",store:[ "bank", "cash"]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","active"])
		.addChildrenTo("col2",["docType","type"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.tx.dc.PaymentMethod$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.tx.dc.PaymentMethod$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addLov({name:"docType", xtype:"gridcolumn", dataIndex:"docType",width:120,editor:{xtype:"net.nan21.dnet.module.bd.tx.lovs.TxDocTypesPay" , selectOnFocus:true,allowBlank:false ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]} })
		.addComboColumn({ name:"type", dataIndex:"type", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true 	, valueField: 'bv', displayField: 'tv' ,store:[ "bank", "cash"] , triggerAction:'all', forceSelection:true }})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
