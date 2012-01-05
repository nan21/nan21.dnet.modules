   

Ext.define("net.nan21.dnet.module.hr.time.dc.AbsenceType", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceTypeDs",
	filterModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceTypeDsFilter",
	paramModel: "net.nan21.dnet.module.hr.time.ds.param.AbsenceTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.hr.time.dc.AbsenceType$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.time.dc.AbsenceType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addLov({ name:"category", xtype:"net.nan21.dnet.module.hr.time.lovs.AbsenceCategories", dataIndex:"category",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["name","category"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.hr.time.dc.AbsenceType$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.time.dc.AbsenceType$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addLov({name:"category", xtype:"gridcolumn", dataIndex:"category",width:120,editor:{xtype:"net.nan21.dnet.module.hr.time.lovs.AbsenceCategories" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
