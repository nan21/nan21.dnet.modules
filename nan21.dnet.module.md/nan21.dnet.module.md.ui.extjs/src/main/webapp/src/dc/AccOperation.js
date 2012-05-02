   

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccOperation", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.AccOperationDs",
	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.AccOperationDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.fin.ds.param.AccOperationDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccOperation$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.fin.dc.AccOperation$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDateField({ name:"eventDate", dataIndex:"eventDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addTextField({ name:"dbAccount", dataIndex:"dbAccount",anchor:"-20",maxLength:255  })
		.addTextField({ name:"crAccount", dataIndex:"crAccount",anchor:"-20",maxLength:255  })
		.addNumberField({ name:"dbAmount", dataIndex:"dbAmount",anchor:"-20"  })
		.addNumberField({ name:"crAmount", dataIndex:"crAmount",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["dbAccount","crAccount"])
		.addChildrenTo("col2",["eventDate"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccOperation$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.dc.AccOperation$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addDateColumn({ name:"eventDate", dataIndex:"eventDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"dbAccount", dataIndex:"dbAccount",width:200 })   	
		.addTextColumn({ name:"crAccount", dataIndex:"crAccount",width:200 })   	
		.addNumberColumn({ name:"dbAmount", dataIndex:"dbAmount",decimals:2 })  
		.addNumberColumn({ name:"crAmount", dataIndex:"crAmount",decimals:2 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
