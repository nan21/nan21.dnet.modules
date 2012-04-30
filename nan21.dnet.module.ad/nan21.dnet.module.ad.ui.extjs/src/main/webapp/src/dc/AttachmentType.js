   

Ext.define("net.nan21.dnet.module.ad.data.dc.AttachmentType", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.data.ds.model.AttachmentTypeDs",
	filterModel: "net.nan21.dnet.module.ad.data.ds.model.AttachmentTypeDsFilter",
	paramModel: "net.nan21.dnet.module.ad.data.ds.param.AttachmentTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.data.dc.AttachmentType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.data.dc.AttachmentType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addCombo({ name:"category", xtype:"combo", dataIndex:"category",anchor:"-20",store:[ "image", "document"]  })
		.addTextField({ name:"useInContext", dataIndex:"useInContext",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","active"])
		.addChildrenTo("col2",["category","useInContext"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.ad.data.dc.AttachmentType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.data.dc.AttachmentType$EditList",
	
	_bulkEditFields_ : ["active","description","useInContext","category","uploadPath","baseUrl"],
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"useInContext", dataIndex:"useInContext",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addComboColumn({ name:"category", dataIndex:"category", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true 	, valueField: 'bv', displayField: 'tv' ,store:[ "image", "document"] , triggerAction:'all', forceSelection:true }})
		.addTextColumn({ name:"uploadPath", dataIndex:"uploadPath",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"baseUrl", dataIndex:"baseUrl",width:100,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
