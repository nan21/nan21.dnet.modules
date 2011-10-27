   

Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScaleRate", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateDs",
	filterModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateDsFilter",
	paramModel: "net.nan21.dnet.module.hr.grade.ds.param.PayScaleRateDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScaleRate$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.grade.dc.PayScaleRate$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addLov({ name:"payScaleCode", xtype:"net.nan21.dnet.module.hr.grade.lovs.PayScales", dataIndex:"payScaleCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "payScaleId"} ]  })
		.addLov({ name:"currencyCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currencyCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name"])
		.addChildrenTo("col2",["payScaleCode","currencyCode"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScaleRate$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.grade.dc.PayScaleRate$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
		.addNumberColumn({ name:"payScaleId", dataIndex:"payScaleId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"payScaleCode", dataIndex:"payScaleCode",width:100 })   	
		.addTextColumn({ name:"payScaleName", dataIndex:"payScaleName",width:200 })   	
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
 
 	

Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScaleRate$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.hr.grade.dc.PayScaleRate$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"description", dataIndex:"description",height:60, width:300   })
		.addLov({ name:"payScaleCode", xtype:"net.nan21.dnet.module.hr.grade.lovs.PayScales", dataIndex:"payScaleCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "payScaleId"} ]  })
		.addLov({ name:"currencyCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currencyCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300})     
		.addPanel({ name:"col2", layout:"anchor" , width:300})     
		.addPanel({ name:"col3", layout:"anchor" , width:300, defaults:{
labelAlign:"top"}})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["name","active"])
		.addChildrenTo("col2",["payScaleCode","currencyCode"])
		.addChildrenTo("col3",["description"])
;
	}	
});
