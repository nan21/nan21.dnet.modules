   

Ext.define("net.nan21.dnet.module.md.base.tx.dc.TxDocSequence", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.base.tx.ds.model.TxDocSequenceDs",
	filterModel: "net.nan21.dnet.module.md.base.tx.ds.model.TxDocSequenceDsFilter",
	paramModel: "net.nan21.dnet.module.md.base.tx.ds.param.TxDocSequenceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.base.tx.dc.TxDocSequence$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.base.tx.dc.TxDocSequence$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addNumberField({ name:"firstNo", dataIndex:"firstNo",anchor:"-20"  })
		.addNumberField({ name:"lastNo", dataIndex:"lastNo",anchor:"-20"  })
		.addNumberField({ name:"nextNo", dataIndex:"nextNo",anchor:"-20"  })
		.addTextField({ name:"prefix", dataIndex:"prefix",anchor:"-20",maxLength:4  })
		.addTextField({ name:"suffix", dataIndex:"suffix",anchor:"-20",maxLength:4  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","active"])
		.addChildrenTo("col2",["prefix","suffix"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.base.tx.dc.TxDocSequence$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.base.tx.dc.TxDocSequence$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"prefix", dataIndex:"prefix",width:50,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:4,vtype:"alphanum"} })
		.addTextColumn({ name:"suffix", dataIndex:"suffix",width:50,editor:{xtype:"textfield", selectOnFocus:true ,maxLength:4,vtype:"alphanum"} })
		.addNumberColumn({ name:"firstNo", dataIndex:"firstNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"lastNo", dataIndex:"lastNo", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"incrementBy", dataIndex:"incrementBy", align:"right",editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addNumberColumn({ name:"nextNo", dataIndex:"nextNo", align:"right"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
