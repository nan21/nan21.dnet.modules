   
Ext.ns('net.nan21.dnet.module.mm.md.dc');	 
net.nan21.dnet.module.mm.md.dc.Product = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Product" 		 
			,ds: new net.nan21.dnet.module.mm.md.ds.ProductDs()			  
		});
	 	net.nan21.dnet.module.mm.md.dc.Product.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.mm.md.dc'); 
net.nan21.dnet.module.mm.md.dc.Product$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addLov({ name:"categoryName", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductCategories", dataIndex:"categoryName",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]  })
		.addBooleanField({ name:"storable", dataIndex:"storable"  })
		.addLov({ name:"manufacturerCode", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductManufacturers", dataIndex:"manufacturerCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]  })
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo",anchor:"-20",maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210, height:50,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col3", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["categoryName","storable"])
		.addChildrenTo("col3",["manufacturerCode","manufacturerProductNo"])
	}
}); 
Ext.reg("net.nan21.dnet.module.mm.md.dc.Product$Filter", net.nan21.dnet.module.mm.md.dc.Product$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.mm.md.dc');	 	 
net.nan21.dnet.module.mm.md.dc.Product$List = Ext.extend(dnet.base.AbstractDcvGrid, {
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
		.addNumberColumn({ name:"categoryId", dataIndex:"categoryId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"categoryName", dataIndex:"categoryName",width:200 })   	
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
 
Ext.reg("net.nan21.dnet.module.mm.md.dc.Product$List", net.nan21.dnet.module.mm.md.dc.Product$List ); 
 	
Ext.ns('net.nan21.dnet.module.mm.md.dc');	 
net.nan21.dnet.module.mm.md.dc.Product$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32,vtype:"alphanum"  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		.addNumberField({ name:"manufacturerId", dataIndex:"manufacturerId",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addLov({ name:"manufacturerCode", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductManufacturers", dataIndex:"manufacturerCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]  })
		.addNumberField({ name:"categoryId", dataIndex:"categoryId",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addLov({ name:"categoryName", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductCategories", dataIndex:"categoryName",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]  })
		.addNumberField({ name:"defaultUomId", dataIndex:"defaultUomId",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addLov({ name:"defaultUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"defaultUomCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "defaultUomId"} ]  })
		.addCheckbox({ name:"storable", dataIndex:"storable"  })
		.addNumberField({ name:"weight", dataIndex:"weight",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"weightUomId", dataIndex:"weightUomId",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addLov({ name:"weightUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UomMass", dataIndex:"weightUomCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "weightUomId"} ]  })
		.addNumberField({ name:"volume", dataIndex:"volume",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"volumeUomId", dataIndex:"volumeUomId",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addLov({ name:"volumeUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UomVolume", dataIndex:"volumeUomCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "volumeUomId"} ]  })
		.addNumberField({ name:"dimWidth", dataIndex:"dimWidth",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"dimHeight", dataIndex:"dimHeight",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"dimDepth", dataIndex:"dimDepth",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"dimUomId", dataIndex:"dimUomId",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addLov({ name:"dimUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UomLength", dataIndex:"dimUomCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "dimUomId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:350,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" ,width:250,labelWidth:0 })     
		.addPanel({ name:"col3", layout:"form" , width:200,labelWidth:0 })     
		.addPanel({ name:"col4", layout:"form" , width:200,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ,"col4" ])
		.addChildrenTo("col1",["name","code","defaultUomCode","categoryName","active"])
		.addChildrenTo("col2",["manufacturerCode","manufacturerProductNo"])
		.addChildrenTo("col3",["storable","weight","weightUomCode","volume","volumeUomCode"])
		.addChildrenTo("col4",["dimWidth","dimHeight","dimDepth","dimUomCode"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.mm.md.dc.Product$Edit", net.nan21.dnet.module.mm.md.dc.Product$Edit ); 
