   

Ext.define("net.nan21.dnet.module.hr.skill.dc.JobSkill", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.JobSkillDs",
	paramModel: "net.nan21.dnet.module.hr.skill.ds.param.JobSkillDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.skill.dc.JobSkill$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.skill.dc.JobSkill$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"jobId", dataIndex:"jobId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"competenceId", dataIndex:"competenceId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"competence", xtype:"gridcolumn", dataIndex:"competence", width:300,editor:{xtype:"net.nan21.dnet.module.hr.skill.lovs.Skills" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "competenceId"} ,{lovField:"ratingScaleId", dsField: "ratingScaleId"} ]} })
		.addNumberColumn({ name:"requiredLevelId", dataIndex:"requiredLevelId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"requiredLevel", xtype:"gridcolumn", dataIndex:"requiredLevel",width:120,editor:{xtype:"net.nan21.dnet.module.hr.skill.lovs.RatingLevels" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "requiredLevelId"} ],filterFieldMapping: [{lovField:"ratingScaleId", dsField: "ratingScaleId"} ]} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
