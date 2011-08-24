   
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 
net.nan21.dnet.module.bp.md.dc.Contact = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Contact" 		 
			,ds: new net.nan21.dnet.module.bp.md.ds.ContactDs()			  
		});
	 	net.nan21.dnet.module.bp.md.dc.Contact.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc'); 
net.nan21.dnet.module.bp.md.dc.Contact$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20",maxLength:255  })
		.addLov({ name:"bpartnerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartners", dataIndex:"bpartnerCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: []  })
		.addCombo({ name:"gender", xtype:"combo", dataIndex:"gender", id:Ext.id(),anchor:"-20",store:[ "male", "female"]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:220,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form", width:250,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["firstName","lastName"])
		.addChildrenTo("col2",["bpartnerCode","gender"])
	}
}); 
Ext.reg("net.nan21.dnet.module.bp.md.dc.Contact$Filter", net.nan21.dnet.module.bp.md.dc.Contact$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 	 
net.nan21.dnet.module.bp.md.dc.Contact$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"firstName", dataIndex:"firstName", width:120 })   	
		.addTextColumn({ name:"lastName", dataIndex:"lastName", width:120 })   	
		.addNumberColumn({ name:"bpartnerId", dataIndex:"bpartnerId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"bpartnerCode", dataIndex:"bpartnerCode",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"gender", dataIndex:"gender", hidden:true,width:60 })   	
		.addDateColumn({ name:"birthdate", dataIndex:"birthdate", hidden:true,format:Ext.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"position", dataIndex:"position",width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bp.md.dc.Contact$List", net.nan21.dnet.module.bp.md.dc.Contact$List ); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 	 
net.nan21.dnet.module.bp.md.dc.Contact$CtxEditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"firstName", dataIndex:"firstName", width:120,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"lastName", dataIndex:"lastName", width:120,editor:{xtype:"textfield" , selectOnFocus:true,allowBlank:false,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})

		.addTextColumn({ name:"gender", dataIndex:"gender", hidden:true,width:60,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:16,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "16"}} })
		.addDateColumn({ name:"birthdate", dataIndex:"birthdate", hidden:true,format:Ext.DATE_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"position", dataIndex:"position",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.bp.md.dc.Contact$CtxEditList", net.nan21.dnet.module.bp.md.dc.Contact$CtxEditList ); 
 	
Ext.ns('net.nan21.dnet.module.bp.md.dc');	 
net.nan21.dnet.module.bp.md.dc.Contact$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addCombo({ name:"gender", xtype:"combo", dataIndex:"gender",anchor:"-20",store:[ "male", "female"]  })
		.addTextField({ name:"position", dataIndex:"position",anchor:"-20" ,maxLength:255  })
		.addDateField({ name:"birthdate", dataIndex:"birthdate",width:100 })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addLov({ name:"bpartnerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartners", dataIndex:"bpartnerCode", width:150 ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: []  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" , width:300,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["firstName","lastName","bpartnerCode","active"])
		.addChildrenTo("col2",["position","gender","birthdate"])
;
	}	
});
Ext.reg("net.nan21.dnet.module.bp.md.dc.Contact$Edit", net.nan21.dnet.module.bp.md.dc.Contact$Edit ); 
