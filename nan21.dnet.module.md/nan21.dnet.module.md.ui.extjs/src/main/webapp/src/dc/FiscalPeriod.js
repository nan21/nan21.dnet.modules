   

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
		.addLov({ name:"year", xtype:"net.nan21.dnet.module.md.base.period.lovs.FiscalYears", dataIndex:"year",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "yearId"} ]  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["code","name"])
		.addChildrenTo("col2",["year","active"])
    	.addAuditFilter()	
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
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
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
		.addLov({name:"year", xtype:"gridcolumn", dataIndex:"year",width:100,editor:{xtype:"net.nan21.dnet.module.md.base.period.lovs.FiscalYears" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "yearId"} ]} })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
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
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextField({ name:"notes", dataIndex:"notes",anchor:"-20" ,maxLength:4000  })
		.addDateField({ name:"startDate", dataIndex:"startDate",anchor:"-20" ,allowBlank:false})
		.addDateField({ name:"endDate", dataIndex:"endDate",anchor:"-20" ,allowBlank:false})
		.addLov({ name:"year", xtype:"net.nan21.dnet.module.md.base.period.lovs.FiscalYears", dataIndex:"year",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "yearId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","notes"])
		.addChildrenTo("col2",["year","startDate","endDate","active"])
;
	}	
});
 	
