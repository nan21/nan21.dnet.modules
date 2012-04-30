   

Ext.define("net.nan21.dnet.module.ad.system.dc.SysFrameExtension", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysFrameExtensionDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.SysFrameExtensionDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysFrameExtensionDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.system.dc.SysFrameExtension$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.system.dc.SysFrameExtension$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"frameFQN", dataIndex:"frameFQN",anchor:"-20",maxLength:255  })
		.addTextField({ name:"fileLocation", dataIndex:"fileLocation",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"relativePath", dataIndex:"relativePath",anchor:"-20"  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["frameFQN","fileLocation"])
		.addChildrenTo("col2",["relativePath","active"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.ad.system.dc.SysFrameExtension$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.system.dc.SysFrameExtension$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"frameFQN", dataIndex:"frameFQN",width:150,editor:{xtype:"textfield", selectOnFocus:true } })
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextColumn({ name:"fileLocation", dataIndex:"fileLocation",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"relativePath", dataIndex:"relativePath"})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
