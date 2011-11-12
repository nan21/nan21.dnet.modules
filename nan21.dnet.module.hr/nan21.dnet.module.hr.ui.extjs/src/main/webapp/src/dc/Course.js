   

Ext.define("net.nan21.dnet.module.hr.training.dc.Course", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.training.ds.model.CourseDs",
	filterModel: "net.nan21.dnet.module.hr.training.ds.model.CourseDsFilter",
	paramModel: "net.nan21.dnet.module.hr.training.ds.param.CourseDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.hr.training.dc.Course$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.training.dc.Course$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.training.lovs.CourseTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["type","active"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.hr.training.dc.Course$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.training.dc.Course$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"deliveredCompetences", dataIndex:"deliveredCompetences", hidden:true,width:200 })   	
		.addTextColumn({ name:"intendedAudience", dataIndex:"intendedAudience", hidden:true,width:200 })   	
		.addTextColumn({ name:"requirements", dataIndex:"requirements", hidden:true,width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.hr.training.dc.Course$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.hr.training.dc.Course$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextField({ name:"notes", dataIndex:"notes",anchor:"-20" ,maxLength:4000  })
		.addTextArea({ name:"deliveredCompetences", dataIndex:"deliveredCompetences",height:80,anchor:"-20"   })
		.addTextArea({ name:"intendedAudience", dataIndex:"intendedAudience",height:80,anchor:"-20"   })
		.addTextArea({ name:"requirements", dataIndex:"requirements",height:80,anchor:"-20"   })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.training.lovs.CourseTypes", dataIndex:"type",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:600})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ])
		.addChildrenTo("col1",["name","code","deliveredCompetences","intendedAudience","requirements","type","active"])
;
	}	
});
