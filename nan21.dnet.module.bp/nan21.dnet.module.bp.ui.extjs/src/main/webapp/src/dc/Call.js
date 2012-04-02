   

Ext.define("net.nan21.dnet.module.bp.calendar.dc.Call", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarCallDs",
	filterModel: "net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarCallDsFilter",
	paramModel: "net.nan21.dnet.module.bp.calendar.ds.param.MyCalendarCallDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	},
	initNewRecordInstance : function(o) {
		o.eventType = "call";
		return o;
	}
	
});



 	

Ext.define("net.nan21.dnet.module.bp.calendar.dc.Call$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bp.calendar.dc.Call$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"subject", dataIndex:"subject",anchor:"-20",maxLength:255  })
		.addDateField({ name:"startDate", dataIndex:"startDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"endDate", dataIndex:"endDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addLov({ name:"statusName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusCall", dataIndex:"statusName",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priorityName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesCall", dataIndex:"priorityName",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"bpartnerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartnersCode", dataIndex:"bpartnerCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "bpartnerId"} ]  })
		.addLov({ name:"contact", xtype:"net.nan21.dnet.module.bp.md.lovs.BpContacts", dataIndex:"contact",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "contactId"} ],filterFieldMapping: [{lovField:"bpartnerId", dsField: "bpartnerId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form",width:210}) 
		.addPanel({ name:"col4", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["subject"])
		.addChildrenTo("col2",["statusName","priorityName"])
		.addChildrenTo("col3",["startDate","endDate"])
		.addChildrenTo("col4",["bpartnerCode","contact"])
    		
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.bp.calendar.dc.Call$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bp.calendar.dc.Call$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"subject", dataIndex:"subject",width:200 })   	
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200 })   	
		.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"statusName", dataIndex:"statusName",width:120 })   	
		.addTextColumn({ name:"bpartnerCode", dataIndex:"bpartnerCode",width:100 })   	
		.addTextColumn({ name:"contact", dataIndex:"contact",width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.bp.calendar.dc.Call$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bp.calendar.dc.Call$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"subject", dataIndex:"subject",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Dnet.DATETIME_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Dnet.DATETIME_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true, align:"right",format:"0",width:70})
		.addTextColumn({ name:"statusName", dataIndex:"statusName",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.bp.calendar.dc.Call$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.bp.calendar.dc.Call$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"subject", dataIndex:"subject",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:100,anchor:"-20"   })
		.addDateTimeField({ name:"startDate", dataIndex:"startDate",anchor:"-20" ,allowBlank:false})
		.addDateTimeField({ name:"endDate", dataIndex:"endDate",anchor:"-20" ,allowBlank:false})
		.addNumberField({ name:"statusId", dataIndex:"statusId",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		.addLov({ name:"statusName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusCall", dataIndex:"statusName",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addNumberField({ name:"priorityId", dataIndex:"priorityId",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		.addLov({ name:"priorityName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesCall", dataIndex:"priorityName",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"bpartnerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartnersCode", dataIndex:"bpartnerCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "bpartnerId"} ]  })
		.addLov({ name:"contact", xtype:"net.nan21.dnet.module.bp.md.lovs.BpContacts", dataIndex:"contact",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "contactId"} ],filterFieldMapping: [{lovField:"bpartnerId", dsField: "bpartnerId"} ]  })
		.addNumberField({ name:"id", dataIndex:"id",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:400})     
		.addPanel({ name:"col2", layout:"form" , width:400})     
		.addPanel({ name:"row2", layout:"form" , width:800})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		.addPanel({ name:"row1",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["row1" ,"row2" ])
		.addChildrenTo("row1",["col1" ,"col2" ])
		.addChildrenTo("col1",["subject","startDate","endDate","statusName","priorityName"])
		.addChildrenTo("col2",["bpartnerCode","contact"])
		.addChildrenTo("row2",["notes"])
;
	}	
});
 	
