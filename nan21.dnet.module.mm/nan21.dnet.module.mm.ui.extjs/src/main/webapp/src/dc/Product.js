   
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
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("code", { name:"code", xtype:"textfield", _rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("categoryName", { name:"categoryName", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductCategories", dataIndex:"categoryName", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]  });
		this._elems_.add("storable", { name:"storable", xtype:"combo", mode: 'local', dataIndex:"storable", id:Ext.id(), selectOnFocus:true, valueField: 'bv', displayField: 'tv',  store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true, width:70  });
		this._elems_.add("manufacturerCode", { name:"manufacturerCode", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductManufacturers", dataIndex:"manufacturerCode", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]  });
		this._elems_.add("manufacturerProductNo", { name:"manufacturerProductNo", xtype:"textfield", dataIndex:"manufacturerProductNo", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(),width:210, height:50,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("code") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("categoryName") ,this._elems_.get("storable") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("manufacturerCode") ,this._elems_.get("manufacturerProductNo") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.mm.md.dc.Product$Filter", net.nan21.dnet.module.mm.md.dc.Product$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.mm.md.dc');	 	 
net.nan21.dnet.module.mm.md.dc.Product$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("code", { xtype:"gridcolumn",_rbkey_:"code", dataIndex:"code", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("storable", { xtype:"booleancolumn", dataIndex:"storable", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("defaultUomId", { xtype:"numbercolumn", dataIndex:"defaultUomId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("defaultUomCode", { xtype:"gridcolumn", dataIndex:"defaultUomCode", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("categoryId", { xtype:"numbercolumn", dataIndex:"categoryId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("categoryName", { xtype:"gridcolumn", dataIndex:"categoryName", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("manufacturerId", { xtype:"numbercolumn", dataIndex:"manufacturerId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("manufacturerCode", { xtype:"gridcolumn", dataIndex:"manufacturerCode", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("manufacturerProductNo", { xtype:"gridcolumn", dataIndex:"manufacturerProductNo", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("weight", { xtype:"numbercolumn", dataIndex:"weight", sortable:true, hidden:false, align:"right",format:Ext.NUMBER_FORMAT_DEC });  
		this._columns_.add("weightUomId", { xtype:"numbercolumn", dataIndex:"weightUomId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("weightUomCode", { xtype:"gridcolumn", dataIndex:"weightUomCode", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("volume", { xtype:"numbercolumn", dataIndex:"volume", sortable:true, hidden:true, align:"right",format:Ext.NUMBER_FORMAT_DEC });  
		this._columns_.add("volumeUomId", { xtype:"numbercolumn", dataIndex:"volumeUomId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("volumeUomCode", { xtype:"gridcolumn", dataIndex:"volumeUomCode", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("dimWidth", { xtype:"numbercolumn", dataIndex:"dimWidth", sortable:true, hidden:true, align:"right",format:Ext.NUMBER_FORMAT_DEC });  
		this._columns_.add("dimHeight", { xtype:"numbercolumn", dataIndex:"dimHeight", sortable:true, hidden:true, align:"right",format:Ext.NUMBER_FORMAT_DEC });  
		this._columns_.add("dimDepth", { xtype:"numbercolumn", dataIndex:"dimDepth", sortable:true, hidden:true, align:"right",format:Ext.NUMBER_FORMAT_DEC });  
		this._columns_.add("dimUomId", { xtype:"numbercolumn", dataIndex:"dimUomId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("dimUomCode", { xtype:"gridcolumn", dataIndex:"dimUomCode", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:true,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.mm.md.dc.Product$List", net.nan21.dnet.module.mm.md.dc.Product$List ); 
 	
Ext.ns('net.nan21.dnet.module.mm.md.dc');	 
net.nan21.dnet.module.mm.md.dc.Product$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield",_rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("code", { name:"code", xtype:"textfield",_rbkey_:"code", dataIndex:"code", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("active", { name:"active", xtype:"checkbox", _rbkey_:"active", dataIndex:"active", id:Ext.id()  });
		this._elems_.add("manufacturerProductNo", { name:"manufacturerProductNo", xtype:"textfield", dataIndex:"manufacturerProductNo", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("manufacturerId", { name:"manufacturerId", xtype:"numberfield", dataIndex:"manufacturerId", id:Ext.id(),anchor:"-20",disabled:true   , style: "text-align:right;" });
		this._elems_.add("manufacturerCode", { name:"manufacturerCode", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductManufacturers", dataIndex:"manufacturerCode", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]  });
		this._elems_.add("categoryId", { name:"categoryId", xtype:"numberfield", dataIndex:"categoryId", id:Ext.id(),anchor:"-20",disabled:true   , style: "text-align:right;" });
		this._elems_.add("categoryName", { name:"categoryName", xtype:"net.nan21.dnet.module.mm.md.lovs.ProductCategories", dataIndex:"categoryName", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]  });
		this._elems_.add("defaultUomId", { name:"defaultUomId", xtype:"numberfield", dataIndex:"defaultUomId", id:Ext.id(),anchor:"-20",disabled:true   , style: "text-align:right;" });
		this._elems_.add("defaultUomCode", { name:"defaultUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"defaultUomCode", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "defaultUomId"} ]  });
		this._elems_.add("storable", { name:"storable", xtype:"checkbox", dataIndex:"storable", id:Ext.id()  });
		this._elems_.add("weight", { name:"weight", xtype:"numberfield", dataIndex:"weight", id:Ext.id(),anchor:"-20"  , style: "text-align:right;" });
		this._elems_.add("weightUomId", { name:"weightUomId", xtype:"numberfield", dataIndex:"weightUomId", id:Ext.id(),anchor:"-20",disabled:true   , style: "text-align:right;" });
		this._elems_.add("weightUomCode", { name:"weightUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"weightUomCode", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "weightUomId"} ]  });
		this._elems_.add("volume", { name:"volume", xtype:"numberfield", dataIndex:"volume", id:Ext.id(),anchor:"-20"  , style: "text-align:right;" });
		this._elems_.add("volumeUomId", { name:"volumeUomId", xtype:"numberfield", dataIndex:"volumeUomId", id:Ext.id(),anchor:"-20",disabled:true   , style: "text-align:right;" });
		this._elems_.add("volumeUomCode", { name:"volumeUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"volumeUomCode", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "volumeUomId"} ]  });
		this._elems_.add("dimWidth", { name:"dimWidth", xtype:"numberfield", dataIndex:"dimWidth", id:Ext.id(),anchor:"-20"  , style: "text-align:right;" });
		this._elems_.add("dimHeight", { name:"dimHeight", xtype:"numberfield", dataIndex:"dimHeight", id:Ext.id(),anchor:"-20"  , style: "text-align:right;" });
		this._elems_.add("dimDepth", { name:"dimDepth", xtype:"numberfield", dataIndex:"dimDepth", id:Ext.id(),anchor:"-20"  , style: "text-align:right;" });
		this._elems_.add("dimUomId", { name:"dimUomId", xtype:"numberfield", dataIndex:"dimUomId", id:Ext.id(),anchor:"-20",disabled:true   , style: "text-align:right;" });
		this._elems_.add("dimUomCode", { name:"dimUomCode", xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", dataIndex:"dimUomCode", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "dimUomId"} ]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:350,labelWidth:0 });     
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id() ,width:250,labelWidth:0 });     
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id() , width:200,labelWidth:0 });     
		this._elems_.add("col4", { name:"col4", layout:"form", id:Ext.id() , width:200,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ,this._elems_.get("col4") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ,this._elems_.get("code") ,this._elems_.get("defaultUomCode") ,this._elems_.get("categoryName") ,this._elems_.get("active") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("manufacturerCode") ,this._elems_.get("manufacturerProductNo") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("storable") ,this._elems_.get("weight") ,this._elems_.get("weightUomCode") ,this._elems_.get("volume") ,this._elems_.get("volumeUomCode") ];
		this._elems_.get("col4")["items"] = [this._elems_.get("dimWidth") ,this._elems_.get("dimHeight") ,this._elems_.get("dimDepth") ,this._elems_.get("dimUomCode") ];
	}	
});
Ext.reg("net.nan21.dnet.module.mm.md.dc.Product$Edit", net.nan21.dnet.module.mm.md.dc.Product$Edit ); 
