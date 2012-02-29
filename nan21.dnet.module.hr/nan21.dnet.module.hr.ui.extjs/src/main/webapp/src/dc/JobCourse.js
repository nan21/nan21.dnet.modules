   

Ext.define("net.nan21.dnet.module.hr.training.dc.JobCourse", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.training.ds.model.JobCourseDs",
	filterModel: "net.nan21.dnet.module.hr.training.ds.model.JobCourseDsFilter",
	paramModel: "net.nan21.dnet.module.hr.training.ds.param.JobCourseDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.training.dc.JobCourse$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.training.dc.JobCourse$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"courseCode", dataIndex:"courseCode",anchor:"-20",maxLength:32  })
		//containers
		.addPanel({ name:"main", layout:"form", autoScroll:true,width:210}) 
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["courseCode"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.hr.training.dc.JobCourse$JobCtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.training.dc.JobCourse$JobCtxEditList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"courseCode", xtype:"gridcolumn", dataIndex:"courseCode",width:100,editor:{xtype:"net.nan21.dnet.module.hr.training.lovs.Courses" , selectOnFocus:true ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "courseId"} ,{lovField:"name", dsField: "courseName"} ]} })
		.addTextColumn({ name:"courseName", dataIndex:"courseName",width:200 })
		.addNumberColumn({ name:"validFor", dataIndex:"validFor", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"jobId", dataIndex:"jobId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"courseId", dataIndex:"courseId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	 
Ext.define("net.nan21.dnet.module.hr.training.dc.JobCourse$CourseCtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.training.dc.JobCourse$CourseCtxEditList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"jobCode", xtype:"gridcolumn", dataIndex:"jobCode",width:100,editor:{xtype:"net.nan21.dnet.module.hr.job.lovs.Jobs" , selectOnFocus:true ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "jobId"} ,{lovField:"name", dsField: "jobName"} ]} })
		.addTextColumn({ name:"jobName", dataIndex:"jobName",width:200 })
		.addNumberColumn({ name:"validFor", dataIndex:"validFor", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"jobId", dataIndex:"jobId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"courseId", dataIndex:"courseId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
