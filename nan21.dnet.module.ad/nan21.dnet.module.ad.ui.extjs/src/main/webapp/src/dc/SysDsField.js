   
Ext.ns('net.nan21.dnet.module.ad.system.dc');	 
net.nan21.dnet.module.ad.system.dc.SysDsField = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"SysDsField" 		 
			,ds: new net.nan21.dnet.module.ad.system.ds.SysDsFieldDs()			  
		});
	 	net.nan21.dnet.module.ad.system.dc.SysDsField.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.system.dc');	 	 
net.nan21.dnet.module.ad.system.dc.SysDsField$CtxList = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false, width:200 });   	
		this._columns_.add("dataType", { xtype:"gridcolumn", dataIndex:"dataType", sortable:true, hidden:false,width:150 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.system.dc.SysDsField$CtxList", net.nan21.dnet.module.ad.system.dc.SysDsField$CtxList ); 
