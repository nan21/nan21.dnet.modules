   

Ext.define("net.nan21.dnet.module.hr.training.dc.CourseType", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.training.ds.model.CourseTypeDs",
	filterModel: "net.nan21.dnet.module.hr.training.ds.model.CourseTypeDsFilter",
	paramModel: "net.nan21.dnet.module.hr.training.ds.param.CourseTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.hr.training.dc.CourseType$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.training.dc.CourseType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"category", xtype:"net.nan21.dnet.module.hr.training.lovs.CourseCategories", dataIndex:"category",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","category"])
		.addChildrenTo("col2",["active"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.hr.training.dc.CourseType$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.training.dc.CourseType$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"category", xtype:"gridcolumn", dataIndex:"category",width:120,editor:{xtype:"net.nan21.dnet.module.hr.training.lovs.CourseCategories" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]} })
		.addTextColumn({ name:"name", dataIndex:"name", width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
