   

Ext.define("net.nan21.dnet.module.bd.uom.dc.Uom", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.uom.ds.model.UomDs",
	filterModel: "net.nan21.dnet.module.bd.uom.ds.model.UomDsFilter",
	paramModel: "net.nan21.dnet.module.bd.uom.ds.param.UomDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.uom.dc.Uom$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.uom.dc.Uom$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.bd.uom.lovs.UomType", dataIndex:"type",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["type","active"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.bd.uom.dc.Uom$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bd.uom.dc.Uom$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:120 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
		.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.uom.dc.Uom$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.uom.dc.Uom$EditList",
	
	_bulkEditFields_ : ["type","active","notes"],
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addLov({name:"type", xtype:"gridcolumn", dataIndex:"type",width:120,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UomType" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.bd.uom.dc.Uom$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.bd.uom.dc.Uom$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addLov({ name:"type", xtype:"net.nan21.dnet.module.bd.uom.lovs.UomType", dataIndex:"type",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "typeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:350})     
		.addPanel({ name:"col2", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","type"])
		.addChildrenTo("col2",["notes","active"])
;
	}	
});
 	
