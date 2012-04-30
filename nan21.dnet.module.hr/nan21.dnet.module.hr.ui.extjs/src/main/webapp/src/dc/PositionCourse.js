   

Ext.define("net.nan21.dnet.module.hr.training.dc.PositionCourse", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.training.ds.model.PositionCourseDs",
	filterModel: "net.nan21.dnet.module.hr.training.ds.model.PositionCourseDsFilter",
	paramModel: "net.nan21.dnet.module.hr.training.ds.param.PositionCourseDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.training.dc.PositionCourse$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.training.dc.PositionCourse$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"courseName", dataIndex:"courseName",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"main", layout:"form", autoScroll:true,width:210}) 
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["courseName"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.hr.training.dc.PositionCourse$PositionCtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.training.dc.PositionCourse$PositionCtxEditList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"courseCode", xtype:"gridcolumn", dataIndex:"courseCode",width:100,editor:{xtype:"net.nan21.dnet.module.hr.training.lovs.Courses" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "courseId"} ,{lovField:"name", dsField: "courseName"} ]} })
		.addTextColumn({ name:"courseName", dataIndex:"courseName",width:200 })
		.addDateColumn({ name:"validFor", dataIndex:"validFor",format:Dnet.DATETIME_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addNumberColumn({ name:"positionId", dataIndex:"positionId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"courseId", dataIndex:"courseId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.hr.training.dc.PositionCourse$CourseCtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.training.dc.PositionCourse$CourseCtxEditList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"positionCode", xtype:"gridcolumn", dataIndex:"positionCode",width:100,editor:{xtype:"net.nan21.dnet.module.hr.job.lovs.Positions" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "positionId"} ,{lovField:"name", dsField: "positionName"} ]} })
		.addTextColumn({ name:"positionName", dataIndex:"positionName",width:200 })
		.addDateColumn({ name:"validFor", dataIndex:"validFor",format:Dnet.DATETIME_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addNumberColumn({ name:"positionId", dataIndex:"positionId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"courseId", dataIndex:"courseId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
