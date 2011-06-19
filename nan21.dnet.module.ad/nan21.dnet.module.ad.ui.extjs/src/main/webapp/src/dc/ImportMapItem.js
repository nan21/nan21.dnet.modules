   
Ext.ns('net.nan21.dnet.module.ad.impex.dc');	 
net.nan21.dnet.module.ad.impex.dc.ImportMapItem = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"ImportMapItem" 		 
			,ds: new net.nan21.dnet.module.ad.impex.ds.ImportMapItemDs()			  
		});
	 	net.nan21.dnet.module.ad.impex.dc.ImportMapItem.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.impex.dc'); 
net.nan21.dnet.module.ad.impex.dc.ImportMapItem$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("importMapName", { name:"importMapName", xtype:"net.nan21.dnet.module.ad.impex.lovs.ImportMap", dataIndex:"importMapName", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "importMapId"} ]  });
		this._elems_.add("dataSource", { name:"dataSource", xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSource", dataIndex:"dataSource", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: []  });
		this._elems_.add("fileName", { name:"fileName", xtype:"textfield", dataIndex:"fileName", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("active", { name:"active", xtype:"combo", mode: 'local',_rbkey_:"active", dataIndex:"active", id:Ext.id(), selectOnFocus:true, valueField: 'bv', displayField: 'tv',  store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true, width:70  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("importMapName") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("dataSource") ,this._elems_.get("fileName") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("active") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.impex.dc.ImportMapItem$Filter", net.nan21.dnet.module.ad.impex.dc.ImportMapItem$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.impex.dc');	 	 
net.nan21.dnet.module.ad.impex.dc.ImportMapItem$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection() 
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("importMapId", { xtype:"numbercolumn", dataIndex:"importMapId", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("importMapName", { xtype:"gridcolumn", dataIndex:"importMapName", sortable:true, hidden:false,width:120,editor:{xtype:"net.nan21.dnet.module.ad.impex.lovs.ImportMap" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "importMapId"} ]} });
		this._columns_.add("sequenceNo", { xtype:"numbercolumn", dataIndex:"sequenceNo", sortable:true, hidden:false, align:"right",format:Ext.NUMBER_FORMAT_INT ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("dataSource", { xtype:"gridcolumn", dataIndex:"dataSource", sortable:true, hidden:false,width:150,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSource" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: []} });
		this._columns_.add("fileName", { xtype:"gridcolumn", dataIndex:"fileName", sortable:true, hidden:false,width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} });
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv', store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true }});
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
	}  
});
Ext.reg("net.nan21.dnet.module.ad.impex.dc.ImportMapItem$EditList", net.nan21.dnet.module.ad.impex.dc.ImportMapItem$EditList ); 
