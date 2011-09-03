   
Ext.ns('net.nan21.dnet.module.hr.time.dc');	 
net.nan21.dnet.module.hr.time.dc.AbsenceReason = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"AbsenceReason" 		 
			,ds: new net.nan21.dnet.module.hr.time.ds.AbsenceReasonDs()			  
		});
	 	net.nan21.dnet.module.hr.time.dc.AbsenceReason.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.time.dc'); 
net.nan21.dnet.module.hr.time.dc.AbsenceReason$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.hr.time.lovs.AbsenceTypes", dataIndex:"type",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		//containers
		.addPanel({ name:"main", layout:"hbox", autoScroll:true, defaults:{labelAlign:"right",labelWidth:80,width:210 }})
	}
	,_linkElements_: function () {
		this._getBuilder_()
		this._elems_.get("main")["items"] = [
	    {layout:"form", border:false 
	      ,items:[ this._elems_.get("name")] }
	  ,	    {layout:"form", border:false 
	      ,items:[ this._elems_.get("type")] }
];
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.time.dc.AbsenceReason$Filter", net.nan21.dnet.module.hr.time.dc.AbsenceReason$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.time.dc');	 	 
net.nan21.dnet.module.hr.time.dc.AbsenceReason$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addLov({name:"type", xtype:"gridcolumn", dataIndex:"type",width:120,editor:{xtype:"net.nan21.dnet.module.hr.time.lovs.AbsenceTypes" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})

		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.hr.time.dc.AbsenceReason$EditList", net.nan21.dnet.module.hr.time.dc.AbsenceReason$EditList ); 
