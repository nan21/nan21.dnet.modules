   

Ext.define("net.nan21.dnet.module.hr.job.dc.PositionRequirement", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.PositionRequirementDs",
	filterModel: "net.nan21.dnet.module.hr.job.ds.model.PositionRequirementDsFilter",
	paramModel: "net.nan21.dnet.module.hr.job.ds.param.PositionRequirementDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.job.dc.PositionRequirement$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.job.dc.PositionRequirement$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"positionId", dataIndex:"positionId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"requirementId", dataIndex:"requirementId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"requirement", xtype:"gridcolumn", dataIndex:"requirement", width:300,editor:{xtype:"net.nan21.dnet.module.hr.job.lovs.WorkRequirements" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "requirementId"} ]} })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
	  	.addDefaults()
	  ;  		   
	}  
});
