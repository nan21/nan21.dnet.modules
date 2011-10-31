   

Ext.define("net.nan21.dnet.module.pj.md.dc.ItemLink", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ItemLinkDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.ItemLinkDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.ItemLinkDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});



 	

Ext.define("net.nan21.dnet.module.pj.md.dc.ItemLink$Filter", {
	extend: "dnet.base.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.md.dc.ItemLink$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"sourceItem", dataIndex:"sourceItem",anchor:"-20",maxLength:255  })
		.addTextField({ name:"targetItem", dataIndex:"targetItem",anchor:"-20",maxLength:255  })
		.addTextField({ name:"linkType", dataIndex:"linkType",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"main", layout:"hbox", autoScroll:true, defaults:{labelAlign:"right",labelWidth:80,width:210 }})
	}
	,_linkElements_: function () {
		this._getBuilder_()
		this._elems_.get("main")["items"] = [
	    {layout:"anchor", border:false 
	      ,items:[ this._elems_.get("sourceItem")] }
	  ,	    {layout:"anchor", border:false 
	      ,items:[ this._elems_.get("targetItem")] }
	  ,	    {layout:"anchor", border:false 
	      ,items:[ this._elems_.get("linkType")] }
];
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.pj.md.dc.ItemLink$CtxList", {
	extend: "dnet.base.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.pj.md.dc.ItemLink$CtxList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {	
		this._getBuilder_()	
		.addNumberColumn({ name:"sourceItemId", dataIndex:"sourceItemId",format:"0",width:70 })  
		.addTextColumn({ name:"sourceItem", dataIndex:"sourceItem", width:150 })   	
		.addTextColumn({ name:"linkType", dataIndex:"linkType", width:150 })   	
		.addNumberColumn({ name:"targetItemId", dataIndex:"targetItemId",format:"0",width:70 })  
		.addTextColumn({ name:"targetItem", dataIndex:"targetItem", width:150 })   	
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Ext.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })   	
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })   	
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true,format:"0",width:70 })  
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.pj.md.dc.ItemLink$CtxCreate", {
	extend: "dnet.base.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.pj.md.dc.ItemLink$CtxCreate",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addNumberField({ name:"targetItemId", dataIndex:"targetItemId",anchor:"-20"  , style: "text-align:right;" })
		.addLov({ name:"linkType", xtype:"net.nan21.dnet.module.pj.base.lovs.ItemLinkTypes", dataIndex:"linkType",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "linkTypeId"} ]  })
		//containers
		.addPanel({ name:"main", layout:"anchor" , autoScroll:true,width:250})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["linkType","targetItemId"])
;
	}	
});
