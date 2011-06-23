   
Ext.ns('net.nan21.dnet.module.bd.uom.dc');	 
net.nan21.dnet.module.bd.uom.dc.Uom = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Uom" 		 
			,ds: new net.nan21.dnet.module.bd.uom.ds.UomDs()			  
		});
	 	net.nan21.dnet.module.bd.uom.dc.Uom.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bd.uom.dc'); 
net.nan21.dnet.module.bd.uom.dc.Uom$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		; 
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["active"])
;
	}
}); 
Ext.reg("net.nan21.dnet.module.bd.uom.dc.Uom$Filter", net.nan21.dnet.module.bd.uom.dc.Uom$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bd.uom.dc');	 	 
net.nan21.dnet.module.bd.uom.dc.Uom$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bd.uom.dc.Uom$List", net.nan21.dnet.module.bd.uom.dc.Uom$List ); 
 	
Ext.ns('net.nan21.dnet.module.bd.uom.dc');	 	 
net.nan21.dnet.module.bd.uom.dc.Uom$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"} })
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
Ext.reg("net.nan21.dnet.module.bd.uom.dc.Uom$EditList", net.nan21.dnet.module.bd.uom.dc.Uom$EditList ); 
 	
Ext.ns('net.nan21.dnet.module.bd.uom.dc');	 
net.nan21.dnet.module.bd.uom.dc.Uom$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32,vtype:"alphanum"  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addNumberField({ name:"id", dataIndex:"id",anchor:"-20",disabled:true  ,allowBlank:false , style: "text-align:right;" })
		.addNumberField({ name:"clientId", dataIndex:"clientId",anchor:"-20" ,allowBlank:false , style: "text-align:right;" })
		.addDateField({ name:"createdAt", dataIndex:"createdAt",width:100,disabled:true  ,allowBlank:false})
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",width:100,disabled:true  ,allowBlank:false})
		.addTextField({ name:"createdBy", dataIndex:"createdBy",anchor:"-20",disabled:true  ,allowBlank:false,maxLength:32  })
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",anchor:"-20",disabled:true  ,allowBlank:false,maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:350,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" , width:250,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","notes"])
		.addChildrenTo("col2",["active","modifiedAt","modifiedBy"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.bd.uom.dc.Uom$Edit", net.nan21.dnet.module.bd.uom.dc.Uom$Edit ); 
