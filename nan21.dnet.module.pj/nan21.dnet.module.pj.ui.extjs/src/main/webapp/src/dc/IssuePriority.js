   

Ext.define("net.nan21.dnet.module.pj.base.dc.IssuePriority", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssuePriorityDs",
	filterModel: "net.nan21.dnet.module.pj.base.ds.model.IssuePriorityDsFilter",
	paramModel: "net.nan21.dnet.module.pj.base.ds.param.IssuePriorityDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.pj.base.dc.IssuePriority$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.base.dc.IssuePriority$Filter",
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
 	
 	 
Ext.define("net.nan21.dnet.module.pj.base.dc.IssuePriority$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.pj.base.dc.IssuePriority$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextColumn({ name:"name", dataIndex:"name", width:150,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:400} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
