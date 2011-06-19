   
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 
net.nan21.dnet.module.bd.geo.dc.Location = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Location" 		 
			,ds: new net.nan21.dnet.module.bd.geo.ds.LocationDs()			  
		});
	 	net.nan21.dnet.module.bd.geo.dc.Location.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 	 
net.nan21.dnet.module.bd.geo.dc.Location$ListCtx = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {		
		this._columns_.add("countryId", { xtype:"numbercolumn", dataIndex:"countryId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("countryCode", { xtype:"gridcolumn", dataIndex:"countryCode", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("regionId", { xtype:"numbercolumn", dataIndex:"regionId", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("regionCode", { xtype:"gridcolumn", dataIndex:"regionCode", sortable:true, hidden:false,width:100 });   	
		this._columns_.add("cityName", { xtype:"gridcolumn", dataIndex:"cityName", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("adress", { xtype:"gridcolumn", dataIndex:"adress", sortable:true, hidden:false,width:200 });   	
		this._columns_.add("notes", { xtype:"gridcolumn",_rbkey_:"notes", dataIndex:"notes", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("active", { xtype:"booleancolumn",_rbkey_:"active", dataIndex:"active", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("billing", { xtype:"booleancolumn", dataIndex:"billing", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("mailing", { xtype:"booleancolumn", dataIndex:"mailing", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("shipping", { xtype:"booleancolumn", dataIndex:"shipping", sortable:true, hidden:false, trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false")});   	     
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("modifiedAt", { xtype:"datecolumn",_rbkey_:"modifiedAt", dataIndex:"modifiedAt", sortable:true, hidden:false,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
		this._columns_.add("modifiedBy", { xtype:"gridcolumn",_rbkey_:"modifiedBy", dataIndex:"modifiedBy", sortable:true, hidden:false,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Location$ListCtx", net.nan21.dnet.module.bd.geo.dc.Location$ListCtx ); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 
net.nan21.dnet.module.bd.geo.dc.Location$EditCtx = Ext.extend(dnet.base.AbstractDcvForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("countryCode", { name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  });
		this._elems_.add("regionCode", { name:"regionCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Regions", dataIndex:"regionCode", id:Ext.id(),anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "regionId"} ]  });
		this._elems_.add("cityName", { name:"cityName", xtype:"textfield", dataIndex:"cityName", id:Ext.id(),anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("adress", { name:"adress", xtype:"textarea", dataIndex:"adress", id:Ext.id(),height:60,anchor:"-20"   });
		this._elems_.add("notes", { name:"notes", xtype:"textarea", _rbkey_:"notes", dataIndex:"notes", id:Ext.id(),height:60,anchor:"-20"   });
		this._elems_.add("billing", { name:"billing", xtype:"checkbox", dataIndex:"billing", id:Ext.id()  });
		this._elems_.add("mailing", { name:"mailing", xtype:"checkbox", dataIndex:"mailing", id:Ext.id()  });
		this._elems_.add("shipping", { name:"shipping", xtype:"checkbox", dataIndex:"shipping", id:Ext.id()  });
		this._elems_.add("active", { name:"active", xtype:"checkbox", _rbkey_:"active", dataIndex:"active", id:Ext.id()  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id() , width:250,labelWidth:0 });     
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id() , width:350,labelWidth:0 });     
		this._elems_.add("col3", { name:"col3", layout:"form", id:Ext.id() , width:200,labelWidth:0 });     
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true }); 
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ,this._elems_.get("col3") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("countryCode") ,this._elems_.get("regionCode") ,this._elems_.get("cityName") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("adress") ,this._elems_.get("notes") ];
		this._elems_.get("col3")["items"] = [this._elems_.get("billing") ,this._elems_.get("mailing") ,this._elems_.get("shipping") ,this._elems_.get("active") ];
	}	
});
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Location$EditCtx", net.nan21.dnet.module.bd.geo.dc.Location$EditCtx ); 
