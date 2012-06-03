   

Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollBalanceValue", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollBalanceValueDs",
	filterModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollBalanceValueDsFilter",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.param.PayrollBalanceValueDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollBalanceValue$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.PayrollBalanceValue$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"element", xtype:"net.nan21.dnet.module.hr.payroll.lovs.PayrollElementsBalance", dataIndex:"element",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "elementId"} ]  })
		.addLov({ name:"sourceElement", xtype:"net.nan21.dnet.module.hr.payroll.lovs.PayrollElementsSource", dataIndex:"sourceElement",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "sourceElementId"} ]  })
		.addLov({ name:"accItem", xtype:"net.nan21.dnet.module.md.acc.lovs.AccItems", dataIndex:"accItem",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accItemId"} ]  })
		.addLov({ name:"period", xtype:"net.nan21.dnet.module.hr.payroll.lovs.PayrollPeriods", dataIndex:"period",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "periodId"} ]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.bd.elem.lovs.ElementTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"employer", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"employer",anchor:"-20",allowBlank:false,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "employerId"} ]  })
		.addDateField({ name:"periodStart_From", dataIndex:"periodStart_From", emptyText:"From" })
		.addDateField({ name:"periodStart_To", dataIndex:"periodStart_To", emptyText:"To" })
		.addFieldContainer({name: "periodStart", fieldLabel:"Period Start"}) 
		.addChildrenTo("periodStart",["periodStart_From", "periodStart_To"]) 

		.addDateField({ name:"periodEnd_From", dataIndex:"periodEnd_From", emptyText:"From" })
		.addDateField({ name:"periodEnd_To", dataIndex:"periodEnd_To", emptyText:"To" })
		.addFieldContainer({name: "periodEnd", fieldLabel:"Period End"}) 
		.addChildrenTo("periodEnd",["periodEnd_From", "periodEnd_To"]) 

		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"col3", layout:"form", width:300}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["employer","period","element"])
		.addChildrenTo("col2",["type","sourceElement","accItem"])
		.addChildrenTo("col3",["periodStart","periodEnd"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollBalanceValue$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.payroll.dc.PayrollBalanceValue$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"employer", dataIndex:"employer",width:100 })   	
		.addTextColumn({ name:"period", dataIndex:"period",width:120 })   	
		.addDateColumn({ name:"periodStart", dataIndex:"periodStart",format:Dnet.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"periodEnd", dataIndex:"periodEnd",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"element", dataIndex:"element",width:100 })   	
		.addTextColumn({ name:"elementName", dataIndex:"elementName",width:200 })   	
		.addTextColumn({ name:"value", dataIndex:"value",width:200 })   	
		.addTextColumn({ name:"sourceElement", dataIndex:"sourceElement",width:100 })   	
		.addTextColumn({ name:"accItem", dataIndex:"accItem",width:120 })   	
		.addNumberColumn({ name:"periodId", dataIndex:"periodId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
