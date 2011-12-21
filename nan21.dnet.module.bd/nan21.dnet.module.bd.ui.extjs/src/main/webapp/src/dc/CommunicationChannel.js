   

Ext.define("net.nan21.dnet.module.bd.contact.dc.CommunicationChannel", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelDs",
	filterModel: "net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelDsFilter",
	paramModel: "net.nan21.dnet.module.bd.contact.ds.param.CommunicationChannelDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	
 	 
Ext.define("net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"type", xtype:"gridcolumn", dataIndex:"type",width:120,editor:{xtype:"net.nan21.dnet.module.bd.contact.lovs.CommunicationChannelTypes" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]} })
		.addTextColumn({ name:"value", dataIndex:"value",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"validTo", dataIndex:"validTo",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
