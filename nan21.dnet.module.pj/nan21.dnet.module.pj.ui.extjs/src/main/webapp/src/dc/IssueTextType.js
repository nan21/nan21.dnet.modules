   

Ext.define("net.nan21.dnet.module.pj.base.dc.IssueTextType", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssueTextTypeDs",
	filterModel: "net.nan21.dnet.module.pj.base.ds.model.IssueTextTypeDsFilter",
	paramModel: "net.nan21.dnet.module.pj.base.ds.param.IssueTextTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.pj.base.dc.IssueTextType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.pj.base.dc.IssueTextType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addBooleanField({ name:"active",_sharedLabel_:true, dataIndex:"active",anchor:"-20"  })
		//containers
		.addPanel({ name:"main", layout:"hbox", autoScroll:true, defaults:{labelAlign:"right",labelWidth:80,width:210 }})
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		this._elems_.get("main")["items"] = [
	    {layout:"anchor", border:false 
	      ,items:[ this._elems_.get("name")] }
	  ,	    {layout:"anchor", border:false 
	      ,items:[ this._elems_.get("active")] }
];
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.pj.base.dc.IssueTextType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.pj.base.dc.IssueTextType$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name", width:150,editor:{xtype:"textfield", selectOnFocus:true } })
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true } })
		.addBooleanColumn({ name:"active", dataIndex:"active"})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
