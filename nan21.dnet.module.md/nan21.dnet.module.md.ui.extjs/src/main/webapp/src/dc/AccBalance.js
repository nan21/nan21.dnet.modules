   

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccBalance", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.AccBalanceDs",
	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.AccBalanceDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.fin.ds.param.AccBalanceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccBalance$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.fin.dc.AccBalance$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"account", dataIndex:"account",anchor:"-20",maxLength:255  })
		.addNumberField({ name:"amount", dataIndex:"amount",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["account"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.AccBalance$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.dc.AccBalance$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"account", dataIndex:"account",width:200 })   	
		.addNumberColumn({ name:"amount", dataIndex:"amount",decimals:2 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
