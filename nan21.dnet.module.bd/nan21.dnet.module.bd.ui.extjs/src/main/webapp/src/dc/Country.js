   
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 
net.nan21.dnet.module.bd.geo.dc.Country = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Country" 		 
			,ds: new net.nan21.dnet.module.bd.geo.ds.CountryDs()			  
		});
	 	net.nan21.dnet.module.bd.geo.dc.Country.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc'); 
net.nan21.dnet.module.bd.geo.dc.Country$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("code", { name:"code", xtype:"textfield", _rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("iso2", { name:"iso2", xtype:"textfield", dataIndex:"iso2", id:Ext.id(),anchor:"-20",maxLength:2,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "2"},caseRestriction:"uppercase",style: "text-transform:uppercase;"  });
		this._elems_.add("iso3", { name:"iso3", xtype:"textfield", dataIndex:"iso3", id:Ext.id(),anchor:"-20",maxLength:3,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "3"},caseRestriction:"uppercase",style: "text-transform:uppercase;"  });
		this._elems_.add("active", { name:"active", xtype:"combo", mode: 'local',_rbkey_:"active", dataIndex:"active", id:Ext.id(), selectOnFocus:true, valueField: 'bv', displayField: 'tv',  store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true, width:70  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col4", { name:"col4", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col4") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("code") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("iso2") ,this._elems_.get("iso3") ];
		this._elems_.get("col4")["items"] = [this._elems_.get("active") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Country$Filter", net.nan21.dnet.module.bd.geo.dc.Country$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 	 
net.nan21.dnet.module.bd.geo.dc.Country$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("code", { xtype:"gridcolumn",_rbkey_:"code", dataIndex:"code", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("iso2", { xtype:"gridcolumn", dataIndex:"iso2", sortable:true, hidden:false,width:50 });   	
		this._columns_.add("iso3", { xtype:"gridcolumn", dataIndex:"iso3", sortable:true, hidden:false,width:50 });   	
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("notes", { xtype:"gridcolumn",_rbkey_:"notes", dataIndex:"notes", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("hasRegions", { xtype:"booleancolumn", dataIndex:"hasRegions", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Country$List", net.nan21.dnet.module.bd.geo.dc.Country$List ); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 	 
net.nan21.dnet.module.bd.geo.dc.Country$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection() 
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("code", { xtype:"gridcolumn",_rbkey_:"code", dataIndex:"code", sortable:true, hidden:false,width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"} });
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} });
		this._columns_.add("iso2", { xtype:"gridcolumn", dataIndex:"iso2", sortable:true, hidden:false,width:50,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:2,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "2"},caseRestriction:"uppercase",style: "text-transform:uppercase;",vtype:"alphanum"} });
		this._columns_.add("iso3", { xtype:"gridcolumn", dataIndex:"iso3", sortable:true, hidden:false,width:50,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:3,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "3"},caseRestriction:"uppercase",style: "text-transform:uppercase;",vtype:"alphanum"} });
		this._columns_.add("hasRegions", { xtype:"booleancolumn", dataIndex:"hasRegions", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv', store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true }});
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv', store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true }});
		this._columns_.add("notes", { xtype:"gridcolumn",_rbkey_:"notes", dataIndex:"notes", sortable:true, hidden:false,width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} });
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
	}  
});
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Country$EditList", net.nan21.dnet.module.bd.geo.dc.Country$EditList ); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 
net.nan21.dnet.module.bd.geo.dc.Country$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("code", { name:"code", xtype:"textfield",_rbkey_:"code", dataIndex:"code", id:Ext.id(), width:200 ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("name", { name:"name", xtype:"textfield",_rbkey_:"name", dataIndex:"name", id:Ext.id(), width:200 ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("notes", { name:"notes", xtype:"textarea", _rbkey_:"notes", dataIndex:"notes", id:Ext.id(),height:40, width:200   });
		this._elems_.add("active", { name:"active", xtype:"checkbox", _rbkey_:"active", dataIndex:"active", id:Ext.id()  });
		this._elems_.add("hasRegions", { name:"hasRegions", xtype:"checkbox", dataIndex:"hasRegions", id:Ext.id()  });
		this._elems_.add("iso2", { name:"iso2", xtype:"textfield", dataIndex:"iso2", id:Ext.id(),anchor:"-20" ,maxLength:2,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "2"},caseRestriction:"uppercase",style: "text-transform:uppercase;",vtype:"alphanum"  });
		this._elems_.add("iso3", { name:"iso3", xtype:"textfield", dataIndex:"iso3", id:Ext.id(),anchor:"-20" ,maxLength:3,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "3"},caseRestriction:"uppercase",style: "text-transform:uppercase;",vtype:"alphanum"  });
		this._elems_.add("createdAt", { name:"createdAt", xtype:"datefield", _rbkey_:"createdAt", dataIndex:"createdAt", id:Ext.id(),width:100,disabled:true  ,allowBlank:false, labelSeparator:"*" ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("modifiedAt", { name:"modifiedAt", xtype:"datefield", _rbkey_:"modifiedAt", dataIndex:"modifiedAt", id:Ext.id(),width:100,disabled:true  ,allowBlank:false, labelSeparator:"*" ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("createdBy", { name:"createdBy", xtype:"textfield",_rbkey_:"createdBy", dataIndex:"createdBy", id:Ext.id(),anchor:"-20",disabled:true  ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("modifiedBy", { name:"modifiedBy", xtype:"textfield",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", id:Ext.id(),anchor:"-20",disabled:true  ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:350,labelWidth:0 });     
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id() , width:220,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("code") ,this._elems_.get("notes") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("iso2") ,this._elems_.get("iso3") ,this._elems_.get("active") ,this._elems_.get("hasRegions") ];
	}	
});
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Country$Edit", net.nan21.dnet.module.bd.geo.dc.Country$Edit ); 
