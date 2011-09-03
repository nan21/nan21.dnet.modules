   
Ext.ns('net.nan21.dnet.module.bd.uom.dc');	 
net.nan21.dnet.module.bd.uom.dc.UomType = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"UomType" 		 
			,ds: new net.nan21.dnet.module.bd.uom.ds.UomTypeDs()			  
		});
	 	net.nan21.dnet.module.bd.uom.dc.UomType.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bd.uom.dc'); 
net.nan21.dnet.module.bd.uom.dc.UomType$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active"  })
		.addCombo({ name:"category", xtype:"combo", dataIndex:"category", id:Ext.id(),anchor:"-20",store:[ "length", "mass", "volume", "other"]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","active"])
		.addChildrenTo("col2",["category"])
	}
}); 
Ext.reg("net.nan21.dnet.module.bd.uom.dc.UomType$Filter", net.nan21.dnet.module.bd.uom.dc.UomType$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bd.uom.dc');	 	 
net.nan21.dnet.module.bd.uom.dc.UomType$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"category", dataIndex:"category",width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:16,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "16"}} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})

		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.bd.uom.dc.UomType$EditList", net.nan21.dnet.module.bd.uom.dc.UomType$EditList ); 
