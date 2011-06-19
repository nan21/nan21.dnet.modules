   
Ext.ns('net.nan21.dnet.module.ad.org.dc');	 
net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"OrganizationHierarchy" 		 
			,ds: new net.nan21.dnet.module.ad.org.ds.OrganizationHierarchyDs()			  
		});
	 	net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.org.dc'); 
net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("active", { name:"active", xtype:"combo", mode: 'local',_rbkey_:"active", dataIndex:"active", id:Ext.id(), selectOnFocus:true, valueField: 'bv', displayField: 'tv',  store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true, width:70  });
		//containers
		this._elems_.add("main", { name:"main", layout:"hbox", id:Ext.id() , autoScroll:true, defaults:{labelAlign:"right",labelWidth:80,width:210 }}); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [
	    {layout:"form", border:false 
	      ,items:[ this._elems_.get("name")] }
	  ,	    {layout:"form", border:false 
	      ,items:[ this._elems_.get("active")] }
];
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$Filter", net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.org.dc');	 	 
net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:120 });   	
		this._columns_.add("startDate", { xtype:"datecolumn", dataIndex:"startDate", sortable:true, hidden:false,format:Ext.DATE_FORMAT});   	      	     
		this._columns_.add("endDate", { xtype:"datecolumn", dataIndex:"endDate", sortable:true, hidden:false,format:Ext.DATE_FORMAT});   	      	     
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("notes", { xtype:"gridcolumn",_rbkey_:"notes", dataIndex:"notes", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:true,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$List", net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$List ); 
 	
Ext.ns('net.nan21.dnet.module.ad.org.dc');	 	 
net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection() 
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:120,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} });
		this._columns_.add("startDate", { xtype:"datecolumn", dataIndex:"startDate", sortable:true, hidden:false,format:Ext.DATE_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("endDate", { xtype:"datecolumn", dataIndex:"endDate", sortable:true, hidden:false,format:Ext.DATE_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv', store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true }});
		this._columns_.add("notes", { xtype:"gridcolumn",_rbkey_:"notes", dataIndex:"notes", sortable:true, hidden:false,width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} });
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
	}  
});
Ext.reg("net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$EditList", net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$EditList ); 
 	
Ext.ns('net.nan21.dnet.module.ad.org.dc');	 
net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield",_rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("startDate", { name:"startDate", xtype:"datefield", dataIndex:"startDate", id:Ext.id(),width:100 ,allowBlank:false, labelSeparator:"*" ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("endDate", { name:"endDate", xtype:"datefield", dataIndex:"endDate", id:Ext.id(),width:100  ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("active", { name:"active", xtype:"checkbox", _rbkey_:"active", dataIndex:"active", id:Ext.id()  });
		this._elems_.add("notes", { name:"notes", xtype:"textarea", _rbkey_:"notes", dataIndex:"notes", id:Ext.id(),height:40,anchor:"-20"   });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:300,labelWidth:0 });     
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id() ,width:250,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("notes") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("startDate") ,this._elems_.get("endDate") ,this._elems_.get("active") ];
	}	
});
Ext.reg("net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$Edit", net.nan21.dnet.module.ad.org.dc.OrganizationHierarchy$Edit ); 
