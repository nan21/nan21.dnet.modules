   

Ext.define("net.nan21.dnet.module.pj.base.dc.ProjectType", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.ProjectTypeDs",
	filterModel: "net.nan21.dnet.module.pj.base.ds.model.ProjectTypeDsFilter",
	paramModel: "net.nan21.dnet.module.pj.base.ds.param.ProjectTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.pj.base.dc.ProjectType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.base.dc.ProjectType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"category", xtype:"net.nan21.dnet.module.pj.base.lovs.ProjectCategories", dataIndex:"category",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
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
 	
 	 
Ext.define("net.nan21.dnet.module.pj.base.dc.ProjectType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.pj.base.dc.ProjectType$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"category", xtype:"gridcolumn", dataIndex:"category",width:120,editor:{xtype:"net.nan21.dnet.module.pj.base.lovs.ProjectCategories" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]} })
		.addTextColumn({ name:"name", dataIndex:"name", width:150,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});