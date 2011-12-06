   

Ext.define("net.nan21.dnet.module.mm.price.dc.ProductPrice", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.price.ds.model.ProductPriceDs",
	filterModel: "net.nan21.dnet.module.mm.price.ds.model.ProductPriceDsFilter",
	paramModel: "net.nan21.dnet.module.mm.price.ds.param.ProductPriceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.price.dc.ProductPrice$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.price.dc.ProductPrice$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addNumberField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20"  })
		.addDateField({ name:"createdAt",_sharedLabel_:true, dataIndex:"createdAt",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"modifiedAt",_sharedLabel_:true, dataIndex:"modifiedAt",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addTextField({ name:"createdBy",_sharedLabel_:true, dataIndex:"createdBy",anchor:"-20",maxLength:32  })
		.addTextField({ name:"modifiedBy",_sharedLabel_:true, dataIndex:"modifiedBy",anchor:"-20",maxLength:32  })
		.addNumberField({ name:"priceListId", dataIndex:"priceListId",anchor:"-20"  })
		.addNumberField({ name:"productId", dataIndex:"productId",anchor:"-20"  })
		.addTextField({ name:"product", dataIndex:"product",anchor:"-20",maxLength:32  })
		.addTextField({ name:"productName", dataIndex:"productName",anchor:"-20",maxLength:255  })
		.addNumberField({ name:"price", dataIndex:"price",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["createdBy","modifiedBy","product","productName"])
		.addChildrenTo("col2",["createdBy","modifiedBy","product","productName"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.mm.price.dc.ProductPrice$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.price.dc.ProductPrice$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"priceListId", dataIndex:"priceListId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70})
		.addTextColumn({ name:"product", dataIndex:"product",width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"productName", dataIndex:"productName",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addNumberColumn({ name:"price", dataIndex:"price", align:"right",format:Ext.NUMBER_FORMAT_DEC,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
	  ;  		   
	}  
});
