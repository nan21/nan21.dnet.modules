   

Ext.define("net.nan21.dnet.module.ad.report.dc.Report", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.report.ds.model.ReportDs",
	filterModel: "net.nan21.dnet.module.ad.report.ds.model.ReportDsFilter",
	paramModel: "net.nan21.dnet.module.ad.report.ds.param.ReportDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.ad.report.dc.Report$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.report.dc.Report$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addLov({ name:"reportServerName", xtype:"net.nan21.dnet.module.ad.report.lovs.ReportServers", dataIndex:"reportServerName",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "reportServerId"} ]  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"col2", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["reportServerName","active"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.report.dc.Report$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.report.dc.Report$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
		.addTextColumn({ name:"reportServerName", dataIndex:"reportServerName",width:120 })   	
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.ad.report.dc.Report$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.report.dc.Report$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addLov({ name:"reportServerName", xtype:"net.nan21.dnet.module.ad.report.lovs.ReportServers", dataIndex:"reportServerName",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "reportServerId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300})     
		.addPanel({ name:"col2", layout:"anchor" , width:400})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","reportServerName","active"])
		.addChildrenTo("col2",["notes"])
;
	}	
});
