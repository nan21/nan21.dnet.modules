   
Ext.ns('net.nan21.dnet.module.bd.currency.dc');	 
net.nan21.dnet.module.bd.currency.dc.CurrencyXRate = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"CurrencyXRate" 		 
			,ds: new net.nan21.dnet.module.bd.currency.ds.CurrencyXRateDs()			  
		});
	 	net.nan21.dnet.module.bd.currency.dc.CurrencyXRate.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bd.currency.dc'); 
net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"sourceCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"sourceCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "sourceId"} ]  })
		.addLov({ name:"targetCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"targetCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "targetId"} ]  })
		.addLov({ name:"providerCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.CurrencyXRateProviders", dataIndex:"providerCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "providerId"} ]  })
		.addDateField({ name:"validAt", dataIndex:"validAt",width:100 ,format:Ext.DATE_FORMAT })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["sourceCode","targetCode"])
		.addChildrenTo("col2",["providerCode","validAt"])
	}
}); 
Ext.reg("net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$Filter", net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bd.currency.dc');	 	 
net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"sourceCode", xtype:"gridcolumn", dataIndex:"sourceCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "sourceId"} ]} })
		.addLov({name:"targetCode", xtype:"gridcolumn", dataIndex:"targetCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "targetId"} ]} })
		.addDateColumn({ name:"validAt", dataIndex:"validAt",format:Ext.DATE_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addNumberColumn({ name:"value", dataIndex:"value", align:"right",format:Ext.NUMBER_FORMAT_DEC ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"providerId", dataIndex:"providerId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addLov({name:"providerCode", xtype:"gridcolumn", dataIndex:"providerCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.currency.lovs.CurrencyXRateProviders" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "providerId"} ]} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$EditList", net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$EditList ); 
