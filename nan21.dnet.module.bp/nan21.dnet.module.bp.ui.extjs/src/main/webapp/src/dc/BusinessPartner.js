   
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 
net.nan21.dnet.module.bp.md.dc.BusinessPartner = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"BusinessPartner" 		 
			,ds: new net.nan21.dnet.module.bp.md.ds.BusinessPartnerDs()			  
		});
	 	net.nan21.dnet.module.bp.md.dc.BusinessPartner.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc'); 
net.nan21.dnet.module.bp.md.dc.BusinessPartner$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("code", { name:"code", xtype:"textfield", _rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("type", { name:"type", xtype:"textfield", dataIndex:"type", id:Ext.id(),anchor:"-20",maxLength:1,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "1"}  });
		this._elems_.add("firstName", { name:"firstName", xtype:"textfield", dataIndex:"firstName", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("lastName", { name:"lastName", xtype:"textfield", dataIndex:"lastName", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("gender", { name:"gender", xtype:"textfield", dataIndex:"gender", id:Ext.id(),anchor:"-20",maxLength:16,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "16"}  });
		this._elems_.add("registrationNo", { name:"registrationNo", xtype:"textfield", dataIndex:"registrationNo", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("taxNo", { name:"taxNo", xtype:"textfield", dataIndex:"taxNo", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("name1", { name:"name1", xtype:"textfield", dataIndex:"name1", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("name2", { name:"name2", xtype:"textfield", dataIndex:"name2", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("countryCode", { name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(), width:220,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(), width:220,labelWidth:0 });
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id(), width:220,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col3") ,this._elems_.get("col2") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("code") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("countryCode") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("registrationNo") ,this._elems_.get("taxNo") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.bp.md.dc.BusinessPartner$Filter", net.nan21.dnet.module.bp.md.dc.BusinessPartner$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 	 
net.nan21.dnet.module.bp.md.dc.BusinessPartner$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("code", { xtype:"gridcolumn",_rbkey_:"code", dataIndex:"code", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("type", { xtype:"gridcolumn", dataIndex:"type", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("countryCode", { xtype:"gridcolumn", dataIndex:"countryCode", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("firstName", { xtype:"gridcolumn", dataIndex:"firstName", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("lastName", { xtype:"gridcolumn", dataIndex:"lastName", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("gender", { xtype:"gridcolumn", dataIndex:"gender", sortable:true, hidden:true,width:60 });   	
		this._columns_.add("legalForm", { xtype:"gridcolumn", dataIndex:"legalForm", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("registrationNo", { xtype:"gridcolumn", dataIndex:"registrationNo", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("registrationDate", { xtype:"datecolumn", dataIndex:"registrationDate", sortable:true, hidden:true,format:Ext.DATE_FORMAT});   	      	     
		this._columns_.add("taxNo", { xtype:"gridcolumn", dataIndex:"taxNo", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("name1", { xtype:"gridcolumn", dataIndex:"name1", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("name2", { xtype:"gridcolumn", dataIndex:"name2", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bp.md.dc.BusinessPartner$List", net.nan21.dnet.module.bp.md.dc.BusinessPartner$List ); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 
net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("code", { name:"code", xtype:"textfield",_rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("active", { name:"active", xtype:"checkbox", _rbkey_:"active", dataIndex:"active", id:Ext.id()  });
		this._elems_.add("countryCode", { name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  });
		this._elems_.add("type", { name:"type", xtype:"textfield", dataIndex:"type", id:Ext.id(),anchor:"-20",disabled:true  ,maxLength:1,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "1"}  });
		this._elems_.add("firstName", { name:"firstName", xtype:"textfield", dataIndex:"firstName", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("lastName", { name:"lastName", xtype:"textfield", dataIndex:"lastName", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("gender", { name:"gender", xtype:"textfield", dataIndex:"gender", id:Ext.id(),anchor:"-20" ,maxLength:16,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "16"}  });
		this._elems_.add("name", { name:"name", xtype:"textfield",_rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("legalForm", { name:"legalForm", xtype:"textfield", dataIndex:"legalForm", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("registrationNo", { name:"registrationNo", xtype:"textfield", dataIndex:"registrationNo", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("registrationDate", { name:"registrationDate", xtype:"datefield", dataIndex:"registrationDate", id:Ext.id(),width:100  ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("taxNo", { name:"taxNo", xtype:"textfield", dataIndex:"taxNo", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		//containers
		this._elems_.add("formLE", { name:"formLE", layout:"form", id:Ext.id() ,width:250,labelWidth:0 });     
		this._elems_.add("formPI", { name:"formPI", layout:"form", id:Ext.id() ,width:250,labelWidth:0 });     
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:250,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
		this._elems_.add("col0", { name:"col0", layout:"card", id:Ext.id(), activeItem:0 , width:300 });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col0") ,this._elems_.get("col1") ];
		this._elems_.get("col0")["items"] = [this._elems_.get("formLE") ,this._elems_.get("formPI") ];
		this._elems_.get("formLE")["items"] = [this._elems_.get("name") ,this._elems_.get("registrationNo") ,this._elems_.get("taxNo") ];
		this._elems_.get("formPI")["items"] = [this._elems_.get("firstName") ,this._elems_.get("lastName") ,this._elems_.get("gender") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("countryCode") ,this._elems_.get("code") ,this._elems_.get("active") ];
	}	
});
Ext.reg("net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit", net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit ); 
