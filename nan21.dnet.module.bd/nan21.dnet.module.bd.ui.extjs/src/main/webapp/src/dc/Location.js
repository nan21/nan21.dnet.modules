   

Ext.define("net.nan21.dnet.module.bd.geo.dc.Location", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.LocationDs",
	filterModel: "net.nan21.dnet.module.bd.geo.ds.model.LocationDsFilter",
	paramModel: "net.nan21.dnet.module.bd.geo.ds.param.LocationDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 		 
Ext.define("net.nan21.dnet.module.bd.geo.dc.Location$ListCtx", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bd.geo.dc.Location$ListCtx",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"countryCode", dataIndex:"countryCode",width:100 })   	
		.addTextColumn({ name:"regionCode", dataIndex:"regionCode",width:100 })   	
		.addTextColumn({ name:"cityName", dataIndex:"cityName", width:120 })   	
		.addTextColumn({ name:"adress", dataIndex:"adress",width:200 })   	
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200 })   	
		.addBooleanColumn({ name:"billing", dataIndex:"billing", width:60})   	     
		.addBooleanColumn({ name:"mailing", dataIndex:"mailing", width:60})   	     
		.addBooleanColumn({ name:"shipping", dataIndex:"shipping", width:60})   	     
		.addBooleanColumn({ name:"active", dataIndex:"active", width:60})   	     
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"countryId", dataIndex:"countryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"regionId", dataIndex:"regionId", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.bd.geo.dc.Location$EditCtx", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.bd.geo.dc.Location$EditCtx",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  })
		.addLov({ name:"regionCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Regions", dataIndex:"regionCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "regionId"} ],filterFieldMapping: [{lovField:"countryId", dsField: "countryId"} ]  })
		.addTextField({ name:"cityName", dataIndex:"cityName",anchor:"-20" ,maxLength:255  })
		.addTextArea({ name:"adress", dataIndex:"adress",height:60,anchor:"-20" ,allowBlank:false  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addCheckbox({ name:"billing", dataIndex:"billing"  })
		.addCheckbox({ name:"mailing", dataIndex:"mailing"  })
		.addCheckbox({ name:"shipping", dataIndex:"shipping"  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:250})     
		.addPanel({ name:"col2", layout:"anchor" , width:350})     
		.addPanel({ name:"col3", layout:"anchor" , width:200})     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["countryCode","regionCode","cityName"])
		.addChildrenTo("col2",["adress","notes"])
		.addChildrenTo("col3",["billing","mailing","shipping","active"])
;
	}	
});
