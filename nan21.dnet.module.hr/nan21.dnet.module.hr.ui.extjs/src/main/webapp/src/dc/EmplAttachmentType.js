   
Ext.ns('net.nan21.dnet.module.hr.employee.dc');	 
net.nan21.dnet.module.hr.employee.dc.EmplAttachmentType = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"EmplAttachmentType" 		 
			,ds: new net.nan21.dnet.module.hr.employee.ds.EmplAttachmentTypeDs()			  
		});
	 	net.nan21.dnet.module.hr.employee.dc.EmplAttachmentType.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.hr.employee.dc'); 
net.nan21.dnet.module.hr.employee.dc.EmplAttachmentType$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active"  })
		.addCombo({ name:"category", xtype:"combo", dataIndex:"category", id:Ext.id(),anchor:"-20",store:[ "image", "document"]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","category"])
		.addChildrenTo("col2",["active"])
	}
}); 
Ext.reg("net.nan21.dnet.module.hr.employee.dc.EmplAttachmentType$Filter", net.nan21.dnet.module.hr.employee.dc.EmplAttachmentType$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.hr.employee.dc');	 	 
net.nan21.dnet.module.hr.employee.dc.EmplAttachmentType$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addTextColumn({ name:"uploadPath", dataIndex:"uploadPath",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addTextColumn({ name:"baseUrl", dataIndex:"baseUrl",width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addComboColumn({ name:"category", dataIndex:"category", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv' ,store:[ "image", "document"] , triggerAction:'all', forceSelection:true }})
		.addBooleanColumn({ name:"active", dataIndex:"active"})

		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.hr.employee.dc.EmplAttachmentType$EditList", net.nan21.dnet.module.hr.employee.dc.EmplAttachmentType$EditList ); 
