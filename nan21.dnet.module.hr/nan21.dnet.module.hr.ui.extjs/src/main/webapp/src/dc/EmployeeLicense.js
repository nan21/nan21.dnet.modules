   

Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeLicense", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeLicenseDs",
	filterModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeLicenseDsFilter",
	paramModel: "net.nan21.dnet.module.hr.employee.ds.param.EmployeeLicenseDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeLicense$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.employee.dc.EmployeeLicense$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"employeeId", dataIndex:"employeeId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"licenseTypeId", dataIndex:"licenseTypeId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"licenseType", xtype:"gridcolumn", dataIndex:"licenseType",width:120,editor:{xtype:"net.nan21.dnet.module.hr.employee.lovs.LicenseTypes" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "licenseTypeId"} ]} })
		.addTextColumn({ name:"documentNo", dataIndex:"documentNo",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"issuedBy", dataIndex:"issuedBy",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"validTo", dataIndex:"validTo",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
