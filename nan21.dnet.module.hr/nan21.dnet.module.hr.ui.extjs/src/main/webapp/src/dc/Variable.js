   

Ext.define("net.nan21.dnet.module.hr.payroll.dc.Variable", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.VariableDs",
	filterModel: "net.nan21.dnet.module.hr.payroll.ds.model.VariableDsFilter",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.param.VariableDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.Variable$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.Variable$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true, align:"right",format:"0",width:70})
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addNumberColumn({ name:"crossReferenceId", dataIndex:"crossReferenceId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"crossReference", xtype:"gridcolumn", dataIndex:"crossReference",width:200,editor:{xtype:"net.nan21.dnet.module.hr.payroll.lovs.Elements" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "crossReferenceId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
