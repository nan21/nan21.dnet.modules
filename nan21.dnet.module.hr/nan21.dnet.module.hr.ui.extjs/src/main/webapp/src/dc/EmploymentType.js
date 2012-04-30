   

Ext.define("net.nan21.dnet.module.hr.employee.dc.EmploymentType", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmploymentTypeDs",
	filterModel: "net.nan21.dnet.module.hr.employee.ds.model.EmploymentTypeDsFilter",
	paramModel: "net.nan21.dnet.module.hr.employee.ds.param.EmploymentTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.hr.employee.dc.EmploymentType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.hr.employee.dc.EmploymentType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["name","active"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.hr.employee.dc.EmploymentType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.hr.employee.dc.EmploymentType$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name", width:200,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false } })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
