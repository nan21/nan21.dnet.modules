   

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccDocLine", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.AccDocLineDs",
	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.AccDocLineDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.fin.ds.param.AccDocLineDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccDocLine$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.fin.dc.AccDocLine$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"dbAccount", dataIndex:"dbAccount",anchor:"-20",maxLength:255  })
		.addTextField({ name:"crAccount", dataIndex:"crAccount",anchor:"-20",maxLength:255  })
		.addNumberField({ name:"dbAmount", dataIndex:"dbAmount",anchor:"-20"  })
		.addNumberField({ name:"crAmount", dataIndex:"crAmount",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["dbAccount","crAccount"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccDocLine$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.dc.AccDocLine$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", hidden:true })  
		.addTextColumn({ name:"dbAccount", dataIndex:"dbAccount", width:90 })   	
		.addTextColumn({ name:"crAccount", dataIndex:"crAccount", width:90 })   	
		.addNumberColumn({ name:"dbAmount", dataIndex:"dbAmount",decimals:2, width:90 })  
		.addNumberColumn({ name:"crAmount", dataIndex:"crAmount",decimals:2, width:90 })  
		.addNumberColumn({ name:"accDocId", dataIndex:"accDocId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
