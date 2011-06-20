   
Ext.ns('net.nan21.dnet.module.hr.training.dc');	 
net.nan21.dnet.module.hr.training.dc.Course = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Course" 		 
			,ds: new net.nan21.dnet.module.hr.training.ds.CourseDs()			  
		});
	 	net.nan21.dnet.module.hr.training.dc.Course.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.training.dc'); 
net.nan21.dnet.module.hr.training.dc.Course$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("code", { name:"code", xtype:"textfield", _rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("active", { name:"active", xtype:"combo", mode: 'local',_rbkey_:"active", dataIndex:"active", id:Ext.id(), selectOnFocus:true, valueField: 'bv', displayField: 'tv',  store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true, width:70  });
		this._elems_.add("type", { name:"type", xtype:"net.nan21.dnet.module.hr.training.lovs.CourseTypes", dataIndex:"type", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("code") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("type") ,this._elems_.get("active") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.training.dc.Course$Filter", net.nan21.dnet.module.hr.training.dc.Course$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.training.dc');	 	 
net.nan21.dnet.module.hr.training.dc.Course$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("code", { xtype:"gridcolumn",_rbkey_:"code", dataIndex:"code", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("typeId", { xtype:"numbercolumn", dataIndex:"typeId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("type", { xtype:"gridcolumn", dataIndex:"type", sortable:true, hidden:false,width:120 });   	
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("deliveredCompetences", { xtype:"gridcolumn", dataIndex:"deliveredCompetences", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("intendedAudience", { xtype:"gridcolumn", dataIndex:"intendedAudience", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("requirements", { xtype:"gridcolumn", dataIndex:"requirements", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.hr.training.dc.Course$List", net.nan21.dnet.module.hr.training.dc.Course$List ); 
 	
Ext.ns('net.nan21.dnet.module.hr.training.dc');	 
net.nan21.dnet.module.hr.training.dc.Course$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield",_rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("code", { name:"code", xtype:"textfield",_rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("active", { name:"active", xtype:"checkbox", _rbkey_:"active", dataIndex:"active", id:Ext.id()  });
		this._elems_.add("notes", { name:"notes", xtype:"textfield",_rbkey_:"notes", dataIndex:"notes", id:Ext.id(),anchor:"-20" ,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}  });
		this._elems_.add("deliveredCompetences", { name:"deliveredCompetences", xtype:"textarea", dataIndex:"deliveredCompetences", id:Ext.id(),height:80,anchor:"-20"   });
		this._elems_.add("intendedAudience", { name:"intendedAudience", xtype:"textarea", dataIndex:"intendedAudience", id:Ext.id(),height:80,anchor:"-20"   });
		this._elems_.add("requirements", { name:"requirements", xtype:"textarea", dataIndex:"requirements", id:Ext.id(),height:80,anchor:"-20"   });
		this._elems_.add("type", { name:"type", xtype:"net.nan21.dnet.module.hr.training.lovs.CourseTypes", dataIndex:"type", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:600,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("code") ,this._elems_.get("deliveredCompetences") ,this._elems_.get("intendedAudience") ,this._elems_.get("requirements") ,this._elems_.get("type") ,this._elems_.get("active") ];
	}	
});
Ext.reg("net.nan21.dnet.module.hr.training.dc.Course$Edit", net.nan21.dnet.module.hr.training.dc.Course$Edit ); 
