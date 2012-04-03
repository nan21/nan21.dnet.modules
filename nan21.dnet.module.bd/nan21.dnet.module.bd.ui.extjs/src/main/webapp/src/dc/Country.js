   

Ext.define("net.nan21.dnet.module.bd.geo.dc.Country", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.CountryDs",
	filterModel: "net.nan21.dnet.module.bd.geo.ds.model.CountryDsFilter",
	paramModel: "net.nan21.dnet.module.bd.geo.ds.param.CountryDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.geo.dc.Country$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"iso2", dataIndex:"iso2",anchor:"-20",maxLength:2,caseRestriction:"uppercase"  })
		.addTextField({ name:"iso3", dataIndex:"iso3",anchor:"-20",maxLength:3,caseRestriction:"uppercase"  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:220}) 
		.addPanel({ name:"col2", layout:"form", width:220}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["iso2","iso3","active"])
    	.addAuditFilter({})	
	}
}); 
 	
 	

Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$FilterPG", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
 	alias: "widget.net.nan21.dnet.module.bd.geo.dc.Country$FilterPG",
	_defineElements_: function () {	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",maxLength:32  })
		.addTextField({ name:"iso2", dataIndex:"iso2",maxLength:2,caseRestriction:"uppercase"  })
		.addTextField({ name:"iso3", dataIndex:"iso3",maxLength:3,caseRestriction:"uppercase"  })
		 
		
	}
	
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bd.geo.dc.Country$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"iso2", dataIndex:"iso2",width:50 })   	
		.addTextColumn({ name:"iso3", dataIndex:"iso3",width:50 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200 })   	
		.addBooleanColumn({ name:"hasRegions", dataIndex:"hasRegions"})   	     
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.geo.dc.Country$EditList",
	
	_bulkEditFields_ : ["active","notes"],
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"iso2", dataIndex:"iso2",width:50,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:2,caseRestriction:"uppercase",style: "text-transform:uppercase;",vtype:"alphanum"} })
		.addTextColumn({ name:"iso3", dataIndex:"iso3",width:50,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:3,caseRestriction:"uppercase",style: "text-transform:uppercase;",vtype:"alphanum"} })
		.addBooleanColumn({ name:"hasRegions", dataIndex:"hasRegions"})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.bd.geo.dc.Country$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32  })
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:40,anchor:"-20"   })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addCheckbox({ name:"hasRegions", dataIndex:"hasRegions"  })
		.addTextField({ name:"iso2", dataIndex:"iso2",anchor:"-20" ,maxLength:2,caseRestriction:"uppercase",vtype:"alphanum"  })
		.addTextField({ name:"iso3", dataIndex:"iso3",anchor:"-20" ,maxLength:3,caseRestriction:"uppercase",vtype:"alphanum"  })
		.addDateField({ name:"createdAt", dataIndex:"createdAt",anchor:"-20",noEdit:true, hideTrigger:true })
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",anchor:"-20",noEdit:true, hideTrigger:true })
		.addTextField({ name:"createdBy", dataIndex:"createdBy",anchor:"-20",noEdit:true  ,maxLength:32  })
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",anchor:"-20",noEdit:true  ,maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:350})     
		.addPanel({ name:"col2", layout:"form" , width:220})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
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
 	
 	

Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$EditPG", {
	extend: "dnet.core.dc.AbstractDcvEditPropGrid",
	alias: "widget.net.nan21.dnet.module.bd.geo.dc.Country$EditPG",
	
	_defineElements_: function () {	
		this._getBuilder_()	
		.addNumberField({ name:"id", dataIndex:"id",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextField({ name:"code", dataIndex:"code",editor:{ selectOnFocus:true,allowBlank:false ,maxLength:32} })
		.addTextField({ name:"name", dataIndex:"name",editor:{ selectOnFocus:true,allowBlank:false } })
		.addTextField({ name:"notes", dataIndex:"notes",editor:{ selectOnFocus:true } })
		.addBooleanField({ name:"active", dataIndex:"active"  })
		.addBooleanField({ name:"hasRegions", dataIndex:"hasRegions"  })
		.addTextField({ name:"iso2", dataIndex:"iso2",editor:{ selectOnFocus:true ,maxLength:2,caseRestriction:"uppercase",style: "text-transform:uppercase;",vtype:"alphanum"} })
		.addTextField({ name:"iso3", dataIndex:"iso3",editor:{ selectOnFocus:true ,maxLength:3,caseRestriction:"uppercase",style: "text-transform:uppercase;",vtype:"alphanum"} })
		.addDateField({ name:"createdAt", dataIndex:"createdAt",editor:{xtype:"textfield", noEdit:true} })
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",editor:{xtype:"textfield", noEdit:true} })
		.addTextField({ name:"createdBy", dataIndex:"createdBy",editor:{ noEdit:true}  })
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",editor:{ noEdit:true}  })
		;     
	}
	 	
});
 	
