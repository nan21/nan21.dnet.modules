   

Ext.define("net.nan21.dnet.module.fi.asset.dc.AmortizationItem", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.fi.asset.ds.model.AmortizationItemDs",
	filterModel: "net.nan21.dnet.module.fi.asset.ds.model.AmortizationItemDsFilter",
	paramModel: "net.nan21.dnet.module.fi.asset.ds.param.AmortizationItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.fi.asset.dc.AmortizationItem$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.fi.asset.dc.AmortizationItem$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"asset", dataIndex:"asset",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addNumberColumn({ name:"amount", dataIndex:"amount", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"percentage", dataIndex:"percentage", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"assetId", dataIndex:"assetId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
