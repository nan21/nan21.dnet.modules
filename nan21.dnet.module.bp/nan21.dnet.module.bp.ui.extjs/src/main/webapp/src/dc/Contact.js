   

Ext.define("net.nan21.dnet.module.bp.md.dc.Contact", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bp.md.ds.model.ContactDs",
	paramModel: "net.nan21.dnet.module.bp.md.ds.param.ContactDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.bp.md.dc.Contact$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bp.md.dc.Contact$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20",maxLength:255  })
		.addLov({ name:"bpartnerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartners", dataIndex:"bpartnerCode",anchor:"-20",maxLength:32,retFieldMapping: []  })
		.addCombo({ name:"gender", xtype:"combo", dataIndex:"gender",anchor:"-20",store:[ "male", "female"]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:220,labelWidth:0 })
		.addPanel({ name:"col2", layout:"anchor", width:250,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["firstName","lastName"])
		.addChildrenTo("col2",["bpartnerCode","gender"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.bp.md.dc.Contact$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bp.md.dc.Contact$List",
	
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
 
 	
 	 
Ext.define("net.nan21.dnet.module.bp.md.dc.Contact$CtxEditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bp.md.dc.Contact$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"firstName", dataIndex:"firstName", width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"lastName", dataIndex:"lastName", width:120,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"gender", dataIndex:"gender", hidden:true,width:60,editor:{xtype:"textfield", selectOnFocus:true,maxLength:16,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "16"}} })
		.addDateColumn({ name:"birthdate", dataIndex:"birthdate", hidden:true,format:Ext.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT}})
		.addTextColumn({ name:"position", dataIndex:"position",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
 	

Ext.define("net.nan21.dnet.module.bp.md.dc.Contact$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.bp.md.dc.Contact$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"firstName", dataIndex:"firstName",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"lastName", dataIndex:"lastName",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addCombo({ name:"gender", xtype:"localcombo", dataIndex:"gender",anchor:"-20" ,store:[ "male", "female"]  })
		.addTextField({ name:"position", dataIndex:"position",anchor:"-20" ,maxLength:255  })
		.addDateField({ name:"birthdate", dataIndex:"birthdate",anchor:"-20" })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addLov({ name:"bpartnerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartners", dataIndex:"bpartnerCode",anchor:"-20" ,maxLength:32,retFieldMapping: []  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"anchor" , width:250,labelWidth:0 })     
		.addPanel({ name:"col3", layout:"anchor" , width:300,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["firstName","lastName","active"])
		.addChildrenTo("col2",["gender","birthdate"])
		.addChildrenTo("col3",["bpartnerCode","position"])
;
	}	
});
