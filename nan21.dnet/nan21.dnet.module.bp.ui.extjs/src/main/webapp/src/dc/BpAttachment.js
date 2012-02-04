   

Ext.define("net.nan21.dnet.module.bp.md.dc.BpAttachment", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bp.md.ds.model.BpAttachmentDs",
	filterModel: "net.nan21.dnet.module.bp.md.ds.model.BpAttachmentDsFilter",
	paramModel: "net.nan21.dnet.module.bp.md.ds.param.BpAttachmentDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bp.md.dc.BpAttachment$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bp.md.dc.BpAttachment$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"businessPartner", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartnersCode", dataIndex:"businessPartner",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "businessPartnerId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.ad.data.lovs.AttachmentTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ],filterFieldMapping: [{lovField:"useInContext", dsField: "businessPartnerBO"} ]  })
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"location", dataIndex:"location",anchor:"-20",maxLength:400  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:280}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["businessPartner","type"])
		.addChildrenTo("col2",["name","location"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.bp.md.dc.BpAttachment$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bp.md.dc.BpAttachment$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"businessPartner", dataIndex:"businessPartner", hidden:true,width:100 })
		.addLov({name:"type", xtype:"gridcolumn", dataIndex:"type",width:120,editor:{xtype:"net.nan21.dnet.module.ad.data.lovs.AttachmentTypes" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ],filterFieldMapping: [{lovField:"useInContext", dsField: "businessPartnerBO"} ]} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"location", dataIndex:"location",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"businessPartnerId", dataIndex:"businessPartnerId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
 	
 	 
Ext.define("net.nan21.dnet.module.bp.md.dc.BpAttachment$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bp.md.dc.BpAttachment$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"businessPartner", xtype:"gridcolumn", dataIndex:"businessPartner", width:150,editor:{xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartnersCode" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "businessPartnerId"} ]} })
		.addLov({name:"type", xtype:"gridcolumn", dataIndex:"type",width:120,editor:{xtype:"net.nan21.dnet.module.ad.data.lovs.AttachmentTypes" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ],filterFieldMapping: [{lovField:"useInContext", dsField: "businessPartnerBO"} ]} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"location", dataIndex:"location",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"businessPartnerId", dataIndex:"businessPartnerId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
