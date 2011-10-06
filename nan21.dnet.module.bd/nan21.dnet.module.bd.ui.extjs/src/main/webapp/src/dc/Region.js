   

Ext.define("net.nan21.dnet.module.bd.geo.dc.Region", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.RegionDs",
	paramModel: "net.nan21.dnet.module.bd.geo.ds.param.RegionDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.bd.geo.dc.Region$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.geo.dc.Region$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"iso", dataIndex:"iso",anchor:"-20",maxLength:32  })
		.addNumberField({ name:"countryId", dataIndex:"countryId",anchor:"-20"  })
		.addLov({ name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", 
			dataIndex:"countryCode",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"col2", layout:"anchor",width:210,labelWidth:0 })
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["countryCode","iso"])
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.bd.geo.dc.Region$List", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bd.geo.dc.Region$List",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"iso", dataIndex:"iso",width:100 })   	
		.addNumberColumn({ name:"countryId", dataIndex:"countryId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"countryCode", dataIndex:"countryCode",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })   	
	  ;		   
	}
});
 
 	
 	 
Ext.define("net.nan21.dnet.module.bd.geo.dc.Region$EditListContext", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.geo.dc.Region$EditListContext",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"} })
		.addTextColumn({ name:"iso", dataIndex:"iso",width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addNumberColumn({ name:"countryId", dataIndex:"countryId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
 	
 	 
Ext.define("net.nan21.dnet.module.bd.geo.dc.Region$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.geo.dc.Region$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"countryCode", xtype:"gridcolumn", dataIndex:"countryCode", width:150,editor:{xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum",retFieldMapping: [{lovField:"id", dsField: "countryId"} ]} })
		.addTextColumn({ name:"name", dataIndex:"name",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addTextColumn({ name:"code", dataIndex:"code",width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"} })
		.addTextColumn({ name:"iso", dataIndex:"iso",width:100,editor:{xtype:"textfield", selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},vtype:"alphanum"} })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:4000,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "4000"}} })
		.addNumberColumn({ name:"countryId", dataIndex:"countryId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Ext.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
 	

Ext.define("net.nan21.dnet.module.bd.geo.dc.Region$Edit", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.bd.geo.dc.Region$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,allowBlank:false,maxLength:32,vtype:"alphanum"  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:60,anchor:"-20"   })
		.addTextField({ name:"iso", dataIndex:"iso",anchor:"-20" ,maxLength:32,vtype:"alphanum"  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addNumberField({ name:"countryId", dataIndex:"countryId",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		.addLov({ name:"countryCode", xtype:"net.nan21.dnet.module.bd.geo.lovs.Countries", 
			dataIndex:"countryCode",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "countryId"} ]  })
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",anchor:"-20",noEdit:true, hideTrigger:true ,allowBlank:false})
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",anchor:"-20",noEdit:true  ,allowBlank:false,maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"anchor" , width:300,labelWidth:0 })     
		.addPanel({ name:"col2", layout:"anchor" , width:250,labelWidth:0 })     
		.addPanel({ name:"col3", layout:"anchor" , width:300,labelWidth:0 })     
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'}, autoScroll:true }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["countryCode","iso","active"])
		.addChildrenTo("col3",["notes"])
;
	}	
});
