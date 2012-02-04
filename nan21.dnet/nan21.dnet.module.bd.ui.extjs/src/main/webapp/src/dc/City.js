   

Ext.define("net.nan21.dnet.module.bd.geo.dc.City", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.CityDs",
	filterModel: "net.nan21.dnet.module.bd.geo.ds.model.CityDsFilter",
	paramModel: "net.nan21.dnet.module.bd.geo.ds.param.CityDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.geo.dc.City$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.geo.dc.City$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addNumberField({ name:"countryId", dataIndex:"countryId",anchor:"-20"  })
		.addLov({ name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name"])
		.addChildrenTo("col2",["countryCode"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.bd.geo.dc.City$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bd.geo.dc.City$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
		.addNumberColumn({ name:"countryId", dataIndex:"countryId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"countryCode", dataIndex:"countryCode",width:100 })   	
		.addNumberColumn({ name:"regionId", dataIndex:"regionId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"regionCode", dataIndex:"regionCode",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	 
Ext.define("net.nan21.dnet.module.bd.geo.dc.City$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.geo.dc.City$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addNumberColumn({ name:"countryId", dataIndex:"countryId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"regionId", dataIndex:"regionId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
