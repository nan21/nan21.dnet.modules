   

Ext.define("net.nan21.dnet.module.md.activity.dc.Meeting", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.activity.ds.model.MyCalendarMeetingDs",
	filterModel: "net.nan21.dnet.module.md.activity.ds.model.MyCalendarMeetingDsFilter",
	paramModel: "net.nan21.dnet.module.md.activity.ds.param.MyCalendarMeetingDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	},
	initNewRecordInstance : function(o) {
		o.eventType = "meeting";
		return o;
	}
	
});



 	

Ext.define("net.nan21.dnet.module.md.activity.dc.Meeting$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.activity.dc.Meeting$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"subject", dataIndex:"subject",anchor:"-20",maxLength:255  })
		.addDateField({ name:"startDate", dataIndex:"startDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"endDate", dataIndex:"endDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addLov({ name:"statusName", xtype:"net.nan21.dnet.module.md.activity.lovs.CalendarEventStatusMeeting", dataIndex:"statusName",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priorityName", xtype:"net.nan21.dnet.module.md.activity.lovs.CalendarEventPrioritiesMeeting", dataIndex:"priorityName",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"bpartnerCode", xtype:"net.nan21.dnet.module.md.bp.lovs.BusinessPartnersCode", dataIndex:"bpartnerCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "bpartnerId"} ]  })
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
		.addChildrenTo("col4",["bpartnerCode"])
    		
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.activity.dc.Meeting$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.activity.dc.Meeting$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"subject", dataIndex:"subject",width:200 })   	
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"bpartnerCode", dataIndex:"bpartnerCode",width:100 })   	
		.addTextColumn({ name:"location", dataIndex:"location",width:200 })   	
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200 })   	
		.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"statusName", dataIndex:"statusName", width:100 })   	
		.addNumberColumn({ name:"priorityId", dataIndex:"priorityId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"priorityName", dataIndex:"priorityName", width:100 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.activity.dc.Meeting$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.activity.dc.Meeting$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"subject", dataIndex:"subject",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Dnet.DATETIME_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Dnet.DATETIME_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addTextColumn({ name:"location", dataIndex:"location",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true, align:"right",format:"0",width:70})
		.addTextColumn({ name:"statusName", dataIndex:"statusName",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
 	

Ext.define("net.nan21.dnet.module.md.activity.dc.Meeting$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.activity.dc.Meeting$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"subject", dataIndex:"subject" ,allowBlank:false,maxLength:255  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:100   })
		.addDateTimeField({ name:"startDate", dataIndex:"startDate" ,allowBlank:false})
		.addDateTimeField({ name:"endDate", dataIndex:"endDate" ,allowBlank:false})
		.addNumberField({ name:"statusId", dataIndex:"statusId",noEdit:true   , style: "text-align:right;" })
		.addLov({ name:"statusName", xtype:"net.nan21.dnet.module.md.activity.lovs.CalendarEventStatusMeeting", dataIndex:"statusName" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addNumberField({ name:"priorityId", dataIndex:"priorityId",noEdit:true   , style: "text-align:right;" })
		.addLov({ name:"priorityName", xtype:"net.nan21.dnet.module.md.activity.lovs.CalendarEventPrioritiesMeeting", dataIndex:"priorityName" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"bpartnerCode", xtype:"net.nan21.dnet.module.md.bp.lovs.BusinessPartnersCode", dataIndex:"bpartnerCode" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "bpartnerId"} ]  })
		.addNumberField({ name:"id", dataIndex:"id",noEdit:true   , style: "text-align:right;" })
		.addDateField({ name:"createdAt", dataIndex:"createdAt",noEdit:true, hideTrigger:true })
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",noEdit:true, hideTrigger:true })
		.addTextField({ name:"createdBy", dataIndex:"createdBy",noEdit:true  ,maxLength:32  })
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",noEdit:true  ,maxLength:32  })
		.addTextField({ name:"location", dataIndex:"location" ,maxLength:4000  })
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
		.addChildrenTo("col1",["subject","startDate","endDate","location"])
		.addChildrenTo("col2",["bpartnerCode","statusName","priorityName"])
		.addChildrenTo("row2",["notes"])
;
	}	
});
 	
