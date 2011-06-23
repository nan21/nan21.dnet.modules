   
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 
net.nan21.dnet.module.bd.geo.dc.Country = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Country" 		 
			,ds: new net.nan21.dnet.module.bd.geo.ds.CountryDs()			  
		});
	 	net.nan21.dnet.module.bd.geo.dc.Country.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc'); 
net.nan21.dnet.module.bd.geo.dc.Country$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"iso2", dataIndex:"iso2",anchor:"-20",maxLength:2,caseRestriction:"uppercase"  })
		.addTextField({ name:"iso3", dataIndex:"iso3",anchor:"-20",maxLength:3,caseRestriction:"uppercase"  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col4", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		; 
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col4"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["iso2","iso3"])
		.addChildrenTo("col4",["active"])
;
	}
}); 
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Country$Filter", net.nan21.dnet.module.bd.geo.dc.Country$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 	 
net.nan21.dnet.module.bd.geo.dc.Country$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"iso2", dataIndex:"iso2",width:50 })   	
		.addTextColumn({ name:"iso3", dataIndex:"iso3",width:50 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200 })   	
		.addBooleanColumn({ name:"hasRegions", dataIndex:"hasRegions"})   	     
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Country$List", net.nan21.dnet.module.bd.geo.dc.Country$List ); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 	 
net.nan21.dnet.module.bd.geo.dc.Country$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"iso2", dataIndex:"iso2",width:50,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:2,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "2"},caseRestriction:"uppercase",style: "text-transform:uppercase;",vtype:"alphanum"} })
		.addTextColumn({ name:"iso3", dataIndex:"iso3",width:50,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:3,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "3"},caseRestriction:"uppercase",style: "text-transform:uppercase;",vtype:"alphanum"} })
		.addBooleanColumn({ name:"hasRegions", dataIndex:"hasRegions"})

		.addBooleanColumn({ name:"active", dataIndex:"active"})

		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Country$EditList", net.nan21.dnet.module.bd.geo.dc.Country$EditList ); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 
net.nan21.dnet.module.bd.geo.dc.Country$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code", width:200 ,allowBlank:false,maxLength:32,vtype:"alphanum"  })
		.addTextField({ name:"name", dataIndex:"name", width:200 ,allowBlank:false,maxLength:255  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:40, width:200   })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addCheckbox({ name:"hasRegions", dataIndex:"hasRegions"  })
		.addTextField({ name:"iso2", dataIndex:"iso2",anchor:"-20" ,maxLength:2,caseRestriction:"uppercase",vtype:"alphanum"  })
		.addTextField({ name:"iso3", dataIndex:"iso3",anchor:"-20" ,maxLength:3,caseRestriction:"uppercase",vtype:"alphanum"  })
		.addDateField({ name:"createdAt", dataIndex:"createdAt",width:100,disabled:true  ,allowBlank:false})
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",width:100,disabled:true  ,allowBlank:false})
		.addTextField({ name:"createdBy", dataIndex:"createdBy",anchor:"-20",disabled:true  ,allowBlank:false,maxLength:32  })
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",anchor:"-20",disabled:true  ,allowBlank:false,maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:350,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" , width:220,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","notes"])
		.addChildrenTo("col2",["iso2","iso3","active","hasRegions"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Country$Edit", net.nan21.dnet.module.bd.geo.dc.Country$Edit ); 
