   

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
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"employeeId", dataIndex:"employeeId", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"fromDate", dataIndex:"fromDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"toDate", dataIndex:"toDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addTextColumn({ name:"institute", dataIndex:"institute",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
