   

Ext.define("net.nan21.dnet.module.pj.md.dc.ItemLink", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ItemLinkDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.ItemLinkDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.ItemLinkDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.ItemLink$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.ItemLink$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"sourceItem", dataIndex:"sourceItem",anchor:"-20",maxLength:255  })
		.addTextField({ name:"targetItem", dataIndex:"targetItem",anchor:"-20",maxLength:255  })
		.addNumberField({ name:"linkTypeId", dataIndex:"linkTypeId",anchor:"-20"  })
		.addTextField({ name:"linkType", dataIndex:"linkType",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["sourceItem","targetItem","linkType"])
		.addChildrenTo("col2",["sourceItem","targetItem","linkType"])
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.pj.md.dc.ItemLink$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.ItemLink$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
		.addNumberColumn({ name:"sourceItemId", dataIndex:"sourceItemId", hidden:true, align:"right",format:"0",width:70})
		.addTextColumn({ name:"sourceItem", dataIndex:"sourceItem",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addNumberColumn({ name:"targetItemId", dataIndex:"targetItemId", hidden:true, align:"right",format:"0",width:70})
		.addTextColumn({ name:"targetItem", dataIndex:"targetItem",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addNumberColumn({ name:"linkTypeId", dataIndex:"linkTypeId", hidden:true, align:"right",format:"0",width:70})
		.addTextColumn({ name:"linkType", dataIndex:"linkType",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
	  ;  		   
	}  
});
