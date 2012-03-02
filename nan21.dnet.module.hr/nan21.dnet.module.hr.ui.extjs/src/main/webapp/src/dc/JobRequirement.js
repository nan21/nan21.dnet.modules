   

Ext.define("net.nan21.dnet.module.hr.job.dc.JobRequirement", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.JobRequirementDs",
	filterModel: "net.nan21.dnet.module.hr.job.ds.model.JobRequirementDsFilter",
	paramModel: "net.nan21.dnet.module.hr.job.ds.param.JobRequirementDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.job.dc.JobRequirement$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.job.dc.JobRequirement$CtxEditList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"jobId", dataIndex:"jobId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"requirementId", dataIndex:"requirementId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"requirement", xtype:"gridcolumn", dataIndex:"requirement", width:300,editor:{xtype:"net.nan21.dnet.module.hr.job.lovs.WorkRequirements" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "requirementId"} ]} })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:4000} })
	  	.addDefaults()
	  ;  		   
	}  
});
