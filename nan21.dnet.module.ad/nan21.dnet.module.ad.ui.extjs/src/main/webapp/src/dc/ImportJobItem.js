   
Ext.ns('net.nan21.dnet.module.ad.impex.dc');	 
net.nan21.dnet.module.ad.impex.dc.ImportJobItem = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"ImportJobItem" 		 
			,ds: new net.nan21.dnet.module.ad.impex.ds.ImportJobItemDs()			  
		});
	 	net.nan21.dnet.module.ad.impex.dc.ImportJobItem.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.impex.dc');	 	 
net.nan21.dnet.module.ad.impex.dc.ImportJobItem$CtxEditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection() 
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("sequenceNo", { xtype:"numbercolumn", dataIndex:"sequenceNo", sortable:true, hidden:false, align:"right",format:Ext.NUMBER_FORMAT_INT ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("mapName", { xtype:"gridcolumn", dataIndex:"mapName", sortable:true, hidden:false,width:120,editor:{xtype:"net.nan21.dnet.module.ad.impex.lovs.ImportMap" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "mapId"} ]} });
		this._columns_.add("jobName", { xtype:"gridcolumn", dataIndex:"jobName", sortable:true, hidden:true,width:120,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} });
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv', store:new Ext.data.ArrayStore({idIndex:0,fields: [ 'bv', 'tv' ], data: [[true,Dnet.translate("msg", "bool_true")],[false,Dnet.translate("msg", "bool_false")]] }), triggerAction:'all', forceSelection:true }});
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("jobId", { xtype:"numbercolumn", dataIndex:"jobId", sortable:true, hidden:true, align:"right",format:"0",width:70 ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("mapId", { xtype:"numbercolumn", dataIndex:"mapId", sortable:true, hidden:true, align:"right",format:"0",width:70 ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
	}  
});
Ext.reg("net.nan21.dnet.module.ad.impex.dc.ImportJobItem$CtxEditList", net.nan21.dnet.module.ad.impex.dc.ImportJobItem$CtxEditList ); 
