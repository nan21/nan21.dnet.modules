   
Ext.ns('net.nan21.dnet.module.mm.md.dc');	 
net.nan21.dnet.module.mm.md.dc.ProductAttribute = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"ProductAttribute" 		 
			,ds: new net.nan21.dnet.module.mm.md.ds.ProductAttributeDs()			  
		});
	 	net.nan21.dnet.module.mm.md.dc.ProductAttribute.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.mm.md.dc'); 
net.nan21.dnet.module.mm.md.dc.ProductAttribute$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"title", dataIndex:"title",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active"  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductAttributeType", dataIndex:"type",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		.addLov({ name:"uomType", xtype:"net.nan21.dnet.module.bd.uom.lovs.UomType", dataIndex:"uomType",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "uomTypeId"} ]  })
		.addCombo({ name:"dataType", xtype:"combo", dataIndex:"dataType", id:Ext.id(),anchor:"-20",store:[ "string", "text", "integer", "decimal", "boolean", "date"]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col3", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name","active"])
		.addChildrenTo("col2",["type","dataType"])
		.addChildrenTo("col3",["uomType"])
	}
}); 
Ext.reg("net.nan21.dnet.module.mm.md.dc.ProductAttribute$Filter", net.nan21.dnet.module.mm.md.dc.ProductAttribute$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.mm.md.dc');	 	 
net.nan21.dnet.module.mm.md.dc.ProductAttribute$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"title", dataIndex:"title",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
		.addLov({name:"type", xtype:"gridcolumn", dataIndex:"type",width:120,editor:{xtype:"net.nan21.dnet.module.mm.md.lovs.ProductAttributeType" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]} })
		.addComboColumn({ name:"dataType", dataIndex:"dataType", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv' ,store:[ "string", "text", "integer", "decimal", "boolean", "date"] , triggerAction:'all', forceSelection:true }})
		.addLov({name:"uomType", xtype:"gridcolumn", dataIndex:"uomType",width:120,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UomType" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "uomTypeId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})

		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.mm.md.dc.ProductAttribute$EditList", net.nan21.dnet.module.mm.md.dc.ProductAttribute$EditList ); 
