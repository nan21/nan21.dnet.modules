   
Ext.ns('net.nan21.dnet.module.hr.training.dc');	 
net.nan21.dnet.module.hr.training.dc.JobCourse = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"JobCourse" 		 
			,ds: new net.nan21.dnet.module.hr.training.ds.JobCourseDs()			  
		});
	 	net.nan21.dnet.module.hr.training.dc.JobCourse.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.training.dc'); 
net.nan21.dnet.module.hr.training.dc.JobCourse$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"courseCode", dataIndex:"courseCode",anchor:"-20",maxLength:32  })
		//containers
		.addPanel({ name:"main", layout:"form", autoScroll:true,width:210,labelWidth:0 })
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["courseCode"])
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.training.dc.JobCourse$Filter", net.nan21.dnet.module.hr.training.dc.JobCourse$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.training.dc');	 	 
net.nan21.dnet.module.hr.training.dc.JobCourse$JobCtxEditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addLov({name:"courseCode", xtype:"gridcolumn", dataIndex:"courseCode",width:100,editor:{xtype:"net.nan21.dnet.module.hr.training.lovs.Courses" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "courseId"} ,{lovField:"name", dsField: "courseName"} ]} })
		.addTextColumn({ name:"courseName", dataIndex:"courseName",width:200,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addNumberColumn({ name:"validFor", dataIndex:"validFor", align:"right",format:Ext.NUMBER_FORMAT_INT ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addNumberColumn({ name:"jobId", dataIndex:"jobId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"courseId", dataIndex:"courseId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.hr.training.dc.JobCourse$JobCtxEditList", net.nan21.dnet.module.hr.training.dc.JobCourse$JobCtxEditList ); 
 	
Ext.ns('net.nan21.dnet.module.hr.training.dc');	 	 
net.nan21.dnet.module.hr.training.dc.JobCourse$CourseCtxEditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addLov({name:"jobCode", xtype:"gridcolumn", dataIndex:"jobCode",width:100,editor:{xtype:"net.nan21.dnet.module.hr.job.lovs.Jobs" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "jobId"} ,{lovField:"name", dsField: "jobName"} ]} })
		.addTextColumn({ name:"jobName", dataIndex:"jobName",width:200,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addNumberColumn({ name:"validFor", dataIndex:"validFor", align:"right",format:Ext.NUMBER_FORMAT_INT ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addNumberColumn({ name:"jobId", dataIndex:"jobId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"courseId", dataIndex:"courseId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.hr.training.dc.JobCourse$CourseCtxEditList", net.nan21.dnet.module.hr.training.dc.JobCourse$CourseCtxEditList ); 
