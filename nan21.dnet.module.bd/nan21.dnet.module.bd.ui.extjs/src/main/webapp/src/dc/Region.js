   
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 
net.nan21.dnet.module.bd.geo.dc.Region = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Region" 		 
			,ds: new net.nan21.dnet.module.bd.geo.ds.RegionDs()			  
		});
	 	net.nan21.dnet.module.bd.geo.dc.Region.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc'); 
net.nan21.dnet.module.bd.geo.dc.Region$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("code", { name:"code", xtype:"textfield", _rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("iso", { name:"iso", xtype:"textfield", dataIndex:"iso", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("countryId", { name:"countryId", xtype:"numberfield", dataIndex:"countryId", id:Ext.id(),anchor:"-20" , style: "text-align:right;" });
		this._elems_.add("countryCode", { name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("code") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("countryCode") ,this._elems_.get("iso") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Region$Filter", net.nan21.dnet.module.bd.geo.dc.Region$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 	 
net.nan21.dnet.module.bd.geo.dc.Region$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("code", { xtype:"gridcolumn",_rbkey_:"code", dataIndex:"code", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("iso", { xtype:"gridcolumn", dataIndex:"iso", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("countryId", { xtype:"numbercolumn", dataIndex:"countryId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("countryCode", { xtype:"gridcolumn", dataIndex:"countryCode", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("notes", { xtype:"gridcolumn",_rbkey_:"notes", dataIndex:"notes", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Region$List", net.nan21.dnet.module.bd.geo.dc.Region$List ); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 	 
net.nan21.dnet.module.bd.geo.dc.Region$EditListContext = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection() 
	,_controller_: null 
	,_noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} });
		this._columns_.add("code", { xtype:"gridcolumn",_rbkey_:"code", dataIndex:"code", sortable:true, hidden:false,width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"} });
		this._columns_.add("iso", { xtype:"gridcolumn", dataIndex:"iso", sortable:true, hidden:false,width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"} });
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv', store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true }});
		this._columns_.add("notes", { xtype:"gridcolumn",_rbkey_:"notes", dataIndex:"notes", sortable:true, hidden:false,width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} });
		this._columns_.add("countryId", { xtype:"numbercolumn", dataIndex:"countryId", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
	}  
});
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Region$EditListContext", net.nan21.dnet.module.bd.geo.dc.Region$EditListContext ); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 	 
net.nan21.dnet.module.bd.geo.dc.Region$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection() 
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("countryCode", { xtype:"gridcolumn", dataIndex:"countryCode", sortable:true, hidden:false, width:150,editor:{xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "countryId"} ]} });
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} });
		this._columns_.add("code", { xtype:"gridcolumn",_rbkey_:"code", dataIndex:"code", sortable:true, hidden:false,width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"} });
		this._columns_.add("iso", { xtype:"gridcolumn", dataIndex:"iso", sortable:true, hidden:false,width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"} });
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv', store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true }});
		this._columns_.add("notes", { xtype:"gridcolumn",_rbkey_:"notes", dataIndex:"notes", sortable:true, hidden:false,width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} });
		this._columns_.add("countryId", { xtype:"numbercolumn", dataIndex:"countryId", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
	}  
});
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Region$EditList", net.nan21.dnet.module.bd.geo.dc.Region$EditList ); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 
net.nan21.dnet.module.bd.geo.dc.Region$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield",_rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("code", { name:"code", xtype:"textfield",_rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("notes", { name:"notes", xtype:"textarea", _rbkey_:"notes", dataIndex:"notes", id:Ext.id(),height:60,anchor:"-20"   });
		this._elems_.add("iso", { name:"iso", xtype:"textfield", dataIndex:"iso", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("active", { name:"active", xtype:"checkbox", _rbkey_:"active", dataIndex:"active", id:Ext.id()  });
		this._elems_.add("countryId", { name:"countryId", xtype:"numberfield", dataIndex:"countryId", id:Ext.id(),anchor:"-20",disabled:true   , style: "text-align:right;" });
		this._elems_.add("countryCode", { name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  });
		this._elems_.add("modifiedAt", { name:"modifiedAt", xtype:"datefield", _rbkey_:"modifiedAt", dataIndex:"modifiedAt", id:Ext.id(),width:100,disabled:true  ,allowBlank:false, labelSeparator:"*" ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("modifiedBy", { name:"modifiedBy", xtype:"textfield",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", id:Ext.id(),anchor:"-20",disabled:true  ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:300,labelWidth:0 });     
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id() , width:250,labelWidth:0 });     
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id() , width:300,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("code") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("countryCode") ,this._elems_.get("iso") ,this._elems_.get("active") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("notes") ];
	}	
});
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Region$Edit", net.nan21.dnet.module.bd.geo.dc.Region$Edit ); 
