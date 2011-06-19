   
Ext.ns('net.nan21.dnet.module.ad.usr.dc');	 
net.nan21.dnet.module.ad.usr.dc.User = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"User" 		 
			,ds: new net.nan21.dnet.module.ad.usr.ds.UserDs()			  
		});
	 	net.nan21.dnet.module.ad.usr.dc.User.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.usr.dc'); 
net.nan21.dnet.module.ad.usr.dc.User$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("code", { name:"code", xtype:"textfield", _rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("active", { name:"active", xtype:"combo", mode: 'local',_rbkey_:"active", dataIndex:"active", id:Ext.id(), selectOnFocus:true, valueField: 'bv', displayField: 'tv',  store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true, width:70  });
		this._elems_.add("locked", { name:"locked", xtype:"combo", mode: 'local', dataIndex:"locked", id:Ext.id(), selectOnFocus:true, valueField: 'bv', displayField: 'tv',  store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true, width:70  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("code") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("active") ,this._elems_.get("locked") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.usr.dc.User$Filter", net.nan21.dnet.module.ad.usr.dc.User$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.usr.dc');	 	 
net.nan21.dnet.module.ad.usr.dc.User$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("code", { xtype:"gridcolumn",_rbkey_:"code", dataIndex:"code", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("locked", { xtype:"booleancolumn", dataIndex:"locked", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("accountType", { xtype:"gridcolumn", dataIndex:"accountType", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("notes", { xtype:"gridcolumn",_rbkey_:"notes", dataIndex:"notes", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.usr.dc.User$List", net.nan21.dnet.module.ad.usr.dc.User$List ); 
 	
Ext.ns('net.nan21.dnet.module.ad.usr.dc');	 
net.nan21.dnet.module.ad.usr.dc.User$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("code", { name:"code", xtype:"textfield",_rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("name", { name:"name", xtype:"textfield",_rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("accountType", { name:"accountType", xtype:"combo", dataIndex:"accountType", id:Ext.id(),anchor:"-20",allowBlank:false, labelSeparator:"*",store:[ "Employee"]  });
		this._elems_.add("notes", { name:"notes", xtype:"textarea", _rbkey_:"notes", dataIndex:"notes", id:Ext.id(),height:60,anchor:"-20"   });
		this._elems_.add("active", { name:"active", xtype:"checkbox", _rbkey_:"active", dataIndex:"active", id:Ext.id()  });
		this._elems_.add("locked", { name:"locked", xtype:"checkbox", dataIndex:"locked", id:Ext.id()  });
		this._elems_.add("modifiedAt", { name:"modifiedAt", xtype:"datefield", _rbkey_:"modifiedAt", dataIndex:"modifiedAt", id:Ext.id(),width:100,disabled:true  ,allowBlank:false, labelSeparator:"*" ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("modifiedBy", { name:"modifiedBy", xtype:"textfield",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", id:Ext.id(),anchor:"-20",disabled:true  ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:350,labelWidth:0 });     
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id() , width:250,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("code") ,this._elems_.get("accountType") ,this._elems_.get("notes") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("active") ,this._elems_.get("locked") ,this._elems_.get("modifiedAt") ,this._elems_.get("modifiedBy") ];
	}	
});
Ext.reg("net.nan21.dnet.module.ad.usr.dc.User$Edit", net.nan21.dnet.module.ad.usr.dc.User$Edit ); 
