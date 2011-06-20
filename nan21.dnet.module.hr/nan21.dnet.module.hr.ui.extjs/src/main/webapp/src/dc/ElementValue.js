   
Ext.ns('net.nan21.dnet.module.hr.payroll.dc');	 
net.nan21.dnet.module.hr.payroll.dc.ElementValue = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"ElementValue" 		 
			,ds: new net.nan21.dnet.module.hr.payroll.ds.ElementValueDs()			  
		});
	 	net.nan21.dnet.module.hr.payroll.dc.ElementValue.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.payroll.dc'); 
net.nan21.dnet.module.hr.payroll.dc.ElementValue$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("element", { name:"element", xtype:"net.nan21.dnet.module.hr.payroll.lovs.Elements", dataIndex:"element", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "elementId"} ]  });
		this._elems_.add("employeeName", { name:"employeeName", xtype:"net.nan21.dnet.module.hr.employee.lovs.Employees", dataIndex:"employeeName", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "employeeId"} ]  });
		this._elems_.add("period", { name:"period", xtype:"net.nan21.dnet.module.hr.payroll.lovs.PayrollPeriods", dataIndex:"period", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "periodId"} ]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("element") ,this._elems_.get("period") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("employeeName") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.payroll.dc.ElementValue$Filter", net.nan21.dnet.module.hr.payroll.dc.ElementValue$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.payroll.dc');	 	 
net.nan21.dnet.module.hr.payroll.dc.ElementValue$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("elementId", { xtype:"numbercolumn", dataIndex:"elementId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("element", { xtype:"gridcolumn", dataIndex:"element", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("employeeId", { xtype:"numbercolumn", dataIndex:"employeeId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("employeeName", { xtype:"gridcolumn", dataIndex:"employeeName", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("value", { xtype:"gridcolumn", dataIndex:"value", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("periodId", { xtype:"numbercolumn", dataIndex:"periodId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("period", { xtype:"gridcolumn", dataIndex:"period", sortable:true, hidden:false,width:120 });   	
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.hr.payroll.dc.ElementValue$List", net.nan21.dnet.module.hr.payroll.dc.ElementValue$List ); 
