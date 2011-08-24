   
Ext.ns('net.nan21.dnet.module.hr.payroll.dc');	 
net.nan21.dnet.module.hr.payroll.dc.Payroll = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Payroll" 		 
			,ds: new net.nan21.dnet.module.hr.payroll.ds.PayrollDs()			  
		});
	 	net.nan21.dnet.module.hr.payroll.dc.Payroll.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.payroll.dc'); 
net.nan21.dnet.module.hr.payroll.dc.Payroll$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addCombo({ name:"periodType", xtype:"combo", dataIndex:"periodType", id:Ext.id(),anchor:"-20",store:[ "calendar-month", "semi-month"]  })
		//containers
		.addPanel({ name:"main", layout:"hbox", autoScroll:true, defaults:{labelAlign:"right",labelWidth:80,width:210 }})
	}
	,_linkElements_: function () {
		this._getBuilder_()
		this._elems_.get("main")["items"] = [
	    {layout:"form", border:false 
	      ,items:[ this._elems_.get("name")] }
	  ,	    {layout:"form", border:false 
	      ,items:[ this._elems_.get("periodType")] }
];
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.payroll.dc.Payroll$Filter", net.nan21.dnet.module.hr.payroll.dc.Payroll$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.payroll.dc');	 	 
net.nan21.dnet.module.hr.payroll.dc.Payroll$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
		.addTextColumn({ name:"periodType", dataIndex:"periodType",width:100 })   	
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
 
Ext.reg("net.nan21.dnet.module.hr.payroll.dc.Payroll$List", net.nan21.dnet.module.hr.payroll.dc.Payroll$List ); 
 	
Ext.ns('net.nan21.dnet.module.hr.payroll.dc');	 
net.nan21.dnet.module.hr.payroll.dc.Payroll$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"description", dataIndex:"description",height:60,anchor:"-20"   })
		.addCombo({ name:"periodType", xtype:"combo", dataIndex:"periodType",anchor:"-20",allowBlank:false,store:[ "calendar-month", "semi-month"]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" , width:350,labelWidth:0 })     
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
Ext.reg("net.nan21.dnet.module.hr.payroll.dc.Payroll$Edit", net.nan21.dnet.module.hr.payroll.dc.Payroll$Edit ); 
