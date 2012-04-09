   

Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollPeriod", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodDs",
	filterModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodDsFilter",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.param.PayrollPeriodDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollPeriod$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.PayrollPeriod$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"payrollId", dataIndex:"payrollId", hidden:true, align:"right",format:"0",width:70})
		.addTextColumn({ name:"payrollName", dataIndex:"payrollName", hidden:true,width:120 })
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addBooleanColumn({ name:"active", dataIndex:"active",_noEdit_:true})
		.addBooleanColumn({ name:"processed", dataIndex:"processed",_noEdit_:true})
		.addBooleanColumn({ name:"closed", dataIndex:"closed",_noEdit_:true})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
