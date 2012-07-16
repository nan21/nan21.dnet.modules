   

Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.base.period.ds.model.FiscalPeriodDs",
	filterModel: "net.nan21.dnet.module.md.base.period.ds.model.FiscalPeriodDsFilter",
	paramModel: "net.nan21.dnet.module.md.base.period.ds.param.FiscalPeriodDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addCombo({ name:"type", xtype:"combo", dataIndex:"type",anchor:"-20",store:[ "month", "quarter", "half-year", "other"]  })
		.addLov({ name:"year", xtype:"net.nan21.dnet.module.md.base.period.lovs.FiscalYears", dataIndex:"year",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "yearId"} ]  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addBooleanField({ name:"posting", dataIndex:"posting",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form", width:170}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["code","name"])
		.addChildrenTo("col2",["year","type"])
		.addChildrenTo("col3",["posting","active"])
    	.addAuditFilter()	
	}
}); 
 	
 	

Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$FilterCtx", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
 	alias: "widget.net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$FilterCtx",
	_defineElements_: function () {	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",maxLength:32  })
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",maxLength:255  })
		.addCombo({ name:"type", xtype:"combo", dataIndex:"type",editor: { store:[ "month", "quarter", "half-year", "other"] }  })
		.addBooleanField({ name:"posting", dataIndex:"posting",anchor:"-20"  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		 
		
	}
	
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Dnet.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"year", dataIndex:"year",width:100 })   	
		.addTextColumn({ name:"type", dataIndex:"type",width:80 })   	
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
		.addBooleanColumn({ name:"posting", dataIndex:"posting"})   	     
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false } })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false ,maxLength:32} })
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addComboColumn({ name:"type", dataIndex:"type", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true 	, valueField: 'bv', displayField: 'tv' ,store:[ "month", "quarter", "half-year", "other"] , triggerAction:'all', forceSelection:true }})
		.addLov({name:"year", xtype:"gridcolumn", dataIndex:"year",width:100,editor:{xtype:"net.nan21.dnet.module.md.base.period.lovs.FiscalYears" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "yearId"} ]} })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"posting", dataIndex:"posting"})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false } })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false ,maxLength:32} })
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addComboColumn({ name:"type", dataIndex:"type", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true 	, valueField: 'bv', displayField: 'tv' ,store:[ "month", "quarter", "half-year", "other"] , triggerAction:'all', forceSelection:true }})
		.addBooleanColumn({ name:"posting", dataIndex:"posting"})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name" ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code" ,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addCheckbox({ name:"posting", dataIndex:"posting"  })
		.addTextField({ name:"notes", dataIndex:"notes" ,maxLength:4000  })
		.addDateField({ name:"startDate", dataIndex:"startDate" ,allowBlank:false})
		.addDateField({ name:"endDate", dataIndex:"endDate" ,allowBlank:false})
		.addCombo({ name:"type", xtype:"localcombo", dataIndex:"type" ,store:[ "month", "quarter", "half-year", "other"]  })
		.addLov({ name:"year", xtype:"net.nan21.dnet.module.md.base.period.lovs.FiscalYears", dataIndex:"year" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "yearId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"col3", layout:"form" , width:160})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["name","code","notes"])
		.addChildrenTo("col2",["year","startDate","endDate","type"])
		.addChildrenTo("col3",["posting","active"])
;
	}	
});
 	
