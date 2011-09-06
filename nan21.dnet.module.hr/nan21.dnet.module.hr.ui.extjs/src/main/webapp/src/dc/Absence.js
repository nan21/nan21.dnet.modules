   
Ext.ns('net.nan21.dnet.module.hr.time.dc');	 
net.nan21.dnet.module.hr.time.dc.Absence = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Absence" 		 
			,ds: new net.nan21.dnet.module.hr.time.ds.AbsenceDs()			  
		});
	 	net.nan21.dnet.module.hr.time.dc.Absence.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.time.dc'); 
net.nan21.dnet.module.hr.time.dc.Absence$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"employeeCode", dataIndex:"employeeCode",anchor:"-20",disabled:true ,maxLength:32  })
		.addLov({ name:"employee", xtype:"net.nan21.dnet.module.hr.employee.lovs.Employees", dataIndex:"employee",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "employeeId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.time.lovs.AbsenceTypes", dataIndex:"type",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"reason", xtype:"net.nan21.dnet.module.hr.time.lovs.AbsenceReasons", dataIndex:"reason",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "reasonId"} ]  })
		.addDateField({ name:"eventDate", dataIndex:"eventDate",width:100 ,format:Ext.DATE_FORMAT })
		.addNumberField({ name:"hours", dataIndex:"hours",anchor:"-20"  })
		.addDateField({ name:"from", dataIndex:"from", _isParam_:true,width:100,listeners: {change: {scope:this, fn:function(f,nv,ov) {this._controller_.setParamValue("from", nv);} }} ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"to", dataIndex:"to", _isParam_:true,width:100,listeners: {change: {scope:this, fn:function(f,nv,ov) {this._controller_.setParamValue("to", nv);} }} ,format:Ext.DATE_FORMAT })
		.addBooleanField({ name:"posted", dataIndex:"posted"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col3", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["employee","posted"])
		.addChildrenTo("col2",["type","reason"])
		.addChildrenTo("col3",["from","to"])
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.time.dc.Absence$Filter", net.nan21.dnet.module.hr.time.dc.Absence$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.time.dc');	 	 
net.nan21.dnet.module.hr.time.dc.Absence$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"employeeCode", dataIndex:"employeeCode",width:100 })   	
		.addTextColumn({ name:"employee", dataIndex:"employee",width:200 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addTextColumn({ name:"reason", dataIndex:"reason",width:120 })   	
		.addDateColumn({ name:"eventDate", dataIndex:"eventDate",format:Ext.DATE_FORMAT})   	      	     
		.addNumberColumn({ name:"hours", dataIndex:"hours",format:Ext.NUMBER_FORMAT_INT })  
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
		.addBooleanColumn({ name:"posted", dataIndex:"posted"})   	     
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"employeeId", dataIndex:"employeeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"reasonId", dataIndex:"reasonId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.hr.time.dc.Absence$List", net.nan21.dnet.module.hr.time.dc.Absence$List ); 
 	
Ext.ns('net.nan21.dnet.module.hr.time.dc');	 
net.nan21.dnet.module.hr.time.dc.Absence$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"employee", xtype:"net.nan21.dnet.module.hr.employee.lovs.Employees", dataIndex:"employee",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "employeeId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.time.lovs.AbsenceTypes", dataIndex:"type",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"reason", xtype:"net.nan21.dnet.module.hr.time.lovs.AbsenceReasons", dataIndex:"reason",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "reasonId"} ],filterFieldMapping: [{lovField:"typeId", dsField: "typeId"} ]  })
		.addDateField({ name:"eventDate", dataIndex:"eventDate",width:100 ,allowBlank:false})
		.addNumberField({ name:"hours", dataIndex:"hours", width:80 ,allowBlank:false , style: "text-align:right;" })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" ,width:250,labelWidth:0 })     
		.addPanel({ name:"col3", layout:"form" , width:400,labelAlign:"top",labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["employee","type","reason"])
		.addChildrenTo("col2",["eventDate","hours"])
		.addChildrenTo("col3",["notes"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.hr.time.dc.Absence$Edit", net.nan21.dnet.module.hr.time.dc.Absence$Edit ); 
