   
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 
net.nan21.dnet.module.bd.geo.dc.Location = Ext.extend(dnet.base.AbstractDc, {
	constructor: function(config) {
		config = config || {};
		Ext.apply(config, {
			 dcName:"Location" 		 
			,ds: new net.nan21.dnet.module.bd.geo.ds.LocationDs()			  
		});
	 	net.nan21.dnet.module.bd.geo.dc.Location.superclass.constructor.call(this, config);
	}	 
}); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 	 
net.nan21.dnet.module.bd.geo.dc.Location$ListCtx = Ext.extend(dnet.base.AbstractDcvGrid, {
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addNumberColumn({ name:"countryId", dataIndex:"countryId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"countryCode", dataIndex:"countryCode",width:100 })   	
		.addNumberColumn({ name:"regionId", dataIndex:"regionId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"regionCode", dataIndex:"regionCode",width:100 })   	
		.addTextColumn({ name:"cityName", dataIndex:"cityName",width:200 })   	
		.addTextColumn({ name:"adress", dataIndex:"adress",width:200 })   	
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true,width:200 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addBooleanColumn({ name:"billing", dataIndex:"billing"})   	     
		.addBooleanColumn({ name:"mailing", dataIndex:"mailing"})   	     
		.addBooleanColumn({ name:"shipping", dataIndex:"shipping"})   	     
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Location$ListCtx", net.nan21.dnet.module.bd.geo.dc.Location$ListCtx ); 
 	
Ext.ns('net.nan21.dnet.module.bd.geo.dc');	 
net.nan21.dnet.module.bd.geo.dc.Location$EditCtx = Ext.extend(dnet.base.AbstractDcvForm, {
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", dataIndex:"countryCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  })
		.addLov({ name:"regionCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Regions", dataIndex:"regionCode",anchor:"-20" ,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "regionId"} ]  })
		.addTextField({ name:"cityName", dataIndex:"cityName",anchor:"-20" ,maxLength:255  })
		.addTextArea({ name:"adress", dataIndex:"adress",height:60,anchor:"-20"   })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addCheckbox({ name:"billing", dataIndex:"billing"  })
		.addCheckbox({ name:"mailing", dataIndex:"mailing"  })
		.addCheckbox({ name:"shipping", dataIndex:"shipping"  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:250,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"form" , width:350,labelWidth:0 })     
		.addPanel({ name:"col3", layout:"form" , width:200,labelWidth:0 })     
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
Ext.reg("net.nan21.dnet.module.bd.geo.dc.Location$EditCtx", net.nan21.dnet.module.bd.geo.dc.Location$EditCtx ); 
