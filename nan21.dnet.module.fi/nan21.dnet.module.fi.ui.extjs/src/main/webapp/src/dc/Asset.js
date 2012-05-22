   

Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.fi.asset.ds.model.AssetDs",
	filterModel: "net.nan21.dnet.module.fi.asset.ds.model.AssetDsFilter",
	paramModel: "net.nan21.dnet.module.fi.asset.ds.param.AssetDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.fi.asset.dc.Asset$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		.addTextField({ name:"org", dataIndex:"org",anchor:"-20",maxLength:32  })
		.addTextField({ name:"category", dataIndex:"category",anchor:"-20",maxLength:32  })
		.addTextField({ name:"productCode", dataIndex:"productCode",anchor:"-20",maxLength:32  })
		.addTextField({ name:"productName", dataIndex:"productName",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["name","code"])
		.addChildrenTo("col2",["org","category"])
		.addChildrenTo("col3",["productCode","productName"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.fi.asset.dc.Asset$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"name", dataIndex:"name",width:200 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addBooleanColumn({ name:"active", dataIndex:"active"})   	     
		.addTextColumn({ name:"notes", dataIndex:"notes",width:200 })   	
		.addTextColumn({ name:"org", dataIndex:"org",width:100 })   	
		.addTextColumn({ name:"category", dataIndex:"category",width:100 })   	
		.addTextColumn({ name:"productCode", dataIndex:"productCode",width:100 })   	
		.addTextColumn({ name:"productName", dataIndex:"productName",width:200 })   	
		.addNumberColumn({ name:"initialValue", dataIndex:"initialValue",decimals:2 })  
		.addNumberColumn({ name:"residualValue", dataIndex:"residualValue",decimals:2 })  
		.addNumberColumn({ name:"depreciationAmount", dataIndex:"depreciationAmount",decimals:2 })  
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"categoryId", dataIndex:"categoryId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.fi.asset.dc.Asset$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.fi.asset.dc.Asset$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name", dataIndex:"name",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addCheckbox({ name:"active", dataIndex:"active"  })
		.addTextField({ name:"notes", dataIndex:"notes",anchor:"-20" ,maxLength:4000  })
		.addTextField({ name:"org", dataIndex:"org",anchor:"-20" ,maxLength:32  })
		.addTextField({ name:"category", dataIndex:"category",anchor:"-20" ,maxLength:32  })
		.addTextField({ name:"productCode", dataIndex:"productCode",anchor:"-20" ,maxLength:32  })
		.addTextField({ name:"productName", dataIndex:"productName",anchor:"-20" ,maxLength:255  })
		.addNumberField({ name:"initialValue", dataIndex:"initialValue",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"residualValue", dataIndex:"residualValue",anchor:"-20"  , style: "text-align:right;" })
		.addNumberField({ name:"depreciationAmount", dataIndex:"depreciationAmount",anchor:"-20"  , style: "text-align:right;" })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["name","code","active","notes"])
		.addChildrenTo("col2",["org","category","productCode","productName","initialValue","residualValue","depreciationAmount"])
;
	}	
});
 	
