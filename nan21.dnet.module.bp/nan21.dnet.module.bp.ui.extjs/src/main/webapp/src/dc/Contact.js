   
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 
net.nan21.dnet.module.bp.md.dc.Contact = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Contact" 		 
			,ds: new net.nan21.dnet.module.bp.md.ds.ContactDs()			  
		});
	 	net.nan21.dnet.module.bp.md.dc.Contact.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc'); 
net.nan21.dnet.module.bp.md.dc.Contact$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("firstName", { name:"firstName", xtype:"textfield", dataIndex:"firstName", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("lastName", { name:"lastName", xtype:"textfield", dataIndex:"lastName", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("bpartnerCode", { name:"bpartnerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartners", _rbkey_:"bpartnerCode", dataIndex:"bpartnerCode", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: []  });
		this._elems_.add("birthdate", { name:"birthdate", xtype:"datefield", dataIndex:"birthdate", id:Ext.id(),width:100 ,format:Ext.DATE_FORMAT });
		this._elems_.add("gender", { name:"gender", xtype:"combo", dataIndex:"gender", id:Ext.id(),anchor:"-20",store:[ "male", "female"]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(), width:220,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(), width:250,labelWidth:0 });
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id(), width:220,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("firstName") ,this._elems_.get("lastName") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("bpartnerCode") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("birthdate") ,this._elems_.get("gender") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.bp.md.dc.Contact$Filter", net.nan21.dnet.module.bp.md.dc.Contact$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 	 
net.nan21.dnet.module.bp.md.dc.Contact$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("firstName", { xtype:"gridcolumn", dataIndex:"firstName", sortable:true, hidden:false, width:120 });   	
		this._columns_.add("lastName", { xtype:"gridcolumn", dataIndex:"lastName", sortable:true, hidden:false, width:120 });   	
		this._columns_.add("bpartnerId", { xtype:"numbercolumn",_rbkey_:"bpartnerId", dataIndex:"bpartnerId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("bpartnerCode", { xtype:"gridcolumn",_rbkey_:"bpartnerCode", dataIndex:"bpartnerCode", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("gender", { xtype:"gridcolumn", dataIndex:"gender", sortable:true, hidden:true,width:60 });   	
		this._columns_.add("birthdate", { xtype:"datecolumn", dataIndex:"birthdate", sortable:true, hidden:true,format:Ext.DATE_FORMAT});   	      	     
		this._columns_.add("position", { xtype:"gridcolumn", dataIndex:"position", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bp.md.dc.Contact$List", net.nan21.dnet.module.bp.md.dc.Contact$List ); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 	 
net.nan21.dnet.module.bp.md.dc.Contact$CtxEditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection() 
	,_controller_: null 
	,_noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {		
		this._columns_.add("firstName", { xtype:"gridcolumn", dataIndex:"firstName", sortable:true, hidden:false, width:120,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} });
		this._columns_.add("lastName", { xtype:"gridcolumn", dataIndex:"lastName", sortable:true, hidden:false, width:120,editor:{xtype:"textfield" , selectOnFocus:true,allowBlank:false,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} });
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv', store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true }});
		this._columns_.add("gender", { xtype:"gridcolumn", dataIndex:"gender", sortable:true, hidden:true,width:60,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:16,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "16"}} });
		this._columns_.add("birthdate", { xtype:"datecolumn", dataIndex:"birthdate", sortable:true, hidden:true,format:Ext.DATE_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("position", { xtype:"gridcolumn", dataIndex:"position", sortable:true, hidden:false,width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} });
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
	}  
});
Ext.reg("net.nan21.dnet.module.bp.md.dc.Contact$CtxEditList", net.nan21.dnet.module.bp.md.dc.Contact$CtxEditList ); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 
net.nan21.dnet.module.bp.md.dc.Contact$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("firstName", { name:"firstName", xtype:"textfield", dataIndex:"firstName", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("lastName", { name:"lastName", xtype:"textfield", dataIndex:"lastName", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("gender", { name:"gender", xtype:"combo", dataIndex:"gender", id:Ext.id(),anchor:"-20",store:[ "male", "female"]  });
		this._elems_.add("position", { name:"position", xtype:"textfield", dataIndex:"position", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("birthdate", { name:"birthdate", xtype:"datefield", dataIndex:"birthdate", id:Ext.id(),width:100  ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("active", { name:"active", xtype:"checkbox", _rbkey_:"active", dataIndex:"active", id:Ext.id()  });
		this._elems_.add("bpartnerCode", { name:"bpartnerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartners", _rbkey_:"bpartnerCode", dataIndex:"bpartnerCode", id:Ext.id(), width:150 ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: []  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:300,labelWidth:0 });     
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id() , width:300,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("firstName") ,this._elems_.get("lastName") ,this._elems_.get("bpartnerCode") ,this._elems_.get("active") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("position") ,this._elems_.get("gender") ,this._elems_.get("birthdate") ];
	}	
});
Ext.reg("net.nan21.dnet.module.bp.md.dc.Contact$Edit", net.nan21.dnet.module.bp.md.dc.Contact$Edit ); 
