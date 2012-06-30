   

Ext.define("net.nan21.dnet.module.bd.attr.dc.Attribute", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeDs",
	filterModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeDsFilter",
	paramModel: "net.nan21.dnet.module.bd.attr.ds.param.AttributeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.attr.dc.Attribute$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.attr.dc.Attribute$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"title", dataIndex:"title",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"category", xtype:"net.nan21.dnet.module.bd.attr.lovs.AttributeCategory", dataIndex:"category",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]  })
		.addLov({ name:"uom", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"uom",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]  })
		.addCombo({ name:"dataType", xtype:"combo", dataIndex:"dataType",anchor:"-20",store:[ "string", "text", "integer", "decimal", "boolean", "date"]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"col3", layout:"form", width:170}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name","dataType"])
		.addChildrenTo("col2",["category","uom"])
		.addChildrenTo("col3",["active"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.attr.dc.Attribute$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.attr.dc.Attribute$EditList",
	
	_bulkEditFields_ : ["active","category","dataType","uom"],
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"title", dataIndex:"title",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"listOfvalues", dataIndex:"listOfvalues",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addLov({name:"category", xtype:"gridcolumn", dataIndex:"category",width:120,editor:{xtype:"net.nan21.dnet.module.bd.attr.lovs.AttributeCategory" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]} })
		.addComboColumn({ name:"dataType", dataIndex:"dataType", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true 	, valueField: 'bv', displayField: 'tv' ,store:[ "string", "text", "integer", "decimal", "boolean", "date"] , triggerAction:'all', forceSelection:true }})
		.addLov({name:"uom", xtype:"gridcolumn", dataIndex:"uom", width:80,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasureCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active", width:60})
		.addNumberColumn({ name:"categoryId", dataIndex:"categoryId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
