   
Ext.ns('net.nan21.dnet.module.ad.system.dc');	 
net.nan21.dnet.module.ad.system.dc.SysDataSource = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"SysDataSource" 		 
			,ds: new net.nan21.dnet.module.ad.system.ds.SysDataSourceDs()			  
		});
	 	net.nan21.dnet.module.ad.system.dc.SysDataSource.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.system.dc'); 
net.nan21.dnet.module.ad.system.dc.SysDataSource$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._elems_.add("name", { name:"name", xtype:"textfield", _rbkey_:"name", dataIndex:"name", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("controller", { name:"controller", xtype:"textfield", dataIndex:"controller", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		this._elems_.add("model", { name:"model", xtype:"textfield", dataIndex:"model", id:Ext.id(),anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}  });
		//containers
		this._elems_.add("col1", { name:"col1", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("col2", { name:"col2", layout:"form", id:Ext.id(),width:210,labelWidth:0 });
		this._elems_.add("main", { name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, id:Ext.id() , autoScroll:true });     
	}
	,_linkElements_: function () {
		this._elems_.get("main")["items"] = [this._elems_.get("col1") ,this._elems_.get("col2") ];
		this._elems_.get("col1")["items"] = [this._elems_.get("name") ];
		this._elems_.get("col2")["items"] = [this._elems_.get("model") ,this._elems_.get("controller") ];
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.system.dc.SysDataSource$Filter", net.nan21.dnet.module.ad.system.dc.SysDataSource$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.system.dc');	 	 
net.nan21.dnet.module.ad.system.dc.SysDataSource$List = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: true
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false, width:200 });   	
		this._columns_.add("controller", { xtype:"gridcolumn", dataIndex:"controller", sortable:true, hidden:true, width:250 });   	
		this._columns_.add("model", { xtype:"gridcolumn", dataIndex:"model", sortable:true, hidden:false, width:350 });   	
		this._columns_.add("description", { xtype:"gridcolumn",_rbkey_:"description", dataIndex:"description", sortable:true, hidden:true,width:200 });   	
		this._columns_.add("id", { xtype:"numbercolumn",_rbkey_:"id", dataIndex:"id", sortable:true, hidden:true, align:"right",format:"0",width:70 });  
		this._columns_.add("createdAt", { xtype:"datecolumn",_rbkey_:"createdAt", dataIndex:"createdAt", sortable:true, hidden:true,format:Ext.DATETIME_FORMAT});   	      	     
		this._columns_.add("createdBy", { xtype:"gridcolumn",_rbkey_:"createdBy", dataIndex:"createdBy", sortable:true, hidden:true,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.system.dc.SysDataSource$List", net.nan21.dnet.module.ad.system.dc.SysDataSource$List ); 
