   
Ext.ns('net.nan21.dnet.module.hr.payroll.dc');	 
net.nan21.dnet.module.hr.payroll.dc.Payroll = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Payroll" 		 
			,ds: new net.nan21.dnet.module.hr.payroll.ds.PayrollDs()			  
		});
	 	net.nan21.dnet.module.hr.payroll.dc.Payroll.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.payroll.dc'); 
net.nan21.dnet.module.hr.payroll.dc.Payroll$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("periodType", { name:"periodType", xtype:"combo", dataIndex:"periodType", id:Ext.id(),anchor:"-20",store:[ "calendar-month", "semi-month"]  });
		//containers
		this._elems_.add("main", { name:"main", layout:"hbox", id:Ext.id() , autoScroll:true, defaults:{labelAlign:"right",labelWidth:80,width:210 }}); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [
	    {layout:"form", border:false 
	      ,items:[ this._elems_.get("name")] }
	  ,	    {layout:"form", border:false 
	      ,items:[ this._elems_.get("periodType")] }
];
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.payroll.dc.Payroll$Filter", net.nan21.dnet.module.hr.payroll.dc.Payroll$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.payroll.dc');	 	 
net.nan21.dnet.module.hr.payroll.dc.Payroll$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:120 });   	
		this._columns_.add("periodType", { xtype:"gridcolumn", dataIndex:"periodType", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("description", { xtype:"gridcolumn",_rbkey_:"description", dataIndex:"description", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.hr.payroll.dc.Payroll$List", net.nan21.dnet.module.hr.payroll.dc.Payroll$List ); 
 	
Ext.ns('net.nan21.dnet.module.hr.payroll.dc');	 
net.nan21.dnet.module.hr.payroll.dc.Payroll$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield",_rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("active", { name:"active", xtype:"checkbox", _rbkey_:"active", dataIndex:"active", id:Ext.id()  });
		this._elems_.add("description", { name:"description", xtype:"textarea", _rbkey_:"description", dataIndex:"description", id:Ext.id(),height:60,anchor:"-20"   });
		this._elems_.add("periodType", { name:"periodType", xtype:"combo", dataIndex:"periodType", id:Ext.id(),anchor:"-20",allowBlank:false, labelSeparator:"*",store:[ "calendar-month", "semi-month"]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:300,labelWidth:0 });     
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id() , width:350,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("periodType") ,this._elems_.get("active") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("description") ];
	}	
});
Ext.reg("net.nan21.dnet.module.hr.payroll.dc.Payroll$Edit", net.nan21.dnet.module.hr.payroll.dc.Payroll$Edit ); 
