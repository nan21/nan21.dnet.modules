   
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 
net.nan21.dnet.module.bp.md.dc.BpAccount = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"BpAccount" 		 
			,ds: new net.nan21.dnet.module.bp.md.ds.BpAccountDs()			  
		});
	 	net.nan21.dnet.module.bp.md.dc.BpAccount.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc'); 
net.nan21.dnet.module.bp.md.dc.BpAccount$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("businessPartner", { name:"businessPartner", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartners", dataIndex:"businessPartner", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "businessPartnerId"} ]  });
		this._elems_.add("organization", { name:"organization", xtype:"net.nan21.dnet.module.ad.org.lovs.Organizations", dataIndex:"organization", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]  });
		this._elems_.add("customerGroup", { name:"customerGroup", xtype:"net.nan21.dnet.module.bp.base.lovs.CustomerGroup", dataIndex:"customerGroup", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "customerGroupId"} ]  });
		this._elems_.add("vendorGroup", { name:"vendorGroup", xtype:"net.nan21.dnet.module.bp.base.lovs.VendorGroup", dataIndex:"vendorGroup", id:Ext.id(),anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "vendorGroupId"} ]  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(), width:220,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(), width:220,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("organization") ,this._elems_.get("businessPartner") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("customerGroup") ,this._elems_.get("vendorGroup") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.bp.md.dc.BpAccount$Filter", net.nan21.dnet.module.bp.md.dc.BpAccount$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 	 
net.nan21.dnet.module.bp.md.dc.BpAccount$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("organizationId", { xtype:"numbercolumn", dataIndex:"organizationId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("organization", { xtype:"gridcolumn", dataIndex:"organization", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("businessPartnerId", { xtype:"numbercolumn", dataIndex:"businessPartnerId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("businessPartner", { xtype:"gridcolumn", dataIndex:"businessPartner", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("customerGroupId", { xtype:"numbercolumn", dataIndex:"customerGroupId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("customerGroup", { xtype:"gridcolumn", dataIndex:"customerGroup", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("customerPaymentMethodId", { xtype:"numbercolumn", dataIndex:"customerPaymentMethodId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("customerPaymentMethod", { xtype:"gridcolumn", dataIndex:"customerPaymentMethod", sortable:true, hidden:false,width:120 });   	
		this._columns_.add("customerCreditLimit", { xtype:"numbercolumn", dataIndex:"customerCreditLimit", sortable:true, hidden:true, align:"right",format:Ext.NUMBER_FORMAT_DEC });  
		this._columns_.add("customerPaymentTerm", { xtype:"gridcolumn", dataIndex:"customerPaymentTerm", sortable:true, hidden:false,width:120 });   	
		this._columns_.add("vendorGroupId", { xtype:"numbercolumn", dataIndex:"vendorGroupId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("vendorGroup", { xtype:"gridcolumn", dataIndex:"vendorGroup", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("vendorPaymentMethodId", { xtype:"numbercolumn", dataIndex:"vendorPaymentMethodId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("vendorPaymentMethod", { xtype:"gridcolumn", dataIndex:"vendorPaymentMethod", sortable:true, hidden:false,width:120 });   	
		this._columns_.add("vendorCreditLimit", { xtype:"numbercolumn", dataIndex:"vendorCreditLimit", sortable:true, hidden:false, align:"right",format:Ext.NUMBER_FORMAT_DEC });  
		this._columns_.add("vendorPaymentTerm", { xtype:"gridcolumn", dataIndex:"vendorPaymentTerm", sortable:true, hidden:false,width:120 });   	
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bp.md.dc.BpAccount$List", net.nan21.dnet.module.bp.md.dc.BpAccount$List ); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 
net.nan21.dnet.module.bp.md.dc.BpAccount$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("businessPartner", { name:"businessPartner", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartners", dataIndex:"businessPartner", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "businessPartnerId"} ]  });
		this._elems_.add("organization", { name:"organization", xtype:"net.nan21.dnet.module.ad.org.lovs.Organizations", dataIndex:"organization", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]  });
		this._elems_.add("customerGroup", { name:"customerGroup", xtype:"net.nan21.dnet.module.bp.base.lovs.CustomerGroup", dataIndex:"customerGroup", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "customerGroupId"} ]  });
		this._elems_.add("customerPaymentMethod", { name:"customerPaymentMethod", xtype:"net.nan21.dnet.module.bp.base.lovs.PaymentMethod", dataIndex:"customerPaymentMethod", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "customerPaymentMethodId"} ]  });
		this._elems_.add("customerCreditLimit", { name:"customerCreditLimit", xtype:"numberfield", dataIndex:"customerCreditLimit", id:Ext.id(),anchor:"-20"  , style: "text-align:right;" });
		this._elems_.add("customerPaymentTerm", { name:"customerPaymentTerm", xtype:"net.nan21.dnet.module.bp.base.lovs.PaymentTerm", dataIndex:"customerPaymentTerm", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "customerPaymentTerm"} ]  });
		this._elems_.add("vendorGroup", { name:"vendorGroup", xtype:"net.nan21.dnet.module.bp.base.lovs.VendorGroup", dataIndex:"vendorGroup", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "vendorGroupId"} ]  });
		this._elems_.add("vendorPaymentMethod", { name:"vendorPaymentMethod", xtype:"net.nan21.dnet.module.bp.base.lovs.PaymentMethod", dataIndex:"vendorPaymentMethod", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "vendorPaymentMethodId"} ]  });
		this._elems_.add("vendorCreditLimit", { name:"vendorCreditLimit", xtype:"numberfield", dataIndex:"vendorCreditLimit", id:Ext.id(),anchor:"-20"  , style: "text-align:right;" });
		this._elems_.add("vendorPaymentTerm", { name:"vendorPaymentTerm", xtype:"net.nan21.dnet.module.bp.base.lovs.PaymentTerm", dataIndex:"vendorPaymentTerm", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "vendorPaymentTerm"} ]  });
		this._elems_.add("modifiedAt", { name:"modifiedAt", xtype:"datefield", _rbkey_:"modifiedAt", dataIndex:"modifiedAt", id:Ext.id(),width:100,disabled:true  ,allowBlank:false, labelSeparator:"*" ,format:Ext.DATE_FORMAT, selectOnFocus:true });
		this._elems_.add("modifiedBy", { name:"modifiedBy", xtype:"textfield",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", id:Ext.id(),anchor:"-20",disabled:true  ,allowBlank:false, labelSeparator:"*",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:300,labelWidth:0 });     
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id() , width:300,labelWidth:0 });     
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id() , width:300,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("organization") ,this._elems_.get("businessPartner") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("customerGroup") ,this._elems_.get("customerPaymentMethod") ,this._elems_.get("customerCreditLimit") ,this._elems_.get("customerPaymentTerm") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("vendorGroup") ,this._elems_.get("vendorPaymentMethod") ,this._elems_.get("vendorCreditLimit") ,this._elems_.get("vendorPaymentTerm") ];
	}	
});
Ext.reg("net.nan21.dnet.module.bp.md.dc.BpAccount$Edit", net.nan21.dnet.module.bp.md.dc.BpAccount$Edit ); 
