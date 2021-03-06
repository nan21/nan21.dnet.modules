   

Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccount", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.org.ds.model.FinancialAccountDs",
	filterModel: "net.nan21.dnet.module.md.org.ds.model.FinancialAccountDsFilter",
	paramModel: "net.nan21.dnet.module.md.org.ds.param.FinancialAccountDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccount$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.org.dc.FinancialAccount$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addCombo({ name:"type", xtype:"combo", dataIndex:"type",anchor:"-20",store:[ "bank", "cash"]  })
		.addTextField({ name:"analiticSegment", dataIndex:"analiticSegment",anchor:"-20",maxLength:32  })
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"journal", xtype:"net.nan21.dnet.module.md.acc.lovs.AccJournals", dataIndex:"journal",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "journalId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name","type"])
		.addChildrenTo("col2",["org","journal"])
		.addChildrenTo("col3",["currency","analiticSegment","active"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccount$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.org.dc.FinancialAccount$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:120 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:60 })   	
		.addTextColumn({ name:"description", dataIndex:"description",width:200 })   	
		.addTextColumn({ name:"org", dataIndex:"org",width:100 })   	
		.addTextColumn({ name:"analiticSegment", dataIndex:"analiticSegment",width:100 })   	
		.addTextColumn({ name:"journal", dataIndex:"journal",width:120 })   	
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.md.org.dc.FinancialAccount$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.org.dc.FinancialAccount$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name" ,maxLength:255  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"description", dataIndex:"description",height:80   })
		.addCombo({ name:"type", xtype:"localcombo", dataIndex:"type" ,noUpdate:true ,store:[ "bank", "cash"]  })
		.addTextField({ name:"analiticSegment", dataIndex:"analiticSegment" ,maxLength:32  })
		.addLov({ name:"org", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"org" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "orgId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"journal", xtype:"net.nan21.dnet.module.md.acc.lovs.AccJournals", dataIndex:"journal" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "journalId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:250})     
		.addPanel({ name:"col3", layout:"form" , width:170})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["name","description"])
		.addChildrenTo("col2",["org","type","currency","journal"])
		.addChildrenTo("col3",["analiticSegment","active"])
;
	}	
});
 	
