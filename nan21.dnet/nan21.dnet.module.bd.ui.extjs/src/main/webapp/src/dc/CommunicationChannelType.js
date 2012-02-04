   

Ext.define("net.nan21.dnet.module.bd.contact.dc.CommunicationChannelType", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelTypeDs",
	filterModel: "net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelTypeDsFilter",
	paramModel: "net.nan21.dnet.module.bd.contact.ds.param.CommunicationChannelTypeDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bd.contact.dc.CommunicationChannelType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bd.contact.dc.CommunicationChannelType$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"name",_sharedLabel_:true, dataIndex:"name",anchor:"-20",maxLength:255  })
		.addCombo({ name:"type", xtype:"combo", dataIndex:"type",anchor:"-20",store:[ "email", "messenger", "phone", "url", "other"]  })
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
	      ,items:[ this._elems_.get("type")] }
	  ,	    {layout:"anchor", border:false 
	      ,items:[ this._elems_.get("active")] }
];
    	.addAuditFilter({})	
	}
}); 
 	
 	 
Ext.define("net.nan21.dnet.module.bd.contact.dc.CommunicationChannelType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.bd.contact.dc.CommunicationChannelType$EditList",
	
	 _noImport_: false
	,_noExport_: false
	,_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name",width:120,editor:{xtype:"textfield", selectOnFocus:true,allowBlank:false,maxLength:255,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "255"}} })
		.addComboColumn({ name:"type", dataIndex:"type", trueText:Dnet.translate("msg", "bool_true"), falseText:Dnet.translate("msg", "bool_false"),editor: {xtype: 'combo', mode: 'local', selectOnFocus:true, valueField: 'bv', displayField: 'tv' ,store:[ "email", "messenger", "phone", "url", "other"] , triggerAction:'all', forceSelection:true }})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"description", dataIndex:"description",width:200,editor:{xtype:"textfield", selectOnFocus:true,maxLength:400,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "400"}} })
	  	.addDefaults()
	  ;  		   
	}  
});
