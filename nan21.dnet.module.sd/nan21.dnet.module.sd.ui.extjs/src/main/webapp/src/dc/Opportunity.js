   

Ext.define("net.nan21.dnet.module.sd.opportunity.dc.Opportunity", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityDs",
	filterModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityDsFilter",
	paramModel: "net.nan21.dnet.module.sd.opportunity.ds.param.OpportunityDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.sd.opportunity.dc.Opportunity$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sd.opportunity.dc.Opportunity$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addLov({ name:"account", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartnersName", dataIndex:"account",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accountId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.sd.opportunity.lovs.OpportunityStatuses", dataIndex:"status",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priority", xtype:"net.nan21.dnet.module.sd.opportunity.lovs.OpportunityPriorities", dataIndex:"priority",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"salesStage", xtype:"net.nan21.dnet.module.sd.opportunity.lovs.OpportunityStages", dataIndex:"salesStage",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "salesStageId"} ]  })
		.addLov({ name:"leadSource", xtype:"net.nan21.dnet.module.sd.opportunity.lovs.OpportunitySources", dataIndex:"leadSource",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "leadSourceId"} ]  })
		.addLov({ name:"resultReason", xtype:"net.nan21.dnet.module.sd.opportunity.lovs.OpportunityResultReasons", dataIndex:"resultReason",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "resultReasonId"} ]  })
		.addLov({ name:"assignedTo", xtype:"net.nan21.dnet.module.ad.usr.lovs.Assignables", dataIndex:"assignedTo",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assignedToId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor", width:250}) 
		.addPanel({ name:"col2", layout:"anchor", width:250}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","account","assignedTo","status","priority"])
		.addChildrenTo("col2",["salesStage","leadSource","resultReason"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.sd.opportunity.dc.Opportunity$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sd.opportunity.dc.Opportunity$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name", width:150 })   	
		.addTextColumn({ name:"account", dataIndex:"account",width:200 })   	
		.addTextColumn({ name:"salesStage", dataIndex:"salesStage",width:120 })   	
		.addDateColumn({ name:"closeDate", dataIndex:"closeDate",format:Dnet.DATE_FORMAT})   	      	     
		.addNumberColumn({ name:"amount", dataIndex:"amount",decimals:2 })  
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addNumberColumn({ name:"probability", dataIndex:"probability",decimals:2 })  
		.addTextColumn({ name:"assignedTo", dataIndex:"assignedTo",width:120 })   	
		.addTextColumn({ name:"status", dataIndex:"status",width:120 })   	
		.addTextColumn({ name:"priority", dataIndex:"priority",width:120 })   	
		.addTextColumn({ name:"leadSource", dataIndex:"leadSource", hidden:true,width:120 })   	
		.addTextColumn({ name:"campaign", dataIndex:"campaign", hidden:true,width:200 })   	
		.addTextColumn({ name:"resultReason", dataIndex:"resultReason", hidden:true,width:120 })   	
		.addTextColumn({ name:"resultNote", dataIndex:"resultNote", hidden:true,width:200 })   	
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"assignedToId", dataIndex:"assignedToId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"accountId", dataIndex:"accountId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.sd.opportunity.dc.Opportunity$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.sd.opportunity.dc.Opportunity$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextArea({ name:"description", dataIndex:"description",height:80,anchor:"-20"   })
		.addLov({ name:"account", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartnersName", dataIndex:"account",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accountId"} ]  })
		.addLov({ name:"status", xtype:"net.nan21.dnet.module.sd.opportunity.lovs.OpportunityStatuses", dataIndex:"status",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priority", xtype:"net.nan21.dnet.module.sd.opportunity.lovs.OpportunityPriorities", dataIndex:"priority",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"salesStage", xtype:"net.nan21.dnet.module.sd.opportunity.lovs.OpportunityStages", dataIndex:"salesStage",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "salesStageId"} ]  })
		.addLov({ name:"leadSource", xtype:"net.nan21.dnet.module.sd.opportunity.lovs.OpportunitySources", dataIndex:"leadSource",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "leadSourceId"} ]  })
		.addTextField({ name:"campaign", dataIndex:"campaign",anchor:"-20" ,maxLength:255  })
		.addLov({ name:"resultReason", xtype:"net.nan21.dnet.module.sd.opportunity.lovs.OpportunityResultReasons", dataIndex:"resultReason",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "resultReasonId"} ]  })
		.addTextArea({ name:"resultNote", dataIndex:"resultNote",height:80,anchor:"-20"   })
		.addDateField({ name:"closeDate", dataIndex:"closeDate",anchor:"-20" ,allowBlank:false})
		.addNumberField({ name:"probability", dataIndex:"probability",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"amount", dataIndex:"amount",anchor:"-20" ,allowBlank:false , style: "text-align:right;" })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"assignedTo", xtype:"net.nan21.dnet.module.ad.usr.lovs.Assignables", dataIndex:"assignedTo",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "assignedToId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:350, defaults:{
labelAlign:"right",labelWidth:110}})     
		.addPanel({ name:"col2", layout:"anchor" , width:300})     
		.addPanel({ name:"col3", layout:"anchor" , width:400, defaults:{
labelAlign:"top"}})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["name","account","salesStage","amount","currency","closeDate"])
		.addChildrenTo("col2",["assignedTo","status","priority","leadSource","campaign","probability","resultReason"])
		.addChildrenTo("col3",["description","resultNote"])
;
	}	
});
