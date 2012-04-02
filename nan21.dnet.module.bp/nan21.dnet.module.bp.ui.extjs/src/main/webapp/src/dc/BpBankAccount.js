   

Ext.define("net.nan21.dnet.module.bp.md.dc.BpBankAccount", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bp.md.ds.model.BpBankAccountDs",
	filterModel: "net.nan21.dnet.module.bp.md.ds.model.BpBankAccountDsFilter",
	paramModel: "net.nan21.dnet.module.bp.md.ds.param.BpBankAccountDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.bp.md.dc.BpBankAccount$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bp.md.dc.BpBankAccount$CtxEditList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"bpartnerCode", dataIndex:"bpartnerCode", hidden:true,width:100 })
		.addLov({name:"bankCode", xtype:"gridcolumn", dataIndex:"bankCode",width:100,editor:{xtype:"net.nan21.dnet.module.bp.base.lovs.Banks" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "bankId"} ]} })
		.addTextColumn({ name:"bankBranch", dataIndex:"bankBranch",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addLov({name:"currencyCode", xtype:"gridcolumn", dataIndex:"currencyCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]} })
		.addTextColumn({ name:"accountNo", dataIndex:"accountNo",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addBooleanColumn({ name:"ibanAccount", dataIndex:"ibanAccount"})
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"bpartnerId", dataIndex:"bpartnerId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"bankId", dataIndex:"bankId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
