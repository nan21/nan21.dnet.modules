   
Ext.ns('net.nan21.dnet.module.hr.employee.dc');	 
net.nan21.dnet.module.hr.employee.dc.Employee = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Employee" 		 
			,ds: new net.nan21.dnet.module.hr.employee.ds.EmployeeDs()			  
		});
	 	net.nan21.dnet.module.hr.employee.dc.Employee.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.employee.dc'); 
net.nan21.dnet.module.hr.employee.dc.Employee$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("code", { name:"code", xtype:"textfield", _rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("firstName", { name:"firstName", xtype:"textfield", dataIndex:"firstName", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("lastName", { name:"lastName", xtype:"textfield", dataIndex:"lastName", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("gender", { name:"gender", xtype:"combo", dataIndex:"gender", id:Ext.id(),anchor:"-20",store:[ "male", "female"]  });
		this._elems_.add("maritalStatus", { name:"maritalStatus", xtype:"combo", dataIndex:"maritalStatus", id:Ext.id(),anchor:"-20",store:[ "single", "married", "divorced", "widow", "other"]  });
		this._elems_.add("employerCode", { name:"employerCode", xtype:"net.nan21.dnet.module.ad.org.lovs.LegalEntityOrganizations", dataIndex:"employerCode", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "employerId"} ]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(), width:220,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(), width:220,labelWidth:0 });
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id(), width:220,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("firstName") ,this._elems_.get("lastName") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("employerCode") ,this._elems_.get("code") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("gender") ,this._elems_.get("maritalStatus") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.employee.dc.Employee$Filter", net.nan21.dnet.module.hr.employee.dc.Employee$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.employee.dc');	 	 
net.nan21.dnet.module.hr.employee.dc.Employee$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("code", { xtype:"gridcolumn",_rbkey_:"code", dataIndex:"code", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("firstName", { xtype:"gridcolumn", dataIndex:"firstName", sortable:true, hidden:false, width:100 });   	
		this._columns_.add("lastName", { xtype:"gridcolumn", dataIndex:"lastName", sortable:true, hidden:false, width:100 });   	
		this._columns_.add("employerCode", { xtype:"gridcolumn", dataIndex:"employerCode", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("birthdate", { xtype:"datecolumn", dataIndex:"birthdate", sortable:true, hidden:true,format:Ext.DATE_FORMAT});   	      	     
		this._columns_.add("gender", { xtype:"gridcolumn", dataIndex:"gender", sortable:true, hidden:false,width:60 });   	
		this._columns_.add("maritalStatus", { xtype:"gridcolumn", dataIndex:"maritalStatus", sortable:true, hidden:false,width:60 });   	
		this._columns_.add("currentHireDate", { xtype:"datecolumn", dataIndex:"currentHireDate", sortable:true, hidden:true,format:Ext.DATE_FORMAT});   	      	     
		this._columns_.add("firstHireDate", { xtype:"datecolumn", dataIndex:"firstHireDate", sortable:true, hidden:true,format:Ext.DATE_FORMAT});   	      	     
		this._columns_.add("officeEmail", { xtype:"gridcolumn", dataIndex:"officeEmail", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("citizenshipCode", { xtype:"gridcolumn", dataIndex:"citizenshipCode", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:true,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.hr.employee.dc.Employee$List", net.nan21.dnet.module.hr.employee.dc.Employee$List ); 
 	
Ext.ns('net.nan21.dnet.module.hr.employee.dc');	 
net.nan21.dnet.module.hr.employee.dc.Employee$EditMain = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("firstName", { name:"firstName", xtype:"textfield", dataIndex:"firstName", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("lastName", { name:"lastName", xtype:"textfield", dataIndex:"lastName", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("middleName", { name:"middleName", xtype:"textfield", dataIndex:"middleName", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("code", { name:"code", xtype:"textfield",_rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("employerCode", { name:"employerCode", xtype:"net.nan21.dnet.module.ad.org.lovs.LegalEntityOrganizations", dataIndex:"employerCode", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "employerId"} ]  });
		this._elems_.add("birthdate", { name:"birthdate", xtype:"datefield", dataIndex:"birthdate", id:Ext.id(),width:100  ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("gender", { name:"gender", xtype:"combo", dataIndex:"gender", id:Ext.id(),anchor:"-20",store:[ "male", "female"]  });
		this._elems_.add("maritalStatus", { name:"maritalStatus", xtype:"combo", dataIndex:"maritalStatus", id:Ext.id(),anchor:"-20",store:[ "single", "married", "divorced", "widow", "other"]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:300,labelWidth:0 });     
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id() ,width:250,labelWidth:0 });     
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id() ,width:250,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("firstName") ,this._elems_.get("lastName") ,this._elems_.get("middleName") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("employerCode") ,this._elems_.get("code") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("gender") ,this._elems_.get("birthdate") ,this._elems_.get("maritalStatus") ];
	}	
});
Ext.reg("net.nan21.dnet.module.hr.employee.dc.Employee$EditMain", net.nan21.dnet.module.hr.employee.dc.Employee$EditMain ); 
 	
Ext.ns('net.nan21.dnet.module.hr.employee.dc');	 
net.nan21.dnet.module.hr.employee.dc.Employee$EditOther = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("firstHireDate", { name:"firstHireDate", xtype:"datefield", dataIndex:"firstHireDate", id:Ext.id(),width:100  ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("currentHireDate", { name:"currentHireDate", xtype:"datefield", dataIndex:"currentHireDate", id:Ext.id(),width:100  ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("officeEmail", { name:"officeEmail", xtype:"textfield", dataIndex:"officeEmail", id:Ext.id(),anchor:"-20" ,maxLength:128,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "128"},vtype:"email"  });
		this._elems_.add("hasDisability", { name:"hasDisability", xtype:"checkbox", dataIndex:"hasDisability", id:Ext.id()  });
		this._elems_.add("citizenshipCode", { name:"citizenshipCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"citizenshipCode", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "citizenshipId"} ]  });
		this._elems_.add("passportNo", { name:"passportNo", xtype:"textfield", dataIndex:"passportNo", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("sinNo", { name:"sinNo", xtype:"textfield", dataIndex:"sinNo", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("ssnNo", { name:"ssnNo", xtype:"textfield", dataIndex:"ssnNo", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:300,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("citizenshipCode") ,this._elems_.get("passportNo") ,this._elems_.get("ssnNo") ,this._elems_.get("sinNo") ,this._elems_.get("officeEmail") ,this._elems_.get("currentHireDate") ,this._elems_.get("firstHireDate") ];
	}	
});
Ext.reg("net.nan21.dnet.module.hr.employee.dc.Employee$EditOther", net.nan21.dnet.module.hr.employee.dc.Employee$EditOther ); 
