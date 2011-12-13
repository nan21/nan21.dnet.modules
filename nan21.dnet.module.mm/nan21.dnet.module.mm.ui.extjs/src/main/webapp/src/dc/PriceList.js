   

Ext.define("net.nan21.dnet.module.mm.price.dc.PriceList", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.price.ds.model.PriceListDs",
	filterModel: "net.nan21.dnet.module.mm.price.ds.model.PriceListDsFilter",
	paramModel: "net.nan21.dnet.module.mm.price.ds.param.PriceListDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.price.dc.PriceList$FilterH", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.price.dc.PriceList$FilterH",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.mm.price.lovs.PriceListTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addDateField({ name:"validAt", paramIndex:"validAt",anchor:"-20" ,format:Ext.DATE_FORMAT })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor", width:250}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["type","currency"])
		.addChildrenTo("col2",["validAt"])
	}
}); 
 	

Ext.define("net.nan21.dnet.module.mm.price.dc.PriceList$FilterV", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.price.dc.PriceList$FilterV",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.mm.price.lovs.PriceListTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addDateField({ name:"validAt", paramIndex:"validAt",anchor:"-20" ,format:Ext.DATE_FORMAT })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["type","currency","validAt"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.mm.price.dc.PriceList$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.price.dc.PriceList$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"type", xtype:"gridcolumn", dataIndex:"type",width:120,editor:{xtype:"net.nan21.dnet.module.mm.price.lovs.PriceListTypes" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]} })
		.addLov({name:"currency", xtype:"gridcolumn", dataIndex:"currency",width:100,editor:{xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]} })
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Ext.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT}})
		.addDateColumn({ name:"validTo", dataIndex:"validTo",format:Ext.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT}})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
 		 
Ext.define("net.nan21.dnet.module.mm.price.dc.PriceList$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.mm.price.dc.PriceList$List",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Ext.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"validTo", dataIndex:"validTo",format:Ext.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
