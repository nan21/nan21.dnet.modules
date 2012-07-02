   

Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceListVersion", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.mm.price.ds.model.PriceListVersionDs",
	filterModel: "net.nan21.dnet.module.md.mm.price.ds.model.PriceListVersionDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.price.ds.param.PriceListVersionDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"priceList", xtype:"net.nan21.dnet.module.md.mm.price.lovs.PriceList", dataIndex:"priceList",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priceListId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:180}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","priceList"])
		.addChildrenTo("col2",["active"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"priceListId", dataIndex:"priceListId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"priceList", xtype:"gridcolumn", dataIndex:"priceList", width:150,editor:{xtype:"net.nan21.dnet.module.md.mm.price.lovs.PriceList" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priceListId"} ]} })
		.addTextColumn({ name:"name", dataIndex:"name", width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addNumberColumn({ name:"priceListId", dataIndex:"priceListId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$CtxView", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$CtxView",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",noEdit:true  ,maxLength:255  })
		.addTextField({ name:"priceList", dataIndex:"priceList",noEdit:true  ,maxLength:255  })
		.addDateField({ name:"validFrom", dataIndex:"validFrom",noEdit:true, hideTrigger:true })
		.addTextField({ name:"currency", dataIndex:"currency",noEdit:true  ,maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:220})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","priceList"])
		.addChildrenTo("col2",["validFrom","currency"])
;
	}	
});
 	
 	

Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$CopyProductsFromCategory", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$CopyProductsFromCategory",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"productCategory", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductCategories", paramIndex:"productCategory" ,retFieldMapping: [{lovField:"id", dsParam: "productCategoryId"} ]  })
		//containers
		.addPanel({ name:"main", layout:"form" , autoScroll:true})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["productCategory"])
;
	}	
});
 	
