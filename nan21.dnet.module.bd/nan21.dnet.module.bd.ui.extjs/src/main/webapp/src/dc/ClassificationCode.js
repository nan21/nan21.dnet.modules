   

Ext.define("net.nan21.dnet.module.bd.standards.dc.ClassificationCode", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.standards.ds.model.ClassificationCodeDs",
	filterModel: "net.nan21.dnet.module.bd.standards.ds.model.ClassificationCodeDsFilter",
	paramModel: "net.nan21.dnet.module.bd.standards.ds.param.ClassificationCodeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.standards.dc.ClassificationCode$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.standards.dc.ClassificationCode$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addTextField({ name:"notes",_sharedLabel_:true, dataIndex:"notes",anchor:"-20",maxLength:4000  })
		.addLov({ name:"classSystem", xtype:"net.nan21.dnet.module.bd.standards.lovs.ClassificationSystems", dataIndex:"classSystem",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "classSystemId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["classSystem","active"])
    	.addAuditFilter({})	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.standards.dc.ClassificationCode$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.standards.dc.ClassificationCode$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addLov({name:"classSystem", xtype:"gridcolumn", dataIndex:"classSystem",width:100,editor:{xtype:"net.nan21.dnet.module.bd.standards.lovs.ClassificationSystems" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "classSystemId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"classSystemId", dataIndex:"classSystemId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
