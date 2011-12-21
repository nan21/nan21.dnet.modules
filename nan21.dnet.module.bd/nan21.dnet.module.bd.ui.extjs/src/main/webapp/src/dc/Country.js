   

Ext.define("net.nan21.dnet.module.bd.geo.dc.Country", {
	extend: "dnet.base.AbstractDc",
 
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
	extend: "dnet.base.AbstractDcvFilterForm",
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
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"col4", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col4"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["iso2","iso3"])
		.addChildrenTo("col4",["active"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bd.geo.dc.Country$List",
	
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
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
 	
 	 
Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.geo.dc.Country$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"iso2", dataIndex:"iso2",width:50,editor:{xtype:"textfield", selectOnFocus:true,maxLength:2,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "2"},caseRestriction:"uppercase",style: "text-transform:uppercase;",vtype:"alphanum"} })
		.addTextColumn({ name:"iso3", dataIndex:"iso3",width:50,editor:{xtype:"textfield", selectOnFocus:true,maxLength:3,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "3"},caseRestriction:"uppercase",style: "text-transform:uppercase;",vtype:"alphanum"} })
		.addBooleanColumn({ name:"hasRegions", dataIndex:"hasRegions"})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
 	

Ext.define("net.nan21.dnet.module.bd.geo.dc.Country$Edit", {
	extend: "dnet.base.AbstractDcvForm",
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
		.addPanel({ name:"col1", layout:"anchor" , width:350})     
		.addPanel({ name:"col2", layout:"anchor" , width:220})     
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
