   

Ext.define("net.nan21.dnet.module.fi.asset.dc.AssetAcct", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.fi.asset.ds.model.AssetAcctDs",
	filterModel: "net.nan21.dnet.module.fi.asset.ds.model.AssetAcctDsFilter",
	paramModel: "net.nan21.dnet.module.fi.asset.ds.param.AssetAcctDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.fi.asset.dc.AssetAcct$EditListCtx", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.fi.asset.dc.AssetAcct$EditListCtx",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accSchema", xtype:"gridcolumn", dataIndex:"accSchema",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.AccSchemas" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]} })
		.addLov({name:"deprecAccount", xtype:"gridcolumn", dataIndex:"deprecAccount",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "deprecAccountId"} ]} })
		.addLov({name:"acmlDeprecAccount", xtype:"gridcolumn", dataIndex:"acmlDeprecAccount",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.Accounts" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "acmlDeprecAccountId"} ]} })
		.addNumberColumn({ name:"assetId", dataIndex:"assetId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"deprecAccountId", dataIndex:"deprecAccountId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"acmlDeprecAccountId", dataIndex:"acmlDeprecAccountId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
