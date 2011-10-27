   

Ext.define("net.nan21.dnet.module.bd.currency.dc.CurrencyXRate", {
	extend: "dnet.base.AbstractDc",
 
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
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"sourceCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"sourceCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "sourceId"} ]  })
		.addLov({ name:"targetCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"targetCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "targetId"} ]  })
		.addLov({ name:"providerCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.CurrencyXRateProviders", dataIndex:"providerCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "providerId"} ]  })
		.addDateField({ name:"validAt", dataIndex:"validAt",anchor:"-20" ,format:Ext.DATE_FORMAT })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["sourceCode","targetCode"])
		.addChildrenTo("col2",["providerCode","validAt"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"sourceCode", xtype:"gridcolumn", dataIndex:"sourceCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "sourceId"} ]} })
		.addLov({name:"targetCode", xtype:"gridcolumn", dataIndex:"targetCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "targetId"} ]} })
		.addDateColumn({ name:"validAt", dataIndex:"validAt",format:Ext.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT}})
		.addNumberColumn({ name:"value", dataIndex:"value", align:"right",format:Ext.NUMBER_FORMAT_DEC,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"providerId", dataIndex:"providerId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"providerCode", xtype:"gridcolumn", dataIndex:"providerCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.currency.lovs.CurrencyXRateProviders" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "providerId"} ]} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
