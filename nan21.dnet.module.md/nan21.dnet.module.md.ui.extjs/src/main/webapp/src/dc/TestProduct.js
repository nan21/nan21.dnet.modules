   

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductDs",
	filterModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.prod.ds.param.ProductDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.TestProduct$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"storable", dataIndex:"storable",anchor:"-20"  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"showInCatalog", dataIndex:"showInCatalog",anchor:"-20"  })
		.addLov({ name:"manufacturerCode", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductManufacturers", dataIndex:"manufacturerCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]  })
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo",anchor:"-20",maxLength:32  })
		.addLov({ name:"attributeGroup", xtype:"net.nan21.dnet.module.md.base.attr.lovs.AttributeGroup", dataIndex:"attributeGroup",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "attributeGroupId"} ]  })
		.addLov({ name:"productCategory", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductCategories", paramIndex:"productCategory",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "productCategoryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:150, defaults:{
labelAlign:"right",labelWidth:70}}) 
		.addPanel({ name:"col3", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name","code","manufacturerCode","manufacturerProductNo"])
		.addChildrenTo("col2",["storable","active","showInCatalog"])
		.addChildrenTo("col3",["attributeGroup","productCategory"])
    	.addAuditFilter()	
	}
}); 
 	
 	

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct$FilterPG", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
 	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.TestProduct$FilterPG",
	_defineElements_: function () {	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",maxLength:32  })
		.addBooleanField({ name:"storable", dataIndex:"storable",anchor:"-20"  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"showInCatalog", dataIndex:"showInCatalog",anchor:"-20"  })
		.addNumberField({ name:"manufacturerId", dataIndex:"manufacturerId"  })
		.addLov({ name:"manufacturerCode", dataIndex:"manufacturerCode",editor:{ xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductManufacturers", selectOnFocus:true,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]}  })
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo",maxLength:32  })
		.addLov({ name:"attributeGroup", dataIndex:"attributeGroup",editor:{ xtype:"net.nan21.dnet.module.md.base.attr.lovs.AttributeGroup", selectOnFocus:true,retFieldMapping: [{lovField:"id", dsField: "attributeGroupId"} ]}  })
		.addLov({ name:"productCategory", paramIndex:"productCategory",editor:{ xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductCategories", selectOnFocus:true,retFieldMapping: [{lovField:"id", dsParam: "productCategoryId"} ]}  })
		 
		
	}
	
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.mm.prod.dc.TestProduct$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active", width:60})   	     
		.addBooleanColumn({ name:"storable", dataIndex:"storable", width:60})   	     
		.addBooleanColumn({ name:"showInCatalog", dataIndex:"showInCatalog", width:60})   	     
		.addNumberColumn({ name:"defaultUomId", dataIndex:"defaultUomId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"defaultUomCode", dataIndex:"defaultUomCode",width:100 })   	
		.addTextColumn({ name:"attributeGroup", dataIndex:"attributeGroup",width:120 })   	
		.addNumberColumn({ name:"manufacturerId", dataIndex:"manufacturerId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"manufacturerCode", dataIndex:"manufacturerCode",width:100 })   	
		.addTextColumn({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", hidden:true,width:100 })   	
		.addNumberColumn({ name:"weight", dataIndex:"weight",decimals:2 })  
		.addNumberColumn({ name:"weightUomId", dataIndex:"weightUomId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"weightUomCode", dataIndex:"weightUomCode",width:100 })   	
		.addNumberColumn({ name:"volume", dataIndex:"volume", hidden:true,decimals:2 })  
		.addNumberColumn({ name:"volumeUomId", dataIndex:"volumeUomId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"volumeUomCode", dataIndex:"volumeUomCode", hidden:true,width:100 })   	
		.addNumberColumn({ name:"dimWidth", dataIndex:"dimWidth", hidden:true,decimals:2 })  
		.addNumberColumn({ name:"dimHeight", dataIndex:"dimHeight", hidden:true,decimals:2 })  
		.addNumberColumn({ name:"dimDepth", dataIndex:"dimDepth", hidden:true,decimals:2 })  
		.addNumberColumn({ name:"dimUomId", dataIndex:"dimUomId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"dimUomCode", dataIndex:"dimUomCode", hidden:true,width:100 })   	
		.addTextColumn({ name:"iconUrl", dataIndex:"iconUrl", hidden:true,width:100 })   	
		.addTextColumn({ name:"imageUrl", dataIndex:"imageUrl", hidden:true,width:100 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.TestProduct$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addBooleanColumn({ name:"active", dataIndex:"active", width:60})
		.addBooleanColumn({ name:"storable", dataIndex:"storable", width:60})
		.addBooleanColumn({ name:"showInCatalog", dataIndex:"showInCatalog", width:60})
		.addNumberColumn({ name:"defaultUomId", dataIndex:"defaultUomId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({name:"defaultUomCode", xtype:"gridcolumn", dataIndex:"defaultUomCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure" , selectOnFocus:true,allowBlank:false ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "defaultUomId"} ]} })
		.addTextColumn({ name:"attributeGroup", dataIndex:"attributeGroup",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addNumberColumn({ name:"manufacturerId", dataIndex:"manufacturerId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextColumn({ name:"manufacturerCode", dataIndex:"manufacturerCode",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addTextColumn({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", hidden:true,width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addNumberColumn({ name:"weight", dataIndex:"weight", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"weightUomId", dataIndex:"weightUomId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextColumn({ name:"weightUomCode", dataIndex:"weightUomCode",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addNumberColumn({ name:"volume", dataIndex:"volume", hidden:true, align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"volumeUomId", dataIndex:"volumeUomId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextColumn({ name:"volumeUomCode", dataIndex:"volumeUomCode", hidden:true,width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addNumberColumn({ name:"dimWidth", dataIndex:"dimWidth", hidden:true, align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"dimHeight", dataIndex:"dimHeight", hidden:true, align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"dimDepth", dataIndex:"dimDepth", hidden:true, align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"dimUomId", dataIndex:"dimUomId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextColumn({ name:"dimUomCode", dataIndex:"dimUomCode", hidden:true,width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addTextColumn({ name:"iconUrl", dataIndex:"iconUrl", hidden:true,width:100,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"imageUrl", dataIndex:"imageUrl", hidden:true,width:100,editor:{xtype:"textfield", selectOnFocus:true } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.TestProduct$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code" ,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addCheckbox({ name:"showInCatalog", dataIndex:"showInCatalog"  })
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo" ,maxLength:32  })
		.addLov({ name:"manufacturerCode", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductManufacturers", dataIndex:"manufacturerCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]  })
		.addLov({ name:"attributeGroup", xtype:"net.nan21.dnet.module.md.base.attr.lovs.AttributeGroup", dataIndex:"attributeGroup" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "attributeGroupId"} ]  })
		.addLov({ name:"defaultUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"defaultUomCode" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "defaultUomId"} ]  })
		.addCheckbox({ name:"storable", dataIndex:"storable"  })
		.addNumberField({ name:"weight", dataIndex:"weight"  , style: "text-align:right;" })
		.addLov({ name:"weightUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UomMass", dataIndex:"weightUomCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "weightUomId"} ]  })
		.addNumberField({ name:"volume", dataIndex:"volume"  , style: "text-align:right;" })
		.addNumberField({ name:"volumeUomId", dataIndex:"volumeUomId",noEdit:true   , style: "text-align:right;" })
		.addLov({ name:"volumeUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UomVolume", dataIndex:"volumeUomCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "volumeUomId"} ]  })
		.addNumberField({ name:"dimWidth", dataIndex:"dimWidth"  , style: "text-align:right;" })
		.addNumberField({ name:"dimHeight", dataIndex:"dimHeight"  , style: "text-align:right;" })
		.addNumberField({ name:"dimDepth", dataIndex:"dimDepth"  , style: "text-align:right;" })
		.addNumberField({ name:"dimUomId", dataIndex:"dimUomId",noEdit:true   , style: "text-align:right;" })
		.addLov({ name:"dimUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UomLength", dataIndex:"dimUomCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "dimUomId"} ]  })
		.addTextField({ name:"iconUrl", dataIndex:"iconUrl" ,maxLength:255  })
		.addTextField({ name:"imageUrl", dataIndex:"imageUrl" ,maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"col3", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["name","code","defaultUomCode","attributeGroup","manufacturerCode","manufacturerProductNo"])
		.addChildrenTo("col2",["storable","weight","weightUomCode","volume","volumeUomCode","dimWidth","dimHeight","dimDepth","dimUomCode"])
		.addChildrenTo("col3",["active","showInCatalog","iconUrl","imageUrl"])
;
	}	
});
 	
 	

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct$EditPG", {
	extend: "dnet.core.dc.AbstractDcvEditPropGrid",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.TestProduct$EditPG",
	
	_defineElements_: function () {	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",editor:{ selectOnFocus:true,allowBlank:false } })
		.addTextField({ name:"code", dataIndex:"code",editor:{ selectOnFocus:true ,maxLength:32} })
		.addBooleanField({ name:"active", dataIndex:"active"  })
		.addBooleanField({ name:"showInCatalog", dataIndex:"showInCatalog"  })
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo",editor:{ selectOnFocus:true ,maxLength:32} })
		.addLov({ name:"manufacturerCode", dataIndex:"manufacturerCode",editor:{ xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductManufacturers", selectOnFocus:true,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]}  })
		.addLov({ name:"attributeGroup", dataIndex:"attributeGroup",editor:{ xtype:"net.nan21.dnet.module.md.base.attr.lovs.AttributeGroup", selectOnFocus:true,retFieldMapping: [{lovField:"id", dsField: "attributeGroupId"} ]}  })
		.addNumberField({ name:"defaultUomId", dataIndex:"defaultUomId",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({ name:"defaultUomCode", dataIndex:"defaultUomCode",editor:{ xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", selectOnFocus:true,allowBlank:false,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "defaultUomId"} ]}  })
		.addBooleanField({ name:"storable", dataIndex:"storable"  })
		.addNumberField({ name:"weight", dataIndex:"weight",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addLov({ name:"weightUomCode", dataIndex:"weightUomCode",editor:{ xtype:"net.nan21.dnet.module.bd.uom.lovs.UomMass", selectOnFocus:true,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "weightUomId"} ]}  })
		.addNumberField({ name:"volume", dataIndex:"volume",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberField({ name:"volumeUomId", dataIndex:"volumeUomId",editor:{xtype:"textfield", noEdit:true} })
		.addLov({ name:"volumeUomCode", dataIndex:"volumeUomCode",editor:{ xtype:"net.nan21.dnet.module.bd.uom.lovs.UomVolume", selectOnFocus:true,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "volumeUomId"} ]}  })
		.addNumberField({ name:"dimWidth", dataIndex:"dimWidth",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberField({ name:"dimHeight", dataIndex:"dimHeight",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberField({ name:"dimDepth", dataIndex:"dimDepth",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberField({ name:"dimUomId", dataIndex:"dimUomId",editor:{xtype:"textfield", noEdit:true} })
		.addLov({ name:"dimUomCode", dataIndex:"dimUomCode",editor:{ xtype:"net.nan21.dnet.module.bd.uom.lovs.UomLength", selectOnFocus:true,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "dimUomId"} ]}  })
		.addTextField({ name:"iconUrl", dataIndex:"iconUrl",editor:{ selectOnFocus:true } })
		.addTextField({ name:"imageUrl", dataIndex:"imageUrl",editor:{ selectOnFocus:true } })
		;     
	}
	 	
});
 	
