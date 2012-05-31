   

Ext.define("net.nan21.dnet.module.ad.system.dc.UiViewState", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.UiViewStateDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.UiViewStateDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.UiViewStateDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.system.dc.UiViewState$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.system.dc.UiViewState$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"cmp", dataIndex:"cmp",anchor:"-20",maxLength:255  })
		.addCombo({ name:"cmpType", xtype:"combo", dataIndex:"cmpType",anchor:"-20",store:[ "frame-dcgrid", "frame-dcegrid"]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","cmpType"])
		.addChildrenTo("col2",["cmp"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.ad.system.dc.UiViewState$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.system.dc.UiViewState$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name", width:150 })   	
		.addTextColumn({ name:"cmpType", dataIndex:"cmpType", width:120 })   	
		.addTextColumn({ name:"cmp", dataIndex:"cmp", width:400 })   	
		.addTextColumn({ name:"stateValue", dataIndex:"stateValue", hidden:true,width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.ad.system.dc.UiViewState$ViewState", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.ad.system.dc.UiViewState$ViewState",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDisplayFieldText({ name:"stateValue", dataIndex:"stateValue"  })
		//containers
		.addPanel({ name:"main", layout:"form" , autoScroll:true, defaults:{
labelAlign:"top"}})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["stateValue"])
;
	}	
});
 	
