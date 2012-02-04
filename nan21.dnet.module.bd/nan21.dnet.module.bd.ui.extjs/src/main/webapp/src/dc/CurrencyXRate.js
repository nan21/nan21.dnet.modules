   

Ext.define("net.nan21.dnet.module.bd.currency.dc.CurrencyXRate", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateDs",
	filterModel: "net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateDsFilter",
	paramModel: "net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"sourceCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"sourceCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "sourceId"} ]  })
		.addLov({ name:"targetCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"targetCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "targetId"} ]  })
		.addLov({ name:"providerCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.CurrencyXRateProviders", dataIndex:"providerCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "providerId"} ]  })
		.addDateField({ name:"validAt", dataIndex:"validAt",anchor:"-20" ,format:Ext.DATE_FORMAT })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["sourceCode","targetCode"])
		.addChildrenTo("col2",["providerCode","validAt"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"sourceCode", xtype:"gridcolumn", dataIndex:"sourceCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "sourceId"} ]} })
		.addLov({name:"targetCode", xtype:"gridcolumn", dataIndex:"targetCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "targetId"} ]} })
		.addDateColumn({ name:"validAt", dataIndex:"validAt",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addNumberColumn({ name:"value", dataIndex:"value", align:"right",decimals:6,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:6 } })
		.addNumberColumn({ name:"providerId", dataIndex:"providerId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"providerCode", xtype:"gridcolumn", dataIndex:"providerCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.currency.lovs.CurrencyXRateProviders" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "providerId"} ]} })
	  	.addDefaults()
	  ;  		   
	}  
});
