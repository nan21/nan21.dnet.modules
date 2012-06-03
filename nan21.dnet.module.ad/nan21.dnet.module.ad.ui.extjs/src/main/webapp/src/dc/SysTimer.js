   

Ext.define("net.nan21.dnet.module.ad.system.dc.SysTimer", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysTimerDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.SysTimerDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysTimerDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.system.dc.SysTimer$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.system.dc.SysTimer$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"jobCtx", xtype:"net.nan21.dnet.module.ad.system.lovs.SysJobCtx", dataIndex:"jobCtx",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "jobCtxId"} ]  })
		.addDateField({ name:"startTime_From", dataIndex:"startTime_From", emptyText:"From" })
		.addDateField({ name:"startTime_To", dataIndex:"startTime_To", emptyText:"To" })
		.addFieldContainer({name: "startTime", fieldLabel:"Start Time"}) 
		.addChildrenTo("startTime",["startTime_From", "startTime_To"]) 

		.addDateField({ name:"endTime_From", dataIndex:"endTime_From", emptyText:"From" })
		.addDateField({ name:"endTime_To", dataIndex:"endTime_To", emptyText:"To" })
		.addFieldContainer({name: "endTime", fieldLabel:"End Time"}) 
		.addChildrenTo("endTime",["endTime_From", "endTime_To"]) 

		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addCombo({ name:"type", xtype:"combo", dataIndex:"type",anchor:"-20",store:[ "simple", "cron"]  })
		.addCombo({ name:"repeatIntervalType", xtype:"combo", dataIndex:"repeatIntervalType",anchor:"-20",store:[ "seconds", "minutes", "hours"]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form", width:290}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["name","active"])
		.addChildrenTo("col2",["type","repeatIntervalType"])
		.addChildrenTo("col3",["startTime","endTime","jobCtx"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.ad.system.dc.SysTimer$CtxListJob", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.system.dc.SysTimer$CtxListJob",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name", width:150 })   	
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true,width:200 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"type", dataIndex:"type",width:60 })   	
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"endTime", dataIndex:"endTime", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"cronExpression", dataIndex:"cronExpression", hidden:true,width:200 })   	
		.addNumberColumn({ name:"repeatCount", dataIndex:"repeatCount", hidden:true })  
		.addNumberColumn({ name:"repeatInterval", dataIndex:"repeatInterval", hidden:true })  
		.addTextColumn({ name:"repeatIntervalType", dataIndex:"repeatIntervalType", hidden:true,width:60 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 		 
Ext.define("net.nan21.dnet.module.ad.system.dc.SysTimer$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.system.dc.SysTimer$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"jobCtx", dataIndex:"jobCtx",width:120 })   	
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true,width:200 })   	
		.addTextColumn({ name:"name", dataIndex:"name", width:150 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"type", dataIndex:"type",width:60 })   	
		.addDateColumn({ name:"startTime", dataIndex:"startTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"endTime", dataIndex:"endTime",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"cronExpression", dataIndex:"cronExpression", hidden:true,width:200 })   	
		.addNumberColumn({ name:"repeatCount", dataIndex:"repeatCount", hidden:true })  
		.addNumberColumn({ name:"repeatInterval", dataIndex:"repeatInterval", hidden:true })  
		.addTextColumn({ name:"repeatIntervalType", dataIndex:"repeatIntervalType", hidden:true,width:60 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.ad.system.dc.SysTimer$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.ad.system.dc.SysTimer$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,maxLength:255  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"description", dataIndex:"description",height:60,anchor:"-20"   })
		.addCombo({ name:"type", xtype:"localcombo", dataIndex:"type",anchor:"-20" ,store:[ "simple", "cron"]  })
		.addTextField({ name:"cronExpression", dataIndex:"cronExpression",anchor:"-20" ,maxLength:400  })
		.addNumberField({ name:"repeatCount", dataIndex:"repeatCount",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"repeatInterval", dataIndex:"repeatInterval",anchor:"-20"  , style: "text-align:right;" })
		.addCombo({ name:"repeatIntervalType", xtype:"localcombo", dataIndex:"repeatIntervalType",anchor:"-20" ,store:[ "seconds", "minutes", "hours"]  })
		.addLov({ name:"jobCtx", xtype:"net.nan21.dnet.module.ad.system.lovs.SysJobCtx", dataIndex:"jobCtx",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "jobCtxId"} ]  })
		.addDateTimeField({ name:"startTime", dataIndex:"startTime",anchor:"-20" })
		.addDateTimeField({ name:"endTime", dataIndex:"endTime",anchor:"-20" })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ])
		.addChildrenTo("col1",["jobCtx","name","description","type","active","cronExpression","repeatCount","repeatInterval","repeatIntervalType","startTime","endTime"])
;
	}	
});
 	
