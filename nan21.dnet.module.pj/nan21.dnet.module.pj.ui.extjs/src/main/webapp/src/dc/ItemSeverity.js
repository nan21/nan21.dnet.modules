   

Ext.define("net.nan21.dnet.module.pj.base.dc.ItemSeverity", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.ItemSeverityDs",
	filterModel: "net.nan21.dnet.module.pj.base.ds.model.ItemSeverityDsFilter",
	paramModel: "net.nan21.dnet.module.pj.base.ds.param.ItemSeverityDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.pj.base.dc.ItemSeverity$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.base.dc.ItemSeverity$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addTextField({ name:"description",_sharedLabel_:true, dataIndex:"description",anchor:"-20",maxLength:400  })
		.addNumberField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20"  })
		.addDateField({ name:"createdAt",_sharedLabel_:true, dataIndex:"createdAt",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"modifiedAt",_sharedLabel_:true, dataIndex:"modifiedAt",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addTextField({ name:"createdBy",_sharedLabel_:true, dataIndex:"createdBy",anchor:"-20",maxLength:32  })
		.addTextField({ name:"modifiedBy",_sharedLabel_:true, dataIndex:"modifiedBy",anchor:"-20",maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","description","createdBy","modifiedBy"])
		.addChildrenTo("col2",["name","description","createdBy","modifiedBy"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.pj.base.dc.ItemSeverity$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.pj.base.dc.ItemSeverity$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"sortValue", dataIndex:"sortValue", align:"right",format:Ext.NUMBER_FORMAT_INT,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addTextColumn({ name:"name", dataIndex:"name", width:150,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
	  ;  		   
	}  
});
