   

Ext.define("net.nan21.dnet.module.fi.asset.dc.Amortization", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.fi.asset.ds.model.AmortizationDs",
	filterModel: "net.nan21.dnet.module.fi.asset.ds.model.AmortizationDsFilter",
	paramModel: "net.nan21.dnet.module.fi.asset.ds.param.AmortizationDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.fi.asset.dc.Amortization$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.fi.asset.dc.Amortization$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addCombo({ name:"periodType", xtype:"combo", dataIndex:"periodType",anchor:"-20",store:[ "month", "year"]  })
		.addLov({ name:"assetCategory", xtype:"net.nan21.dnet.module.fi.asset.lovs.AssetCategories", dataIndex:"assetCategory",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "assetCategoryId"} ]  })
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addDateField({ name:"postingDate_From", dataIndex:"postingDate_From", emptyText:"From" })
		.addDateField({ name:"postingDate_To", dataIndex:"postingDate_To", emptyText:"To" })
		.addFieldContainer({name: "postingDate", fieldLabel:"Posting Date"}) 
		.addChildrenTo("postingDate",["postingDate_From", "postingDate_To"]) 

		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:300}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["org","currency","periodType"])
		.addChildrenTo("col2",["assetCategory","postingDate"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.fi.asset.dc.Amortization$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.fi.asset.dc.Amortization$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"org", dataIndex:"org",width:100 })   	
		.addTextColumn({ name:"asset", dataIndex:"asset",width:100 })   	
		.addTextColumn({ name:"assetName", dataIndex:"assetName",width:200 })   	
		.addTextColumn({ name:"periodType", dataIndex:"periodType",width:60 })   	
		.addDateColumn({ name:"postingDate", dataIndex:"postingDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addNumberColumn({ name:"percentage", dataIndex:"percentage",decimals:2 })  
		.addNumberColumn({ name:"amount", dataIndex:"amount",decimals:2 })  
		.addNumberColumn({ name:"assetId", dataIndex:"assetId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.fi.asset.dc.Amortization$EditListCtxAsset", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.fi.asset.dc.Amortization$EditListCtxAsset",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addDateColumn({ name:"postingDate", dataIndex:"postingDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addNumberColumn({ name:"percentage", dataIndex:"percentage", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"amount", dataIndex:"amount", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })
		.addNumberColumn({ name:"assetId", dataIndex:"assetId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
