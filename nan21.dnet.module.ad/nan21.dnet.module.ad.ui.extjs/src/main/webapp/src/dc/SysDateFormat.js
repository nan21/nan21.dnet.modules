   

Ext.define("net.nan21.dnet.module.ad.system.dc.SysDateFormat", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysDateFormatDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.SysDateFormatDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysDateFormatDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.system.dc.SysDateFormat$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.system.dc.SysDateFormat$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["name","active"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.ad.system.dc.SysDateFormat$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.system.dc.SysDateFormat$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_bulkEditFields_ : ["active","extjsDateFormat","extjsTimeFormat","extjsDateTimeFormat","extjsAltFormats","javaDateFormat","javaTimeFormat","javaDateTimeFormat"]
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"extjsDateFormat", dataIndex:"extjsDateFormat", width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"extjsTimeFormat", dataIndex:"extjsTimeFormat", width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"extjsDateTimeFormat", dataIndex:"extjsDateTimeFormat", width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"extjsAltFormats", dataIndex:"extjsAltFormats", width:150,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addTextColumn({ name:"javaDateFormat", dataIndex:"javaDateFormat", width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"javaTimeFormat", dataIndex:"javaTimeFormat", width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"javaDateTimeFormat", dataIndex:"javaDateTimeFormat", width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
	  	.addDefaults()
	  ;  		   
	}  
});
