   
Ext.ns('net.nan21.dnet.module.hr.grade.dc');	 
net.nan21.dnet.module.hr.grade.dc.GradeRate = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"GradeRate" 		 
			,ds: new net.nan21.dnet.module.hr.grade.ds.GradeRateDs()			  
		});
	 	net.nan21.dnet.module.hr.grade.dc.GradeRate.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.grade.dc'); 
net.nan21.dnet.module.hr.grade.dc.GradeRate$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active"  })
		.addLov({ name:"currencyCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currencyCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name"])
		.addChildrenTo("col2",["currencyCode","active"])
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.grade.dc.GradeRate$Filter", net.nan21.dnet.module.hr.grade.dc.GradeRate$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.grade.dc');	 	 
net.nan21.dnet.module.hr.grade.dc.GradeRate$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"currencyCode", dataIndex:"currencyCode",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.hr.grade.dc.GradeRate$List", net.nan21.dnet.module.hr.grade.dc.GradeRate$List ); 
 	
Ext.ns('net.nan21.dnet.module.hr.grade.dc');	 
net.nan21.dnet.module.hr.grade.dc.GradeRate$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"description", dataIndex:"description",height:60, width:300   })
		.addLov({ name:"currencyCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currencyCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",width:100,disabled:true  ,allowBlank:false})
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",anchor:"-20",disabled:true  ,allowBlank:false,maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" , width:320,labelAlign:"top",labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","currencyCode","active"])
		.addChildrenTo("col2",["description"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.hr.grade.dc.GradeRate$Edit", net.nan21.dnet.module.hr.grade.dc.GradeRate$Edit ); 
