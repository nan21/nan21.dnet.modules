   

Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeContact", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactDs",
	filterModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactDsFilter",
	paramModel: "net.nan21.dnet.module.hr.employee.ds.param.EmployeeContactDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeContact$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.employee.dc.EmployeeContact$CtxEditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"firstName", dataIndex:"firstName",width:200,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"lastName", dataIndex:"lastName",width:200,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addDateColumn({ name:"birthdate", dataIndex:"birthdate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Dnet.DATE_FORMAT}})
		.addComboColumn({ name:"gender", dataIndex:"gender", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv' ,store:[ "male", "female"] , triggerAction:'all', forceSelection:true }})
		.addNumberColumn({ name:"employeeId", dataIndex:"employeeId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"relationshipId", dataIndex:"relationshipId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"relationship", xtype:"gridcolumn", dataIndex:"relationship",width:120,editor:{xtype:"net.nan21.dnet.module.hr.employee.lovs.EmployeeContactRelationships" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "relationshipId"} ]} })
		.addBooleanColumn({ name:"isDependent", dataIndex:"isDependent"})
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
