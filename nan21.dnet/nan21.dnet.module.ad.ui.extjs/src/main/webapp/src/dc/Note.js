   

Ext.define("net.nan21.dnet.module.ad.data.dc.Note", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.data.ds.model.NoteDs",
	filterModel: "net.nan21.dnet.module.ad.data.ds.model.NoteDsFilter",
	paramModel: "net.nan21.dnet.module.ad.data.ds.param.NoteDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.data.dc.Note$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.data.dc.Note$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"modifiedBy",_sharedLabel_:true, dataIndex:"modifiedBy",anchor:"-20",maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"anchor",width:210}) 
		.addPanel({ name:"main", layout:"hbox", layoutConfig: { align:'top' , pack:'start'} , autoScroll:true })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["modifiedBy"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.ad.data.dc.Note$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.ad.data.dc.Note$List",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"note", dataIndex:"note", hidden:true,width:200 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.ad.data.dc.Note$Edit", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.ad.data.dc.Note$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextArea({ name:"note", dataIndex:"note",height:100,anchor:"-20" ,allowBlank:false  })
		//containers
		.addPanel({ name:"main", layout:"anchor" , autoScroll:true,width:250, defaults:{
labelAlign:"top"}})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["note"])
;
	}	
});