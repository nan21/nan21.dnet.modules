   

Ext.define("net.nan21.dnet.module.mm.price.dc.PriceListVersion", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.price.ds.model.PriceListVersionDs",
	filterModel: "net.nan21.dnet.module.mm.price.ds.model.PriceListVersionDsFilter",
	paramModel: "net.nan21.dnet.module.mm.price.ds.param.PriceListVersionDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.price.dc.PriceListVersion$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.price.dc.PriceListVersion$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addTextField({ name:"priceList", dataIndex:"priceList",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","priceList"])
		.addChildrenTo("col2",["active"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.mm.price.dc.PriceListVersion$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.price.dc.PriceListVersion$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"priceListId", dataIndex:"priceListId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
 	
 	 
Ext.define("net.nan21.dnet.module.mm.price.dc.PriceListVersion$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.price.dc.PriceListVersion$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"priceList", dataIndex:"priceList",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"priceListId", dataIndex:"priceListId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
 	

Ext.define("net.nan21.dnet.module.mm.price.dc.PriceListVersion$CtxView", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.mm.price.dc.PriceListVersion$CtxView",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20",noEdit:true  ,maxLength:255  })
		.addTextField({ name:"priceList", dataIndex:"priceList",anchor:"-20",noEdit:true  ,maxLength:255  })
		.addDateField({ name:"validFrom", dataIndex:"validFrom",anchor:"-20",noEdit:true, hideTrigger:true })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300})     
		.addPanel({ name:"col2", layout:"anchor" , width:300})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","priceList"])
		.addChildrenTo("col2",["validFrom"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.mm.price.dc.PriceListVersion$CopyProductsFromCategory", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.mm.price.dc.PriceListVersion$CopyProductsFromCategory",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"productCategory", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductCategories", paramIndex:"productCategory",anchor:"-20" ,retFieldMapping: [{lovField:"id", dsParam: "productCategoryId"} ]  })
		//containers
		.addPanel({ name:"main", layout:"anchor" , autoScroll:true,width:250})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["productCategory"])
;
	}	
});
