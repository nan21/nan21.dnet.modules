   

Ext.define("net.nan21.dnet.module.bd.fin.dc.Tax", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.fin.ds.model.TaxDs",
	filterModel: "net.nan21.dnet.module.bd.fin.ds.model.TaxDsFilter",
	paramModel: "net.nan21.dnet.module.bd.fin.ds.param.TaxDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.fin.dc.Tax$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.fin.dc.Tax$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"summary", dataIndex:"summary",anchor:"-20"  })
		.addLov({ name:"category", xtype:"net.nan21.dnet.module.bd.fin.lovs.TaxCategories", dataIndex:"category",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]  })
		.addLov({ name:"parentTax", xtype:"net.nan21.dnet.module.bd.fin.lovs.Taxes", dataIndex:"parentTax",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "parentTaxId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","category","parentTax"])
		.addChildrenTo("col2",["summary","active"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.bd.fin.dc.Tax$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bd.fin.dc.Tax$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
		.addBooleanColumn({ name:"summary", dataIndex:"summary"})   	     
		.addNumberColumn({ name:"rate", dataIndex:"rate",decimals:2 })  
		.addTextColumn({ name:"category", dataIndex:"category",width:120 })   	
		.addTextColumn({ name:"parentTax", dataIndex:"parentTax",width:120 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addNumberColumn({ name:"categoryId", dataIndex:"categoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"parentTaxId", dataIndex:"parentTaxId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.bd.fin.dc.Tax$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.bd.fin.dc.Tax$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,maxLength:255  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"description", dataIndex:"description",height:60,anchor:"-20"   })
		.addNumberField({ name:"rate", dataIndex:"rate",anchor:"-20"  , style: "text-align:right;" })
		.addCheckbox({ name:"summary", dataIndex:"summary"  })
		.addLov({ name:"category", xtype:"net.nan21.dnet.module.bd.fin.lovs.TaxCategories", dataIndex:"category",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]  })
		.addLov({ name:"parentTax", xtype:"net.nan21.dnet.module.bd.fin.lovs.Taxes", dataIndex:"parentTax",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "parentTaxId"} ],filterFieldMapping: [{lovField:"summary",value: "true"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:350})     
		.addPanel({ name:"col2", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","category","description"])
		.addChildrenTo("col2",["summary","active","rate","parentTax"])
;
	}	
});
 	
