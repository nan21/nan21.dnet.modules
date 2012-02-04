   

Ext.define("net.nan21.dnet.module.hr.payroll.dc.Payroll", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollDs",
	filterModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollDsFilter",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.param.PayrollDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.payroll.dc.Payroll$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.Payroll$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addCombo({ name:"periodType", xtype:"combo", dataIndex:"periodType",anchor:"-20",store:[ "calendar-month", "semi-month"]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["name","periodType"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.hr.payroll.dc.Payroll$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.hr.payroll.dc.Payroll$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
		.addTextColumn({ name:"periodType", dataIndex:"periodType",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.hr.payroll.dc.Payroll$Edit", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.hr.payroll.dc.Payroll$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"description", dataIndex:"description",height:60,anchor:"-20"   })
		.addCombo({ name:"periodType", xtype:"localcombo", dataIndex:"periodType",anchor:"-20" ,allowBlank:false,store:[ "calendar-month", "semi-month"]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300})     
		.addPanel({ name:"col2", layout:"anchor" , width:350})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","periodType","active"])
		.addChildrenTo("col2",["description"])
;
	}	
});
