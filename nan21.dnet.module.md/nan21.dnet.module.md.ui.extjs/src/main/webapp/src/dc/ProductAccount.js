   

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccount", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountDs",
	filterModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.prod.ds.param.ProductAccountDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccount$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.ProductAccount$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"groupCode", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductAccountGroups", dataIndex:"groupCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "groupId"} ]  })
		.addTextField({ name:"productCode", dataIndex:"productCode",anchor:"-20",maxLength:32  })
		.addTextField({ name:"analiticSegment", dataIndex:"analiticSegment",anchor:"-20",maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["org","productCode"])
		.addChildrenTo("col2",["groupCode","analiticSegment"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccount$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.ProductAccount$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"org", xtype:"gridcolumn", dataIndex:"org",width:100,editor:{xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]} })
		.addLov({name:"groupCode", xtype:"gridcolumn", dataIndex:"groupCode",width:100,editor:{xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductAccountGroups" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "groupId"} ]} })
		.addTextColumn({ name:"productCode", dataIndex:"productCode",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addTextColumn({ name:"analiticSegment", dataIndex:"analiticSegment",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"groupId", dataIndex:"groupId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccount$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.ProductAccount$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"org", xtype:"gridcolumn", dataIndex:"org",width:100,editor:{xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]} })
		.addLov({name:"groupCode", xtype:"gridcolumn", dataIndex:"groupCode",width:100,editor:{xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductAccountGroups" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "groupId"} ]} })
		.addTextColumn({ name:"analiticSegment", dataIndex:"analiticSegment",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"groupId", dataIndex:"groupId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
