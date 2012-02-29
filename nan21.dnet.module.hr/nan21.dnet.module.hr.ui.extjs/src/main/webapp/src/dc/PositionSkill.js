   

Ext.define("net.nan21.dnet.module.hr.skill.dc.PositionSkill", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.PositionSkillDs",
	filterModel: "net.nan21.dnet.module.hr.skill.ds.model.PositionSkillDsFilter",
	paramModel: "net.nan21.dnet.module.hr.skill.ds.param.PositionSkillDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.hr.skill.dc.PositionSkill$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.skill.dc.PositionSkill$CtxEditList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"positionId", dataIndex:"positionId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"competenceId", dataIndex:"competenceId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"competence", xtype:"gridcolumn", dataIndex:"competence", width:300,editor:{xtype:"net.nan21.dnet.module.hr.skill.lovs.Skills" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "competenceId"} ,{lovField:"ratingScaleId", dsField: "ratingScaleId"} ]} })
		.addNumberColumn({ name:"requiredLevelId", dataIndex:"requiredLevelId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"requiredLevel", xtype:"gridcolumn", dataIndex:"requiredLevel",width:120,editor:{xtype:"net.nan21.dnet.module.hr.skill.lovs.RatingLevels" , selectOnFocus:true ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "requiredLevelId"} ],filterFieldMapping: [{lovField:"ratingScaleId", dsField: "ratingScaleId"} ]} })
	  	.addDefaults()
	  ;  		   
	}  
});
