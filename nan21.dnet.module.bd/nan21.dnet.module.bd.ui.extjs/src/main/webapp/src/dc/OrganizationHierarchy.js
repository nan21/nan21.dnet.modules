   
Ext.ns('net.nan21.dnet.module.bd.org.dc');	 
net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"OrganizationHierarchy" 		 
			,ds: new net.nan21.dnet.module.bd.org.ds.OrganizationHierarchyDs()			  
		});
	 	net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bd.org.dc'); 
net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active"  })
		//containers
		.addPanel({ name:"main", layout:"hbox", autoScroll:true, defaults:{labelAlign:"right",labelWidth:80,width:210 }})
		; 
	}
	,_linkElements_: function () {
		this._getBuilder_()
		this._elems_.get("main")["items"] = [
	    {layout:"form", border:false 
	      ,items:[ this._elems_.get("name")] }
	  ,	    {layout:"form", border:false 
	      ,items:[ this._elems_.get("active")] }
];
;
	}
}); 
Ext.reg("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$Filter", net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bd.org.dc');	 	 
net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Ext.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Ext.DATE_FORMAT})   	      	     
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$List", net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$List ); 
 	
Ext.ns('net.nan21.dnet.module.bd.org.dc');	 	 
net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Ext.DATE_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Ext.DATE_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})

		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70 ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$EditList", net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$EditList ); 
 	
Ext.ns('net.nan21.dnet.module.bd.org.dc');	 
net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addDateField({ name:"startDate", dataIndex:"startDate",width:100 ,allowBlank:false})
		.addDateField({ name:"endDate", dataIndex:"endDate",width:100 })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:40,anchor:"-20"   })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" ,width:250,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","notes"])
		.addChildrenTo("col2",["startDate","endDate","active"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$Edit", net.nan21.dnet.module.bd.org.dc.OrganizationHierarchy$Edit ); 