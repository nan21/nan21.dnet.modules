   

Ext.define("net.nan21.dnet.module.bd.standards.dc.ClassificationCode", {
	extend: "dnet.base.AbstractDc",
 
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
	extend: "dnet.base.AbstractDcvFilterForm",
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
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["classSystem","active"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.bd.standards.dc.ClassificationCode$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.standards.dc.ClassificationCode$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addLov({name:"classSystem", xtype:"gridcolumn", dataIndex:"classSystem",width:100,editor:{xtype:"net.nan21.dnet.module.bd.standards.lovs.ClassificationSystems" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "classSystemId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"classSystemId", dataIndex:"classSystemId", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
