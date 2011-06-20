   
Ext.ns('net.nan21.dnet.module.sd.invoice.dc');	 
net.nan21.dnet.module.sd.invoice.dc.SalesInvoice = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"SalesInvoice" 		 
			,ds: new net.nan21.dnet.module.sd.invoice.ds.SalesInvoiceDs()			  
		});
	 	net.nan21.dnet.module.sd.invoice.dc.SalesInvoice.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.sd.invoice.dc'); 
net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("docNo", { name:"docNo", xtype:"textfield", dataIndex:"docNo", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		this._elems_.add("docDate", { name:"docDate", xtype:"datefield", dataIndex:"docDate", id:Ext.id(),width:100 ,format:Ext.DATE_FORMAT });
		this._elems_.add("customerCode", { name:"customerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.Customers", dataIndex:"customerCode", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  });
		this._elems_.add("status", { name:"status", xtype:"net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceStatus", dataIndex:"status", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  });
		this._elems_.add("type", { name:"type", xtype:"net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceType", dataIndex:"type", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  });
		this._elems_.add("currencyCode", { name:"currencyCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currencyCode", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("docNo") ,this._elems_.get("docDate") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("customerCode") ,this._elems_.get("currencyCode") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("type") ,this._elems_.get("status") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter", net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.sd.invoice.dc');	 	 
net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("docNo", { xtype:"gridcolumn", dataIndex:"docNo", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("docDate", { xtype:"datecolumn", dataIndex:"docDate", sortable:true, hidden:false,format:Ext.DATE_FORMAT});   	      	     
		this._columns_.add("type", { xtype:"gridcolumn", dataIndex:"type", sortable:true, hidden:false,width:120 });   	
		this._columns_.add("status", { xtype:"gridcolumn", dataIndex:"status", sortable:true, hidden:false,width:120 });   	
		this._columns_.add("currencyId", { xtype:"numbercolumn", dataIndex:"currencyId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("currencyCode", { xtype:"gridcolumn", dataIndex:"currencyCode", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("totalNetAmount", { xtype:"numbercolumn", dataIndex:"totalNetAmount", sortable:true, hidden:false, align:"right",format:Ext.NUMBER_FORMAT_DEC });  
		this._columns_.add("totalTaxAmount", { xtype:"numbercolumn", dataIndex:"totalTaxAmount", sortable:true, hidden:false, align:"right",format:Ext.NUMBER_FORMAT_DEC });  
		this._columns_.add("totalAmount", { xtype:"numbercolumn", dataIndex:"totalAmount", sortable:true, hidden:false, align:"right",format:Ext.NUMBER_FORMAT_DEC });  
		this._columns_.add("customerId", { xtype:"numbercolumn", dataIndex:"customerId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("customerCode", { xtype:"gridcolumn", dataIndex:"customerCode", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("salesOrderId", { xtype:"numbercolumn", dataIndex:"salesOrderId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List", net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List ); 
 	
Ext.ns('net.nan21.dnet.module.sd.invoice.dc');	 
net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("docNo", { name:"docNo", xtype:"textfield", dataIndex:"docNo", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"  });
		this._elems_.add("docDate", { name:"docDate", xtype:"datefield", dataIndex:"docDate", id:Ext.id(),width:100 ,allowBlank:false, labelSeparator:"*" ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("status", { name:"status", xtype:"net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceStatus", dataIndex:"status", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  });
		this._elems_.add("type", { name:"type", xtype:"net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceType", dataIndex:"type", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  });
		this._elems_.add("currencyCode", { name:"currencyCode", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currencyCode", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  });
		this._elems_.add("billToLocation", { name:"billToLocation", xtype:"net.nan21.dnet.module.bd.geo.lovs.LocationsToBill", dataIndex:"billToLocation", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "billToLocationId"} ],filterFieldMapping: [{lovField:"targetId", dsField: "customerId"} ]  });
		this._elems_.add("billToContact", { name:"billToContact", xtype:"net.nan21.dnet.module.bp.md.lovs.BpContacts", dataIndex:"billToContact", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "billToContactId"} ],filterFieldMapping: [{lovField:"bpartnerId", dsField: "customerId"} ]  });
		this._elems_.add("totalNetAmount", { name:"totalNetAmount", xtype:"numberfield", dataIndex:"totalNetAmount", id:Ext.id(),anchor:"-20",disabled:true   , style: "text-align:right;" });
		this._elems_.add("totalTaxAmount", { name:"totalTaxAmount", xtype:"numberfield", dataIndex:"totalTaxAmount", id:Ext.id(),anchor:"-20",disabled:true   , style: "text-align:right;" });
		this._elems_.add("totalAmount", { name:"totalAmount", xtype:"numberfield", dataIndex:"totalAmount", id:Ext.id(),anchor:"-20",disabled:true   , style: "text-align:right;" });
		this._elems_.add("customerCode", { name:"customerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.Customers", dataIndex:"customerCode", id:Ext.id(),anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() ,width:250,labelWidth:0 });     
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id() , width:300,labelWidth:0 });     
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id() ,width:250,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("customerCode") ,this._elems_.get("type") ,this._elems_.get("status") ,this._elems_.get("currencyCode") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("docNo") ,this._elems_.get("docDate") ,this._elems_.get("billToLocation") ,this._elems_.get("billToContact") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("totalNetAmount") ,this._elems_.get("totalTaxAmount") ,this._elems_.get("totalAmount") ];
	}	
});
Ext.reg("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Edit", net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Edit ); 
