   
Ext.ns('net.nan21.dnet.module.hr.job.dc');	 
net.nan21.dnet.module.hr.job.dc.Position = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Position" 		 
			,ds: new net.nan21.dnet.module.hr.job.ds.PositionDs()			  
		});
	 	net.nan21.dnet.module.hr.job.dc.Position.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.job.dc'); 
net.nan21.dnet.module.hr.job.dc.Position$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addLov({ name:"organizationCode", xtype:"net.nan21.dnet.module.bd.org.lovs.Organizations", dataIndex:"organizationCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]  })
		.addLov({ name:"jobCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Jobs", dataIndex:"jobCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "jobId"} ]  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form", width:250,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["jobCode","active"])
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.job.dc.Position$Filter", net.nan21.dnet.module.hr.job.dc.Position$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.job.dc');	 	 
net.nan21.dnet.module.hr.job.dc.Position$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name", width:250 })   	
		.addTextColumn({ name:"code", dataIndex:"code", width:150 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addNumberColumn({ name:"jobId", dataIndex:"jobId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"jobCode", dataIndex:"jobCode", width:150 })   	
		.addTextColumn({ name:"organizationCode", dataIndex:"organizationCode", width:150 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.hr.job.dc.Position$List", net.nan21.dnet.module.hr.job.dc.Position$List ); 
 	
Ext.ns('net.nan21.dnet.module.hr.job.dc');	 
net.nan21.dnet.module.hr.job.dc.Position$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32,vtype:"alphanum"  })
		.addLov({ name:"organizationCode", xtype:"net.nan21.dnet.module.bd.org.lovs.Organizations", dataIndex:"organizationCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]  })
		.addLov({ name:"jobCode", xtype:"net.nan21.dnet.module.hr.job.lovs.Jobs", dataIndex:"jobCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "jobId"} ]  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:350,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" , width:300,labelAlign:"top",labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","organizationCode","jobCode","active"])
		.addChildrenTo("col2",["notes"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.hr.job.dc.Position$Edit", net.nan21.dnet.module.hr.job.dc.Position$Edit ); 
