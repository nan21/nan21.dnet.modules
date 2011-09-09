   
Ext.ns('net.nan21.dnet.module.ad.usr.dc');	 
net.nan21.dnet.module.ad.usr.dc.DsAccessControl = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"DsAccessControl" 		 
			,ds: new net.nan21.dnet.module.ad.usr.ds.DsAccessControlDs()			  
		});
	 	net.nan21.dnet.module.ad.usr.dc.DsAccessControl.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.ad.usr.dc'); 
net.nan21.dnet.module.ad.usr.dc.DsAccessControl$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"dsName", dataIndex:"dsName",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"queryAllowed", dataIndex:"queryAllowed"  })
		.addBooleanField({ name:"insertAllowed", dataIndex:"insertAllowed"  })
		.addBooleanField({ name:"updateAllowed", dataIndex:"updateAllowed"  })
		.addBooleanField({ name:"deleteAllowed", dataIndex:"deleteAllowed"  })
		.addBooleanField({ name:"importAllowed", dataIndex:"importAllowed"  })
		.addBooleanField({ name:"exportAllowed", dataIndex:"exportAllowed"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col3", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col4", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["dsName"])
		.addChildrenTo("col2",["queryAllowed","deleteAllowed"])
		.addChildrenTo("col3",["insertAllowed","updateAllowed"])
		.addChildrenTo("col4",["importAllowed","exportAllowed"])
	}
}); 
Ext.reg("net.nan21.dnet.module.ad.usr.dc.DsAccessControl$Filter", net.nan21.dnet.module.ad.usr.dc.DsAccessControl$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.ad.usr.dc');	 	 
net.nan21.dnet.module.ad.usr.dc.DsAccessControl$CtxEditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"dsName", xtype:"gridcolumn", dataIndex:"dsName",width:200,editor:{xtype:"net.nan21.dnet.module.ad.system.lovs.SysDataSource" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: []} })
		.addBooleanColumn({ name:"queryAllowed", dataIndex:"queryAllowed"})

		.addBooleanColumn({ name:"insertAllowed", dataIndex:"insertAllowed"})

		.addBooleanColumn({ name:"updateAllowed", dataIndex:"updateAllowed"})

		.addBooleanColumn({ name:"deleteAllowed", dataIndex:"deleteAllowed"})

		.addBooleanColumn({ name:"importAllowed", dataIndex:"importAllowed"})

		.addBooleanColumn({ name:"exportAllowed", dataIndex:"exportAllowed"})

		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.ad.usr.dc.DsAccessControl$CtxEditList", net.nan21.dnet.module.ad.usr.dc.DsAccessControl$CtxEditList ); 
