   
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
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"hierarchyId", dataIndex:"hierarchyId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"organizationId", dataIndex:"organizationId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addLov({name:"organizationCode", xtype:"gridcolumn", dataIndex:"organizationCode",width:100,editor:{xtype:"net.nan21.dnet.module.ad.org.lovs.Organizations" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]} })
		.addNumberColumn({ name:"parentId", dataIndex:"parentId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addLov({name:"parentCode", xtype:"gridcolumn", dataIndex:"parentCode",width:100,editor:{xtype:"net.nan21.dnet.module.ad.org.lovs.OrganizationHierarchyItems" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"organizationId", dsField: "parentId"} ],filterFieldMapping: [{lovField:"hierarchyId", dsField: "hierarchyId"} ]} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
	  ;  		   
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
