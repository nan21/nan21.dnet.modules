   

Ext.define("net.nan21.dnet.module.hr.skill.dc.QualificationSkill", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.QualificationSkillDs",
	filterModel: "net.nan21.dnet.module.hr.skill.ds.model.QualificationSkillDsFilter",
	paramModel: "net.nan21.dnet.module.hr.skill.ds.param.QualificationSkillDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.skill.dc.QualificationSkill$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.skill.dc.QualificationSkill$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"qualificationId", dataIndex:"qualificationId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"skillId", dataIndex:"skillId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"skill", xtype:"gridcolumn", dataIndex:"skill",width:120,editor:{xtype:"net.nan21.dnet.module.hr.skill.lovs.Skills" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "skillId"} ,{lovField:"ratingScaleId", dsField: "ratingScaleId"} ]} })
		.addLov({name:"requiredLevel", xtype:"gridcolumn", dataIndex:"requiredLevel",width:120,editor:{xtype:"net.nan21.dnet.module.hr.skill.lovs.RatingLevels" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "requiredLevelId"} ],filterFieldMapping: [{lovField:"ratingScaleId", dsField: "ratingScaleId"} ]} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
	  ;  		   
	}  
});
