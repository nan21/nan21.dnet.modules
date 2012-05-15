   

Ext.define("net.nan21.dnet.module.bd.tx.dc.FiscalYear", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.tx.ds.model.FiscalYearDs",
	filterModel: "net.nan21.dnet.module.bd.tx.ds.model.FiscalYearDsFilter",
	paramModel: "net.nan21.dnet.module.bd.tx.ds.param.FiscalYearDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.tx.dc.FiscalYear$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.tx.dc.FiscalYear$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addLov({ name:"calendar", xtype:"net.nan21.dnet.module.bd.org.lovs.Calendars", dataIndex:"calendar",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "calendarId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["code","name"])
		.addChildrenTo("col2",["calendar","active"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.bd.tx.dc.FiscalYear$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bd.tx.dc.FiscalYear$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Dnet.DATE_FORMAT})   	      	     
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"calendar", dataIndex:"calendar",width:120 })   	
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bd.tx.dc.FiscalYear$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.tx.dc.FiscalYear$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:32} })
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addLov({name:"calendar", xtype:"gridcolumn", dataIndex:"calendar",width:120,editor:{xtype:"net.nan21.dnet.module.bd.org.lovs.Calendars" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "calendarId"} ]} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.bd.tx.dc.FiscalYear$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.bd.tx.dc.FiscalYear$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextField({ name:"notes", dataIndex:"notes",anchor:"-20" ,maxLength:4000  })
		.addLov({ name:"calendar", xtype:"net.nan21.dnet.module.bd.org.lovs.Calendars", dataIndex:"calendar",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "calendarId"} ]  })
		.addDateField({ name:"startDate", dataIndex:"startDate",anchor:"-20" ,allowBlank:false})
		.addDateField({ name:"endDate", dataIndex:"endDate",anchor:"-20" ,allowBlank:false})
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
		.addChildrenTo("col2",["calendar","startDate","endDate","active"])
;
	}	
});
 	
