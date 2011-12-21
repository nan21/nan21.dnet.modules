   

Ext.define("net.nan21.dnet.module.sd.opportunity.dc.OpportunityAttachment", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityAttachmentDs",
	filterModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityAttachmentDsFilter",
	paramModel: "net.nan21.dnet.module.sd.opportunity.ds.param.OpportunityAttachmentDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	
 	 
Ext.define("net.nan21.dnet.module.sd.opportunity.dc.OpportunityAttachment$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.sd.opportunity.dc.OpportunityAttachment$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"type", xtype:"gridcolumn", dataIndex:"type",width:120,editor:{xtype:"net.nan21.dnet.module.ad.data.lovs.AttachmentTypes" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ],filterFieldMapping: [{lovField:"useInContext",value: "Opportunity"} ]} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"location", dataIndex:"location",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"opportunityId", dataIndex:"opportunityId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
