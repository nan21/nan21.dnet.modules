   

Ext.define("net.nan21.dnet.module.hr.grade.dc.GradeRateValue", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.GradeRateValueDs",
	filterModel: "net.nan21.dnet.module.hr.grade.ds.model.GradeRateValueDsFilter",
	paramModel: "net.nan21.dnet.module.hr.grade.ds.param.GradeRateValueDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.grade.dc.GradeRateValue$CtxEditList4GradeRate", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.grade.dc.GradeRateValue$CtxEditList4GradeRate",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"gradeRateId", dataIndex:"gradeRateId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"gradeId", dataIndex:"gradeId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"gradeName", xtype:"gridcolumn", dataIndex:"gradeName",width:200,editor:{xtype:"net.nan21.dnet.module.hr.grade.lovs.Grades" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "gradeId"} ]} })
		.addNumberColumn({ name:"fixValue", dataIndex:"fixValue", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"minValue", dataIndex:"minValue", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"maxValue", dataIndex:"maxValue", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addDateColumn({ name:"validFrom", dataIndex:"validFrom",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"validTo", dataIndex:"validTo",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
