   
Ext.ns('net.nan21.dnet.module.ad.org.dc');	 
net.nan21.dnet.module.ad.org.dc.OrganizationHierarchyItem = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"OrganizationHierarchyItem" 		 
			,ds: new net.nan21.dnet.module.ad.org.ds.OrganizationHierarchyItemDs()			  
		});
	 	net.nan21.dnet.module.ad.org.dc.OrganizationHierarchyItem.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.org.dc');	 	 
net.nan21.dnet.module.ad.org.dc.OrganizationHierarchyItem$CtxEditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection() 
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("hierarchyId", { xtype:"numbercolumn", dataIndex:"hierarchyId", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("organizationId", { xtype:"numbercolumn", dataIndex:"organizationId", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("organizationCode", { xtype:"gridcolumn", dataIndex:"organizationCode", sortable:true, hidden:false,width:100,editor:{xtype:"net.nan21.dnet.module.ad.org.lovs.Organizations" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]} });
		this._columns_.add("parentId", { xtype:"numbercolumn", dataIndex:"parentId", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("parentCode", { xtype:"gridcolumn", dataIndex:"parentCode", sortable:true, hidden:false,width:100,editor:{xtype:"net.nan21.dnet.module.ad.org.lovs.OrganizationHierarchyItems" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"organizationId", dsField: "parentId"} ],filterFieldMapping: [{lovField:"hierarchyId", dsField: "hierarchyId"} ]} });
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
	}  
});
Ext.reg("net.nan21.dnet.module.ad.org.dc.OrganizationHierarchyItem$CtxEditList", net.nan21.dnet.module.ad.org.dc.OrganizationHierarchyItem$CtxEditList ); 
 	
Ext.ns('net.nan21.dnet.module.ad.org.dc');	 
net.nan21.dnet.module.ad.org.dc.OrganizationHierarchyItem$TreeView = Ext.extend(dnet.base.AbstractDcvTree, {
 	 
	_controller_: null 
	 
	,_defineColumns_: function () {		
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.org.dc.OrganizationHierarchyItem$TreeView", net.nan21.dnet.module.ad.org.dc.OrganizationHierarchyItem$TreeView ); 
