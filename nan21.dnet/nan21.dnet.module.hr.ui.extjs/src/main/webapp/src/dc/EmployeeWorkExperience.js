   

Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeWorkExperience", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeWorkExperienceDs",
	filterModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeWorkExperienceDsFilter",
	paramModel: "net.nan21.dnet.module.hr.employee.ds.param.EmployeeWorkExperienceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeWorkExperience$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.employee.dc.EmployeeWorkExperience$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"employeeId", dataIndex:"employeeId", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"fromDate", dataIndex:"fromDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"toDate", dataIndex:"toDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addTextColumn({ name:"institute", dataIndex:"institute",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
