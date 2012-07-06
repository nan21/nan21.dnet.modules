   

Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccountMethod", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.org.ds.model.FinancialAccountMethodDs",
	filterModel: "net.nan21.dnet.module.md.org.ds.model.FinancialAccountMethodDsFilter",
	paramModel: "net.nan21.dnet.module.md.org.ds.param.FinancialAccountMethodDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccountMethod$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.org.dc.FinancialAccountMethod$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"financialAccount", dataIndex:"financialAccount",anchor:"-20",maxLength:255  })
		.addLov({ name:"payMethod", xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentMethod", dataIndex:"payMethod",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "payMethodId"} ]  })
		.addBooleanField({ name:"allowPayIn", dataIndex:"allowPayIn",anchor:"-20"  })
		.addBooleanField({ name:"allowPayOut", dataIndex:"allowPayOut",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["financialAccount","payMethod"])
		.addChildrenTo("col2",["allowPayIn","allowPayOut"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccountMethod$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.org.dc.FinancialAccountMethod$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"financialAccount", dataIndex:"financialAccount",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addLov({name:"payMethod", xtype:"gridcolumn", dataIndex:"payMethod", width:150,editor:{xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentMethod" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "payMethodId"} ]} })
		.addBooleanColumn({ name:"allowPayIn", dataIndex:"allowPayIn"})
		.addBooleanColumn({ name:"allowPayOut", dataIndex:"allowPayOut"})
		.addNumberColumn({ name:"financialAccountId", dataIndex:"financialAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"payMethodId", dataIndex:"payMethodId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccountMethod$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.org.dc.FinancialAccountMethod$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"payMethod", xtype:"gridcolumn", dataIndex:"payMethod", width:150,editor:{xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentMethod" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "payMethodId"} ],filterFieldMapping: [{lovField:"type", dsField: "financialAccountType"} ]} })
		.addBooleanColumn({ name:"allowPayIn", dataIndex:"allowPayIn"})
		.addBooleanColumn({ name:"allowPayOut", dataIndex:"allowPayOut"})
		.addNumberColumn({ name:"financialAccountId", dataIndex:"financialAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"payMethodId", dataIndex:"payMethodId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
