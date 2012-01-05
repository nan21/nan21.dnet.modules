   

Ext.define("net.nan21.dnet.module.mm.md.dc.ProdClassification", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProdClassificationDs",
	filterModel: "net.nan21.dnet.module.mm.md.ds.model.ProdClassificationDsFilter",
	paramModel: "net.nan21.dnet.module.mm.md.ds.param.ProdClassificationDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.md.dc.ProdClassification$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.md.dc.ProdClassification$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"productCode", dataIndex:"productCode",anchor:"-20",maxLength:32  })
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
		.addChildrenTo("col1",["productCode"])
		.addChildrenTo("col2",["classificationSystem","classificationCode"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.mm.md.dc.ProdClassification$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.mm.md.dc.ProdClassification$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"classificationSystem", xtype:"gridcolumn", dataIndex:"classificationSystem", width:150,editor:{xtype:"net.nan21.dnet.module.bd.standards.lovs.ClassificationSystems" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "classificationSystemId"} ],filterFieldMapping: [{lovField:"useInContext",value: "Product"} ]} })
		.addLov({name:"classificationCode", xtype:"gridcolumn", dataIndex:"classificationCode", width:150,editor:{xtype:"net.nan21.dnet.module.bd.standards.lovs.ClassificationCodes" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "classificationId"} ,{lovField:"name", dsField: "classificationName"} ],filterFieldMapping: [{lovField:"classSystemId", dsField: "classificationSystemId"} ]} })
		.addTextColumn({ name:"classificationName", dataIndex:"classificationName", width:300 })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"classSystemId", dataIndex:"classificationSystemId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"classCodeId", dataIndex:"classificationId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
