   

Ext.define("net.nan21.dnet.module.mm.md.dc.Product", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProductDs",
	filterModel: "net.nan21.dnet.module.mm.md.ds.model.ProductDsFilter",
	paramModel: "net.nan21.dnet.module.mm.md.ds.param.ProductDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.mm.md.dc.Product$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.mm.md.dc.Product$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"storable", dataIndex:"storable",anchor:"-20"  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"manufacturerCode", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductManufacturers", dataIndex:"manufacturerCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]  })
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo",anchor:"-20",maxLength:32  })
		.addLov({ name:"attributeGroup", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductAttributeGroup", dataIndex:"attributeGroup",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "attributeGroupId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210, height:50}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"col3", layout:"anchor",width:210}) 
		.addPanel({ name:"col4", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["storable","active"])
		.addChildrenTo("col3",["manufacturerCode","manufacturerProductNo"])
		.addChildrenTo("col4",["attributeGroup"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.mm.md.dc.Product$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.mm.md.dc.Product$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addBooleanColumn({ name:"storable", dataIndex:"storable"})   	     
		.addNumberColumn({ name:"defaultUomId", dataIndex:"defaultUomId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"defaultUomCode", dataIndex:"defaultUomCode",width:100 })   	
		.addTextColumn({ name:"attributeGroup", dataIndex:"attributeGroup",width:120 })   	
		.addNumberColumn({ name:"manufacturerId", dataIndex:"manufacturerId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"manufacturerCode", dataIndex:"manufacturerCode",width:100 })   	
		.addTextColumn({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", hidden:true,width:100 })   	
		.addNumberColumn({ name:"weight", dataIndex:"weight",format:Ext.NUMBER_FORMAT_DEC })  
		.addNumberColumn({ name:"weightUomId", dataIndex:"weightUomId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"weightUomCode", dataIndex:"weightUomCode",width:100 })   	
		.addNumberColumn({ name:"volume", dataIndex:"volume", hidden:true,format:Ext.NUMBER_FORMAT_DEC })  
		.addNumberColumn({ name:"volumeUomId", dataIndex:"volumeUomId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"volumeUomCode", dataIndex:"volumeUomCode", hidden:true,width:100 })   	
		.addNumberColumn({ name:"dimWidth", dataIndex:"dimWidth", hidden:true,format:Ext.NUMBER_FORMAT_DEC })  
		.addNumberColumn({ name:"dimHeight", dataIndex:"dimHeight", hidden:true,format:Ext.NUMBER_FORMAT_DEC })  
		.addNumberColumn({ name:"dimDepth", dataIndex:"dimDepth", hidden:true,format:Ext.NUMBER_FORMAT_DEC })  
		.addNumberColumn({ name:"dimUomId", dataIndex:"dimUomId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"dimUomCode", dataIndex:"dimUomCode", hidden:true,width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.mm.md.dc.Product$CtxFormName", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.mm.md.dc.Product$CtxFormName",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20",noEdit:true  ,allowBlank:false,maxLength:255  })
		//containers
		.addPanel({ name:"main", layout:"anchor" , autoScroll:true, width:90})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["name"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.mm.md.dc.Product$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.mm.md.dc.Product$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo",anchor:"-20" ,maxLength:32  })
		.addLov({ name:"manufacturerCode", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductManufacturers", dataIndex:"manufacturerCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]  })
		.addLov({ name:"attributeGroup", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductAttributeGroup", dataIndex:"attributeGroup",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "attributeGroupId"} ]  })
		.addLov({ name:"defaultUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"defaultUomCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "defaultUomId"} ]  })
		//containers
		.addPanel({ name:"row1", layout:"anchor" , width:700})     
		.addPanel({ name:"col1", layout:"anchor" , width:350})     
		.addPanel({ name:"col2", layout:"anchor" ,width:250})     
		.addPanel({ name:"col3", layout:"anchor" , width:200})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		.addPanel({ name:"row2", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["row1" ,"row2" ])
		.addChildrenTo("row1",["name"])
		.addChildrenTo("row2",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["code","defaultUomCode","attributeGroup"])
		.addChildrenTo("col2",["manufacturerCode","manufacturerProductNo"])
		.addChildrenTo("col3",["active"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.mm.md.dc.Product$EditInfo", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.mm.md.dc.Product$EditInfo",
	
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
		//containers
		.addPanel({ name:"col1", layout:"anchor" ,title:"Physical", width:300,xtype:"fieldset", border:false, collapsible:true})     
		.addPanel({ name:"col2", layout:"anchor" ,title:"Dimensions", width:300,xtype:"fieldset", border:false, collapsible:true})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["storable","weight","weightUomCode","volume","volumeUomCode"])
		.addChildrenTo("col2",["dimWidth","dimHeight","dimDepth","dimUomCode"])
;
	}	
});
