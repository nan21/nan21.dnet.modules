   

Ext.define("net.nan21.dnet.module.hr.time.dc.Absence", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceDs",
	filterModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceDsFilter",
	paramModel: "net.nan21.dnet.module.hr.time.ds.param.AbsenceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.hr.time.dc.Absence$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.time.dc.Absence$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"employeeCode", dataIndex:"employeeCode",anchor:"-20",disabled:true ,maxLength:32  })
		.addLov({ name:"employee", xtype:"net.nan21.dnet.module.hr.employee.lovs.Employees", dataIndex:"employee",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "employeeId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.time.lovs.AbsenceTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"reason", xtype:"net.nan21.dnet.module.hr.time.lovs.AbsenceReasons", dataIndex:"reason",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "reasonId"} ]  })
		.addDateField({ name:"eventDate", dataIndex:"eventDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addNumberField({ name:"hours", dataIndex:"hours",anchor:"-20"  })
		.addDateField({ name:"from", paramIndex:"from",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"to", paramIndex:"to",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addBooleanField({ name:"posted", dataIndex:"posted",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"col3", layout:"anchor", width:250}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col3","col2"])
		.addChildrenTo("col1",["employee","type","reason"])
		.addChildrenTo("col2",["posted"])
		.addChildrenTo("col3",["from","to"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.hr.time.dc.Absence$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.time.dc.Absence$List",
	
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
 
 	

Ext.define("net.nan21.dnet.module.hr.time.dc.Absence$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.hr.time.dc.Absence$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"employee", xtype:"net.nan21.dnet.module.hr.employee.lovs.Employees", dataIndex:"employee",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "employeeId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.time.lovs.AbsenceTypes", dataIndex:"type",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"reason", xtype:"net.nan21.dnet.module.hr.time.lovs.AbsenceReasons", dataIndex:"reason",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "reasonId"} ],filterFieldMapping: [{lovField:"typeId", dsField: "typeId"} ]  })
		.addDateField({ name:"eventDate", dataIndex:"eventDate",anchor:"-20" ,allowBlank:false})
		.addNumberField({ name:"hours", dataIndex:"hours",anchor:"-20" ,allowBlank:false , style: "text-align:right;" })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300})     
		.addPanel({ name:"col2", layout:"anchor" ,width:250})     
		.addPanel({ name:"col3", layout:"anchor" , width:400, defaults:{
labelAlign:"top"}})     
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
