   

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.Product", {
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



 	

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.Product$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.Product$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"storable", dataIndex:"storable",anchor:"-20"  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"sale", dataIndex:"sale",anchor:"-20"  })
		.addBooleanField({ name:"purchase", dataIndex:"purchase",anchor:"-20"  })
		.addBooleanField({ name:"showInCatalog", dataIndex:"showInCatalog",anchor:"-20"  })
		.addLov({ name:"manufacturerCode", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductManufacturers", dataIndex:"manufacturerCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]  })
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo",anchor:"-20",maxLength:32  })
		.addLov({ name:"attributeGroup", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductAttributeGroup", dataIndex:"attributeGroup",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "attributeGroupId"} ]  })
		.addLov({ name:"productCategory", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductCategories", paramIndex:"productCategory",anchor:"-20",retFieldMapping: [{lovField:"id", dsParam: "productCategoryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:150, defaults:{
labelAlign:"right",labelWidth:70}}) 
		.addPanel({ name:"col3", layout:"form", width:150, defaults:{
labelAlign:"right",labelWidth:70}}) 
		.addPanel({ name:"col4", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["name","code","manufacturerCode","manufacturerProductNo"])
		.addChildrenTo("col2",["storable","active","showInCatalog"])
		.addChildrenTo("col3",["sale","purchase"])
		.addChildrenTo("col4",["attributeGroup","productCategory"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.Product$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.mm.prod.dc.Product$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active", width:60})   	     
		.addBooleanColumn({ name:"storable", dataIndex:"storable", width:60})   	     
		.addBooleanColumn({ name:"sale", dataIndex:"sale", width:60})   	     
		.addBooleanColumn({ name:"purchase", dataIndex:"purchase", width:60})   	     
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
 
 	
 	

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.Product$CtxFormName", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.Product$CtxFormName",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDisplayFieldText({ name:"name", dataIndex:"name", fieldCls:"displayfield important-field"  })
		//containers
		.addPanel({ name:"main", layout:"form" , autoScroll:true, width:"90%"})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["name"])
;
	}	
});
 	
 	

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.Product$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.Product$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addCheckbox({ name:"showInCatalog", dataIndex:"showInCatalog"  })
		.addCheckbox({ name:"sale", dataIndex:"sale"  })
		.addCheckbox({ name:"purchase", dataIndex:"purchase"  })
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo",anchor:"-20" ,maxLength:32  })
		.addLov({ name:"manufacturerCode", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductManufacturers", dataIndex:"manufacturerCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]  })
		.addLov({ name:"attributeGroup", xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductAttributeGroup", dataIndex:"attributeGroup",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "attributeGroupId"} ]  })
		.addLov({ name:"defaultUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"defaultUomCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "defaultUomId"} ]  })
		//containers
		.addPanel({ name:"row1", layout:"form" , width:700})     
		.addPanel({ name:"col1", layout:"form" , width:350})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"col3", layout:"form" , width:200})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		.addPanel({ name:"row2",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["row1" ,"row2" ])
		.addChildrenTo("row1",["name"])
		.addChildrenTo("row2",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["code","defaultUomCode","attributeGroup"])
		.addChildrenTo("col2",["manufacturerCode","manufacturerProductNo"])
		.addChildrenTo("col3",["active","showInCatalog","sale","purchase"])
;
	}	
});
 	
 	

Ext.define("net.nan21.dnet.module.md.mm.prod.dc.Product$EditInfo", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.dc.Product$EditInfo",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addCheckbox({ name:"storable", dataIndex:"storable"  })
		.addNumberField({ name:"weight", dataIndex:"weight",anchor:"-20"  , style: "text-align:right;" })
		.addLov({ name:"weightUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UomMass", dataIndex:"weightUomCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "weightUomId"} ]  })
		.addNumberField({ name:"volume", dataIndex:"volume",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"volumeUomId", dataIndex:"volumeUomId",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		.addLov({ name:"volumeUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UomVolume", dataIndex:"volumeUomCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "volumeUomId"} ]  })
		.addNumberField({ name:"dimWidth", dataIndex:"dimWidth",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"dimHeight", dataIndex:"dimHeight",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"dimDepth", dataIndex:"dimDepth",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"dimUomId", dataIndex:"dimUomId",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		.addLov({ name:"dimUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UomLength", dataIndex:"dimUomCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "dimUomId"} ]  })
		.addTextField({ name:"iconUrl", dataIndex:"iconUrl",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"imageUrl", dataIndex:"imageUrl",anchor:"-20" ,maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"form" ,title:"Physical", width:250,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"col2", layout:"form" ,title:"Dimensions", width:250,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"col3", layout:"form" ,title:"Image", width:400,xtype:"fieldset", border:true, collapsible:true, defaults:{
labelAlign:"top"}})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["storable","weight","weightUomCode","volume","volumeUomCode"])
		.addChildrenTo("col2",["dimWidth","dimHeight","dimDepth","dimUomCode"])
		.addChildrenTo("col3",["iconUrl","imageUrl"])
;
	}	
});
 	
