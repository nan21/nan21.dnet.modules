   

Ext.define("net.nan21.dnet.module.md.acc.dc.Account", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.acc.ds.model.AccountDs",
	filterModel: "net.nan21.dnet.module.md.acc.ds.model.AccountDsFilter",
	paramModel: "net.nan21.dnet.module.md.acc.ds.param.AccountDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.acc.dc.Account$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.acc.dc.Account$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"accSchema", xtype:"net.nan21.dnet.module.md.acc.lovs.AccSchemas", dataIndex:"accSchema",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]  })
		.addCombo({ name:"type", xtype:"combo", dataIndex:"type",anchor:"-20",store:[ "D", "C", "N"]  })
		.addBooleanField({ name:"summary", dataIndex:"summary",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["accSchema","type"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.acc.dc.Account$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.acc.dc.Account$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"accSchema", dataIndex:"accSchema",width:100 })   	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:60 })   	
		.addBooleanColumn({ name:"summary", dataIndex:"summary"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.acc.dc.Account$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.acc.dc.Account$EditList",
	
	_bulkEditFields_ : ["accSchema","type","summary","active"],
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accSchema", xtype:"gridcolumn", dataIndex:"accSchema",width:100,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.AccSchemas" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "accSchemaId"} ]} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addComboColumn({ name:"type", dataIndex:"type", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true 	, valueField: 'bv', displayField: 'tv' ,store:[ "D", "C", "N"] , triggerAction:'all', forceSelection:true }})
		.addBooleanColumn({ name:"summary", dataIndex:"summary"})
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.md.acc.dc.Account$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.acc.dc.Account$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name" ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code" ,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextField({ name:"notes", dataIndex:"notes" ,maxLength:4000  })
		.addTextField({ name:"accSchema", dataIndex:"accSchema" ,maxLength:32  })
		.addCombo({ name:"type", xtype:"localcombo", dataIndex:"type" ,store:[ "D", "C", "N"]  })
		.addCheckbox({ name:"summary", dataIndex:"summary"  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","active","notes"])
		.addChildrenTo("col2",["accSchema","type","summary"])
;
	}	
});
 	
