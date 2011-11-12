   

Ext.define("net.nan21.dnet.module.bp.md.dc.BpClassification", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bp.md.ds.model.BpClassificationDs",
	filterModel: "net.nan21.dnet.module.bp.md.ds.model.BpClassificationDsFilter",
	paramModel: "net.nan21.dnet.module.bp.md.ds.param.BpClassificationDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.bp.md.dc.BpClassification$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bp.md.dc.BpClassification$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"businessPartner", dataIndex:"businessPartner",anchor:"-20",maxLength:32  })
		.addTextField({ name:"classificationSystem", dataIndex:"classificationSystem",anchor:"-20",maxLength:32  })
		.addTextField({ name:"classificationCode", dataIndex:"classificationCode",anchor:"-20",maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["businessPartner"])
		.addChildrenTo("col2",["classificationSystem","classificationCode"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.bp.md.dc.BpClassification$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bp.md.dc.BpClassification$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"classificationSystem", xtype:"gridcolumn", dataIndex:"classificationSystem", width:150,editor:{xtype:"net.nan21.dnet.module.bd.standards.lovs.ClassificationSystems" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "classificationSystemId"} ],filterFieldMapping: [{lovField:"useInContext", dsField: "businessPartnerBO"} ]} })
		.addLov({name:"classificationCode", xtype:"gridcolumn", dataIndex:"classificationCode", width:150,editor:{xtype:"net.nan21.dnet.module.bd.standards.lovs.ClassificationCodes" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "classificationId"} ,{lovField:"name", dsField: "classificationName"} ],filterFieldMapping: [{lovField:"classSystemId", dsField: "classificationSystemId"} ]} })
		.addTextColumn({ name:"classificationName", dataIndex:"classificationName", width:300 })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"classSystemId", dataIndex:"classificationSystemId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"classCodeId", dataIndex:"classificationId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
