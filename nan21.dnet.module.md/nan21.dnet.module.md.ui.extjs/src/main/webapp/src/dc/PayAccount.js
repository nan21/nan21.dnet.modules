   

Ext.define("net.nan21.dnet.module.md.org.dc.PayAccount", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.org.ds.model.PayAccountDs",
	filterModel: "net.nan21.dnet.module.md.org.ds.model.PayAccountDsFilter",
	paramModel: "net.nan21.dnet.module.md.org.ds.param.PayAccountDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.org.dc.PayAccount$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.org.dc.PayAccount$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addCombo({ name:"type", xtype:"combo", dataIndex:"type",anchor:"-20",store:[ "bank", "cash"]  })
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","type"])
		.addChildrenTo("col2",["org","currency"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.org.dc.PayAccount$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.org.dc.PayAccount$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:60 })   	
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
		.addTextColumn({ name:"org", dataIndex:"org",width:100 })   	
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.md.org.dc.PayAccount$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.org.dc.PayAccount$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,maxLength:255  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"description", dataIndex:"description",height:80,anchor:"-20"   })
		.addCombo({ name:"type", xtype:"localcombo", dataIndex:"type",anchor:"-20" ,noUpdate:true ,store:[ "bank", "cash"]  })
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:250})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","description"])
		.addChildrenTo("col2",["org","type","currency","active"])
;
	}	
});
 	
