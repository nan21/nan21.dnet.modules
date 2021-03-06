   

Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchyItem", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemDs",
	filterModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemDsFilter",
	paramModel: "net.nan21.dnet.module.bd.org.ds.param.OrganizationHierarchyItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchyItem$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.org.dc.OrganizationHierarchyItem$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"org", xtype:"gridcolumn", dataIndex:"org",width:100,editor:{xtype:"net.nan21.dnet.module.bd.org.lovs.Organizations" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]} })
		.addNumberColumn({ name:"parentId", dataIndex:"parentId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"parentCode", xtype:"gridcolumn", dataIndex:"parentCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.org.lovs.OrganizationHierarchyItems" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"orgId", dsField: "parentId"} ],filterFieldMapping: [{lovField:"hierarchyId", dsField: "hierarchyId"} ]} })
		.addNumberColumn({ name:"hierarchyId", dataIndex:"hierarchyId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	
Ext.define("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchyItem$TreeView", {
	extend: "dnet.core.dc.AbstractDcvTree",
	alias: "widget.net.nan21.dnet.module.bd.org.dc.OrganizationHierarchyItem$TreeView",
 
	_defineColumns_: function () {		
	  		   
	}
});
