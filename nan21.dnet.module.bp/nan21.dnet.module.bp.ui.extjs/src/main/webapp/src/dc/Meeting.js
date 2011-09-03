   
Ext.ns('net.nan21.dnet.module.bp.calendar.dc');	 
net.nan21.dnet.module.bp.calendar.dc.Meeting = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Meeting" 		 
			,ds: new net.nan21.dnet.module.bp.calendar.ds.MyCalendarMeetingDs()			  
		});
	 	net.nan21.dnet.module.bp.calendar.dc.Meeting.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bp.calendar.dc'); 
net.nan21.dnet.module.bp.calendar.dc.Meeting$Filter = Ext.extend(dnet.base.AbstractDcvFilterForm, {
 
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"subject", dataIndex:"subject",anchor:"-20",maxLength:255  })
		.addDateField({ name:"startDate", dataIndex:"startDate",width:100 ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"endDate", dataIndex:"endDate",width:100 ,format:Ext.DATE_FORMAT })
		.addLov({ name:"statusName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusMeeting", dataIndex:"statusName",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priorityName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesMeeting", dataIndex:"priorityName",anchor:"-20",maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"bpartnerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartners", dataIndex:"bpartnerCode",anchor:"-20",maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "bpartnerId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col3", layout:"form",width:210,labelWidth:0 })
		.addPanel({ name:"col4", layout:"form", width:250,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
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
Ext.reg("net.nan21.dnet.module.bp.calendar.dc.Meeting$Filter", net.nan21.dnet.module.bp.calendar.dc.Meeting$Filter ); 
 	
Ext.ns('net.nan21.dnet.module.bp.calendar.dc');	 	 
net.nan21.dnet.module.bp.calendar.dc.Meeting$List = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"subject", dataIndex:"subject",width:200 })   	
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"bpartnerCode", dataIndex:"bpartnerCode",width:100 })   	
		.addTextColumn({ name:"location", dataIndex:"location",width:200 })   	
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200 })   	
		.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"statusName", dataIndex:"statusName", width:100 })   	
		.addNumberColumn({ name:"priorityId", dataIndex:"priorityId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"priorityName", dataIndex:"priorityName", width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bp.calendar.dc.Meeting$List", net.nan21.dnet.module.bp.calendar.dc.Meeting$List ); 
 	
Ext.ns('net.nan21.dnet.module.bp.calendar.dc');	 	 
net.nan21.dnet.module.bp.calendar.dc.Meeting$EditList = Ext.extend(dnet.base.AbstractDcvEditableGrid, {
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"subject", dataIndex:"subject",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Ext.DATETIME_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Ext.DATETIME_FORMAT ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"location", dataIndex:"location",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addTextColumn({ name:"statusName", dataIndex:"statusName",width:120,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70,editable:false ,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT,editable:false ,editor:{xtype:"datefield", selectOnFocus:true, format:Ext.DATE_FORMAT} })
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100,editable:false,editor:{xtype:"textfield" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"}} })
	  ;  		   
	}  
});
Ext.reg("net.nan21.dnet.module.bp.calendar.dc.Meeting$EditList", net.nan21.dnet.module.bp.calendar.dc.Meeting$EditList ); 
 	
Ext.ns('net.nan21.dnet.module.bp.calendar.dc');	 
net.nan21.dnet.module.bp.calendar.dc.Meeting$Edit = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"subject", dataIndex:"subject",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:100,anchor:"-20"   })
		.addDateTimeField({ name:"startDate", dataIndex:"startDate" ,allowBlank:false}) 

		.addDateTimeField({ name:"endDate", dataIndex:"endDate" ,allowBlank:false}) 

		.addNumberField({ name:"statusId", dataIndex:"statusId",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addLov({ name:"statusName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusMeeting", dataIndex:"statusName",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addNumberField({ name:"priorityId", dataIndex:"priorityId",anchor:"-20",disabled:true   , style: "text-align:right;" })
		.addLov({ name:"priorityName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesMeeting", dataIndex:"priorityName",anchor:"-20" ,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"},retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"bpartnerCode", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartners", dataIndex:"bpartnerCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "bpartnerId"} ]  })
		.addNumberField({ name:"id", dataIndex:"id",anchor:"-20",disabled:true  ,allowBlank:false , style: "text-align:right;" })
		.addDateField({ name:"createdAt", dataIndex:"createdAt",width:100,disabled:true  ,allowBlank:false})
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",width:100,disabled:true  ,allowBlank:false})
		.addTextField({ name:"createdBy", dataIndex:"createdBy",anchor:"-20",disabled:true  ,allowBlank:false,maxLength:32  })
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",anchor:"-20",disabled:true  ,allowBlank:false,maxLength:32  })
		.addTextField({ name:"location", dataIndex:"location",anchor:"-20" ,maxLength:4000  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:400,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" , width:400,labelWidth:0 })     
		.addPanel({ name:"row2", layout:"form" , width:800,labelWidth:0 })     
		.addPanel({ name:"main" , autoScroll:true })      	 
		.addPanel({ name:"row1", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} }) 
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
Ext.reg("net.nan21.dnet.module.bp.calendar.dc.Meeting$Edit", net.nan21.dnet.module.bp.calendar.dc.Meeting$Edit ); 