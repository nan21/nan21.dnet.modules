   

Ext.define("net.nan21.dnet.module.hr.payroll.dc.Element", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.ElementDs",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.param.ElementDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.hr.payroll.dc.Element$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.Element$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addCombo({ name:"dataType", xtype:"combo", dataIndex:"dataType", id:Ext.id(),anchor:"-20",store:[ "string", "number", "boolean", "date"]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.payroll.lovs.ElementTypes", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"anchor", width:250,labelWidth:0 })
		.addPanel({ name:"col3", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["type","dataType"])
		.addChildrenTo("col3",["active"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.Element$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.payroll.dc.Element$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"dataType", dataIndex:"dataType",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.hr.payroll.dc.Element$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.Element$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32,vtype:"alphanum"  })
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addCombo({ name:"dataType", xtype:"combo", dataIndex:"dataType",anchor:"-20" ,allowBlank:false,store:[ "string", "number", "boolean", "date"]  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.payroll.lovs.ElementTypes", dataIndex:"type",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"anchor" ,width:250,labelWidth:0 })     
		.addPanel({ name:"col3", layout:"anchor" , width:350,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["name","code","type"])
		.addChildrenTo("col2",["dataType","active"])
		.addChildrenTo("col3",["notes"])
;
	}	
});
