   

Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementType", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementTypeDs",
	filterModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementTypeDsFilter",
	paramModel: "net.nan21.dnet.module.bd.elem.ds.param.ElementTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.elem.dc.ElementType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"engine", xtype:"net.nan21.dnet.module.bd.elem.lovs.Engines", dataIndex:"engine",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "engineId"} ]  })
		.addLov({ name:"category", xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementCategories", dataIndex:"category",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "categoryId"} ],filterFieldMapping: [{lovField:"engineId", dsField: "engineId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form", width:170}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name"])
		.addChildrenTo("col2",["engine","category"])
		.addChildrenTo("col3",["active"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.elem.dc.ElementType$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"engine", xtype:"gridcolumn", dataIndex:"engine",width:120,editor:{xtype:"net.nan21.dnet.module.bd.elem.lovs.Engines" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "engineId"} ]} })
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false } })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addLov({name:"category", xtype:"gridcolumn", dataIndex:"category",width:120,editor:{xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementCategories" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "categoryId"} ],filterFieldMapping: [{lovField:"engineId", dsField: "engineId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
