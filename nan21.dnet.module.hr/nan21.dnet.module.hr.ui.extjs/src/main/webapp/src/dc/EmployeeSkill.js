   
Ext.ns('net.nan21.dnet.module.hr.skill.dc');	 
net.nan21.dnet.module.hr.skill.dc.EmployeeSkill = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"EmployeeSkill" 		 
			,ds: new net.nan21.dnet.module.hr.skill.ds.EmployeeSkillDs()			  
		});
	 	net.nan21.dnet.module.hr.skill.dc.EmployeeSkill.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.skill.dc'); 
net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("createdBy", { name:"createdBy", xtype:"textfield", _rbkey_:"createdBy", dataIndex:"createdBy", id:Ext.id(),anchor:"-20",disabled:true ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("modifiedBy", { name:"modifiedBy", xtype:"textfield", _rbkey_:"modifiedBy", dataIndex:"modifiedBy", id:Ext.id(),anchor:"-20",disabled:true ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("skill", { name:"skill", xtype:"textfield", dataIndex:"skill", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("skillLevel", { name:"skillLevel", xtype:"textfield", dataIndex:"skillLevel", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		//containers
		this._elems_.add("main", { name:"main", layout:"form", id:Ext.id(), autoScroll:true,width:210,labelWidth:0 });
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("createdBy") ,this._elems_.get("modifiedBy") ,this._elems_.get("skill") ,this._elems_.get("skillLevel") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$Filter", net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.skill.dc');	 	 
net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection() 
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("employeeId", { xtype:"numbercolumn", dataIndex:"employeeId", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("skillId", { xtype:"numbercolumn", dataIndex:"skillId", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("skill", { xtype:"gridcolumn", dataIndex:"skill", sortable:true, hidden:false,width:120,editor:{xtype:"net.nan21.dnet.module.hr.skill.lovs.Skills" , selectOnFocus:true,allowBlank:false,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "skillId"} ,{lovField:"ratingScaleId", dsField: "ratingScaleId"} ]} });
		this._columns_.add("skillLevelId", { xtype:"numbercolumn", dataIndex:"skillLevelId", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("skillLevel", { xtype:"gridcolumn", dataIndex:"skillLevel", sortable:true, hidden:false,width:120,editor:{xtype:"net.nan21.dnet.module.hr.skill.lovs.RatingLevels" , selectOnFocus:true,allowBlank:false,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "skillLevelId"} ],filterFieldMapping: [{lovField:"ratingScaleId", dsField: "ratingScaleId"} ]} });
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
	}  
});
Ext.reg("net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$EditList", net.nan21.dnet.module.hr.skill.dc.EmployeeSkill$EditList ); 
