   

Ext.define("net.nan21.dnet.module.hr.skill.dc.EmployeeSkill", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.EmployeeSkillDs",
	filterModel: "net.nan21.dnet.module.hr.skill.ds.model.EmployeeSkillDsFilter",
	paramModel: "net.nan21.dnet.module.hr.skill.ds.param.EmployeeSkillDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"createdBy",_sharedLabel_:true, dataIndex:"createdBy",anchor:"-20",disabled:true ,maxLength:32  })
		.addTextField({ name:"modifiedBy",_sharedLabel_:true, dataIndex:"modifiedBy",anchor:"-20",disabled:true ,maxLength:32  })
		.addTextField({ name:"skill", dataIndex:"skill",anchor:"-20",maxLength:255  })
		.addTextField({ name:"skillLevel", dataIndex:"skillLevel",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"main", layout:"form", autoScroll:true,width:210}) 
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["createdBy","modifiedBy","skill","skillLevel"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"employeeId", dataIndex:"employeeId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"skillId", dataIndex:"skillId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"skill", xtype:"gridcolumn", dataIndex:"skill",width:120,editor:{xtype:"net.nan21.dnet.module.hr.skill.lovs.Skills" , selectOnFocus:true,allowBlank:false,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "skillId"} ,{lovField:"ratingScaleId", dsField: "ratingScaleId"} ]} })
		.addNumberColumn({ name:"skillLevelId", dataIndex:"skillLevelId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"skillLevel", xtype:"gridcolumn", dataIndex:"skillLevel",width:120,editor:{xtype:"net.nan21.dnet.module.hr.skill.lovs.RatingLevels" , selectOnFocus:true,allowBlank:false,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "skillLevelId"} ],filterFieldMapping: [{lovField:"ratingScaleId", dsField: "ratingScaleId"} ]} })
	  	.addDefaults()
	  ;  		   
	}  
});
