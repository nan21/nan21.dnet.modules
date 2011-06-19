   
Ext.ns('net.nan21.dnet.module.ad.system.dc');	 
net.nan21.dnet.module.ad.system.dc.SysDsEvent = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"SysDsEvent" 		 
			,ds: new net.nan21.dnet.module.ad.system.ds.SysDsEventDs()			  
		});
	 	net.nan21.dnet.module.ad.system.dc.SysDsEvent.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.system.dc');	 	 
net.nan21.dnet.module.ad.system.dc.SysDsEvent$CtxList = Ext.extend(dnet.base.AbstractDcvGrid, {
 	 _columns_: new Ext.util.MixedCollection()
 	,_elems_ : new Ext.util.MixedCollection()  
	,_controller_: null 
	,_noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {		
		this._columns_.add("name", { xtype:"gridcolumn",_rbkey_:"name", dataIndex:"name", sortable:true, hidden:false,width:100 });   	
	  		   
	}
});
 
Ext.reg("net.nan21.dnet.module.ad.system.dc.SysDsEvent$CtxList", net.nan21.dnet.module.ad.system.dc.SysDsEvent$CtxList ); 
