   
Ext.ns('net.nan21.dnet.module.bd.contact.dc');	 
net.nan21.dnet.module.bd.contact.dc.CommunicationChannel = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"CommunicationChannel" 		 
			,ds: new net.nan21.dnet.module.bd.contact.ds.CommunicationChannelDs()			  
		});
	 	net.nan21.dnet.module.bd.contact.dc.CommunicationChannel.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bd.contact.dc');	 	 
net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection() 
	,_controller_: null 
	,_noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {		
		this._columns_.add("type", { xtype:"gridcolumn", dataIndex:"type", sortable:true, hidden:false,width:120,editor:{xtype:"net.nan21.dnet.module.bd.contact.lovs.CommunicationChannelTypes" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]} });
		this._columns_.add("value", { xtype:"gridcolumn", dataIndex:"value", sortable:true, hidden:false,width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} });
		this._columns_.add("validFrom", { xtype:"datecolumn", dataIndex:"validFrom", sortable:true, hidden:false,format:Ext.DATE_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("validTo", { xtype:"datecolumn", dataIndex:"validTo", sortable:true, hidden:false,format:Ext.DATE_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("typeId", { xtype:"numbercolumn", dataIndex:"typeId", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } });
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} });
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} });
	}  
});
Ext.reg("net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList", net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList ); 
