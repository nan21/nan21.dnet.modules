   

Ext.define("net.nan21.dnet.module.ad.workflow.dc.WfDefTransition", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.WfDefTransitionDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.WfDefTransitionDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.WfDefTransitionDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.ad.workflow.dc.WfDefTransition$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.WfDefTransition$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"source", dataIndex:"source",anchor:"-20",maxLength:255  })
		.addTextField({ name:"target", dataIndex:"target",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"main", layout:"anchor", autoScroll:true,width:210}) 
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["source","target"])
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.ad.workflow.dc.WfDefTransition$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.ad.workflow.dc.WfDefTransition$CtxEditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"processId", dataIndex:"processId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"sourceId", dataIndex:"sourceId", hidden:true, align:"right",format:"0",width:70})
		.addTextColumn({ name:"source", dataIndex:"source",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addNumberColumn({ name:"targetId", dataIndex:"targetId", hidden:true, align:"right",format:"0",width:70})
		.addTextColumn({ name:"target", dataIndex:"target",width:120,editor:{xtype:"textfield", selectOnFocus:true,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy", hidden:true,width:100 })
	  ;  		   
	}  
});
